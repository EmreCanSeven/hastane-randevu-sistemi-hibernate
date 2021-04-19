package arayuz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import impl.DoktorDaoImpl;
import impl.PoliklinikDaoImpl;
import model.Doktor;
import model.Poliklinik;

public class ArayuzPoliklinikDuzenleme extends javax.swing.JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAdi;
	
	private JFrame frame22;


	public ArayuzPoliklinikDuzenleme(Long id) {
		initialize(id);

	}

	public void initialize(Long id) {
		
		PoliklinikDaoImpl poliklinikDaoImpl = new PoliklinikDaoImpl();
		Poliklinik poliklinikSecilen = poliklinikDaoImpl.findById(id);

		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame22 = new JFrame();
		frame22.setBounds(100, 100, 875, 875);
		frame22.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame22.setTitle("Poliklinik Duzenleme Sayfasi");
		frame22.getContentPane().setLayout(null);

		int x =(screenSize.width - frame22.getWidth()) / 2;
		int y =(screenSize.height - frame22.getHeight()) / 2;

		frame22.setLocation(x, y);
		
		JLabel lblAdi = new JLabel("Adi : ");
		lblAdi.setBounds(10, 60, 107, 36);
		frame22.getContentPane().add(lblAdi);

		txtAdi= new JTextField();
		txtAdi.setBounds(130, 65, 175, 24);
		txtAdi.setBackground(Color.WHITE);
		frame22.getContentPane().add(txtAdi);
		txtAdi.setColumns(10);
		
		
		
		DoktorDaoImpl doktorDaoImpl = new DoktorDaoImpl();
		
		List<Doktor> doktorListesi = doktorDaoImpl.findAll();
		
		String[] s = new String[doktorListesi.size()];
		
		
		for(int j=0 ; j < doktorListesi.size(); j++) {
			
			Doktor doktorNesnesi = doktorListesi.get(j);
			
			String adi = doktorNesnesi.getAdi();
			
			s[j] = adi;
			
		}
		
		
	    final JComboBox comboboxDoktor = new JComboBox(s);    
	    
	    comboboxDoktor.getModel().setSelectedItem(poliklinikSecilen.getDoktor().getAdi());

	    comboboxDoktor.setBounds(130, 417,90,20);    
	    frame22.add(comboboxDoktor);
		
		
		JButton btnGuncelle= new JButton(" Guncelle ");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

 
			}

		});

		btnGuncelle.setBounds(10, 470, 175, 75);
		frame22.getContentPane().add(btnGuncelle);
		
		
		JButton btnSil= new JButton(" Sil ");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

 
			}

		});

		btnSil.setBounds(195, 470, 175, 75);
		frame22.getContentPane().add(btnSil);

		frame22.setVisible(true);
		pack();

	}


	public JFrame getFrame() {
		return frame22;
	}

	public void setFrame(JFrame frame21) {
		this.frame22 = frame21;
	}

}
