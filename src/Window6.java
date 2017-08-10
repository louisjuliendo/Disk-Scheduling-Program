import java.awt.*;
import java.awt.event.*;
import java.io.File;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import java.util.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;

public class Window6 extends JFrame {

    int[] queue;
    int[] sorted;

    int head;
    int end;
    boolean CSCAN, LOOK, CLOOK;
    boolean beginCheck, endCheck = false;
    
    JButton save = new JButton("Save");
    
    JFreeChart chart;

    public Window6() {
        initUI();
    }
    
    public Window6(int[] queue, int[] sorted,int head,int send,boolean selectionCSCAN, boolean selectionLOOK, boolean selectionCLOOK, boolean sbegin, boolean ssend) {
        this.queue = queue;
        this.sorted = sorted;
        this.head = head;
        this.end = send;
        CSCAN = selectionCSCAN;
        LOOK = selectionLOOK;
        CLOOK = selectionCLOOK;
        beginCheck = sbegin;
        endCheck = ssend;
        //pass and load all these data before loading the initUI method
        initUI();
    }


    private void initUI() {
        XYDataset dataset = createDataset(queue, sorted, head,end); //data that will be plotted in the graph
        JFreeChart chart = createChart(dataset); //dataset put in the chart
        ChartPanel chartPanel = new ChartPanel(chart); //put the chart in panel
        JPanel savePanel = new JPanel(); 
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); //to set the gap of the graph with the chart panel
        chartPanel.setBackground(Color.white);
        add(chartPanel, BorderLayout.CENTER);
        Font f= new Font ("Arial Unicode MS", Font.PLAIN, 14);
        save.setFont(f);
        savePanel.add(save);
        add(savePanel, BorderLayout.SOUTH);
        
