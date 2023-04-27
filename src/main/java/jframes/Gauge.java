package jframes;

import eu.hansolo.steelseries.gauges.Linear;
import eu.hansolo.steelseries.tools.ColorDef;
import eu.hansolo.steelseries.tools.FrameDesign;
import eu.hansolo.steelseries.tools.LcdColor;
import eu.hansolo.steelseries.tools.LedColor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Gauge extends JFrame {
    double value ; 
    String num_pension;
    JButton ok;
    
    public String getNum_pension() {
        return num_pension;
    }
    public void setNum_pension(String num_pension) {
        this.num_pension = num_pension;
    }   
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }

    public Gauge(double value,String a) {
        this.setValue(value);
        this.setNum_pension(a);
         createAndShowUI();
    }
   
    private  void createAndShowUI() {
        this.setLocationByPlatform(true);

        JPanel panel = new JPanel() {
            @Override 
            public Dimension getPreferredSize() {
                return new Dimension(400, 150);
            }
        };
         this.setLayout(new GridLayout(2, 1));
         
         
        Linear gauge = new Linear();
        gauge.setTitle(this.getNum_pension());
        gauge.setBackground(Color.lightGray);
        gauge.setFrameDesign(FrameDesign.BLACK_METAL);
        gauge.setLedColor(LedColor.YELLOW);
        gauge.setLcdColor(LcdColor.STANDARD_LCD);
        gauge.setTrackStart(0);
        gauge.setTrackStartColor(Color.MAGENTA);
        gauge.setTrackSection(80);
        gauge.setTrackSectionColor(Color.YELLOW);
        gauge.setTrackStop(100);
        gauge.setTrackStopColor(Color.GREEN);
        gauge.setTrackVisible(true);
        
        panel.setLayout(new BorderLayout());
        panel.add(gauge, BorderLayout.CENTER);
      
        JPanel buttonsPanel = new JPanel();
        ok=new JButton("OK");
        ok.setBackground(new Color(59, 89, 182));
        ok.setForeground(Color.WHITE);
        ok.setFocusPainted(false);
        ok.setFont(new Font("Tahoma", Font.BOLD, 12));
       // ok.addActionListener(new OkListener(this,this.fb)); 
        
    
        buttonsPanel.add(ok);
       
        gauge.setValueAnimated(this.getValue());
        if(value<51) {
              gauge.setValueColor(ColorDef.RED);
        }
        else if(value>50 && value < 80 ) {
              gauge.setValueColor(ColorDef.YELLOW);
        }
        else {
            gauge.setValueColor(ColorDef.GREEN);
        }
        this.add(panel);
       
        this.add(buttonsPanel, BorderLayout.NORTH);
      
        this.pack();
        this.setVisible(true);
    }

}