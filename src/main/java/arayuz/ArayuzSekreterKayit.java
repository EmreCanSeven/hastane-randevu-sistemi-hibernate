package arayuz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import impl.DoktorDaoImpl;
import impl.SekreterDaoImpl;
import model.Doktor;
import model.Sekreter;

public class ArayuzSekreterKayit extends javax.swing.JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField txtTCKimlikNo;
	private JTextField txtAdi;
	private JTextField txtSoyadi;
	private JFrame frame9;

	public ArayuzSekreterKayit() {
		initialize();

	}

	private void initialize() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame9 = new JFrame();
		frame9.setBounds(100, 100, 875, 875);
		frame9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame9.setTitle(" Sekreter Kayit Sayfasi");
		frame9.getContentPane().setLayout(null);

		int x =(screenSize.width - frame9.getWidth()) / 2;
		int y =(screenSize.height - frame9.getHeight()) / 2;

		frame9.setLocation(x, y);

		JLabel lblAdi = new JLabel("Adi : ");
		lblAdi.setBounds(10, 20, 107, 36);
		frame9.getContentPane().add(lblAdi);

		txtAdi= new JTextField();
		txtAdi.setBounds(130, 30, 175, 24);
		txtAdi.setBackground(Color.WHITE);
		frame9.getContentPane().add(txtAdi);
		txtAdi.setColumns(10);

		JLabel lblSoyadi = new JLabel("Soyadi: ");
		lblSoyadi.setBounds(10, 65, 107, 36);
		frame9.getContentPane().add(lblSoyadi);

		txtSoyadi = new JTextField();
		txtSoyadi.setBounds(130, 70, 175, 24);
		txtSoyadi.setBackground(Color.WHITE);
		frame9.getContentPane().add(txtSoyadi);
		txtSoyadi.setColumns(10);
		
		
		JLabel lblTCKimlikNo = new JLabel("TC Kimlik No : ");
		lblTCKimlikNo.setBounds(10, 110, 107, 36);
		frame9.getContentPane().add(lblTCKimlikNo);

		txtTCKimlikNo = new JTextField();
		txtTCKimlikNo.setBounds(130, 110, 175, 24);
		txtTCKimlikNo.setBackground(Color.WHITE);
		frame9.getContentPane().add(txtTCKimlikNo);
		txtTCKimlikNo.setColumns(10);


		JButton btnKaydet = new JButton(" Kaydet ");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				SekreterDaoImpl sekreterDaoImpl = new SekreterDaoImpl();
				Sekreter sekreter = new Sekreter();
				
				sekreter.setAdi(txtAdi.getText());
				sekreter.setSoyadi(txtSoyadi.getText());
				sekreter.setTCKN(txtTCKimlikNo.getText());
				
				sekreterDaoImpl.save(sekreter);
				

			}

		});

		btnKaydet.setBounds(30, 140, 175, 75);
		frame9.getContentPane().add(btnKaydet);


		frame9.setVisible(true);
		pack();

	}

	
	
	public JFrame getFrame() {
		return frame9;
	}

	public void setFrame(JFrame frame9) {
		this.frame9 = frame9;
	}


}
