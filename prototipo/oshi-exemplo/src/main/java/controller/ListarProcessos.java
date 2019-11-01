
package controller;


import java.util.Arrays;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSProcess;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class ListarProcessos {

    private static String informacoes = "";
    private static String processos = "";
    private static SystemInfo si;
    private static HardwareAbstractionLayer hal;
    private static OperatingSystem os;

    public ListarProcessos() {
        si = new SystemInfo();
        hal = si.getHardware();
        os = si.getOperatingSystem();
    }
     
   
    
    public String runPid(){
        listarProcessos(os, hal.getMemory()); 
        return informacoes;
    }
    
    
    public String runThread(){
        contarProcessos(os, hal.getMemory());
        return processos;
    }
    
    
    private static void listarProcessos(OperatingSystem os, GlobalMemory memory) {
        
        List<OSProcess> procs = Arrays.asList(os.getProcesses(20, OperatingSystem.ProcessSort.CPU));

        for (int i = 0; i < procs.size() && i < 20; i++) {
            OSProcess p = procs.get(i);
            informacoes +=(String.format("%5d              %5.1f                 %4.1f              %9s             %9s                 %s", p.getProcessID(),
                    100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime(),
                    100d * p.getResidentSetSize() / memory.getTotal(), FormatUtil.formatBytes(p.getVirtualSize()),
                    FormatUtil.formatBytes(p.getResidentSetSize()), p.getName()));
            informacoes +="\n";
        }
        informacoes +=("\n");
    }
    
    
    private static void contarProcessos (OperatingSystem os, GlobalMemory memory) {
        processos += ("\n Processos: " + os.getProcessCount() + ",      Threads: " + os.getThreadCount());
    }
    
    
    
}
