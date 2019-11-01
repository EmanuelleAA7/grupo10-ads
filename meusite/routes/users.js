var express = require('express');
var router = express.Router();
var nodemailer = require('nodemailer');
var stringify = require('json-stringify-safe');

/* GET users listing. */
router.get('/', function(req, res, next) {
  res.send('respond with a resource');
});


router.post('/entrar',(req,res,next)=>{
  var empresa = req.body.nameEmpresa;
  var cnpj = req.body.cnpj;
  var email = req.body.email;
  var representante = req.body.nameRepresentante;
  var emailRepresentante = req.body.emailRepresentante;
  var telefone = req.body.phone;
  
  
  var transporter = nodemailer.createTransport({
    service: 'gmail',
    auth: {
      user: 'emanuelle.araujoa7@gmail.com',
      pass: 'adrinelle'
    }
  });
  
  var mailOptions = {
    from: 'emanuelle.araujoa7@gmail.com',
    to: 'giuliamaia2@gmail.com',
    subject: 'Pré Cadastro- Novo Cliente',
    text: 'Informações : blablabla'
  };
  
  
  return transporter.sendMail(mailOptions, function(error, info){
    if (error) {
      console.log("erro: "+error);
      // return res.send({ "ok": false });
      res.status(500).json({ "ok": false });
    } else {
      console.log('Email sent: ' + info.response);
      // return res.send({ "ok": true, "info": info });
      res.status(200).json({ "ok": true, "info": info });
    }
  });
});


module.exports = router;
