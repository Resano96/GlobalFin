# GlobalFin

## 📋 Proyecto GlobalFin

Este repositorio contiene los artefactos del proyecto bancario **GlobalFin**.
Durante este sprint inicial nos centramos en validar los diseños y preparar el entorno de desarrollo antes de escribir código.

---

## 🎨 Wireframes Low-Fi (Fase 1)

### 📊 Dashboard B2B (Empleados - Internal Use)

Estructura de wireframes necesarios para el dashboard interno:

#### 1. **Login B2B** (Pantalla de autenticación)
- Cabecera con logo GlobalFin
- Campo email con validación
- Campo contraseña con toggle "mostrar/ocultar"
- Botón "Ingresar" (CTA principal)
- Link "He olvidado mi contraseña" (recuperación)
- Pie: versión de la app y copyright
- **Observaciones**: Sin JavaScript; validación en backend. Navegación por Tab+Enter.

#### 2. **Dashboard Principal** (Home)
- Barra lateral left-pin (siempre visible en desktop):
  - Logo GlobalFin
  - Menú principal (5-6 opciones: Transacciones, Reportes, Clientes, Configuración, Logout)
  - Indicador de rol/usuario logueado
- Encabezado top:
  - Título de la sección actual
  - Búsqueda rápida (keyboard-first)
  - Avatar de usuario + dropdown de menú
- Área de contenido central:
  - Widgets resumen (tarjetas con KPIs): Total de transacciones, clientes activos, alertas, etc.
  - Tabla de últimas transacciones (paginable, selección múltiple)
  - Gráfico de tendencias (opcional)
- **Observaciones**: Jerarquía visual clara. Atajos de teclado (Alt+T = Transacciones, etc.).

#### 3. **Gestión de Transacciones** (Tabla principal)
- Filtros top (fecha, rango, estado: pendiente/completado)
- Tabla grande:
  - Columnas: ID, Cliente, Monto, Fecha, Estado, Acciones
  - Ordenable por cada columna
  - Selección múltiple con checkboxes
  - Paginación con salto de página
- Acciones inline (ver detalles, editar, eliminar)
- Botón "Exportar" (CSV/PDF)
- **Observaciones**: Virtual scrolling para grandes datasets. Sin hover (focus en keyboard).

#### 4. **Detalle de Transacción** (Modal/Side panel)
- Encabezado: Referencia y estado (badge de color)
- Secciones desplegables:
  - Información de cliente
  - Detalles de transacción
  - Historial de cambios
- Botones de acción: Aprobar, Rechazar, Comentar
- Botón de cierre (X o Escape)
- **Observaciones**: Datos inmutables desde el cliente. Validaciones en backend.

#### 5. **Reportes** (Basic)
- Filtros avanzados (fecha, tipo, estado)
- Selector de formato (PDF, CSV, Excel)
- Tabla de reportes disponibles (generados previamente)
- Botón "Generar nuevo reporte"
- **Observaciones**: Sin gráficos interactivos en fase 1.

#### 6. **Configuración / Perfil de Usuario**
- Datos personales (nombre, email, rol) - solo lectura
- Cambio de contraseña
- Preferencias (tema, idioma)
- Botón "Logout"

---

### 📱 App B2C (Clientes - Mobile)

Estructura de wireframes para la aplicación Flutter:

#### 1. **Splash Screen / Onboarding**
- Logo GlobalFin animado
- Texto: "Bienvenido a GlobalFin"
- Botones: "Ingresar" / "Registrarse"
- **Consideraciones**: Accesibilidad. Contraste ≥ 4.5:1.

#### 2. **Login B2C** (Mobile-optimized)
- Campo email con teclado email
- Campo contraseña con toggle mostrar/ocultar
- Botón "Ingresar" (ancho completo, fondo de marca)
- Link "Registrarse" y "He olvidado mi contraseña"
- **Consideraciones**: Tamaño de touch ≥ 44x44dp. Microinteracción en button (feedback táctil).

