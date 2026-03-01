# 📚 Recursos del Proyecto GlobalFin

Guía rápida para acceder a toda la documentación y artefactos del proyecto.

---

## 🎨 WIREFRAMES 

### 📱 Visualización Interactiva (Para CEO/PO)

**B2B Dashboard (Desktop)**
- 📄 Archivo: [docs/wireframes-b2b.html](docs/wireframes-b2b.html)
- 🖥️ Abrir en navegador: `file:///workspaces/GlobalFin/docs/wireframes-b2b.html`
- 📐 Viewport: 1280x1024px
- 🎯 Incluye: Login + Dashboard con tabla virtual + KPIs

**B2C Mobile App**
- 📄 Archivo: [docs/wireframes-b2c.html](docs/wireframes-b2c.html)
- 📱 Abrir en navegador: Mismo archivo, scroll down
- 📐 Viewport: 375x667px (iPhone)
- 🎯 Incluye: Splash + Login + Dashboard + Movimientos

### 📋 Especificación Técnica (Para Diseñadores)

- **[docs/wireframes-specification.json](docs/wireframes-specification.json)** - Definición en JSON
- **[docs/FIGMA_GUIDE.md](docs/FIGMA_GUIDE.md)** - Instrucciones para Figma

### 📖 Resumen Ejecutivo

- **[docs/WIREFRAMES_SUMMARY.md](docs/WIREFRAMES_SUMMARY.md)** - Overview completo de wireframes

---

## 📖 DOCUMENTACIÓN TÉCNICA

### Arquitectura & Diseño

| Documento | Propósito | Audiencia |
|-----------|----------|-----------|
| [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md) | Arquitectura técnica, patrones, decisiones | Tech Lead, Developers |
| [docs/SECURITY.md](docs/SECURITY.md) | Análisis de seguridad, vulnerabilidades, roadmap | Security Officer, Tech Lead |
| [docs/SPRINT1_SUMMARY.md](docs/SPRINT1_SUMMARY.md) | Resumen de Sprint 1, métricas, lecciones | Stakeholders, Team |

### Setup & Contribuciones

| Documento | Propósito | Audiencia |
|-----------|----------|-----------|
| [README.md](README.md) | Overview del proyecto, setup inicial | Everyone |
| [docs/CONTRIBUTING.md](docs/CONTRIBUTING.md) | Cómo contribuir, convenciones, PR process | Contributors |
| [backend/README.md](backend/README.md) | Setup backend, endpoints, test users | Backend Devs |
| [ui-b2b/README.md](ui-b2b/README.md) | Setup UI B2B, MVVM pattern | Desktop Devs |
| [ui-b2c/README.md](ui-b2c/README.md) | Setup UI B2C, Flutter structure | Mobile Devs |

---

## 💻 COMO EMPEZAR

### 1️⃣ Clonar Repositorio
```bash
git clone https://github.com/Resano96/GlobalFin.git
cd GlobalFin
```

### 2️⃣ Setup Backend
```bash
cd backend
mvn clean package
mvn spring-boot:run  # Inicia en puerto 8080
```

**Test Users**:
- `admin@globalfin.com` / `admin123` (ADMIN)
- `empleado@globalfin.com` / `emp123` (EMPLOYEE)
- `cliente@globalfin.com` / `cli123` (USER)

### 3️⃣ Setup UI B2B
```bash
cd ui-b2b
mvn clean javafx:run  # Inicia JavaFX
```

### 4️⃣ Setup UI B2C
```bash
cd ui-b2c
flutter pub get
flutter run  # En emulador/dispositivo
```

---

## 🧪 TESTING

### Ejecutar Tests Completos

```bash
# Backend (13 tests)
cd backend && mvn test

# UI B2B (10 tests)
cd ui-b2b && mvn test

# UI B2C (6 tests)
cd ui-b2c && flutter test --coverage
```

### Coverage Reports

- Backend: `backend/target/site/jacoco/index.html`
- UI B2B: `ui-b2b/target/site/jacoco/index.html`
- UI B2C: `ui-b2c/coverage/lcov-report/index.html`

---

## 🔄 CI/CD PIPELINES

### GitHub Actions Workflows

| Workflow | Evento | Ubicación |
|----------|--------|-----------|
| Backend CI | Push/PR | `.github/workflows/backend-ci.yml` |
| UI B2B CI | Push/PR | `.github/workflows/ui-b2b-ci.yml` |
| UI B2C CI | Push/PR | `.github/workflows/ui-b2c-ci.yml` |

**Acciones por pipeline**:
- Maven: clean → package → test → SpotBugs → Checkstyle → JaCoCo
- Flutter: analyze → test → coverage → build APK/IPA

---

## 📊 ESTRUCTURA DEL PROYECTO

