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

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import enums.Cinsiyet;
import impl.DoktorDaoImpl;
import impl.PoliklinikDaoImpl;
import model.Doktor;
import model.Poliklinik;

public class ArayuzDoktorDuzenleme extends  javax.swing.JFrame{
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
	private JFrame frame4;
	
	
	public ArayuzDoktorDuzenleme(Long id) {   //içine long id yaz
		initialize(id);

	}
	
	private void initialize(final long id) {  //içine long id yaz
		
		DoktorDaoImpl d = new DoktorDaoImpl();
		Doktor doktorSecilen = d.findById(id);
		
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame4 = new JFrame();
		frame4.setBounds(100, 100, 875, 875);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.setTitle(" Doktor Duzenleme Sayfasi");
		frame4.getContentPane().setLayout(null);

		int x =(screenSize.width - frame4.getWidth()) / 2;
		int y =(screenSize.height - frame4.getHeight()) / 2;

		frame4.setLocation(x, y);
		
		JLabel lblTCKimlikNo = new JLabel("TC Kimlik No : ");
		lblTCKimlikNo.setBounds(10, 10, 107, 36);
		frame4.getContentPane().add(lblTCKimlikNo);

		txtTCKimlikNo = new JTextField(); 
		txtTCKimlikNo.setBounds(130, 15, 175, 24);
		txtTCKimlikNo.setBackground(Color.WHITE);
		frame4.getContentPane().add(txtTCKimlikNo);
		txtTCKimlikNo.setColumns(10);
		txtTCKimlikNo.setText(doktorSecilen.getTckn()); // Doktor listesinde kullanýcý bir kaydý seçmek için butona bastýðýnda o kaydýn id'sini göndermiþ olur. Biz de bu id'yi alýp DoktorDaoImpl'dan ilgili kaydýn veritabanýndaki tüm bilgilerini alýrýz. Bu bilgileri de kullanýcý seçtiði kaydý görüntülerken ona göstermek için "setText" ile tek tek set ederiz.
		
		JLabel lblAdi = new JLabel("Adi : ");
		lblAdi.setBounds(10, 60, 107, 36);
		frame4.getContentPane().add(lblAdi);

		txtAdi= new JTextField();
		txtAdi.setBounds(130, 65, 175, 24);
		txtAdi.setBackground(Color.WHITE);
		frame4.getContentPane().add(txtAdi);
		txtAdi.setColumns(10);
		txtAdi.setText(doktorSecilen.getAdi());
		
		JLabel lblSoyadi = new JLabel("Soyadi: ");
		lblSoyadi.setBounds(10, 110, 107, 36);
		frame4.getContentPane().add(lblSoyadi);

		txtSoyadi = new JTextField();
		txtSoyadi.setBounds(130, 115, 175, 24);
		txtSoyadi.setBackground(Color.WHITE);
		frame4.getContentPane().add(txtSoyadi);
		txtSoyadi.setColumns(10);
		txtSoyadi.setText(doktorSecilen.getSoyadi());
		
		
		JLabel lblCinsiyeti = new JLabel("Cinsiyeti: ");
		lblCinsiyeti.setBounds(10, 160, 107, 36);
		frame4.getContentPane().add(lblCinsiyeti);
		
		final JComboBox<Cinsiyet> comboBoxCinsiyet=new JComboBox<Cinsiyet>();
	    comboBoxCinsiyet.setModel(new DefaultComboBoxModel<Cinsiyet>(Cinsiyet.values()));  
	    
	    comboBoxCinsiyet.setSelectedItem(doktorSecilen.getCinsiyet());
	    
	    
	    comboBoxCinsiyet.setBounds(130, 167,90,20);    
	    frame4.add(comboBoxCinsiyet);        
	    frame4.setLayout(null);    
	    frame4.setVisible(true);

		
		
		
		JLabel lblDogumYeri = new JLabel("Dogum Yeri: ");
		lblDogumYeri.setBounds(10, 210, 107, 36);
		frame4.getContentPane().add(lblDogumYeri);
	
		txtDogumYeri = new JTextField();
		txtDogumYeri.setBounds(130, 215, 175, 24);
		txtDogumYeri.setBackground(Color.WHITE);
		frame4.getContentPane().add(txtDogumYeri);
		txtDogumYeri.setColumns(10);
		txtDogumYeri.setText(doktorSecilen.getDogumYeri());
		
		
		
		JLabel lblDogumTarihi = new JLabel("Dogum Tarihi: ");
		lblDogumTarihi.setBounds(10, 260, 107, 36);
		frame4.getContentPane().add(lblDogumTarihi);
	
		txtDogumTarihi = new JTextField();
		txtDogumTarihi.setBounds(130, 265, 175, 24);
		txtDogumTarihi.setBackground(Color.WHITE);
		frame4.getContentPane().add(txtDogumTarihi);
		txtDogumTarihi.setColumns(10);
		txtDogumTarihi.setText(doktorSecilen.getDogumTarihi().toString());
		
		
		JLabel lblCepTelefonu = new JLabel("Cep Telefonu: ");
		lblCepTelefonu.setBounds(10, 310, 107, 36);
		frame4.getContentPane().add(lblCepTelefonu);
	
		txtCepTelefonu = new JTextField();
		txtCepTelefonu.setBounds(130, 315, 175, 24);
		txtCepTelefonu.setBackground(Color.WHITE);
		frame4.getContentPane().add(txtCepTelefonu);
		txtCepTelefonu.setColumns(10);
		txtCepTelefonu.setText(doktorSecilen.getCepTel());
		
		JLabel lblEPosta = new JLabel("E Posta: ");
		lblEPosta.setBounds(10, 360, 107, 36);
		frame4.getContentPane().add(lblEPosta);
	
		txtEPosta = new JTextField();
		txtEPosta.setBounds(130, 365, 175, 24);
		txtEPosta.setBackground(Color.WHITE);
		frame4.getContentPane().add(txtEPosta);
		txtEPosta.setColumns(10);
		txtEPosta.setText(doktorSecilen.getePosta());
		
		JLabel lblPolikinlik = new JLabel("Polikinlik: ");
		lblPolikinlik.setBounds(10, 410, 107, 36);
		frame4.getContentPane().add(lblPolikinlik);
	
		
		//TODO : polkilinik dropdown ýn datasource u polklink tablosundan gelecek.. Randevudaki gibi gelecek.. 
		
		PoliklinikDaoImpl poliklinikDaoImpl = new PoliklinikDaoImpl();
		
		List<Poliklinik> poliklinikListesi = poliklinikDaoImpl.findAll();
		
		String[] s = new String[poliklinikListesi.size()];
		
		
		for(int j=0 ; j < poliklinikListesi.size(); j++) {
			
			Poliklinik poliNesnesi = poliklinikListesi.get(j);
			
			String adi = poliNesnesi.getAdi();
			
			s[j] = adi;
			
		}
		
		
	    final JComboBox comboboxPoliklinik = new JComboBox(s);    
	    
	    comboboxPoliklinik.getModel().setSelectedItem(doktorSecilen.getPoliklinik().getAdi());

	    comboboxPoliklinik.setBounds(130, 417,90,20);    
	    frame4.add(comboboxPoliklinik); 
	    
	    
	    frame4.setLayout(null);    
	    frame4.setVisible(true);
	    
	    
	    final JButton btnGuncelle = new JButton(" Guncelle ");
	    btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				DoktorDaoImpl doktorDaoImpl = new DoktorDaoImpl();
				
				Doktor guncellenecekDoktor = doktorDaoImpl.findById(id); // var olan id li doktoru gðncelledim, kullancýýnýn özellkilerini deðiþtirdiiði(herhangi bir alaný deðiþtirdði için tüm alnalarýný alýp o son haliyle nesne olarak daoýmpl ýn update ine gönderilir.. )
				
				guncellenecekDoktor.setAdi(txtAdi.getText());
				guncellenecekDoktor.setCepTel(txtCepTelefonu.getText());
				guncellenecekDoktor.setDogumYeri(txtDogumYeri.getText());
				guncellenecekDoktor.setePosta(txtEPosta.getText());
				guncellenecekDoktor.setSoyadi(txtSoyadi.getText());
				guncellenecekDoktor.setTckn(txtTCKimlikNo.getText());
				
				SimpleDateFormat formatterDogumTarihi = new SimpleDateFormat("yyyy-MM-dd");
				String dateInString = txtDogumTarihi.getText();
				
				Date date = null;
				try {
					
					date = formatterDogumTarihi.parse(dateInString);
					
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				guncellenecekDoktor.setDogumTarihi(date);
				
				Cinsiyet cinsiyet = (Cinsiyet) comboBoxCinsiyet.getSelectedItem();
				guncellenecekDoktor.setCinsiyet(cinsiyet);

				
				
				SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date dateUpdate = new Date(System.currentTimeMillis());
				
				guncellenecekDoktor.setUpdatedAt(dateUpdate);
				
				String secilenPoliklinikAdi = (String) comboboxPoliklinik.getSelectedItem();
				PoliklinikDaoImpl poliklinikDaoImpl = new PoliklinikDaoImpl();
				Poliklinik geriDonenPoliklinik = poliklinikDaoImpl.findByAdi(secilenPoliklinikAdi);
				guncellenecekDoktor.setPoliklinik(geriDonenPoliklinik);
				
				
				doktorDaoImpl.update(guncellenecekDoktor);
				
				JOptionPane.showMessageDialog(btnGuncelle, "Bilgiler baþarýlý bir þekilde güncellendi");
				
			}
			
		});

	    btnGuncelle.setBounds(10, 470, 150, 75);
	    frame4.getContentPane().add(btnGuncelle);
	    
	    
	    JButton btnSil = new JButton(" Sil ");
	    btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DoktorDaoImpl doktorDaoImpl = new DoktorDaoImpl();
				Doktor silinecekDoktor = doktorDaoImpl.findById(id);
				doktorDaoImpl.delete(silinecekDoktor);
				
			}
			
		});

	    btnSil.setBounds(170, 470, 150, 75);
	    frame4.getContentPane().add(btnSil);
		
		
		
		JButton bynKapat = new JButton(" Kapat ");
	    bynKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame4.dispose();
				new ArayuzDoktorListeleme2().getMainFrame().setVisible(true);
			}
			
		});

	    bynKapat.setBounds(100, 570, 110, 75);
	    frame4.getContentPane().add(bynKapat);
		
	    frame4.setVisible(true);
		pack();
		
	}
	


	

	public JFrame getFrame() {
		return frame4;
	}

	public void setFrame(JFrame frame4) {
		this.frame4 = frame4;
	}

	
	

}
