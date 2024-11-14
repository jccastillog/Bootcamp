const express = require('express')
const app = express()
const port = 3000

var admin = require("./admin")

app.use('/admin', admin)

app.get('/',(req,res)=>{
    res.send('Aprendiendo Express')
})

app.listen(port,()=>{
    console.log(`Escuchando el puerto ${port}`);
})