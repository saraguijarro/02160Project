package com.project.GUI;

import com.project.dto.Container;

import javax.swing.*;
import java.awt.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Miguel
 */
public class ContainerStorage extends javax.swing.JFrame {

    /**
     * Creates new form ContainerDatabase
     */
    public ContainerStorage() {
        initComponents();
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JScrollPane jScrollPane1 = new JScrollPane();
        jTable1 = new javax.swing.JTable();
        JButton details = new JButton();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        JButton back = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Containers");
        setPreferredSize(new Dimension(900, 340));

        Object [][] tableBody = Controller.Requests.tableContainerSetter("All", "None");
        String [] tableTitles = new String [] {
                "ID", "Current Position", "Internal Temperature", "Air Humidity", "Atm. Pressure", "Corresponding Journey"
            };
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(tableBody,tableTitles));
        jTable1.setDefaultEditor(Object.class, null);
        jScrollPane1.setViewportView(jTable1);
        
        

        details.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        details.setText("Details");
        details.addActionListener(this::detailsActionPerformed);

        back.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        back.setText("Back");
        back.addActionListener(this::backActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(details)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(details, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailsActionPerformed
        // TODO add your handling code here:
    	int row = jTable1.getSelectedRow();
    	Container c = Controller.company.getContainerDatabase().getContainers().get(row);
    	
    	if (row>-1) {
	    	
	    	CompJourneyContainer_Details.newScreen("container", c);
	        dispose();
    	}
        
        
        
    }//GEN-LAST:event_detailsActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        new CompMainMenu();
        CompMainMenu.newScreen();
        dispose();
    }//GEN-LAST:event_backActionPerformed

    /**
     * 
     */
    
    
    public static void newScreen() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ContainerStorage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new ContainerStorage().setVisible(true));
    }

    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

