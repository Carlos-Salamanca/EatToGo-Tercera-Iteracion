package co.unicauca.eattogo.presentation.intarface;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;

import co.unicauca.eattogo.access.OrderConsumer;
import co.unicauca.eattogo.domain.entity.LunchClient;
import co.unicauca.eattogo.domain.entity.LunchPart;
import co.unicauca.eattogo.domain.entity.LunchPartTypeEnum;
import co.unicauca.eattogo.domain.entity.Order;
import co.unicauca.eattogo.domain.service.ConsumerOrderService;
/**
 * Interfaz del resumen de los almuerzos deseados
 * 
 * @author Christian Tobar, Juliana Mora, Yeferson Benavides, Alejandro Latorre,
 *         Carlos Salamanca
 *
 */
public class GUIOrderSummary extends JInternalFrame {
	private JLabel lblNewLabel;
	private JPanel panel;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnRegresarResumen;
	private JButton btnPedir;
	
	public static String summary;
	public static ArrayList<ArrayList<LunchPart>> summaryOrder = new ArrayList<>();
	//public static ArrayList<LunchPart> summaryOrder;
	private JButton btnBorrarItemCanasta;
	public static ArrayList<Order> orders;
	private Order order;
	private ConsumerOrderService cService;
	
	
	/**
	 * Create the frame.
	 */
	public GUIOrderSummary() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				summary = null;
				GUICommunerClient.visibleSelection(true);
				dispose();
			}
		});
		setIconifiable(true);
		setFrameIcon(new ImageIcon("C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Dish-Service\\src\\main\\resources\\templates\\carro-de-la-compra (1).png"));
		summary = "summary";
		
		setTitle("Canasta Pedidos");
		setBounds(100, 100, 547, 480);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Resumen Pedido");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(170, 11, 182, 43);
		getContentPane().add(lblNewLabel);
		
		panel = new JPanel();
		panel.setBounds(10, 51, 511, 329);
		getContentPane().add(panel);
		panel.setLayout(new CardLayout(0, 0));
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane, "name_800954736428268");
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Entrada", "Principio", "Proteina", "Bebida", "Subtotal"
			}
		));
		scrollPane.setViewportView(table);
		
		btnRegresarResumen = new JButton("Regresar");
		btnRegresarResumen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GUICommunerClient.botonRegresarOrderSummary();
			}
		});
		btnRegresarResumen.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegresarResumen.setBounds(10, 414, 89, 28);
		getContentPane().add(btnRegresarResumen);
		
		btnPedir = new JButton("Pedir $");
		btnPedir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("sizeof orders:" +  orders.size());
				for(Order or : orders) {
					System.out.println("tostring: "+ or.toString());
					try {
						boolean response = cService.create(or);
					} catch (HttpClientErrorException k1) {
						System.out.println("Http code is not 2XX. The server responded: " + k1.getStatusCode() + " Cause: "
								+ k1.getResponseBodyAsString());
					} catch (RestClientException k) {
						System.out.println("The server didn't respond: " + k.getMessage());
					} catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
				JOptionPane.showMessageDialog(null, "Pedido realizado");
			}
		});
		btnPedir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPedir.setBounds(170, 414, 191, 28);
		getContentPane().add(btnPedir);
		
		btnBorrarItemCanasta = new JButton("Borrar");
		btnBorrarItemCanasta.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBorrarItemCanasta.setIcon(new ImageIcon("C:\\Users\\Personal\\eclipse-workspace\\Microservicios-Spring-Boot\\Product-Service\\src\\main\\resources\\templates\\remove.png"));
		btnBorrarItemCanasta.setBounds(430, 415, 91, 28);
		getContentPane().add(btnBorrarItemCanasta);
		
		order = new Order();
		orders = new ArrayList<>();
		OrderConsumer oc = new OrderConsumer();
		cService = new ConsumerOrderService(oc);
		
		loadDataTable(table);
		
		btnPedir.setText(btnPedir.getText() + (GUIAddMenu.priceMenu*table.getRowCount()));
	}

	/**
	 * Carga las comidas en el jTable
	 */
	private static void loadDataTable(JTable jtable) {
		
		DefaultTableModel modelTable = (DefaultTableModel) jtable.getModel();
		Object[] fila = new Object[5];
		// ArrayList<LunchClient> lunchClients = new ArrayList<>();
		LunchClient auxLunCli = new LunchClient();
		Order or;

		for (int i = 0; i < summaryOrder.size(); i++) {
			or = new Order();
			//or.setId(i+1L);
			for (int j = 0; j < summaryOrder.get(0).size(); j++) {
				
				LunchPartTypeEnum type = summaryOrder.get(i).get(j).getType();
				Long idPart = summaryOrder.get(i).get(j).getId();
				if (type == LunchPartTypeEnum.ENTRADA) {
					fila[0] = summaryOrder.get(i).get(j).getName();
					auxLunCli.setEntryId(idPart);
				}
				if (type == LunchPartTypeEnum.PRINCIPIO) {
					fila[1] = summaryOrder.get(i).get(j).getName();
					auxLunCli.setSideDishId(idPart);
				}
				if (type == LunchPartTypeEnum.PROTEINA) {
					fila[2] = summaryOrder.get(i).get(j).getName();
					auxLunCli.setProteinId(idPart);
				}
				if (type == LunchPartTypeEnum.JUGO) {
					fila[3] = summaryOrder.get(i).get(j).getName();
					auxLunCli.setDrinkId(idPart);
				}
			}
			
			fila[4] = GUIAddMenu.priceMenu + "";
			auxLunCli.setPrice(GUIAddMenu.priceMenu);

			or.setLunchClient(auxLunCli);
			orders.add(or);
			// lunchClients.add(auxLunCli);
			// order.setLunchClients(lunchClients);
			modelTable.addRow(fila);
		}
		
	} 

}
