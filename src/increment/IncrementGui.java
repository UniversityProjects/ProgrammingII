package increment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class IncrementGui extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private int num = 0;
	private JLabel numLabel = new JLabel();
	
	public IncrementGui(String title)  {
		
		// Main Frame
		super(title);	
		num = 0;
		this.setSize(300,200);
		
		
		// Panel
		JPanel pan = new JPanel();
		this.add(pan);
		pan.setLayout(new GridLayout(2,2,10,50));
		
		
		// Label
		pan.add(new JLabel("Valore della variabile:"));
		
		
		// Value
		this.numLabel.setText("" + this.num);
		pan.add(this.numLabel);
		
		
		// Button Incrementa
		JButton incrementaButt = new JButton("Incrementa");
		incrementaButt.addActionListener(this);
		pan.add(incrementaButt);
		
			
		
		// Button Decrementa
		JButton decrementaButt = new JButton("Decrementa");
		decrementaButt.addActionListener(this);
		pan.add(decrementaButt);		
		
	}
	
	
	public IncrementGui() {
		
		this("Esempio Gui");
		
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getActionCommand().equals("Incrementa")) {
			
			this.num++;
			
			if (this.numLabel != null) { 
				
				this.numLabel.setText("" + this.num);
			
			}
			
		}
		
		if (arg0.getActionCommand().equals("Decrementa")) {
			
			this.num--;
			
			if (this.numLabel != null) {
				
				this.numLabel.setText("" + this.num);
			
			}
			
		}

	}


	public static void main(String[] args) {
		
		IncrementGui gui = new IncrementGui();
		
		gui.setVisible(true);
		

	}

}
