package co.unicauca.eattogo.presentation.intarface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JLabel;
/**
 * Intefaz contenedora de los JInternalFrame
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class GUICommuner extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu JMenu1;
	private JMenuItem JMenuItemRegMenuSem;
	private JMenu JMenuSistema;
	private JMenuItem JMenuItemSistemaCerrar;
	private JDesktopPane escritorio;


	/**
	 * Create the frame.
	 */
	public GUICommuner() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Dish-Service\\src\\main\\resources\\templates\\logo1.png"));
		setTitle("Eat To Go");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 452);
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		setJMenuBar(menuBar);
		
		JMenu1 = new JMenu("Administrador");
		menuBar.add(JMenu1);
		
		JMenuItemRegMenuSem = new JMenuItem("Registrar Menu Semanal");
		JMenuItemRegMenuSem.setIcon(new ImageIcon("C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Product-Service\\src\\main\\resources\\templates\\agregar.png"));
		JMenuItemRegMenuSem.addActionListener(this);
		JMenu1.add(JMenuItemRegMenuSem);
		
		JMenuSistema = new JMenu("Sistema");
		menuBar.add(JMenuSistema);
		
		JMenuItemSistemaCerrar = new JMenuItem("Cerrar");
		JMenuItemSistemaCerrar.addActionListener(this);
		JMenuItemSistemaCerrar.setIcon(new ImageIcon("C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Product-Service\\src\\main\\resources\\templates\\cerrar.png"));
		JMenuSistema.add(JMenuItemSistemaCerrar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		escritorio = new JDesktopPane();
		escritorio.setBackground(SystemColor.activeCaption);
		contentPane.add(escritorio, BorderLayout.CENTER);
		escritorio.setLayout(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == JMenuItemSistemaCerrar) {
			actionPerformedJMenuItemSistemaCerrar(e);
		}
		if (e.getSource() == JMenuItemRegMenuSem) {
			actionPerformedJMenuItemRegistroMenu(e);
		}
	}
	
	protected void actionPerformedJMenuItemRegistroMenu(ActionEvent e) {
		String m = GUIAddMenu.menu;
		try {
			if(m == null) {
				GUIAddMenu menu = new GUIAddMenu();
				//aqui centramos la ventana de GUIAddMenu dentro de GUICommuner
				menu.setLocation((escritorio.getWidth() / 2) - (menu.getWidth() /2) , (escritorio.getHeight() / 2) - (menu.getHeight() /2));
				escritorio.add(menu);
				menu.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "La ventana ya esta abierta.");
			}
		}catch(Exception exp) {
			
		}
		
	}
	
	protected void actionPerformedJMenuItemSistemaCerrar(ActionEvent e) {
		dispose();
	}
	
	
}
