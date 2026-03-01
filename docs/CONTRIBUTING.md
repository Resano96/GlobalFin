# Guía de Contribución - GlobalFin

## 🚀 Antes de empezar

1. Fork o crea una rama desde `main`
2. Crea un branch descriptivo: `feature/login-b2b` o `fix/validation-bug`
3. Haz commit frecuentes con mensajes claros
4. Abre un PR para revisión antes de mergear a `main`

## 📝 Convenciones de Commits

Usamos **Conventional Commits** para mantener el historial legible:

```
<type>(<scope>): <subject>

<body>

<footer>
```

### Tipos válidos
- `feat`: Nueva funcionalidad
- `fix`: Corrección de bug
- `docs`: Cambios en documentación
- `style`: Cambios de formato (no lógica)
- `refactor`: Refactorización de código
- `perf`: Mejoras de rendimiento
- `test`: Agregar o actualizar tests
- `chore`: Cambios de configuración/dependencias
- `ci`: Cambios en CI/CD

### Ejemplos
```
feat(backend): agregar endpoint para listar transacciones
fix(ui-b2b): solucionar bug en validación de email
docs(readme): actualizar instrucciones de setup
test(backend): agregar tests para TransactionService
```

## 🌳 Estrategia de branches

```
main (release)
  ├── hotfix/critical-bug
  ├── release/1.0.0
  └── develop (staging)
      ├── feature/login
      ├── feature/transactions-list
      ├── refactor/ui-components
      └── bugfix/validation-issue
```

### Reglas
- **main**: Solo releases estables (producción)
- **develop**: Integración de features (pre-release)
- **feature/_**: Nuevas funcionalidades
- **bugfix/_**: Correcciones no críticas
- **hotfix/_**: Correcciones críticas en producción (rama desde main)

## 🧪 Testing obligatorio

### Backend (Java/Spring)
```bash
cd backend
mvn clean test          # Unit tests
mvn verify              # Incluye coverage (JaCoCo)
```

Mínimo **80% de cobertura** en clases de lógica.

### UI B2B (JavaFX)
```bash
cd ui-b2b
mvn clean test          # Tests con TestFX
mvn verify
```

Mínimo **60% de cobertura** de ViewModels.

### UI B2C (Flutter)
```bash
cd ui-b2c
flutter test --coverage # Ejecutar tests
flutter analyze         # Análisis estático
```

Mínimo **70% de cobertura**.

## 🔍 Calidad de código

### Backend
```bash
cd backend
mvn spotbugs:check      # Análisis de bugs
mvn checkstyle:check    # Estilo de código
```

### UI B2B
```bash
cd ui-b2b
mvn spotbugs:check
mvn checkstyle:check
```

### UI B2C
```bash
cd ui-b2c
flutter analyze
dart format --fix .
```

## ✅ Checklist antes de PR

- [ ] Los tests pasan localmente (`mvn test` o `flutter test`)
- [ ] Cobertura mínima cumplida
- [ ] SpotBugs/Lint sin críticos
- [ ] Commit message sigue Conventional Commits
- [ ] Documentación actualizada (si aplica)
- [ ] Sin archivos `.class`, `.jar` o dependencias en git
- [ ] Branch está actualizado con `main/develop`

## 🔐 Seguridad

### Reglas de oro
1. **Nunca** commitear credenciales, tokens, passwords
2. **Nunca** pushear a `main` directamente (solo PRs)
3. **Siempre** validar datos en backend, no en UI
4. **Usar** `.env` y `secrets` de GitHub para config sensible

### Archivos sensibles (ignorados en .gitignore)
```
.env
.env.local
*.key
*.pem
secrets/
```

## 📋 Proceso de Pull Request

1. **Crear PR** con título descriptivo (e.g., "Add login flow for B2B")
2. **Descripción**: Explicar qué cambia y por qué
3. **Asignar reviewers**: Mínimo 1 persona
4. **Esperar checks**: Backend pipeline, UI pipeline, code quality
5. **Resolver feedback**: Si hay comentarios, hacer cambios
6. **Merge**: Solo después de aprobación + checks pasando

### Template de PR
```markdown
## Descripción
Qué se implementa y por qué

## Cambios
- Cambio 1
- Cambio 2

## Testing
Cómo se probó (manual, automated)

## Screenshots/Gifs (si aplica UI)

## Checklist
- [ ] Tests pasan
- [ ] Documentación actualizada
- [ ] Sin warnings/errors
```

## 🚦 Revisión de código

### Criterios
- ¿El código es legible y está bien comentado?
- ¿Cumple con las convenciones del proyecto?
- ¿Hay tests suficientes?
- ¿Se contemplaron casos edge/errores?
- ¿Hay vulnerabilidades de seguridad?
- ¿El rendimiento es aceptable?

### Feedback respetuoso
- Preguntar antes de asumir
- Proponer soluciones, no solo problemas
- Reconocer buenas prácticas

## 🏗️ Estructura de carpetas - Nuevos archivos

### Backend (Java)
```
src/main/java/com/globalfin/
├── entity/          # @Entity, models persistentes
├── dto/             # Data Transfer Objects (inmutables)
├── repository/      # @Repository, acceso a datos
├── service/         # @Service, lógica de negocio
├── controller/      # @RestController, endpoints
├── config/          # @Configuration
├── exception/       # Excepciones custom
└── util/            # Clases utilitarias

src/test/java/...   # Espejo de la estructura anterior
```

### UI B2B (JavaFX)
```
src/main/java/com/globalfin/ui/b2b/
├── controller/      # Controladores FXML (@FXML)
├── model/           # ViewModels (propiedades observable)
├── service/         # Servicios (HTTP client, storage)
├── view/            # Componentes custom
└── util/            # Utilidades (formatters, validators)

src/main/resources/
├── fxml/            # Archivos FXML
└── css/             # Estilos CSS

src/test/java/...   # Tests
```

### UI B2C (Flutter)
```
lib/
├── main.dart        # Punto de entrada
├── screens/         # Pantallas principales
├── widgets/         # Componentes reutilizables
├── models/          # DTOs, entidades
├── services/        # API, storage local
├── providers/       # Estado (Provider/Bloc)
└── utils/           # Helpers, validadores

test/
├── unit/            # Tests de lógica
├── widget/          # Tests de widgets
└── integration/     # Tests end-to-end
```

## 🐛 Reporte de bugs

Si encuentras un bug:
1. Abre una **Issue** describiendo el problema
2. Incluye pasos para reproducir
3. Agrega screenshots/logs si es posible
4. Asigna label: `bug`, `priority-high` (si es crítico)

## 💬 Comunicación

- **Slack / Teams**: Preguntas rápidas, sincronización
- **GitHub Issues**: Bugs, features, tasks con contexto
- **PR Comments**: Feedback técnico, revisión de código

---

**¡Gracias por contribuir a GlobalFin!** 🎉
