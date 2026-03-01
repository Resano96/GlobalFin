# Seguridad en GlobalFin

Documento de consideraciones y buenas prácticas de seguridad para el proyecto GlobalFin.

## 🔐 Principios fundamentales

1. **Default Secure**: La seguridad no es una característica adicional, es el fundamento
2. **Defense in Depth**: Múltiples capas de validación
3. **Assume Breach**: Cualquier dato del cliente puede estar comprometido
4. **Zero Trust**: No confiar en nada que venga del cliente

---

## 🛡️ Autenticación (Login)

### Flujo seguro actual (Sprint 1)

```
Cliente                Backend
  │                       │
  ├─ Validación local ────┤ (UX, opcional)
  │  (email format)       │
  │                       │
  ├─ POST /api/auth/login │
  │  {email, password} ───>
  │                       │
  │                  [Validación 1]
  │                  Jakarta Bean Validation
  │                  - Email: no nulo, formato
  │                  - Password: no nulo, min 6 chars
  │                       │
  │                  [Búsqueda]
  │                  SELECT * FROM users
  │                  WHERE email = ?
  │                       │
  │                  [Comparación]
  │                  password == bcrypt(input)
  │                       │
  │    <─── {token, role} ←─ [Generación JWT]
  │  (200 OK)                 exp: 1 hora
  │                           refreshToken: rotativo
  │
  ├─ Almacenar token en
  │  Secure Storage
  │  (Android Keystore / iOS Keychain)
```

### ⚠️ Sprint 1 (Desarrollo)

| Control | Estado | Nota |
|---------|--------|------|
| Validación entrada | ✅ | Jakarta Bean Validation |
| Contraseñas hasheadas | ❌ | Usuarios en memoria (solo dev) |
| Rate limiting | ❌ | TODO: Implementar |
| HTTPS | ❌ | Solo HTTP en dev |
| JWT | ❌ | Mock en Base64 (TODO: real JWT) |
| Refresh token | ❌ | TODO: Rotación |
| 2FA / MFA | ❌ | TODO: Sprint futuro |

### 🚀 Producción (Roadmap)

```yaml
Sprint 2:
  - bcrypt para contraseñas (library: spring-security-crypto)
  - JWT real con firma RS256
  - Refresh token rotation
  - Rate limiting (10 intentos/15 min)
  - CORS configurado para dominios seguros
  
Sprint 3:
  - HTTPS obligatorio
  - Certificate pinning (móvil)
  - 2FA con TOTP (Google Authenticator)
  - Audit logging de intentos de acceso
  
Sprint 4+:
  - OAuth2 / OpenID Connect
  - Passwordless authentication
  - Biometric on mobile
```

---

## 🔒 Validación de datos

### Regla de oro
```
                     [CLIENTE]
                         │
                    Validación UX
                   (mejora usabilidad)
                         │
              [Red = Potencial atacante]
              ◄─────────┼────────►
              ║         │         ║
              ║         ▼         ║
              ║    [BACKEND]      ║
              ║         │         ║
              ║  Validación REAL  ║
              ║  (seguridad!)     ║
              │
              └─ Rechazar si falla
```

### Capas de validación en Login

1. **Cliente (UI B2C/B2B)**
   - Email: formato regex
   - Password: mínimo 6 caracteres
   - **Propósito**: UX (feedback inmediato)
   - **No confiar**: El cliente puede estar comprometido

2. **Controlador (Backend)**
   ```java
   @Valid @RequestBody LoginRequest request
   // Validación: Jakarta Bean Validation
   // @Email, @NotBlank, @Size
   ```

3. **Servicio (Backend)**
   ```java
   // Validación de lógica de negocio
   - Usuario existe?
   - Contraseña válida?
   - Cuenta activa?
   - No bloqueada por rate limiting?
   ```

---

## 🚨 Ataques comunes (y cómo prevenimos)

### 1. SQL Injection
**Ataque**: `email: "' OR '1'='1" --`

**Defensa**:
```java
// ❌ MAL (vulnerable)
String query = "SELECT * FROM users WHERE email = '" + email + "'";

// ✅ BIEN (seguro)
@Query("SELECT * FROM users WHERE email = ?1")
User findByEmail(String email);
```

**Status**: ✅ Usando Spring Data JPA (queries parametrizadas)

---

### 2. Inyección de JSON
**Ataque**: Input con caracteres especiales (`\n`, `"`, etc.)

**Defensa**:
```java
// En HttpAuthService (UI)
private String sanitizeJson(String value) {
    return value
        .replace("\\", "\\\\")  // Escape backslash
        .replace("\"", "\\\"")  // Escape quotes
        .replace("\n", "\\n");  // Escape newlines
}
```

**Status**: ✅ Implementado en UI B2B

---

### 3. Contraseña en tránsito (MITM)
**Ataque**: Interceptar request HTTP sin cifrar

**Defensa**:
```yaml
Sprint 1: HTTP (solo desarrollo local)
Sprint 2: HTTPS forzado en todas las conexiones
Sprint 3: Certificate pinning (móvil)
```

**Status**: ⏳ TODO: HTTPS en producción

---

### 4. Brute Force
**Ataque**: Millones de intentos `admin@globalfin.com:pass1`, `pass2`, ...

**Defensa**:
```yaml
Rate limiting:
  - 10 intentos fallidos por IP → bloquear 15 minutos
  - Alertar si >50 intentos en 1 hora
  - Log de todos los intentos
```

