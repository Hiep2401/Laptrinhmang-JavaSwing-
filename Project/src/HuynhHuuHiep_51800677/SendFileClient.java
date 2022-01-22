package HuynhHuuHiep_51800677;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SendFileClient extends JFrame{

	private JFrame frame;
	private JTextField textField;
	static Socket socket;
	String str;
	static InputStream in ;
	static OutputStream out;
	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendFileClient frame = new SendFileClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		socket = new Socket("127.0.0.1", 8080);
	}
	/**
	 * Create the application.
	 */
	public SendFileClient() {
		setTitle("SendFile");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setBackground(UIManager.getColor("Button.highlight"));
		setBounds(100, 100, 629, 307);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select file ");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel.setBounds(234, 21, 120, 33);
		getContentPane().add(lblNewLabel);
		
		JButton btnBrowse = new JButton("Browse file");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.showOpenDialog(btnBrowse);
				  str = fileChooser.getSelectedFile().getAbsolutePath();
				  textField.setText(str);
			}
		});
		btnBrowse.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnBrowse.setForeground(Color.RED);
		btnBrowse.setBackground(Color.DARK_GRAY);
		btnBrowse.setBounds(209, 147, 167, 33);
		getContentPane().add(btnBrowse);
		
		textField = new JTextField();
		textField.setFont(new Font("Caladea", Font.PLAIN, 20));
		textField.setBounds(37, 65, 524, 33);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSend = new JButton("Send File");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				File file = new File(str);
				
				byte [] b = new byte[16*1024];
				
				try {
					in = new FileInputStream(file);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} 
				
				try {
					out = socket.getOutputStream();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				try {
					int count ;
					while ((count  = in.read(b))>0) {
						out.write(b, 0, count);
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSend.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		btnSend.setForeground(Color.BLACK);
		btnSend.setBackground(Color.ORANGE);
		btnSend.setBounds(350, 212, 211, 48);
		getContentPane().add(btnSend);
		
		JButton btnNewButton = new JButton("Back to Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartSendFile frame = new StartSendFile();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(37, 211, 211, 48);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("(images, mp3, mp4, txt, word...vv)");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel_1.setBounds(37, 108, 524, 29);
		getContentPane().add(lblNewLabel_1);
}
}
