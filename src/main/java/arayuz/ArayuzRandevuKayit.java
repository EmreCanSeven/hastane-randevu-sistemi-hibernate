package arayuz;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import main.DatePicker;
import model.Doktor;
import model.Hasta;
import model.Hastahane;
import model.Poliklinik;
import model.Randevu;

public class ArayuzRandevuKayit extends javax.swing.JFrame{



	private static final long serialVersionUID = 1L;
	private JTextField txtRandevuTarihi;
	private JTextField txtPolikinlik;
	private JLabel lblRandevuTarihi;
	private JButton buttonDatePicker;
	private JTextField textDatePicker;


	private JFrame frame12;


	public ArayuzRandevuKayit() {
		initialize();

	}

	public void initialize() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame12 = new JFrame();
		frame12.setBounds(100, 100, 875, 875);
		frame12.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame12.setTitle("Randevu Kayit Sayfasi");
		frame12.getContentPane().setLayout(null);

		int x =(screenSize.width - frame12.getWidth()) / 2;
		int y =(screenSize.height - frame12.getHeight()) / 2;

		frame12.setLocation(x, y);

		lblRandevuTarihi = new JLabel("Randevu Tarihi : ");
		lblRandevuTarihi.setBounds(10, 10, 107, 36);
		frame12.getContentPane().add(lblRandevuTarihi);
		
		
		textDatePicker = new JTextField();
		buttonDatePicker = new JButton("Sec");
		textDatePicker.setBounds(130, 15, 175, 24);
		
		
		buttonDatePicker.setBounds(310, 15, 65, 24);
		frame12.getContentPane().add(textDatePicker);
		frame12.getContentPane().add(buttonDatePicker);
		
		frame12.setVisible(true);
		buttonDatePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				textDatePicker.setText(new DatePicker(frame12).setPickedDate());
			}
		});
		
		
		JLabel lblPolikinlik = new JLabel("Poliklinik : ");
		lblPolikinlik.setBounds(10, 60, 107, 36);
		frame12.getContentPane().add(lblPolikinlik);

		//		String country2[]={"Dahiliye","Nöroloji","Kalp-Damar","Radyoloji"};

		PoliklinikDaoImpl poliklinikDaoImpl = new PoliklinikDaoImpl();
		List<Poliklinik> geriDonenPoliList = poliklinikDaoImpl.findAll();

		String[] poliArray = new String[geriDonenPoliList.size()];

		int i=0;

		for(Poliklinik poliklinik : geriDonenPoliList) {

			String poliAdi = poliklinik.getAdi();
			poliArray[i] = poliAdi;
			i++;

		}

		final JComboBox comboBoxPoli=new JComboBox(poliArray);    

		comboBoxPoli.setBounds(130,70,110,20);    
		frame12.add(comboBoxPoli);        
		frame12.setLayout(null);    
		frame12.setVisible(true);


		JLabel lblDoktor = new JLabel("Doktor : ");
		lblDoktor.setBounds(10, 110, 107, 36);
		frame12.getContentPane().add(lblDoktor);

		DoktorDaoImpl doktorDaoImpl = new DoktorDaoImpl();
		List<Doktor> geriDonenButunList = doktorDaoImpl.findAll();

		//		String country3[]={"Emre Can Seven","Cihan Adil Seven","Burcu Seven","Aydýn Seven","Nahide Seven"};       
		int i2=0;
		
		String[] array = new String[geriDonenButunList.size()];

		for(Doktor doktor : geriDonenButunList) {
			String doktorTamAdi = doktor.getId() + "-" + doktor.getAdi() + " " + doktor.getSoyadi();
			array[i2] = doktorTamAdi;
			i2++;

		}
		
		final JComboBox comboBoxDoktor=new JComboBox(array);    

		comboBoxDoktor.setBounds(130, 115,110,20);    
		frame12.add(comboBoxDoktor);        
		frame12.setLayout(null);    
		frame12.setVisible(true);
		
		
		
		JLabel lblhastahane = new JLabel("Hastahane : ");
		lblhastahane.setBounds(10, 160, 107, 36);
		frame12.getContentPane().add(lblhastahane);
		
		HastahaneDaoImpl hastahaneDaoImpl = new HastahaneDaoImpl();
		List<Hastahane> geriDonenHastahaneList = hastahaneDaoImpl.findAll();

		//		String country3[]={"Emre Can Seven","Cihan Adil Seven","Burcu Seven","Aydýn Seven","Nahide Seven"};       
		int i4=0;

		String[] arrayHastahane = new String[geriDonenHastahaneList.size()];

		for(Hastahane hastahane : geriDonenHastahaneList) {
			String hastahaneAdi = hastahane.getAdi();
			arrayHastahane[i4] = hastahaneAdi;
			i4++;

		}

		final JComboBox comboBoxHastahane=new JComboBox(arrayHastahane);    

		comboBoxHastahane.setBounds(130, 170,110,20);    
		frame12.add(comboBoxHastahane);        
		frame12.setLayout(null);    
		frame12.setVisible(true);
		
		
		
		JLabel lblHasta = new JLabel("Hasta :");
		lblHasta.setBounds(10, 210, 107, 36);
		frame12.getContentPane().add(lblHasta);
		
		HastaDaoImpl hastaDaoImpl = new HastaDaoImpl();
		List<Hasta> geriDonenHastaList = hastaDaoImpl.findAll();

		int i5=0;
		
		String[] arrayHasta = new String[geriDonenHastaList.size()];
		
		for(Hasta hasta : geriDonenHastaList) {
			
			String hastaTamAdi = hasta.getId() + "-" + hasta.getAdi() + " " + hasta.getSoyadi();
			arrayHasta[i5] = hastaTamAdi;
			i5++;
			
		}
		
		final JComboBox comboBoxHasta = new JComboBox(arrayHasta);
		
		comboBoxHasta.setBounds(130, 220, 110, 20);
		frame12.add(comboBoxHasta);
		frame12.setLayout(null);
		frame12.setVisible(true);






		JButton btnKaydet = new JButton(" Kaydet ");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				RandevuDaoImpl randevuDaoImpl = new RandevuDaoImpl();
				Randevu randevu = new Randevu();
				
