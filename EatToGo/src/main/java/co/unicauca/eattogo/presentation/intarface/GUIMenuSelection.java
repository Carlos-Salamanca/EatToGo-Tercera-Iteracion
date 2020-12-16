package co.unicauca.eattogo.presentation.intarface;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;
import java.awt.CardLayout;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import co.unicauca.eattogo.access.LunchConsumer;
import co.unicauca.eattogo.domain.entity.DayEnum;
import co.unicauca.eattogo.domain.entity.LunchPart;
import co.unicauca.eattogo.domain.entity.LunchPartTypeEnum;
import co.unicauca.eattogo.domain.service.ConsumerLunchService;

import javax.swing.event.InternalFrameEvent;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
/**
 * Interfaz de selecion del menu
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class GUIMenuSelection extends JInternalFrame implements InternalFrameListener, ActionListener {
	private JLabel lblNewLabel;
	private JButton btnRegresarSeleccion;
	private JButton btnAgregarCarrito;
	private JButton btnIrCarrito;
	private JPanel panel;
	private JPanel panel_4;
	private JScrollPane scrollPaneEntrada;
	private JTable tableEntrada;
	private JPanel panel_5;
	private JScrollPane scrollPanePrincipio;
	private JTable tablePrincipio;
	private JPanel panel_6;
	private JScrollPane scrollPaneProteina;
	private JTable tableProteina;
	
	public static String selection;
	private JPanel panel_7;
	private JScrollPane scrollPaneBebida;
	private JTable tableBebida;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	
	private ConsumerLunchService cService;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	public static DayEnum actualDay = DayEnum.MIERCOLES;
	private List<LunchPart> auxListlunches = new ArrayList<>();
	private List<LunchPart> lunches;


	/**
	 * Create the frame.
	 */
	public GUIMenuSelection() {
		setFrameIcon(new ImageIcon("C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Dish-Service\\src\\main\\resources\\templates\\menu.png"));
		setTitle("Menu");
		selection = "selection";
		
		addInternalFrameListener(this);
		setIconifiable(true);
		setClosable(true);	
		setBounds(100, 100, 871, 650);
		getContentPane().setLayout(null);
		
		if(GUIRestaurentes.nameRest.length() == 0) {
			lblNewLabel = new JLabel("Nombre Restaurante");
		}
		else {
			lblNewLabel = new JLabel(GUIRestaurentes.nameRest);
		}
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(350, 11, 194, 44);
		//lblNewLabel.setHorizontalAlignment(1);
		getContentPane().add(lblNewLabel);
		
		btnRegresarSeleccion = new JButton("Regresar");
		btnRegresarSeleccion.addActionListener(this);
		btnRegresarSeleccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegresarSeleccion.setBounds(161, 565, 89, 23);
		getContentPane().add(btnRegresarSeleccion);
		
		btnAgregarCarrito = new JButton("Agregar al Carrito");
		btnAgregarCarrito.addActionListener(this);
		btnAgregarCarrito.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregarCarrito.setBounds(344, 565, 146, 23);
		btnAgregarCarrito.setEnabled(false);
		getContentPane().add(btnAgregarCarrito);
		
		btnIrCarrito = new JButton("Ir al Carrito");
		btnIrCarrito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUICommunerClient.iniciarGUIOrderSummary();
			}
		});
		btnIrCarrito.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnIrCarrito.setBounds(582, 565, 109, 23);
		getContentPane().add(btnIrCarrito);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Menu del dia de hoy: " + actualDay, TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(10, 66, 835, 474);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBounds(10, 96, 191, 294);
		panel.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));
		
		scrollPaneEntrada = new JScrollPane();
		panel_4.add(scrollPaneEntrada, "name_795165422814059");
		
		tableEntrada = new JTable();
		tableEntrada.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Imagen", "Nombre"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		scrollPaneEntrada.setViewportView(tableEntrada);
		tableEntrada.getSelectedRow();
		
		panel_5 = new JPanel();
		panel_5.setBounds(211, 96, 205, 294);
		panel.add(panel_5);
		panel_5.setLayout(new CardLayout(0, 0));
		
		scrollPanePrincipio = new JScrollPane();
		
		panel_5.add(scrollPanePrincipio, "name_795256069810640");
		
		tablePrincipio = new JTable();
		tablePrincipio.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Imagen", "Nombre"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		scrollPanePrincipio.setViewportView(tablePrincipio);
		
		
		panel_6 = new JPanel();
		panel_6.setBounds(426, 96, 197, 294);
		panel.add(panel_6);
		panel_6.setLayout(new CardLayout(0, 0));
		
		scrollPaneProteina = new JScrollPane();
		
		panel_6.add(scrollPaneProteina, "name_795279270019807");
		
		tableProteina = new JTable();
		tableProteina.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Imagen", "Nombre"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		scrollPaneProteina.setViewportView(tableProteina);
		
		panel_7 = new JPanel();
		panel_7.setBounds(633, 96, 192, 294);
		panel.add(panel_7);
		panel_7.setLayout(new CardLayout(0, 0));
		
		scrollPaneBebida = new JScrollPane();
		panel_7.add(scrollPaneBebida, "name_1207852848850961");
		
		tableBebida = new JTable();
		tableBebida.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Imagen", "Nombre"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		scrollPaneBebida.setViewportView(tableBebida);
		
		lblNewLabel_7 = new JLabel("Entrada");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(73, 71, 56, 14);
		panel.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Principio");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(276, 71, 72, 14);
		panel.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Proteina");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(489, 71, 72, 14);
		panel.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Bebida");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(696, 71, 56, 14);
		panel.add(lblNewLabel_10);
		
		if(GUIAddMenu.priceMenu == 0) {
			GUIAddMenu.priceMenu = 4500;
		}
		lblNewLabel_1 = new JLabel("Precio Almuerzo: " + GUIAddMenu.priceMenu);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(10, 429, 334, 14);
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Combina tu Almuerzo: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 36, 191, 14);
		panel.add(lblNewLabel_2);
		
			
		// Eventos de tablas
		
		tableEntrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enableBtnAgregarCarrito();
			}
		});
		
		tablePrincipio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enableBtnAgregarCarrito();
			}
		});
		
		tableProteina.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enableBtnAgregarCarrito();
			}
		});
		
		tableBebida.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				enableBtnAgregarCarrito();
			}
		});
		
		lunches = new ArrayList<>();
		LunchConsumer lc = new LunchConsumer();
		cService = new ConsumerLunchService(lc);
		
	}
	
	public void loadTables() {
		Long idRestaurant = GUIRestaurentes.idRestSelected;
		loadTbl(tableEntrada, idRestaurant, actualDay, LunchPartTypeEnum.ENTRADA);
		loadTbl(tablePrincipio, idRestaurant, actualDay, LunchPartTypeEnum.PRINCIPIO);
		loadTbl(tableProteina, idRestaurant, actualDay, LunchPartTypeEnum.PROTEINA);
		loadTbl(tableBebida, idRestaurant, actualDay, LunchPartTypeEnum.JUGO);
	}
	
	private void loadTbl(JTable table, Long idRestaurant, DayEnum day, LunchPartTypeEnum typeLunch) {
		clearData((DefaultTableModel) table.getModel());
		
		try {
			this.auxListlunches = cService.ListByRestDayType(idRestaurant, day, typeLunch);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (!this.auxListlunches.isEmpty()) {
			lunches.addAll(auxListlunches);
			loadDataTable(this.auxListlunches, table);
		}
	}
	
	/**
	 * Carga las comidas en el jTable
	 */
	private void loadDataTable(List<LunchPart> lunches, JTable table) {
		this.auxListlunches = lunches;
		table.setDefaultRenderer(Object.class, new ImgTable());
		
		TableColumn column = table.getColumnModel().getColumn(0);
		column.setPreferredWidth(70);
	    column.setMaxWidth(70);
	    column.setMinWidth(70);
	    table.setRowHeight(70);
		DefaultTableModel modelTable = (DefaultTableModel) table.getModel();
		for (LunchPart component : lunches) {
			Object[] fila = new Object[2];
			ImageIcon fot = new ImageIcon(component.getImage());
			fila[0] = new JLabel(new ImageIcon(fot.getImage().getScaledInstance(column.getMaxWidth(), table.getRowHeight(), Image.SCALE_DEFAULT)));
			fila[1] = component.getName();
			
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
		selection = null;
		GUICommunerClient.visibleRestaurante(true);
		dispose();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAgregarCarrito) {
			actionPerformedBtnAgregarCarrito(e);
		}
		if (e.getSource() == btnRegresarSeleccion) {
			actionPerformedBtnRegresarSeleccion(e);
		}
	}
	protected void actionPerformedBtnRegresarSeleccion(ActionEvent e) {
		GUICommunerClient.botonRegresarMenuSelection();
	}
	
	protected void enableBtnAgregarCarrito() {
		int filaEnt = tableEntrada.getSelectedRow();
		int filaPrinc = tablePrincipio.getSelectedRow();
		int filaProt = tableProteina.getSelectedRow();
		int filaBeb = tableBebida.getSelectedRow();
		
		if(filaEnt != -1 && filaPrinc != -1 &&  filaProt != -1 &&  filaBeb != -1) {
			
			btnAgregarCarrito.setEnabled(true);
		}
		else {
			btnAgregarCarrito.setEnabled(false);
		}
	}
	
	protected void actionPerformedBtnAgregarCarrito(ActionEvent e) {
		if (tableEntrada.getSelectedRow() == -1 || tablePrincipio.getSelectedRow() == -1 || 
				tableProteina.getSelectedRow() == -1 || tableBebida.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(null, "Faltan platos por seleccionar");
			return;
		}
		
		String entr = (String) tableEntrada.getValueAt(tableEntrada.getSelectedRow(), 1);
		String princ = (String) tablePrincipio.getValueAt(tablePrincipio.getSelectedRow(), 1);
		String prot = (String) tableProteina.getValueAt(tableProteina.getSelectedRow(), 1);
		String beb = (String) tableBebida.getValueAt(tableBebida.getSelectedRow(), 1);
		
		ArrayList<LunchPart> aux = new ArrayList<>();
		for(LunchPart lu: lunches) {
			if(lu.getType() == LunchPartTypeEnum.ENTRADA && lu.getName().compareTo(entr)==0)
				aux.add(lu);
			else if(lu.getType() == LunchPartTypeEnum.PRINCIPIO && lu.getName().compareTo(princ)==0)
				aux.add(lu);
			else if(lu.getType() == LunchPartTypeEnum.PROTEINA && lu.getName().compareTo(prot)==0)
				aux.add(lu);
			else if(lu.getType() == LunchPartTypeEnum.JUGO && lu.getName().compareTo(beb)==0)
				aux.add(lu);
		}
		
		GUIOrderSummary.summaryOrder.add(aux);
		

	}
	
	/**
	 * Clase interna que permite agregar una imagen a una tabla
	 * 
	 */
	private class ImgTable extends DefaultTableCellRenderer{
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object obj, boolean bln, boolean bln1, int i, int i1) {
			if (obj instanceof JLabel) {
				JLabel jlblAux = (JLabel) obj;
				return jlblAux;
			}
			return super.getTableCellRendererComponent(table, obj, bln, bln1, i, i1); //to change body of generate
		}
		
	}
	
}
