# 🗺️ Mapa del Proyecto GlobalFin

## 📍 Estructura Completa (Sprint 1)

```
GlobalFin/
│
├── 📄 README.md                          ⭐ INICIO - Overview del proyecto
├── 📄 RESOURCES.md                       📚 Índice de recursos
├── 📄 WIREFRAMES_QUICK_GUIDE.md          👔 Para CEO/PO - Cómo ver wireframes
│
├── 📁 docs/
│   ├── ARCHITECTURE.md                   🏗️ Arquitectura técnica (15 pgs)
│   ├── CONTRIBUTING.md                   🤝 Guía de contribución (12 pgs)
│   ├── SECURITY.md                       🔒 Análisis de seguridad (14 pgs)
│   ├── SPRINT1_SUMMARY.md                📊 Resumen Sprint 1 (10 pgs)
│   ├── SPRINT1_FINAL_REPORT.md           📈 Reporte final (20 pgs)
│   │
│   ├── WIREFRAMES_SUMMARY.md             🎨 Overview wireframes (12 pgs)
│   ├── FIGMA_GUIDE.md                    🖌️ Cómo crear en Figma (10 pgs)
│   │
│   ├── wireframes-specification.json     📋 JSON de especificación
│   ├── wireframes-b2b.html               🖥️ Viz B2B (500+ líneas HTML)
│   └── wireframes-b2c.html               📱 Viz B2C (600+ líneas HTML)
│
├── 📁 backend/
│   ├── pom.xml                           Maven config (Spring Boot 3.2)
│   ├── README.md                         Backend setup guide
│   │
│   ├── src/main/java/com/globalfin/
│   │   ├── GlobalFinApplication.java     🚀 Spring Boot entry point
│   │   │
│   │   ├── controller/
│   │   │   └── AuthenticationController.java    REST /api/auth/login
│   │   │
│   │   ├── service/
│   │   │   └── AuthenticationService.java       Login business logic
│   │   │
│   │   ├── dto/
│   │   │   ├── LoginRequest.java               Email + password (immutable)
│   │   │   └── LoginResponse.java              Token + user (immutable)
│   │   │
│   │   └── exception/
│   │       └── AuthenticationException.java    Custom exception
│   │
│   ├── src/main/resources/
│   │   ├── application.yml                     H2 database config
│   │   └── logback-spring.xml                  Logging config
│   │
│   ├── src/test/java/com/globalfin/
│   │   ├── service/
│   │   │   └── AuthenticationServiceTest.java  8 unit tests
│   │   │
│   │   └── controller/
│   │       └── AuthenticationControllerIntegrationTest.java  5 integration tests
│   │
│   └── target/
│       └── site/jacoco/index.html              Coverage report (95%)
│
├── 📁 ui-b2b/
│   ├── pom.xml                           Maven config (JavaFX 21)
│   ├── README.md                         UI B2B setup guide
│   │
│   ├── src/main/java/com/globalfin/ui/b2b/
│   │   ├── MainApp.java                       🎯 JavaFX application
│   │   │
│   │   ├── model/
│   │   │   └── LoginViewModel.java            MVVM ViewModel (observable)
│   │   │
│   │   └── service/
│   │       └── HttpAuthService.java           HTTP client, sanitization
│   │
│   ├── src/test/java/com/globalfin/ui/b2b/
│   │   ├── model/
│   │   │   └── LoginViewModelTest.java        10 ViewModel tests
│   │   │
│   │   └── MainAppTest.java                   Smoke test
│   │
│   └── target/
│       └── site/jacoco/index.html             Coverage report (95%)
│
├── 📁 ui-b2c/
│   ├── pubspec.yaml                      Flutter dependencies
│   ├── README.md                         Flutter setup guide
│   │
│   ├── lib/
│   │   ├── main.dart                         🎯 App entry point
│   │   │
│   │   ├── screens/
│   │   │   ├── splash_screen.dart            Animated 2-sec splash
│   │   │   └── login_screen.dart             Complete login form
│   │   │
│   │   └── models/
│   │       └── authenticated_user.dart       User data model
│   │
│   ├── test/
│   │   ├── smoke_test.dart                   Compilation verification
│   │   └── screens_test.dart                 Widget tests (4 tests)
│   │
│   └── coverage/
│       └── lcov-report/index.html            Coverage report (70%)
│
├── 📁 .github/workflows/
│   ├── backend-ci.yml                    🔄 Backend pipeline
│   │   └── Maven clean → package → test → spotbugs → checkstyle → jaco
│   ├── ui-b2b-ci.yml                     🔄 JavaFX pipeline
│   │   └── Maven clean → javafx:run → test → analysis
│   └── ui-b2c-ci.yml                     🔄 Flutter pipeline
│       └── flutter analyze → test → coverage → build
│
├── .gitignore                            Git ignore patterns
└── checkstyle.xml                        Code style rules (120 char lines)
```

