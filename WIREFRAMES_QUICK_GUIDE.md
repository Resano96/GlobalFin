# 🎨 Wireframes GlobalFin - Guía Rápida

## 👋 Bienvenido

Se han generado **wireframes Low-Fidelity** (diseños en blanco y negro sin colores finales) para validar el flujo de usuario antes de comenzar la implementación.

---

## 🖼️ VISUALIZAR WIREFRAMES

### Opción 1: HTML Interactivo (Recomendado)

**Abrir en navegador**:
```
B2B Dashboard: docs/wireframes-b2b.html
B2C Mobile:    docs/wireframes-b2c.html
```

**Ventajas**:
✅ Interactivo (clickeable)  
✅ Responsive (se adapta a pantalla)  
✅ Sin software adicional  
✅ Fácil de compartir

**Cómo**:
1. Descargar archivos
2. Doble-click en HTML
3. Verá en navegador

---

## 📋 QUÉ VE EN CADA WIREFRAME

### B2B Dashboard (Desktop)

**Pantalla 1: Login**
- Cabecera con logo
- Campos: Email + Contraseña
- Botón "Ingresar"
- Sin ratón (navegación por teclado)

**Pantalla 2: Dashboard Principal**
- Sidebar izquierdo (menú)
- Top bar (búsqueda + usuario)
- Área central:
  - 3 tarjetas de métricas (KPIs)
  - Tabla de transacciones virtualizada
  - Paginación

**Características**:
- Diseño para empleados
- Keyboard-first (Alt+T, Alt+R, etc)
- Debe soportar 50,000+ registros
- Tabla optimizada con scroll virtual

---

### B2C Mobile (iOS/Android)

**Pantalla 1: Splash**
- Logo animado (2 segundos)
- Auto-navega a Login

**Pantalla 2: Login**
- Email + Contraseña (mobile optimizado)
- Touch targets ≥44x44dp
- Show/hide password

**Pantalla 3: Dashboard**
- Saludo + Saldo destacado
- 4 acciones rápidas (grid 2x2)
- Últimos movimientos
- Bottom nav (5 tabs)

**Pantalla 4: Movimientos**
- Filtros (rango de fechas)
- Listado agrupado por mes
- Colores: Verde (entrada), Rojo (salida)
- Scroll infinito

**Características**:
- Diseño para clientes
- 100% accesible (VoiceOver, TalkBack)
- Totalmente responsive
- Micro-interacciones visibles

---

## ✅ CHECKLIST DE VALIDACIÓN

Como CEO/PO, por favor validar:

### B2B Dashboard
- [ ] Flujo de login es claro
- [ ] Información en dashboard es suficiente para empleados
- [ ] Tabla es usable con teclado
- [ ] Menú tiene opciones necesarias
- [ ] Agregar/quitar elementos según necesidad

### B2C Mobile
- [ ] Flujo completo es intuitivo
- [ ] Información de saldo es clara
- [ ] Acciones rápidas son las correctas
- [ ] Listado de movimientos es usable
- [ ] Bottom nav tiene tabs suficientes

### General
- [ ] Flujos de usuario son claros
- [ ] Hay logotipo en lugares adecuados
- [ ] Jerarquía visual hace sentido
- [ ] Mensajes de error son claros

---

## 🔄 PROPORCIONAR FEEDBACK

### Cambios sugeridos:
1. Describir qué falta o sobra
2. Sugerir ubicación alternativa (si aplica)
3. Compartir con el equipo

**Ejemplo feedback**:
> "En B2B Dashboard, agregar botón 'Exportar' en toolbar top-right, entre búsqueda y avatar."

### Proceso:
```
1. CEO/PO revisa wireframes (1-2 horas)
   ↓
2. Envía feedback al equipo
   ↓
3. Equipo (Designer + Tech Lead) itera
   ↓
4. CEO/PO aprueba iteración
   ↓
5. Comienza diseño High-Fi (con colores)
   ↓
6. Desarrollo frontend comienza
```

---

## 📐 ESPECIFICACIONES TÉCNICAS

### B2B (Desktop)
- Viewport: 1280 x 1024 pixels
- Navegación: Keyboard-first (sin ratón)
- Tabla: Soporta scroll virtual para 50K+ registros

### B2C (Mobile)
- Viewport: 375 x 667 pixels (iPhone 8/9)
- Touch: Mínimo 44x44dp por elemento
- Accesibilidad: VoiceOver + TalkBack

---

## 🎨 SIGUIENTE FASE: HIGH-FIDELITY

Una vez aprobados estos wireframes Low-Fi:

1. **Designer** crea versión HIGH-FIDELITY en Figma
2. Se agregan:
   - Colores de marca (#003DA5 primary, etc)
   - Tipografía (Roboto, Poppins)
   - Efectos de sombra
   - Micro-interacciones
   - Estudio de componentes reutilizables

3. **Developer** implementa UI basado en High-Fi
4. **QA** valida contra diseño

---

## 📚 DOCUMENTOS ADICIONALES

En caso que quiera más detalle:

- **[WIREFRAMES_SUMMARY.md](docs/WIREFRAMES_SUMMARY.md)** - Descripción completa
- **[FIGMA_GUIDE.md](docs/FIGMA_GUIDE.md)** - Cómo se implementó en Figma
- **[ARCHITECTURE.md](docs/ARCHITECTURE.md)** - Diseño técnico del sistema
- **[wireframes-specification.json](docs/wireframes-specification.json)** - Especificación en JSON

---

## ❓ PREGUNTAS FRECUENTES

**P: ¿Por qué blanco y negro?**  
R: Wireframes Low-Fi se usan para validar flujo y usabilidad, no estética. Colores vienen después en High-Fi.

**P: ¿Cuándo tenemos colores?**  
R: Después de aprobación Low-Fi (2-3 días). Designer crea High-Fi en Figma.

**P: ¿Se puede cambiar el flujo?**  
R: Sí. Feedback shapes el producto. Mejor ahora (sin código) que después.

**P: ¿Cuánto tarda el desarrollo?**  
R: ~3 semanas (Sprint 2) para implementar login + dashboard con seguridad.

**P: ¿Quién implementa?**  
R: 3 desarrolladores (Backend + Desktop + Mobile) trabajando en paralelo.

---

## 🚀 PRÓXIMOS PASOS

### HOY
- [ ] Revisar wireframes HTML
- [ ] Dar feedback al equipo

### PRÓXIMA SEMANA
- [ ] Designer crea High-Fi design
- [ ] Aprobación final de colores/tipografía

### 3 SEMANAS
- [ ] Desarrollo frontend terminado
- [ ] Testing e integración
- [ ] Deploy a staging para UAT

---

## 📞 CONTACTAR

¿Dudas o sugerencias?

- **Tech Lead**: Preguntas técnicas
- **Designer**: Preguntas de diseño
- **Product Manager**: Priorización de features

---

**Generado**: Marzo 1, 2026  
**Status**: 🟢 Ready for Review  
**Próxima revisión**: Marzo 3, 2026

Gracias por revisar. Tu feedback es crítico para el éxito del proyecto.
