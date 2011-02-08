# Proyecto 1: el juego "go" 

##Introducción

Durante los dos siguientes parciales se desarrollará un proyecto en el cual se aplicarán los conceptos vistos durante todo el curso. El proyecto consistirá en una implementación en java del juego de tablero [go](http://en.wikipedia.org/wiki/Go_(game))

Habrán dos entregas para el proyecto. La primera, a realizarse **al final del segundo parcial** comprenderá una prueba de concepto de la jugabilidad y el establecimiento de las clases y rutinas básicas a utilizarse. La segunda, **a presentarse durante la última semana del tercer parcial** incluirá la implementación de una interfaz gráfica de usuario, así como de características avanzadas (guardado de partidas, interacción con el mouse, sugerencias de jugadas).

Para todas las características críticas de la implementación de ambos juegos (validación de jugadas, realización de acciones de usuario, detección del final del juego) se espera se presenten **pruebas automatizadas que aseguren la calidad del código**.

##Requerimientos

###Fase 1 (15 puntos): a entregar el **25 de febrero de 2011**

Se espera que en esta entrega **toda entrada del usuario sea validada**: si en algún momento se esperan números o ciertos caracteres, el programa debería **manejar** estos errores sin interrumpir la ejecución o tener consecuencias indeseables. **Todas las características** se evaluarán con este criterio, así que no sólo deben funcionar como se espera, sino que deben manejar **situaciones excepcionales**.

1. Identificación, mediante diagramas UML, de las clases involucradas en la implementación del juego, así como las relaciones entre éstas. Para crear tales diagramas, se recomienda utilizar una herramienta como gliffy.com(<http://www.gliffy.com/>), dia(<http://dia-installer.de/>) o similar. 
2. Implementación en java de lógica de inicialización de juego: elección del tamaño de tablero (**9x9, 13x13 o 19x19**) y presentación del tablero y estadísticas de juego (cuántas fichas ha capturado y tiene en tablero un jugador). Para esta entrega **no es necesaria una interfaz gráfica** y se recomienda representar al tablero como una simple matriz en consola, por ejemplo, un tablero se podría representar así (donde un `.` representa una intersección, una `o` representa a una ficha blanca y un `#`, a una negra):

          1  2  3  4  5  6  7  8  9
        a .  .  .  .  .  .  .  .  .
        b .  .  .  .  .  .  .  .  .
        c .  .  .  #  .  .  .  .  .
        d .  .  .  o  .  .  .  .  .
        e .  .  .  #  o  .  .  .  .
        f .  .  .  #  #  .  .  .  .
        g .  .  .  .  .  .  .  .  .
        h .  .  .  .  .  .  .  .  . 
        i .  .  .  .  .  .  .  .  . 

3. Implementación de un mecanismo de jugadas: deberá idear una manera en la cual un usuario pueda elegir el destino de una pieza. Se recomienda usar el sistema de coordenadas de tablero: p.e: `A1` para poner una pieza en la intersección de la fila `A` y la columna `1` o `pass` para decir que uno desea saltarse su turno.
4. Implementación de la lógica de turnos: el juego deberá permitir, en esta entrega, que **dos jugadores** se enfrenten como oponentes, **validando** que jugadas inválidas, como *suicidios*, se prohíban. El programa deberá **detectar capturas** y quitar del tablero las piezas capturadas, siguiendo las reglas de captura modernas del juego.
5. Determinación del ganador: una vez que ambos usuarios se han rendido porque consideran que no hay jugadas válidas, el programa deberá calcular el puntaje final, usando cualquiera de los dos sistemas -chino o japonés-  ( _puntos extra si es posible decidir al principio del juego cuál de los dos usar_ )

###Fase 2 (25 puntos) : a entregar el **21 de marzo de 2011**

Esta fase se centrará en el comportamiento avanzado del juego. A pesar de que la interfaz de usuario cambiará, se espera que toda validación pertinente esté presente en cada una de las características siguientes.

1. Creación y personalización de una interfaz gráfica de usuario: 
    1. Al _iniciar_ el juego, uno debe poder elegir el tamaño del tablero, el color que usará, la cantidad de _komi_ que recibirá al final y el número de fichas que deberían estar puestas como [ventaja](http://en.wikipedia.org/wiki/Go_handicaps) al inicio. 
    2. Y _durante_ el juego, el usuario debe tener retroalimentación evidente de cuándo es su turno, el estado de sus fichas, el tiempo transcurrido desde el inicio del juego y por turno. 
    3. Al _final_ del juego, se debe proveer un mecanismo práctico para mostrar el puntaje final calculado automáticamente.

2. El usuario deberá poder usar el *mouse* para realizar jugadas durante su turno (siguiendo las reglas del juego), eligiendo posiciones de destino mediante el evento `click`, cuidando, claro, que no se puedan poner fichas en posiciones inválidas y _dando la retroalimentación pertinente_.
3. Guardado de jugadas: el estado de un juego deberá poder **guardarse en un archivo** para **reanudarse** en un futuro. Este estado deberá ser completo y consistente: desde el turno actual, pasando por el estado de las fichas de cada jugador, hasta el tiempo transcurrido desde el inicio de la partida y desde el inicio del turno actual.

La interfaz gráfica se puede hacer como se desee, se reta al alumno a averiguar sobre las capacidades de [gráficos de java](http://download.oracle.com/javase/tutorial/2d/index.html) para manejar el tablero y las fichas.

##Recursos

* Frank Arévalo tuvo la amabilidad de compilar un documento tutorial en español que se encuentra disponible en la siguiente dirección: <http://lfborjas.com/progra2/go.pdf>
* Asimismo, el sitio <http://govsgo.com> es idóneo para ver una implementación del juego, además de que provee recursos para aprender a jugarlo: <http://govsgo.com/go_resources>
* El proyecto GNU GO es una implementación de código libre en el lenguaje de programación C del juego: <http://www.gnu.org/software/gnugo/>

