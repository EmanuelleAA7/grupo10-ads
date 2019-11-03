var express = require('express');
var router = express.Router();
var banco = require('../app-banco');

  router.post('/cadastrar',(req,res,next)=>{
         console.log(`Chegou para registro.`);
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

 banco.conectar().then(()=>{



   return banco.query(`insert into tbEmpresa (nomeEmpresa,cnpj,rua,numero,cep,cidade,estado,telefone,email) values
                ('${nomeEmpresa}',${cnpj},'${rua}',${numero},${cep},'${cidade}','${estado}',${telefone},'${email}')`),function(err,result){
                  if(!err){
                    console.log('Usuario cadastrado com sucesso');
                  }else{
                    onsole.log('erro ao cadastrar')
    }
  }
}

).then(()=>{
res.send('cadastrou.'); 
res.sendStatus(200);
})
.catch(err=>{
console.log('Erro ao cadastrar: \n', err)
res.sendCode(500);
})
.finally(()=>{
banco.sql.close();
})
});



module.exports = router;
