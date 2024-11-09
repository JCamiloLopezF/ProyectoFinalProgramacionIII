# Luxora Wallet

**Luxora Wallet** es una aplicación de gestión de wallet virtual desarrollada en Java que permite a los usuarios registrar sus datos, realizar transacciones y gestionar su saldo de manera sencilla y segura. El proyecto está diseñado con un enfoque en la seguridad de los datos y la facilidad de uso, proporcionando funcionalidades de inicio de sesión, visualización de transacciones, y sugerencias personalizadas basadas en el historial de transacciones.

## Características

- **Registro de Usuarios:** Los usuarios pueden crear una cuenta en la wallet proporcionando un nombre de usuario único.
- **Inicio de Sesión Seguro:** Los usuarios pueden iniciar sesión con su nombre de usuario y acceder a su historial de transacciones.
- **Gestión de Transacciones:** Los usuarios pueden visualizar todas sus transacciones realizadas, con detalles como fecha, monto y tipo de transacción.
- **Asistente Financiero:** Implementación de un chatbot que ofrece recomendaciones personalizadas sobre ahorro e inversiones, basado en el historial de transacciones del usuario.
- **Interfaz Amigable:** Interfaz de usuario intuitiva, desarrollada con JavaFX, que proporciona una experiencia fluida tanto en el registro como en la interacción con la wallet.

## Tecnologías Utilizadas

- **Java:** Lenguaje de programación principal para la creación de la aplicación.
- **JavaFX:** Framework utilizado para el diseño de la interfaz de usuario.
- **XML y Archivos Binarios:** Persistencia de los datos de usuarios y transacciones.
- **RabbitMQ:** Sistema de mensajería para la comunicación entre componentes del sistema.

## Instalación

1. Clona el repositorio:
  https://github.com/JCamiloLopezF/ProyectoFinalProgramacionIII

2. Crea una carpeta llamada td en el disco C: de tu pc
3. Crea una carpeta llamada persistencia
4. Adentro crea properties.properties   usuarioArchivo.dat   usuarioArchivoXML.xml   y las siguientes carpetas:
archivos    log     respaldo
5. En archivos crea archivosTransacciones.txt   y   archivosUsuarios.txt
En la carpeta de log, crea un archivo llamado luxoraWallet_Log.log