import java.awt.*;
import java.awt.Graphics;
import java.util.Random;
import java.awt.event.*;
import java.math.MathContext;
import java.awt.Color;	
import javax.management.StringValueExp;
import javax.swing.border.Border;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.*;
import javax.swing.JTabbedPane;
import java.text.DecimalFormat;
import java.util.PriorityQueue;
import java.util.LinkedList;
import javax.swing.JScrollBar;
import java.util.Queue;

public class VentanaResultados extends JFrame implements ActionListener
{   
    JLabel Label1, Label2, Label3, EntropiaLabel, LogitudProm, Eficacia;
    JTextField Texto, Entropia, Logitud, EficaciaCod;
    JButton Salir, Codificar, OtroCalculo;
    public final JTextArea mainConsole = new JTextArea("");

    VentanaResultados()
    {
    	super("CODIGO DE HUFFMAN");
		setSize(1100, 700);
		setVisible(true);
		setLayout(null);
        Color colorVentana=new Color(225,247,213);
        Color BotonColor=new Color(225,247,213);
		this.getContentPane().setBackground(colorVentana);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        mainConsole.setFont(new Font("Times New Roman", 1, 15));

        Label1 = new JLabel("ALGORITMO DE CODIFICACI\u00d3N DE HUFFMAN");
        Label1.setBounds(40, 10, 1000, 50); 
        Label1.setForeground(Color.BLACK);
        Label1.setFont(new Font("Times New Roman", 1, 20));
        Label1.setHorizontalAlignment(JTextField.CENTER);
        Label1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        add(Label1);

        Label2 = new JLabel("Ingrese el texto a codificar:");
        Label2.setBounds(40, 70, 200, 50); 
        Label2.setForeground(Color.BLACK);
        Label2.setFont(new Font("Times New Roman", 1, 14));
        Label2.setHorizontalAlignment(JTextField.CENTER);
        add(Label2);

        Label3 = new JLabel("RESULTADOS");
        Label3.setBounds(40, 200, 1000, 50); 
        Label3.setForeground(Color.BLACK);
        Label3.setFont(new Font("Times New Roman", 1, 17));
        Label3.setHorizontalAlignment(JTextField.CENTER);
        add(Label3);

        EntropiaLabel = new JLabel("Entrop\u00eda:");
        EntropiaLabel.setBounds(160, 530, 250, 50); 
        EntropiaLabel.setForeground(Color.BLACK);
        EntropiaLabel.setFont(new Font("Times New Roman", 1, 17));
        add(EntropiaLabel);

        LogitudProm = new JLabel("Logitud Promedio del C\u00f3digo:");
        LogitudProm.setBounds(430, 530, 250, 50); 
        LogitudProm.setForeground(Color.BLACK);
        LogitudProm.setFont(new Font("Times New Roman", 1, 17));
        add(LogitudProm);

        Eficacia = new JLabel("Eficacia del C\u00f3digo:");
        Eficacia.setBounds(700, 530, 250, 50); 
        Eficacia.setForeground(Color.BLACK);
        Eficacia.setFont(new Font("Times New Roman", 1, 17));
        add(Eficacia);

        Entropia = new JTextField();
        Entropia.setBounds(160, 590, 250, 50); 
        Entropia.setForeground(Color.BLACK);
        Entropia.setFont(new Font("Times New Roman", 1, 17));
        Entropia.setHorizontalAlignment(JTextField.CENTER);
        Entropia.setBackground(Color.GRAY); 
        Entropia.setForeground(Color.GREEN);
        Entropia.setDisabledTextColor(Color.WHITE);
        Entropia.setEnabled(false);
        add(Entropia);

        Logitud = new JTextField();
        Logitud.setBounds(430, 590, 250, 50); 
        Logitud.setForeground(Color.BLACK);
        Logitud.setFont(new Font("Times New Roman", 1, 17));
        Logitud.setHorizontalAlignment(JTextField.CENTER);
        Logitud.setBackground(Color.GRAY); 
        Logitud.setForeground(Color.GREEN);
        Logitud.setDisabledTextColor(Color.WHITE);
        Logitud.setEnabled(false);
        add(Logitud);

        EficaciaCod = new JTextField();
        EficaciaCod.setBounds(700, 590, 250, 50); 
        EficaciaCod.setForeground(Color.BLACK);
        EficaciaCod.setFont(new Font("Times New Roman", 1, 17));
        EficaciaCod.setHorizontalAlignment(JTextField.CENTER);
        EficaciaCod.setBackground(Color.GRAY); 
        EficaciaCod.setForeground(Color.GREEN);
        EficaciaCod.setDisabledTextColor(Color.WHITE);
        EficaciaCod.setEnabled(false);
        add(EficaciaCod);

        Texto = new JTextField();
        Texto.setBounds(250, 80, 790, 30);
        Texto.setFont(new Font("Times New Roman", 1, 14));
        Texto.setHorizontalAlignment(JTextField.CENTER);
        Texto.setDisabledTextColor(Color.WHITE);
        Texto.setVisible(true);
        add(Texto);
        
        Codificar = new JButton("Codificar");
        Codificar.setBounds(250+328, 120, 120, 40);
        Codificar.setForeground(Color.BLACK);
        Codificar.setFont(new Font("Times New Roman", 1, 14));
        add(Codificar);
        Codificar.addActionListener(this);

        Salir = new JButton("Salir");
        Salir.setBounds(420+328, 120, 120, 40);
        Salir.setForeground(Color.BLACK);
        Salir.setFont(new Font("Times New Roman", 1, 14));
        add(Salir);
        Salir.addActionListener(this);

        OtroCalculo = new JButton("Otro Calculo");
        OtroCalculo.setBounds(590+328, 120, 120, 40);
        OtroCalculo.setForeground(Color.BLACK);
        OtroCalculo.setFont(new Font("Times New Roman", 1, 14));
        add(OtroCalculo);
        OtroCalculo.addActionListener(this);
        mainConsole.setText(mainConsole.getText() +"------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        mainConsole.setText(mainConsole.getText() +"S\u00edmbolo\tProbabilidad(Px)\tCantidad S\u00edmbolos\tC\u00f3digo\tMedida de la informaci\u00f3n\n");
        mainConsole.setText(mainConsole.getText() +"------------------------------------------------------------------------------------------------------------------------------------------------------------\n");

        JScrollPane scrollPane = new JScrollPane(mainConsole);
        scrollPane.setBounds(150,270,800,260);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane);
        setVisible(true);
        setLayout(null);

        }

