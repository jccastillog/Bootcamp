function esMayorQue(){
    let numeroUno = parseInt(prompt("Ingrese el primer número : "));
    let numeroDos = parseInt(prompt("Ingrese el segundo número : "));
    if(numeroUno==numeroDos){
        console.log("El número Uno es igual al número Dos");
    }else if(numeroUno>numeroDos){
        console.log("El número Uno es mayor que el número Dos");
    }else{
        console.log("El número Uno es menor que el número Dos");
    }
}

function esMayordeEdad(){
    let edad = parseInt(prompt("Ingrese su edad : "));
    if(edad>=18){
        console.log("Usted es mayor de edad");
    }else{
        console.log("Usted es menor de edad");
    }
}

function aproboMateria(){
    let nota = parseInt(prompt("Ingrese la nota : "));
    if(nota>=90){
        console.log("Sobresaliente!!!");
    }else if(nota>=70){
        console.log("Aceptable");
    }else{
        console.log("Reprobado");
    }
}