```
GlobalFin/
├── backend/                    # Spring Boot 3.2
│   ├── src/main/java/
│   │   └── com/globalfin/
│   │       ├── GlobalFinApplication.java
│   │       ├── controller/     # REST endpoints
│   │       ├── service/        # Business logic
│   │       ├── dto/            # Request/Response
│   │       ├── exception/      # Custom exceptions
│   │       └── ...
│   ├── src/test/java/          # 13 test cases
│   ├── pom.xml                 # Maven config
│   └── README.md
│
├── ui-b2b/                     # JavaFX Desktop
│   ├── src/main/java/
│   │   └── com/globalfin/ui/b2b/
│   │       ├── MainApp.java    # App entry
│   │       ├── model/          # ViewModel (MVVM)
│   │       ├── service/        # HTTP service
│   │       └── ...
│   ├── src/test/java/          # 10 test cases
│   ├── pom.xml
│   └── README.md
│
├── ui-b2c/                     # Flutter Mobile
│   ├── lib/
│   │   ├── main.dart           # App entry
│   │   ├── screens/            # UI screens
│   │   └── ...
│   ├── test/                   # 6 test cases
│   ├── pubspec.yaml
│   └── README.md
│
├── docs/                       # Documentation
│   ├── ARCHITECTURE.md
│   ├── CONTRIBUTING.md
│   ├── SECURITY.md
│   ├── SPRINT1_SUMMARY.md
│   ├── WIREFRAMES_SUMMARY.md
│   ├── FIGMA_GUIDE.md
│   ├── wireframes-b2b.html     # Wireframe viz
│   ├── wireframes-b2c.html     # Wireframe viz
│   └── wireframes-specification.json
│
├── .github/workflows/          # CI/CD pipelines
│   ├── backend-ci.yml
│   ├── ui-b2b-ci.yml
│   └── ui-b2c-ci.yml
│
├── .gitignore
├── README.md
├── RESOURCES.md               # Este archivo
└── checkstyle.xml            # Reglas de estilo
```

---

## 🎯 QUICK LINKS

### Para CEO/PO
- 🖼️ [B2B Wireframes](docs/wireframes-b2b.html) - Visualizar desktop
- 📱 [B2C Wireframes](docs/wireframes-b2c.html) - Visualizar mobile
- 📖 [Sprint 1 Summary](docs/SPRINT1_SUMMARY.md) - Qué se entregó

### Para Tech Team
- 🏛️ [Architecture](docs/ARCHITECTURE.md) - Diseño técnico
- 🔒 [Security](docs/SECURITY.md) - Análisis de seguridad
- 📝 [Contributing](docs/CONTRIBUTING.md) - Cómo contribuir

### Para Diseñadores
- 📋 [Wireframe Specs](docs/wireframes-specification.json) - JSON spec
- 📖 [Figma Guide](docs/FIGMA_GUIDE.md) - Cómo crear en Figma
- 📊 [Summary](docs/WIREFRAMES_SUMMARY.md) - Overview wireframes

### Para Desarrolladores
- 💻 [Backend Setup](backend/README.md) - Java/Spring Boot
- 🖥️ [UI B2B Setup](ui-b2b/README.md) - JavaFX desktop
- 📱 [UI B2C Setup](ui-b2c/README.md) - Flutter mobile

---

## 📊 PROJECTSTATUS

| Área | Sprint 1 | Sprint 2 | Sprint 3+ |
|------|----------|----------|-----------|
| **Backend** | ✅ Login | 🔄 DB + bcrypt + JWT | 🔮 2FA + Rate-limit |
| **UI B2B** | ✅ ViewModel | 🔄 Dashboard | 🔮 Reports |
| **UI B2C** | ✅ Screens | 🔄 Integration | 🔮 Payments |
| **Seguridad** | ✅ Base | 🔄 bcrypt + JWT + CORS | 🔮 OAuth2 |
| **Docs** | ✅ Complete | 🔄 Roadmap | 🔮 API docs |

---

## 📞 CONTACTOS

- **CEO/PO**: Valida wireframes y visión
- **Tech Lead**: Revisa arquitectura y seguridad
- **Backend Dev**: Implementa servicios
- **Desktop Dev**: Implementa UI B2B
- **Mobile Dev**: Implementa UI B2C
- **Designer**: Crea High-Fi design, componentes

---

## 🚀 PRÓXIMOS PASOS

### Semana 1 (HOY)
- [ ] CEO/PO revisa wireframes (B2B + B2C HTML)
- [ ] Recopilar feedback
- [ ] Actualizar especificación si hay cambios

### Semana 2-3 (Sprint 2)
- [ ] Designer crea High-Fi en Figma
- [ ] Aprobación final de diseño
- [ ] Backend dev inicia DB + bcrypt
- [ ] Frontend dev inicia integración

### Semana 4+ (Sprint 2+)
- [ ] Frontend conecta a backend real
- [ ] Testing e2e
- [ ] Deploy a staging
- [ ] UAT y feedback

---

**Última actualización**: Marzo 1, 2026  
**Status**: 🟢 Sprint 1 Complete - Ready for Validation  
**Próxima revisión**: Marzo 3, 2026 (post CEO/PO feedback)
