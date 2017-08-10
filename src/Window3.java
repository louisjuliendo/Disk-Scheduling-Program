import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Window3 extends JFrame {
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JLabel jlbl = new JLabel("Disk requests: ");
    JLabel jlbl2 = new JLabel();
    JButton jbtNext = new JButton("Next");
    JScrollPane scr = new JScrollPane(panel); //scrollbar add to panel 1
    
    int send;
    boolean CSCAN, LOOK, CLOOK;
    
    JTextField [] jtxfRequest;
    int [] noms;
    
    
    public Window3(){
        jbtNext.addActionListener(new ButtonListener());
    }
    
    public Window3 (int numofDiskRequests, int end, boolean selectionCSCAN, boolean selectionLOOK, boolean selectionCLOOK){
        send = end;
        CSCAN = selectionCSCAN;
        LOOK = selectionLOOK;
        CLOOK = selectionCLOOK;
        jtxfRequest = new JTextField[numofDiskRequests];
        
        panel.setPreferredSize(new Dimension(300,500));
        panel.add(jlbl);
        panel.add(jlbl2);
        
        for (int i = 0; i < numofDiskRequests; i++) {
            panel.add(new JLabel("Request " + (i + 1) + ":"));
            panel.add(jtxfRequest[i] = new JTextField(2));
            panel.setLayout(new GridLayout(0,2));
        }
        
        panel2.add(jbtNext);
       
        jbtNext.addActionListener(new ButtonListener());
        
        Font f= new Font ("Arial Unicode MS", Font.PLAIN, 14);
        jbtNext.setFont(f);
        jlbl.setFont(f);
        panel.setFont(f);
       
        scr.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); //Scrollbar will appear if needed
        scr.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //Never show horizontal scrollbar
        scr.setSize(50,100);
        
        add(scr,BorderLayout.CENTER);
        
        add(panel2, BorderLayout.SOUTH);
        
        
    }
    
    public boolean contains(int[] array, int val) { //check range for DR eg num cylinder 200 cant enter DR greater than 199
        boolean result = false;

        for(int i : array){ //for each loop
            if(i >= val-1){
                result = true;
                break;
            }
        }
        return result;
    }
    
    public boolean containsOne(int[] array, int val) { //check request must be greater than 0
        boolean result = false;

        for(int i : array){
            if(i <= val){
                result = true;
                break;
            }
        }
        return result;
    }
    
    public boolean checkLoop(){ //check any similar disk request
        for (int i = 0; i < noms.length-1; i++){ //eg size 8 check 0-6
            for (int j = 1; j < noms.length; j++){ //eg size check 1-7
                if(((noms[i]==noms[j])) && (i != j) ){
                   JOptionPane.showMessageDialog(null, "Request of \" " + noms[j] 
                           + " \" cannot be the same.", "Error", JOptionPane.ERROR_MESSAGE);
                   return true;
                }   
            }
        }
        
        return false;
    }
    
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            noms = new int [jtxfRequest.length]; //number of DR store in noms (array how many elements)
            try{
                for (int i = 0; i < jtxfRequest.length; i++){
                    noms [i] = Integer.parseInt(jtxfRequest[i].getText());
                }
            

                if (contains(noms, send)){
                    JOptionPane.showMessageDialog(null, "Request must be below the range of cylinders.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else if(containsOne(noms, 0)){
                    JOptionPane.showMessageDialog(null, "Request must be greater than zero.", "Error", JOptionPane.ERROR_MESSAGE);
                    
                }
                else if (checkLoop()){
                }
                else{
                    Window4 w4 = new Window4(noms, send, CSCAN, LOOK, CLOOK);
                    w4.setVisible(true);
                    w4.setSize(340,350);
                    w4.setLocationRelativeTo(null);
                    dispose();
                }
            }
        catch (Exception ex){ //not integer, empty
            JOptionPane.showMessageDialog(null, "Please enter valid numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
    }
}

