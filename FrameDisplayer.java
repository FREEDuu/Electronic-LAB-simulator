import java.awt.BorderLayout;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.border.Border;

public class FrameDisplayer extends JFrame{
      
        private JButton button1 = new JButton("Program");
        private JButton button2 = new JButton("Memory");
        private JButton button3 = new JButton("Setting");
        int x ;
        int y ;

        public FrameDisplayer(String title , int x, int y){
            
            super(title);
            this.x = x;
            this.y = y;
            setLayout(new BorderLayout());
            setSize(x,y);
            setLocation(800,400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            add(button1 , BorderLayout.LINE_START);
            add(button2 , BorderLayout.LINE_END);
            add(button3, BorderLayout.CENTER);
            button1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayProgram();
                }
            });
            button2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displaySetting();
                }
            });
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayMemory();
                }
            });
        }
      
        public void displayProgram(){
            setVisible(false);
            PaintProgram(1);
        }
        public void displayMemory(){
            setVisible(false);
            PaintProgram(2);
        }
        public void displaySetting(){
            setVisible(false);
            PaintProgram(3);
        }
        public void Paints(JFrame frame, JButton button){
            
            frame.setSize(x,y);
            frame.setLocation(800,400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(button);
            button.addActionListener(new ActionListener(){
                 @Override
                public void actionPerformed(ActionEvent e) {
                    Backing(frame);
                }
            });
            frame.setVisible(true);
        }
        public void Backing(JFrame frame){
            frame.setVisible(false);
            setVisible(true);
        }
        public void PaintProgram(int code){
            if(code == 1){
                JFrame frameProgram = new JFrame("Program");
                JButton button = new JButton("Back");
                frameProgram.add(new ScrollMenu());
                
                Paints(frameProgram, button);

            }
            if(code == 2){
                JFrame framePrgram = new JFrame("Settings");
                JButton button = new JButton("Back");
                Paints(framePrgram, button);
            }
            if(code == 3){
                JFrame framePrgram = new JFrame("Memory");
                JButton button = new JButton("Back");
                Paints(framePrgram, button);
            }
        }
}
