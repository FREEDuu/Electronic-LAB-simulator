import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class FrameDisplayer extends JFrame{

        private String[] components = {"menù", "resistenza", "alimentatore", "voltmetro", "led"};
        double x;
        double y;
        Dimension scrDimension = Toolkit.getDefaultToolkit().getScreenSize();
        private JButton button2 = new JButton("Project");
        private JButton button3 = new JButton("Setting");
        private JPanel TotalPanel = new JPanel();
        private JPanel TopPanel = new JPanel();
        private JPanel OpenProject = new JPanel();
        private JPanel panelOption = new JPanel();
        private JPanel ScrollPanel = new JPanel();
        private JPanel WorkingSpace = new JPanel();

        public FrameDisplayer(String title){

            super(title);
            this.x = scrDimension.getWidth();
            this.y = scrDimension.getHeight();
            setSize((int)x,(int)y);
            TotalPanel.setLayout(new BorderLayout());
            TotalPanel.add(TopPanel, BorderLayout.NORTH);
            TopPanel.setLayout(new BorderLayout());
            TopPanel.add(panelOption, BorderLayout.WEST);
            TopPanel.add(OpenProject, BorderLayout.CENTER);
            OpenProject.setBackground(Color.BLACK);
            TotalPanel.add(WorkingSpace, BorderLayout.CENTER);
            WorkingSpace.setBackground(Color.LIGHT_GRAY);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ScrollPanel.setBackground(Color.CYAN);
            TotalPanel.add(ScrollPanel, BorderLayout.WEST);
            panelOption.setLayout(new FlowLayout(FlowLayout.LEFT));
            add(TotalPanel);
            panelOption.add(button2);
            panelOption.add(button3);
            ScrollPanel.add(new JComboBox(components));
            panelOption.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            setVisible(true);
           
        }
      
        
}
