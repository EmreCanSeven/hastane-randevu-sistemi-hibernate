package arayuz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import arayuz.util.ButtonEditorDoktor;
import arayuz.util.ButtonEditorSehir;
import arayuz.util.ButtonRenderer;
import impl.DoktorDaoImpl;
import impl.SehirDaoImpl;
import model.Doktor;
import model.Sehir;



public class ArayuzSehirListeleme extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame mainFrame;
	private JPanel controlPanel;

	private Object[][] sehirListesindenMatrisOlustur(List<Sehir> sehirList) {
		Object[][] result = new Object[sehirList.size()][5];

		for (int i = 0; i < sehirList.size(); i++) {
			Sehir sehir = sehirList.get(i);
			result[i] = sehiriArrayeCevir(sehir);
		}

		return result;
	}

	private Object[] sehiriArrayeCevir(Sehir sehir) {
		Object[] objArr = new Object[2];

		objArr[0] = sehir.getAdi();
		objArr[1] = sehir.getId(); // Bunu seçildiðinde göndermek için almak zorundaydýk

		return objArr;
	}

	public ArayuzSehirListeleme() {
		
		
		mainFrame = new JFrame("Sehir Listesi ");
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
		
		Object[] basliklar = new Object[] { "Adi", "Düzenle" };

		SehirDaoImpl sehirDaoImpl = new SehirDaoImpl();
		List<Sehir> sehirListAll = sehirDaoImpl.findAll();

		Object[][] sehirListesiMatris = new Object[sehirListAll.size()][5];
		sehirListesiMatris = sehirListesindenMatrisOlustur(sehirListAll);

		JTable table = new JTable(sehirListesiMatris, basliklar);
		table.getColumn("Düzenle").setCellRenderer(new ButtonRenderer());
		table.getColumn("Düzenle").setCellEditor(new ButtonEditorSehir(new JCheckBox(), mainFrame));

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

