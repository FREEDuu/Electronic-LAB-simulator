import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class FrameDisplayer extends JFrame{

    Immagini[] componenti_passivi = {
        new Immagini("/Electronic-LAB-simulator/img/button.jpeg"),
        new Immagini("/Electronic-LAB-simulator/img/button.jpeg"),
        new Immagini("/Electronic-LAB-simulator/img/button.jpeg"),
        new Immagini("/Electronic-LAB-simulator/img/button.jpeg"),
    };
    Immagini[] componenti_attivi = {
        new Immagini("/Electronic-LAB-simulator/img/led.png"),
        new Immagini("/Electronic-LAB-simulator/img/led.png"),
        new Immagini("/Electronic-LAB-simulator/img/led.png"),
        new Immagini("/Electronic-LAB-simulator/img/led.png"),
    };
    Immagini[] componenti_di_misura = {
        new Immagini("/Electronic-LAB-simulator/img/resistor.png"),
        new Immagini("/Electronic-LAB-simulator/img/resistor.png"),
        new Immagini("/Electronic-LAB-simulator/img/resistor.png"),
        new Immagini("/Electronic-LAB-simulator/img/resistor.png"),
    };
    // screen size variables 
    double x;
    double y;
    
    //main pane
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
    private JPanel ScrollPanel1 = new JPanel();
    private JPanel ScrollPanel2 = new JPanel();
    private JPanel WorkingSpace = new JPanel();
    private JPanel Panel_attivi = new JPanel();
    private JPanel Panel_Passivi = new JPanel();
    private JPanel Panel_Misura = new JPanel();

    //luca: settings panel, da aggiungere qualsiasi toggle 
    //impostazione de lcazzochetipare
    public class SettingsPanel extends JPanel{
        private JCheckBoxMenuItem checkBox1;
        private JCheckBoxMenuItem checkBox2;
        private JCheckBoxMenuItem checkBox3;
        private JCheckBoxMenuItem checkBox4;
        
        public SettingsPanel(){
            setLayout(new GridLayout(1,4));
            checkBox1 = new JCheckBoxMenuItem("Opzione 1");
            checkBox1 = new JCheckBoxMenuItem("Opzione 2");
            checkBox1 = new JCheckBoxMenuItem("Opzione 3");
            checkBox1 = new JCheckBoxMenuItem("Opzione 4");

            add(checkBox1);
            add(checkBox2);
            add(checkBox3);
            add(checkBox4);

        }
    }

    
    //spawn a dialogue interface to insert the project title and adds the project to the tab panel

    public void CreateNewProject(){
        String projTitle = (String)JOptionPane.showInputDialog("Project title:");
        tabbedPane.addTab(projTitle, new JPanel());

    }
    public void DeleteProject(){
        //tabbedPane.removeTabAt();;
    }

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
        
        button3.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e){
            SettingsPanel settingsPanel = new SettingsPanel();
            JFrame settingsFrame = new JFrame("Settings");

            settingsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            settingsFrame.getContentPane().add(settingsPanel, BorderLayout.CENTER);
            settingsFrame.pack();
            settingsFrame.setAlwaysOnTop(true);
            settingsFrame.setVisible(true);
          }  
        });

        String[] data = {"Elementi Passivi", "Elementi Attivi", "Elementi di Misura"};
        JComboBox<String> lista = new JComboBox<>(data);
        lista.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String comparazione = e.getItem().toString();

                if(comparazione.equals("Elementi Passivi")){
                    Panel_attivi.setVisible(false);
                    Panel_Passivi.setVisible(true);
                    Panel_Misura.setVisible(false);

                }
                else if(comparazione.equals("Elementi Attivi")){
                    Panel_attivi.setVisible(true);
                    Panel_Passivi.setVisible(false);
                    Panel_Misura.setVisible(false);
                }
                if(comparazione.equals("Elementi di Misura")){
                    Panel_attivi.setVisible(false);
                    Panel_Passivi.setVisible(false);
                    Panel_Misura.setVisible(true);
                }

            }
        });
        //set layout of all panels 

        TotalPanel.setLayout(new BoxLayout(TotalPanel, BoxLayout.Y_AXIS));
        TopPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        MiddPanel.setLayout(new BorderLayout());
        WorkingSpace.setLayout(new BorderLayout());
        
        ScrollPanel.setLayout(new BoxLayout(ScrollPanel, BoxLayout.PAGE_AXIS));
        ScrollPanel2.setLayout(new BoxLayout(ScrollPanel2, BoxLayout.PAGE_AXIS));
        Panel_Misura.setLayout(new BoxLayout(Panel_Misura, BoxLayout.PAGE_AXIS));
        Panel_Passivi.setLayout(new BoxLayout(Panel_Passivi, BoxLayout.PAGE_AXIS));
        Panel_attivi.setLayout(new BoxLayout(Panel_attivi, BoxLayout.PAGE_AXIS));

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
        ScrollPanel.add(ScrollPanel1);
        ScrollPanel.add(ScrollPanel2);
        ScrollPanel1.setMaximumSize(new Dimension(200,50));
        ScrollPanel1.setMinimumSize(new Dimension(200,50));

        Panel_attivi.setVisible(false);
        Panel_Passivi.setVisible(true);
        Panel_Misura.setVisible(false);

        for(Immagini e : componenti_attivi){
            e.setOpaque(false);
            e.setMaximumSize(e.getHeightandWidht());
            Panel_attivi.add(e);
        }
        for(Immagini e : componenti_di_misura){
            e.setOpaque(false);
            e.setMaximumSize(e.getHeightandWidht());
            Panel_Misura.add(e);
        }
        for(Immagini e : componenti_passivi){
            e.setOpaque(false);
            e.setMaximumSize(e.getHeightandWidht());
            Panel_Passivi.add(e);
        }

        MiddPanel.add(WorkingSpace, BorderLayout.CENTER);
        ScrollPanel1.add(lista);
        ScrollPanel2.add(Panel_attivi);
        ScrollPanel2.add(Panel_Misura);
        ScrollPanel2.add(Panel_Passivi);

        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        WorkingSpace.add(tabbedPane, BorderLayout.CENTER);
        tabbedPane.addTab("New Project", new JPanel());

        //add total panel in the frame
        add(TotalPanel);
        
        OpenProject.setBackground(Color.BLACK);
        WorkingSpace.setBackground(Color.LIGHT_GRAY);
        ScrollPanel1.setBackground(Color.LIGHT_GRAY);
        ScrollPanel.setBackground(Color.WHITE);
        ScrollPanel2.setBackground(Color.WHITE);
        Panel_Misura.setBackground(Color.WHITE);
        Panel_attivi.setBackground(Color.WHITE);
        Panel_Passivi.setBackground(Color.WHITE);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
    }        
    
}