        pack(); //fit everything into the frame
        setTitle("Graph");
        setLocationRelativeTo(null);
        save.addActionListener(new ButtonListener()); //to save the image
    }

    public int getArrayIndex(int[] arr, int value) { //get the index of the DR in the queue

        int k = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == value) {
                k = i;
                break;
            }
        }
        return k;
    }

    private XYDataset createDataset(int[] arr, int[] sorted, int head, int end) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        if(CSCAN == true){
            if (beginCheck == true){
                
                 XYSeries series1 = new XYSeries("Series 1"); //name the first series
      
        int a = 0;
        int yAxis = 30; //y axis starts from 30
        int last = getArrayIndex(arr, 0); //find the index of data 0 in array as CSCAN touch 0

        while (last >= a) { //from the head of the queue until 0
            series1.add(arr[a], yAxis);
            yAxis--; //going down the graph
            a++;
        }
        
        // ---------------------------------------------------------------------
       
        
        Arrays.sort(sorted); //sort the result from 0 - 199
        XYSeries series2 = new XYSeries("0-199"); // Second series
        int c = 1;
        while (c < 2) {
            series2.add(sorted[arr.length - 1], yAxis);
            series2.add(sorted[0], yAxis + 1);            
            yAxis--;
            c++;
        }
        
         //53, 37, 14, 0, 199, 183, 124, 122, 98, 67, 65
        //0,14,37,53,65,67,98,122,124,183,199

        int pos = Arrays.binarySearch(sorted, head);// pos = 3 // (arr.len-2 - head + 1) +2
        int right = pos + 1; // 4

        XYSeries series3 = new XYSeries("Series 2"); // Third series
        yAxis = 30 - right;
        int count = sorted.length-1; // 10
        int sumOfIdx = ((sorted.length-2)-pos);
        while (count >= right) { // 10 >= 4       
            series3.add(sorted[right], yAxis-sumOfIdx);
            yAxis++; //go up the graph
            right++; //go to the right of the array (the one sorted)
        }
      
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);

        return dataset;
                
            }
            else if (endCheck == true){
                XYSeries series1 = new XYSeries("Series 1"); //First series
                int a = 0;
                int yAxis = 30;
                int last = getArrayIndex(arr, end); //index of 199 = 7 in scheduled queue

                while (last >= a) {
                    series1.add(arr[a], yAxis);
                    yAxis--;
                    a++;
                }

                Arrays.sort(sorted);
                XYSeries series2 = new XYSeries("0-199"); // Second series
                int c = 1;
                while (c < 2) {
                    series2.add(arr[0], yAxis);
                    series2.add(arr[arr.length - 1], yAxis + 1);
                    yAxis--;
                    c++;
                }


                int pos = Arrays.binarySearch(sorted, head);// pos = 3
                int left = pos - 1; //2    

                XYSeries series3 = new XYSeries("Series 2"); // Third series
                a = 0;
                int count = 0;
                while (count <= left) {
                    series3.add(sorted[a], yAxis + 1);
                    count++;
                    yAxis--;
                    a++;
                }

                dataset.addSeries(series1);
                dataset.addSeries(series2);
                dataset.addSeries(series3);

                return dataset;
            }
        }
        else if (LOOK==true){
            if(beginCheck==true){                
                
                XYSeries series1 = new XYSeries("Series 1");      
                
                Arrays.sort(arr);
                Arrays.sort(sorted);
                int pos = Arrays.binarySearch(sorted, head);
                int left = pos - 1; //index 2 = 37
                int right = pos + 1;
                int aa = 0;
                int yAxis = 30;
                int headIdx = getArrayIndex(arr, sorted[pos]); //index of 53 = 2 in sorted array

                while (headIdx >= aa) {
                    series1.add(sorted[aa], yAxis);
                    yAxis++;
                    aa++;
                }
                
                yAxis = 30;
                XYSeries series2 = new XYSeries("Series 2");
                    series2.add(sorted[0],yAxis); //from first element in DR
                    series2.add(arr[right],yAxis-1); //until head+1 in DR
                                    
                XYSeries series3 = new XYSeries("Series 3");
                int lastIdx = getArrayIndex(arr, sorted[sorted.length-1]);
                int a = 0;
                while(right <= lastIdx){
                      series3.add(sorted[right],yAxis-1);
                      right++;
                      yAxis--;
                }               
                
                dataset.addSeries(series1);
                dataset.addSeries(series2);
                dataset.addSeries(series3);

                return dataset;
            
            }
            
            else if (endCheck==true){
                
                XYSeries series1 = new XYSeries("Series 1");
                Arrays.sort(arr);
                Arrays.sort(sorted);
                int pos = Arrays.binarySearch(sorted, head);
                int left = pos - 1; //index 2 = 37
                int aa = pos;
                int yAxis = 30;
                int last = getArrayIndex(arr, arr[arr.length-1]); 

                while (last >= aa) {
                    series1.add(arr[aa], yAxis);
                    yAxis--;
                    aa++;
                }
                
                
                XYSeries series2 = new XYSeries("Series 2");
                    series2.add(arr[last],yAxis+1);
                    series2.add(arr[left],yAxis);
                    
                XYSeries series3 = new XYSeries("Series 3");
                int a = 0;
                while(a <= left){
                      series3.add(arr[a],yAxis-1);
                      a++;
                      yAxis++;
                }               
                
                dataset.addSeries(series1);
                dataset.addSeries(series2);
                dataset.addSeries(series3);

                return dataset;

            }
        }
        else if (CLOOK == true){
            if(beginCheck==true){                
                
            XYSeries series1 = new XYSeries("Series 1"); //First series      

        int a = 0;
        int yAxis = 30;
        Arrays.sort(sorted);
        int pos = Arrays.binarySearch(sorted, head);// pos = 2
        int last = getArrayIndex(sorted, head); //
                System.out.println(pos + " and last " + last);
        while (last >= a) {
            series1.add(arr[a], yAxis);
            yAxis++;
            a++;
        }
        
                
        Arrays.sort(sorted);
        XYSeries series2 = new XYSeries("Series 2"); // Second series
        yAxis = 30;
        int c = 1;
        while (c < 2) {            
            series2.add(sorted[0], yAxis);      
            series2.add(sorted[sorted.length - 1], yAxis-1);
            yAxis--;
            c++;
        }       
        
        int right = pos + 1; // 4               
        XYSeries series3 = new XYSeries("Series 3"); // Third series
       // yAxis = 30 - right;
        int count = sorted.length-1; // 10
        int sumOfIdx = ((sorted.length-2)-pos);
        while (count >= right) { // 10 >= 4
            
            series3.add(sorted[right], yAxis-sumOfIdx);
            yAxis++;            
            right++;
        }
      
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        dataset.addSeries(series3);

        return dataset;
            
            }
            
            else if (endCheck==true){
              XYSeries series1 = new XYSeries("Series 1"); //First series
                Arrays.sort(arr);
                Arrays.sort(sorted);
                int pos = Arrays.binarySearch(sorted, head);
                int aa = pos;
                int yAxis = 30;
                int last = getArrayIndex(arr, arr[arr.length-1]); //index of 199 = 7 in scheduled queue

                while (last >= aa) {
                    series1.add(arr[aa], yAxis);
                    yAxis--;
                    aa++;
                }
                
                XYSeries series2 = new XYSeries("Series 2"); // Second series
                int c = 1;
                while (c < 2) {
                    series2.add(arr[0], yAxis);
                    series2.add(arr[arr.length - 1], yAxis + 1);
                    yAxis--;
                    c++;
                }

                // pos = 3
                int left = pos - 1; //2    

                XYSeries series3 = new XYSeries("Series 3"); // Third series
                int a = 0;
                int count = 0;
                while (count <= left) {
                    series3.add(sorted[a], yAxis + 1);
                    count++;
                    yAxis--;
                    a++;
                }
                dataset.addSeries(series1);
                dataset.addSeries(series2);
                dataset.addSeries(series3);

                return dataset;
            }
        }
        
        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        chart = ChartFactory.createXYLineChart(
                "Disk Scheduling Algorithm",
                "",
                "Time",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        
        ChartPanel panel = new ChartPanel(chart);
        //ScreenImage.writeImage(ScreenImage.createImage(panel), "myImageFile.jpg");

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.WHITE);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);
        
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis(); //wont show y-axis
        rangeAxis.setVisible(false);
        
        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Disk Scheduling Algorithm",
                new Font("Comic Sans", java.awt.Font.BOLD, 14)
        )
        );

        return chart;

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Window6 ex = new Window6();
            ex.setVisible(true);
            
        });
    }
    
  class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
        String checkInput = JOptionPane.showInputDialog(null, "Enter the file name to save your graph: ");
       
        if (checkInput != null){
            try {
               ChartUtilities.saveChartAsPNG(new File(checkInput+".jpg"), chart, 600, 300); 
               JOptionPane.showMessageDialog(null, "Image successfully saved!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } 
            catch (Exception ex) {
               JOptionPane.showMessageDialog(null,"Image failed to save.", "Error", JOptionPane.ERROR_MESSAGE);
               }
            }
        else{
            System.out.println("");
        }
      }
        
  }
}
