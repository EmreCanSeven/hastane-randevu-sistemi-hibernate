package arayuz.util;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTable;

import arayuz.ArayuzDoktorDuzenleme;
import arayuz.ArayuzSekreterDuzenleme;

public class ButtonEditorSekreter extends DefaultCellEditor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JButton button;
//	private String label;
	private Long labelId;
	private boolean isPushed;

//	public ButtonEditor(JCheckBox checkBox, final long id) {
	public ButtonEditorSekreter(JCheckBox checkBox, final JFrame frame) {
		super(checkBox);
//		button = new JButton(String.valueOf(id));
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				EventQueue.invokeLater(new Runnable() {
					public void run() {

						new ArayuzSekreterDuzenleme(labelId).setVisible(true);
						
					}
				});

			}

		});
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
		} else {
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
		}
		labelId = (value == null) ? -1L : Long.parseLong(value.toString());
//		button.setText(label);
		button.setText("Duzenleee");
		isPushed = true;
		return button;
	}

	@Override
	public Object getCellEditorValue() {
		if (isPushed) {
//			JOptionPane.showMessageDialog(button, labelId + ": Ouch!");
		}
		isPushed = false;
		return labelId;
	}

	@Override
	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}


}
