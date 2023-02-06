import	javax.swing.JFrame;	
import	javax.swing.JLabel;	
import	javax.swing.JPanel;

public class Principal
{
    public static void main(String args[])
    {
    	VentanaResultados obj = new VentanaResultados();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setSize(1100, 700);
		obj.setVisible(true);
		obj.setLayout(null);
		obj.setLocationRelativeTo(null);
    }
}
