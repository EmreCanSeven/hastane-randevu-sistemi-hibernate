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

import impl.SehirDaoImpl;
import model.Sehir;

public class ArayuzSehirDuzenleme extends javax.swing.JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtAdi;
	
	private JFrame frame19;


	public ArayuzSehirDuzenleme(Long id) {
		initialize(id);

	}

	public void initialize(final Long id) {
		
		SehirDaoImpl s = new SehirDaoImpl();
		Sehir secilenSehir = s.findById(id);

		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame19 = new JFrame();
		frame19.setBounds(100, 100, 875, 875);
		frame19.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame19.setTitle("Sehir Duzenleme Sayfasi");
		frame19.getContentPane().setLayout(null);

		int x =(screenSize.width - frame19.getWidth()) / 2;
		int y =(screenSize.height - frame19.getHeight()) / 2;

		frame19.setLocation(x, y);
		
		JLabel lblAdi = new JLabel("Adi : ");
		lblAdi.setBounds(10, 20, 107, 36);
		frame19.getContentPane().add(lblAdi);

		txtAdi= new JTextField();
		txtAdi.setBounds(130, 24, 175, 24);
		txtAdi.setBackground(Color.WHITE);
		frame19.getContentPane().add(txtAdi);
		txtAdi.setColumns(10);
		txtAdi.setText(secilenSehir.getAdi());
		
		
		final JButton btnGuncelle = new JButton(" Guncelle ");
		btnGuncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SehirDaoImpl sehirDaoImpl = new SehirDaoImpl();
				
				Sehir guncellenecekSehir = sehirDaoImpl.findById(id);
				
				guncellenecekSehir.setAdi(txtAdi.getText());
				
				SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
				Date dateUpdate = new Date(System.currentTimeMillis());
				
				guncellenecekSehir.setUpdatedAt(dateUpdate);
				
				sehirDaoImpl.update(guncellenecekSehir);
				
				JOptionPane.showMessageDialog(btnGuncelle, "Bilgiler baþarýlý bir þekilde güncellendi");
			}

		});

		btnGuncelle.setBounds(30, 90, 175, 75);
		frame19.getContentPane().add(btnGuncelle);
		
		
		JButton btnSil = new JButton(" Sil ");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				SehirDaoImpl sehirDaoImpl = new SehirDaoImpl();
				Sehir silinecekSehir = sehirDaoImpl.findById(id);
				sehirDaoImpl.delete(silinecekSehir);
 
			}

		});

		btnSil.setBounds(225, 90, 175, 75);
		frame19.getContentPane().add(btnSil);
		
		
		JButton btnKapat = new JButton(" Kapat ");
	    btnKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frame19.dispose();
				new ArayuzSehirListeleme().getMainFrame().setVisible(true);
			}
			
		});

	    btnKapat.setBounds(120, 185, 110, 75);
	    frame19.getContentPane().add(btnKapat);
		

		frame19.setVisible(true);
		pack();

	}


	public JFrame getFrame() {
		return frame19;
	}

	public void setFrame(JFrame frame19) {
		this.frame19 = frame19;
	}


}
