package HuynhHuuHiep_51800677;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;

public class ChatClient extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel JLable_1;
    private JTextField JTextField_1;
    private JLabel JLable_2;
    private JTextField JTextField_2;
    private JLabel JLable_3;
    private JTextField JTextField_3;
    private JPanel panel;
    private JButton btnNewButton;
    private JPanel panel_1;
    private JLabel lblNewLabel_1;


    Socket socket = null;
    String Address = "";
    int Port = 0;
    String Name = "";
    BufferedReader Buffer = null;
    DataOutputStream DataOut = null;
    private JButton btnNewButton_1;

    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		try {
		    ChatClient frame = new ChatClient();
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
    public ChatClient() {
	initComponents();
    }

    private void initComponents() {
	setTitle("ChatClient/Server");
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 822, 716);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	contentPane.add(getJLable_1());
	contentPane.add(getJTextField_1());
	contentPane.add(getJLable_2());
	contentPane.add(getJTextField_2());
	contentPane.add(getJLable_3());
	contentPane.add(getJTextField_3());
	contentPane.add(getPanel_1());
	contentPane.add(getBtnNewButton());
	contentPane.add(getPanel_1_1());
	contentPane.add(getBtnNewButton_1());
    }

    public JLabel getJLable_1() {
	if (JLable_1 == null) {
	    JLable_1 = new JLabel("Name");
	    JLable_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	    JLable_1.setBounds(23, 13, 131, 51);
	}
	return JLable_1;
    }

    public JTextField getJTextField_1() {
	if (JTextField_1 == null) {
	    JTextField_1 = new JTextField();
	    JTextField_1.setBounds(90, 26, 131, 31);
	    JTextField_1.setColumns(10);
	}
	return JTextField_1;
    }

    public JLabel getJLable_2() {
	if (JLable_2 == null) {
	    JLable_2 = new JLabel("Address ");
	    JLable_2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	    JLable_2.setBounds(231, 13, 115, 51);
	}
	return JLable_2;
    }

    public JTextField getJTextField_2() {
	if (JTextField_2 == null) {
	    JTextField_2 = new JTextField();
	    JTextField_2.setColumns(10);
	    JTextField_2.setBounds(319, 26, 131, 31);
	}
	return JTextField_2;
    }

    public JLabel getJLable_3() {
	if (JLable_3 == null) {
	    JLable_3 = new JLabel("Port");
	    JLable_3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	    JLable_3.setBounds(460, 13, 131, 51);
	}
	return JLable_3;
    }

    public JTextField getJTextField_3() {
	if (JTextField_3 == null) {
	    JTextField_3 = new JTextField();
	    JTextField_3.setColumns(10);
	    JTextField_3.setBounds(511, 26, 131, 31);
	}
	return JTextField_3;
    }

    public JPanel getPanel_1() {
	if (panel == null) {
	    panel = new JPanel();
	    panel.setBackground(Color.LIGHT_GRAY);
	    panel.setBorder(new MatteBorder(1, 1, 1, 1, Color.RED));
	    panel.setBounds(12, 72, 792, 554);
	    panel.setLayout(new GridLayout(1, 1, 1, 1));
	    panel.add(getLblNewLabel_1());
	}
	return panel;
    }

    public JButton getBtnNewButton() {
	if (btnNewButton == null) {
	    btnNewButton = new JButton("Connect");
	    btnNewButton.setIcon(null);
	    btnNewButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		    try {
			Address = JTextField_2.getText();
			Port = Integer.parseInt(JTextField_3.getText());
			Name = JTextField_1.getText();

			socket = new Socket(Address, Port);

			if (Name.isEmpty()) throw new Exception("Empty Name");
			if (socket == null) throw new Exception("Null Socket");

			panel.removeAll();
			ChatGUI chatPanel = new ChatGUI(socket, Name, "Server");
			panel.add(chatPanel);
			panel.updateUI();

			Thread t = new Thread(chatPanel);
			t.start();

			JOptionPane.showMessageDialog(contentPane, "Connect success", "Connected",
			                JOptionPane.INFORMATION_MESSAGE);
		    } catch (Exception e) {
			JOptionPane.showMessageDialog(contentPane,
			                "Error while connect, please check details try again!\nDetails: " + e,
			                "Error while connect", JOptionPane.ERROR_MESSAGE);
		    }
		}
	    });
	    btnNewButton.setBackground(Color.ORANGE);
	    btnNewButton.setForeground(Color.RED);
	    btnNewButton.setBorder(new MatteBorder(1, 1, 1, 1, new Color(0, 0, 0)));
	    btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	    btnNewButton.setBounds(658, 13, 146, 51);
	}
	return btnNewButton;
    }

    public JPanel getPanel_1_1() {
	if (panel_1 == null) {
	    panel_1 = new JPanel();
	    panel_1.setBackground(Color.GREEN);
	    panel_1.setBorder(new LineBorder(Color.BLACK, 2));
	    panel_1.setBounds(12, 13, 792, 51);
	}
	return panel_1;
    }

    public JLabel getLblNewLabel_1() {
	if (lblNewLabel_1 == null) {
	    lblNewLabel_1 = new JLabel("Type infomation above to connect");
	    lblNewLabel_1.setBackground(Color.CYAN);
	    lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
	    lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
	    lblNewLabel_1.setForeground(Color.RED);
	    lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	}
	return lblNewLabel_1;
    }
	private JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("Back to Menu");
			btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			btnNewButton_1.setBounds(272, 640, 259, 38);
		}
		return btnNewButton_1;
	}
}