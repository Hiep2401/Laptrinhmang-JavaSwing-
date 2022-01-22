package HuynhHuuHiep_51800677;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class ChatServer extends JFrame implements Runnable {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField textField;
    private JTabbedPane tabbedPane;
    private JButton btnNewButton;
    // _________________________________________
    ChatServer thisManager;
    ServerSocket socket = null;
    BufferedReader br = null;
    Thread t;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_1_1;

    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    ChatServer frame = new ChatServer();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    public ChatServer() {
	initComponents();
	thisManager = this;
    }

    private void initComponents() {
	setTitle("Chat Client/Server");
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 835, 674);
	contentPane = new JPanel();
	contentPane.setBackground(Color.GREEN);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	contentPane.add(getLblNewLabel());
	contentPane.add(getTextField());
	contentPane.add(getTabbedPane());
	contentPane.add(getBtnNewButton());
	
	JLabel lblNewLabel_3 = new JLabel("Example: 8, 80, 123, ..vv");
	lblNewLabel_3.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
	lblNewLabel_3.setBounds(291, 83, 184, 13);
	contentPane.add(lblNewLabel_3);
	
	JButton btnNewButton_1 = new JButton("Back to Menu");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MainFrame frame = new MainFrame();
		    frame.setVisible(true);
		    dispose();
		}
	});
	btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
	btnNewButton_1.setBounds(291, 604, 256, 32);
	contentPane.add(btnNewButton_1);
	contentPane.add(getLblNewLabel_1());
	contentPane.add(getLblNewLabel_1_1());
    }

    public JLabel getLblNewLabel() {
	if (lblNewLabel == null) {
	    lblNewLabel = new JLabel("Input Port ");
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
	    lblNewLabel.setBounds(169, 25, 202, 53);
	}
	return lblNewLabel;
    }

    public JTextField getTextField() {
	if (textField == null) {
	    textField = new JTextField();
	    textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
	    textField.setBounds(291, 27, 184, 46);
	    textField.setColumns(10);
	}
	return textField;
    }

    public JTabbedPane getTabbedPane() {
	if (tabbedPane == null) {
	    tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	    tabbedPane.setFont(new Font("Sylfaen", Font.PLAIN, 20));
	    tabbedPane.setBorder(null);
	    tabbedPane.setBounds(12, 103, 805, 491);
	    tabbedPane.addTab(null, null, getLblNewLabel_2(), null);
	}
	return tabbedPane;
    }

    @Override
    public void run() {
	while (true)

	    try {
		Socket staffSocket = socket.accept();
		if (staffSocket != null) {
		    br = new BufferedReader(new InputStreamReader(staffSocket.getInputStream()));
		    String staffName = br.readLine();
		    staffName = staffName.substring(0, staffName.indexOf(":"));

		    ChatGUI chatPanel = new ChatGUI(staffSocket, "Manager", staffName);
		    tabbedPane.add(staffName, chatPanel);
		    chatPanel.updateUI();

		    Thread t = new Thread(chatPanel);
		    t.start();
		}

	    } catch (Exception e) {
	
	    }
    }

    public JButton getBtnNewButton() {
	if (btnNewButton == null) {
	    btnNewButton = new JButton("START SERVER");
	    btnNewButton.setBackground(Color.YELLOW);
	    btnNewButton.setForeground(Color.RED);
	    btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
	    btnNewButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		    int port = 8;
		    try {
			port = Integer.parseInt(textField.getText());
		    } catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane,
			                "Can't start at this port, program will use the default port=8\nDetails: " + e,
			                "Error while read Port", JOptionPane.ERROR_MESSAGE);
		    }
		    try {
			socket = new ServerSocket(port);
			JOptionPane.showMessageDialog(contentPane, "Server is running at port: " + port, "Started server",
			                JOptionPane.INFORMATION_MESSAGE);

		    } catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane, "Details: " + e, "Start server error",
			                JOptionPane.ERROR_MESSAGE);
		    }

		    Thread t = new Thread(thisManager);
		    t.start();
		}
	    });
	    btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
	    btnNewButton.setBounds(487, 25, 167, 47);
	}
	return btnNewButton;
    }

    public JLabel getLblNewLabel_2() {
	if (lblNewLabel_2 == null) {
	    lblNewLabel_2 = new JLabel("Looking for Client");
	    lblNewLabel_2.setBackground(Color.YELLOW);
	    lblNewLabel_2.setForeground(Color.BLUE);
	    lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
	    lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
	}
	return lblNewLabel_2;
    }
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(ChatServer.class.getResource("/HuynhHuuHiep_51800677/haha-icon.png")));
			lblNewLabel_1.setBounds(16, 10, 143, 127);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("");
			lblNewLabel_1_1.setIcon(new ImageIcon(ChatServer.class.getResource("/HuynhHuuHiep_51800677/unnamed.png")));
			lblNewLabel_1_1.setBounds(674, 10, 143, 127);
		}
		return lblNewLabel_1_1;
	}
}