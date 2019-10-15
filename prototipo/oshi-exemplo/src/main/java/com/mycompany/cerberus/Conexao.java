
package com.mycompany.cerberus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexao {
    
//    public static Statement stm;
//    public static ResultSet rs;
//    private final String driver="com.mssql.Driver";
//    private final String url="jdbc:sqlserver://srvcerberus.database.windows.net:1433;database=bdcerberus;user=usercerberus@srvcerberus;password={#Gfgrupo10};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
//    public Connection con;
    
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
        
        JOptionPane.showMessageDialog(null,"Conectado com sucesso");
        return dataSource;
    }
   
    
//    
//    public void conecta(){
//       
//        try{
//              System.setProperty("jdbc.Drivers",driver);
//              con = DriverManager.getConnection(url);  
//              JOptionPane.showMessageDialog(null, "Conectado com sucesso");
//        }
//        catch(SQLException ex){
//            
//            JOptionPane.showMessageDialog(null,"Erro de conexão"+ ex.getMessage());
//             
//        }
//        
//    }
//    
//       public void manipularSQL(String sql){
//        
//        try{
//            stm = con.createStatement(rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_READ_ONLY);
//            stm.execute(sql);
//        }catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Erro de Acesso" + ex.getMessage());
//            
//        }
//        
//    }
    
}
