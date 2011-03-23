!SLIDE 
# Arreglos en java 

!SLIDE bullets incremental

## ¿Qué es un arreglo?

* Un contenedor *homogéneo* de 
  tamaño *fijo*.
* Tiene elementos
* Cada elemento tiene un índice
* Empiezan en *cero*
* Si tiene tamaño N, los índices están de *0 a N-1*


!SLIDE

# La imagen

!SLIDE code small

    @@@java
    class Arreglos{
        public static void main(String[] args){
            int[] unArreglo; //declaración
            int otroArreglo[]; //otra declaración

            unArreglo = new int[3]; //inicialización
                                     // y asignación
            unArreglo[0] = 100;
            unArreglo[1] = 225;
            unArreglo[2] = 367;
            
            System.out.println(unArreglo[2]);

            //también podemos asignar los elementos al crear:
            double[] tercerArreglo = {3.1416, 2.712, 1.416};

            System.out.println(unArreglo.length);
            System.out.println(tercerArreglo.length);
        }
    }

!SLIDE bullets

##Arreglos en java

* Se declaran con corchetes después del tipo o del nombre.
* Se *deben* inicializar con un tamaño *entero*.
* Sólo pueden tener elementos del *mismo* tipo.
* Para acceder a un elemento, el índice va entre corchetes.
* Los arreglos cuentan con la propiedad `length`.

!SLIDE 

#¿Qué está mal en el siguiente código?

!SLIDE code

    @@@java
    int[] arreglo1;
    arreglo1[0] = 999;

    double arreglo2[] = new double[2];
    arreglo2[3] = 5.6;
    arreglo2[-1] = 4.44;
    arreglo2[0] = "hola";

    String[] arreglo3 = new int[5];

    char[] arreglo4 = {4.5, 6.7, 0.25};

!SLIDE bullets

##Ejercicios: 

* Imprimir todos los elementos de un arreglo
* Encontrar promedio y los elementos máximo y mínimo de un arreglo de números reales

!SLIDE bullets 

##Algoritmos útiles

* Recorrer un arreglo
* Intercambiar elementos
* Desordenar un arreglo


!SLIDE code

    @@@java
    int[] a = {1,2,3,4,5};
    for(int i = 0; i< a.length; i++)
        System.out.println(a[i]);

!SLIDE code

    @@@java
    int[] b = {1,2,3,4,5};
    int temporal = b[1];
    b[1] = b[2];
    b[2] = temporal;

!SLIDE code
    @@@java
    int[] c = {1,2,3,4,5};
    for(int i = 0; i < a.length; i++){
        int r = i + (int)(Math.random() * (N-i));
        int t = c[r];
        c[r] = c[i];
        c[i] = t;
    }


!SLIDE 

#Arreglos multi-dimensionales

!SLIDE code

    @@@java
    class Arreglos2{
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        double[][] coordenadas = new double[2][2];
        coordenadas[0][0] = 1;
    }

!SLIDE bullets

##Ejercicios

* Imprimir todos los elementos de un arreglo bidimensional, con fila y columna
* Imprimir los elementos en la *diagonal* de un arreglo bidimensional


!SLIDE bullets

##Recordar que

* Los arreglos no pueden cambiar de tamaño, una vez establecido
* Deben inicializarse antes de ser usados
* Índices negativos o muy grandes causan errores
* Comienzan en el índice 0 y terminan en `length-1`

!SLIDE smbullets

## Más ejercicios

* Calcular el producto punto de dos arreglos
* Invertir un arreglo
* Encontrar la transpuesta de una matriz
* Encontrar la suma y el producto de una matriz

