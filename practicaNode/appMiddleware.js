const express = require('express')
const app = express()
const port = 3000

var mi_middleware = (req, res, next) =>{
    console.log('Time:',Date.now())
    next()
}

app.use(mi_middleware)

app.get('/', mi_middleware)

app.use('/ruta',mi_middleware)

app.listen(port,()=>{
    console.log(`Escuchando el puerto ${port}`);
})