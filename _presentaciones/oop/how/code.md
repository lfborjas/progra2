!SLIDE code

##Ok, me convenciste, ¿cómo se hace?

    @@@java
    class NOMBRE_DE_CLASE{
        //PROPIEDADES 
        //MÉTODOS 
    }

!SLIDE code small

    @@@java
    public class Persona{
        String nombre;
        int edad;

        public boolean esMayorDeEdad(){
            return this.edad >= 21;
        }

        public boolean seLlama(String n){
            return this.nombre == n;
        }
    }

!SLIDE code small

##¿Y cómo creás personas nuevas?

    @@@java
    String s = "hola"
    String s = new String(new char[]{'h','o','l','a'});
    String p = new Persona("Karl", 60);


!SLIDE code

##Un método especial: el constructor

    @@@java
    public class Persona{
        //Propiedades...
        public Persona(String n, int e){
            this.nombre = n;
            this.edad = e;
        }
        //Métodos...
    }

!SLIDE smbullets
##¿Qué acabamos de hacer?

* Una definición de clase dice qué podrá *ser y hacer* cada instancia
* El *constructor* es un método especial: dice cómo hacer una instancia
* Las *propiedades de instancia* definen el estado
* Los *métodos de instancia* definen el comportamiento
* *`this`* se refiere a la *instancia actual*
* (Cada instancia tiene su propio estado)

!SLIDE bullets

##Definiendo clases

* Si no ponés constructor, se crea uno por defecto
* Todos los métodos pueden estar sobrecargados
* A veces es necesario imprimirlos: `toString`
* A veces es necesario ver si son iguales: `equals`


!SLIDE bullets

##Miembros de instancia vs. miembros de clase

* Cuando ponés `static`, decís: todas las instancias
  van a compartir esto, y no tendrán su propia copia


!SLIDE code small

    @@@java
    class Persona{
        int personasCreadas; 
        int edad;
        public Persona(){
            System.out.println("Personas: "+personasCreadas);
        }
    }
    //... 
    class Main{
        public static void main(String[] args){
            Persona a,b,c;
            a = new Persona(); //Personas: 1
            b = new Persona(); //Personas: 1
            c = new Persona(); //Personas: 1
        }   
    }

!SLIDE code small

    @@@java
    class Persona{
        static int personasCreadas;
        int edad;
        public Persona(){
            System.out.println("Personas: "+personasCreadas);
        }
    }
    //... 
    class Main{
        public static void main(String[] args){
            Persona a,b,c;
            a = new Persona(); //Personas: 1
            b = new Persona(); //Personas: 2
            c = new Persona(); //Personas: 3
        }   
    }


!SLIDE bullets

##Referencias vs Valores

* Una variable es una *referencia* a un objeto
* I.e.: dónde puedo encontrarlo
* `a==b` se pregunta si están el mismo lugar
