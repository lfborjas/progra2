!SLIDE 
# Herencia 

!SLIDE 
# ¿Qué es herencia? 

!SLIDE bullets
#Herencia biológica

* Se adquieren *rasgos* de los padres
* Pero los hijos son ligeramente diferentes

!SLIDE code small

    @@@java
    class Enemigo{
        double vida;
        double suerte;
        Arma arma;
        public double recibirAtaque(double damage){
            double hit = this.vida - damage;
            this.vida -= hit;
            return hit;
        }
        public double atacar(Heroe h, Arma a){
            return h.recibirAtaque(a.getFuerza());
        }

        public double atacar(Heroe h){
            return atacar(h, this.arma);
        }
    }

!SLIDE code small
    
    @@@java
    class Heroe{
        double vida;
        double suerte;
        ArrayList<Arma> armas;
        public double recibirAtaque(double damage){
            double hit = this.vida - damage;
            this.vida -= hit;
            return hit;
        }
        public double atacar(Enemigo e, Arma a){
            return e.recibirAtaque(a.getFuerza());
        }
        public double agregarArma(Arma a){
            armas.add(a);
        }
    }


!SLIDE code small

    @@@java
    public class Main{
        public static void main(String... args){
            Heroe elHeroe = new Heroe();
            Enemigo elEnemigo = new Enemigo();

            elEnemigo.atacar(elHeroe);
        }
    }

!SLIDE bullets

##Copiar y pegar es un pecado capital

* ¿Qué tienen en común las clases?
* ¿Nos estamos repitiendo a nosotros mismos?
* ¿Qué pasaría si decidimos que ambas clases ahora `recibenAtaque` de otra forma?
* **Siempre que te estés repitiendo, recordá: repetirse está mal, siempre hay solución**


!SLIDE
#Herencia al rescate


!SLIDE code small

    @@@java
    class Personaje{
        double vida;
        double suerte;
        public double recibirAtaque(double damage){
            double hit = this.vida - damage;
            this.vida -= hit;
            return hit;
        }

        public double atacar(Personaje p, Arma a){
            return p.recibirAtaque(a.getFuerza());
        }
    }

!SLIDE code small

    @@@java
    class Enemigo extends Personaje{
        Arma a; 
        public double atacar(Personaje h){
            return atacar(h, this.arma);
        }
    }

!SLIDE code small
    
    @@@java
    class Heroe{
        ArrayList<Arma> armas;

        public double agregarArma(Arma a){
            armas.add(a);
        }
    }


!SLIDE smbullets incremental

##¿Cómo funciona la herencia?

* La palabra clave *extends* declara relación de subclase
* "Enemigo *es un* Personaje"
* ¿Qué se hereda? Métodos de instancia y propiedades *públicos*. 
* **Los constructores NO se heredan**
* **Miembros (propiedades o métodos) *privados* no serán heredados**
* ¿Y qué pasa con el encapsulamiento? *protected*
* Una clase sólo puede tener *un* ancestro pero *muchos* hijos

!SLIDE code small

    @@@java
    public class Main{
        public static void main(String... args){
            Personaje elHeroe = new Heroe();
            Personaje elEnemigo = new Enemigo();

            elEnemigo.atacar(elHeroe);
        }
    }

!SLIDE bullets incremental

*  elHeroe y elEnemigo *son* Personajes
* Podés decir que su *tipo de compilación* es `Personaje`
* Pero construirlos con su verdadero tipo (*de ejecución*)
* "casting" e `instanceof` 

!SLIDE code small

    @@@java
    class Personaje{
        protected double vida;
        protected double suerte;
        public Personaje(double v, double s){
            vida = v;
            suerte = s;
        }
        public double recibirAtaque(double damage){
            double hit = this.vida - damage;
            this.vida -= hit;
            return hit;
        }

        public double atacar(Personaje p, Arma a){
            return p.recibirAtaque(a.getFuerza());
        }
    }

!SLIDE code small

    @@@java
    class Enemigo extends Personaje{
        Arma a; 
        String nombre;
        public Enemigo(double vida, double suerte, String n){
            super(vida, suerte);
            nombre = n;
        }
        public double atacar(Personaje h){
            return super.atacar(h, this.arma);
        }
    }


!SLIDE bullets

##La palabra clave `super`

* La primera línea de un constructor *siempre* debería llamar al de la súper-clase
* `super` se refiere a la parte de esta clase que es de la súper-clase.


!SLIDE code small
    
    @@@java
    class Heroe{
        ArrayList<Arma> armas;

        public double agregarArma(Arma a){
            armas.add(a);
        }

        public double recibirAtaque(double damage){
            damage -= this.suerte*0.01;
            return super.recibirAtaque(damage);
        }
    }

!SLIDE bullets incremental

##¿Qué pasa cuando "redefinís" algo?

* Entra en juego el *polimorfismo*:
* Cuando llamás un método, mira si está en el *tipo de ejecución*
* Si *no* está, busca su definición en el *antecesor* (súper-clase)
* La clase `Object`
* "Override" (¿recordás la anotación `@Override`?)


!SLIDE code

    @@@java
    class Enemigo{
        double vida;
        //...
    }

!SLIDE bullets

* Miembros estáticos y propiedades *no funcionan con polimorfismo*
* ¿Y si hay algo que no querés que se redefina?

!SLIDE code small

    @@@java
    class Personaje{
        protected final double vida;
        //...
    }
    class Enemigo{
        double vida; //ERROR!
        //...
    }

!SLIDE code

    @@@java
    class Enemigo{/*...*/}
    class EnemigoTerrestre extends Enemigo{/*...*/}

!SLIDE bullets

* Una jerarquía puede ser tan profunda como querás
* Pero si querés que una clase no tenga hijos...

!SLIDE code small

    @@@java
    final class Enemigo{/*...*/}
    class EnemigoTerrestre extends Enemigo{/*ERROR!!!*/}

!SLIDE bullets

##Referencias

* [Tutorial oficial de java](http://download.oracle.com/javase/tutorial/java/IandI/subclasses.html)
* [Otro tutorial](http://home.cogeco.ca/~ve3ll/jatutor5.htm)
* [Introducción a java en MIT](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/lecture-notes/)
* [Curso avanzado de java (MIT)](http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-java-preparation-for-6-170-january-iap-2006/lecture-notes/)
* [Curso de java en Princeton](http://introcs.cs.princeton.edu/36inheritance/)
