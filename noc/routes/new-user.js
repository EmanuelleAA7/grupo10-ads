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
var cnpj = req.body.cnpj;
var nomeEmpresa = req.body.nomeEmpresa;
var rua = req.body.rua;
var numero = req.body.numero;
var cep = req.body.cep;
var cidade = req.body.cidade;
var estado = req.body.estado;
var telefone = req.body.telefone;
var email = req.body.email;


},
function cadastrar(cnpj,rua,nomeEmpresa,cep,cidade,estado,telefone,email){
    banco.query(`insert into tbEmpresa (nomeEmpresa,cnpj,rua,numero,cep,cidade,estado,telefone,email) values
                (${nomeEmpresa},${cnpj},${rua},${numero},${cep},${cidade},${estado},${telefone},${email})`),function(err,result){
                  if(!err){
                    console.log('Usuario cadastrado com sucesso');
                  }else{
                    onsole.log('erro ao cadastrar')
    }
  }
}








).then((consulta)=>{
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