//				randevu.setRandevuTarihi(txtRandevuTarihi.getText());
//				randevu.setDoktor(dok);
				
				Date date = new Date();
				
				String poliklinikAdi = (String) comboBoxPoli.getSelectedItem();
				String doktorAdi = (String) comboBoxDoktor.getSelectedItem();  
				String hastaAdi = (String) comboBoxHasta.getSelectedItem();
				String hasthahaneAdi = (String) comboBoxHastahane.getSelectedItem();
				
				
				// 1-emre seven
				// 2-cihan saygý
				// 3-bilal haktan
				// 4-ebru kel
				
				
				String[] parcaDoktor = doktorAdi.split("-");
				String doktorIdStr = parcaDoktor[0];
				Long doktorId = Long.parseLong(doktorIdStr);
				
				
				String[] parcaHasta = hastaAdi.split("-");
				String hastaIdStr = parcaHasta[0];
				Long hastaId = Long.parseLong(hastaIdStr);
				
				
//				Doktor doktor = (Doktor) comboBoxDoktor.getSelectedItem();
//				Hastahane hastahane = (Hastahane) comboBoxHastahane.getSelectedItem();
//				Hasta hasta = (Hasta) comboBoxHasta.getSelectedItem();
//				Poliklinik poliklinik = (Poliklinik) comboBoxPoli.getSelectedItem();
				
				
				PoliklinikDaoImpl poliklinikDaoImpl = new PoliklinikDaoImpl();
				Poliklinik poliklinik = poliklinikDaoImpl.findByAdi(poliklinikAdi);
				
				DoktorDaoImpl doktorDaoImpl = new DoktorDaoImpl();
				Doktor doktor = doktorDaoImpl.findById(doktorId);
				
				HastaDaoImpl hastaDaoImpl = new HastaDaoImpl();
				Hasta hasta = hastaDaoImpl.findById(hastaId);
				
				HastahaneDaoImpl hastahaneDaoImpl = new HastahaneDaoImpl();
				Hastahane hastahane = hastahaneDaoImpl.findByAdi(hasthahaneAdi);
				
				
				randevu.setPoliklinik(poliklinik);
				randevu.setDoktor(doktor);
				randevu.setHastahane(hastahane);
				randevu.setHasta(hasta);
				randevu.setRandevuTarihi(date);
				
				randevuDaoImpl.save(randevu);
			

			}

		});

		btnKaydet.setBounds(125, 270, 100, 75);
		frame12.getContentPane().add(btnKaydet);



	

		
		
		JButton btnKapat = new JButton(" Kapat ");
		btnKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				ArayuzMenu theWindow = new ArayuzMenu();
//				theWindow.getFrame().setVisible(true);
				frame12.dispose();
			}

		});

		btnKapat.setBounds(175, 360, 150, 75);
		frame12.getContentPane().add(btnKapat);



		frame12.setVisible(true);

		pack();

	}





	public JFrame getFrame() {
		return frame12;
	}

	public void setFrame(JFrame frame12) {
		this.frame12 = frame12;
	}

	
	

}
