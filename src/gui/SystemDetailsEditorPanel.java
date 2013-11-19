package gui;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JLabel;


public class SystemDetailsEditorPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private StartKinoPanel startKinoPanel;
	/**
	 * Create the panel.
	 * @param startKinoPanel 
	 */
	public SystemDetailsEditorPanel(StartKinoPanel startKinoPanel) {
		this.startKinoPanel = startKinoPanel;
		
		setLayout(new BorderLayout(0, 0));
		
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(3, 10));
		add(separator, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_3.add(lblNewLabel);
		
		textField = new JTextField();
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_3.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_1.add(panel_4);
		
		JPanel panel = new JPanel();
		panel_2.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton = new JButton("Edit");
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Cancel");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Save");
		panel.add(btnNewButton_1);

	}

}
