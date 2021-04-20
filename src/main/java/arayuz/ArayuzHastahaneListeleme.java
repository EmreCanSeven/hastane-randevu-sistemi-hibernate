package arayuz;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import arayuz.util.ButtonEditorHastahane;
import arayuz.util.ButtonRenderer;
import impl.HastahaneDaoImpl;
import model.Hastahane;

public class ArayuzHastahaneListeleme extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame mainFrame;
	private JPanel controlPanel;

	private Object[][] hastahaneListesindenMatrisOlustur(List<Hastahane> hastahaneList) {
		Object[][] result = new Object[hastahaneList.size()][5];

		for (int i = 0; i < hastahaneList.size(); i++) {
			Hastahane hastahane = hastahaneList.get(i);
			result[i] = hastahaneyiArrayeCevir(hastahane);
		}

		return result;
	}

	private Object[] hastahaneyiArrayeCevir(Hastahane hastahane) {
		Object[] objArr = new Object[4];

		objArr[0] = hastahane.getAdi();
		objArr[1] = hastahane.getSehir().getAdi().toString();
		objArr[2] = hastahane.getHastahaneTipi();
		objArr[3] = hastahane.getId(); // Bunu se�ildi�inde g�ndermek i�in almak zorundayd�k

		return objArr;
	}

	public ArayuzHastahaneListeleme() {
		mainFrame = new JFrame("Hastahane Listesi Frame");
		mainFrame.setSize(875, 875);
		GridLayout gridLayout = new GridLayout(2, 1);

		mainFrame.setLayout(gridLayout);

		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();

		int x = (screenSize.width - mainFrame.getWidth()) / 2;
		int y = (screenSize.height - mainFrame.getHeight()) / 2;

		mainFrame.setLocation(x, y);

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		JPanel panel = new JPanel();
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(controlPanel);
		mainFrame.add(panel);

		Object[] basliklar = new Object[] { "Adi", "Sehir", "Tipi", "D�zenle" };

		HastahaneDaoImpl hastahaneDaoImpl = new HastahaneDaoImpl();
		List<Hastahane> hastahaneListAll = hastahaneDaoImpl.findAll();

		Object[][] hastahaneListesiMatris = new Object[hastahaneListAll.size()][5];
		hastahaneListesiMatris = hastahaneListesindenMatrisOlustur(hastahaneListAll);

		JTable table = new JTable(hastahaneListesiMatris, basliklar);
		table.getColumn("D�zenle").setCellRenderer(new ButtonRenderer());
		table.getColumn("D�zenle").setCellEditor(new ButtonEditorHastahane(new JCheckBox(), mainFrame));

		final JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setVisible(false);
		controlPanel.add(scrollPane);
		mainFrame.setVisible(true);

		JButton button = new JButton("Listele");
		button.setBounds(x, 350, 100, 20);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						scrollPane.setVisible(true);
						refreshEkran();
					}
				});
			}
		});

		panel.add(button);

	}

	private void refreshEkran() {
		mainFrame.invalidate();
		mainFrame.validate();
		mainFrame.repaint();
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

}
