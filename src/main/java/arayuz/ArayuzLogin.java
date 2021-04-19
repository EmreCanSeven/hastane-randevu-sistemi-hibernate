package arayuz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ArayuzLogin extends javax.swing.JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField txtTCKN;
	private JTextField txtPassword;

	private JFrame frame;


	public ArayuzLogin() {
		initialize();

	}

	public void initialize() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame = new JFrame();
		frame.setBounds(100, 100, 875, 875);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setTitle("Sisteme Giris");
		frame.getContentPane().setLayout(null);

		int x =(screenSize.width - frame.getWidth()) / 2;
		int y =(screenSize.height - frame.getHeight()) / 2;

		frame.setLocation(x, y);

		JLabel lblTCKN = new JLabel("TC Kimlik No : ");
		lblTCKN.setBounds(10, 10, 107, 36);
		frame.getContentPane().add(lblTCKN);

		txtTCKN = new JTextField();
		txtTCKN.setBounds(130, 15, 185, 24);
		txtTCKN.setBackground(Color.WHITE);
		frame.getContentPane().add(txtTCKN);
		txtTCKN.setColumns(10);

		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setBounds(10, 60, 107, 36);
		frame.getContentPane().add(lblPassword);

		txtPassword= new JTextField();
		txtPassword.setBounds(130, 65, 185, 24);
		txtPassword.setBackground(Color.WHITE);
		frame.getContentPane().add(txtPassword);
		txtPassword.setColumns(10);




		JButton btnLogin = new JButton(" Login ");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ArayuzAdmin theWindow = new ArayuzAdmin();
							theWindow.getFrame().setVisible(true);

							frame.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});


			}

		});

		btnLogin.setBounds(130, 100, 90, 50);
		frame.getContentPane().add(btnLogin);



		JButton btnKapat = new JButton(" Kapat ");
		btnKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame.dispose();

			}

		});

		btnKapat.setBounds(235, 100, 80, 50);
		frame.getContentPane().add(btnKapat);



		frame.setVisible(true);
		pack();
	}




	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}







}