---

## 🧭 NAVEGACIÓN POR ROL

### 👔 Para CEO/PO

**COMIENZA AQUÍ**:
1. Leer: [README.md](README.md) - Resumen proyecto
2. Ver: [WIREFRAMES_QUICK_GUIDE.md](WIREFRAMES_QUICK_GUIDE.md) - Cómo ver wireframes
3. Abrir: [docs/wireframes-b2b.html](docs/wireframes-b2b.html) en navegador
4. Abrir: [docs/wireframes-b2c.html](docs/wireframes-b2c.html) en navegador
5. Leer: [docs/SPRINT1_FINAL_REPORT.md](docs/SPRINT1_FINAL_REPORT.md) - Métricas y logros

**Documentos principales**:
- Overview: [README.md](README.md)
- Wireframes: [docs/wireframes-b2b.html](docs/wireframes-b2b.html) + [docs/wireframes-b2c.html](docs/wireframes-b2c.html)
- Reporte: [docs/SPRINT1_FINAL_REPORT.md](docs/SPRINT1_FINAL_REPORT.md)

---

### 🎨 Para Diseñador

**COMIENZA AQUÍ**:
1. Leer: [WIREFRAMES_QUICK_GUIDE.md](WIREFRAMES_QUICK_GUIDE.md)
2. Revisar: [docs/wireframes-specification.json](docs/wireframes-specification.json)
3. Leer: [docs/FIGMA_GUIDE.md](docs/FIGMA_GUIDE.md)
4. Ver: [docs/wireframes-b2b.html](docs/wireframes-b2b.html) + [docs/wireframes-b2c.html](docs/wireframes-b2c.html)

**Documentos principales**:
- Especificación técnica: [docs/wireframes-specification.json](docs/wireframes-specification.json)
- Guía Figma: [docs/FIGMA_GUIDE.md](docs/FIGMA_GUIDE.md)
- Visualización: HTML en navegador

---

### 🏗️ Para Tech Lead / Arquitecto

**COMIENZA AQUÍ**:
1. Leer: [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md)
2. Leer: [docs/SECURITY.md](docs/SECURITY.md)
3. Revisar: [README.md](README.md) - Setup inicial
4. Leer: [docs/SPRINT1_FINAL_REPORT.md](docs/SPRINT1_FINAL_REPORT.md)
5. Revisar CI/CD: [.github/workflows/](.github/workflows)

**Documentos principales**:
- Arquitectura: [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md)
- Seguridad: [docs/SECURITY.md](docs/SECURITY.md)
- Contribución: [docs/CONTRIBUTING.md](docs/CONTRIBUTING.md)

---

### 💻 Para Backend Developer

**COMIENZA AQUÍ**:
1. Leer: [backend/README.md](backend/README.md)
2. Leer: [docs/CONTRIBUTING.md](docs/CONTRIBUTING.md)
3. Revisar: [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md) - Architecture section
4. Leer: [docs/SECURITY.md](docs/SECURITY.md)
5. Setup: `cd backend && mvn clean package`

**Archivos principales**:
- Backend main: [backend/src/main/java/com/globalfin/](backend/src/main/java/com/globalfin/)
- Tests: [backend/src/test/java/com/globalfin/](backend/src/test/java/com/globalfin/)
- Config: [backend/pom.xml](backend/pom.xml)

---

### 🖥️ Para Frontend B2B Developer (JavaFX)

**COMIENZA AQUÍ**:
1. Leer: [ui-b2b/README.md](ui-b2b/README.md)
2. Leer: [docs/CONTRIBUTING.md](docs/CONTRIBUTING.md)
3. Revisar: [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md) - MVVM section
4. Ver: [docs/wireframes-b2b.html](docs/wireframes-b2b.html) - UI reference
5. Setup: `cd ui-b2b && mvn clean javafx:run`

