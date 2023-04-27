/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import esper.Config;
import events.PowerEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Youssef Negm
 */
public class KettleView extends javax.swing.JFrame {

    /**
     * Creates new form KettleView
     */
    public KettleView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        currentTempTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ledStatusTxt = new javax.swing.JTextField();
        onBtn = new javax.swing.JButton();
        offBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel1.setText("Current Temp");

        currentTempTxt.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        currentTempTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        currentTempTxt.setText("18");
        currentTempTxt.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Led Status");

        ledStatusTxt.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        ledStatusTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ledStatusTxt.setText("OFF");
        ledStatusTxt.setEnabled(false);

        onBtn.setText("ON");
        onBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                onBtnActionPerformed(evt);
            }
        });

        offBtn.setText("OFF");
        offBtn.setEnabled(false);
        offBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(onBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(currentTempTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ledStatusTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(offBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentTempTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ledStatusTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(onBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(offBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_onBtnActionPerformed
        Config.sendEvent(new PowerEvent(true));
    }//GEN-LAST:event_onBtnActionPerformed

    private void offBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offBtnActionPerformed
        Config.sendEvent(new PowerEvent(false));
    }//GEN-LAST:event_offBtnActionPerformed

    public JTextField getCurrentTempTxt() {
        return currentTempTxt;
    }

    public JTextField getLedStatusTxt() {
        return ledStatusTxt;
    }

    public JButton getOffBtn() {
        return offBtn;
    }

    public JButton getOnBtn() {
        return onBtn;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField currentTempTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField ledStatusTxt;
    private javax.swing.JButton offBtn;
    private javax.swing.JButton onBtn;
    // End of variables declaration//GEN-END:variables
}