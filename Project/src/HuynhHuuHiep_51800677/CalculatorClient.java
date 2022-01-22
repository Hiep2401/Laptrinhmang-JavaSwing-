package HuynhHuuHiep_51800677;
 
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
 
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DropMode;
import javax.swing.UIManager;
 
public class CalculatorClient extends JFrame implements ActionListener{
	private JTextField NumA,NumB,NumAns,IPAddress;
	private JButton Add,Sub,Mul,Div;
	private JTextField txtCalculatorOnline;
	public static void main(String[] args) {
		CalculatorClient frame = new CalculatorClient();
		frame.setVisible(true);
	}
	public CalculatorClient() {
		getContentPane().setBackground(Color.ORANGE);
		getContentPane().setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		setTitle("Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(645,510);
		setLocation(100,200);
 
		Box Frame=Box.createVerticalBox();
		Frame.setForeground(Color.BLUE);
		Frame.setBackground(Color.WHITE);
		Frame.setBorder(UIManager.getBorder("TextArea.border"));
		Frame.setBounds(21, 120, 600, 253);
		Box box1=Box.createHorizontalBox();
		Box box2=Box.createHorizontalBox();
		Box box3=Box.createHorizontalBox();
		Box box4=Box.createHorizontalBox();
		Box box5=Box.createHorizontalBox();
		JLabel NumberA,NumberB,Server;
 
		box5.add(Server=new JLabel("Server Address:",JLabel.RIGHT));
		Server.setAlignmentX(0.5f);
		Server.setFont(new Font("Comic Sans MS", Font.BOLD, 20));box5.add(IPAddress=new JTextField("localhost"));
		IPAddress.setBackground(Color.RED);
		IPAddress.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		box1.add(NumberA=new JLabel("Number A:",SwingConstants.CENTER));
		NumberA.setAlignmentX(0.5f);
		NumberA.setBackground(Color.YELLOW);
		NumberA.setFont(new Font("Comic Sans MS", Font.BOLD, 20));box1.add(NumA=new JTextField());
		NumA.setBackground(Color.YELLOW);
		box2.add(NumberB=new JLabel("Number B:",SwingConstants.CENTER));
		NumberB.setFont(new Font("Comic Sans MS", Font.BOLD, 20));box2.add(NumB=new JTextField());
		NumB.setBackground(Color.YELLOW);
		JLabel Answer = new JLabel("Answer:",JLabel.RIGHT);
		Answer.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		box4.add(Answer);box4.add(NumAns=new JTextField());
		NumAns.setHorizontalAlignment(SwingConstants.LEFT);
		NumAns.setEditable(false);
		NumAns.setBackground(Color.GREEN);
 
		box3.add(Add=new JButton("+"));
		Add.setFont(new Font("Comic Sans MS", Font.BOLD, 30));Add.addActionListener(this);
		box3.add(Sub=new JButton("-"));
		Sub.setFont(new Font("Comic Sans MS", Font.BOLD, 30));Sub.addActionListener(this);
		box3.add(Mul=new JButton("x"));
		Mul.setFont(new Font("Comic Sans MS", Font.BOLD, 30));Mul.addActionListener(this);
		box3.add(Div=new JButton("/"));
		Div.setFont(new Font("Comic Sans MS", Font.BOLD, 30));Div.addActionListener(this);
		NumberA.setPreferredSize(Server.getPreferredSize());
		NumberB.setPreferredSize(Server.getPreferredSize());
		getContentPane().setLayout(null);
		Frame.add(box5);
		Frame.add(box1);
		Frame.add(box2);
		Frame.add(box3);
		Frame.add(box4);
 
		getContentPane().add(Frame);
		JButton btnNewButton = new JButton("Back to Menu");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			MainFrame frame = new MainFrame();
			frame.setVisible(true);
			dispose();
			}
		});
		
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		btnNewButton.setBounds(184, 383, 303, 74);
		getContentPane().add(btnNewButton);
		txtCalculatorOnline = new JTextField();
		txtCalculatorOnline.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
		txtCalculatorOnline.setText("Calculator Online");
		txtCalculatorOnline.setBounds(178, 10, 309, 95);
		getContentPane().add(txtCalculatorOnline);
		txtCalculatorOnline.setColumns(10);
	}
 
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		try {
			double a=Double.parseDouble(NumA.getText());
			double b=Double.parseDouble(NumB.getText());
			String Execute="";
 
			if(obj.equals(Add)){
				Execute="+";
			}
			else if(obj.equals(Sub)){
				Execute="-";
			}
			else if(obj.equals(Mul))
				Execute="*";
			else if(obj.equals(Div))
				Execute="/";
 
			Socket soc=new Socket(IPAddress.getText(),8080);
			Scanner in=new Scanner(soc.getInputStream());
			PrintWriter out=new PrintWriter(soc.getOutputStream(),true);
			out.println(a);
			out.println(b);
			out.println(Execute);
 
			String Ans=in.nextLine();
			NumAns.setText(Ans);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
			}
	}
}