**Archivos principales**:
- ViewModel: [ui-b2b/src/main/java/com/globalfin/ui/b2b/model/](ui-b2b/src/main/java/com/globalfin/ui/b2b/model/)
- Service: [ui-b2b/src/main/java/com/globalfin/ui/b2b/service/](ui-b2b/src/main/java/com/globalfin/ui/b2b/service/)
- Tests: [ui-b2b/src/test/java/](ui-b2b/src/test/java/)

---

### 📱 Para Frontend B2C Developer (Flutter)

**COMIENZA AQUÍ**:
1. Leer: [ui-b2c/README.md](ui-b2c/README.md)
2. Leer: [docs/CONTRIBUTING.md](docs/CONTRIBUTING.md)
3. Revisar: [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md) - MVU section
4. Ver: [docs/wireframes-b2c.html](docs/wireframes-b2c.html) - UI reference
5. Setup: `cd ui-b2c && flutter pub get && flutter run`

**Archivos principales**:
- Screens: [ui-b2c/lib/screens/](ui-b2c/lib/screens/)
- Main: [ui-b2c/lib/main.dart](ui-b2c/lib/main.dart)
- Tests: [ui-b2c/test/](ui-b2c/test/)

---

## 📚 DOCUMENTACIÓN - MAPA DE REFERENCIAS

```
Sprint 1 Documentation Hierarchy
│
├── 👁️ OVERVIEW (para todos)
│   ├── README.md
│   └── RESOURCES.md
│
├── 💼 BUSINESS / PM (CEO/PO)
│   ├── WIREFRAMES_QUICK_GUIDE.md
│   ├── wireframes-b2b.html
│   ├── wireframes-b2c.html
│   └── SPRINT1_FINAL_REPORT.md
│
├── 📐 DESIGN (Designer/UX)
│   ├── WIREFRAMES_SUMMARY.md
│   ├── FIGMA_GUIDE.md
│   ├── wireframes-specification.json
│   ├── wireframes-b2b.html
│   └── wireframes-b2c.html
│
├── 🏗️ TECHNICAL LEADERSHIP
│   ├── ARCHITECTURE.md
│   ├── SECURITY.md
│   ├── CONTRIBUTING.md
│   └── SPRINT1_FINAL_REPORT.md
│
├── 💻 DEVELOPMENT
│   ├── CONTRIBUTING.md
│   ├── ARCHITECTURE.md
│   ├── backend/README.md
│   ├── ui-b2b/README.md
│   ├── ui-b2c/README.md
│   └── Source code files
│
└── 🔐 SECURITY
    ├── SECURITY.md
    └── checkstyle.xml
```

---

## 🎯 QUICK LINKS POR TAREA

### "Quiero ver el producto"
→ [docs/wireframes-b2b.html](docs/wireframes-b2b.html) + [docs/wireframes-b2c.html](docs/wireframes-b2c.html)

### "Quiero entender la arquitectura"
→ [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md)

### "Quiero revisar código"
→ Según módulo:
- Backend: [backend/src/main/java/](backend/src/main/java/)
- B2B: [ui-b2b/src/main/java/](ui-b2b/src/main/java/)
- B2C: [ui-b2c/lib/](ui-b2c/lib/)

### "Quiero saber cómo contribuir"
→ [docs/CONTRIBUTING.md](docs/CONTRIBUTING.md)

### "Quiero revisar seguridad"
→ [docs/SECURITY.md](docs/SECURITY.md)

### "Quiero ver métricas"
→ [docs/SPRINT1_FINAL_REPORT.md](docs/SPRINT1_FINAL_REPORT.md)

### "Quiero correo para CEO"
→ [WIREFRAMES_QUICK_GUIDE.md](WIREFRAMES_QUICK_GUIDE.md) + HTMLs

### "Quiero setup instrucciones"
→ [README.md](README.md) + módulo README específico

### "Quiero lista de recursos"
→ [RESOURCES.md](RESOURCES.md)

---

## 🚀 EJECUCIÓN POR FASE

### Fase 1: Validación (HOY - Próx 2 días)
```
CEO/PO revisa:
├── Abrir docs/wireframes-b2b.html
├── Abrir docs/wireframes-b2c.html
├── Dar feedback
└── Aprobar
```

