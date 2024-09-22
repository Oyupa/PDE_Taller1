Repositorio: https://github.com/Oyupa/PDE_Taller1

# Taller 1 - PDE

## Funcionamiento

### 1. Main Activity
#### La aplicación inicia en la Main Activity, en la cual se muestra un mensaje de bienvenida que cambia en función de la hora del día y un botón que lleva a la Primary Activity.

### 2. Primary Activity
#### En la Primary Activity se encuentra un `EditText` en el que se puede ingresar cualquier cadena de caracteres (no vacía) para que sea almacenada como nombre del usuario.
#### Al presionar el botón `Guardar` se almacena el nombre del usuario en un archivo de texto en la memoria interna del dispositivo. Si el nombre está vacío, se mostrará un aviso con un `Toast.makeText` y no se guardará.
#### Seguidamente, se encuentra el espacio de texto `TextView` en el que se muestra el nombre del usuario almacenado.
#### Al presionar el botón `Ir a la Configuración` se pasa a la Settings Activity.

### 3. Settings Activity
#### En la Settings Activity se encuentran 5 botones que permiten cambiar el color de fondo de la aplicación. Al presionar uno de los botones, se cambia el color de fondo de la aplicación y se guarda en la memoria interna del dispositivo lo que permite que el ajuste quede guardado en todas las actividades incluso se cierra la aplicación.
#### Por último, se encuentra el botón `Volver al Saludo` que lleva de vuelta a la Main Activity.


## Desarollo

### 1. Crear un repositorio en GitHub
#### La aplicación la subido a un repositorio en GitHub para poder trabajar desde distintos dispositivos y para tener un control de versiones eficiente.

### 2. Crear un archivo README.md
#### El archivo README.md me ha servido para ir documentando el desarrollo de la aplicación y para poder explicar el funcionamiento de la misma.

### 3. Crear la Main Activity
#### Para crear las diferentes actividades he decidido usar plantillas xml (en la carpeta `/res/layout`) que me servirían como base para el diseño de las actividades.
#### Seguidamente, he creado la clase `MainActivity` que extiende de `CompatActivity` y he implementado el método `onCreate` para poder mostrar el mensaje de bienvenida y el botón que lleva a la Primary Activity.

### 4. Crear la Primary Activity
#### Aquí, primeramente, he creado la plantilla xml de la actividad y la clase `PrimaryActivity` que extiende de `CompatActivity`.
#### He implementado el método `onCreate` para mostrar el `EditText` y el `TextView` y he usado `SharedPreferences` para guardar el nombre del usuario.
#### He evitado que el nombre del usuario sea vacío y he mostrado un aviso con `Toast.makeText` en caso de que el nombre sea vacío.
#### Por último, he implementado el botón que lleva a la Settings Activity.

### 5. Crear la Settings Activity
#### He creado la plantilla xml de la actividad y la clase `SettingsActivity` que extiende de `CompatActivity`.
#### He implementado el método `onCreate` para mostrar los botones que permiten cambiar el color de fondo de la aplicación y he usado `SharedPreferences` para guardar el color de fondo. Aquí han surgido algunos problemas dado que pretendía usar una librería externa (colorpicker) para cambiar el color de fondo, pero al final he obtado por implementar un numero fijo de colores a los que el usuario pueda cambiar el fondo.
#### Por último, he implementado el botón que lleva de vuelta a la Main Activity.