package co.unicauca.eattogo.presentation.intarface;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import co.unicauca.eattogo.domain.command.Invoker;
import co.unicauca.eattogo.domain.command.CreateCommand;
import co.unicauca.eattogo.access.LunchConsumer;
import co.unicauca.eattogo.domain.entity.DayEnum;
import co.unicauca.eattogo.domain.entity.LunchPart;
import co.unicauca.eattogo.domain.entity.LunchPartTypeEnum;
import co.unicauca.eattogo.domain.service.ConsumerLunchService;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.SystemColor;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.CardLayout;
import javax.swing.JSeparator;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSplitPane;
import java.awt.event.MouseAdapter;
/**
 * Interfaz de usuario para el registro del menu semanal
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class GUIAddMenu extends JInternalFrame implements ActionListener, InternalFrameListener, MouseListener {

	private JLabel lblRegistroMenuSemanal;
	private JPanel panel;
	private JLabel lblLunes;
	private JLabel lblMartes;
	private JLabel lblMiercoles;
	private JLabel lblJueves;
	private JLabel lblViernes;
	private JLabel lblSabado;
	private JLabel lblDomingo;
	private JTabbedPane tabbedPane;
	private JPanel panelEntrada;
	private JPanel panelPrincipio;
	private JPanel panelProteina;
	private JLabel lblNombrePlatoPrin;
	private JTextField txtNombreEntrada;
	private JLabel lblImagenEntrada;
	private JPanel panelImagenPlatoPrin;
	private JLabel lblNombreBebida;
	private JTextField txtNombreProteina;
	private JPanel panelImagenBebida;
	private JLabel lblImagenProteina;
	private JLabel lblNombrePostre;
	private JTextField txtNombrePrincipio;
	private JPanel panelImagenPostre;
	private JLabel lblImagenPrincipio;
	private JButton btnRegistrarEntrada;
	private JButton btnRegistrarPrincipio;
	private JButton btnRegistrarProteina;
	private JLabel lblNewLabel;
	private JLabel lblIconLunes;
	private JLabel lblIconMartes;
	private JLabel lblIconMiercoles;
	private JLabel lblIconJueves;
	private JLabel lblIconViernes;
	private JLabel lblIconSabado;
	private JLabel lblIconDomingo;

	public static String menu;
	public static JFileChooser chooser;

	public static MouseEvent event;
	private JPanel panelBebida;
	private JLabel lblNombre;
	private JTextField txtNombreBebida;
	private JPanel panelImagenBebida_1;
	private JLabel lblImagenBebida;
	private JButton btnRegistrarBebida;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private JTable tableRegBebida;
	private JLabel lblNewLabel_1;
	private JPanel panel_2;
	private JScrollPane scrollPane_1;
	private JTable tableRegProteina;
	private JLabel lblNewLabel_2;
	private JPanel panel_3;
	private JScrollPane scrollPane_2;
	private JTable tableRegPrincipio;
	private JLabel lblNewLabel_3;
	private JPanel panel_4;
	private JScrollPane scrollPane_3;
	private JTable tableRegEntrada;
	private JLabel lblNewLabel_4;
	private JButton btnBorrarEntrada;
	private JButton btnBorrarProteina;
	private JButton btnBorrarBebida;
	private JButton btnBorrarPrincipio;
	private JPanel panel_5;
	private JLabel lblNewLabel_5;
	private JTextField textPrecioAlmuerzo;
	private JButton btnRegPrecio;
	
	private DayEnum daySelected;
	public static Long idRestaurant;
	public static int priceMenu;
	private boolean priceEntered = false;
	private JTable actualTable; 
	private LunchPartTypeEnum actualLunchType;
	private List<LunchPart> components = new ArrayList<>();
	private ConsumerLunchService cService;
	
	// Patrón Command
	private Invoker invoker;
	private JButton btnDeshacerProt;
	private JButton btnDeshacerPrin;
	private JButton btnDeshacerBeb;
	private JButton btnDeshacerEntr;

	/**
	 * Create the frame.
	 */
	public GUIAddMenu() {
		event = null;
		invoker = new Invoker();
		setFrameIcon(new ImageIcon(
				"C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Dish-Service\\src\\main\\resources\\templates\\notas.png"));
		setTitle("Registro Menu");
		menu = "menu";

		addInternalFrameListener(this);
		setClosable(true);
		setIconifiable(true);
		setBounds(100, 100, 784, 518);
		getContentPane().setLayout(null);

		lblRegistroMenuSemanal = new JLabel("Registro Menu Semanal");
		lblRegistroMenuSemanal.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistroMenuSemanal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRegistroMenuSemanal.setBounds(270, 24, 250, 24);
		getContentPane().add(lblRegistroMenuSemanal);

		panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Seleccione el dia:", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		panel.setBounds(10, 207, 250, 270);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblLunes = new JLabel("Lunes");
		lblLunes.addMouseListener(this);
		lblLunes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLunes.setBounds(87, 36, 110, 14);
		panel.add(lblLunes);

		lblMartes = new JLabel("Martes");
		lblMartes.addMouseListener(this);
		lblMartes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMartes.setBounds(87, 71, 110, 14);
		panel.add(lblMartes);

		lblMiercoles = new JLabel("Miercoles");
		lblMiercoles.addMouseListener(this);
		lblMiercoles.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMiercoles.setBounds(87, 105, 110, 14);
		panel.add(lblMiercoles);

		lblJueves = new JLabel("Jueves");
		lblJueves.addMouseListener(this);
		lblJueves.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblJueves.setBounds(87, 138, 110, 14);
		panel.add(lblJueves);

		lblViernes = new JLabel("Viernes");
		lblViernes.addMouseListener(this);
		lblViernes.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblViernes.setBounds(87, 170, 110, 14);
		panel.add(lblViernes);

		lblSabado = new JLabel("Sabado");
		lblSabado.addMouseListener(this);
		lblSabado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSabado.setBounds(87, 204, 110, 14);
		panel.add(lblSabado);

		lblDomingo = new JLabel("Domingo");
		lblDomingo.addMouseListener(this);
		lblDomingo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDomingo.setBounds(87, 232, 110, 23);
		panel.add(lblDomingo);

		lblIconLunes = new JLabel("");
		lblIconLunes.setEnabled(false);
		lblIconLunes.setIcon(new ImageIcon(
				"src\\main\\resources\\templates\\aplicar.png"));
		lblIconLunes.setBounds(52, 32, 25, 25);
		panel.add(lblIconLunes);

		lblIconMartes = new JLabel("");
		lblIconMartes.setEnabled(false);
		lblIconMartes.setIcon(new ImageIcon(
				"src\\main\\resources\\templates\\aplicar.png"));
		lblIconMartes.setBounds(52, 66, 25, 25);
		panel.add(lblIconMartes);

		lblIconMiercoles = new JLabel("");
		lblIconMiercoles.setEnabled(false);
		lblIconMiercoles.setIcon(new ImageIcon(
				"src\\main\\resources\\templates\\aplicar.png"));
		lblIconMiercoles.setBounds(52, 99, 25, 25);
		panel.add(lblIconMiercoles);

		lblIconJueves = new JLabel("");
		lblIconJueves.setEnabled(false);
		lblIconJueves.setIcon(new ImageIcon(
				"src\\main\\resources\\templates\\aplicar.png"));
		lblIconJueves.setBounds(52, 132, 25, 25);
		panel.add(lblIconJueves);

		lblIconViernes = new JLabel("");
		lblIconViernes.setEnabled(false);
		lblIconViernes.setIcon(new ImageIcon(
				"src\\main\\resources\\templates\\aplicar.png"));
		lblIconViernes.setBounds(52, 164, 25, 25);
		panel.add(lblIconViernes);

		lblIconSabado = new JLabel("");
		lblIconSabado.setEnabled(false);
		lblIconSabado.setIcon(new ImageIcon(
				"src\\main\\resources\\templates\\aplicar.png"));
		lblIconSabado.setBounds(52, 198, 25, 25);
		panel.add(lblIconSabado);

		lblIconDomingo = new JLabel("");
		lblIconDomingo.setEnabled(false);
		lblIconDomingo.setIcon(new ImageIcon(
				"src\\main\\resources\\templates\\aplicar.png"));
		lblIconDomingo.setBounds(52, 230, 25, 25);
		panel.add(lblIconDomingo);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.setFont(new Font("Tahoma", Font.BOLD, 12));
		tabbedPane.setBounds(295, 73, 463, 404);
		getContentPane().add(tabbedPane);

		panelEntrada = new JPanel();
		panelEntrada.setToolTipText("");
		tabbedPane.addTab("Entrada", null, panelEntrada, null);
		panelEntrada.setLayout(null);

		lblNombrePlatoPrin = new JLabel("Nombre:");
		lblNombrePlatoPrin.setBounds(30, 26, 85, 14);
		panelEntrada.add(lblNombrePlatoPrin);

		txtNombreEntrada = new JTextField();
		txtNombreEntrada.setBounds(30, 51, 197, 20);
		txtNombreEntrada.setBackground(SystemColor.window);
		panelEntrada.add(txtNombreEntrada);
		txtNombreEntrada.setColumns(10);

		panelImagenPlatoPrin = new JPanel();
		panelImagenPlatoPrin.setBounds(31, 105, 175, 127);
		panelImagenPlatoPrin.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Subir Imagen:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelEntrada.add(panelImagenPlatoPrin);
		panelImagenPlatoPrin.setLayout(null);

		lblImagenEntrada = new JLabel("");
		lblImagenEntrada.setIcon(new ImageIcon(
				"C:\\Users\\yefer\\OneDrive\\Documentos\\GitHub\\Eat_To_Go\\Dish-Service\\src\\main\\resources\\templates\\adjuntar.png"));
		lblImagenEntrada.addMouseListener(this);
		lblImagenEntrada.setBounds(10, 21, 155, 95);
		panelImagenPlatoPrin.add(lblImagenEntrada);
		lblImagenEntrada.setForeground(SystemColor.desktop);
		lblImagenEntrada.setBackground(SystemColor.controlDkShadow);
		lblImagenEntrada.setHorizontalAlignment(SwingConstants.CENTER);

		btnRegistrarEntrada = new JButton("Registrar");
		btnRegistrarEntrada.setIcon(new ImageIcon(
				"src\\main\\resources\\templates\\agregar.png"));
		btnRegistrarEntrada.setBounds(30, 340, 133, 28);
		btnRegistrarEntrada.addActionListener(this);
		btnRegistrarEntrada.setFont(new Font("Tahoma", Font.BOLD, 12));
		panelEntrada.add(btnRegistrarEntrada);

		panel_4 = new JPanel();
		panel_4.setBounds(251, 51, 197, 275);
		panelEntrada.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));

		scrollPane_3 = new JScrollPane();
		panel_4.add(scrollPane_3, "name_1205226693995755");

		tableRegEntrada = new JTable();
		tableRegEntrada.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre" }) {
			Class[] columnTypes = new Class[] { String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_3.setViewportView(tableRegEntrada);

		lblNewLabel_4 = new JLabel("Entradas Registradas");
		lblNewLabel_4.setBounds(251, 26, 197, 14);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panelEntrada.add(lblNewLabel_4);

		btnBorrarEntrada = new JButton("Borrar");
		btnBorrarEntrada.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBorrarEntrada.setBounds(305, 341, 122, 28);
		btnBorrarEntrada.setIcon(new ImageIcon(
				"src\\main\\resources\\templates\\remove.png"));
		panelEntrada.add(btnBorrarEntrada);
		
		btnDeshacerEntr = new JButton("Deshacer");
		btnDeshacerEntr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeshacerActionPerformed(e);
			}
		});
		btnDeshacerEntr.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeshacerEntr.setBounds(173, 340, 122, 28);
		panelEntrada.add(btnDeshacerEntr);

		panelProteina = new JPanel();
		tabbedPane.addTab("Proteina", null, panelProteina, null);
		panelProteina.setLayout(null);

		lblNombreBebida = new JLabel("Nombre:");
		lblNombreBebida.setBounds(30, 26, 95, 14);
		panelProteina.add(lblNombreBebida);

		txtNombreProteina = new JTextField();
		txtNombreProteina.setColumns(10);
		txtNombreProteina.setBackground(Color.WHITE);
		txtNombreProteina.setBounds(30, 51, 197, 20);
		panelProteina.add(txtNombreProteina);

		panelImagenBebida = new JPanel();
		panelImagenBebida.setLayout(null);
		panelImagenBebida.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Subir Imagen:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelImagenBebida.setBounds(30, 102, 168, 130);
		panelProteina.add(panelImagenBebida);

		lblImagenProteina = new JLabel("");
		lblImagenProteina.addMouseListener(this);
		lblImagenProteina.setIcon(new ImageIcon("C:\\Users\\yefer\\OneDrive\\Documentos\\GitHub\\Eat_To_Go\\Dish-Service\\src\\main\\resources\\templates\\adjuntar.png"));
		lblImagenProteina.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenProteina.setForeground(Color.BLACK);
		lblImagenProteina.setBackground(SystemColor.controlDkShadow);
		lblImagenProteina.setBounds(10, 21, 148, 98);
		panelImagenBebida.add(lblImagenProteina);

		btnRegistrarProteina = new JButton("Registrar");
		btnRegistrarProteina.setIcon(new ImageIcon(
				"C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Dish-Service\\src\\main\\resources\\templates\\agregar.png"));
		btnRegistrarProteina.addActionListener(this);
		btnRegistrarProteina.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrarProteina.setBounds(70, 340, 117, 28);
		panelProteina.add(btnRegistrarProteina);

		panel_2 = new JPanel();
		panel_2.setBounds(251, 51, 197, 275);
		panelProteina.add(panel_2);
		panel_2.setLayout(new CardLayout(0, 0));

		scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, "name_1205028687722782");

		tableRegProteina = new JTable();
		tableRegProteina.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre" }) {
			Class[] columnTypes = new Class[] { String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_1.setViewportView(tableRegProteina);

		lblNewLabel_2 = new JLabel("Proteinas Registradas");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(291, 26, 118, 14);
		panelProteina.add(lblNewLabel_2);

		btnBorrarProteina = new JButton("Borrar");
		btnBorrarProteina.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrarProteina.setIcon(new ImageIcon(
				"C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Dish-Service\\src\\main\\resources\\templates\\remove.png"));
		btnBorrarProteina.setBounds(305, 341, 98, 28);
		panelProteina.add(btnBorrarProteina);
		
		btnDeshacerProt = new JButton("Deshacer");
		btnDeshacerProt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeshacerActionPerformed(e);
			}
		});
		btnDeshacerProt.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDeshacerProt.setBounds(197, 340, 98, 27);
		panelProteina.add(btnDeshacerProt);

		panelPrincipio = new JPanel();

		tabbedPane.addTab("Principio", null, panelPrincipio, null);
		panelPrincipio.setLayout(null);

		lblNombrePostre = new JLabel("Nombre:");
		lblNombrePostre.setBounds(30, 26, 95, 14);
		panelPrincipio.add(lblNombrePostre);

		txtNombrePrincipio = new JTextField();
		txtNombrePrincipio.setColumns(10);
		txtNombrePrincipio.setBackground(Color.WHITE);
		txtNombrePrincipio.setBounds(30, 51, 197, 20);
		panelPrincipio.add(txtNombrePrincipio);

		panelImagenPostre = new JPanel();
		panelImagenPostre.setLayout(null);
		panelImagenPostre.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Subir Imagen:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelImagenPostre.setBounds(30, 101, 169, 120);
		panelPrincipio.add(panelImagenPostre);

		lblImagenPrincipio = new JLabel("");
		lblImagenPrincipio.addMouseListener(this);
		lblImagenPrincipio.setIcon(new ImageIcon("C:\\Users\\yefer\\OneDrive\\Documentos\\GitHub\\Eat_To_Go\\Dish-Service\\src\\main\\resources\\templates\\adjuntar.png"));
		lblImagenPrincipio.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenPrincipio.setForeground(Color.BLACK);
		lblImagenPrincipio.setBackground(SystemColor.controlDkShadow);
		lblImagenPrincipio.setBounds(10, 21, 149, 88);
		panelImagenPostre.add(lblImagenPrincipio);

		btnRegistrarPrincipio = new JButton("Registrar");
		btnRegistrarPrincipio.setIcon(new ImageIcon(
				"C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Dish-Service\\src\\main\\resources\\templates\\agregar.png"));
		btnRegistrarPrincipio.addActionListener(this);
		btnRegistrarPrincipio.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrarPrincipio.setBounds(56, 340, 117, 28);
		panelPrincipio.add(btnRegistrarPrincipio);

		panel_3 = new JPanel();
		panel_3.setBounds(251, 51, 197, 275);
		panelPrincipio.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));

		scrollPane_2 = new JScrollPane();
		panel_3.add(scrollPane_2, "name_1205092167109315");

		tableRegPrincipio = new JTable();
		tableRegPrincipio.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre" }) {
			Class[] columnTypes = new Class[] { String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_2.setViewportView(tableRegPrincipio);

		lblNewLabel_3 = new JLabel("Principios Registrados");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(300, 26, 104, 14);
		panelPrincipio.add(lblNewLabel_3);

		btnBorrarPrincipio = new JButton("Borrar");
		btnBorrarPrincipio.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrarPrincipio.setIcon(new ImageIcon(
				"C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Dish-Service\\src\\main\\resources\\templates\\remove.png"));
		btnBorrarPrincipio.setBounds(305, 341, 98, 27);
		panelPrincipio.add(btnBorrarPrincipio);
		
		btnDeshacerPrin = new JButton("Deshacer");
		btnDeshacerPrin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeshacerActionPerformed(e);
			}
		});
		btnDeshacerPrin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeshacerPrin.setBounds(183, 340, 112, 28);
		panelPrincipio.add(btnDeshacerPrin);

		panelBebida = new JPanel();
		tabbedPane.addTab("Bebida", null, panelBebida, null);
		panelBebida.setLayout(null);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(30, 26, 95, 14);
		panelBebida.add(lblNombre);

		txtNombreBebida = new JTextField();
		txtNombreBebida.setColumns(10);
		txtNombreBebida.setBackground(Color.WHITE);
		txtNombreBebida.setBounds(30, 51, 197, 20);
		panelBebida.add(txtNombreBebida);

		panelImagenBebida_1 = new JPanel();
		panelImagenBebida_1.setLayout(null);
		panelImagenBebida_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Subir Imagen:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelImagenBebida_1.setBounds(30, 100, 170, 132);
		panelBebida.add(panelImagenBebida_1);

		lblImagenBebida = new JLabel("");
		lblImagenBebida.addMouseListener(this);
		lblImagenBebida.setIcon(new ImageIcon("C:\\Users\\yefer\\OneDrive\\Documentos\\GitHub\\Eat_To_Go\\Dish-Service\\src\\main\\resources\\templates\\adjuntar.png"));
		lblImagenBebida.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenBebida.setForeground(Color.BLACK);
		lblImagenBebida.setBackground(SystemColor.controlDkShadow);
		lblImagenBebida.setBounds(10, 21, 150, 100);
		panelImagenBebida_1.add(lblImagenBebida);

		btnRegistrarBebida = new JButton("Registrar");

		btnRegistrarBebida.setIcon(new ImageIcon(
				"C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Dish-Service\\src\\main\\resources\\templates\\agregar.png"));
		btnRegistrarBebida.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrarBebida.setBounds(68, 340, 117, 28);
		btnRegistrarBebida.addActionListener(this);
		panelBebida.add(btnRegistrarBebida);

		panel_1 = new JPanel();
		panel_1.setBounds(251, 51, 197, 275);
		panelBebida.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, "name_1204680562865074");

		tableRegBebida = new JTable();
		tableRegBebida.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Nombre" }) {
			Class[] columnTypes = new Class[] { String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tableRegBebida);

		lblNewLabel_1 = new JLabel("Bebidas Registradas");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(298, 26, 103, 14);
		panelBebida.add(lblNewLabel_1);

		btnBorrarBebida = new JButton("Borrar");
		btnBorrarBebida.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrarBebida.setIcon(new ImageIcon(
				"C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Dish-Service\\src\\main\\resources\\templates\\remove.png"));
		btnBorrarBebida.setBounds(305, 341, 98, 28);
		panelBebida.add(btnBorrarBebida);
		
		btnDeshacerBeb = new JButton("Deshacer");
		btnDeshacerBeb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDeshacerActionPerformed(e);
			}
		});
		btnDeshacerBeb.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeshacerBeb.setBounds(195, 340, 100, 28);
		panelBebida.add(btnDeshacerBeb);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(681, 11, 77, 70);
		getContentPane().add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("src\\main\\resources\\templates\\logo1.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		panel_5 = new JPanel();
		panel_5.setBorder(
				new TitledBorder(null, "Precio Almuerzo:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 73, 250, 123);
		getContentPane().add(panel_5);
		panel_5.setLayout(null);

		lblNewLabel_5 = new JLabel("Digite el Precio:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(20, 33, 119, 14);
		panel_5.add(lblNewLabel_5);

		textPrecioAlmuerzo = new JTextField();
		textPrecioAlmuerzo.setColumns(10);
		textPrecioAlmuerzo.setBounds(20, 58, 184, 20);
		panel_5.add(textPrecioAlmuerzo);

		btnRegPrecio = new JButton("Registrar Precio");
		btnRegPrecio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int pr = Integer.parseInt(textPrecioAlmuerzo.getText());
				priceMenu = pr;
				System.out.println("precio: " + pr);
				priceEntered = true;
			}
		});
		btnRegPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegPrecio.setBounds(49, 89, 145, 23);
		panel_5.add(btnRegPrecio);

		LunchConsumer lc = new LunchConsumer();
		cService = new ConsumerLunchService(lc);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrarEntrada) {
			actionPerformedBtnRegistrarEntrada(e);
		}
		if (e.getSource() == btnRegistrarPrincipio) {
			actionPerformedBtnRegistrarPrincipio(e);
		}
		if (e.getSource() == btnRegistrarProteina) {
			actionPerformedBtnRegistrarProteina(e);
		}
		if (e.getSource() == btnRegistrarBebida) {
			actionPerformedBtnRegistrarBebida(e);
		}

	}

	// -----EVENTS------ //

	/**
	 * Evento del boton registrar entrada
	 * 
	 * @param e evento
	 */
	protected void actionPerformedBtnRegistrarEntrada(ActionEvent e) {

		if (priceEntered) {
			if (event != null) {
				actualTable = tableRegEntrada;
				actualLunchType = LunchPartTypeEnum.ENTRADA;
				// Esta primera seccion del metodo se guardara la imagen del plato seleccionado
				// en la carpeta del proyecto
				String pathImage = copyImage();
				String nameDish = this.txtNombreEntrada.getText();
				saveLunchPart(8L, idRestaurant, nameDish, actualLunchType, pathImage);

				// Actualizar tabla
				updateTable(cService, actualTable, actualLunchType);
				clearControls();
				activarIcono(event);
			}
			else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un día");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe ingresar el precio de los almuerzos");
			textPrecioAlmuerzo.requestFocus();
		}

	}

	/**
	 * Evento del boton registrar principio
	 * 
	 * @param e evento
	 */
	protected void actionPerformedBtnRegistrarPrincipio(ActionEvent e) {

		if (priceEntered) {
			if (event != null) {
				actualTable = tableRegPrincipio;
				actualLunchType = LunchPartTypeEnum.PRINCIPIO;
				
				// Esta primera seccion del metodo se guardara la imagen del plato seleccionado
				// en la carpeta del proyecto
				String pathImage = copyImage();
				String nameDish = this.txtNombrePrincipio.getText();
				saveLunchPart(8L, idRestaurant, nameDish, actualLunchType, pathImage);
	
				// Actualizar tabla
				updateTable(cService, actualTable, actualLunchType);
				clearControls();
				activarIcono(event);
			}
			else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un día");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe ingresar el precio de los almuerzos");
			textPrecioAlmuerzo.requestFocus();
		}

	}

	/**
	 * Evento del boton registrar proteina
	 * 
	 * @param e evento
	 */
	protected void actionPerformedBtnRegistrarProteina(ActionEvent e) {
		
		if (priceEntered) {
			if(event != null) {
				actualTable = tableRegProteina;
				actualLunchType = LunchPartTypeEnum.PROTEINA;
				
				// Esta primera seccion del metodo se guardara la imagen del plato seleccionado
				// en la carpeta del proyecto
				String pathImage = copyImage();
	
				String nameDish = this.txtNombreProteina.getText();
				saveLunchPart(8L, idRestaurant, nameDish, actualLunchType, pathImage);
				
				// Actualizar tabla
				updateTable(cService, actualTable, actualLunchType);
				clearControls();
				activarIcono(event);
			}
			else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un día");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe ingresar el precio de los almuerzos");
			textPrecioAlmuerzo.requestFocus();
		}

	}

	/**
	 * Evento del boton registrar bebida
	 * 
	 * @param e evento
	 */
	protected void actionPerformedBtnRegistrarBebida(ActionEvent e) {

		if (priceEntered) {
			if (event != null) {
				actualTable = tableRegBebida;
				actualLunchType = LunchPartTypeEnum.JUGO;
				
				// Esta primera seccion del metodo se guardara la imagen del plato seleccionado
				// en la carpeta del proyecto
				String pathImage = copyImage();
				
				String nameDish = this.txtNombreBebida.getText();
				saveLunchPart(8L, idRestaurant, nameDish, actualLunchType, pathImage);
	
				// Actualizar tabla
				updateTable(cService, actualTable, actualLunchType);
				clearControls();
				activarIcono(event);
			}
			else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un día");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Debe ingresar el precio de los almuerzos");
			textPrecioAlmuerzo.requestFocus();
		}

	}
	
	private void saveLunchPart(Long id, Long idRest, String name, LunchPartTypeEnum type, String pathImage) {
		LunchPart objLunch = new LunchPart(8L, idRestaurant, name, type, daySelected, pathImage);
		//Fija el comando del invoker
        invoker.setCommand(new CreateCommand(objLunch));
        //Ejecuta el comando
        invoker.execute();
        this.btnDeshacerEntr.setEnabled(invoker.hasCommandUndo());
	}

	private void updateTable(ConsumerLunchService cs, JTable actualTable, LunchPartTypeEnum typeSelected) {
		
		clearData((DefaultTableModel) actualTable.getModel());
		try {
			components = cs.ListByRestDayType(idRestaurant, daySelected, typeSelected);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (!components.isEmpty()) {
			loadDataTable(components, actualTable);
		}
	}

	/**
	 * Carga las comidas en el jTable
	 */
	private void loadDataTable(List<LunchPart> lunches, JTable table) {
		DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
		for (LunchPart component : lunches) {
			Object[] fila = new Object[1];
			fila[0] = component.getName();
			modelTable.addRow(fila);
		}
	}

	/**
	 * Elimina las filas del jTable
	 *
	 * @param modelTable modelo de datos del jTable
	 */
	private void clearData(DefaultTableModel modelTable) {
		while (modelTable.getRowCount() > 0) {
			modelTable.removeRow(0);
		}
	}

	/**
	 * Limpia los controles
	 */
	public void clearControls() {
		this.txtNombreBebida.setText("");
		this.txtNombreProteina.setText("");
		this.txtNombrePrincipio.setText("");
		this.txtNombreEntrada.setText("");
		this.lblImagenBebida.setIcon(new ImageIcon(
				"C:\\Users\\yefer\\OneDrive\\Documentos\\GitHub\\Eat_To_Go\\Dish-Service\\src\\main\\resources\\templates\\adjuntar.png"));
		this.lblImagenEntrada.setIcon(new ImageIcon(
				"C:\\Users\\yefer\\OneDrive\\Documentos\\GitHub\\Eat_To_Go\\Dish-Service\\src\\main\\resources\\templates\\adjuntar.png"));
		this.lblImagenPrincipio.setIcon(new ImageIcon(
				"C:\\Users\\yefer\\OneDrive\\Documentos\\GitHub\\Eat_To_Go\\Dish-Service\\src\\main\\resources\\templates\\adjuntar.png"));
		this.lblImagenProteina.setIcon(new ImageIcon(
				"C:\\Users\\yefer\\OneDrive\\Documentos\\GitHub\\Eat_To_Go\\Dish-Service\\src\\main\\resources\\templates\\adjuntar.png"));

	}

	private String copyImage() {
		String pathImage = "src\\main\\resources\\templates\\ImegenesPlatos\\" + chooser.getSelectedFile().getName();
		System.out.println(pathImage);
		try {
			Files.copy(Paths.get(chooser.getSelectedFile().toURI()), Paths.get(pathImage));
		} catch (IOException ex) {
			ex.printStackTrace();
			return "";
		}
		return pathImage;
	}

	protected void activarIcono(MouseEvent e) {
		if (e.getSource() == lblDomingo) {
			lblIconDomingo.setEnabled(true);
		}
		if (e.getSource() == lblSabado) {
			lblIconSabado.setEnabled(true);
		}
		if (e.getSource() == lblViernes) {
			lblIconViernes.setEnabled(true);
		}
		if (e.getSource() == lblJueves) {
			lblIconJueves.setEnabled(true);
		}
		if (e.getSource() == lblMiercoles) {
			lblIconMiercoles.setEnabled(true);
		}
		if (e.getSource() == lblMartes) {
			lblIconMartes.setEnabled(true);
		}
		if (e.getSource() == lblLunes) {
			lblIconLunes.setEnabled(true);
		}

		// PARA IMAGEN DE REGISTRAR PRINCIPIO

	}
	
	protected void desactivarIcono(MouseEvent e) {
		if (e.getSource() == lblDomingo) {
			lblIconDomingo.setEnabled(false);
		}
		if (e.getSource() == lblSabado) {
			lblIconSabado.setEnabled(false);
		}
		if (e.getSource() == lblViernes) {
			lblIconViernes.setEnabled(false);
		}
		if (e.getSource() == lblJueves) {
			lblIconJueves.setEnabled(false);
		}
		if (e.getSource() == lblMiercoles) {
			lblIconMiercoles.setEnabled(false);
		}
		if (e.getSource() == lblMartes) {
			lblIconMartes.setEnabled(false);
		}
		if (e.getSource() == lblLunes) {
			lblIconLunes.setEnabled(false);
		}

		// PARA IMAGEN DE REGISTRAR PRINCIPIO

	}


	// -------------------------------------------------------------

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
		menu = null;
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
		if (e.getSource() == lblImagenProteina) {
			mousePressedLblImagenProteina(e);
		}
		if (e.getSource() == lblImagenPrincipio) {
			mousePressedLblImagenEntrada(e);
		}
		if (e.getSource() == lblImagenEntrada) {
			mousePressedLblImagenPrincipio(e);
		}
		if (e.getSource() == lblImagenBebida) {
			mousePressedLblImagenBebida(e);
		}
		if (e.getSource() == lblDomingo) {
			reiniciar(e);
			mousePressedLblDomingo(e);
			event = e;
		}
		if (e.getSource() == lblSabado) {
			reiniciar(e);
			;
			mousePressedLblSabado(e);
			event = e;
		}
		if (e.getSource() == lblViernes) {
			reiniciar(e);
			mousePressedLblViernes(e);
			event = e;
		}
		if (e.getSource() == lblJueves) {
			reiniciar(e);
			mousePressedLblJueves(e);
			event = e;
		}
		if (e.getSource() == lblMiercoles) {
			reiniciar(e);
			mousePressedLblMiercoles(e);
			event = e;
		}
		if (e.getSource() == lblMartes) {
			reiniciar(e);
			mousePressedLblMartes(e);
			event = e;
		}
		if (e.getSource() == lblLunes) {
			reiniciar(e);
			mousePressedLblLunes(e);
			event = e;
		}
	}

	public void mouseReleased(MouseEvent e) {
	}

	// Eventos y funciones necesarias para conocer día y tipo de plato seleccionado

	protected void reiniciar(MouseEvent e) {
		Font font = new Font("Tahoma", Font.BOLD, 14);

		lblLunes.setFont(font);
		lblLunes.setForeground(Color.GRAY);
		lblMartes.setFont(font);
		lblMartes.setForeground(Color.GRAY);
		lblMiercoles.setFont(font);
		lblMiercoles.setForeground(Color.GRAY);
		lblJueves.setFont(font);
		lblJueves.setForeground(Color.GRAY);
		lblViernes.setFont(font);
		lblViernes.setForeground(Color.GRAY);
		lblSabado.setFont(font);
		lblSabado.setForeground(Color.GRAY);
		lblDomingo.setFont(font);
		lblDomingo.setForeground(Color.GRAY);
	}

	protected void mousePressedLblLunes(MouseEvent e) {
		Font font = new Font("Tahoma", Font.BOLD, 17);
		lblLunes.setFont(font);
		lblLunes.setForeground(Color.BLACK);
		daySelected = DayEnum.LUNES;
		if (this.tabbedPane.getSelectedComponent() == this.panelEntrada)
			updateTable(cService, tableRegEntrada, LunchPartTypeEnum.ENTRADA);
		else if (this.tabbedPane.getSelectedComponent() == this.panelPrincipio)
			updateTable(cService, tableRegPrincipio, LunchPartTypeEnum.PRINCIPIO);
		else if (this.tabbedPane.getSelectedComponent() == this.panelProteina)
			updateTable(cService, tableRegProteina, LunchPartTypeEnum.PROTEINA);
		else if (this.tabbedPane.getSelectedComponent() == this.panelBebida)
			updateTable(cService, tableRegBebida, LunchPartTypeEnum.JUGO);
		else
			System.out.println("_-----******-------");
	}

	protected void mousePressedLblMartes(MouseEvent e) {
		Font font = new Font("Tahoma", Font.BOLD, 17);
		lblMartes.setFont(font);
		lblMartes.setForeground(Color.BLACK);
		daySelected = DayEnum.MARTES;
		if (this.tabbedPane.getSelectedComponent() == this.panelEntrada)
			updateTable(cService, tableRegEntrada, LunchPartTypeEnum.ENTRADA);
		else if (this.tabbedPane.getSelectedComponent() == this.panelPrincipio)
			updateTable(cService, tableRegPrincipio, LunchPartTypeEnum.PRINCIPIO);
		else if (this.tabbedPane.getSelectedComponent() == this.panelProteina)
			updateTable(cService, tableRegProteina, LunchPartTypeEnum.PROTEINA);
		else if (this.tabbedPane.getSelectedComponent() == this.panelBebida)
			updateTable(cService, tableRegBebida, LunchPartTypeEnum.JUGO);
		else
			System.out.println("7777777777777777777");

	}

	protected void mousePressedLblMiercoles(MouseEvent e) {
		Font font = new Font("Tahoma", Font.BOLD, 17);
		lblMiercoles.setFont(font);
		lblMiercoles.setForeground(Color.BLACK);
		daySelected = DayEnum.MIERCOLES;
		if (this.tabbedPane.getSelectedComponent() == this.panelEntrada)
			updateTable(cService, tableRegEntrada, LunchPartTypeEnum.ENTRADA);
		else if (this.tabbedPane.getSelectedComponent() == this.panelPrincipio)
			updateTable(cService, tableRegPrincipio, LunchPartTypeEnum.PRINCIPIO);
		else if (this.tabbedPane.getSelectedComponent() == this.panelProteina)
			updateTable(cService, tableRegProteina, LunchPartTypeEnum.PROTEINA);
		else if (this.tabbedPane.getSelectedComponent() == this.panelBebida)
			updateTable(cService, tableRegBebida, LunchPartTypeEnum.JUGO);
		else
			System.out.println("11111111111111111111");

	}

	protected void mousePressedLblJueves(MouseEvent e) {
		Font font = new Font("Tahoma", Font.BOLD, 17);
		lblJueves.setFont(font);
		lblJueves.setForeground(Color.BLACK);
		daySelected = DayEnum.JUEVES;
		if (this.tabbedPane.getSelectedComponent() == this.panelEntrada)
			updateTable(cService, tableRegEntrada, LunchPartTypeEnum.ENTRADA);
		else if (this.tabbedPane.getSelectedComponent() == this.panelPrincipio)
			updateTable(cService, tableRegPrincipio, LunchPartTypeEnum.PRINCIPIO);
		else if (this.tabbedPane.getSelectedComponent() == this.panelProteina)
			updateTable(cService, tableRegProteina, LunchPartTypeEnum.PROTEINA);
		else if (this.tabbedPane.getSelectedComponent() == this.panelBebida)
			updateTable(cService, tableRegBebida, LunchPartTypeEnum.JUGO);
		else
			System.out.println("22222222222222222222");

	}

	protected void mousePressedLblViernes(MouseEvent e) {
		Font font = new Font("Tahoma", Font.BOLD, 17);
		lblViernes.setFont(font);
		lblViernes.setForeground(Color.BLACK);
		daySelected = DayEnum.VIERNES;
		if (this.tabbedPane.getSelectedComponent() == this.panelEntrada) {
			System.out.println(this.tabbedPane.getSelectedComponent().getName());
			updateTable(cService, tableRegEntrada, LunchPartTypeEnum.ENTRADA);
		} else if (this.tabbedPane.getSelectedComponent() == this.panelPrincipio)
			updateTable(cService, tableRegPrincipio, LunchPartTypeEnum.PRINCIPIO);
		else if (this.tabbedPane.getSelectedComponent() == this.panelProteina)
			updateTable(cService, tableRegProteina, LunchPartTypeEnum.PROTEINA);
		else if (this.tabbedPane.getSelectedComponent() == this.panelBebida)
			updateTable(cService, tableRegBebida, LunchPartTypeEnum.JUGO);
		else
			System.out.println("3333333333333333333");

	}

	protected void mousePressedLblSabado(MouseEvent e) {
		Font font = new Font("Tahoma", Font.BOLD, 17);
		lblSabado.setFont(font);
		lblSabado.setForeground(Color.BLACK);
		daySelected = DayEnum.SABADO;
		if (this.tabbedPane.getSelectedComponent() == this.panelEntrada)
			updateTable(cService, tableRegEntrada, LunchPartTypeEnum.ENTRADA);
		else if (this.tabbedPane.getSelectedComponent() == this.panelPrincipio)
			updateTable(cService, tableRegPrincipio, LunchPartTypeEnum.PRINCIPIO);
		else if (this.tabbedPane.getSelectedComponent() == this.panelProteina)
			updateTable(cService, tableRegProteina, LunchPartTypeEnum.PROTEINA);
		else if (this.tabbedPane.getSelectedComponent() == this.panelBebida)
			updateTable(cService, tableRegBebida, LunchPartTypeEnum.JUGO);
		else
			System.out.println("44444444444444444444");

	}

	protected void mousePressedLblDomingo(MouseEvent e) {
		Font font = new Font("Tahoma", Font.BOLD, 17);
		lblDomingo.setFont(font);
		lblDomingo.setForeground(Color.BLACK);
		daySelected = DayEnum.DOMINGO;
		if (this.tabbedPane.getSelectedComponent() == this.panelEntrada)
			updateTable(cService, tableRegEntrada, LunchPartTypeEnum.ENTRADA);
		else if (this.tabbedPane.getSelectedComponent() == this.panelPrincipio)
			updateTable(cService, tableRegPrincipio, LunchPartTypeEnum.PRINCIPIO);
		else if (this.tabbedPane.getSelectedComponent() == this.panelProteina)
			updateTable(cService, tableRegProteina, LunchPartTypeEnum.PROTEINA);
		else if (this.tabbedPane.getSelectedComponent() == this.panelBebida)
			updateTable(cService, tableRegBebida, LunchPartTypeEnum.JUGO);
		else
			System.out.println("55555555555555555555");

	}
	
	private void btnDeshacerActionPerformed(ActionEvent e) {
		 //Ejecuta el comando deshacer
        invoker.undo();
        updateTable(cService, actualTable, actualLunchType);
        //desactivarIcono();
        repaint();
        
        initStateButtons();
	}

	// Eventos y funcion para la carga de imágenes

	// Carga imagen para un principio
	protected void mousePressedLblImagenPrincipio(MouseEvent e) {
		seleccionarImagen(e);
	}

	// Carga imagen para un entrada
	protected void mousePressedLblImagenEntrada(MouseEvent e) {
		seleccionarImagen(e);
	}

	// Carga imagen para una bebida
	protected void mousePressedLblImagenBebida(MouseEvent e) {
		seleccionarImagen(e);
	}

	// Carga imagen para una proteina
	protected void mousePressedLblImagenProteina(MouseEvent e) {
		seleccionarImagen(e);
	}

	protected void seleccionarImagen(MouseEvent e) {
		this.chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & JPEG & PNG", "jpg", "jpeg", "png");
		chooser.setFileFilter(filter);

		int seleccion = chooser.showOpenDialog(this);

		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File f = chooser.getSelectedFile();
			ImageIcon i = null;

			try {
				i = new ImageIcon(f.toURI().toURL());
			} catch (MalformedURLException ex) {
				System.out.println("Error al buscar la imagen");
			}

			if (e.getSource() == lblImagenEntrada) {
				lblImagenEntrada.setIcon(new ImageIcon(i.getImage().getScaledInstance(lblImagenEntrada.getWidth(),
						lblImagenEntrada.getHeight(), Image.SCALE_SMOOTH)));
			}

			if (e.getSource() == lblImagenPrincipio) {
				lblImagenPrincipio.setIcon(new ImageIcon(i.getImage().getScaledInstance(lblImagenPrincipio.getWidth(),
						lblImagenPrincipio.getHeight(), Image.SCALE_SMOOTH)));
			}

			if (e.getSource() == lblImagenProteina) {
				lblImagenProteina.setIcon(new ImageIcon(i.getImage().getScaledInstance(lblImagenProteina.getWidth(),
						lblImagenProteina.getHeight(), Image.SCALE_SMOOTH)));
			}
			
			if (e.getSource() == lblImagenBebida) {
				lblImagenBebida.setIcon(new ImageIcon(i.getImage().getScaledInstance(lblImagenBebida.getWidth(),
						lblImagenBebida.getHeight(), Image.SCALE_SMOOTH)));
			}
		}
		
		
	}
	
	/**
     * Poner los botones en su estado inicial
     */
    private void initStateButtons() {
        btnBorrarBebida.setEnabled(false);
        btnDeshacerEntr.setEnabled(invoker.hasCommandUndo());
    }
}
