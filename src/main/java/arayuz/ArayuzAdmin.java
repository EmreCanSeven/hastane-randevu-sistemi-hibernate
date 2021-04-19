package arayuz;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class ArayuzAdmin extends javax.swing.JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFrame frame2;

	public ArayuzAdmin() {
		initialize();

	}


	public void initialize() {

		Toolkit toolkit = Toolkit.getDefaultToolkit();  
		Dimension screenSize = toolkit.getScreenSize();

		frame2 = new JFrame();
		frame2.setBounds(100, 100, 875, 875);
		frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame2.setTitle("Admin Sayfasi");
		frame2.getContentPane().setLayout(null);

		int x =(screenSize.width - frame2.getWidth()) / 2;
		int y =(screenSize.height - frame2.getHeight()) / 2;

		frame2.setLocation(x, y);


		JButton btnDoktorKayit = new JButton(" Doktor Kayit ");
		btnDoktorKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ArayuzDoktorKayit theWindow = new ArayuzDoktorKayit();
							theWindow.getFrame().setVisible(true);

//							frame2.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});


			}

		});

		btnDoktorKayit.setBounds(50, 50, 125, 50);
		frame2.getContentPane().add(btnDoktorKayit);
		
		
		
//		JButton btnDoktorDuzenleme = new JButton(" Doktor Duzenle ");
//		btnDoktorDuzenleme.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//
//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							ArayuzDoktorDuzenleme theWindow = new ArayuzDoktorDuzenleme();
//							theWindow.getFrame().setVisible(true);
//
////							frame2.setVisible(false);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
//
//
//			}
//
//		});
//
//		btnDoktorDuzenleme.setBounds(195, 50, 125, 50);
//		frame2.getContentPane().add(btnDoktorDuzenleme);
		
		
		
		JButton btnDoktorListele = new JButton(" Doktor Listele ");
		btnDoktorListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							ArayuzDoktorListeleme2 theWindow = new ArayuzDoktorListeleme2();
//							theWindow.getFrame().setVisible(true);
//
//							frame2.setVisible(false);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {

						new ArayuzDoktorListeleme2().getMainFrame().setVisible(true);
						 
					}
				});
			}
		});

		btnDoktorListele.setBounds(340, 50, 125, 50);
		frame2.getContentPane().add(btnDoktorListele);
		
		
		
		JButton btnHastaKayit = new JButton(" Hasta Kayit ");
		btnHastaKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ArayuzHastaKayit theWindow = new ArayuzHastaKayit();
							theWindow.getFrame().setVisible(true);

//							frame2.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});


			}

		});

		btnHastaKayit.setBounds(50, 120, 125, 50);
		frame2.getContentPane().add(btnHastaKayit);
		
		
		
//		JButton btnHastaDuzenleme = new JButton(" Hasta Duzenleme ");
//		btnHastaDuzenleme.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//
//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							ArayuzHastaDuzenleme theWindow = new ArayuzHastaDuzenleme();
//							theWindow.getFrame().setVisible(true);
//
////							frame2.setVisible(false);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
//
//
//			}
//
//		});
//
//		btnHastaDuzenleme.setBounds(195, 120, 125, 50);
//		frame2.getContentPane().add(btnHastaDuzenleme);

		
		
		JButton btnHastaListele = new JButton(" Hasta Listele ");
		btnHastaListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							ArayuzHastaListeleme theWindow = new ArayuzHastaListeleme();
//							theWindow.getFrame().setVisible(true);
//
////							frame2.setVisible(false);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						
						new ArayuzHastaListeleme().setVisible(true);
						 
							
					}
				});


			}

		});

		btnHastaListele.setBounds(340, 120, 125, 50);
		frame2.getContentPane().add(btnHastaListele);
		
		
		
		JButton btnSekreterKayit = new JButton(" Sekreter Kayit ");
		btnSekreterKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ArayuzSekreterKayit theWindow = new ArayuzSekreterKayit();
							theWindow.getFrame().setVisible(true);

