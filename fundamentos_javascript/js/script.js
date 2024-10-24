function saludar(){
    alert("Hola, estoy saludando");
    console.log("Hola, estoy saludando por consola");
}

function mostrarTiposDatos(){
    console.log("Un valor de tipo texto");
    console.log(20);
    console.log(1.2);
    console.log(1,62);
    console.log(1+1);
    console.log(true);
    console.log(false);
    console.log({});
}

function mostrarVariables(){
    let numero = 10;
    let verdadero = true;
    let nombre = 'Juan Carlos';
    console.log("Numero :"+ numero)
    console.log("verdadero:"+verdadero)
    console.log("Nombre:"+nombre);

    console.log("Tú nombre es: "+ nombre + " y tú número es " + numero)
}

function sumarDosNumeros(){
    let numero1 = 10;
    let numero2 = 20;
    console.log("Sumar dos números " + (numero1 + numero2))
}


function capturarDatos(){
    let nombre = prompt("ingrese su nombre: ");
    let apellido = prompt("ingrese su apellido: ");
    console.log("Su nombre completo es : "+nombre+" "+apellido);
}

function sumar(){
    let numero1 = prompt("ingrese su numero 1: "); //prompt solo recibe string
    let numero2 = prompt("ingrese su numero 2: ");
    console.log(typeof numero1); //muestra el tipo de dato
    resultado = parseInt(numero1)+parseInt(numero2); //parseInt convierte a entero las variables
    console.log("Resultado :" + resultado);
}

function restar(){
    let numero1 = prompt("ingrese su numero 1: "); //prompt solo recibe string
    let numero2 = prompt("ingrese su numero 2: ");
    resultado = parseInt(numero1)-parseInt(numero2); //parseInt convierte a entero las variables
    console.log("Resultado :" + resultado);
}

function multiplicar(){
    let numero1 = prompt("ingrese su numero 1: "); //prompt solo recibe string
    let numero2 = prompt("ingrese su numero 2: ");
    resultado = parseInt(numero1)*parseInt(numero2); //parseInt convierte a entero las variables
    console.log("Resultado :" + resultado);
}

function dividir(){
    let numero1 = prompt("ingrese su numero 1: "); //prompt solo recibe string
    let numero2 = prompt("ingrese su numero 2: ");
    resultado = parseInt(numero1)/parseInt(numero2); //parseInt convierte a entero las variables
    console.log("Resultado :" + resultado);
}

function moduloResiduo(){
    let numero1 = prompt("ingrese su numero 1: "); //prompt solo recibe string
    let numero2 = prompt("ingrese su numero 2: ");
    resultado = parseInt(numero1)%parseInt(numero2); //parseInt convierte a entero las variables
    console.log("Resultado :" + resultado);
}

function operacionAleatoria(){
    let resultado = 2*100+50/30; // se aplica la jerarquia de operaciones matemáticas * / + -
    console.log("🚀 ~ operacionAleatoria ~ resultado: \n", resultado) // para crear un salto de linea \n 
}

function evaluarDosValores(){
    let numero1 = prompt("ingrese su numero 1: "); 
    let numero2 = prompt("ingrese su numero 2: ");
    console.log("Numero 1 es mayor que numero 2:" + (parseInt(numero1)>parseInt(numero2)));
    console.log("Numero 2 es mayor que numero 1:" + (parseInt(numero2)>parseInt(numero1)));
    console.log("Numero 2 es igual que numero 1:" + (parseInt(numero2)===parseInt(numero1)));
    console.log("Numero 2 es diferente que numero 1:" + (parseInt(numero2)!==parseInt(numero1)));
}

function esIgual(){
    let numero1 = prompt("ingrese su numero 1: "); 
    let numero2 = prompt("ingrese su numero 2: ");
    console.log("Numero 2 es igual que numero 1:" + (parseInt(numero2)==(numero1)));
    console.log("Numero 2 es igual que numero 1:" + (parseInt(numero2)===(numero1)));
}

function esIgual(){
    let numero1 = prompt("ingrese su numero 1: "); 
    let numero2 = prompt("ingrese su numero 2: ");
    console.log("Numero 2 es igual que numero 1:" + (parseInt(numero2)==(numero1)));
    console.log("Numero 2 es igual que numero 1:" + (parseInt(numero2)===(numero1)));
}                

function comparaciones(){
    console.log("true&&true : " + (true&&true));
    console.log("true&&false : " + (true&&false));
    console.log("false&&true : " + (false&&true));
    console.log("false&&false : " + (false&&false));
    console.log("true||true : " + (true||true));
    console.log("true||false : " + (true||false));
    console.log("false||true : " + (false||true));
    console.log("false||false : " + (false||false));
    console.log("no false :" + !false);
    console.log("no true : "+ !true);
}


