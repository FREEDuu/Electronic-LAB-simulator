import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Flow;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;


public class FrameDisplayer extends JFrame{

        Object[] comp = {

            new ImageIcon("/home/fred/Desktop/JavaProj/Electronic-LAB-simulator/img/led.png"),
            new ImageIcon("/home/fred/Desktop/JavaProj/Electronic-LAB-simulator/img/button.png"),
            new ImageIcon("/home/fred/Desktop/JavaProj/Electronic-LAB-simulator/img/resistor.png")
        };
        double x;
        double y;
        private JTabbedPane tabbedPane = new JTabbedPane();
        Dimension scrDimension = Toolkit.getDefaultToolkit().getScreenSize();
        
        private JButton button1 = new JButton("New Project");
        private JButton button2 = new JButton("Saved Projects");
        private JButton button3 = new JButton("Setting");
        private JButton button4 = new JButton("Delete Project");



        private JPanel TotalPanel = new JPanel();
        private JPanel TopPanel = new JPanel();
        private JPanel OpenProject = new JPanel();
        private JPanel MiddPanel = new JPanel();
        private JPanel ScrollPanel = new JPanel();
        private JPanel WorkingSpace = new JPanel();
        JComboBox comps = new JComboBox(comp);

        public FrameDisplayer(String title){

            super(title);
            this.x = scrDimension.getWidth();
            this.y = scrDimension.getHeight();
            setSize((int)x,(int)y);

            //on create new project press this is creating a new tab
            // #todo implements an inteface correctly 
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    CreateNewProject();
                }
            });
            
            button2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    DeleteProject();
                }
            });

            //set layout of all panels 

            TotalPanel.setLayout(new BoxLayout(TotalPanel, BoxLayout.Y_AXIS));
            TopPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            MiddPanel.setLayout(new BorderLayout());
            WorkingSpace.setLayout(new BorderLayout());

            //action selection panel (new projects, saved projects, settings)

            TotalPanel.add(TopPanel);
            TotalPanel.add(MiddPanel);            

            //add action buttons in the top panels

            TopPanel.add(button1);
            TopPanel.add(button2);
            TopPanel.add(button3);
            TopPanel.add(button4);


            //add comps (the combobox) 

            MiddPanel.add(ScrollPanel, BorderLayout.WEST);
            MiddPanel.add(WorkingSpace, BorderLayout.CENTER);
            ScrollPanel.add(comps);

            
            tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            WorkingSpace.add(tabbedPane, BorderLayout.CENTER);
            tabbedPane.addTab("New Project", new JPanel());

            //add total panel in the frame
            add(TotalPanel);
            
            OpenProject.setBackground(Color.BLACK);
            WorkingSpace.setBackground(Color.LIGHT_GRAY);
            ScrollPanel.setBackground(Color.CYAN);
            
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
        }

        //spawn a dialogue interface to insert the project title and adds the project to the tab panel

        public void CreateNewProject(){
            String projTitle = (String)JOptionPane.showInputDialog("Project title:");
            tabbedPane.addTab(projTitle, new JPanel());

        }
        public void DeleteProject(){
            //tabbedPane.removeTabAt();;
        }
        
}