//							frame2.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});


			}

		});

		btnSekreterKayit.setBounds(50, 190, 125, 50);
		frame2.getContentPane().add(btnSekreterKayit);
		
		
		
//		JButton btnSekreterDuzenleme = new JButton(" Sekreter Duzenleme ");
//		btnSekreterDuzenleme.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//
//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							ArayuzSekreterDuzenleme theWindow = new ArayuzSekreterDuzenleme();
//							theWindow.getFrame().setVisible(true);
//
////							frame2.setVisible(false);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
//
//
//			}
//
//		});
//
//		btnSekreterDuzenleme.setBounds(195, 190, 125, 50);
//		frame2.getContentPane().add(btnSekreterDuzenleme);
		
		
		
		JButton btnSekreterListele = new JButton(" Sekreter Listele ");
		btnSekreterListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							ArayuzSekreterListeleme theWindow = new ArayuzSekreterListeleme();
//							theWindow.getFrame().setVisible(true);
//
////							frame2.setVisible(false);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						
						new ArayuzSekreterListeleme().setVisible(true);
						 
							
					}
				});


			}

		});

		btnSekreterListele.setBounds(340, 190, 125, 50);
		frame2.getContentPane().add(btnSekreterListele);
		
		
		
		JButton btnRandevuKayit = new JButton(" Randevu Kayit ");
		btnRandevuKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ArayuzRandevuKayit theWindow = new ArayuzRandevuKayit();
							theWindow.getFrame().setVisible(true);

							frame2.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});


			}

		});

		btnRandevuKayit.setBounds(50, 260, 125, 50);
		frame2.getContentPane().add(btnRandevuKayit);
		
		
		
//		JButton btnRandevuduzenleme = new JButton(" Randevu Duzenleme ");
//		btnRandevuduzenleme.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//
//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							ArayuzRandevuDuzenleme theWindow = new ArayuzRandevuDuzenleme();
//							theWindow.getFrame().setVisible(true);
//
////							frame2.setVisible(false);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
//
//
//			}
//
//		});
//
//		btnRandevuduzenleme.setBounds(195, 260, 125, 50);
//		frame2.getContentPane().add(btnRandevuduzenleme);
		
		
		
		JButton btnRandevuListele = new JButton(" Randevu Listele ");
		btnRandevuListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							ArayuzRandevuListeleme theWindow = new ArayuzRandevuListeleme();
//							theWindow.getFrame().setVisible(true);
//
//							frame2.setVisible(false);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						
						new ArayuzRandevuListeleme().setVisible(true);
						 
							
					}
				});


			}

		});

		btnRandevuListele.setBounds(340, 260, 125, 50);
		frame2.getContentPane().add(btnRandevuListele);
		
		
		
		JButton btnHastahaneKayit = new JButton(" Hastahane Kayit ");
		btnHastahaneKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ArayuzHastahaneKayit theWindow = new ArayuzHastahaneKayit();
							theWindow.getFrame().setVisible(true);

//							frame2.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});


			}

		});

		btnHastahaneKayit.setBounds(50, 330, 125, 50);
		frame2.getContentPane().add(btnHastahaneKayit);
		
		
		
//		JButton btnHastahaneDuzeneleme = new JButton(" Hastahane Duzenleme ");
//		btnHastahaneDuzeneleme.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//
//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							ArayuzHastahaneDuzenleme theWindow = new ArayuzHastahaneDuzenleme();
//							theWindow.getFrame().setVisible(true);
//
////							frame2.setVisible(false);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
//
//
//			}
//
//		});
//
//		btnHastahaneDuzeneleme.setBounds(195, 330, 125, 50);
//		frame2.getContentPane().add(btnHastahaneDuzeneleme);
		
		
		
		JButton btnHastahaneListele = new JButton(" Hastahane Listele ");
		btnHastahaneListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							ArayuzHastahaneListeleme theWindow = new ArayuzHastahaneListeleme();
