package arayuz;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import impl.DoktorDaoImpl;
import model.Doktor;


public class ArayuzDoktorListeleme  extends  javax.swing.JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame5;
	
	
	private final JSplitPane splitPane; // split the window in top and bottom
	private final JPanel topPanel; // container panel for the top
	private final JPanel bottomPanel; // container panel for the bottom
	private final JScrollPane scrollPane; // makes the text scrollable
	private final JTextArea textArea; // the text
	private final JPanel inputPanel; // under the text a container for all the input elements
	private final JTextField textField; // a textField for the text the user inputs
	private final JButton button; // and a "send" button
	private javax.swing.JTable jTable_Display_Users;
	
	
	public ArayuzDoktorListeleme() {
		
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame5 = new JFrame();
		frame5.setBounds(100, 100, 875, 875);
		frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame5.setTitle(" Doktor Listeleme Sayfasi");
		frame5.getContentPane().setLayout(null);

		int x =(screenSize.width - frame5.getWidth()) / 2;
		int y =(screenSize.height - frame5.getHeight()) / 2;

		frame5.setLocation(x, y);
		
		
		
		splitPane = new JSplitPane();

		topPanel = new JPanel(); // our top component
		bottomPanel = new JPanel(); // our bottom component
		scrollPane = new JScrollPane(); // this scrollPane is used to make the text area scrollable
		textArea = new JTextArea(); // this text area will be put inside the scrollPane
		inputPanel = new JPanel();
		textField = new JTextField(); // first the input field where the user can type his text
		button = new JButton("send"); // and a button at the right, to send the text
		setPreferredSize(new Dimension(400, 400)); // let's open the window with a default size of 400x400 pixels
		getContentPane().setLayout(new GridLayout()); // the default GridLayout is like a grid with 1 column and 1 row,
		getContentPane().add(splitPane); // due to the GridLayout, our splitPane will now fill the whole window

		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT); // we want it to split the window verticaly
		splitPane.setDividerLocation(1); // the initial position of the divider is 200 (our window is 400 pixels high)
		/** top panelin yüksekliðini sýfýr yap **/
		splitPane.setTopComponent(topPanel); // at the top we want our "topPanel"
		splitPane.setBottomComponent(bottomPanel); // and at the bottom we want our "bottomPanel"

		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS)); // BoxLayout.Y_AXIS will arrange the

		
		ArrayList<Doktor> listGelen = getDoktorList();

		String[][] rec = tablogoster(listGelen);
		
		String[] header = { "id", "AD", "SOYAD" };
		JTable table = new JTable(rec, header);
		table.setSize(100, 100);

		JButton geriDon = new JButton("geri dön");
		geriDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ArayuzAdmin theWindow = new ArayuzAdmin();
							theWindow.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}

		});


		bottomPanel.add(scrollPane); // first we add the scrollPane to the bottomPanel, so it is at the top
		/** buraya tablo gelecek */ 
		scrollPane.setViewportView(table); // the scrollPane should make the textArea scrollable, so we define the
		// viewport
		bottomPanel.add(inputPanel); // then we add the inputPanel to the bottomPanel, so it under the scrollPane /
		inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75)); // we set the max height to 75 and the max
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS)); // X_Axis will arrange the content
		/** buraya butonlar gelecek **/ 
		inputPanel.add(button); // and right the "send" button
		inputPanel.add(geriDon);
		pack(); // calling pack() at the end, will ensure that every layout and size we just



	}
	
	public String[][] tablogoster(ArrayList<Doktor> list) {
		
		String[][] geriyeDonecegimDeger = new String[list.size()][4];
		
		String[] row = new String[4];
		
		int sayac = 0;
		for(int i = 0; i < list.size(); i++){
			
			long idGelen = list.get(i).getId(); 
			
			row[0] = String.valueOf(idGelen);
			row[1] = list.get(i).getAdi();
			row[2] = list.get(i).getSoyadi();
			
			for(int k=0 ; k <= 3 ; k++) {
				geriyeDonecegimDeger[sayac][k] = row[k];
			}
			
			sayac++;
		}
		
		return geriyeDonecegimDeger;
	}

	public ArrayList<Doktor> getDoktorList()
	{
		
		DoktorDaoImpl doktorDaoImpl = new DoktorDaoImpl();
		List<Doktor> geriDonenButunList = doktorDaoImpl.findAll();
		
		return (ArrayList<Doktor>) geriDonenButunList;
	}

	
	public JFrame getFrame() {
		return frame5;
	}

	public void setFrame(JFrame frame5) {
		this.frame5 = frame5;
	}
	

}
