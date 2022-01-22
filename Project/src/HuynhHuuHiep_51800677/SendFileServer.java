package HuynhHuuHiep_51800677;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.InflaterInputStream;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

public class SendFileServer extends JFrame{

	private JFrame frame;
	static InputStream in ;
	static OutputStream out;
	static ServerSocket serverSocket;
	static JLabel lblNewLabel_3;
	static JLabel lblNewLabel_4;
	static JLabel lblNewLabel_5;
	private JTextField txtSendFileFrom;
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SendFileServer frame = new SendFileServer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
 
		serverSocket = new ServerSocket(8080);
		 
		Socket socket = serverSocket.accept();
		lblNewLabel_4.setText("Accepted");
		lblNewLabel_4.setForeground(new Color(127, 255, 0));
		in = socket.getInputStream();
		out = new FileOutputStream("test.txt");
		
		byte [] b = new byte[16*1024];
		
		int count ;
		while ((count = in.read(b)) >0) {
			out.write(b, 0, count);
			lblNewLabel_5.setText(" File recieved");
			lblNewLabel_5.setForeground(Color.ORANGE);
		}
		
	}

	/**
	 * Create the application.
	 */
	public SendFileServer() {
		setTitle("SendFile");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		getContentPane().setBackground(Color.BLUE);
		setBackground(Color.WHITE);
		setBounds(100, 100, 586, 396);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblServer = new JLabel("Recieved File from Client");
		lblServer.setBackground(new Color(240, 240, 240));
		lblServer.setForeground(new Color(255, 255, 255));
		lblServer.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblServer.setBounds(34, 10, 433, 98);
		getContentPane().add(lblServer);
		
		JLabel lblNewLabel = new JLabel("Status : ");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(34, 111, 94, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Connected : ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNewLabel_1.setBounds(30, 157, 135, 39);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Recieved files : ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNewLabel_2.setBounds(30, 208, 162, 33);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Run");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_3.setForeground(new Color(255, 255, 0));
		lblNewLabel_3.setBounds(129, 120, 249, 22);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("No Connected");
		lblNewLabel_4.setForeground(Color.YELLOW);
		lblNewLabel_4.setBackground(Color.YELLOW);
		
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_4.setBounds(155, 157, 318, 39);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("No File");
		lblNewLabel_5.setForeground(Color.YELLOW);
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 18));
		
		lblNewLabel_5.setBounds(196, 208, 249, 33);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_6.setBackground(Color.BLUE);
		lblNewLabel_6.setIcon(new ImageIcon(SendFileServer.class.getResource("/HuynhHuuHiep_51800677/folder.png")));
		lblNewLabel_6.setBounds(10, 10, 552, 339);
		getContentPane().add(lblNewLabel_6);
		
		txtSendFileFrom = new JTextField();
		txtSendFileFrom.setText("Send File from Client to Server");
		txtSendFileFrom.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		txtSendFileFrom.setBounds(138, 272, 383, 39);
		getContentPane().add(txtSendFileFrom);
		txtSendFileFrom.setColumns(10);
	}
}
