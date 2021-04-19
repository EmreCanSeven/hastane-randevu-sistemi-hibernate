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
import arayuz.util.ButtonEditorSekreter;
import arayuz.util.ButtonRenderer;
import impl.DoktorDaoImpl;
import impl.SekreterDaoImpl;
import model.Doktor;
import model.Sekreter;

public class ArayuzSekreterListeleme extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame mainFrame;
	private JPanel controlPanel;

	private Object[][] sekreterListesindenMatrisOlustur(List<Sekreter> sekreterList) {
		Object[][] result = new Object[sekreterList.size()][5];

		for (int i = 0; i < sekreterList.size(); i++) {
			Sekreter sekreter= sekreterList.get(i);
			result[i] = sekreteriArrayeCevir(sekreter);
		}

		return result;
	}

	private Object[] sekreteriArrayeCevir(Sekreter sekreter) {
		Object[] objArr = new Object[4];

		objArr[0] = sekreter.getTCKN();
		objArr[1] = sekreter.getAdi();
		objArr[2] = sekreter.getSoyadi();
		objArr[3] = sekreter.getId(); // Bunu seçildiðinde göndermek için almak zorundaydýk

		return objArr;
	}

	public ArayuzSekreterListeleme() {
		mainFrame = new JFrame("Sekreter Listesi Frame");
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
		
		Object[] basliklar = new Object[] { "TCKN", "Adi", "Soyadi", "Düzenle" };

		SekreterDaoImpl sekreterDaoImpl = new SekreterDaoImpl();
		List<Sekreter> sekreterListAll = sekreterDaoImpl.findAll();

		Object[][] sekreterListesiMatris = new Object[sekreterListAll.size()][5];
		sekreterListesiMatris = sekreterListesindenMatrisOlustur(sekreterListAll);

		JTable table = new JTable(sekreterListesiMatris, basliklar);
		table.getColumn("Düzenle").setCellRenderer(new ButtonRenderer());
		table.getColumn("Düzenle").setCellEditor(new ButtonEditorSekreter(new JCheckBox(), mainFrame));

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
