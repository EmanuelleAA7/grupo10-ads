/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cerberus;




import java.util.Timer;
import java.util.TimerTask;



/**
 *
 * @author EmanuelleAlves
 */
public class Splash {
    
//    public static final long TEMPO = (1000 * 60);
    
    public static void main(String[] args) {
        Atualizacao att = new Atualizacao();
     
        Splash2 splash = new Splash2();
        splash.setVisible(true);
        TelaLogin start = new TelaLogin();
        try {
            for(int i=0; i<=100 ;i++){
                Thread.sleep(40);
                splash.lblPorcentagem.setText(Integer.toString(i)+ "%");
                splash.pbPorcentagem.setValue(i);
                if(i==100){
                    splash.setVisible(false);
                    start.setVisible(true);
                }
            }
           final long time =60000;
           Timer timer = new Timer();
           TimerTask tarefa = new TimerTask() {
			public void run() {
                               //método
				try {
//					att.atualizar();
                                        System.out.println("teste");
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};
            timer.scheduleAtFixedRate(tarefa, time, time);
            
        } catch (Exception e) {
        }
       
    }
    
    
    
}
