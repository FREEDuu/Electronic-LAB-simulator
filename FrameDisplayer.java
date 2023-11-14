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
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class FrameDisplayer extends JFrame{

        private String[] components = {"menù", "resistenza", "alimentatore", "voltmetro", "led"};
        double x;
        double y;
        private JTabbedPane tabbedPane = new JTabbedPane();
        Dimension scrDimension = Toolkit.getDefaultToolkit().getScreenSize();
        
        private JButton button1 = new JButton("Create New Project");
        private JButton button2 = new JButton("Project");
        private JButton button3 = new JButton("Setting");

        private JPanel TotalPanel = new JPanel();
        private JPanel TopPanel = new JPanel();
        private JPanel OpenProject = new JPanel();
        private JPanel MiddPanel = new JPanel();
        private JPanel ScrollPanel = new JPanel();
        private JPanel WorkingSpace = new JPanel();
        JComboBox comps = new JComboBox(components);

        public FrameDisplayer(String title){

            super(title);
            this.x = scrDimension.getWidth();
            this.y = scrDimension.getHeight();
            setSize((int)x,(int)y);

            //on create new project press this is creating a new tab

            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CreateNewProject();
                }
            });

            //set layout of all panels 

            TotalPanel.setLayout(new BoxLayout(TotalPanel, BoxLayout.Y_AXIS));
            TopPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            MiddPanel.setLayout(new BorderLayout());
            WorkingSpace.setLayout(new BorderLayout());

            //add top panel where is displayed the 3 buttons create new proj option ecc and Midd Panel where is the combobox and the tabs

            TotalPanel.add(TopPanel);
            TotalPanel.add(MiddPanel);            

            //add buttons in the top panels

            TopPanel.add(button1);
            TopPanel.add(button2);
            TopPanel.add(button3);

            //add comps that is the combobox 

            MiddPanel.add(ScrollPanel, BorderLayout.WEST);
            MiddPanel.add(WorkingSpace, BorderLayout.CENTER);
            ScrollPanel.add(comps);

            
            tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            WorkingSpace.add(tabbedPane, BorderLayout.CENTER);
            tabbedPane.addTab("Ciao", new JButton("ciao"));

            //add total panel in the frame
            add(TotalPanel);
            
            OpenProject.setBackground(Color.BLACK);
            WorkingSpace.setBackground(Color.LIGHT_GRAY);
            ScrollPanel.setBackground(Color.CYAN);
            
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
        }

        //function that add a new tabs called when button1 (open new Proj) is pressed
        public void CreateNewProject(){
            
            tabbedPane.addTab("Ciao", new JButton("ciao"));

        }
      
        
}
