# Guía: Crear Wireframes en Figma

## 📋 Introducción

Esta guía te ayuda a crear los wireframes Low-Fi de GlobalFin en Figma, basados en la especificación de este repositorio.

## 🎯 Objetivo

Transferir la especificación técnica a Figma de forma que:
1. El CEO/PO pueda validar visualmente el flujo
2. Quede documentado para handoff a diseñadores
3. Se establezca como base para High-Fi design

---

## 🚀 Paso 1: Setup en Figma

### Crear nuevo proyecto

```
1. Ir a figma.com/files
2. Crear nuevo "File" llamado: "GlobalFin - Wireframes (Low-Fi)"
3. Crear nueva página: " B2B Dashboard"
4. Crear nueva página: "B2C Mobile"
```

### Configurar guías de estilos

```
Figma → Assets → color library

Agregue colores (Gray-scale solo):
  - Black: #000000
  - Dark Gray: #333333
  - Medium Gray: #666666
  - Light Gray: #CCCCCC
  - Off-White: #F5F5F5
  - White: #FFFFFF
```

---

## 📐 Paso 2: Estructura de página B2B

### 2.1 Frame principal

```
Frame name: "B2B_Login"
Dimensions: 1280 x 1024
Background: White (#FFFFFF)
```

### 2.2 Componentes (Crear as Components)

#### Header
```
Component: "Header_B2B"
- Rectangle: 1280 x 80, Background: White, Border: 1px #999
- Text "GlobalFin", 24px, Bold, #000
- Text "Banking Services", 12px, Light, #666
```

#### Login Form Card
```
Component: "LoginForm"
Constraints: Center, Center
- Rectangle: 400 x 500, Background: #FAFAFA, Border: 1px #999
  
Children:
- Text: "Inicia sesión", 20px, Bold
- Input Group (Email)
  - Label: "Email *", 12px Bold
  - TextField: 400 x 36, Border: 1px #999
- Input Group (Password)
  - Label: "Contraseña *", 12px Bold
  - TextField: 400 x 36, Border: 1px #999, masqueraded
- Link: "¿Olvidaste tu contraseña?", 11px, #0066CC
- Button: "INGRESAR", 400 x 40, Background: #333, White text
- Text: "v1.0.0...", 10px, #999
```

### 2.3 Pantalla Dashboard

```
Frame name: "B2B_Dashboard"
Dimensions: 1280 x 1024
Layout: Horizontal stack

Left Side (Sidebar):
  - Component: "Sidebar_B2B"
  - Width: 250px, Background: #F5F5F5
  - Items: 6 menu options (text, 12px)

Right Side (Main):
  - Component: "Dashboard_Main"
  - Toolbar: Search bar + Export button
  - KPI Grid: 3 cards (1 x 3)
    - Each: 300 x 100, Border: 1px
  - Data Table: 4 rows x 7 columns
    - Striped background (alternating #FFF, #FAFAFA)
    - Borders: 1px #DDD
```

---

## 📱 Paso 3: Estructura de página B2C

### 3.1 Frame principal (Mobile)

```
Frame name: "B2C_Splash"
Dimensions: 375 x 667
Background: White

Components dentro:
- Phone frame (stroke 8px, radius 40px, #333)
- Notch (emulate real device)
```

### 3.2 Pantallas B2C

Crear 4 frames de 375 x 667:

#### Screen 1: Splash
```
Component: "Screen_Splash"
- Circle: 100px, Border: 3px #333, center
- Text: "GlobalFin", 32px, Bold, center
- Text: "Banca para todos", 14px, gray, center
- Spinner: animated circle border
```

#### Screen 2: Login
```
Component: "Screen_Login"
- App Bar: 56px, Background: #333, White text "GlobalFin"
- Content area: padding 20px
  - Heading: "Bienvenido", 28px Bold
  - Subheading: "Ingresa con tu cuenta", 14px gray
  - Form fields: Email + Password (44px height)
  - Link: "¿Olvidaste tu contraseña?"
  - Button: Full width, 44px, Black bg, white text
  - Sign up text + link
- Bottom nav: 5 items, icons + labels
```

#### Screen 3: Dashboard
```
Component: "Screen_Dashboard"
- App Bar: "GlobalFin"
- Greeting: "Hola, Usuario 👋"
- Balance Card: 
  - Background: #F5F5F5
  - Label + large amount
- Action Grid: 2x2 buttons with icons
- Recent Transactions:
  - List of 4 items
  - Date, concept, amount (colored by type)
- Bottom nav: Active on Home
```

