# Backend - GlobalFin

Servicios REST para GlobalFin construidos con **Spring Boot 3.2** y **Java 21**.

## 🚀 Inicio rápido

### Compilar el proyecto

```bash
cd backend
mvn clean package -DskipTests
```

### Ejecutar la aplicación

```bash
mvn spring-boot:run
```

La API será accesible en `http://localhost:8080/api`

### Ejecutar tests

```bash
# Todos los tests
mvn test

# Tests específicos
mvn test -Dtest=AuthenticationServiceTest

# Con reporte de cobertura
mvn test jacoco:report
```

### Análisis de calidad

```bash
# SpotBugs (detección de bugs)
mvn spotbugs:check

# Checkstyle (estilo de código)
mvn checkstyle:check

# Todos los análisis
mvn clean verify
```

## 📊 Estructura del código

```
src/main/java/com/globalfin/
├── controller/          # Endpoints REST
│   └── AuthenticationController    # POST /api/auth/login
├── service/             # Lógica de negocio
│   └── AuthenticationService       # Validación de credenciales
├── dto/                 # Data Transfer Objects
│   ├── LoginRequest     # Entrada de login
│   └── LoginResponse    # Respuesta exitosa
├── exception/           # Excepciones personalizadas
│   └── AuthenticationException
└── GlobalFinApplication # Punto de entrada

src/test/java/com/globalfin/
├── service/
│   └── AuthenticationServiceTest           # Tests de lógica
└── controller/
    └── AuthenticationControllerIntegrationTest # Tests de API REST
```

## 🔐 Endpoints

### Login

```bash
POST /api/auth/login

Content-Type: application/json

{
  "email": "admin@globalfin.com",
  "password": "admin123"
}
```

**Respuesta (200 OK)**:
```json
{
  "token": "YWRtaW5AZ2xvYmFsZmluLmNvbToxNzA5Mzc1MDAwMDQw",
  "refreshToken": "550e8400-e29b-41d4-a716-446655440000",
  "email": "admin@globalfin.com",
  "role": "ADMIN",
  "username": "admin"
}
```

**Respuesta (401 Unauthorized)**:
```json
{
  "message": "Credenciales inválidas"
}
```

## 🧪 Usuarios de prueba

⚠️ **SOLO PARA DESARROLLO**

| Email | Contraseña | Rol |
|-------|-----------|-----|
| admin@globalfin.com | admin123 | ADMIN |
| empleado@globalfin.com | emp123 | EMPLOYEE |
| cliente@globalfin.com | cli123 | USER |

## 📈 Métricas

- **Tests**: 12 casos de prueba
- **Cobertura objetivo**: 80%
- **Linters**: SpotBugs + Checkstyle

## 🔄 CI/CD

Integración automática en GitHub Actions (`.github/workflows/backend-ci.yml`):

1. Build con Maven
2. Ejecución de tests
3. Análisis SpotBugs (bugs potenciales)
4. Análisis Checkstyle (estilo de código)
5. Generación de reporte de cobertura

---

**Sprint 1 Focus**: Estructura de autenticación lista para ser completada.
