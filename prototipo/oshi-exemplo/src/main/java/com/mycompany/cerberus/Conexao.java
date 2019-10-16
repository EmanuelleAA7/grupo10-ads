
package com.mycompany.cerberus;

import javax.swing.JOptionPane;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexao {
    
   private BasicDataSource dataSource;
   
   public Conexao(){
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //exemplo para MySql: "com.mysql.cj.jdbc.Driver"
        dataSource.setUrl("jdbc:sqlserver://srvcerberus.database.windows.net:1433;database=bdcerberus;user=usercerberus@srvcerberus;password={#Gfgrupo10};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        // exemplo para MySql: "jdbc:mysql://localhost:3306/meubanco"
        dataSource.setUsername("usercerberus");
        dataSource.setPassword("#Gfgrupo10");
       
   }
   
    public BasicDataSource getDataSource(){
        
//        JOptionPane.showMessageDialog(null,"Conectado com sucesso");
        return dataSource;
    }
   
}
