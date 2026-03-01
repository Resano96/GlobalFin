# UI B2B - GlobalFin

Dashboard JavaFX para empleados de GlobalFin. Interfaz de usuario empresarial con enfoque en atajos de teclado, manejo de grandes conjuntos de datos y accesibilidad.

## 🚀 Inicio rápido

### Compilar el proyecto

```bash
cd ui-b2b
mvn clean package -DskipTests
```

### Ejecutar la aplicación

```bash
mvn javafx:run
```

Se abrirá una ventana con el dashboard (1280x720).

### Ejecutar tests

```bash
# Todos los tests de UI
mvn test

# Tests específicos
mvn test -Dtest=LoginViewModelTest

# Con reporte de cobertura
mvn test jacoco:report
```

## 📐 Arquitectura: MVVM

La aplicación sigue el patrón **Model-View-ViewModel** para separar la lógica de presentación de la UI:

- **View (FXML)**: Define la estructura visual
- **ViewModel**: Propiedades observables que la Vista vincula
- **Model**: Lógica de negocio, servicios HTTP, caché local
- **Service**: Comunicación con backend (HTTP, REST)

```
┌─────────────┐
│    FXML     │  ← Define estructura (botones, campos, tablas)
└──────┬──────┘
       │ binds
┌──────▼──────────────┐
│   ViewModel        │  ← Propiedades observables (email, password, loading)
│  + validaciones    │
└──────┬──────────────┘
       │ uses
┌──────▼──────┐
│   Service   │  ← HTTP client, comunicación con backend
└──────┬──────┘
       │
       ▼
┌─────────────────┐
│     Backend     │
│  /api/auth...   │
└─────────────────┘
```

## 🔐 Componentes implementados (Sprint 1)

### LoginViewModel

```java
// Propiedades observables para UI binding
SimpleStringProperty email
SimpleStringProperty password
SimpleBooleanProperty isLoading
SimpleBooleanProperty loginButtonDisabled
SimpleStringProperty errorMessage
ObjectProperty<AuthenticatedUser> authenticatedUser
```

**Validaciones automáticas**:
- Email y password no vacías → habilita botón
- Limpieza y reseteo de formulario

### HttpAuthService

Servicio HTTP que comunica con `POST /api/auth/login`:
- Manejo asincrónico con `CompletableFuture`
- Sanitización JSON (contra inyección)
- Timeouts (10 segundos)
- Manejo de errores (401, 500, timeout)

## 📁 Estructura de carpetas

```
src/main/java/com/globalfin/ui/b2b/
├── controller/              # Controladores FXML
│   └── LoginController      # (próxima fase)
├── model/
│   └── LoginViewModel.java  # ✅ Implementado
├── service/
│   └── HttpAuthService.java # ✅ Implementado
└── view/                    # Componentes custom

src/main/resources/
├── fxml/
│   └── login.fxml          # UI definition (próxima fase)
└── css/
    └── styles.css          # Estilos globales

src/test/java/com/globalfin/ui/b2b/
├── model/
│   └── LoginViewModelTest.java  # ✅ Implementado (12 tests)
```

## 🧪 Tests de Login

### LoginViewModelTest (12 casos)

```bash
✓ Debe iniciar con formulario vacío
✓ Debe habilitar botón cuando email y contraseña están completos
✓ Debe deshabilitar botón si email está vacío
✓ Debe deshabilitar botón si contraseña está vacía
✓ Debe limpiar formulario al resetear
✓ Debe establecer mensaje de error
✓ Debe limpiar mensaje de error
✓ Debe almacenar usuario autenticado
✓ Debe habilitar loading state
✓ Debe validar email con espacios en blanco
```

## 📋 Próximos pasos (Sprint 2)

1. **LoginController.java**: Conecta ViewModel con FXML
2. **login.fxml**: Estructura visual del formulario de login
3. **DashboardViewController**: Dashboard principal con tablas virtuales
4. **Keyboard navigation**: Atajos (Alt+T, Alt+R, etc.)
5. **Accesibilidad**: ADA compliance, lectores de pantalla

## 🔒 Notas de seguridad

- ✅ **No almacenar contraseña**: Solo usa token en memoria/sesión
- ✅ **Validación en servidor**: Las restricciones de negocio viven en backend
- ✅ **Sanitización**: JSON está escapado en `HttpAuthService`
- ✅ **Timeout de red**: 10 segundos para requests
- ⏳ **TODO**: Implementar refresh token rotation

## 📚 Recursos

- [JavaFX MVVM Pattern](https://www.oracle.com/technical-resources/articles/javase/javafxmvc.html)
- [TestFX Documentation](https://github.com/TestFX/TestFX)
- [JavaFX Accessibility](https://docs.oracle.com/en/java/javase/21/docs/api/javafx.graphics/javafx/scene/AccessibleRole.html)

---

**Sprint 1 Status**: ✅ ViewModel + Service + Tests
