import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class FrameDisplayer extends JFrame{
        
        
        private JButton button2 = new JButton("Memory");
        private JButton button3 = new JButton("Setting");
        private JPanel panel = new JPanel();

        public FrameDisplayer(String title){
            
            super(title);
            BoxLayout boxlayout = new BoxLayout(panel, BoxLayout.X_AXIS);
            panel.setLayout(boxlayout);
            setLocation(600,660);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            
            panel.add(button2);
            panel.add(button3);
            add(panel);
            pack();
            setVisible(true);
           
        }
      
        
}
