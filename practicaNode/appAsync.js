const express = require('express')
const app = express()
const port = 3000

app.listen(port,()=>{
    console.log(`Escuchando el puerto ${port}`);
    console.log("primero")
    console.log("segundo")
    setTimeout(()=>{
        console.log("tercero");
    },5000)

    console.log("cuarto")
})