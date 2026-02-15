# 📚 LitMind Web

**LitMind** es una plataforma educativa web diseñada para mejorar las habilidades lectoras mediante inteligencia artificial, gamificación y personalización.

## 🎯 Características Principales

### ✅ Implementado en esta versión

- **Sistema de Autenticación**
  - Login con email y contraseña
  - Registro de nuevos usuarios
  - Roles de usuario (Estudiante, Profesor, Padre/Madre)
  - Persistencia de sesión con localStorage

- **Panel de Estadísticas**
  - Velocidad de lectura (palabras por minuto)
  - Comprensión lectora (porcentaje)
  - Libros completados
  - Racha de días consecutivos
  - Gráficos de progreso semanal
  - Tendencia de comprensión mensual
  - Actividad semanal

### 🚧 Próximas Funcionalidades (Roadmap)

- Prueba de nivel inicial
- Lector de textos integrado con ejercicios
- Recomendaciones de lectura personalizadas con IA
- Clubs de lectura y foros
- Sistema de logros y recompensas
- Integración con backend real

## 🛠️ Tecnologías

- **Angular 18** - Framework principal
- **TypeScript** - Lenguaje de programación
- **RxJS** - Programación reactiva
- **CSS3** - Estilos y animaciones
- **Signals** - Gestión de estado (nueva API de Angular)

## 📦 Instalación

### Requisitos previos

- Node.js 18 o superior
- npm 9 o superior

### Pasos

1. Clonar el repositorio
```bash
git clone [URL_DEL_REPOSITORIO]
cd litmind-web
```

2. Instalar dependencias
```bash
npm install
```

3. Iniciar el servidor de desarrollo
```bash
npm start
```

4. Abrir en el navegador
```
http://localhost:4200
```

## 🔐 Credenciales de Demo

Para probar la aplicación sin registrarse:

- **Email:** test@litmind.com
- **Contraseña:** test123

## 📁 Estructura del Proyecto

```
litmind-web/
├── src/
│   ├── app/
│   │   ├── core/
│   │   │   ├── models/          # Modelos de datos
│   │   │   ├── services/        # Servicios compartidos
│   │   │   └── guards/          # Guards de autenticación
│   │   ├── features/
│   │   │   ├── auth/            # Módulo de autenticación
│   │   │   │   ├── login/
│   │   │   │   └── register/
│   │   │   └── statistics/      # Dashboard de estadísticas
│   │   └── shared/              # Componentes compartidos
│   ├── assets/                  # Recursos estáticos
│   └── styles.css               # Estilos globales
├── package.json
├── angular.json
└── README.md
```

## 🎨 Diseño

El diseño está basado en el **Figma** del proyecto LitMind, con una paleta de colores:

- **Primario:** `#8575A2` (Púrpura)
- **Secundario:** `#E8D5F2` (Lila claro)
- **Éxito:** `#75A285` (Verde)
- **Advertencia:** `#E5A865` (Naranja)
- **Información:** `#7595A2` (Azul)

## 📱 Responsive Design

La aplicación está completamente optimizada para:
- 📱 Móviles (320px - 768px)
- 💻 Tablets (768px - 1024px)
- 🖥️ Desktop (1024px+)

## 🤝 Contribuir

Este proyecto es parte del **Proyecto Intermodular DAM** del curso 2025/26.

## 📄 Licencia

Este proyecto es de uso educativo para el **2º CFGS DAM** en Torre de los Guzmanes.

## 👥 Autor

**Ángela Chica Montero**
- Proyecto Intermodular DAM 2025/26
- Torre de los Guzmanes

## 🔗 Enlaces Relacionados

- [Figma del Proyecto](https://www.figma.com/design/DZGRCxZdHL0LJlTi3EyOcm/Proyecto-LitMind)
- Proyecto Android: LitMind (en desarrollo)

## 📊 Objetivos de Desarrollo Sostenible (ODS)

Este proyecto contribuye a los siguientes ODS:

- **ODS 4** - Educación de calidad
- **ODS 9** - Industria, innovación e infraestructura
- **ODS 10** - Reducción de las desigualdades
- **ODS 12** - Producción y consumo responsables
- **ODS 17** - Alianzas para lograr los objetivos

---

**¡Gracias por usar LitMind! 📚✨**
