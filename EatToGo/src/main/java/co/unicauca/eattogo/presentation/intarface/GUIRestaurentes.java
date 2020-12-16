package co.unicauca.eattogo.presentation.intarface;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameListener;
import javax.swing.event.InternalFrameEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingConstants;
/**
 * Interfaz de seleccion de restaurantes
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class GUIRestaurentes extends JInternalFrame implements InternalFrameListener{
	private JLabel lblNewLabel;
	private JPanel panel;
	
	public static String restaurante;
	public static ArrayList<Long> idsRest = new ArrayList<>();
	public static Long idRestSelected = 0L;
	public static String nameRest = "";
	private JLabel lblRest2;
	private JLabel lblRest_1;

	/**
	 * Create the frame.
	 */
	public GUIRestaurentes() {
		restaurante = "restaurante";
		
		setFrameIcon(new ImageIcon("C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Dish-Service\\src\\main\\resources\\templates\\tienda-de-alimentacion.png"));
		setTitle("Seleccionar Restaurante");
		setIconifiable(true);
		addInternalFrameListener(this);
		restaurante = "restaurante";
		
		setClosable(true);
		setBounds(100, 100, 656, 499);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Restaurantes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(254, 25, 146, 35);
		getContentPane().add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Elija su Restaurante", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 71, 620, 387);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		lblRest_1 = new JLabel("");
		lblRest_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource() == lblRest_1) {
					idRestSelected = idsRest.get(0);
					nameRest = "PioPio";
				}
				else if(e.getSource() == lblRest2) {
					idRestSelected = idsRest.get(1);
					nameRest = "El Quijote";
				}
				GUICommunerClient.iniciarGUIMenuSelection();
			}
		});
		lblRest_1.setBounds(36, 54, 250, 173);
		
		lblRest2 = new JLabel("");
		lblRest2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(e.getSource() == lblRest_1) {
					idRestSelected = idsRest.get(0);
					nameRest = "PioPio";
				}
				else if(e.getSource() == lblRest2) {
					idRestSelected = idsRest.get(1);
					nameRest = "El Quijote";
				}
				GUICommunerClient.iniciarGUIMenuSelection();
			}
		});
		
		lblRest2.setBounds(329, 54, 250, 173);
		
		ImageIcon fot = new ImageIcon("src\\main\\resources\\templates\\logo_piopio.png");
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblRest2.getWidth(), lblRest2.getHeight(), Image.SCALE_DEFAULT));
		lblRest_1.setIcon(icono);
		
		ImageIcon fot2 = new ImageIcon("src\\main\\resources\\templates\\logo_elquijote.jpg");
		Icon icono2 = new ImageIcon(fot2.getImage().getScaledInstance(lblRest2.getWidth(), lblRest2.getHeight(), Image.SCALE_DEFAULT));
		lblRest2.setIcon(icono2);
		
		panel.add(lblRest_1);
		panel.add(lblRest2);
		
		JLabel lblNewLabel_1 = new JLabel("PioPio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(136, 40, 56, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("El Quijote");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(414, 40, 75, 14);
		panel.add(lblNewLabel_2);

	}
	public void internalFrameActivated(InternalFrameEvent e) {
	}
	public void internalFrameClosed(InternalFrameEvent e) {
	}
	public void internalFrameClosing(InternalFrameEvent e) {
		if (e.getSource() == this) {
			internalFrameClosingThis(e);
		}
	}
	public void internalFrameDeactivated(InternalFrameEvent e) {
	}
	public void internalFrameDeiconified(InternalFrameEvent e) {
	}
	public void internalFrameIconified(InternalFrameEvent e) {
	}
	public void internalFrameOpened(InternalFrameEvent e) {
	}
	
	protected void internalFrameClosingThis(InternalFrameEvent e) {
		dispose();
		restaurante = null;
	}
}
