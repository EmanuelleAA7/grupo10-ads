
package com.mycompany.cerberus;

import java.time.LocalDateTime;
import java.util.TimerTask;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;
import oshi.util.Util;

public class Atualizacao extends TimerTask{
    
    private String so;
    private String processador;
    private String ramTotal;
    private String ramDisp;
    private String cpu;
    private String disco;
    
   Conexao dadosConexao= new Conexao();
   JdbcTemplate jdbcTemplate= new JdbcTemplate(dadosConexao.getDataSource());
    
    
    public void atualizar(){
        SystemInfo si = new SystemInfo();
        OperatingSystem os =  si.getOperatingSystem();
        HardwareAbstractionLayer hal = si.getHardware();
        
        this.so = (String.valueOf(os));   
        
        CentralProcessor cp = hal.getProcessor();
        Util.sleep(1000);
        this.processador = cp.toString();
        
        GlobalMemory memory = hal.getMemory();
        this.ramTotal = FormatUtil.formatBytes(memory.getTotal()) ;     
        this.ramDisp = FormatUtil.formatBytes(memory.getAvailable()) ;
            
        long[] prevTicks = cp.getSystemCpuLoadTicks();
        this.cpu = String.format("%.1f%%", cp.getSystemCpuLoadBetweenTicks(prevTicks) * 100);
        
        //falta disco
        
//        HWDiskStore disco= hal.getDiskStores();
//        this.disco = FormatUtil.formatBytes(disco.get()) ;
       

//falta listar processos

//como vou subir essa listagem pra nuvem? 
    }
    
    public void insereBanco(Atualizacao att){
        
        Double cpu = Double.valueOf(att.getCpu().substring(0,3).replaceAll(",","."));
        Double ram = Double.valueOf(att.getRamDisp().substring(0,4).replaceAll(",","."));
        System.out.println(ram);
        
        Double disco = Double.valueOf(att.getDisco().substring(0,3).replaceAll(",","."));
        
        jdbcTemplate.update("insert into tbLeitura (dataHora, fkMaquina,cpu, ram,disco) values (?,?,?,?,?)",
        LocalDateTime.now(),5,cpu, ram,disco);
        
        System.out.println("funfando");
                
    }

    public String getSo() {
        return so;
    }


    public String getProcesso() {
        return processador;
    }


    public String getRamTotal() {
        return ramTotal;
    }

    public String getRamDisp() {
        return ramDisp;
    }


    public String getCpu() {
        return cpu;
    }
    
    public String getDisco(){
        return disco;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
