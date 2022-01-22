package HuynhHuuHiep_51800677;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartCalculator extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartCalculator frame = new StartCalculator();
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
	public StartCalculator() {
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorServer frame = new CalculatorServer();
				frame.setVisible(true);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(StartCalculator.class.getResource("/HuynhHuuHiep_51800677/2587239-200.png")));
		mntmNewMenuItem.setBounds(70, 10, 232, 240);
		contentPane.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalculatorClient frame = new CalculatorClient();
				frame.setVisible(true);
				dispose();
				}
		});
		mntmNewMenuItem_1.setIcon(new ImageIcon(StartCalculator.class.getResource("/HuynhHuuHiep_51800677/calculator (1).png")));
		mntmNewMenuItem_1.setBounds(70, 244, 232, 223);
		contentPane.add(mntmNewMenuItem_1);
		
		JLabel lblNewLabel = new JLabel("Click to open Server");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		lblNewLabel.setBounds(329, 95, 408, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblClickToCalculator = new JLabel("Click to Calculator");
		lblClickToCalculator.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		lblClickToCalculator.setBounds(329, 322, 408, 57);
		contentPane.add(lblClickToCalculator);
		
		JButton btnNewButton = new JButton("Back to Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		btnNewButton.setBounds(484, 213, 253, 68);
		contentPane.add(btnNewButton);
	}
}
