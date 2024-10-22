Jetpack Compose: Aun que existan muchas apps en vistas clasicas, por su reducción de código, rendimiento y compatibilidad, he escoido hacer el proyecto con compose.

Arquitectura:Es el punto más fuerte de esta aplicación, he montado lo que para mi es una estructura Clean, esta consta de 4 capas:
 1. Core: En esta capa defino las configuraciones más generales dentro de la aplicación.
 2. Data: Esta es la capa de acceso a datos, es la responsable de obtencion de los datos tanto de api como de bbdd.
 3. Domain: Se define la lógica de negocio, use cases, etc...
 4. Presentation: Define la capa de interaccion con el usuario.

Patrón MvvM: He decidido utilizar este patrón porque ofrece una estructura organizada y mantenible para manejar la interfaz de usuario y la lógica de negocio

Inyector de dependencias: He escogido koin ya que es la alternativa a Dager-Hitl y es muy simple de utilizar.



