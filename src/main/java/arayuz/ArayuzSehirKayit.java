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

import impl.SehirDaoImpl;
import model.Sehir;

public class ArayuzSehirKayit extends javax.swing.JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAdi;
	
	private JFrame frame18;


	public ArayuzSehirKayit() {
		initialize();

	}

	public void initialize() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame18 = new JFrame();
		frame18.setBounds(100, 100, 875, 875);
		frame18.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame18.setTitle("Sehir Kayit Sayfasi");
		frame18.getContentPane().setLayout(null);

		int x =(screenSize.width - frame18.getWidth()) / 2;
		int y =(screenSize.height - frame18.getHeight()) / 2;

		frame18.setLocation(x, y);
		
		JLabel lblAdi = new JLabel("Adi : ");
		lblAdi.setBounds(10, 60, 107, 36);
		frame18.getContentPane().add(lblAdi);

		txtAdi= new JTextField();
		txtAdi.setBounds(130, 65, 175, 24);
		txtAdi.setBackground(Color.WHITE);
		frame18.getContentPane().add(txtAdi);
		txtAdi.setColumns(10);
		
		
		JButton btnKaydet = new JButton(" Kaydet ");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SehirDaoImpl sehirDaoImpl = new SehirDaoImpl();
				Sehir sehir = new Sehir();
				
				sehir.setAdi(txtAdi.getText());
				
				sehirDaoImpl.save(sehir);
				
			}

		});

		btnKaydet.setBounds(10, 470, 175, 75);
		frame18.getContentPane().add(btnKaydet);

		frame18.setVisible(true);
		pack();

	}


	public JFrame getFrame() {
		return frame18;
	}

	public void setFrame(JFrame frame18) {
		this.frame18 = frame18;
	}


}