    public void actionPerformed(ActionEvent e)
	{
        if (e.getSource()==Codificar) 
        {
            String text = Texto.getText();
            ConteroCaracter obj = new ConteroCaracter(text);
            Codigo Cod = new Codigo();
            obj.contarNumCaracteres();
            double[] Px = obj.getPx();
            String[] Letra = obj.getCaracter();
            int[] Cont = obj.getConteo();
            int Limite = obj.getLimite();
            OrdenarCaracterConPx ArbolGenerado = Cod.AsignacionDatos(Px, Limite, Letra, Cont);
            Cod.GenerarCodigo(ArbolGenerado, new StringBuffer());
            Cod.reordenarFinal();

            String[] OrdenCodigoHuffman = Cod.FinalCodigo(); 
            String[] OrdenCaracters = Cod.FinalCaracter(); 
            int[] OrdenFinal = Cod.FinalConteo();
            double[] PxFinal = Cod.FinalProbabilidad();
            double[] log = Cod.Finallog(); 
            double[] PxLog = Cod.FinalPxLog(); 
            double[] nPx = Cod.FinalnPx(); 
            double suma1= Cod.FinalSuma1();
            double suma2= Cod.FinalSuma2();
            double porcentaje= Cod.FinalnPorcentaje();
            int lim = Cod.Finali();
            DecimalFormat decimales = new DecimalFormat("0.0000");
                for (int i=0; i<lim; i++) 
                {
                    mainConsole.setText(mainConsole.getText() + OrdenCaracters[i]+"\t"+decimales.format(PxFinal[i])+"\t\t"+OrdenFinal[i]+"\t\t"+OrdenCodigoHuffman[i]+"\t\t"+decimales.format(log[i])+"\n");
                }
                mainConsole.setText(mainConsole.getText() +"------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
            Entropia.setText(decimales.format(suma2));
            Logitud.setText(decimales.format(suma1));
            EficaciaCod.setText(decimales.format(porcentaje));
            Codificar.setEnabled(false);
        }
        if (e.getSource()==OtroCalculo) 
        {
                mainConsole.setText("");
                Entropia.setText("");
                Logitud.setText("");
                EficaciaCod.setText("");
                Texto.setText("");
                mainConsole.setText(mainConsole.getText() +"------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                mainConsole.setText(mainConsole.getText() +"S\u00edmbolo\tProbabilidad(Px)\tCantidad S\u00edmbolos\tC\u00f3digo\tMedida de la informaci\u00f3n\n");
                mainConsole.setText(mainConsole.getText() +"------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                Codificar.setEnabled(true);
        }
        if (e.getSource()==Salir) 
        {   
                dispose();
        }
    }
}