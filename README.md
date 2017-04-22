# Minimo1Rehecho
Examen Minimo 1 Rehecho (3 partes) con fecha limite 23/04/2017
La EETAC está interesada en construir un juego virtual basado en los famosos
pokemons. Por este motivo, propone a sus alumnos de DSA la construcción de
una prueba piloto con las siguientes operaciones:
- Listado de usuarios ordenado alfabéticamente
- Añadir un usuario
- Modificar un usuario
- Consultar información de un usuario
- Consultar los objetos de un usuario (orden de inserción)
- Añadir un objeto sobre un usuario
SE PIDE:
PARTE I: 4 puntos
1.- Especificación del componente que implementará las operaciones descritas
anteriormente: (EtakemonManager.java , interfaz Java)
2.- Implementación de una Fachada (patrón de diseño) que implemente el
interfaz definido previamente (EtakemonManagerImpl.java, clase Java).
2.1 Elección de las estructuras de datos: HashMap para usuarios y una
implementación de List para los objetos
2.3 La fachada deberá implementarse como un Singleton.
2.4 Todos los métodos deberán tener una TRAZA (a nivel de INFO) de
LOG4J que muestre el valor de los parámetros al inicio de los métodos y
al final. También debe contemplarse trazas de otros niveles (ERORR o
FATAL)
3.- Implementación de un test (JUNIT) sobre el componente desarrollado con
los siguientes puntos:
- método setUp que inicializa la estructura de datos
- método tearDown que libera los recursos
- método de test para añadir un usuario en el sistema y verificar el
número de usuarios.
- método de test para añadir un objeto asociado a un usuario y verificar
el número de objetos asociados a un usuario
PARTE II: 3 puntos
1.- Implementar un servicio REST que permita realizar las siguientes
operaciones:
• lista de usuarios
• añadir un usuario
• modificar un usuario
• consultar la información de un usuario
• consultar los objetos de un usuario
• añadir un objeto sobre un usuario
NOTA: El servicio debe utilizar el componente construido en el punto anterior
(EtakemonManager)
2.- Crear una colección postman para realizar el testing del servicio REST
PARTE III: 3 puntos
1.- Realizar OTRA implementación de la fachada (que implementa las
operaciones descritas) y utilice una base de datos relacional mediante JDBC:
EtakemonManagerDB.java
2.- Integrar el nuevo componente en el servicio REST
NOTA:
- No se permite el uso de System.out.println
- La gestión de dependencias (librerías) debe realizare ÚNICAMENTE con
Maven: junit, log4j, driver sql, etc
- La entrega debe realizarse sobre un repositorio de GITHUB
- ANTES DE FINALIZAR el ejercicio mostrar al profesor
