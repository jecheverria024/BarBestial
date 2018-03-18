package packInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import packModelo.BarBestial;
import packModelo.ColaEntrada;
import packModelo.Usuario.Jugador;
import packObservable.IObserver;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.GridLayout;

public class VentanaPartida extends JFrame implements IObserver  {

	private JPanel contentPane;
	private JPanel panel;
	private JButton carta1;
	private JButton carta2;
	private JButton carta3;
	private JButton carta4;
	private JPanel panel_1;
	private JButton btnBaraja;
	private JPanel panel_2;
	private JLabel[] cola;
	
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
		System.out.println("qwerty");
		ColaEntrada.getColaEntrada().registrarObservador(this);
		
		BarBestial.getBarBestial().iniciarPartida();
		
		this.getCola();
	
		
		//Jugador.getJugador().addObserver(this);

	}

	/*Se encarga de inicializar la cola, aun falta poner como colocar las fotos segun fuerza y eso */
	private void getCola() {
		cola=new JLabel[5];
		cola[0]=new JLabel();
		if(ColaEntrada.getColaEntrada().le()!=0) {
			
		ImageIcon imagen = new ImageIcon(getClass().getResource("/packImagen/leon.jpg"));
		
		cola[0]=new JLabel(imagen);
		}
		cola[1]=new JLabel();
		cola[2]=new JLabel();
		cola[3]=new JLabel();
		cola[4]=new JLabel();
		
		panel_2.add(cola[0]);
		panel_2.add(cola[1]);
		panel_2.add(cola[2]);
		panel_2.add(cola[3]);
		panel_2.add(cola[4]);
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
		if (carta1 == null) {
			carta1 = new JButton("1");
			carta1.addActionListener(new ControladorListaDeCartas());
			carta1.setActionCommand("1");
			
			
		}
		return carta1;
	}
	private JButton getButton_1() {
		if (carta2 == null) {
			carta2 = new JButton("2");
			carta2.addActionListener(new ControladorListaDeCartas());
			carta2.setActionCommand("2");
		}
		return carta2;
	}
	private JButton getButton_2() {
		if (carta3 == null) {
			carta3 = new JButton("3");
			carta3.addActionListener(new ControladorListaDeCartas());
			carta3.setActionCommand("3");
		}
		return carta3;
	}
	private JButton getButton_3() {
		if (carta4 == null) {
			carta4 = new JButton("4");
			carta4.addActionListener(new ControladorListaDeCartas());
			carta4.setActionCommand("4");
		}
		return carta4;
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
			btnBaraja.addActionListener(new ControladorListaDeCartas());
			btnBaraja.setActionCommand("Baraja");
		}
		return btnBaraja;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new GridLayout(1, 5, 0, 0));
		}
		return panel_2;
	}
	
	private class ControladorListaDeCartas extends WindowAdapter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String action=e.getActionCommand();
			Jugador.getJugador().imprimirmano();
			if(action.equals("Baraja")){//falta meter turnos y comprobar si el jugador tiene algun hueco libre en la mano
				Jugador.getJugador().cogerCarta();
			}else{
				Jugador.getJugador().echarCarta(Integer.parseInt(action)-1);
				
			}
			
		}
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.println("Update ventana partida");	
		this.getCola();
		this.panel_2.updateUI();
		this.panel_2.repaint();
	}
}
