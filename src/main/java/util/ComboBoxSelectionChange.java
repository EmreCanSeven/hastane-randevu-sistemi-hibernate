package util;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

public class ComboBoxSelectionChange extends JFrame {
    public ComboBoxSelectionChange() {
        initialize();
    }

    private void initialize() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        String[] items = new String[] {"A", "B", "C", "D", "E", "F"};
        JComboBox<String> comboBox = new JComboBox<String>(items);

        final JTextArea textArea = new JTextArea(5, 15);
        textArea.setBorder(new BevelBorder(BevelBorder.LOWERED));

        // For listening to the changes of the selected items in the combo box
        // we need to add an ItemListener to the combo box component as shown
        // below.
        comboBox.addItemListener(new ItemListener() {
            // Listening if a new items of the combo box has been selected.
            public void itemStateChanged(ItemEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();

                // The item affected by the event.
                Object item = event.getItem();

                textArea.setText("Affected items: " + item.toString());

                if (event.getStateChange() == ItemEvent.SELECTED) {
                    textArea.setText(item.toString() + " selected.");
                }

                if (event.getStateChange() == ItemEvent.DESELECTED) {
                    textArea.setText(item.toString() + " deselected.");
                }
            }
        });

        getContentPane().add(comboBox);
        getContentPane().add(textArea);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComboBoxSelectionChange().setVisible(true);
            }
        });
    }
}
