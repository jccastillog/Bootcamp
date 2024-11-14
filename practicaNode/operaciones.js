/* exports.producto = function(a,b) {return a*b;};
exports.suma = function(a,b){return a + b;}; */

//Se exporta como un objeto
module.exports = {
    producto2: function(a,b){return a*b;},
    suma2: function(a,b) {return a+b;}
}


//funcion constructora, al usarla se usa la palabra new para crear un nuevo objeto
/* module.exports = function(a,b){
    this.producto = a * b,
    this.suma = function(){return a+b};
} */