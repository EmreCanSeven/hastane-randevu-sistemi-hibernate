package arayuz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import impl.DoktorDaoImpl;
import impl.HastaDaoImpl;
import impl.HastahaneDaoImpl;
import impl.PoliklinikDaoImpl;
import impl.RandevuDaoImpl;
import model.Doktor;
import model.Hasta;
import model.Hastahane;
import model.Poliklinik;
import model.Randevu;

public class ArayuzRandevuDuzenleme extends javax.swing.JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtRandevuTarihi;
	private JTextField txtPolikinlik;
	private JLabel lblRandevuTarihi;
	private JButton buttonDatePicker;
	private JTextField textDatePicker;

	private JFrame frame13;


	public ArayuzRandevuDuzenleme(Long id) {
		initialize(id);

	}

	public void initialize(final Long id) {
		
		RandevuDaoImpl r = new RandevuDaoImpl();
		Randevu secilenRandevu = r.findById(id);

		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame13 = new JFrame();
		frame13.setBounds(100, 100, 875, 875);
		frame13.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame13.setTitle("Randevu Duzenleme Sayfasi");
		frame13.getContentPane().setLayout(null);

		int x =(screenSize.width - frame13.getWidth()) / 2;
		int y =(screenSize.height - frame13.getHeight()) / 2;

		frame13.setLocation(x, y);

		lblRandevuTarihi = new JLabel("Randevu Tarihi : ");
		lblRandevuTarihi.setBounds(10, 10, 107, 36);
		frame13.getContentPane().add(lblRandevuTarihi);
		
		
		txtRandevuTarihi = new JTextField();
		txtRandevuTarihi.setBounds(130, 14, 175, 24);
		txtRandevuTarihi.setBackground(Color.WHITE);
		frame13.getContentPane().add(txtRandevuTarihi);
		txtRandevuTarihi.setColumns(10);
//		txtRandevuTarihi.setText(secilenRandevu.getRandevuTarihi()).toString());
		
		
		
		final DoktorDaoImpl doktorDaoImpl = new DoktorDaoImpl();
		List<Doktor> doktorListesi = doktorDaoImpl.findAll();
		String[] s = new String[doktorListesi.size()];
		
		for(int j=0 ; j < doktorListesi.size(); j++) {
			
			Doktor doktorNesnesi = doktorListesi.get(j);
			
			String adi = doktorNesnesi.getAdi();
			
			s[j] = adi;
			
		}
		
	    final JComboBox comboboxDoktor = new JComboBox(s);    
	    comboboxDoktor.getModel().setSelectedItem(secilenRandevu.getDoktor().getAdi());
	    comboboxDoktor.setBounds(130, 417,90,20);    
	    frame13.add(comboboxDoktor); 
	    
	    
	    
	    HastaDaoImpl hastaDaoImpl = new HastaDaoImpl();
		List<Hasta> hastaListesi = hastaDaoImpl.findAll();
		String[] s2 = new String[hastaListesi.size()];
		
		for(int j=0 ; j < hastaListesi.size(); j++) {
			
			Hasta hastaNesnesi = hastaListesi.get(j);
			
			String adi = hastaNesnesi.getAdi();
			
			s2[j] = adi;
			
		}
		
	    final JComboBox comboboxHasta = new JComboBox(s2);    
	    comboboxHasta.getModel().setSelectedItem(secilenRandevu.getHasta().getAdi());
	    comboboxHasta.setBounds(130, 417,90,20);    
	    frame13.add(comboboxHasta); 
	    
	    
	    
	    
	    HastahaneDaoImpl hastahaneDaoImpl = new HastahaneDaoImpl();
		List<Hastahane> hastahaneListesi = hastahaneDaoImpl.findAll();
		String[] s3 = new String[hastahaneListesi.size()];
		
		for(int j=0 ; j < hastahaneListesi.size(); j++) {
			
			Hastahane hastahaneNesnesi = hastahaneListesi.get(j);
			
			String adi = hastahaneNesnesi.getAdi();
			
			s3[j] = adi;
			
		}
		
	    final JComboBox comboboxHastahane = new JComboBox(s3);    
	    comboboxHastahane.getModel().setSelectedItem(secilenRandevu.getHastahane().getAdi());
	    comboboxHastahane.setBounds(130, 417,90,20);    
	    frame13.add(comboboxHastahane); 
	    

	    
	    

		PoliklinikDaoImpl poliklinikDaoImpl = new PoliklinikDaoImpl();
		List<Poliklinik> poliklinikListesi = poliklinikDaoImpl.findAll();
		String[] s4 = new String[poliklinikListesi.size()];
		
		for(int j=0 ; j < poliklinikListesi.size(); j++) {
			
			Poliklinik poliNesnesi = poliklinikListesi.get(j);
			
			String adi = poliNesnesi.getAdi();
			
			s4[j] = adi;
			
		}
		
	    final JComboBox comboboxPoliklinik = new JComboBox(s4);    
	    comboboxPoliklinik.getModel().setSelectedItem(secilenRandevu.getPoliklinik().getAdi());
	    comboboxPoliklinik.setBounds(130, 417,90,20);    
	    frame13.add(comboboxPoliklinik); 



	    
	    
	    
		JButton btnGuncelle = new JButton(" Guncelle ");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				RandevuDaoImpl randevuDaoImpl  = new RandevuDaoImpl();
				Randevu guncellenecekRandevu = randevuDaoImpl.findById(id);
				
				SimpleDateFormat formatterRandevuTarihi = new SimpleDateFormat("yyyy-MM-dd");
				String dateInString = txtRandevuTarihi.getText();
				Date date = null;
				try {
					
					date = formatterRandevuTarihi.parse(dateInString);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				guncellenecekRandevu.setRandevuTarihi(date);
				
				
				
				String secilenDoktorAdi = (String) comboboxDoktor.getSelectedItem();
				PoliklinikDaoImpl poliklinikDaoImpl = new PoliklinikDaoImpl();
				Doktor geriDonenDoktor = doktorDaoImpl.findByAdi(secilenDoktorAdi);
				guncellenecekRandevu.setDoktor(geriDonenDoktor);
				

			}

		});

		btnGuncelle.setBounds(125, 270, 100, 75);
		frame13.getContentPane().add(btnGuncelle);



		JButton btnSil = new JButton(" Sil ");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



			}

		});

		btnSil.setBounds(270, 270, 75, 75);
		frame13.getContentPane().add(btnSil);

		
		
		JButton btnKapat = new JButton(" Kapat ");
		btnKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				ArayuzMenu theWindow = new ArayuzMenu();
//				theWindow.getFrame().setVisible(true);
				frame13.dispose();
			}

		});

		btnKapat.setBounds(175, 360, 150, 75);
		frame13.getContentPane().add(btnKapat);



		frame13.setVisible(true);

		pack();

	}

	//	public static void main(String[] args) {
	//
	//		EventQueue.invokeLater(new Runnable() {
	//			@Override
	//			public void run() {
	//				new ArayuzDoktorKaydý().setVisible(true);
	//			}
	//		});
	//	}



	public JFrame getFrame() {
		return frame13;
	}

	public void setFrame(JFrame frame12) {
		this.frame13 = frame12;
	}

	
	

}
