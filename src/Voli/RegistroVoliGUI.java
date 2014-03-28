package Voli;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;



public class RegistroVoliGUI extends JFrame implements ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;
	
	private JTextArea output;	
	private JTextField textFieldCodiceVolo;	
	private JButton erogaButton;
		
	private RegistroVoli registroVoli;
	
	
	public RegistroVoliGUI(RegistroVoli registroVoli){
		super("Registro dei voli");
		this.registroVoli = registroVoli;
		
	
		output = new JTextArea();
		output.setEditable(false);
		output.setBackground(Color.LIGHT_GRAY);
		refreshOutput();

		JScrollPane scroll = new JScrollPane(output);
		add(scroll, BorderLayout.CENTER);
				
		JPanel voliEistentiPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		voliEistentiPanel.setBorder(new TitledBorder("Selezionare un volo da visualizzare"));		
		voliEistentiPanel.add(new JLabel("Codice volo "));
		textFieldCodiceVolo = new JTextField(15);
		
		voliEistentiPanel.add(textFieldCodiceVolo);
		erogaButton = new JButton("Visualizza");	
		erogaButton.addActionListener(this);
		
		voliEistentiPanel.add(erogaButton);		
		add(voliEistentiPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		addWindowListener(this);		
	}
	
	private void refreshOutput(){
		output.setText("");
		String codiciDeiVoli[] = registroVoli.getListaCodiciDeiVoli();
		
		for(String codice : codiciDeiVoli)
			output.append(codice + "\n");
		output.append("----------------------\n\n");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		refreshOutput();
		String codiceVolo = textFieldCodiceVolo.getText();
		if(codiceVolo != null){			
			Volo volo = registroVoli.getVolo(codiceVolo);
			if(volo != null){
				output.append(volo.toString());
			} else {
				output.append("Volo non trovato");
			}
		}
	}	
	
	public void windowClosing(WindowEvent e) {
		int value = JOptionPane.showConfirmDialog(this, "Vuoi uscire?",
				"Uscita", JOptionPane.YES_NO_OPTION);
		if (value == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	public void windowActivated(WindowEvent arg0) {}
	public void windowClosed(WindowEvent arg0) {}	
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
		
	
	public static void main(String a[]) throws Exception{
		RegistroVoli r = new RegistroVoli();
		VoloDiretto v1 = new VoloDiretto("LIN", "FCO", 60);
		VoloDiretto v2 = new VoloDiretto("FCO", "SFO", 665);
		VoloDiretto vv[] = {v1, v2};
		VoloMultiTratta v3 = new VoloMultiTratta(vv);
		r.aggiungiVolo("P2A01", v1);
		r.aggiungiVolo("P2B02", v2);
		r.aggiungiVolo("P2C03", v3);
		RegistroVoliGUI gui = new RegistroVoliGUI(r);
		gui.setSize(500, 300);
		gui.setVisible(true);
	}

}