/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cerberus;

/**
 *
 * @author EmanuelleAlves
 */
public class Splash {
    
    public static void main(String[] args) {
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
        } catch (Exception e) {
        }
       
    }
    
    
    
}
