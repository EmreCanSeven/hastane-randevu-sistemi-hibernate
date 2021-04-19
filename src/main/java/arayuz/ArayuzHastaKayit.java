package arayuz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import enums.Cinsiyet;
import impl.DoktorDaoImpl;
import impl.HastaDaoImpl;
import model.Doktor;
import model.Hasta;

public class ArayuzHastaKayit extends javax.swing.JFrame{


	private JTextField txtTCKimlikNo;
	private JTextField txtAdi;
	private JTextField txtSoyadi;
	private JTextField txtCinsiyeti;
	private JTextField txtDogumYeri;
	private JTextField txtDogumTarihi;
	private JTextField txtBabaAdi;
	private JTextField txtAnneAdi;
	private JTextField txtCepTelefonu;

	private JFrame frame6;


	public ArayuzHastaKayit() {
		initialize();

	}

	public void initialize() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame6 = new JFrame();
		frame6.setBounds(100, 100, 875, 875);
		frame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame6.setTitle("Hasta Kayit Sayfasi");
		frame6.getContentPane().setLayout(null);

		int x =(screenSize.width - frame6.getWidth()) / 2;
		int y =(screenSize.height - frame6.getHeight()) / 2;

		frame6.setLocation(x, y);

		JLabel lblTCKimlikNo = new JLabel("TC Kimlik No : ");
		lblTCKimlikNo.setBounds(10, 10, 107, 36);
		frame6.getContentPane().add(lblTCKimlikNo);

		txtTCKimlikNo = new JTextField();
		txtTCKimlikNo.setBounds(130, 15, 175, 24);
		txtTCKimlikNo.setBackground(Color.WHITE);
		frame6.getContentPane().add(txtTCKimlikNo);
		txtTCKimlikNo.setColumns(10);

		JLabel lblAdi = new JLabel("Adi : ");
		lblAdi.setBounds(10, 60, 107, 36);
		frame6.getContentPane().add(lblAdi);

		txtAdi= new JTextField();
		txtAdi.setBounds(130, 65, 175, 24);
		txtAdi.setBackground(Color.WHITE);
		frame6.getContentPane().add(txtAdi);
		txtAdi.setColumns(10);

		JLabel lblSoyadi = new JLabel("Soyadi: ");
		lblSoyadi.setBounds(10, 110, 107, 36);
		frame6.getContentPane().add(lblSoyadi);

		txtSoyadi = new JTextField();
		txtSoyadi.setBounds(130, 115, 175, 24);
		txtSoyadi.setBackground(Color.WHITE);
		frame6.getContentPane().add(txtSoyadi);
		txtSoyadi.setColumns(10);


		JLabel lblCinsiyeti = new JLabel("Cinsiyeti: ");
		lblCinsiyeti.setBounds(10, 160, 107, 36);
		frame6.getContentPane().add(lblCinsiyeti);

		final JComboBox<Cinsiyet> cb=new JComboBox<Cinsiyet>();
	    cb.setModel(new DefaultComboBoxModel<Cinsiyet>(Cinsiyet.values()));    

		cb.setBounds(130, 167,90,20);    
		frame6.add(cb);        
		frame6.setLayout(null);    
		frame6.setVisible(true);


		JLabel lblDogumYeri = new JLabel("Dogum Yeri: ");
		lblDogumYeri.setBounds(10, 210, 107, 36);
		frame6.getContentPane().add(lblDogumYeri);

		txtDogumYeri = new JTextField();
		txtDogumYeri.setBounds(130, 215, 175, 24);
		txtDogumYeri.setBackground(Color.WHITE);
		frame6.getContentPane().add(txtDogumYeri);
		txtDogumYeri.setColumns(10);


		JLabel lblDogumTarihi = new JLabel("Dogum Tarihi: ");
		lblDogumTarihi.setBounds(10, 260, 107, 36);
		frame6.getContentPane().add(lblDogumTarihi);

		txtDogumTarihi = new JTextField();
		txtDogumTarihi.setBounds(130, 265, 175, 24);
		txtDogumTarihi.setBackground(Color.WHITE);
		frame6.getContentPane().add(txtDogumTarihi);
		txtDogumTarihi.setColumns(10);


		JLabel lblBabaAdi = new JLabel("Baba Adi: ");
		lblBabaAdi.setBounds(10, 310, 107, 36);
		frame6.getContentPane().add(lblBabaAdi);

		txtBabaAdi = new JTextField();
		txtBabaAdi.setBounds(130, 315, 175, 24);
		txtBabaAdi.setBackground(Color.WHITE);
		frame6.getContentPane().add(txtBabaAdi);
		txtBabaAdi.setColumns(10);


		JLabel lblAnneAdi = new JLabel("Anne Adi: ");
		lblAnneAdi.setBounds(10, 360, 107, 36);
		frame6.getContentPane().add(lblAnneAdi);

		txtAnneAdi = new JTextField();
		txtAnneAdi.setBounds(130, 365, 175, 24);
		txtAnneAdi.setBackground(Color.WHITE);
		frame6.getContentPane().add(txtAnneAdi);
		txtAnneAdi.setColumns(10);


		JLabel lblCeptelefonu = new JLabel("Cep Telefonu: ");
		lblCeptelefonu.setBounds(10, 410, 107, 36);
		frame6.getContentPane().add(lblCeptelefonu);

		txtCepTelefonu = new JTextField();
		txtCepTelefonu.setBounds(130, 415, 175, 24);
		txtCepTelefonu.setBackground(Color.WHITE);
		frame6.getContentPane().add(txtCepTelefonu);
		txtCepTelefonu.setColumns(10);

		JButton btnKaydet = new JButton(" Kaydet ");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				HastaDaoImpl hastaDaoImpl = new HastaDaoImpl();
				Hasta hasta = new Hasta();
				
				hasta.setAdi(txtAdi.getText());
				hasta.setSoyadi(txtSoyadi.getText());
				hasta.setAnneAdi(txtAnneAdi.getText());
				hasta.setBabaAdi(txtBabaAdi.getText());
				hasta.setCepTel(txtCepTelefonu.getText());
//				hasta.setDogumTarihi(txtDogumTarihi.);
				
				Cinsiyet cinsiyet = (Cinsiyet) cb.getSelectedItem();
				hasta.setCinsiyet(cinsiyet);
				
				Date date = null;
				try {
					date = new SimpleDateFormat("dd/MM/yyyy").parse(txtDogumTarihi.getText());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				hasta.setDogumTarihi(date);
				
				SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date dateCreate = new Date(System.currentTimeMillis());
				hasta.setCreatedAt(dateCreate);
				
				hasta.setDogumYeri(txtDogumYeri.getText());
				hasta.setTckn(txtTCKimlikNo.getText());
				
				hastaDaoImpl.save(hasta);
				
			}

		});

		btnKaydet.setBounds(10, 470, 175, 75);
		frame6.getContentPane().add(btnKaydet);


		JButton bynKapat = new JButton(" Kapat ");
		bynKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame6.dispose();

			}

		});

		bynKapat.setBounds(195, 470, 110, 75);
		frame6.getContentPane().add(bynKapat);


		frame6.setVisible(true);
		pack();

	}


	public JFrame getFrame() {
		return frame6;
	}

	public void setFrame(JFrame frame6) {
		this.frame6 = frame6;
	}


}
