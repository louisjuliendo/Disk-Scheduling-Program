
public class Window1 extends javax.swing.JFrame {
    boolean CSCAN, CLOOK, LOOK = false;

    public Window1() {
        initComponents();
        this.setLocationRelativeTo(null);
        radCSCAN.setSelected(true);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radGroup = new javax.swing.ButtonGroup();
        radCSCAN = new javax.swing.JRadioButton();
        radLOOK = new javax.swing.JRadioButton();
        radCLOOK = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Disk Scheduling Algorithm");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);
        setName("Title"); // NOI18N

        radGroup.add(radCSCAN);
        radCSCAN.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        radCSCAN.setText("C-SCAN");
        radCSCAN.setToolTipText("");
        radCSCAN.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        radCSCAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radCSCANActionPerformed(evt);
            }
        });

        radGroup.add(radLOOK);
        radLOOK.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        radLOOK.setText("LOOK");
        radLOOK.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        radGroup.add(radCLOOK);
        radCLOOK.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        radCLOOK.setText("C-LOOK");
        radCLOOK.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnNext.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        btnNext.setText("Next");
        btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Please choose a disk scheduling algorithm:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(radLOOK, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(radCLOOK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(radCSCAN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(161, 161, 161))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radCSCAN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radLOOK)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radCLOOK)
                .addGap(18, 18, 18)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radCSCANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radCSCANActionPerformed

    }//GEN-LAST:event_radCSCANActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
       
        if (radCSCAN.isSelected()){
            CSCAN = true;
        }
        else{
            CSCAN = false;
        }
        
        if (radLOOK.isSelected()){
            LOOK = true;
        }
        else{
            LOOK = false;
        }
        
        if (radCLOOK.isSelected()){
            CLOOK = true;
        }
        else{
            CLOOK = false;
        }
        
        
        Window2 w2 = new Window2(CSCAN, LOOK, CLOOK); //pass data to win2
        w2.setVisible(true);
        w2.setLocationRelativeTo(null);
        w2.setSize(380,320);
        w2.setResizable(false);
        this.dispose();
        
    }//GEN-LAST:event_btnNextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Window1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Window1 w1 = new Window1();
                w1.setVisible(true);
                w1.setResizable(false);
                w1.setSize(410,280);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton radCLOOK;
    private javax.swing.JRadioButton radCSCAN;
    private javax.swing.ButtonGroup radGroup;
    private javax.swing.JRadioButton radLOOK;
    // End of variables declaration//GEN-END:variables
}