#### 3. **Registro B2C**
- Flujo multi-paso (paso 1: email/teléfono, paso 2: datos, paso 3: contraseña)
- Indicador de progreso (step indicator)
- Validación en tiempo real (visual feedback)
- **Consideraciones**: Sin envíos hasta que todo sea válido. Relectura clara de datos.

#### 4. **Dashboard de Cliente** (Home)
- Encabezado: Saludo personalizado + saldo disponible (resaltado)
- Tarjetas de acciones rápidas (3-4): Ver movimientos, Transferir, Pagar servicios, Solicitar préstamo
- Sección "Últimos movimientos" (scroll horizontal o vertical)
- Banner de promoción/notificación importante
- Bottom navigation (5 tabs: Home, Transacciones, Tarjetas, Soporte, Perfil)
- **Consideraciones**: Microinteracciones suaves (ease-in-out). Accesibilidad con VoiceOver.

#### 5. **Movimientos / Historial**
- Calendario picker (seleccionar rango de fechas)
- Lista de transacciones (fecha, concepto, monto, saldo)
- Codificación por color (ingresos = verde, egresos = rojo)
- Pull-to-refresh
- Infinity scroll o paginación
- **Consideraciones**: Iconos + texto siempre (no solo iconos). Suficientemente grande para leer sin zoom.

#### 6. **Detalle de Movimiento**
- Resumen: monto, fecha, hora, concepto
- Detalles completos (referencia, comisión, saldo resultante)
- Botones: Descargar comprobante, Compartir, Reportar problema
- **Consideraciones**: Sin datos sensibles expuestos. Backend valida acceso (el cliente solo ve sus propios datos).

#### 7. **Transferencias** (Flujo paso a paso)
- Paso 1: Seleccionar beneficiario (listado preexistente o agregar nuevo)
- Paso 2: Ingresar monto + concepto
- Paso 3: Revisar datos + confirmar con PIN/Biometría
- Paso 4: Confirmación (éxito/error)
- **Consideraciones**: Validación completa en backend. La app solo recibe/envía DTOs inmutables.

#### 8. **Perfil de Usuario**
- Avatar + nombre
- Email, teléfono (con opción de editar desde backend)
- Datos bancarios (cuenta, tipo)
- Botón "Cerrar sesión"
- Versión de la app + copyright
- **Consideraciones**: Solo lectura para datos sensibles.

---

## 📐 Especificaciones técnicas de los wireframes

### 🖇️ Criterios de aceptación generales:

1. **Wireframe Low-Fi**: Blanco y negro, sin colores de marca. Solo geometría y espacios.
2. **Tipografía**: Especificar tamaños relativos (Heading, Body, Caption).
3. **Responsividad**: Indicar puntos de quiebre (desktop 1280+, tablet 768+, mobile <768).
4. **Navegación**: Rutas claras entre pantallas (flechas de flujo).
5. **Estados de componentes**: Normal, hover (desktop) / active (mobile), disabled, loading, error.
6. **Iconografía**: Definir set de iconos (Material Design o custom).
7. **Paleta de colores** (a definir en alta fidelidad):
   - Primary: Azul bankario (seguridad, confianza)
   - Secondary: Verde/naranja (acciones, positividad)
   - Neutral: Grises (fondos, bordes)
   - Estados: Rojo (error), Amarillo (warning), Verde (éxito)

### 🔐 Notas de seguridad en los wireframes:

- **Nunca** mostrar datos sensibles (números completos de cuenta, SSN) completamente.
- **Validación**: Indicar visualmente qué campos son requeridos o tienen restricciones.
- **Feedback de error**: Mostrar mensajes claros sin exponer detalles internos del servidor.
- **CORS/API**: Los wireframes asumen que toda la lógica está en el backend.

---

## 📏 Paleta de colores (Propuesta inicial)

