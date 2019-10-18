
package com.mycompany.cerberus;


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
    
    public String run(){
        String retorno = "";
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();
        OperatingSystem os = si.getOperatingSystem();
        listarProcessos(os, hal.getMemory());
        
        return informacoes;
    }
    
    
    private static void listarProcessos(OperatingSystem os, GlobalMemory memory) {
        informacoes += ("\n Processes: " + os.getProcessCount() + ", Threads: " + os.getThreadCount());
        // Sort by highest CPU
        List<OSProcess> procs = Arrays.asList(os.getProcesses(20, OperatingSystem.ProcessSort.CPU));

        informacoes +=("\n   PID  %CPU %MEM       VSZ       RSS Name");
        for (int i = 0; i < procs.size() && i < 20; i++) {
            OSProcess p = procs.get(i);
            informacoes +=(String.format("\n %5d %5.1f %4.1f %9s %9s %s", p.getProcessID(),
                    100d * (p.getKernelTime() + p.getUserTime()) / p.getUpTime(),
                    100d * p.getResidentSetSize() / memory.getTotal(), FormatUtil.formatBytes(p.getVirtualSize()),
                    FormatUtil.formatBytes(p.getResidentSetSize()), p.getName()));
        }
        informacoes +=("\n");
    }
    
    
    
}
