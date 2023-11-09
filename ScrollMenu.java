import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ScrollMenu extends JComboBox{

    private String[] components = {"menù", "resistenza", "alimentatore", "voltmetro", "led"};

    private JComboBox scrollmenus = new JComboBox(components);

    public ScrollMenu(){

    }
}
