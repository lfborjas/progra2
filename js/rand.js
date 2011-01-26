//agregamos un nuevo método al tipo String
String.prototype.toTitleCase = function(){
    return this.split(/\s+/).map(function(e){
        return e.charAt(0).toUpperCase() + e.slice(1).toLowerCase();
    }).join(" ");
}

//en javascript NO existen clases, sólo funciones; pero una función puede tener datos miembro y "construirse"
//aquí estoy creando un tipo y AL MISMO TIEMPO una nueva instancia de éste. Los datos miembro son lo que retorna.
//ver el "module pattern" (http://www.yuiblog.com/blog/2007/06/12/module-pattern/)
randomizer = new function(){

    alumnos = [
        "11021065 CARLOS RAMIREZ",
        "ALFREDO  UMANZOR ORTIZ",
        "Andrea Trejo Andino",
        "ANTONIO ANTONIO PINEDA PAZ",
        "Bryam   Almendarez Valle",
        "CATHERINE XITLALY ORDOÑEZ",
        "CHRISTIAN GEOVANNY JUAREZ NAVARRO",
        "DAVID ELIAS FLORES DOMINGUEZ",
        "DELCY CAROLINA BONILLA OLIVA",
        "Erick Jose  Sierra Hernandez",
        "Frank Douglas  Arevalo",
        "GABRIELA MAHELY  TORRES VELASQUEZ",
        "GRETHELL ELIUTH CONNOR HERRERA",
        "Haracil Bartem Tomé Rivera",
        "JOSE DAVID CASTILLO RAPALO",
        "kely sanchez",
        "Mario  Cedeño",
        "Oscar Mayorquin",
        "PEDRO  CASTRILLO",
        "Roberto Rivera",
        "Wilmer Carranza Molina",
    ];

    return {
        getRandomStudent : function(){
           return alumnos[Math.floor(Math.random()*alumnos.length)].toTitleCase() 
        }
    };
};