#### Screen 4: Transactions
```
Component: "Screen_Transactions"
- App Bar: "Movimientos"
- Filter buttons: Date, Type, Status
- Transaction lists grouped by month
- Infinite scroll indicator
- Bottom nav: Active on Transactions
```

---

## 🎨 Paso 4: Aplicar estilos

### Tipografía

```
Crear Text Styles:

- Heading1: 32px, Bold, #000
- Heading2: 24px, Bold, #000
- Heading3: 20px, Bold, #000
- Body: 14px, Regular, #333
- Caption: 12px, Regular, #666
- Small: 10px, Regular, #999
- Label: 12px, Bold, #000
```

### Componentes reutilizables

```
Create Components:
- Button_Primary: Black bg, white text, 44px height
- Button_Secondary: Border only
- TextField: 36px height, border, padding
- Card: Border + subtle shadow
- Badge: Various sizes
- Icon_Placeholder: 24x24, border circle
```

---

## ✋ Paso 5: Validación

### Checklist

- [ ] Todos los frames tienen nombres descriptivos
- [ ] Componentes están creados (no copy-paste)
- [ ] Spacing es consistente (8px grid)
- [ ] Tipografía sigue la especificación
- [ ] Colores son solo grises (low-fi)
- [ ] Bordes y líneas en 1px
- [ ] Responsive de desktop funciona (desktop)
- [ ] Mobile frames respetan 375x667
- [ ] No hay elementos cortados
- [ ] Naming convention: "Screen_Name" o "Component_Name"

---

## 📤 Paso 6: Exportar + Documentar

### Generar vista previa

```
Figma → File → Export → PDF

Salvar como:
  - "GlobalFin_Wireframes_LowFi_B2B.pdf"
  - "GlobalFin_Wireframes_LowFi_B2C.pdf"
```

### Compartir con el equipo

```
1. Hacer file público o compartir link
2. Agregar anotaciones:
   - [1] Validación en cliente
   - [2] HTTP request al backend
   - [3] Almacenar token seguro

3. Crear Figma comment:
   "Esperando feedback del CEO/PO"
```

### Documentar en README

```markdown
## Wireframes

✅ **Low-Fi Design (Aprobado)**
- [B2B Dashboard Figma](link-figma)
- [B2C Mobile Figma](link-figma)

**Especificación**
- [wireframes-b2b.html](./wireframes-b2b.html)
- [wireframes-b2c.html](./wireframes-b2c.html)
- [wireframes-specification.json](./wireframes-specification.json)

Status: 🔄 En validación con PO
```

---

## 🎨 Paso 7: Preparar para High-Fidelity

Una vez validado Low-Fi, proceder a High-Fi:

```
1. Duplicate página "B2B Dashboard" → "B2B Dashboard - High-Fi"

2. Agregar colores (desde spec):
   - Primary: #003DA5
   - Secondary: #FF6B35
   - Success: #2ECC71
   - Error: #E74C3C
   - Warning: #F39C12

3. Agregar shadow, blur effects

4. Crear design system en Figma:
   - Color styles
   - Text styles
   - Component library

5. Diseñar micro-interacciones:
   - Hover states
   - Active states
   - Loading states
   - Error states
```

---

## 📋 Archivos de referencia

| Archivo | Propósito |
|---------|-----------|
| `wireframes-specification.json` | Spec técnica (elementos, posiciones, propiedades) |
| `wireframes-b2b.html` | Vista HTML del wireframe B2B |
| `wireframes-b2c.html` | Vista HTML del wireframe B2C |
| `docs/ARCHITECTURE.md` | Arquitectura y flujos |

---

## ⚠️ Consideraciones especiales

### B2B (Desktop - 1280px)

```
✓ Sin ratón obligatorio → Keyboard navigation visible
✓ Menú sidebar fijo (left-pin)
✓ Búsqueda activa (Ctrl+K)
✓ Tabla virtualizada para 1000+ filas
✓ Atajos teclado documentados (Alt+T, etc)
```

### B2C (Mobile - 375px)

```
✓ Touch targets ≥ 44x44dp
✓ Notch del iPhone
✓ Bottom navigation sticky
✓ Scroll suave (no jank)
✓ Botones amplios y accesibles
✓ Feedback táctil inmediato
```

---

## 🚀 Next Steps

1. ✅ Crear wireframes en Figma
2. ⏳ Compartir link con CEO/PO
3. ⏳ Recopilar feedback (2-3 días)
4. ⏳ Iterar si es necesario
5. ⏳ Aprobación final → comenzar Sprint 2
6. ⏳ High-Fidelity design

---

**Documento**: Guía de Wireframes Figma  
**Creado**: Marzo 1, 2026  
**Status**: 🟢 Listo para implementar en Figma