| Elemento | Color | Uso |
|----------|-------|-----|
| Primary | #003DA5 | Botones principales, encabezados B2B |
| Accent | #FF6B35 | CTAs secundarias, notificaciones |
| Success | #2ECC71 | Estados completados, ingresos |
| Error | #E74C3C | Estados rechazados, egresos |
| Warning | #F39C12 | Alertas, estados pendientes |
| Neutral Dark | #2C3E50 | Texto principal |
| Neutral Light | #ECF0F1 | Fondos |

---

## 🎨 Wireframes y prototipos

### Figma Workspace

**Enlace a Figma** (compartido con el equipo):
- `GlobalFin / Diseño` → Carpeta colaborativa.
- `/Low-Fi/` → Wireframes en escala de grises.
- `/High-Fi/` → Prototipos finales con colores y tipografía.
- `/Component Library/` → Botones, inputs, cards reutilizables.

### Checklist de aprobación

- [ ] Wireframes Low-Fi completados para B2B y B2C.
- [ ] PO/CEO revisa y da feedback.
- [ ] Iteración 1 (cambios menores).
- [ ] Aprobación final de Low-Fi.
- [ ] Comienza diseño High-Fi.
- [ ] High-Fi aprobado antes de iniciar frontend development.

---

## 🏗️ Estructura inicial recomendada

- `/backend/` – Servicios Spring Boot (skeleton).
- `/ui-b2b/` – Aplicación JavaFX para dashboard interno.
- `/ui-b2c/` – App Flutter para clientes.
- `/docs/` – Documentación de arquitectura, API, seguridad.

## 🎨 Wireframes Low-Fi Generados ✅

Se han creado **4 artefactos** listos para validación con el CEO/PO:

| Recurso | Tipo | Propósito | Ubicación |
|---------|------|----------|-----------|
| **wireframes-b2b.html** | 🖼️ HTML interactivo | Visualizar desktop (1280x1024) | [docs/wireframes-b2b.html](docs/wireframes-b2b.html) |
| **wireframes-b2c.html** | 📱 HTML interactivo | Visualizar mobile (375x667) | [docs/wireframes-b2c.html](docs/wireframes-b2c.html) |
| **wireframes-specification.json** | 📋 JSON técnico | Importar a Figma, especificación | [docs/wireframes-specification.json](docs/wireframes-specification.json) |
| **FIGMA_GUIDE.md** | 📖 Guía paso-a-paso | Recrear en Figma, componentes | [docs/FIGMA_GUIDE.md](docs/FIGMA_GUIDE.md) |

### 🎯 Cómo visualizar

**Abrir en navegador** (recomendado para CEO/PO):
```bash
# B2B (Desktop)
open docs/wireframes-b2b.html

# B2C (Mobile)
open docs/wireframes-b2c.html
```

**Ver especificación técnica**:
```bash
cat docs/wireframes-specification.json | jq
```

**Leer guía de Figma**:
```bash
cat docs/FIGMA_GUIDE.md
```

**Resumen completo**: [docs/WIREFRAMES_SUMMARY.md](docs/WIREFRAMES_SUMMARY.md)

### 📦 Contenido de wireframes

**B2B Dashboard (Desktop - 1280x1024)**
- ✅ Login form (email + password)
- ✅ Dashboard principal con sidebar
- ✅ KPI cards (3 métricas resumen)
- ✅ Tabla virtual de transacciones

**B2C Mobile (375x667)**
- ✅ Splash screen (2 seg)
- ✅ Login form (mobile-optimized)
- ✅ Dashboard con saldo + 4 acciones rápidas
- ✅ Movimientos con filtros

### ✅ Estado
🟢 **Ready for PO validation** - Compartir HTMLs con CEO/PO para feedback visual

---

## ✨ Sprint 1 - Login Completo (TDD + Seguridad)

### ✅ Implementado

#### Backend (Spring Boot 3.2)
- **AuthenticationService**: Validación de credenciales con usuarios de prueba
- **AuthenticationController**: Endpoint `POST /api/auth/login`
- **DTOs**: LoginRequest + LoginResponse (inmutables)
- **Tests**: 12 casos de prueba (validación, errores, roles)
- **Configuración**: H2 Database, Logging (Logback), Security ready

