String.prototype.toTitleCase = function(){
    return this.split(/\s+/).map(function(e){
        return e.charAt(0).toUpperCase() + e.slice(1).toLowerCase();
    }).join(" ");
}
print = typeof window!=="undefined" && window.print || console.log;

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

print(alumnos[Math.floor(Math.random()*alumnos.length)].toTitleCase());
