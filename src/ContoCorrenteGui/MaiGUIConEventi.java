package ContoCorrenteGui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class MaiGUIConEventi extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private JTextArea output;
	private JRadioButton deposito;
	private JRadioButton prelievo;
	private JRadioButton estratto;
	private JTextField input;	
		
	private ContoCorrente conto;
	private String selezionato;
		
	public MaiGUIConEventi(ContoCorrente conto){
		super("Conto Corrente");
		
		this.conto = conto;
		
		output = new JTextArea();
		output.setEditable(false);
		JScrollPane scroll = new JScrollPane(output);
	
		add(scroll);
		
		JPanel panelControlli = new JPanel(new GridLayout(2, 1));
		JPanel bottoni = new JPanel();
		
		deposito = new JRadioButton("Deposito", /*new ImageIcon("smiley.gif"), */true);
		prelievo = new JRadioButton("Prelievo", /*new ImageIcon("sad.gif"), */false);
		estratto = new JRadioButton("Estratto", /*new ImageIcon("euro.gif"), */false);
		
		selezionato = "Deposito";
		//aggancio al listener
		deposito.addActionListener(this);
		prelievo.addActionListener(this);
		estratto.addActionListener(this);
		
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

		//Registro il listener del textFiled
		input.addActionListener(this);

		panelControlli.add(bottoni);
		panelControlli.add(controlli);
		
		add(panelControlli, BorderLayout.SOUTH);

		//Registro il listener della finestra
		addWindowListener(new ChiusuraFinestra());
	}
	
	
	
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Estratto")){
			selezionato = "Estratto";
			output.append("Saldo: " + conto.saldo() + " Euro\n");
		} else {
			if(arg0.getSource().equals(input)){
				if(!selezionato.equals("Estratto")){
					double d = Double.parseDouble(input.getText());
					if(selezionato.equals("Deposito")){
						conto.deposita(d);
						output.append("Depositato: " + d + " Euro\n");
					} else {
						conto.preleva(d);
						output.append("Prelevato: " + d + " Euro\n");
					}
					input.setText("");
				}else {
					JOptionPane.showMessageDialog(this, 
							"Attenzione: non è selezionato il tipo di operazione!", 
							"Selezione errata", 
							JOptionPane.WARNING_MESSAGE);
				}				
			} else if(arg0.getActionCommand().equals("Deposito")) {
				selezionato = "Deposito";
			} else if(arg0.getActionCommand().equals("Prelievo")){
				selezionato = "Prelievo";
			}
		}		
	}
	
	public static void main (String args[]) {
		MaiGUIConEventi f = new MaiGUIConEventi(new ContoCorrente(1000));
		f.setSize(300,200); 
		f.setVisible(true);
	}
}
