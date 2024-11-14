const express = require('express')
const router = express.Router()

router.get('/',(req,res)=>{
    res.send('Inicio de Admin')
});

router.get('/usuarios',(req,res)=>{
    res.send('Usuarios del sistema')
});

module.exports = router;