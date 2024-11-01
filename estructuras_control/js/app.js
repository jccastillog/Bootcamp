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

function clasificarEdad(){
    let edad = parseInt(prompt("Ingrese la edad : "));
    if(edad<13){
        console.log("Eres un niño");
    }else if (edad>=13 && edad<18){
        console.log("Eres un adolescente");
    }else if (edad>=18 && edad<65){
        console.log("Eres un adulto");
    }else{
        console.log("Eres un adulto mayor");
    }
}

function queColorEs(){
    let color = prompt("Ingrese el color : ");
    if(color.toUpperCase()==="ROJO"){
        console.log("El color es Rojo");
    }else if(color.toUpperCase()==="AZUL"){
        console.log("El color es Azul");
    }else if(color.toUpperCase()==="AMARILLO"){
        console.log("El color es Amarillo");
    }else {
        console.log("No es ninguno de los colores de la bandera");
    }
}

function pasoLaMateria(){
    let nota = parseInt(prompt("Ingrese la Nota : "));
    switch(nota){
        case 1:
            console.log("Rajado");
            break;
        case 2:
            console.log("Mejor suerte a la próxima");
            break;
        case 3:
            console.log("Paso Raspando");
            break;
        case 4:
            console.log("Buen Trabajo!");
            break;          
        case 5:
            console.log("Excelente!!!");
            break; 
        default :
            console.log("Nota no valida");
            break; 
    }
}

function queDiaEs(){
    let dia = parseInt(prompt("Ingrese el día : "));
    switch (dia) {
        case 1:
            console.log("Lunes");
            break;
        case 2:
            console.log("Martes");
            break;
        case 3:
            console.log("Miercoles");
            break;
        case 4:
            console.log("Jueves");
            break;
        case 5:
            console.log("Viernes");
            break;
        case 6:
            console.log("Sabado");
            break;
        case 7:
            console.log("Domingo");
            break;
        default:
                console.log("Día no Válido");
            break;
    }
}


function queMesEs(){
    let mes = prompt("Ingrese el nombre del mes : ");
    switch (mes.toUpperCase()) {
        case "ENERO":
            console.log("1");
            break;
        case "FEBRERO":
            console.log("2");
            break;
        case "MARZO":
            console.log("3");
            break;
        case "ABRIL":
            console.log("4");
            break;
        case "MAYO":
            console.log("5");
            break;
        case "JUNIO":
            console.log("6");
            break;
        case "JULIO":
            console.log("7");
            break;
        case "AGOSTO":
            console.log("8");
            break;
        case "SEPTIEMBRE":
            console.log("9");
            break;
        case "OCTUBRE":
            console.log("10");
            break;            
        case "NOVIEMBRE":
            console.log("11");
            break;
        case "DICIEMBRE":
            console.log("12");
            break;
        default:
            console.log("Mes no Válido");
            break;
    }
}

function evaluarHoraDelDia(){
    let hora = parseInt(prompt("Ingrese la hora : "));
    let mensaje;
    switch (true) {
        case hora>=0 && hora<12:
            mensaje = "Buenos Días"
            break;
        case hora>=12 && hora<18:
            mensaje = "Buenas Tardes"
            break;    
        case hora>=18 && hora<24:
            mensaje = "Buenas Noches"
            break;            
        default:
            mensaje = "Hora no valida"
            break;
    }
    console.log(mensaje);
}

function evaluarHoraDelDiaConIf(){
    let hora = parseInt(prompt("Ingrese la hora : "));
    let mensaje;
    if(hora>=0 && hora<12){
        mensaje = "Buenos Días";
    }else if (hora>=12 && hora<18){
        mensaje = "Buenas Tardes";
    }else if (hora>=18 && hora<24){
        mensaje = "Buenas Noches";
    }else{
        mensaje = "Hora no valida";
    }
    console.log(mensaje);
}

function while1(){
    let numero= 0;
    while (numero<=10) {
        console.log(numero);
        numero++
    }
}

function while2(){
    let numero = parseInt(prompt("Ingrese un numero : "));
    while (numero<=20) {
        console.log(numero);
        numero +=2;
    }
}

function while3(){
    let nombre = prompt("Ingrese su nombre : ");
    let condicion=true;
    while (condicion){
        if(nombre==="Juan") {
        console.log("Bienvenido")
        condicion=false;
        }else{
            nombre = prompt("Nombre Errado, Ingrese su nombre : ");
        }
    }
}

function while4(){
    let contrasena = "12345678";
    let contrasenaIngresada = prompt("Ingrese la contraseña : ");
    let condicion=true;
    while (condicion){
        if(contrasena===contrasenaIngresada) {
        console.log("Bienvenido, Contraseña correcta")
        condicion=false;
        }else{
            contrasenaIngresada = prompt("Contraseña Errada, Ingrese la contraseña : ");
        }
    }
}

function while5(){
    let numero = parseInt(prompt("Ingrese un número : "));
    while (numero>0){
        console.log(numero);
        numero--;
    }
}

function for1(){
    for (let i = 1; i <= 15; i++) {
        console.log(i);
    }
}

function for2(){
    for (let i = 15; i >= 0; i--) {
        console.log(i);
    }
}