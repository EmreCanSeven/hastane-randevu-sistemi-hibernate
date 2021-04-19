package arayuz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import enums.Cinsiyet;
import impl.DoktorDaoImpl;
import impl.PoliklinikDaoImpl;
import model.Doktor;
import model.Poliklinik;

public class ArayuzDoktorKayit extends javax.swing.JFrame{
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
	
	
	public ArayuzDoktorKayit() {
		initialize();

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
		
		JLabel lblTCKimlikNo = new JLabel("TC Kimlik No : ");
		lblTCKimlikNo.setBounds(10, 10, 107, 36);
		frame3.getContentPane().add(lblTCKimlikNo);

		txtTCKimlikNo = new JTextField();
		txtTCKimlikNo.setBounds(130, 15, 175, 24);
		txtTCKimlikNo.setBackground(Color.WHITE);
		frame3.getContentPane().add(txtTCKimlikNo);
		txtTCKimlikNo.setColumns(10);
		
		JLabel lblAdi = new JLabel("Adi : ");
		lblAdi.setBounds(10, 60, 107, 36);
		frame3.getContentPane().add(lblAdi);

		txtAdi= new JTextField();
		txtAdi.setBounds(130, 65, 175, 24);
		txtAdi.setBackground(Color.WHITE);
		frame3.getContentPane().add(txtAdi);
		txtAdi.setColumns(10);
		
		JLabel lblSoyadi = new JLabel("Soyadi: ");
		lblSoyadi.setBounds(10, 110, 107, 36);
		frame3.getContentPane().add(lblSoyadi);

		txtSoyadi = new JTextField();
		txtSoyadi.setBounds(130, 115, 175, 24);
		txtSoyadi.setBackground(Color.WHITE);
		frame3.getContentPane().add(txtSoyadi);
		txtSoyadi.setColumns(10);
		
		
		JLabel lblCinsiyeti = new JLabel("Cinsiyeti: ");
		lblCinsiyeti.setBounds(10, 160, 107, 36);
		frame3.getContentPane().add(lblCinsiyeti);
		
		// TODO : cinsiyet dropdown ý eklenecek.. enum seklinde.!!!
		
//		String country[]={"ERKEK","KADIN"};        
	    final JComboBox<Cinsiyet> comboBoxCinsiyet=new JComboBox<Cinsiyet>();
	    comboBoxCinsiyet.setModel(new DefaultComboBoxModel<Cinsiyet>(Cinsiyet.values()));
	    
	    comboBoxCinsiyet.setBounds(130, 167,90,20);    
	    frame3.add(comboBoxCinsiyet);        
	    frame3.setLayout(null);    
	    frame3.setVisible(true);

		
		JLabel lblDogumYeri = new JLabel("Dogum Yeri: ");
		lblDogumYeri.setBounds(10, 210, 107, 36);
		frame3.getContentPane().add(lblDogumYeri);
	
		txtDogumYeri = new JTextField();
		txtDogumYeri.setBounds(130, 215, 175, 24);
		txtDogumYeri.setBackground(Color.WHITE);
		frame3.getContentPane().add(txtDogumYeri);
		txtDogumYeri.setColumns(10);
		
		
		//TODO : doktor eklerken dogum tarihi ekle
		
		JLabel lblDogumTarihi = new JLabel("Dogum Tarihi: ");
		lblDogumTarihi.setBounds(10, 260, 107, 36);
		frame3.getContentPane().add(lblDogumTarihi);
	
		txtDogumTarihi = new JTextField();
		txtDogumTarihi.setBounds(130, 265, 175, 24);
		txtDogumTarihi.setBackground(Color.WHITE);
		frame3.getContentPane().add(txtDogumTarihi);
		txtDogumTarihi.setColumns(10);
		
		
		JLabel lblCepTelefonu = new JLabel("Cep Telefonu: ");
		lblCepTelefonu.setBounds(10, 310, 107, 36);
		frame3.getContentPane().add(lblCepTelefonu);
	
		txtCepTelefonu = new JTextField();
		txtCepTelefonu.setBounds(130, 315, 175, 24);
		txtCepTelefonu.setBackground(Color.WHITE);
		frame3.getContentPane().add(txtCepTelefonu);
		txtCepTelefonu.setColumns(10);
		
		
		JLabel lblEPosta = new JLabel("E Posta: ");
		lblEPosta.setBounds(10, 360, 107, 36);
		frame3.getContentPane().add(lblEPosta);
	
		txtEPosta = new JTextField();
		txtEPosta.setBounds(130, 365, 175, 24);
		txtEPosta.setBackground(Color.WHITE);
		frame3.getContentPane().add(txtEPosta);
		txtEPosta.setColumns(10);
		
		
		JLabel lblPolikinlik = new JLabel("Polikinlik: ");
		lblPolikinlik.setBounds(10, 410, 107, 36);
		frame3.getContentPane().add(lblPolikinlik);
	
		// ==> burada hangi veti tipi ile dolduryorsam aþðaýda getselecteditem dediðimde de o veri tipini döner. Enum olarak doldurursam getselectedTem dediðimde enum döner
		//obje olarak bir sýnýf tipi olarak doldurusam bu seferde sýnýf tipinde döner..
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
	    
		comboBoxPoli.setBounds(130, 417,90,20);    
	    frame3.add(comboBoxPoli);        
	    frame3.setLayout(null);    
	    frame3.setVisible(true);
	    
	    
	    JButton btnKaydet = new JButton(" Kaydet ");
	    btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DoktorDaoImpl doktorDaoImpl = new DoktorDaoImpl();
				Doktor doktor  = new Doktor();
				
				doktor.setAdi(txtAdi.getText());
				doktor.setCepTel(txtCepTelefonu.getText());
				doktor.setDogumYeri(txtDogumYeri.getText());
				
				Cinsiyet cinsiyet = (Cinsiyet) comboBoxCinsiyet.getSelectedItem();
				doktor.setCinsiyet(cinsiyet);
				
				Date date = null;
				try {
					date = new SimpleDateFormat("dd/MM/yyyy").parse(txtDogumTarihi.getText());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				doktor.setDogumTarihi(date);
				
				doktor.setePosta(txtEPosta.getText());
				doktor.setSoyadi(txtSoyadi.getText());
				doktor.setTckn(txtTCKimlikNo.getText());
				
				SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date dateCreate = new Date(System.currentTimeMillis());
				doktor.setCreatedAt(dateCreate);
				
				String secilenPoliklinikAdi = (String) comboBoxPoli.getSelectedItem();
				PoliklinikDaoImpl poliklinikDaoImpl = new PoliklinikDaoImpl();
				Poliklinik geriDonenPoliklinik = poliklinikDaoImpl.findByAdi(secilenPoliklinikAdi);
				doktor.setPoliklinik(geriDonenPoliklinik);
				
				doktorDaoImpl.save(doktor);
				
			}
			
		});

	    btnKaydet.setBounds(10, 470, 175, 75);
	    frame3.getContentPane().add(btnKaydet);
		
		
		
		JButton bynKapat = new JButton(" Kapat ");
	    bynKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame3.dispose();
				
			}
			
		});

	    bynKapat.setBounds(195, 470, 110, 75);
	    frame3.getContentPane().add(bynKapat);
		
	    frame3.setVisible(true);
		pack();
		
	}
	


	

	public JFrame getFrame() {
		return frame3;
	}

	public void setFrame(JFrame frame3) {
		this.frame3 = frame3;
	}

	

}