**Status**: ⏳ TODO: Implementar en Sprint 2

---

### 5. Contraseña débil
**Ataque**: Usuario usa `123456` como contraseña

**Defensa**:
```java
// Validación en Backend (no en UI)
if (password.length() < 12) {
    throw new ValidationException("Min 12 caracteres");
}

// Verificar contra lista de conocidas
if (isCommonPassword(password)) {
    throw new ValidationException("Contraseña demasiado común");
}

// En producción: zxcvbn library
```

**Status**: ⏳ TODO: Implementar políticas en Sprint 2

---

### 6. Session Hijacking
**Ataque**: Robar token y usarlo desde otra IP

**Defensa**:
```java
// En token:
{
  "sub": "admin@globalfin.com",
  "exp": 1709461800,      // Expira en 1 hora
  "iat": 1709375400,      // Emitido hace X
  "ip": "192.168.1.100",  // IP de emisión (opcional)
  "user_agent": "..."     // User agent (opcional)
}

// En backend:
if (request.getIP() != token.getIP()) {
    throw new UnauthorizedException("IP mismatch");
}
```

**Status**: ⏳ TODO: Implementar en JWT real

---

### 7. Token expirado no validado
**Ataque**: Cliente reutiliza token viejo

**Defensa**:
```java
// En AuthInterceptor (Backend)
if (token.isExpired()) {
    throw new UnauthorizedException("Token expirado");
}

// En UI (cliente)
if (tokenExpiryTime < System.currentTimeMillis()) {
    // Redirigir a login
    navigateToLogin();
}
```

**Status**: ⏳ TODO: Validación en middleware

---

### 8. Contraseña en logs
**Ataque**: Logs contienen `/api/auth/login` con JSON `{password: "123456"}`

**Defensa**:
```java
// ❌ MAL
logger.info("Login request: " + request);

// ✅ BIEN
logger.info("Login request for email: {}", 
    maskSensitiveData(request.getEmail()));
```

**Status**: ⏳ TODO: Implementar en Logback

---

## 🔑 Gestión de tokens

### JWT en producción (futuro)

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.
[Header]

eyJzdWIiOiJhZG1pbkBnbG9iYWxmaW4uY29tIiwi...
[Payload]
  {
    "sub": "admin@globalfin.com",
    "role": "ADMIN",
    "exp": 1709461800,         # ← CRÍTICO: 1 hora
    "iat": 1709375400,
    "iss": "globalfin-backend"
  }

hqWGSaFQmbt86wZVmg32LNHO5r...
[Signature: HMAC-SHA256 con clave privada]
```

### Access Token vs Refresh Token

```
[Cliente: /api/auth/login]
           ↓
[Servidor genera]
  - Access Token (1 hora) - short-lived
  - Refresh Token (30 días) - long-lived, rotativo

[Cliente hace request]
  Authorization: Bearer <access-token>
           ↓
[Servidor valida]
  - If válido: procesar request ✅
  - If expirado: → 401 Unauthorized

[Cliente re-authentica]
  POST /api/auth/refresh
  {refresh_token: "..."}
           ↓
[Servidor]
  - Valida refresh token
  - Si válido: genera nuevo access token (rotativo)
  - Retorna nuevo pair
```

**Status**: ⏳ TODO: Implementar en Sprint 2

---

## 🛡️ Almacenamiento de credenciales en cliente

### Móvil (Flutter)

```dart
// ❌ MAL
SharedPreferences.getInstance()
  .setString('token', token);  // Plain text

// ✅ BIEN
final storage = FlutterSecureStorage();
await storage.write(
  key: 'auth_token',
  value: token,  // Cifrado en Android Keystore
);
```

**Status**: ✅ UI B2C implementa Flutter Secure Storage

### Desktop (JavaFX)

```java
// ❌ MAL
Properties props = new Properties();
props.setProperty("token", token);  // Plain text

// ✅ BIEN
// Usar Java Credential Storage (Windows DPAPI / macOS Keychain)
// O librería: keepass4j, Credentials API
```

**Status**: ⏳ TODO: Implementar en UI B2B Sprint 2

---

## 📋 Checklist de seguridad (por sprint)

### Sprint 1 ✅
- [x] Validación de entrada (Jakarta Bean Validation)
- [x] Separación UI/Backend (sin lógica de negocio en cliente)
- [x] DTOs inmutables
- [ ] HTTPS (solo local HTTP ok)
- [ ] Rate limiting (ok para demo)

### Sprint 2 ⏳
- [ ] bcrypt para contraseñas
- [ ] JWT real con RS256
- [ ] HTTPS forzado
- [ ] Rate limiting (10/15min)
- [ ] CORS seguro
- [ ] Refresh token rotation
- [ ] Validación en cliente y servidor

### Sprint 3+
- [ ] Certificate pinning
- [ ] 2FA / TOTP
- [ ] Audit logging
- [ ] OAuth2 / OpenID
- [ ] Passwordless auth
- [ ] Biometric (móvil)

---

## 📚 Referencias

- [OWASP Top 10 2023](https://owasp.org/www-project-top-ten/)
- [Spring Security Documentation](https://spring.io/projects/spring-security)
- [Flutter Security Best Practices](https://flutter.dev/docs/development/data-and-backend/serialization)
- [JWT.io](https://jwt.io)
- [zxcvbn (Password strength)](https://github.com/dropbox/zxcvbn)

---

**Última actualización**: Sprint 1 (Marzo 2026)
**Responsable**: Equipo de Seguridad + DevOps
