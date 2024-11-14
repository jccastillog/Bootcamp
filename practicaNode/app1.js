const express = require('express')
const app = express()
const port = 3000

app.get('/',(req,res)=>{
    res.send('Aprendiendo Express')
})

var operacion = require("./operaciones");

app.listen(port,()=>{
    console.log(`Escuchando el puerto ${port}`);
/*     console.log('El producto de 4 x 10 es '+operacion.producto(4,10));
    console.log('La suma de 4 + 10 es '+operacion.suma(4,10)); */
    console.log('El producto de 4 x 10 es '+operacion.producto2(4,10));
    console.log('La suma de 4 + 10 es '+operacion.suma2(4,10));
/*     console.log('El producto de 4 x 10 es '+new operacion(4,10).producto);
    console.log('La suma de 4 + 10 es '+new suma(4,10).producto);  */
})