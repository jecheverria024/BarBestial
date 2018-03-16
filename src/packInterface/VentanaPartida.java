package packInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class VentanaPartida extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton button;
	private JButton button_1;
	private JButton button_2;
	private JButton button_3;
	private JPanel panel_1;
	private JButton btnBaraja;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPartida frame = new VentanaPartida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPartida() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getPanel(), BorderLayout.SOUTH);
		contentPane.add(getPanel_1(), BorderLayout.WEST);
		contentPane.add(getBtnBaraja(), BorderLayout.EAST);
		contentPane.add(getPanel_2(), BorderLayout.CENTER);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
			panel.add(getButton());
			panel.add(getButton_1());
			panel.add(getButton_2());
			panel.add(getButton_3());
		}
		return panel;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("1");
			
			
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("2");
		}
		return button_1;
	}
	private JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("3");
		}
		return button_2;
	}
	private JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton("4");
		}
		return button_3;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new BorderLayout(0, 0));
		}
		return panel_1;
	}
	private JButton getBtnBaraja() {
		if (btnBaraja == null) {
			btnBaraja = new JButton("Baraja");
		}
		return btnBaraja;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
		}
		return panel_2;
	}
}
