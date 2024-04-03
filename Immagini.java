import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;

public class Immagini extends JPanel{

    private ImageIcon image;

    public Immagini(String path) {

        this.image = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

    }
    public Dimension getHeightandWidht(){
        return new Dimension(image.getIconWidth(),image.getIconWidth());
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        image.paintIcon(this, g, 0, 0);
    }

}