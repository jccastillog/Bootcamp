/* CREAR ELEMENTOS */
const h2 = document.createElement("h2")
h2.innerText="subtitulo"
document.body.appendChild(h2)

/* QUITAR ELEMENTOS */
const h1 = document.getElementById("idtitulo")
//h1.remove()
//h1.parentNode.removeChild(h1)

/* MODIFICAR STYLE */
const img = document.getElementById('idimg')
img.style.width="200px"

/* CAMBIAR IMAGEN */
function cambiarimagen(){
    if(img.src.includes("../Practica2css/img/692-800x500.jpg")){
        img.src="../Practica2css/img/46-800x500.jpg"
    }else {
        img.src = "../Practica2css/img/692-800x500.jpg";
    }
}

/* AGREGAR EVENT LISTENER */
document.getElementById("idboton").addEventListener("click",function(){
    alert("hola");
    document.querySelector("img").classList.toggle("classimg")
})

document.getElementById("iddiv").innerHTML= '<p class="parrafo">Parrafo DESDE JS </p>'

const parrafos = document.getElementsByTagName("p")
for (const parrafo of parrafos) {
    parrafo.innerText="texto desde JS"
    
}

/* SELECCIONA UNO */
document.querySelector(".classp").innerText="Parrafo con Clase"


/* SELECCIONA TODOS */
const parrafos2 = document.querySelectorAll(".classp")
parrafos2.forEach(parrafo =>{
    parrafo.style.color="green"
})


const valor = document.querySelector("#iddiv").getAttribute("data-atributo")
document.getElementById("idresultado").innerText="El resultado es "+valor
