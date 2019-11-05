var desenvolvimento = false;

var configuracoes = {
    producao: {
        server: "srvcerberus.database.windows.net",
        user: "usercerberus",
        password: "#Gfgrupo10",
        database: "bdcerberus",
        options: {
            encrypt: true
        },
        pool: {
            max: 4,
            min: 1,
            idleTimeoutMillis: 30000
        }
    },
    desenvolvimento: {
        server: "srvcerberus.database.windows.net",
        user: "usercerberus",
        password: "#Gfgrupo10",
        database: "bdcerberus",
        options: {
            encrypt: true
        }
    }
}
 
var sql = require('mssql');
sql.on('error', err => {
    console.error(`Erro de Conex�o: ${err}`);
});

var perfil = desenvolvimento ? 'desenvolvimento' : 'producao';

function conectar() {
  return sql.connect(configuracoes[perfil])
  return new sql.ConnectionPool();  
} 

module.exports = {
    conectar: conectar,
    sql: sql,
    

    
}