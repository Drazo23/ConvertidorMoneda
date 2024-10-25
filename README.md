<h1>Convertidor de moneda</h1>
!Bienvenido al Convertidor de Moneda! Este es un proyecto en Java que permite convertir diferentes monedas utilizando una API de tasas de cambio.

<h3>Descripcion</h3>
ConvertidorMoneda es una aplicación de consola que ofrece opciones para convertir diferentes monedas en las que estan:

- Dolar a peso argentino.
- Peso argentino a dolar.
- Dólar a Real brasileño
- Real brasileño a Dólar
- Dólar a Peso colombiano
- Peso colombiano a Dólar


La conversión se realiza utilizando datos obtenidos de una API externa que proporciona las tasas de cambio actuales.

El convertidor presenta un menu donde se encuentras las anteriores monedas mencionadas, junto a una opcion para deterner el programa. a su vez, el programa solicita por consola en valor que desea cambiar segun la opcion elegida y hace el respectivo cambio.


Si el cliente ingresa una opcion que no se encuentra en el menu, el programa le solicita al usuario que ingrese una opcion valida y le muestra nuevamente el menu. 



<h3>Estructura del proyecto</h3>
1. ConvertidorMoneda: 

Esta clase contiene la lógica principal de la aplicación. Se encarga de:

- Mostrar un menú de opciones al usuario.
- Recoger la entrada del usuario.
- Realizar la conversión de monedas utilizando la función convertir.


2. RespuestaCambio: 

Esta clase se encarga de manejar la respuesta de la API, específicamente la tasa de conversión.

<h3>Requisitos</h3>
- Java 8 o superior
- Dependencia de Gson para la deserialización JSON

<h3>Cómo ejecutar</h3>

- Clona este repositorio o descarga los archivos del proyecto.
- Asegúrate de tener Gson en tu classpath. Puedes agregarlo mediante Maven o Gradle, o descargar el .jar manualmente.
- Compila el proyecto y ejecuta la clase ConvertidorMoneda.




