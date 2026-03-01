# Arquitectura de GlobalFin

## 🏗️ Estructura General

GlobalFin se organiza en tres módulos principales independientes:

```
GlobalFin/
├── backend/           # Servicios REST (Spring Boot)
├── ui-b2b/            # Dashboard interno (JavaFX)
├── ui-b2c/            # App móvil (Flutter)
└── docs/              # Documentación
```

## 🔐 Principios de Arquitectura

### 1. Separación de responsabilidades
- **Backend**: Lógica de negocio, validaciones, seguridad, persistencia
- **Frontend (UI)**: Solo visualización y recopilación de datos
- **Nunca** hay reglas de negocio en la interfaz

### 2. Seguridad en capas
```
[Validación UI]
        ↓
[Backend - Autenticación]
        ↓
[Backend - Autorización]
        ↓
[Backend - Validación de reglas de negocio]
        ↓
[Base de datos - Integridad]
```

### 3. Comunicación cliente-servidor
- REST API con DTOs inmutables
- Todas las validaciones en backend
- No confiamos en datos del cliente

## 📦 Backend (Spring Boot)

### Estructura esperada
```
src/main/java/com/globalfin/
├── entity/          # Entidades JPA
├── dto/             # Data Transfer Objects
├── repository/      # Acceso a datos
├── service/         # Lógica de negocio
├── controller/      # Endpoints REST
├── config/          # Configuración (Security, CORS, etc.)
├── exception/       # Manejo de excepciones
└── util/            # Utilidades
```

### Tecnologías
- **Java 21** con Spring Boot 3.2
- **Spring Data JPA** para persistencia
- **Spring Security** para autenticación/autorización
- **H2 Database** (desarrollo) / otras en producción

### Testing
- JUnit 5 + Mockito
- Cobertura mínima: 80%
- SpotBugs + Checkstyle para calidad

## 🖥️ UI B2B (JavaFX)

### Principios
- **Keyboard-first**: Todos los flujos deben funcionar sin ratón
- **Grandes datasets**: Tablas virtualizadas, paginación
- **Accesibilidad**: Contraste ≥ 4.5:1, navegación lógica

### Estructura esperada
```
src/main/java/com/globalfin/ui/b2b/
├── controller/      # Controladores FXML
├── view/            # Componentes custom
├── model/           # ViewModels (MVVM)
├── service/         # Servicios que hablan con backend
├── util/            # Utilidades UI
└── resources/       # FXML, CSS
```

### Arquitectura recomendada: MVVM
- **View** (FXML): Define la estructura
- **ViewModel**: Gestiona datos de vista (ObservableProperty)
- **Model**: Caché local / transformación de DTOs backend

## 📱 UI B2C (Flutter)

### Principios
- **Mobile-first**: Diseño pensado para pequeñas pantallas
- **Microinteracciones**: Feedback visual inmediato
- **Accesibilidad**: Semantics widget, contraste, tamaños táctiles

### Estructura esperada
```
lib/
├── main.dart                    # Punto de entrada
├── screens/                     # Pantallas principales
├── widgets/                     # Componentes reutilizables
├── models/                      # DTOs de backend
├── services/                    # API client, storage local
├── providers/                   # Estado global (Provider/Bloc)
└── utils/                       # Utilidades (validación, formato)
```

### Arquitectura recomendada: MVU / Provider
- **Screen / Widget**: Presentación
- **Provider/Model**: Gestión de estado
- **Service**: Comunicación con backend

## 🔒 Flujos de Seguridad

### Autenticación (todos los módulos)
1. Usuario ingresa credenciales en UI
2. Backend valida en `/api/auth/login`
3. Backend retorna JWT + refresh token
4. UI almacena JWT en storage seguro (keychain/Secure Storage)
5. UI envía JWT en header `Authorization: Bearer <token>` en próximas requests

### Autorización
1. Backend verifica JWT en cada request
2. Backend valida rol del usuario
3. Backend valida que el usuario tenga acceso a los datos solicitados
4. Si falla, el backend retorna 403 Forbidden

### Validación de datos
- **Cliente**: Validación de formato (UX)
- **Servidor**: Validación de negocio (seguridad)

> ⚠️ NUNCA confiar en datos del cliente. Todo es un potencial ataque.

## 🧪 Testing Strategy

### Backend
- Unit tests: servicios, repositorios
- Integration tests: endpoints REST con MockMvc
- Security tests: validaciones de autorización
- Meta: 80%+ cobertura

### UI B2B (JavaFX)
- Unit tests: ViewModels, lógica
- UI tests: TestFX para interacciones
- Meta: 60%+ cobertura

### UI B2C (Flutter)
- Unit tests: modelos, servicios
- Widget tests: comportamiento de widgets
- Integration tests: flujos completos
- Meta: 70%+ cobertura

## 📊 CI/CD Pipeline

Todos los módulos tienen workflows independientes en GitHub Actions:

1. **Build**: Compila el código
2. **Test**: Ejecuta tests automatizados
3. **Analysis**: SpotBugs, Checkstyle, Lint
4. **Coverage**: Genera reportes de cobertura
5. **Artifact**: Empaqueta artefactos (JAR, APK, iOS)

**Regla de oro**: No se merge a `main` sin pasar todos los checks.

## 🗂️ Convenciones de código

### Java
- Naming: `camelCase` para variables/métodos, `PascalCase` para clases
- Documentación: JavaDoc en clases y métodos públicos
- Formateador: Spotless (checkstyle.xml)

### Dart/Flutter
- Naming: `camelCase` para variables, `PascalCase` para clases
- Comentarios: Documentación en métodos principales
- Formateador: `dart format`

### Git
- Commits: `feat:`, `fix:`, `docs:`, `test:`, `refactor:` (Conventional Commits)
- Branches: `feature/`, `bugfix/`, `hotfix/`, `release/`
- PRs: Descripción clara, mínimo 1 aprobación antes de merge

## 📈 Próximos pasos

1. ✅ Estructura de carpetas inicializada
2. ✅ Pipelines CI/CD configurados
3. ⏳ Validar wireframes en Figma con PO
4. ⏳ Iniciar desarrollo de primera pantalla (login)
5. ⏳ Agregar tests de humo (smoke tests)