#### UI B2B (JavaFX 21)
- **LoginViewModel**: MVVM pattern, propiedades observables, validación automática
- **HttpAuthService**: HTTP client asincrónico, sanitización JSON
- **Tests**: 10 casos de prueba (estado, validación, binding)

#### UI B2C (Flutter)
- **SplashScreen**: Animación inicial de marca
- **LoginScreen**: Formulario completocon validaciones (email, contraseña)
- **Tests**: Widget tests + smoke tests

#### CI/CD
- 3 workflows GitHub Actions (backend, UI B2B, UI B2C)
- Análisis automático (SpotBugs, Checkstyle, Flutter Lint)
- Reportes de cobertura (JaCoCo)

---

## 🚀 Setup del Entorno

### Requisitos previos
- **Java 21** (JDK)
- **Maven 3.8+**
- **Git**
- **IntelliJ IDEA** (Ultimate recomendado)
- **Flutter SDK** (para UI B2C)

### Clonar y configurar

```bash
git clone https://github.com/Resano96/GlobalFin.git
cd GlobalFin
```

### Backend (Spring Boot)

```bash
cd backend
mvn clean package        # Compilar
mvn spring-boot:run      # Ejecutar (puerto 8080)
mvn test                 # Tests
mvn spotbugs:check       # Análisis de buffer
```

La API estará disponible en `http://localhost:8080/api`

**Usuarios de prueba**:
- Email: `admin@globalfin.com` / Contraseña: `admin123` / Rol: ADMIN
- Email: `empleado@globalfin.com` / Contraseña: `emp123` / Rol: EMPLOYEE
- Email: `cliente@globalfin.com` / Contraseña: `cli123` / Rol: USER

### UI B2B (JavaFX)

```bash
cd ui-b2b
mvn clean javafx:run     # Ejecutar app desktop
mvn test                 # Tests con TestFX
```

**Requisito en Linux**: `sudo apt-get install libgtk-3-0`

### UI B2C (Flutter)

```bash
cd ui-b2c
flutter pub get          # Descargar dependencias
flutter run              # Ejecutar en emulador/dispositivo
flutter test --coverage  # Tests con coverage
```

> ⚠️ **Nota**: Flutter no está instalado en el contenedor. Ejecutar manualmente en máquina con Flutter SDK.

## 📚 Documentación

- **[ARCHITECTURE.md](docs/ARCHITECTURE.md)**: Descripción detallada de la arquitectura, estructura de carpetas y decisiones técnicas.
- **[CONTRIBUTING.md](docs/CONTRIBUTING.md)**: Guía para contribuir, convenciones de commits, y proceso de PR.

## 🔄 CI/CD Pipelines

Cada módulo tiene su propio workflow en **GitHub Actions**:

- `backend-ci.yml`: Build → Test → Analysis → Coverage (Maven)
- `ui-b2b-ci.yml`: Build → Test → Analysis (Maven + JavaFX)
- `ui-b2c-ci.yml`: Build → Test → Android APK/iOS IPA (Flutter)

**Acceso**: `.github/workflows/`

### Regla principal
✅ **No se mergea a `main` sin pasar todos los checks**

## 📊 Métricas de calidad esperadas

| Métrica | Meta | Módulo |
|---------|------|--------|
| Cobertura | 80% | Backend |
| Cobertura | 60% | UI B2B |
| Cobertura | 70% | UI B2C |
| SpotBugs | 0 críticos | Backend, UI B2B |
| Flutter Analyze | 0 errores | UI B2C |

## 🚀 Primeros pasos

1. ✅ Estructura de carpetas configurada
2. ✅ Proyectos Maven/Flutter inicializados
3. ✅ Pipelines CI/CD en GitHub Actions
4. ⏳ Crear wireframes Low-Fi en Figma
5. ⏳ Aprobación visual del CEO/PO
6. ⏳ Desarrollo de primera pantalla (login)

---
