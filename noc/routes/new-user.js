var express = require('express');
var router = express.Router();
var banco = require('../app-banco');

router.post('/cadastrar',(req,res,next)=>{
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

    console.log('iniciando conexão com o banco');
    banco.conectar().then(async ()=>{
        try{
            const resultado = await new banco.sql.Request()
            .input('nomeEmpresa', nomeEmpresa)
            .input('cnpj', banco.sql.Int, cnpj)//esta zuada
            .input('rua', rua)
            .input('numero', banco.sql.Int, numero)
            .input('cep', banco.sql.Int, cep)
            .input('cidade', cidade)
            .input('estado', estado)
            .input('telefone', banco.sql.Int, telefone)
            .input('email', email)
            .query('INSERT INTO tbEmpresa (nomeEmpresa,cnpj,rua,numero,cep,cidade,estado,telefone,email) VALUES (@nomeEmpresa, @cnpj, @rua , @numero, @cep, @cidade, @estado, @telefone , @email)');

            console.log('Linhas afetadas', resultado.rowsAffected);

            res.send(resultado);
        }catch(e) {
            console.log("Erro no request \n", e);
        };
	banco.sql.close();
    });
});

module.exports = router;