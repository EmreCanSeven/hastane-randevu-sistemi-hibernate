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

import impl.PoliklinikDaoImpl;
import model.Poliklinik;

public class ArayuzPoliklinikKayit extends javax.swing.JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAdi;
	
	private JFrame frame21;


	public ArayuzPoliklinikKayit() {
		initialize();

	}

	public void initialize() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame21 = new JFrame();
		frame21.setBounds(100, 100, 875, 875);
		frame21.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame21.setTitle("Poliklinik Kayit Sayfasi");
		frame21.getContentPane().setLayout(null);

		int x =(screenSize.width - frame21.getWidth()) / 2;
		int y =(screenSize.height - frame21.getHeight()) / 2;

		frame21.setLocation(x, y);
		
		JLabel lblAdi = new JLabel("Adi : ");
		lblAdi.setBounds(10, 60, 107, 36);
		frame21.getContentPane().add(lblAdi);

		txtAdi= new JTextField();
		txtAdi.setBounds(130, 65, 175, 24);
		txtAdi.setBackground(Color.WHITE);
		frame21.getContentPane().add(txtAdi);
		txtAdi.setColumns(10);
		
		
		JButton btnKaydet = new JButton(" Kaydet ");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PoliklinikDaoImpl poliklinikDaoImpl = new PoliklinikDaoImpl();
				Poliklinik poliklinik = new Poliklinik();
				
				poliklinik.setAdi(txtAdi.getText());
				
				poliklinikDaoImpl.save(poliklinik);
			}

		});

		btnKaydet.setBounds(10, 470, 175, 75);
		frame21.getContentPane().add(btnKaydet);

		frame21.setVisible(true);
		pack();

	}


	public JFrame getFrame() {
		return frame21;
	}

	public void setFrame(JFrame frame21) {
		this.frame21 = frame21;
	}

}
