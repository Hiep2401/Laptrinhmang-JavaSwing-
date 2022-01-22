package HuynhHuuHiep_51800677;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Color;

public class StartSendFile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartSendFile frame = new StartSendFile();
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
	public StartSendFile() {
		setTitle("SendFile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1050, 496);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendFileServer frame = new SendFileServer();
				frame.setVisible(true);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(StartSendFile.class.getResource("/HuynhHuuHiep_51800677/play-button.png")));
		mntmNewMenuItem.setBounds(60, 10, 133, 152);
		contentPane.add(mntmNewMenuItem);
		
		JLabel lblNewLabel = new JLabel("Click to open Server");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblNewLabel.setBounds(239, 53, 445, 73);
		contentPane.add(lblNewLabel);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SendFileClient frame = new SendFileClient();
				frame.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(StartSendFile.class.getResource("/HuynhHuuHiep_51800677/route.png")));
		mntmNewMenuItem_1.setBounds(60, 222, 133, 152);
		contentPane.add(mntmNewMenuItem_1);
		
		JLabel lblClickToSend = new JLabel("Click to send File");
		lblClickToSend.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblClickToSend.setBounds(239, 273, 445, 73);
		contentPane.add(lblClickToSend);
		
		JButton btnNewButton = new JButton("Back to Menu");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		btnNewButton.setBounds(709, 163, 215, 82);
		contentPane.add(btnNewButton);
	}

}
