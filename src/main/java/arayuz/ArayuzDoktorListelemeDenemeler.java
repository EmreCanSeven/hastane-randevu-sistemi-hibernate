package arayuz;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import impl.HastahaneDaoImpl;
import impl.PoliklinikDaoImpl;
import impl.SehirDaoImpl;
import model.Hastahane;
import model.Poliklinik;
import model.Sehir;

public class ArayuzDoktorListelemeDenemeler extends javax.swing.JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtTCKimlikNo;
	private JTextField txtAdi;
	private JTextField txtSoyadi;
	private JTextField txtCinsiyeti;
	private JTextField txtDogumYeri;
	private JTextField txtDogumTarihi;
	private JTextField txtCepTelefonu;
	private JTextField txtEPosta;
	private JTextField txtPolikinlik;
	private JFrame frame3;
	
	
	public ArayuzDoktorListelemeDenemeler() {
//		initialize();

	}
	
	private void initialize() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame3 = new JFrame();
		frame3.setBounds(100, 100, 875, 875);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setTitle("Doktor Kayit Sayfasi");
		frame3.getContentPane().setLayout(null);

		int x =(screenSize.width - frame3.getWidth()) / 2;
		int y =(screenSize.height - frame3.getHeight()) / 2;

		frame3.setLocation(x, y);
		
		
		
		JLabel lblSehir = new JLabel("Sehir: ");
		lblSehir.setBounds(10, 50, 40, 36);
		frame3.getContentPane().add(lblSehir);
		
		SehirDaoImpl sehirDaoImpl= new SehirDaoImpl();
		List<Sehir> geriDonenSehirList = sehirDaoImpl.findAll();

		String[] sehirArray = new String[geriDonenSehirList.size()];

		int i=0;

		for(Sehir sehir: geriDonenSehirList) {

			String sehirAdi = sehir.getAdi();
			sehirArray[i] = sehirAdi;
			i++;

		}

		final JComboBox comboBoxSehir=new JComboBox(sehirArray);    
	    
		comboBoxSehir.setBounds(60, 55,90,20);   
		
		String secilenSehir = (String) comboBoxSehir.getSelectedItem();
	    SehirDaoImpl sehirDaoImpl2 = new SehirDaoImpl();
	    final Sehir geriDonenSehir = sehirDaoImpl2.findByAdi(secilenSehir);  //  ==>>> BURADA ARAYUZDE G�R�LEN YA DA SEC�LEN SEH�R VS G�B� �EYLER�N, STR�NG OLDUGU VEYA �NT VS VS ���N BURADA B�Z F�NDBYAD� G�B� METORLARIMIZI KULLANRAK ONLARDAN DB DEK� KAYDA ULA�IYORUZ.(O KAYIT==NESNE)
	    
	    
		
		comboBoxSehir.addActionListener(new ActionListener() {
	            // Listening if a new items of the combo box has been selected.
	            public void actionPerformed(ActionEvent event) {
	            	refreshEkran();
	            	
	            	
	            	JComboBox<Sehir> comboBoxSehir = (JComboBox<Sehir>) event.getSource();
	            	
	         
	                if (geriDonenSehir.equals(comboBoxSehir)) {
	                    
	                	

	            		HastahaneDaoImpl hastahaneDaoImpl= new HastahaneDaoImpl();
	            		List<Hastahane> geriDonenHastahaneList = hastahaneDaoImpl.findHastahaneBySehir(geriDonenSehir);

	            		String[] hastahaneArray = new String[geriDonenHastahaneList.size()];

	            		int k=0;

	            		for(Hastahane hastahane: geriDonenHastahaneList) {

	            			String hastahaneAdi = hastahane.getAdi();
	            			hastahaneArray[k] = hastahaneAdi;
	            			k++;

	            		}

	            		final JComboBox comboBoxHastahane=new JComboBox(hastahaneArray);    
	            		refreshEkran();
	            		comboBoxHastahane.setBounds(265, 55,140,20);    
	            	    frame3.add(comboBoxHastahane); 
	            		
	            	    frame3.setVisible(true);
	                    
	                    
	                } 
//	                else if (selectedBook.equals("Head First Java")) {
//	                    System.out.println("Nice pick, too!");
//	                }
	           }
	            
	        });
		
		
		
	    frame3.add(comboBoxSehir); 
	    
//	    String secilenPoliklinikAdi = (String) comboBoxPoli.getSelectedItem();
//		PoliklinikDaoImpl poliklinikDaoImpl = new PoliklinikDaoImpl();
//		Poliklinik geriDonenPoliklinik = poliklinikDaoImpl.findByAdi(secilenPoliklinikAdi);
//		doktor.setPoliklinik(geriDonenPoliklinik);
	    
	    
	    
	    
	    
	    
	    
	    
//	    JLabel lblHastahane = new JLabel("Hastahane : ");
//		lblHastahane.setBounds(180, 50, 75, 36);
//		frame3.getContentPane().add(lblHastahane);
//		
//		HastahaneDaoImpl hastahaneDaoImpl= new HastahaneDaoImpl();
//		List<Hastahane> geriDonenHastahaneList = hastahaneDaoImpl.findHastahaneBySehir(geriDonenSehir);
//
//		String[] hastahaneArray = new String[geriDonenHastahaneList.size()];
//
//		int k=0;
//
//		for(Hastahane hastahane: geriDonenHastahaneList) {
//
//			String hastahaneAdi = hastahane.getAdi();
//			hastahaneArray[k] = hastahaneAdi;
//			k++;
//
//		}
//
//		final JComboBox comboBoxHastahane=new JComboBox(hastahaneArray);    
//	    
//		comboBoxHastahane.setBounds(265, 55,140,20);    
//	    frame3.add(comboBoxHastahane); 
		

		 
	    frame3.setLayout(null);    
	    frame3.setVisible(true);
	    
	    
	    JButton btnAra = new JButton(" Ara ");
	    btnAra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				

				
			}
			
		});

	    btnAra.setBounds(750, 55, 100, 25);
	    frame3.getContentPane().add(btnAra);
		
		
	    frame3.setVisible(true);
		pack();
		
	}
	
	public static void main(String[] args) {
	
		
		ArayuzDoktorListelemeDenemeler arayuzDoktorListelemeDenemeler  = new ArayuzDoktorListelemeDenemeler();
		arayuzDoktorListelemeDenemeler.initialize();
	}
	
	private void refreshEkran() {
		frame3.invalidate();
		frame3.validate();
		frame3.repaint();
	}
	
	public JFrame getFrame() {
		return frame3;
	}

	public void setFrame(JFrame frame3) {
		this.frame3 = frame3;
	}
	

}
