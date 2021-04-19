package arayuz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import impl.SekreterDaoImpl;
import model.Sekreter;

public class ArayuzSekreterDuzenleme extends javax.swing.JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtTCKimlikNo;
	private JTextField txtAdi;
	private JTextField txtSoyadi;
	private JFrame frame10;

	public ArayuzSekreterDuzenleme(Long id) {
		initialize(id);

	}

	private void initialize(final long id) {
		
		SekreterDaoImpl s = new SekreterDaoImpl();
		Sekreter sekreterSecilen = s.findById(id);

		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame10 = new JFrame();
		frame10.setBounds(100, 100, 875, 875);
		frame10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame10.setTitle(" Sekreter Duzenleme Sayfasi");
		frame10.getContentPane().setLayout(null);

		int x =(screenSize.width - frame10.getWidth()) / 2;
		int y =(screenSize.height - frame10.getHeight()) / 2;

		frame10.setLocation(x, y);

		JLabel lblAdi = new JLabel("Adi : ");
		lblAdi.setBounds(10, 20, 107, 36);
		frame10.getContentPane().add(lblAdi);

		txtAdi= new JTextField();
		txtAdi.setBounds(130, 30, 175, 24);
		txtAdi.setBackground(Color.WHITE);
		frame10.getContentPane().add(txtAdi);
		txtAdi.setColumns(10);
		txtAdi.setText(sekreterSecilen.getAdi());

		JLabel lblSoyadi = new JLabel("Soyadi: ");
		lblSoyadi.setBounds(10, 65, 107, 36);
		frame10.getContentPane().add(lblSoyadi);

		txtSoyadi = new JTextField();
		txtSoyadi.setBounds(130, 70, 175, 24);
		txtSoyadi.setBackground(Color.WHITE);
		frame10.getContentPane().add(txtSoyadi);
		txtSoyadi.setColumns(10);
		txtSoyadi.setText(sekreterSecilen.getSoyadi());
		
		
		JLabel lblTCKimlikNo = new JLabel("TC Kimlik No : ");
		lblTCKimlikNo.setBounds(10, 110, 107, 36);
		frame10.getContentPane().add(lblTCKimlikNo);

		txtTCKimlikNo = new JTextField();
		txtTCKimlikNo.setBounds(130, 110, 175, 24);
		txtTCKimlikNo.setBackground(Color.WHITE);
		frame10.getContentPane().add(txtTCKimlikNo);
		txtTCKimlikNo.setColumns(10);
		txtTCKimlikNo.setText(sekreterSecilen.getTCKN());

		final JButton btnGuncelle = new JButton(" Guncelle ");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				SekreterDaoImpl sekreterDaoImpl = new SekreterDaoImpl();
				
				Sekreter guncellenecekSekreter = sekreterDaoImpl.findById(id);

				guncellenecekSekreter.setAdi(txtAdi.getText());
				guncellenecekSekreter.setSoyadi(txtSoyadi.getText());
				guncellenecekSekreter.setTCKN(txtTCKimlikNo.getText());
				
				SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date dateUpdate = new Date(System.currentTimeMillis());
				
				guncellenecekSekreter.setUpdatedAt(dateUpdate);
				
				sekreterDaoImpl.update(guncellenecekSekreter);
				
				JOptionPane.showMessageDialog(btnGuncelle, "Bilgiler baþarýlý bir þekilde güncellendi");

				
			}

		});

		btnGuncelle.setBounds(10, 170, 150, 75);
		frame10.getContentPane().add(btnGuncelle);
		
		
		JButton btnSil = new JButton(" Sil ");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SekreterDaoImpl sekreterDaoImpl = new SekreterDaoImpl();
				Sekreter silinecekSekreter = sekreterDaoImpl.findById(id);
				sekreterDaoImpl.delete(silinecekSekreter);

			}

		});

		btnSil.setBounds(180, 170, 150, 75);
		frame10.getContentPane().add(btnSil);
		
		
		JButton btnKapat = new JButton(" Kapat ");
		btnKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame10.dispose();
				new ArayuzSekreterListeleme().getMainFrame().setVisible(true);
				
				
			}

		});

		btnKapat.setBounds(100, 250, 150, 75);
		frame10.getContentPane().add(btnKapat);


		frame10.setVisible(true);
		pack();

	}

	
	
	public JFrame getFrame() {
		return frame10;
	}

	public void setFrame(JFrame frame10) {
		this.frame10 = frame10;
	}

	

}
