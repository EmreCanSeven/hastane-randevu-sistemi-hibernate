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

import arayuz.util.ButtonEditorDoktor;
import arayuz.util.ButtonRenderer;
import impl.DoktorDaoImpl;
import model.Doktor;

public class ArayuzDoktorListeleme2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame mainFrame;
	private JPanel controlPanel;

	private Object[][] doktorListesindenMatrisOlustur(List<Doktor> doktorList) {
		Object[][] result = new Object[doktorList.size()][5];

		for (int i = 0; i < doktorList.size(); i++) {
			Doktor doktor = doktorList.get(i);
			result[i] = doktoruArrayeCevir(doktor);
		}

		return result;
	}

	private Object[] doktoruArrayeCevir(Doktor doktor) {
		Object[] objArr = new Object[5];

		objArr[0] = doktor.getTckn();
		objArr[1] = doktor.getAdi();
		objArr[2] = doktor.getSoyadi();
		objArr[3] = doktor.getDogumYeri();
		objArr[4] = doktor.getId(); // Bunu seçildiðinde göndermek için almak zorundaydýk

		return objArr;
	}

	public ArayuzDoktorListeleme2() {
		mainFrame = new JFrame("Doktor Listesi Frame");
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
		
		Object[] basliklar = new Object[] { "TCKN", "Adi", "Soyadi", "Doðum Yeri", "Düzenle" };

		DoktorDaoImpl doktorDaoImpl = new DoktorDaoImpl();
		List<Doktor> doktorListAll = doktorDaoImpl.findAll();

		Object[][] doktorListesiMatris = new Object[doktorListAll.size()][5];
		doktorListesiMatris = doktorListesindenMatrisOlustur(doktorListAll);

		JTable table = new JTable(doktorListesiMatris, basliklar);
		table.getColumn("Düzenle").setCellRenderer(new ButtonRenderer());
		table.getColumn("Düzenle").setCellEditor(new ButtonEditorDoktor(new JCheckBox(), mainFrame));

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
