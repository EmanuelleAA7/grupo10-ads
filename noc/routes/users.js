var express = require('express');
var router = express.Router();
var banco = require('../app-banco');

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});

router.post('/entrar',(req,res,next)=>{
  banco.conectar().then(()=>{
    console.log(`Chegou para registro: ${JSON.stringify(req.body)}`);

    // Dados do formulário de login
    var email = req.body.email;
    var senha = req.body.senha;


    return banco.sql.query(`SELECT * FROM tbFuncionario where email = '${email}' and senha='${senha}'`);
  }).then((consulta)=>{
    console.log(consulta.recordset);
    if(consulta.recordset.length == 1){
      res.send(consulta.recordset[0]);
    }else{
      res.sendStatus(404);
    }
  }).catch(err=>{
    console.log(err);
  }).finally(()=>{
    banco.sql.close();
  })
});



module.exports = router;