### Fase 2: Diseño (Próx 1 semana)
```
Designer:
├── Leer FIGMA_GUIDE.md
├── Crear High-Fi en Figma
├── Obtener aprobación
└── Exportar componentes
```

### Fase 3: Desarrollo (Sprint 2)
```
Developers:
├── Setup backend/b2b/b2c según READMEs
├── Implementar según wireframes
├── Escribir tests (TDD)
├── Push a GitHub
├── CI/CD corre automáticamente
└── Merge a main cuando todo está green
```

---

## 📊 ESTADÍSTICAS

### Documentación
- Total documentos: 13
- Páginas markdown: ~150
- Líneas JSON: 400+
- Líneas HTML: 1100+

### Código
- Líneas Java: 1400+
- Líneas Dart: 500+
- Tests: 29 (100% passing)
- Cobertura: 85-95%

### Configuración
- CI/CD workflowws: 3
- Maven pom.xml: 3
- Flutter pubspec: 1
- Git ignore: 1

---

## 🎓 GUÍAS PASO-A-PASO

### "Quiero ejecutar el backend"
1. Leer: [backend/README.md](backend/README.md)
2. Ejecutar: `cd backend && mvn spring-boot:run`
3. Test: [http://localhost:8080/api/auth/login](http://localhost:8080/api/auth/login) (POST)

### "Quiero ejecutar UI B2B"
1. Leer: [ui-b2b/README.md](ui-b2b/README.md)
2. Ejecutar: `cd ui-b2b && mvn clean javafx:run`
3. Login con test users

### "Quiero ejecutar UI B2C"
1. Leer: [ui-b2c/README.md](ui-b2c/README.md)
2. Ejecutar: `cd ui-b2c && flutter pub get && flutter run`
3. Login con test users

### "Quiero ver tests"
1. Backend: `cd backend && mvn test`
2. B2B: `cd ui-b2b && mvn test`
3. B2C: `cd ui-b2c && flutter test`

### "Quiero ver coverage"
1. Backend: `cd backend && mvn jacoco:report` → target/site/jacoco/index.html
2. B2B: `cd ui-b2b && mvn jacoco:report` → target/site/jacoco/index.html
3. B2C: `cd ui-b2c && flutter test --coverage` → coverage/lcov-report/index.html

---

## 📞 CUANDO NECESITAS AYUDA

| Problema | Contactar | Referencia |
|----------|-----------|-----------|
| ¿Cómo contribuir? | Leer | [CONTRIBUTING.md](docs/CONTRIBUTING.md) |
| Backend error | Backend lead | [backend/README.md](backend/README.md) |
| UI B2B error | Frontend lead (JavaFX) | [ui-b2b/README.md](ui-b2b/README.md) |
| UI B2C error | Frontend lead (Flutter) | [ui-b2c/README.md](ui-b2c/README.md) |
| Security question | Security officer | [SECURITY.md](docs/SECURITY.md) |
| Architecture question | Tech lead | [ARCHITECTURE.md](docs/ARCHITECTURE.md) |

---

## ✅ CHECKLIST: "¿Dónde está?"

- [ ] Wireframes? → [docs/wireframes-*.html](docs/)
- [ ] Código Backend? → [backend/src/main/](backend/src/main/)
- [ ] Código B2B? → [ui-b2b/src/main/](ui-b2b/src/main/)
- [ ] Código B2C? → [ui-b2c/lib/](ui-b2c/lib/)
- [ ] Tests? → [backend/src/test/](backend/src/test/) + [ui-b2b/src/test/](ui-b2b/src/test/) + [ui-b2c/test/](ui-b2c/test/)
- [ ] Configuración? → pom.xml + pubspec.yaml + [.github/workflows/](.github/workflows/)
- [ ] Documentación? → [docs/](docs/) + READMEs
- [ ] Guía Figma? → [docs/FIGMA_GUIDE.md](docs/FIGMA_GUIDE.md)
- [ ] Especificación JSON? → [docs/wireframes-specification.json](docs/wireframes-specification.json)
- [ ] Setup instrucciones? → [README.md](README.md) + módulo README

---

**Mapa Generado**: Marzo 1, 2026  
**Status**: 🟢 Sprint 1 Complete  
**Última actualización**: Marzo 1, 2026

*Este archivo es tu guía de navegación. Úsalo como punto de partida para encontrar lo que necesitas.*
