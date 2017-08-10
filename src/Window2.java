import javax.swing.*;
public class Window2 extends javax.swing.JFrame {
    
    boolean CSCAN, LOOK, CLOOK;

     
    public Window2() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public Window2(boolean selectionCSCAN, boolean selectionLOOK, boolean selectionCLOOK){ //data from win1
        initComponents();
        CSCAN = selectionCSCAN;
        LOOK = selectionLOOK;
        CLOOK = selectionCLOOK;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblNum = new javax.swing.JLabel();
        jtxtNum = new javax.swing.JTextField();
        jbtnNext = new javax.swing.JButton();
        jlblCylinder = new javax.swing.JLabel();
        jtxfCylinder = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Disk Information");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setSize(new java.awt.Dimension(500, 500));

        jlblNum.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jlblNum.setText("Number of Disk Requests:");

        jtxtNum.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jtxtNum.setToolTipText("Numeric value only.");
        jtxtNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNumActionPerformed(evt);
            }
        });

        jbtnNext.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jbtnNext.setText("Next");
        jbtnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNextActionPerformed(evt);
            }
        });

        jlblCylinder.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jlblCylinder.setText("Total Number of Cylinders:");

        jtxfCylinder.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jtxfCylinder.setToolTipText("Numeric value only.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jlblCylinder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlblNum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(jtxfCylinder, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(1, 1, 1)
                            .addComponent(jtxtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(106, 106, 106))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jtxfCylinder, jtxtNum});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jlblNum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jlblCylinder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxfCylinder, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jbtnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNumActionPerformed
  
    }//GEN-LAST:event_jtxtNumActionPerformed

    private void jbtnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNextActionPerformed
     
        if (jtxtNum.getText().trim().equals("")||
            jtxfCylinder.getText().trim().equals("")){ //remove any space before and after the input
            JOptionPane.showMessageDialog(null,"Input cannot be empty, Please try again!", "Error", JOptionPane.ERROR_MESSAGE);
            jtxtNum.setText("");
            jtxfCylinder.setText("");
        }
        else{
            try{
                int num = Integer.parseInt(jtxtNum.getText().trim());
                int end = Integer.parseInt(jtxfCylinder.getText().trim());
            
        if (num<=0){
            JOptionPane.showMessageDialog(null,"Number of disk requests must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
            //null in JOptionPane is the default, null is the parent component which determines the frame the dialog is displayed
            jtxtNum.setText("");
            jtxfCylinder.setText("");
        }
        else {
            if (end<=0){
                JOptionPane.showMessageDialog(null,"Total number of cylinders must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
                jtxtNum.setText("");
                jtxfCylinder.setText("");
            }
        else {
                if (end<=num+2){ //check num of cylinders (must be greater than num of diskrequest+2)
                    JOptionPane.showMessageDialog(null,"Total number of cylinders is too less.  "
                            + "Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                    jtxtNum.setText("");
                    jtxfCylinder.setText("");
                }
                else{
                     Window3 w3 = new Window3(num, end, CSCAN, LOOK, CLOOK); //pass to win3
                    w3.setVisible(true);
                    w3.setSize(300, 400);
                    w3.setLocationRelativeTo(null); 
                    w3.setResizable(true);
                    w3.setTitle("Disk Requests");
                    this.dispose();
                }
        }
        }}
        catch (Exception ex){
            JOptionPane.showMessageDialog(null,"Please enter valid numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
            jtxtNum.setText("");
            jtxfCylinder.setText("");
        }
        }
    }//GEN-LAST:event_jbtnNextActionPerformed
    
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
            java.util.logging.Logger.getLogger(Window2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        //Window4 w4 = new Window4(num, end);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window2().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jbtnNext;
    private javax.swing.JLabel jlblCylinder;
    private javax.swing.JLabel jlblNum;
    public javax.swing.JTextField jtxfCylinder;
    public static javax.swing.JTextField jtxtNum;
    // End of variables declaration//GEN-END:variables
}