//							theWindow.getFrame().setVisible(true);
//
//							frame2.setVisible(false);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						
						new ArayuzHastahaneListeleme().setVisible(true);
						 
							
					}
				});


			}

		});

		btnHastahaneListele.setBounds(340, 330, 125, 50);
		frame2.getContentPane().add(btnHastahaneListele);
		
		
		
		JButton btnSehirKayit = new JButton(" Sehir Kayit ");
		btnSehirKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ArayuzSehirKayit theWindow = new ArayuzSehirKayit();
							theWindow.getFrame().setVisible(true);

//							frame2.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});


			}

		});

		btnSehirKayit.setBounds(50, 400, 125, 50);
		frame2.getContentPane().add(btnSehirKayit);
		
		
		
//		JButton btnSehirDuzenleme = new JButton(" Sehir Duzenleme ");
//		btnSehirDuzenleme.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//
//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							ArayuzSehirDuzenleme theWindow = new ArayuzSehirDuzenleme();
//							theWindow.getFrame().setVisible(true);
//
////							frame2.setVisible(false);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
//
//
//			}
//
//		});
//
//		btnSehirDuzenleme.setBounds(195, 400, 125, 50);
//		frame2.getContentPane().add(btnSehirDuzenleme);
		
		
		
		JButton btnSehirListele = new JButton(" Sehir Listele ");
		btnSehirListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							ArayuzSehirListeleme theWindow = new ArayuzSehirListeleme();
//							theWindow.getFrame().setVisible(true);
//
//							frame2.setVisible(false);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						
						new ArayuzSehirListeleme().setVisible(true);
						 
							
					}
				});


			}

		});

		btnSehirListele.setBounds(340, 400, 125, 50);
		frame2.getContentPane().add(btnSehirListele);
		
		
		
		JButton btnPoliklinikKayit = new JButton(" Poliklinik Kayit ");
		btnPoliklinikKayit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ArayuzPoliklinikKayit theWindow = new ArayuzPoliklinikKayit();
							theWindow.getFrame().setVisible(true);

//							frame2.setVisible(false);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});


			}

		});

		btnPoliklinikKayit.setBounds(50, 470, 125, 50);
		frame2.getContentPane().add(btnPoliklinikKayit);

		
		
//		JButton btnPoliklinikDuzenleme = new JButton(" Poliklinik Duzenleme ");
//		btnPoliklinikDuzenleme.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//
//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							ArayuzPoliklinikDuzenleme theWindow = new ArayuzPoliklinikDuzenleme();
//							theWindow.getFrame().setVisible(true);
//
////							frame2.setVisible(false);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
//
//
//			}
//
//		});
//
//		btnPoliklinikDuzenleme.setBounds(195, 470, 125, 50);
//		frame2.getContentPane().add(btnPoliklinikDuzenleme);

		
		
		JButton btnPoliklinikListele = new JButton(" Poliklinik Listele ");
		btnPoliklinikListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							ArayuzPoliklinikListeleme theWindow = new ArayuzPoliklinikListeleme();
//							theWindow.getFrame().setVisible(true);
//
////							frame2.setVisible(false);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						
						new ArayuzPoliklinikListeleme().setVisible(true);
						 
							
					}
				});


			}

		});

		btnPoliklinikListele.setBounds(340, 470, 125, 50);
		frame2.getContentPane().add(btnPoliklinikListele);
		
		
		
		JButton btnKapat = new JButton(" Kapat ");
		btnKapat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame2.dispose();

			}

		});

		btnKapat.setBounds(195, 540, 125, 50);
		frame2.getContentPane().add(btnKapat);

		frame2.setVisible(true);
		pack();
	}




	public JFrame getFrame() {
		return frame2;
	}

	public void setFrame(JFrame frame2) {
		this.frame2 = frame2;
	}






}
