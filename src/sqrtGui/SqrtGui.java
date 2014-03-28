package sqrtGui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class SqrtGui extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	
	private JTextField input = new JTextField(15);
	private JTextArea output = new JTextArea();
	
	public SqrtGui(String title) {
		
		// Main Window 
		super("SqrtGui");
		this.setSize(300, 200);
		
		
		// Bottom Panel With Buttons
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,5));
		
		// Button Calculate: Used To Compute The Result
		JButton buttCalculate = new JButton("Calculate");
		buttCalculate.addActionListener(this);
		panel.add(buttCalculate);
		
		// Button Clear: Used To Flush The Input
		JButton buttClear = new JButton("Clear");
		buttCalculate.addActionListener(this);
		panel.add(buttClear);
		
		// Button Quit: Used To Exit From The Application
		JButton buttQuit = new JButton("Quit");
		buttQuit.addActionListener(this);
		panel.add(buttQuit);
		
		this.add("South", panel);
		
		
		// Center Panel
		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(2,1));
		pan.setBackground(Color.ORANGE);
		this.add("Center", pan);
		
		
		// Half Left Center Panel (Number Input)
		JPanel panNumInput = new JPanel();
		panNumInput.setLayout(new GridLayout(1,2));
		JLabel numberLabel = new JLabel("Number");
		numberLabel.setSize(190, 20);
		panNumInput.add("Left", numberLabel);
		this.input = new JTextField(15);
		panNumInput.add("Right", this.input);
		pan.add(panNumInput);
		
		
		// Half RightCenter Panel (Number Input)
		JPanel panNumOutput = new JPanel();
		panNumOutput.setLayout(new GridLayout(1,2));
		JLabel outputLabel = new JLabel("SQRT");
		outputLabel.setSize(190, 40);
		panNumOutput.add("Left", outputLabel);
		this.output = new JTextArea();
		this.output.setEditable(false);
		panNumOutput.add("Right", this.output);
		pan.add(panNumOutput);
		
	}
	
	public SqrtGui() {
		
		this("Title");		
		
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getActionCommand().equals("Calculate")) {
			
			double num = Double.parseDouble (this.input.getText());
			
			double resDouble = Math.sqrt(num);
			
			if ((resDouble - (double)((int)resDouble)) == 0) {
				
				int resInt =(int) resDouble;
				
				this.output.setText("");
				
				this.output.append("" + resInt);
			
			} else { 
				
				this.output.setText("");
				
				this.output.append("" + resDouble);
			
			}
			
		}
		
		if (arg0.getActionCommand().equals("Clear")) {
			
			this.input.setText(null);
			
			this.output.setText(null);
			
		}
		
		if (arg0.getActionCommand().equals("Quit")) {
			
			System.exit(0);
			
		}

	}
	
	
	public static void main (String[] args) {
		
		String title = "SqrtGui";
		
		SqrtGui gui = new SqrtGui(title);
		
		gui.setVisible(true);

		
	}

}
