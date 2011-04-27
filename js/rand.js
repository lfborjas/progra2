//agregamos un nuevo método al tipo String
String.prototype.toTitleCase = function(){
    return this.split(/\s+/).map(function(e){
        return e.charAt(0).toUpperCase() + e.slice(1).toLowerCase();
    }).join(" ");
}

//en javascript NO existen clases, sólo funciones; 
//pero una función puede tener datos miembro y "construirse"
//aquí estoy creando un tipo y AL MISMO TIEMPO una nueva instancia de éste.
//Los datos miembro son lo que retorna.
//ver el "module pattern" (http://www.yuiblog.com/blog/2007/06/12/module-pattern/)
randomizer = new function(){

    alumnos = [
        "Alejandro Núñez Maldonado",
        "ALLEN DANIEL CARBAJAL AYALA",
        "andrea cruz",
        "Andria Reid",
        "ARIEL ARIEL ALVARADO RUBI",
        "Brian Velasquez Sanchez",
        "Carlo Espinal",
        "Claudia Escoto Giron",
        "EDUARDO ARDO CABRERA MARTINEZ",
        "Eduardo Jose   Lopez Rodriguez",
        "Eduardo José Pérez Mejía",
        "Erick Jose  Sierra Hernandez",
        "FABRICIO BRICIO CERRITOS RAUDALES",
        "Luigi Rene Mendoza Roque",
        "Marco  Quan",
        "Rotman Ivan N IVAN ZELAYA LAMBUR",
    ];

    return {
        getRandomStudent : function(){
           return alumnos[Math.floor(Math.random()*alumnos.length)].toTitleCase() 
        }
    };
};

