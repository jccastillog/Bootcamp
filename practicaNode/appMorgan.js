const express = require('express')
const app = express()
const port = 3000

const morgan = require('morgan')

app.use(morgan('combined'))

app.get('/',(req,res)=>{
    res.send('Aprendiendo Morgan')
});

app.listen(port,()=>{
    console.log(`Escuchando el puerto ${port}`);
})