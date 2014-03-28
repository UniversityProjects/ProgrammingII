package ContoCorrenteGui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MaiGUI extends JFrame {
	

	private static final long serialVersionUID = 1L;
	
	private JTextArea output;
	private JRadioButton deposito;
	private JRadioButton prelievo;
	private JRadioButton estratto;
	private JTextField input;	
	
	public MaiGUI(){
		super("Conto Corrente");
			
		output = new JTextArea();
		output.setEditable(false);
		JScrollPane scroll = new JScrollPane(output);
	
		add(scroll);
		
		JPanel panelControlli = new JPanel(new GridLayout(2, 1));
		JPanel bottoni = new JPanel();
		
		deposito = new JRadioButton("Deposito", /*new ImageIcon("smiley.gif"), */true);
		prelievo = new JRadioButton("Prelievo", /*new ImageIcon("sad.gif"), */false);
		estratto = new JRadioButton("Estratto", /*new ImageIcon("euro.gif"), */false);
		
		bottoni.add(deposito);
		bottoni.add(prelievo);
		bottoni.add(estratto);
		
		ButtonGroup g = new ButtonGroup();
		g.add(deposito);
		g.add(estratto);
		g.add(prelievo);
		
		JPanel controlli = new JPanel(new FlowLayout(FlowLayout.LEFT));		
		input = new JTextField(10);
		controlli.add(new JLabel("Euro: ", new ImageIcon("euro.gif"), JLabel.CENTER));
		controlli.add(input);
			
		panelControlli.add(bottoni);
		panelControlli.add(controlli);
		
		add(panelControlli, BorderLayout.SOUTH);
	}

	
	public static void main (String args[]) {
		MaiGUI f = new MaiGUI();
		f.setSize(300,200); 
		f.setVisible(true);
	}
}
