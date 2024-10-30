# Proyecto: Jetpack Compose

## Introducción
Este proyecto está desarrollado en **Jetpack Compose**, una herramienta que he seleccionado por sus beneficios en reducción de código, rendimiento y compatibilidad. Aunque existen muchas aplicaciones construidas en vistas clásicas, Compose ofrece un enfoque más moderno y eficiente.

## Arquitectura
La arquitectura es uno de los puntos fuertes de esta aplicación. He implementado una estructura basada en **Clean Architecture**, simulando un proyecto multimodular. Esta estructura está compuesta por cuatro capas principales:

1. **Core**: Define las configuraciones generales de la aplicación.
2. **Data**: Responsable del acceso a datos, ya sea desde la API o la base de datos.
3. **Domain**: Contiene la lógica de negocio, incluyendo los casos de uso.
4. **Presentation**: Define la capa de interacción con el usuario.

---

### 1. Core
- **di**: Contiene la clase `App`, donde se inicializa Koin con la definición de cada módulo en su correspondiente capa.
- **ui**: Aquí se ubican componentes generales, anotaciones para previews de composables en distintos escenarios, `UiStates` para manejar estados, y extensiones reutilizables. También se define el tema personalizado con íconos, tipos de texto, dimensiones, cadenas de texto (en español e inglés), y colores, organizados para facilitar el acceso a cada recurso.

### 2. Data
- **di**: Inyección de dependencias para este módulo (Interceptor, OkHttp, Retrofit, etc.).
- **datasources**: Define métodos para la obtención de datos, separando responsabilidades.
- **datasources_core**: Implementación de métodos y manejo de códigos de error devueltos por la API, ideal para gestionar respuestas de backend.
- **models**: Definición de modelos específicos de la capa `Data`.
- **repository**: Implementación de métodos definidos en el repositorio de la capa `Domain`, con una clara separación de responsabilidades.

> **Nota**: Entre las capas `Data` y `Domain` se deberia de utilizar mappers para cada modelo, de modo que un modelo no acceda a una capa que no le corresponde.

### 3. Domain
- **di**: Inyección de dependencias relacionadas con este módulo (UseCases).
- **models**: Modelos específicos de `Domain`.
- **repository**: Definición de métodos para el repositorio.
- **usecases**: Definición de casos de uso que la aplicación debe manejar.

### 4. Presentation
- **di**: Inyección de dependencias de este módulo (ViewModels).
- **navigation**: Gestión de la navegación entre pantallas. Dado que los usuarios generados por la API no contienen un ID, se utiliza el email como parámetro para cargar los datos de un usuario específico en la pantalla de detalles.
- **screens**: Composables de cada pantalla.
- **viewmodels**: Encargado de gestionar la lógica de la interfaz de usuario (UI).

---

## Patrón MVVM
He decidido utilizar el patrón **MVVM** (Model-View-ViewModel) ya que ofrece una estructura organizada y mantenible para gestionar la interfaz de usuario y la lógica de negocio.

## Inyección de Dependencias
La aplicación utiliza **Koin** como inyector de dependencias, ya que es una alternativa sencilla a Dagger-Hilt y resulta fácil de usar.

## Testing
Se han implementado pruebas básicas para verificar la funcionalidad del repositorio, utilizando datos simulados para comprobar que la clase funciona correctamente al recibir una respuesta exitosa y que filtra los datos duplicados.

## Manejo de Errores
En caso de que la API devuelva un código de error, la aplicación muestra un diálogo con el motivo del error. Actualmente, se han gestionado los errores de tipo desconocido y los problemas de conexión.

## Puntos de Mejora
- Integrar **Room** para permitir el uso de la aplicación en modo offline.
- Implementar un **paginador** para mejorar la navegación de datos extensos.
- Mejorar la **interfaz de usuario (UI)** en ciertos aspectos.


