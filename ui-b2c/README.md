# UI B2C - GlobalFin

Aplicación móvil Flutter para clientes de GlobalFin. Interfaz accesible, responsiva y con microinteracciones suaves.

## 🚀 Inicio rápido

### Requisitos

- Flutter SDK (3.13.x o superior)
- Dart SDK (incluido con Flutter)
- Android Studio o Xcode (para emuladores)

### Obtener dependencias

```bash
cd ui-b2c
flutter pub get
```

### Ejecutar en desarrollo

```bash
# En emulador/dispositivo conectado
flutter run

# En modo profile (rendimiento)
flutter run --profile

# En modo release (optimizado)
flutter run --release
```

### Tests

```bash
# Tests unitarios y de widgets
flutter test --coverage

# Test específico
flutter test test/screens_test.dart

# Coverage report
open coverage/index.html
```

### Build

```bash
# APK para Android
flutter build apk --release

# Apple App Bundle (iOS)
flutter build ios --release --no-codesign

# Ubicación de artefactos
# APK: build/app/outputs/flutter-apk/app-release.apk
# IPA: build/ios/iphoneos/Runner.app
```

## 🎨 Diseño

### Principios de UX

1. **Mobile-first**: Pantalla pequeña es el diseño base
2. **Accesibilidad**: Contraste ≥ 4.5:1, tamaños táctiles ≥ 44x44dp
3. **Microinteracciones**: Feedback visual inmediato
4. **Validación**: Errores claros sin exponer detalles internos

### Paleta de colores

| Uso | Color | Hex |
|-----|-------|-----|
| Primary | Azul bankario | #003DA5 |
| Success | Verde | #2ECC71 |
| Error | Rojo | #E74C3C |
| Warning | Naranja | #F39C12 |

## 📁 Estructura de carpetas

```
lib/
├── main.dart                    # ✅ App principal + SplashScreen
├── screens/
│   ├── login_screen.dart       # ✅ Pantalla de login con validación
│   ├── dashboard_screen.dart   # ⏳ Dashboard de cliente
│   ├── transactions_screen.dart # ⏳ Historial de movimientos
│   └── profile_screen.dart      # ⏳ Perfil de usuario
├── widgets/
│   ├── custom_buttons.dart      # ⏳ Botones reutilizables
│   ├── input_fields.dart        # ⏳ Campos de entrada custom
│   └── cards.dart               # ⏳ Tarjetas de información
├── models/
│   ├── user_model.dart          # ⏳ Usuario / DTO
│   ├── transaction_model.dart   # ⏳ Transacción / DTO
│   └── api_response.dart        # ⏳ Respuesta de API genérica
├── services/
│   ├── auth_service.dart        # ⏳ HTTP client para autenticación
│   └── storage_service.dart     # ⏳ Almacenamiento seguro (tokens)
├── providers/
│   ├── auth_provider.dart       # ⏳ Estado global de autenticación
│   └── user_provider.dart       # ⏳ Estado global de usuario

test/
├── smoke_test.dart              # ✅ Test básico de compilación
└── screens_test.dart            # ✅ Test de pantalla de login (mock)
```

## 🔐 Componentes implementados (Sprint 1)

### SplashScreen

- Duración: 2 segundos
- Logo + texto de bienvenida
- Transición automática a LoginScreen

### LoginScreen

**Campos**:
- Email (validación: formato, requerido)
- Contraseña (mín. 6 caracteres)
- Toggle mostrar/ocultar contraseña

**Validaciones**:
- Email: regex `[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}`
- Contraseña: mínimo 6 caracteres
- Botón deshabilitado hasta validar

**Accesibilidad**:
- Tamaños de touch ≥ 44x44dp
- Contraste de colores WCAG AA
- Labels asociados a campos
- Feedback de carga (spinner)

**Seguridad**:
- Contraseña oculta por defecto
- No muestra credenciales en error
- TODO: Almacenar token en Secure Storage (flutter_secure_storage)

## 🧪 Tests

### smoke_test.dart

```dart
✓ Aplicacion debe compilar sin errores
✓ MyApp debería ser inicializable
```

### screens_test.dart

```dart
✓ Debe mostrar título y campos de login
✓ Email field debe aceptar entrada
✓ Login button debe existir
```

## 📊 Dependencias principales

| Paquete | Versión | Uso |
|---------|---------|-----|
| http | ^1.1.0 | HTTP client para API REST |
| provider | ^6.0.0 | Gestión de estado |
| flutter_secure_storage | ^9.0.0 | Almacenamiento seguro de tokens |
| intl | ^0.19.0 | Internacionalización y formato |

## 📋 Próximos pasos (Sprint 2)

1. **AuthService**: Integración real con backend
2. **StorageService**: Guardar/recuperar tokens con Secure Storage
3. **AuthProvider**: Estado global (login/logout)
4. **DashboardScreen**: Pantalla principal con KPIs
5. **TransactionsScreen**: Historial con filtros
6. **ProfileScreen**: Datos de usuario

## 🔒 Notas de seguridad

- ✅ **Validación de entrada**: Todos los campos validados localmente
- ✅ **No exponer errores internos**: Mensajes genéricos al usuario
- ✅ **Contraseña oculta**: Mostrar/ocultar toggle
- ⏳ **Secure Storage**: Guardar token de forma encriptada
- ⏳ **Certificate Pinning**: Para HTTPS en producción
- ⏳ **Fingerprint/Face ID**: Autenticación biométrica

## 🌐 Internacionalización

**TODO**: Soportar idiomas adicionales usando `intl`

```dart
// Ejemplo (futuro)
AppLocalizations.of(context)!.loginTitle
→ "Bienvenido" (es) / "Welcome" (en)
```

## 📚 Recursos

- [Flutter Best Practices](https://flutter.dev/docs/testing/best-practices)
- [Material Design 3 Flutter](https://m3.material.io/develop/flutter)
- [Flutter Accessibility](https://flutter.dev/docs/development/accessibility-and-localization/accessibility)
- [Provider Package](https://pub.dev/packages/provider)

---

**Sprint 1 Status**: ✅ SplashScreen + LoginScreen + Tests básicos
