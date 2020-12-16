package co.unicauca.eattogo.presentation.intarface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
/**
 * Interfaz contenedora de los JInternalFrame
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class GUICommunerClient extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem JMenuClienteRealizarPed;
	private JMenu JMenuSistema;
	private JMenuItem mntmNewMenuItem;
	private static JDesktopPane escritoriCliente;
	
	private static GUIRestaurentes restaurante;
	private static GUIMenuSelection selection;
	private static GUIOrderSummary orderSummary;

	
	/**
	 * Create the frame.
	 */
	public GUICommunerClient() {
		setTitle("Eat To Go");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Dish-Service\\src\\main\\resources\\templates\\logo1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 615, 476);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Cliente");
		menuBar.add(mnNewMenu);
		
		JMenuClienteRealizarPed = new JMenuItem("Realizar Pedido");
		JMenuClienteRealizarPed.setIcon(new ImageIcon("C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Product-Service\\src\\main\\resources\\templates\\recibo-entrada.png"));
		JMenuClienteRealizarPed.addActionListener(this);
		mnNewMenu.add(JMenuClienteRealizarPed);
		
		JMenuSistema = new JMenu("Sistema");
		menuBar.add(JMenuSistema);
		
		mntmNewMenuItem = new JMenuItem("Cerrar");
		mntmNewMenuItem.addActionListener(this);
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Product-Service\\src\\main\\resources\\templates\\cerrar.png"));
		JMenuSistema.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		escritoriCliente = new JDesktopPane();
		escritoriCliente.setBackground(SystemColor.activeCaption);
		contentPane.add(escritoriCliente, BorderLayout.CENTER);
	}
	
	public static void iniciarGUIMenuSelection() {
		restaurante.setVisible(false);
//		restaurante.dispose();
		String m2 = GUIMenuSelection.selection;
		try {
			if(m2 == null) {
				selection = new GUIMenuSelection();
				//aqui centramos la ventana de GUIAddMenu dentro de GUICommuner
				selection.setLocation((escritoriCliente.getWidth() / 2) - (selection.getWidth() /2) , (escritoriCliente.getHeight() / 2) - (selection.getHeight() /2));
				escritoriCliente.add(selection);
				selection.setVisible(true);
				selection.loadTables();
			}else {
				JOptionPane.showMessageDialog(null, "La ventana ya esta abierta.");
			}
		}catch(Exception exp) {
				
		}
	}
	
	public static void iniciarGUIOrderSummary() {
		selection.setVisible(false);
//		restaurante.dispose();
		String m3 = GUIOrderSummary.summary;
		try {
			if(m3 == null) {
				orderSummary = new GUIOrderSummary();
				//aqui centramos la ventana de GUIAddMenu dentro de GUICommuner
				orderSummary.setLocation((escritoriCliente.getWidth() / 2) - (orderSummary.getWidth() /2) , (escritoriCliente.getHeight() / 2) - (orderSummary.getHeight() /2));
				escritoriCliente.add(orderSummary);
				orderSummary.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "La ventana ya esta abierta.");
			}
		}catch(Exception exp) {
				
		}
	}
	
	public static void botonRegresarOrderSummary() {
		orderSummary.summary = null;
		selection.setVisible(true);
		orderSummary.setVisible(false);
	}
	
	public static void botonRegresarMenuSelection() {
		selection.selection = null;
		restaurante.setVisible(true);
		selection.setVisible(false);
	}
	
	public static void visibleSelection(boolean visible) {
		selection.setVisible(visible);
	}
	
	public static void visibleRestaurante(boolean visible) {
		restaurante.setVisible(visible);
	}
	
	
	
	
	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmNewMenuItem) {
			actionPerformedMntmNewMenuItem(e);
		}
		if (e.getSource() == JMenuClienteRealizarPed) {
			actionPerformedJMenuClienteRealizarPed(e);
		}
	}
	
	protected void actionPerformedJMenuClienteRealizarPed(ActionEvent e) {
		String m = GUIRestaurentes.restaurante;
		try {
			if(m == null) {
				this.restaurante = new GUIRestaurentes();
				//aqui centramos la ventana de GUIAddMenu dentro de GUICommuner
				restaurante.setLocation((escritoriCliente.getWidth() / 2) - (restaurante.getWidth() /2) , (escritoriCliente.getHeight() / 2) - (restaurante.getHeight() /2));
				escritoriCliente.add(restaurante);
				restaurante.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "La ventana ya esta abierta.");
			}
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}
	protected void actionPerformedMntmNewMenuItem(ActionEvent e) {
		dispose();
	}
}
