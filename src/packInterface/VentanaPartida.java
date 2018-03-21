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
import packModelo.Usuario.Usuario;
import packObservable.IObserver;
import packObservable.ObservableAbstracto;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.util.Observable;
import java.util.Observer;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.GridLayout;

public class VentanaPartida extends JFrame implements IObserver{

	private JPanel contentPane;
	private JPanel panel_1;
	private JButton btnBaraja;
	private JPanel colaEntrada;
	private JLabel[] cola;
	private JLabel[] mano;
	private JPanel manoJugador;
	
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
		contentPane.add(getPanel_1(), BorderLayout.WEST);
		contentPane.add(getBtnBaraja(), BorderLayout.EAST);
		contentPane.add(getColaEntrada(), BorderLayout.CENTER);
		contentPane.add(getManoJugador(), BorderLayout.SOUTH);
		ColaEntrada.getColaEntrada().registrarObservador(this);
		Jugador.getJugador().registrarObservador(this);
		BarBestial.getBarBestial().iniciarPartida();
		
		this.actualizarCola();
		this.actualizarMano();
		
		//Jugador.getJugador().addObserver(this);

	}

	/*Se encarga de inicializar la cola, aun falta poner como colocar las fotos segun fuerza y eso */
	private void actualizarCola() {
		cola=new JLabel[5];	
		cola[0]=new JLabel();
		
		
		cola[1]=new JLabel();
		
		cola[2]=new JLabel();
		
		cola[3]=new JLabel();
		
		cola[4]=new JLabel();
		
		for(int i=0; i<5;i++) {
			int fuerza=ColaEntrada.getColaEntrada().getLista().getFuerzaPosicion(i);
			cola[i].setIcon(this.getImagen(fuerza));
		}
		colaEntrada.removeAll();
		colaEntrada.add(cola[0]);
		colaEntrada.add(cola[1]);
		colaEntrada.add(cola[2]);
		colaEntrada.add(cola[3]);
		colaEntrada.add(cola[4]);
	}
	
	public ImageIcon getImagen(int pFuerza) {
		ImageIcon imagen;
		switch(pFuerza){
			case 1:
				imagen = new ImageIcon(getClass().getResource("/packImagen/mofeta.png"));
				break;
			case 2:
				imagen = new ImageIcon(getClass().getResource("/packImagen/loro.png"));
				break;
			case 3:
				imagen = new ImageIcon(getClass().getResource("/packImagen/canguro.png"));
				break;
			case 4:
				imagen = new ImageIcon(getClass().getResource("/packImagen/mono.png"));
				break;
			case 5:
				imagen = new ImageIcon(getClass().getResource("/packImagen/camaleon.png"));
				break;
			case 6:
				imagen = new ImageIcon(getClass().getResource("/packImagen/foca.png"));
				break;
			case 7:
				imagen = new ImageIcon(getClass().getResource("/packImagen/cebra.png"));
				break;
			case 8:
				imagen = new ImageIcon(getClass().getResource("/packImagen/jirafa.png"));
				break;
			case 9:
				imagen = new ImageIcon(getClass().getResource("/packImagen/serpiente.png"));
				break;
			case 10:
				imagen = new ImageIcon(getClass().getResource("/packImagen/cocodrilo.png"));
				break;
			case 11:
				imagen = new ImageIcon(getClass().getResource("/packImagen/hipopotamo.png"));
				break;
			case 12:
				imagen = new ImageIcon(getClass().getResource("/packImagen/leon.png"));
				break;
			default:
				imagen = new ImageIcon(getClass().getResource("/packImagen/transparente.png"));
				break;
		}
		return imagen;
	}
	private void actualizarMano() {
		mano=new JLabel[4];
		mano[0]=new JLabel();
		mano[0].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				Jugador.getJugador().echarCarta(0);
			}
		});

		mano[1]=new JLabel();
		mano[1].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				Jugador.getJugador().echarCarta(1);
			}
		});
		mano[2]=new JLabel();
		mano[2].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				Jugador.getJugador().echarCarta(2);
			}
		});

		mano[3]=new JLabel();
		mano[3].addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				Jugador.getJugador().echarCarta(3);
			}
		});
		int fuerza;
		for(int i=0; i<Jugador.getJugador().getListaManos().longitud();i++) {
			fuerza=Jugador.getJugador().getListaManos().getFuerzaPosicion(i);
			mano[i].setIcon(this.getImagen(fuerza));
		}
		
		manoJugador.removeAll();
		manoJugador.add(mano[0]);
		manoJugador.add(mano[1]);
		manoJugador.add(mano[2]);
		manoJugador.add(mano[3]);
		
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
	private JPanel getColaEntrada() {
		if (colaEntrada == null) {
			colaEntrada = new JPanel();
			colaEntrada.setLayout(new GridLayout(1, 5, 0, 0));
		}
		return colaEntrada;
	}
	
	private class ControladorListaDeCartas extends WindowAdapter implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String action=e.getActionCommand();
			Jugador.getJugador().imprimirmano();
			if(action.equals("Baraja")){//falta meter turnos y comprobar si el jugador tiene algun hueco libre en la mano
				Jugador.getJugador().cogerCarta();
			}
		}
		
	}

	@Override
	public void update(ObservableAbstracto pObservable) {
		if (pObservable instanceof ColaEntrada){
			//System.out.println("Update ventana partida");	
			this.actualizarCola();
			this.colaEntrada.updateUI();
			this.colaEntrada.repaint();}
		else if(pObservable instanceof Usuario) {
			//System.out.println("Update mano");	
			this.actualizarMano();
			this.manoJugador.updateUI();
			this.manoJugador.repaint();
			System.out.println("mano jugador");
			Jugador.getJugador().imprimirmano();
			}
		}
	private JPanel getManoJugador() {
		if (manoJugador == null) {
			manoJugador = new JPanel();
			manoJugador.setLayout(new GridLayout(1, 4, 0, 0));
		}
		return manoJugador;
	}
}


