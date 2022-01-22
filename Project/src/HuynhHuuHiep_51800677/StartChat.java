package HuynhHuuHiep_51800677;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class StartChat extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartChat frame = new StartChat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartChat() {
		setFont(new Font("Dialog", Font.BOLD, 20));
		setTitle("Start Client/Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatClient frame = new ChatClient();
				frame.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem.setBackground(Color.CYAN);
		mntmNewMenuItem.setIcon(new ImageIcon(StartChat.class.getResource("/HuynhHuuHiep_51800677/power.png")));
		mntmNewMenuItem.setBounds(108, 264, 276, 260);
		contentPane.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChatServer frame = new ChatServer();
				frame.setVisible(true);
			}
		});
		mntmNewMenuItem_1.setBackground(Color.YELLOW);
		mntmNewMenuItem_1.setIcon(new ImageIcon(StartChat.class.getResource("/HuynhHuuHiep_51800677/power-button.png")));
		mntmNewMenuItem_1.setBounds(108, 10, 276, 260);
		contentPane.add(mntmNewMenuItem_1);
		
		JLabel lblNewLabel = new JLabel("Start Server");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(417, 105, 386, 102);
		contentPane.add(lblNewLabel);
		
		JLabel lblStartClient = new JLabel("Start Client");
		lblStartClient.setForeground(Color.BLUE);
		lblStartClient.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblStartClient.setBounds(417, 348, 386, 102);
		contentPane.add(lblStartClient);
		
		JButton btnNewButton = new JButton("Back to Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		btnNewButton.setBounds(601, 217, 276, 102);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(StartChat.class.getResource("/HuynhHuuHiep_51800677/35687hd.jpg")));
		lblNewLabel_1.setBounds(-365, 0, 1421, 524);
		contentPane.add(lblNewLabel_1);
	}
}
