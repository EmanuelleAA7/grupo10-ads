
package telas;

import controller.Atualizacao;
import java.awt.Point;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import logs.CriarLog;
import logs.Log;
import logs.Log.LogType;

public class HardwareList extends javax.swing.JFrame {

    private Point point = new Point();
    private Log logger = new Log();      

    public HardwareList() {
        initComponents();
        
        final long time =1000;
        Timer timer = new Timer();
        TimerTask tarefa = new TimerTask() {
            public void run() {
                try {
                    logger.write(LogType.INFO, "Atualizando componentes...");
                    Atualizacao att = new Atualizacao();
                    att.atualizar();
                    logger.write(LogType.INFO, "Componentes atualizados");
                    lbSO.setText(att.getSo());
                    lbProcessador.setText(att.getProcesso());
                    System.out.println(att.getCpu());
                    if(!att.getCpu().equals("0,0%")){
                        lbCpu.setText(att.getCpu());
                        logger.write(LogType.INFO, "Informação da CPU :" + att.getCpu());
                    }
                    lbRamDisp.setText(att.getRamDisp());
                    logger.write(LogType.INFO, "Ram disponível: " + att.getRamDisp());
                    lbRamTotal.setText(att.getRamTotal());
                    lbDisco.setText(att.getDisco());
                    logger.write(LogType.INFO, "Disco: " + att.getDisco());
                    
                    att.insereBanco(att);

                } catch (Exception e) {
                        e.printStackTrace();
                }

            }
	};
            timer.scheduleAtFixedRate(tarefa, time, time);
    
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbRamTotal = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbRamDisp = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbCpu = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbDisco = new javax.swing.JLabel();
        lbSO = new javax.swing.JLabel();
        lbProcessador = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel5.setText("Disco:");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_pin_3_32px_1.png"))); // NOI18N

        lbRamTotal.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        lbRamTotal.setText("0");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_pin_3_32px_1.png"))); // NOI18N

        lbRamDisp.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        lbRamDisp.setText("0");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_pin_3_32px_1.png"))); // NOI18N

        lbCpu.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        lbCpu.setText("0");

        jLabel13.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel13.setText("% CPU:");

        lbDisco.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        lbDisco.setText("0");

        lbSO.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        lbSO.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSO.setText("...");

        lbProcessador.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        lbProcessador.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbProcessador.setText("...");

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel1.setText("Sistema Operacional:");

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel2.setText("Processador:");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_pin_3_32px_1.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel3.setText("RAM Total:");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_pin_3_32px_1.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel4.setText("RAM disponível:");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8_pin_3_32px_1.png"))); // NOI18N

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(lbSO, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(93, 93, 93))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel8)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(77, 77, 77))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                    .addGap(93, 93, 93)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbRamDisp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbProcessador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                                .addComponent(lbRamTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel13)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(lbSO))
                    .addComponent(jLabel6))
                .addGap(0, 395, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(181, 181, 181)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lbProcessador, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel8))
                    .addGap(43, 43, 43)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbRamTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(48, 48, 48))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(43, 43, 43)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbRamDisp, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(43, 43, 43)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(lbCpu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(36, 36, 36)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(lbDisco, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jLabel9)))
                        .addComponent(jLabel10))
                    .addContainerGap(28, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    
    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
          point.x=evt.getX();
          point.y=evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        Point p = this.getLocation();
        this.setLocation(p.x + evt.getX() - point.x , p.y +evt.getY() - point.y);
    }//GEN-LAST:event_formMouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CriarLog criar = new CriarLog(logger.getLog());
        criar.executar();
        JOptionPane.showMessageDialog(null, "Um log dessa execução foi criado em: " + criar.getArquivo());
         System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HardwareList().setVisible(true);
            }
        });
    }
   
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbCpu;
    private javax.swing.JLabel lbDisco;
    private javax.swing.JLabel lbProcessador;
    private javax.swing.JLabel lbRamDisp;
    private javax.swing.JLabel lbRamTotal;
    private javax.swing.JLabel lbSO;
    // End of variables declaration//GEN-END:variables
}
