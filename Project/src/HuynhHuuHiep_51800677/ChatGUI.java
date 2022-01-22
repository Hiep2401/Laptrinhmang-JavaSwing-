package HuynhHuuHiep_51800677;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class ChatGUI extends JPanel implements Runnable {

    private static final long serialVersionUID = 1L;
    private JTextArea textArea;
    private JButton btnNewButton;
    private JLabel lblNewLabel;
    private JLabel lblHistory;
    private JTextArea textArea_1;
    // ______________________________
    Socket socket = null;
    String Send;
    String Recei;
    BufferedReader Buffer = null;
    DataOutputStream DataOut = null;
    private JTextField txtChatMulclientserver;

    @Override
    public void run() {
	while (true) {
	    try {
		if (socket != null) {
		    String Message = "";
		    while ((Message = Buffer.readLine()) != null) {
			textArea_1.append(Message + "\n");
		    }
		}
	    } catch (Exception e) {
	    }
	}
    }

    public ChatGUI(Socket s, String Send, String Recei) {
    	setBackground(Color.GREEN);
	initComponents();
	socket = s;
	this.Send = Send;
	this.Recei = Recei;
	try {
	    
	    txtChatMulclientserver = new JTextField();
	    txtChatMulclientserver.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	    txtChatMulclientserver.setText("Chat MulClient/Server");
	    txtChatMulclientserver.setColumns(10);
	    
	    JLabel lblNewLabel_1 = new JLabel("");
	    lblNewLabel_1.setIcon(new ImageIcon(ChatGUI.class.getResource("/HuynhHuuHiep_51800677/haha-icon.png")));
	    
	    JLabel lblNewLabel_1_1 = new JLabel("");
	    lblNewLabel_1_1.setIcon(new ImageIcon(ChatGUI.class.getResource("/HuynhHuuHiep_51800677/unnamed.png")));
	    
	    JLabel lblNewLabel_1_1_1 = new JLabel("");
	    lblNewLabel_1_1_1.setIcon(new ImageIcon(ChatGUI.class.getResource("/HuynhHuuHiep_51800677/unnamed (1).png")));
	    
	    JLabel lblNewLabel_1_1_1_1 = new JLabel("");
	    lblNewLabel_1_1_1_1.setIcon(new ImageIcon(ChatGUI.class.getResource("/HuynhHuuHiep_51800677/ops-icon.png")));

	    GroupLayout groupLayout = new GroupLayout(this);
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(txtChatMulclientserver, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
	    			.addPreferredGap(ComponentPlacement.UNRELATED)
	    			.addComponent(getLblHistory(), GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(318, Short.MAX_VALUE))
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(getTextArea_1(), GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
	    			.addGap(14))
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(18)
	    			.addComponent(getTextArea(), GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
	    			.addGap(6)
	    			.addComponent(getBtnNewButton(), GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(12, Short.MAX_VALUE))
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(188)
	    			.addComponent(getLblNewLabel(), GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(263, Short.MAX_VALUE))
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(54)
	    			.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
	    			.addGap(45)
	    			.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
	    			.addGap(53)
	    			.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
	    			.addGap(67)
	    			.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(183, Short.MAX_VALUE))
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addContainerGap()
	    			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    				.addComponent(txtChatMulclientserver, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(getLblHistory(), GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE))
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addComponent(getTextArea_1(), GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
	    			.addGap(29)
	    			.addComponent(getLblNewLabel(), GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
	    			.addPreferredGap(ComponentPlacement.UNRELATED)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(getTextArea(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(getBtnNewButton(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    			.addPreferredGap(ComponentPlacement.UNRELATED)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(lblNewLabel_1_1_1_1, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
	    			.addGap(63))
	    );
	    Buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	    DataOut = new DataOutputStream(socket.getOutputStream());

	    setLayout(groupLayout);
	    (new Thread(this)).start();
	} catch (Exception e) {
	    System.out.println("Error while create Main Panel");
	}

    }

    private void initComponents() {
    }

    public JTextArea getTextArea() {
	if (textArea == null) {
	    textArea = new JTextArea();
	    textArea.setBackground(Color.YELLOW);
	    textArea.setFont(new Font("Arial", Font.PLAIN, 26));
	}
	return textArea;
    }

    public JButton getBtnNewButton() {
	if (btnNewButton == null) {
	    btnNewButton = new JButton("SEND");
	    btnNewButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
		    if (textArea.getText().isEmpty()) return;
		    try {
			DataOut.writeBytes(Send + ": " + textArea.getText() + "\n");
			DataOut.flush();
			textArea_1.append(Send + ": " + textArea.getText() + "\n");
			textArea.setText("");
		    } catch (Exception e) {
			System.out.println("Error while sendding messeger");
		    }
		}
	    });
	    btnNewButton.setBackground(Color.GREEN);
	    btnNewButton.setForeground(Color.BLUE);
	    btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
	}
	return btnNewButton;
    }

    public JLabel getLblNewLabel() {
	if (lblNewLabel == null) {
	    lblNewLabel = new JLabel("Type the messages here to send");
	    lblNewLabel.setForeground(Color.BLACK);
	    lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	}
	return lblNewLabel;
    }

    public JLabel getLblHistory() {
	if (lblHistory == null) {
	    lblHistory = new JLabel("History of Messages");
	    lblHistory.setForeground(Color.BLACK);
	    lblHistory.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
	}
	return lblHistory;
    }

    public JTextArea getTextArea_1() {
	if (textArea_1 == null) {
	    textArea_1 = new JTextArea();
	    textArea_1.setBackground(Color.YELLOW);
	    textArea_1.setFont(new Font("Arial", Font.PLAIN, 30));
	}
	return textArea_1;
    }
}