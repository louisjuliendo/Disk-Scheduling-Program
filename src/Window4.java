import java.util.*;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Window4 extends javax.swing.JFrame {
    ArrayList<Integer> queue = new ArrayList<Integer>();
    int [] request;
    int head,send;
    boolean CSCAN, LOOK, CLOOK;
    boolean begin, end = false;

    public Window4() {
        initComponents();
    }
    
    
    public Window4(int [] array, int end, boolean selectionCSCAN, boolean selectionLOOK, boolean selectionCLOOK){
        initComponents();
        jRadBeginning.setSelected(true);
        CSCAN = selectionCSCAN;
        LOOK = selectionLOOK;
        CLOOK = selectionCLOOK;
        send = end-1;

        request = new int [array.length]; //how many DR
        for (int i=0; i<array.length;i++){
            request[i]=array[i];
        }
    }
    
    public boolean contains(int[] array, int val) { //head and DR cannot be the same
        boolean result = false;

        for(int i : array){ //for each loop in array
            if(i == val){
                result = true;
                break;
            }
        }
        return result;
    }
    
    public boolean checkHeadnEnd (int head, int end){ //head cannot be zero and must be in the range of num of cylinder
        if (head <= 0 || head > end){
            return true;
        }
      
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroupBegEnd = new javax.swing.ButtonGroup();
        jlblArm = new javax.swing.JLabel();
        jtfArm = new javax.swing.JTextField();
        jlblArmDirection = new javax.swing.JLabel();
        jRadBeginning = new javax.swing.JRadioButton();
        jRadEnd = new javax.swing.JRadioButton();
        jbtNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Position and Direction");

        jlblArm.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jlblArm.setText("Current arm position:");

        jtfArm.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jtfArm.setToolTipText("Numeric value only.");
        jtfArm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfArmActionPerformed(evt);
            }
        });

        jlblArmDirection.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jlblArmDirection.setText("Arm Movement Direction:");

        btnGroupBegEnd.add(jRadBeginning);
        jRadBeginning.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jRadBeginning.setText("Towards the beginning of the disk");
        jRadBeginning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadBeginningActionPerformed(evt);
            }
        });

        btnGroupBegEnd.add(jRadEnd);
        jRadEnd.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jRadEnd.setText("Towards the end of the disk");

        jbtNext.setFont(new java.awt.Font("Arial Unicode MS", 0, 14)); // NOI18N
        jbtNext.setText("Next");
        jbtNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadBeginning)
                            .addComponent(jRadEnd)
                            .addComponent(jlblArmDirection)
                            .addComponent(jtfArm, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblArm, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jbtNext, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jlblArm, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfArm, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jlblArmDirection)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadBeginning)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadEnd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jbtNext, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadBeginningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadBeginningActionPerformed
 
    }//GEN-LAST:event_jRadBeginningActionPerformed

    private void jtfArmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfArmActionPerformed
 
    }//GEN-LAST:event_jtfArmActionPerformed

    private void jbtNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNextActionPerformed
        if (CSCAN == true){    
            if (jRadBeginning.isSelected()){
                begin = true; //radio button begin is true
                end = false; // radio button end is false
                if(jtfArm.getText().trim().equals("")){ //trim - remove any space before/after the input
                    JOptionPane.showMessageDialog(null,"Input cannot be empty. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                try{
                int start = 0;
                int head = Integer.parseInt(jtfArm.getText());
                int sum=0;

                Arrays.sort(request); //sort the DR
                    System.out.println(Arrays.toString(request));
                int pos = Arrays.binarySearch(request, head); //to search the position of the head in the DR (where it should be located)
                //-3
                
                    if (contains(request, head)){
                         JOptionPane.showMessageDialog(null, "Current arm position must be different from specified disk request.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(checkHeadnEnd(head, send)){
                         JOptionPane.showMessageDialog(null,"Current arm position cannot be zero and must be different from the specified disk request."
                                + " Please insert a valid input.", "Error", JOptionPane.ERROR_MESSAGE); 
                    }
                    else{
                        pos = -pos-1; //find the position of the head = 2     
                        int left=pos-1; //DR beside head is left
                        int right=pos; //DR beside head is right

                        sum+=Math.abs(head-request[left]); //absolute = no negative

                        queue.add(head); //head add into the array list queue
                        queue.add(request[left]); //add the DR at the left since it is towards beginning

                        while(left>0){ //when there is something at left
                            sum+=Math.abs(request[left]-request[left-1]);
                            queue.add(request[left-1]);
                            left--; //continue move to the left
                        }

                        sum += Math.abs(request[left]-start);
                        queue.add(start); //c-scan will have 0
                        queue.add(send); //total num of cylinder-1 (pass from previous window)
                        sum += Math.abs(start-send);

                        sum+=Math.abs(send-request[request.length-1]);
                        for(int i=request.length-1;i>right;i--){ //go to the last DR from the sorted one before
                            sum+=Math.abs(request[i]-request[i-1]);
                            queue.add(request[i]); //add request to arraylist
                        }
                        queue.add(request[right]); //add the one beside head (the last one)

                        Window5 w5 = new Window5(queue, String.valueOf(sum),head,send, CSCAN, LOOK, CLOOK, begin, end);
                        this.head = Integer.parseInt(jtfArm.getText()); //head in win4
                        this.send = send; //send in win4, current obj in send usually for private, for non-static ONLY
                        w5.setVisible(true);
                        w5.setLocationRelativeTo(null);
                        w5.setSize(415,300);
                        this.dispose();
                    }
                }
                
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                }    
            }
            else if (jRadEnd.isSelected()) {
                begin = false;
                end = true;
                if(jtfArm.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null,"Input cannot be empty. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                try{
                    int start = 0;
                    int head = Integer.parseInt(jtfArm.getText());
                    int sum=0;
                    int arrayLength=request.length;

                    Arrays.sort(request);

                    int pos = Arrays.binarySearch(request, head);
                    
                        if (contains(request, head)){
                             JOptionPane.showMessageDialog(null, "Current arm position must be different from specified disk request.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        else if(checkHeadnEnd(head, send)){
                             JOptionPane.showMessageDialog(null,"Current arm position cannot be zero and must be different from the specified disk request."
                                    + " Please insert a valid input.", "Error", JOptionPane.ERROR_MESSAGE); 
                        }
                        else{
                            pos = -pos-1;
                            int left=pos-1;
                            int right=pos;

                            sum+=Math.abs(head-request[right]);
                            queue.add(head);
                            queue.add(request[right]);
                            while(right<arrayLength-1){
                                sum+=Math.abs(request[right]-request[right+1]);         
                                queue.add(request[right+1]);
                                right++;
                            }

                            sum += Math.abs(request[request.length-1]-send);
                            queue.add(send);
                            queue.add(start);
                            sum += Math.abs(send-start);
                            sum+=Math.abs(start-request[0]);
                            for(int i=0;i<left;i++){
                                queue.add(request[i]);
                                sum+=Math.abs(request[i]-request[i+1]);
                            }
                            queue.add(request[left]);

                        Window5 w5 = new Window5(queue, String.valueOf(sum),head,send, CSCAN, LOOK, CLOOK, begin, end);
                        this.head = Integer.parseInt(jtfArm.getText());
                        this.send = send; 
                        w5.setVisible(true);
                        w5.setLocationRelativeTo(null);
                        w5.setSize(415,300);
                        this.dispose();
                            
                        }
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                } 

            }
        }
    
        else if (LOOK == true){
            if (jRadBeginning.isSelected()){
                begin = true;
                end = false;
                if(jtfArm.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null,"Input cannot be empty. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                try{
                    int head = Integer.parseInt(jtfArm.getText());
                    int sum = 0;
                    int arrayLength = request.length;

                    Arrays.sort(request);

                    int pos = Arrays.binarySearch(request, head);

                    if (contains(request, head)){
                                 JOptionPane.showMessageDialog(null, "Current arm position must be different from specified disk request.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(checkHeadnEnd(head, send)){
                         JOptionPane.showMessageDialog(null,"Current arm position cannot be zero and must be different from the specified disk request."
                                + " Please insert a valid input.", "Error", JOptionPane.ERROR_MESSAGE); 
                    }
                    else{
                        pos = -pos - 1;
                        int left = pos - 1;
                        int right = pos;

                        sum += Math.abs(head - request[left]);
                        queue.add(head);
                        queue.add(request[left]);
                        while (0 < left) {
                            sum += Math.abs(request[left] - request[left - 1]);
                            queue.add(request[left-1]);
                            left--;
                        }

                        sum += Math.abs(request[0] - request[right]); //look from first DR to the one at the right of the head position

                        for(int i=right;i<arrayLength-1;i++){ 
                            sum += Math.abs(request[i] - request[i + 1]);
                            queue.add(request[i]);
                        }

                        queue.add(request[arrayLength-1]);

                        Window5 w5 = new Window5(queue, String.valueOf(sum),head,send, CSCAN, LOOK, CLOOK, begin, end);
                        this.head = Integer.parseInt(jtfArm.getText());
                        this.send = send; 
                        w5.setVisible(true);
                        w5.setLocationRelativeTo(null);
                        w5.setSize(415,300);
                        this.dispose();
                    }
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

            else if (jRadEnd.isSelected()){
                begin = false;
                end = true;
                if(jtfArm.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null,"Input cannot be empty. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                try{
                    int sum=0;
                    int arrayLength=request.length;
                    int head = Integer.parseInt(jtfArm.getText());

                    Arrays.sort(request);

                    int pos = Arrays.binarySearch(request, head);
                    
                    if (contains(request, head)){
                                 JOptionPane.showMessageDialog(null, "Current arm position must be different from specified disk request.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(checkHeadnEnd(head, send)){
                         JOptionPane.showMessageDialog(null,"Current arm position cannot be zero and must be different from the specified disk request."
                                + " Please insert a valid input.", "Error", JOptionPane.ERROR_MESSAGE); 
                    }
                    else{
                        pos = -pos-1;
                        int left=pos-1;
                        int right=pos;

                        sum+=Math.abs(head-request[right]);
                        queue.add(head);
                        queue.add(request[right]);
                        while(right<arrayLength-1){
                            sum+=Math.abs(request[right]-request[right+1]);
                            queue.add(request[right+1]);
                            right++;
                        }

                        sum+=Math.abs(request[arrayLength-1]-request[left]); //from last DR to the one at the left of the head

                        for(int i=left;i>0;i--){
                            sum += Math.abs(request[i] - request[i - 1]);
                            queue.add(request[i]);
                        }

                        queue.add(request[0]);

                        Window5 w5 = new Window5(queue, String.valueOf(sum),head,send, CSCAN, LOOK, CLOOK, begin, end);
                        this.head = Integer.parseInt(jtfArm.getText());
                        this.send = send; 
                        w5.setVisible(true);
                        w5.setLocationRelativeTo(null);
                        w5.setSize(415,300);
                        this.dispose();
                    }
            
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
            
        else if (CLOOK == true){
            if (jRadBeginning.isSelected()) {
                begin = true;
                end = false;
                if(jtfArm.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null,"Input cannot be empty. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
                try{
                    int head = Integer.parseInt(jtfArm.getText());
                    int sum = 0;

                    Arrays.sort(request);

                    int pos = Arrays.binarySearch(request, head);
                    
                    if (contains(request, head)){
                                 JOptionPane.showMessageDialog(null, "Current arm position must be different from specified disk request.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(checkHeadnEnd(head, send)){
                         JOptionPane.showMessageDialog(null,"Current arm position cannot be zero and must be different from the specified disk request."
                                + " Please insert a valid input.", "Error", JOptionPane.ERROR_MESSAGE); 
                    }
                    else{
                        pos = -pos - 1;
                        int left = pos - 1;
                        int right = pos;

                        sum+=Math.abs(head-request[left]);
                        queue.add(head);
                        queue.add(request[left]);

                        while (left > 0) {
                            sum += Math.abs(request[left] - request[left - 1]);
                            queue.add(request[left - 1]);
                            left--;
                        }

                        sum += Math.abs(request[left] - request[request.length - 1]); //loop to the most left and minus with the last DR

                        for (int i = request.length - 1; i > right; i--) { //from the last DR loop to the one at the right of the head
                            sum += Math.abs(request[i] - request[i - 1]);
                            queue.add(request[i]);
                        }
                        queue.add(request[right]);

                        Window5 w5 = new Window5(queue, String.valueOf(sum),head,send, CSCAN, LOOK, CLOOK, begin, end);
                        this.head = Integer.parseInt(jtfArm.getText());
                        this.send = send; 
                        w5.setVisible(true);
                        w5.setLocationRelativeTo(null);
                        w5.setSize(415,300);
                        this.dispose();
                    }
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                }
 
            } 
            else if (jRadEnd.isSelected()) {
                begin = false;
                end = true;
                if(jtfArm.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(null,"Input cannot be empty. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                try{
                    int head = Integer.parseInt(jtfArm.getText());
                    int sum = 0;
                    int arrayLength = request.length;

                    Arrays.sort(request);

                    int pos = Arrays.binarySearch(request, head);

                    if (contains(request, head)){
                                 JOptionPane.showMessageDialog(null, "Current arm position must be different from specified disk request.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(checkHeadnEnd(head, send)){
                         JOptionPane.showMessageDialog(null,"Current arm position cannot be zero and must be different from the specified disk request."
                                + " Please insert a valid input.", "Error", JOptionPane.ERROR_MESSAGE); 
                    }
                    else{
                        pos = -pos - 1;
                        int left = pos - 1;
                        int right = pos;

                        sum += Math.abs(head - request[right]); 
                        queue.add(head);
                        queue.add(request[right]);
                        while (right < arrayLength - 1) {
                            sum += Math.abs(request[right] - request[right + 1]);
                            queue.add(request[right+1]);
                            right++;
                        }

                        sum += Math.abs(request[right] - request[0]); //minus the one at the most right (the last DR) with the start DR
                        for (int i = 0; i < left; i++) {
                            sum += Math.abs(request[i] - request[i + 1]);
                            queue.add(request[i]);
                        }
                        queue.add(request[left]);

                        Window5 w5 = new Window5(queue, String.valueOf(sum),head,send, CSCAN, LOOK, CLOOK, begin, end);
                        this.head = Integer.parseInt(jtfArm.getText());
                        this.send = send; 
                        w5.setVisible(true);
                        w5.setLocationRelativeTo(null);
                        w5.setSize(415,300);
                        this.dispose();
                    }
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter valid numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jbtNextActionPerformed

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
            java.util.logging.Logger.getLogger(Window4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGroupBegEnd;
    private javax.swing.JRadioButton jRadBeginning;
    private javax.swing.JRadioButton jRadEnd;
    public javax.swing.JButton jbtNext;
    private javax.swing.JLabel jlblArm;
    private javax.swing.JLabel jlblArmDirection;
    private javax.swing.JTextField jtfArm;
    // End of variables declaration//GEN-END:variables
}
