package HuynhHuuHiep_51800677;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		CalculatorServer.main(args);
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/HuynhHuuHiep_51800677/download.png")));
		setTitle("MainFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 933, 546);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Application");
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/HuynhHuuHiep_51800677/100px-Facebook_Messenger_logo_2018.svg.png")));
		mntmNewMenuItem.setBounds(42, 24, 125, 121);
		contentPane.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("");
		mntmNewMenuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/HuynhHuuHiep_51800677/image.png")));
		mntmNewMenuItem_1.setBounds(42, 155, 125, 108);
		contentPane.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("");
		mntmNewMenuItem_2.setIcon(new ImageIcon(MainFrame.class.getResource("/HuynhHuuHiep_51800677/user-icon-default_9180.png")));
		mntmNewMenuItem_2.setBounds(42, 273, 125, 100);
		contentPane.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("");
		mntmNewMenuItem_3.setIcon(new ImageIcon(MainFrame.class.getResource("/HuynhHuuHiep_51800677/Google-Chrome-icon.png")));
		mntmNewMenuItem_3.setBounds(42, 383, 125, 104);
		contentPane.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartCalculator frame = new StartCalculator();
				frame.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_4.setIcon(new ImageIcon(MainFrame.class.getResource("/HuynhHuuHiep_51800677/calculate.png")));
		mntmNewMenuItem_4.setBounds(201, 24, 125, 121);
		contentPane.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("");
		mntmNewMenuItem_5.setIcon(new ImageIcon(MainFrame.class.getResource("/HuynhHuuHiep_51800677/images.png")));
		mntmNewMenuItem_5.setBounds(201, 155, 125, 100);
		contentPane.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartChat frame = new StartChat();
				frame.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon(MainFrame.class.getResource("/HuynhHuuHiep_51800677/icon-message-100x100.png")));
		mntmNewMenuItem_6.setBounds(201, 273, 125, 100);
		contentPane.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartSendFile frame = new StartSendFile();
				frame.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_7.setIcon(new ImageIcon(MainFrame.class.getResource("/HuynhHuuHiep_51800677/send-file.png")));
		mntmNewMenuItem_7.setBounds(201, 383, 125, 104);
		contentPane.add(mntmNewMenuItem_7);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainFrame.class.getResource("/HuynhHuuHiep_51800677/4bbeb87a923add210ee03ab2118c739b.png")));
		lblNewLabel.setBounds(0, 0, 909, 509);
		contentPane.add(lblNewLabel);
	}
}
