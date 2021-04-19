package arayuz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import enums.Cinsiyet;
import enums.HastahaneTipi;
import impl.HastahaneDaoImpl;
import impl.SehirDaoImpl;
import model.Hastahane;
import model.Sehir;

public class ArayuzHastahaneDuzenleme  extends javax.swing.JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtAdi;
	private JTextField txtTipi;
	private JTextField txtSehir;

	private JFrame frame16;
	

	public ArayuzHastahaneDuzenleme(Long id) {
		initialize(id);

	}
	
	private void initialize(final Long id) {
		
		HastahaneDaoImpl has = new HastahaneDaoImpl();
		Hastahane hastahaneSecilen = has.findById(id);
//		
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame16 = new JFrame();
		frame16.setBounds(100, 100, 875, 875);
		frame16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame16.setTitle("Hastahane  Duzenleme Sayfasi");
		frame16.getContentPane().setLayout(null);

		int x =(screenSize.width - frame16.getWidth()) / 2;
		int y =(screenSize.height - frame16.getHeight()) / 2;

		frame16.setLocation(x, y);
		
		JLabel lblAdi = new JLabel("Adi : ");
		lblAdi.setBounds(10, 20, 107, 36);
		frame16.getContentPane().add(lblAdi);

		txtAdi= new JTextField();
		txtAdi.setBounds(130, 30, 175, 24);
		txtAdi.setBackground(Color.WHITE);
		frame16.getContentPane().add(txtAdi);
		txtAdi.setColumns(10);
		txtAdi.setText(hastahaneSecilen.getAdi());
		
		
		JLabel lblTipi = new JLabel(" Tipi : ");
		lblTipi.setBounds(10, 70, 107, 36);
		frame16.getContentPane().add(lblTipi);

		final JComboBox<HastahaneTipi> comboBoxHastahaneTipi=new JComboBox<HastahaneTipi>();
		comboBoxHastahaneTipi.setModel(new DefaultComboBoxModel<HastahaneTipi>(HastahaneTipi.values()));  
	    
		comboBoxHastahaneTipi.setSelectedItem(hastahaneSecilen.getHastahaneTipi());   
		
		comboBoxHastahaneTipi.setBounds(130, 80,90,20);    
		frame16.add(comboBoxHastahaneTipi);        
		frame16.setLayout(null);    
		frame16.setVisible(true);
	    
		
		JLabel lblSehir = new JLabel(" Sehir : ");
		lblSehir.setBounds(10, 110, 107, 36);
		frame16.getContentPane().add(lblSehir);

		SehirDaoImpl sehirDaoImpl = new SehirDaoImpl();
	    List<Sehir> sehirListesi = sehirDaoImpl.findAll();
		
		String[] sehirArr = new String[sehirListesi.size()];
		
		
		for(int i=0; i < sehirListesi.size(); i++) {
			
			Sehir sehirNesnesi = sehirListesi.get(i);
			
			String sehirAdi = sehirNesnesi.getAdi();
			
			sehirArr[i] = sehirAdi;
			
		}
		
		final JComboBox comboboxPSehir = new JComboBox(sehirArr); 
		
		comboboxPSehir.getModel().setSelectedItem(hastahaneSecilen.getSehir().getAdi());
		
		comboboxPSehir.setBounds(130, 120,90,20);
		frame16.add(comboboxPSehir); 
		
	    frame16.setLayout(null);    
	    frame16.setVisible(true);
	    
	    
	    
	    final JButton btnGuncelle = new JButton(" Guncelle ");
	    btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				HastahaneDaoImpl hastahaneDaoImpl = new HastahaneDaoImpl();
				
				Hastahane guncellenecekHastahane = hastahaneDaoImpl.findById(id);
				
				guncellenecekHastahane.setAdi(txtAdi.getText());
				
				
				HastahaneTipi hastahaneTipi = (HastahaneTipi) comboBoxHastahaneTipi.getSelectedItem();
				guncellenecekHastahane.setHastahaneTipi(hastahaneTipi);
				
				
				String secilenSehirAdi = (String) comboboxPSehir.getSelectedItem();
				SehirDaoImpl sehirDaoImpl = new SehirDaoImpl();
				Sehir geriDonenSehir = sehirDaoImpl.findByAdi(secilenSehirAdi);
				guncellenecekHastahane.setSehir(geriDonenSehir);
				
				
//				guncellenecekHastahane.setHastahaneTipi(txtTipi.getText().toString());
				
				SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date dateUpdate = new Date(System.currentTimeMillis());
				
				guncellenecekHastahane.setUpdatedAt(dateUpdate);

				hastahaneDaoImpl.update(guncellenecekHastahane);
				
				JOptionPane.showMessageDialog(btnGuncelle, "Bilgiler baþarýlý bir þekilde güncellendi");

			}

		});

	    btnGuncelle.setBounds(10, 150, 175, 75);
		frame16.getContentPane().add(btnGuncelle);
	    

	    JButton btnSil = new JButton(" Sil ");
	    btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				HastahaneDaoImpl hastahaneDaoImpl = new HastahaneDaoImpl();
				Hastahane silinecekHastahane = hastahaneDaoImpl.findById(id);
				hastahaneDaoImpl.delete(silinecekHastahane);

			}

		});

	    btnSil.setBounds(195, 150, 175, 75);
		frame16.getContentPane().add(btnSil);
	    
	    
		JButton bynKapat = new JButton(" Kapat ");
	    bynKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame16.dispose();
				new ArayuzHastahaneListeleme().getMainFrame().setVisible(true);
			}
			
		});

	    bynKapat.setBounds(100, 238, 110, 75);
	    frame16.getContentPane().add(bynKapat);
	    
	    
	    
	    
	    
	    frame16.setVisible(true);
	  		pack();
	  		
	  	}
	
	    
	    public JFrame getFrame() {
			return frame16;
		}

		public void setFrame(JFrame frame16) {
			this.frame16 = frame16;
		}



}
