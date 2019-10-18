
package com.mycompany.cerberus;

import java.time.LocalDateTime;
import java.util.TimerTask;
import org.springframework.jdbc.core.JdbcTemplate;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
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
        this.processador = cp.toString();
        
        GlobalMemory memory = hal.getMemory();
        this.ramTotal = FormatUtil.formatBytes(memory.getTotal()) ;     
//      this.ramDisp = FormatUtil.formatBytes(memory.getAvailable()) ;
        long tot = memory.getTotal();
        long disp = memory.getAvailable();
        this.ramDisp = String.format("%.1f%%", 100 - (100d * disp/tot));
            
        long[] prevTicks = cp.getSystemCpuLoadTicks();
        Util.sleep(2000);
        this.cpu = String.format("%.1f%%", cp.getSystemCpuLoadBetweenTicks(prevTicks) * 100);
        
        //falta disco

        FileSystem fileSystem = os.getFileSystem();
        OSFileStore[] fsArray = fileSystem.getFileStores();
        String hdUsando = "";
            for (OSFileStore fs : fsArray) {
                long usable = fs.getUsableSpace();
                long total = fs.getTotalSpace();
                hdUsando = (String.format("%.1f%% em uso",
                        100 - (100d * usable / total)));
            }
        this.disco = hdUsando;

        
       

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
