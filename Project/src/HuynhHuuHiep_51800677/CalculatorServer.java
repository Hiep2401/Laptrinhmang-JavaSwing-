package HuynhHuuHiep_51800677;
 
import java.awt.EventQueue;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
 
public class CalculatorServer extends JFrame implements Runnable {
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
			    @Override
			    public void run() {
				try {
				    CalculatorServer frame = new CalculatorServer();
				} catch (Exception e) {
				    e.printStackTrace();
				}
			    }
			});
		try{
			final ServerSocket svr=new ServerSocket(8080);
			while(true){
			Socket soc=svr.accept();
			new Thread(new CalcRunnable(soc)).start();
			}
		}catch(Exception ex){
			ex.printStackTrace();
			}
		}

	@Override
	public void run() {
		}
}
 
class CalcRunnable implements Runnable{
		Socket client=null;
		CalcRunnable(Socket client){
			this.client=client;
		}
	@Override
	public void run() {
	try {
		InputStream is=client.getInputStream();
		Scanner in=new Scanner(is);
		OutputStream os=client.getOutputStream();
		PrintWriter out=new PrintWriter(os,true/*auto-flush*/);
		while(in.hasNextLine()){
		double a=Double.parseDouble(in.nextLine());
		double b=Double.parseDouble(in.nextLine());
		char Execute=in.nextLine().charAt(0);
		double Ans=tinhtoan(a,b,Execute);
		out.println(Ans);
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
	}
	private double tinhtoan(double a, double b, char Execute) {
	double Exe=0;
	switch(Execute){
		case '+':Exe=a+b;
		break;
		case '-':Exe=a-b;
		break;
		case '*':Exe=a*b;
		break;
		case '/':Exe=a/b;
		break;
		}
	return Exe;
	}
}