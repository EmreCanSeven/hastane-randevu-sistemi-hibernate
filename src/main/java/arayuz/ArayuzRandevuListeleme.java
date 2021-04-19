package arayuz;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import impl.RandevuDaoImpl;
import model.Randevu;

public class ArayuzRandevuListeleme extends javax.swing.JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtRandevuTarihi;
	private JTextField txtPolikinlik;
	private JLabel lblRandevuTarihi;
	private JButton buttonDatePicker;
	private JTextField textDatePicker;


	private JFrame frame14;
	
	private final JSplitPane splitPane; // split the window in top and bottom
	private final JPanel topPanel; // container panel for the top
	private final JPanel bottomPanel; // container panel for the bottom
	private final JScrollPane scrollPane; // makes the text scrollable
	private final JTextArea textArea; // the text
	private final JPanel inputPanel; // under the text a container for all the input elements
	private final JTextField textField; // a textField for the text the user inputs
	private final JButton button; // and a "send" button
	private javax.swing.JTable jTable_Display_Users;


	public ArayuzRandevuListeleme() {
		
		

		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame14 = new JFrame();
		frame14.setBounds(100, 100, 875, 875);
		frame14.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame14.setTitle("Randevu Duzenleme Sayfasi");
		frame14.getContentPane().setLayout(null);

		int x =(screenSize.width - frame14.getWidth()) / 2;
		int y =(screenSize.height - frame14.getHeight()) / 2;

		frame14.setLocation(x, y);


		splitPane = new JSplitPane();

		topPanel = new JPanel(); // our top component
		bottomPanel = new JPanel(); // our bottom component

		// in our bottom panel we want the text area and the input components
		scrollPane = new JScrollPane(); // this scrollPane is used to make the text area scrollable
		textArea = new JTextArea(); // this text area will be put inside the scrollPane

		// the input components will be put in a separate panel
		inputPanel = new JPanel();
		textField = new JTextField(); // first the input field where the user can type his text
		button = new JButton("send"); // and a button at the right, to send the text

		// now lets define the default size of our window and its layout:
		setPreferredSize(new Dimension(400, 400)); // let's open the window with a default size of 400x400 pixels
		// the contentPane is the container that holds all our components
		getContentPane().setLayout(new GridLayout()); // the default GridLayout is like a grid with 1 column and 1 row,
		// we only add one element to the window itself
		getContentPane().add(splitPane); // due to the GridLayout, our splitPane will now fill the whole window

		// let's configure our splitPane:
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT); // we want it to split the window verticaly
		splitPane.setDividerLocation(1); // the initial position of the divider is 200 (our window is 400 pixels high)
		/** top panelin yüksekliðini sýfýr yap **/
		splitPane.setTopComponent(topPanel); // at the top we want our "topPanel"
		splitPane.setBottomComponent(bottomPanel); // and at the bottom we want our "bottomPanel"

		// our topPanel doesn't need anymore for this example. Whatever you want it to
		// contain, you can add it here
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS)); // BoxLayout.Y_AXIS will arrange the
		// content vertically

		
		ArrayList<Randevu> listGelen = getRandevuList();

		String[][] rec = tablogoster(listGelen);
		
		String[] header = { "id", "Randevu Tarihi", "Doktor Adi", "Hasta Adi", "Hastahane Adi", "Poliklinik Adi" };
		JTable table = new JTable(rec, header);
//		table.setSize(500, 500);
		//		topPanel.add(new JScrollPane(table));
		//		frame.add(topPanel);

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
		// textArea

		// let's set the maximum size of the inputPanel, so it doesn't get too big when
		// the user resizes the window
		inputPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75)); // we set the max height to 75 and the max
		// width to (almost) unlimited
		inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS)); // X_Axis will arrange the content
		// horizontally
		/** buraya butonlar gelecek **/ 
		//		inputPanel.add(textField); // left will be the textField
		inputPanel.add(button); // and right the "send" button
		inputPanel.add(geriDon);
		pack(); // calling pack() at the end, will ensure that every layout and size we just
		// defined gets applied before the stuff becomes visible

	}

	
	// String[] strArr = {"ali","asdas","eee"};
	// String[][] strArrArr = { {"ali","asdas","eee"}, {"asd", "fds", "sdfsd"}, {"as", "tytt", "123e" } };
	// Yonetici yon = new Yonetici(1, "asd", "sad", 100); --> bir yonetici nesnesi
	// List<Yonetici> yonList = ..... -> içinde farklý deðerlere sahip yonetici nesneleri olan liste
	
	public String[][] tablogoster(ArrayList<Randevu> list) {
		
		String[][] geriyeDonecegimDeger = new String[list.size()][6];
		
		String[] row = new String[6];
		
		int sayac = 0;
		for(int i = 0; i < list.size(); i++){
			
			long idGelen = list.get(i).getId(); 
			
			row[0] = String.valueOf(idGelen);
			
			row[1] = list.get(i).getRandevuTarihi().toString();
			
			String doktorAdi = list.get(i).getDoktor().getAdi() + " " + list.get(i).getDoktor().getSoyadi();
			
			row[2] = doktorAdi;
			
			String hastaAdi = list.get(i).getHasta().getAdi() + " " + list.get(i).getHasta().getSoyadi();
			
			row[3] = hastaAdi;
			
			String hastahaneAdi = list.get(i).getHastahane().getAdi();
			
			row[4] = hastahaneAdi;
			
			String poliklinikAdi = list.get(i).getPoliklinik().getAdi();
			
			row[5] = poliklinikAdi;
			
			
			//botun için 
			
			for(int k=0 ; k <= 5 ; k++) {
				geriyeDonecegimDeger[sayac][k] = row[k];
			}
			
			sayac++;
		}
		
		return geriyeDonecegimDeger;
	}

	public ArrayList<Randevu> getRandevuList()
	{
		
		RandevuDaoImpl randevuDaoImpl = new RandevuDaoImpl();
		List<Randevu> geriDonenButunList = randevuDaoImpl.findAll();
		
		return (ArrayList<Randevu>) geriDonenButunList;
	}

	public JFrame getFrame() {
		return frame14;
	}

	public void setFrame(JFrame frame14) {
		this.frame14 = frame14;
	}


}
