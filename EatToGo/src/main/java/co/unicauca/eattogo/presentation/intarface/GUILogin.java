package co.unicauca.eattogo.presentation.intarface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.transaction.Transactional.TxType;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * Interfaz de inicio de sesion
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class GUILogin extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnIniciarSesion;
	private JTextField textNombreUsuario;
	private JPasswordField passwordUsuario;
	
	//Cuentas adimistrador y cliente
	private String nombreAdministrador1;
	private String contraseñaAdministrador1;
	private String nombreAdministrador2;
	private String contraseñaAdministrador2;
	private String nombreCliente;
	private String contraseñaCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUILogin frame = new GUILogin();
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
	public GUILogin() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		/*
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == (KeyEvent.VK_ENTER)) {
					
				}
			}
		});
		*/
		//Inicializamos las cuentas del administrador y el cliente
		nombreAdministrador1 = "juan";
		contraseñaAdministrador1 = "123";
		nombreAdministrador2 = "pepe";
		contraseñaAdministrador2 = "123";
		nombreCliente = "alex";
		contraseñaCliente = "1234";
		
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Dish-Service\\src\\main\\resources\\templates\\recibo-entrada.png"));
		setTitle("Login");
		setBounds(100, 100, 469, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		lblNewLabel = new JLabel("Nombre de Usuario:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 32, 122, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Contraseña: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(70, 76, 122, 14);
		contentPane.add(lblNewLabel_1);
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(this);
		btnIniciarSesion.setIcon(null);
		btnIniciarSesion.setBounds(160, 115, 122, 29);
		contentPane.add(btnIniciarSesion);
		
		textNombreUsuario = new JTextField();
		textNombreUsuario.setBounds(220, 29, 161, 20);
		contentPane.add(textNombreUsuario);
		textNombreUsuario.setColumns(10);
		
		passwordUsuario = new JPasswordField();
		passwordUsuario.setBounds(220, 73, 161, 20);
		contentPane.add(passwordUsuario);
		
		
		// Datos de restaurantes
		if(!GUIRestaurentes.idsRest.contains(40L))
			GUIRestaurentes.idsRest.add(40L);
		if(!GUIRestaurentes.idsRest.contains(50L))
			GUIRestaurentes.idsRest.add(50L);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIniciarSesion) {
			actionPerformedBtnIniciarSesion(e);
		}
	}
	
	//Iniciar Sesion
	protected void actionPerformedBtnIniciarSesion(ActionEvent e) {
		
		if(textNombreUsuario.getText().compareToIgnoreCase(this.nombreAdministrador1) == 0 ) {
			GUIAddMenu.idRestaurant = GUIRestaurentes.idsRest.get(0);
			
			GUICommuner communer = new GUICommuner();
			communer.setExtendedState(MAXIMIZED_BOTH);
			communer.setVisible(true);
			
//			this.setVisible(false);
		}
		
		else if(textNombreUsuario.getText().compareToIgnoreCase(this.nombreAdministrador2) == 0 ) {
			GUIAddMenu.idRestaurant =  GUIRestaurentes.idsRest.get(1);
			
			GUICommuner communer = new GUICommuner();
			communer.setExtendedState(MAXIMIZED_BOTH);
			communer.setVisible(true);
			
//			this.setVisible(false);
		}
		
		else if(textNombreUsuario.getText().compareToIgnoreCase(this.nombreCliente) == 0 ) {
			GUICommunerClient communerClient = new GUICommunerClient();
			communerClient.setExtendedState(MAXIMIZED_BOTH);
			communerClient.setVisible(true);
				
//			this.setVisible(false);
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Los usuarios registrados actualmente son: \n juan (Administrador)\n pepe (Administrador)\n alex (Cliente)");
		}
		
	}
}
