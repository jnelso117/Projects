import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextPane;


public class UI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 552, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblMse = new JLabel("MSE");
		lblMse.setBounds(0, 0, 536, 131);
		frame.getContentPane().add(lblMse);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(89, 58, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setMinimum(50);
		scrollBar.setBlockIncrement(300);
		scrollBar.setBounds(519, 0, 17, 262);
		frame.getContentPane().add(scrollBar);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(49, 94, 243, 35);
		frame.getContentPane().add(textPane);
	}
}
