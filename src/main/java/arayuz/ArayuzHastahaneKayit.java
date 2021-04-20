package arayuz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import enums.HastahaneTipi;
import impl.HastahaneDaoImpl;
import impl.SehirDaoImpl;
import model.Hastahane;
import model.Sehir;

public class ArayuzHastahaneKayit extends javax.swing.JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField txtAdi;
	private JFrame frame15;

	public ArayuzHastahaneKayit() {
		initialize();

	}

	private void initialize() {
//		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();

		frame15 = new JFrame();
		frame15.setBounds(100, 100, 875, 875);
		frame15.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame15.setTitle("Hastahane Kayit Sayfasi");
		frame15.getContentPane().setLayout(null);

		int x = (screenSize.width - frame15.getWidth()) / 2;
		int y = (screenSize.height - frame15.getHeight()) / 2;

		frame15.setLocation(x, y);

		JLabel lblAdi = new JLabel("Adi : ");
		lblAdi.setBounds(10, 20, 107, 36);
		frame15.getContentPane().add(lblAdi);

		txtAdi = new JTextField();
		txtAdi.setBounds(130, 30, 175, 24);
		txtAdi.setBackground(Color.WHITE);
		frame15.getContentPane().add(txtAdi);
		txtAdi.setColumns(10);

		JLabel lblSehir = new JLabel("Sehir : ");
		lblSehir.setBounds(10, 60, 107, 36);
		frame15.getContentPane().add(lblSehir);

		SehirDaoImpl sehirDaoImpl = new SehirDaoImpl();
		List<Sehir> geriDonenSehirList = sehirDaoImpl.findAll();

		String[] sehirArray = new String[geriDonenSehirList.size()];

		int i = 0;

		for (Sehir sehir : geriDonenSehirList) {

			String sehirAdi = sehir.getAdi();
			sehirArray[i] = sehirAdi;
			i++;

		}

		final JComboBox comboBoxSehir = new JComboBox(sehirArray);

		comboBoxSehir.setBounds(130, 65, 90, 20);
		frame15.add(comboBoxSehir);

		JLabel lblHastahaneTipi = new JLabel("Hastahane Tipi : ");
		lblHastahaneTipi.setBounds(10, 104, 107, 36);
		frame15.getContentPane().add(lblHastahaneTipi);

		final JComboBox<HastahaneTipi> cb = new JComboBox<HastahaneTipi>();
		cb.setModel(new DefaultComboBoxModel<HastahaneTipi>(HastahaneTipi.values()));

		cb.setBounds(130, 110, 90, 20);
		frame15.add(cb);
		frame15.setLayout(null);
		frame15.setVisible(true);

		JButton btnKaydet = new JButton(" Kaydet ");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				HastahaneDaoImpl hastahaneDaoImpl = new HastahaneDaoImpl();
				Hastahane hastahane = new Hastahane();

				hastahane.setAdi(txtAdi.getText());

				SehirDaoImpl sehirDaoImpl = new SehirDaoImpl();
				String secilenSehir = (String) comboBoxSehir.getSelectedItem();
				Sehir geriDonenSehir = sehirDaoImpl.findByAdi(secilenSehir);
				hastahane.setSehir(geriDonenSehir);

				HastahaneTipi hastahaneTipi = (HastahaneTipi) cb.getSelectedItem();
				hastahane.setHastahaneTipi(hastahaneTipi);

				hastahaneDaoImpl.save(hastahane);

			}

		});

		btnKaydet.setBounds(10, 195, 175, 75);
		frame15.getContentPane().add(btnKaydet);

		frame15.setVisible(true);
		pack();

	}

	public JFrame getFrame() {
		return frame15;
	}

	public void setFrame(JFrame frame9) {
		this.frame15 = frame9;
	}

}
