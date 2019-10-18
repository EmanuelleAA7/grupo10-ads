
package com.mycompany.cerberus;

import java.util.Map;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class Login {
     
    private String email;
    private String senha;
    private boolean resposta;
    
     Conexao dadosConexao= new Conexao();
    JdbcTemplate jdbcTemplate= new JdbcTemplate(dadosConexao.getDataSource());

    public Login(String email) {
        this.email = email;
//        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public boolean isResposta() {
        return resposta;
    }
    
    
    
    public Map<String, Object> autenticar(String email){
        try {
    Map<String, Object> registro = jdbcTemplate.queryForMap(
    "select * from tbRepresentante where email= ? ",email );
    this.resposta=true;
    return registro;
    } catch (EmptyResultDataAccessException e) {
    return null;
    }

  }
    

    
    
}
