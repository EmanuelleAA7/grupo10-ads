var express = require('express');
var router = express.Router();
var banco = require('../app-banco');


router.post('/cadastrar',(req,res,next)=>{
    console.log(`Chegou para registro: ${JSON.stringify(req.body)}`);
            
    // Dados do formulário de login
    var serialNumber = req.body.serialNumber;
    var modelo = req.body.modelo;
    var sistemaOperacional= req.body.sistemaOperacional;
    var hostName = req.body.hostName;
    var processador = req.body.processador;
    var ram = req.body.ram;
    var disco = req.body.disco;
   
    
    console.log('iniciando conexão com o banco');
    banco.conectar().then(async ()=>{
        new sql.ConnectionPool(config).conectar().then(pool => {
        
        try{
            const resultado = await new banco.sql.Request()
            .input('serialNumber', banco.sql.int, serialNumber)
            .input('modelo',modelo)//esta zuada
            .input('sistemaOPeracional', sistemaOperacional)
            .input('hostName', hostName)
            .input('processador', banco.sql.decimal, processador)
            .input('ram', banco.sql.decimal, ram)
            .input('disco', banco.sql.decimal, disco)
            .query('INSERT INTO tbMaquina (serialNumber,modelo,sistemaOperacional, hostName,processador,ram,disco) VALUES (@serialNumber, @modelo, @sistemaOperacional , @hostName, @processador, @ram, @disco)');

            console.log('Linhas afetadas', resultado.rowsAffected);

            res.send(resultado);
        }catch(e) {
            console.log("Erro no request \n", e);
        };
	banco.sql.close();
    });
});

module.exports = router;