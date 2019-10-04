
package com.mycompany.sqlconexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {
    
    public static Statement stm;
    public static ResultSet rs;
    private final String driver="com.mssql.Driver";
    private final String url="jdbc:sqlserver://servidor01191066.database.windows.net:1433;database=teste;user=GF01191066@servidor01191066;password={#Gf50086194895};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    public Connection con;
    
    public void conecta(){
       
        try{
              System.setProperty("jdbc.Drivers",driver);
              con = DriverManager.getConnection(url);  
              JOptionPane.showMessageDialog(null, "Conectado com sucesso");
        }
        catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null,"Erro de conexão"+ ex.getMessage());
        
        }
        
    }
    
       public void manipularSQL(String sql){
        
        try{
            stm = con.createStatement(rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_READ_ONLY);
            stm.execute(sql);
            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro de Acesso" + ex.getMessage());
            
        }
        
    }
    
}
