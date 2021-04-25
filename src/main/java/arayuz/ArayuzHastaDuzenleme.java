package arayuz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import impl.HastaDaoImpl;
import model.Hasta;

public class ArayuzHastaDuzenleme extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField txtTCKimlikNo;
	private JTextField txtAdi;
	private JTextField txtSoyadi;
	private JTextField txtDogumYeri;
	private JTextField txtDogumTarihi;
	private JTextField txtCepTelefonu;
	private JTextField txtBabaAdi;
	private JTextField txtAnneAdi;
	private JFrame frame7;

	public ArayuzHastaDuzenleme(Long id) {
		initialize(id);

	}

	private void initialize(final Long id) {

		HastaDaoImpl h = new HastaDaoImpl();
		Hasta hastaSecilen = h.findById(id);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();

		frame7 = new JFrame();
		frame7.setBounds(100, 100, 875, 875);
		frame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame7.setTitle(" Hasta Duzenleme Sayfasi");
		frame7.getContentPane().setLayout(null);

		int x = (screenSize.width - frame7.getWidth()) / 2;
		int y = (screenSize.height - frame7.getHeight()) / 2;

		frame7.setLocation(x, y);

		JLabel lblTCKimlikNo = new JLabel("TC Kimlik No : ");
		lblTCKimlikNo.setBounds(10, 10, 107, 36);
		frame7.getContentPane().add(lblTCKimlikNo);

		txtTCKimlikNo = new JTextField();
		txtTCKimlikNo.setBounds(130, 15, 175, 24);
		txtTCKimlikNo.setBackground(Color.WHITE);
		frame7.getContentPane().add(txtTCKimlikNo);
		txtTCKimlikNo.setColumns(10);
		txtTCKimlikNo.setText(hastaSecilen.getTckn());

		JLabel lblAdi = new JLabel("Adi : ");
		lblAdi.setBounds(10, 60, 107, 36);
		frame7.getContentPane().add(lblAdi);

		txtAdi = new JTextField();
		txtAdi.setBounds(130, 65, 175, 24);
		txtAdi.setBackground(Color.WHITE);
		frame7.getContentPane().add(txtAdi);
		txtAdi.setColumns(10);
		txtAdi.setText(hastaSecilen.getAdi());

		JLabel lblSoyadi = new JLabel("Soyadi: ");
		lblSoyadi.setBounds(10, 110, 107, 36);
		frame7.getContentPane().add(lblSoyadi);

		txtSoyadi = new JTextField();
		txtSoyadi.setBounds(130, 115, 175, 24);
		txtSoyadi.setBackground(Color.WHITE);
		frame7.getContentPane().add(txtSoyadi);
		txtSoyadi.setColumns(10);
		txtSoyadi.setText(hastaSecilen.getSoyadi());

		JLabel lblCinsiyeti = new JLabel("Cinsiyeti: ");
		lblCinsiyeti.setBounds(10, 160, 107, 36);
		frame7.getContentPane().add(lblCinsiyeti);

		// TODO : cinsiyet dropdown � eklenecek.. enum seklinde.!!!

		String country[] = { "Erkek", "Kad�n" };
		JComboBox cb = new JComboBox(country);

		cb.setBounds(130, 167, 90, 20);
		frame7.add(cb);
		frame7.setLayout(null);
		frame7.setVisible(true);

		JLabel lblDogumYeri = new JLabel("Dogum Yeri: ");
		lblDogumYeri.setBounds(10, 210, 107, 36);
		frame7.getContentPane().add(lblDogumYeri);

		txtDogumYeri = new JTextField();
		txtDogumYeri.setBounds(130, 215, 175, 24);
		txtDogumYeri.setBackground(Color.WHITE);
		frame7.getContentPane().add(txtDogumYeri);
		txtDogumYeri.setColumns(10);
		txtDogumYeri.setText(hastaSecilen.getDogumYeri());

		// TODO : doktor eklerken dogum tarihi ekle

		JLabel lblDogumTarihi = new JLabel("Dogum Tarihi: ");
		lblDogumTarihi.setBounds(10, 260, 107, 36);
		frame7.getContentPane().add(lblDogumTarihi);

		txtDogumTarihi = new JTextField();
		txtDogumTarihi.setBounds(130, 265, 175, 24);
		txtDogumTarihi.setBackground(Color.WHITE);
		frame7.getContentPane().add(txtDogumTarihi);
		txtDogumTarihi.setColumns(10);

		JLabel lblCepTelefonu = new JLabel("Cep Telefonu: ");
		lblCepTelefonu.setBounds(10, 310, 107, 36);
		frame7.getContentPane().add(lblCepTelefonu);

		txtCepTelefonu = new JTextField();
		txtCepTelefonu.setBounds(130, 315, 175, 24);
		txtCepTelefonu.setBackground(Color.WHITE);
		frame7.getContentPane().add(txtCepTelefonu);
		txtCepTelefonu.setColumns(10);
		txtCepTelefonu.setText(hastaSecilen.getCepTel());

		JLabel lblBabaAdi = new JLabel("Baba Adi: ");
		lblBabaAdi.setBounds(10, 360, 107, 36);
		frame7.getContentPane().add(lblBabaAdi);

		txtBabaAdi = new JTextField();
		txtBabaAdi.setBounds(130, 365, 175, 24);
		txtBabaAdi.setBackground(Color.WHITE);
		frame7.getContentPane().add(txtBabaAdi);
		txtBabaAdi.setColumns(10);
		txtBabaAdi.setText(hastaSecilen.getBabaAdi());

		JLabel lblAnneAdi = new JLabel("Anne Adi: ");
		lblAnneAdi.setBounds(10, 410, 107, 36);
		frame7.getContentPane().add(lblAnneAdi);

		txtAnneAdi = new JTextField();
		txtAnneAdi.setBounds(130, 415, 175, 24);
		txtAnneAdi.setBackground(Color.WHITE);
		frame7.getContentPane().add(txtAnneAdi);
		txtAnneAdi.setColumns(10);
		txtAnneAdi.setText(hastaSecilen.getAnneAdi());

		final JButton btnGuncelle = new JButton(" Guncelle ");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				HastaDaoImpl hastaDaoImpl = new HastaDaoImpl();

				Hasta guncellenecekHasta = hastaDaoImpl.findById(id);

				guncellenecekHasta.setAdi(txtAdi.getText());
				guncellenecekHasta.setAnneAdi(txtAnneAdi.getText());
				guncellenecekHasta.setBabaAdi(txtBabaAdi.getText());
				guncellenecekHasta.setCepTel(txtCepTelefonu.getText());
				guncellenecekHasta.setDogumYeri(txtDogumYeri.getText());
				guncellenecekHasta.setSoyadi(txtSoyadi.getText());
				guncellenecekHasta.setTckn(txtTCKimlikNo.getText());

				Date dateUpdate = new Date(System.currentTimeMillis());

				guncellenecekHasta.setUpdatedAt(dateUpdate);

				hastaDaoImpl.update(guncellenecekHasta);

				JOptionPane.showMessageDialog(btnGuncelle, "Bilgiler basarili bir sekilde guncellendi");

			}

		});

		btnGuncelle.setBounds(10, 470, 150, 75);
		frame7.getContentPane().add(btnGuncelle);

		JButton btnSil = new JButton(" Sil ");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				HastaDaoImpl hastaDaoImpl = new HastaDaoImpl();
				Hasta silinecekHasta = hastaDaoImpl.findById(id);
				hastaDaoImpl.delete(silinecekHasta);

			}

		});

		btnSil.setBounds(170, 470, 150, 75);
		frame7.getContentPane().add(btnSil);

		JButton bynKapat = new JButton(" Kapat ");
		bynKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame7.dispose();
				new ArayuzHastaListeleme().getMainFrame().setVisible(true);
			}

		});

		bynKapat.setBounds(100, 570, 110, 75);
		frame7.getContentPane().add(bynKapat);

		frame7.setVisible(true);
		pack();

	}

	public JFrame getFrame() {
		return frame7;
	}

	public void setFrame(JFrame frame7) {
		this.frame7 = frame7;
	}

}
