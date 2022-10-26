package ChatBox.soketversion;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiChatClient implements ActionListener,Runnable{
	private String ip;
	private String id;
	private Socket socket;
	private BufferedReader inMsg = null;
	private PrintWriter outMsg =null;
	private JPanel loginPanel;
	private JButton loginButton;
	private JLabel label1;
	private JTextField idInput;
	private JPanel logoutPanel;
	private JLabel label2;
	private JButton logoutButton;
	private JPanel msgPanel;
	private JTextField msgInput;
	private JButton exitButton;
	private JFrame jframe;
	private JTextArea msgOut;
	private Container tab;
	private CardLayout clayout;
	private Thread thread;
	boolean status;
	
	MultiChatClient(String ip){
		
		this.ip = ip;
		
		loginPanel = new JPanel();
		loginPanel.setLayout(new BorderLayout());
		idInput = new JTextField(10);
		loginButton = new JButton("입장하기");
		loginButton.addActionListener(this);
		label1 = new JLabel("대화명");
		loginPanel.add(label1,BorderLayout.WEST);
		loginPanel.add(idInput,BorderLayout.CENTER);
		loginPanel.add(loginButton,BorderLayout.EAST);
		
		logoutPanel = new JPanel();
		logoutPanel.setLayout(new BorderLayout());
		label2 = new JLabel();
		logoutButton = new JButton("방나가기");
		logoutButton.addActionListener(this);
		logoutPanel.add(label2,BorderLayout.CENTER);
		logoutPanel.add(logoutButton,BorderLayout.EAST);
		
		msgPanel = new JPanel();
		msgPanel.setLayout(new BorderLayout());
		msgInput = new JTextField(30);
		msgInput.addActionListener(this);
		
		exitButton = new JButton("채팅 종료");
		exitButton.addActionListener(this);
		msgPanel.add(msgInput,BorderLayout.CENTER);
		msgPanel.add(exitButton,BorderLayout.EAST);
		
		tab = new JPanel();
		clayout = new CardLayout();
		tab.setLayout(clayout);
		tab.add(loginPanel,"login");
		tab.add(logoutPanel,"logout");
		jframe = new JFrame("::온라인 채팅방::");
		msgOut = new JTextArea("", 10, 30);
		msgOut.setEditable(false);
		JScrollPane jsp = new JScrollPane(msgOut, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		jframe.add(tab,BorderLayout.NORTH);
		jframe.add(jsp,BorderLayout.CENTER);
		jframe.add(msgPanel,BorderLayout.SOUTH);
		clayout.show(tab, "login");
		jframe.pack();
		jframe.setResizable(true);
		jframe.setVisible(true);
	}
	
	public void connectServer() {
		try {
			System.out.println("[연결요청]");
			socket = new Socket("localhost",7777);
			inMsg = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			outMsg = new PrintWriter(socket.getOutputStream());
			System.out.println("[Client]Server 연결 성공!!");
			outMsg.println(id+"/"+"login");
			//
			outMsg.flush(); // flush가 있어야 값이 바로 서버로 보내짐
			//
			thread = new Thread() {
				@Override
				public void run() {
					System.out.println("##start "+this.getName());
					MultiChatClient.this.run();
				}
			};
			thread.start();
			//
			
		} catch (Exception e) {
			System.out.println("접속 예외 발생!");
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if(obj==exitButton) {
			// 닫기 버튼 눌러도 logout message 뜨게 서버에 보내줌 추가
			outMsg.println(id+"/"+"logout");
			outMsg.flush();// flush가 있어야 값이 바로 서버로 보내짐
			//
			System.exit(0);
		}else if(obj==loginButton) {
			id=idInput.getText();
			label2.setText("대화명:"+id);
			clayout.show(tab, "logout");
			connectServer();
			
		}else if (obj == logoutButton) {
			
			outMsg.println(id+"/"+"logout");
			//
			outMsg.flush();// flush가 있어야 값이 바로 서버로 보내짐
			//
			msgOut.setText("");
			clayout.show(tab, "login");
			outMsg.close();
			try {
				inMsg.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			status = false;
		}else if (obj == msgInput) {	
			outMsg.println(id+"/"+msgInput.getText());
			//
			outMsg.flush();// flush가 있어야 값이 바로 서버로 보내짐
			//
			msgInput.setText("");
		}
	}
	
	public void run() {
		String msg;
		String[] rmsg;
		status = true;
		while(status) {
			try {
				msg = inMsg.readLine();
				rmsg = msg.split("/");
				msgOut.append(rmsg[0]+">"+rmsg[1]+"\n");
				msgOut.setCaretPosition(msgOut.getDocument().getLength()); 
			} catch (IOException | NullPointerException e) {
			status = false;
			}
		}
		System.out.println("[MultiChatClient]"+thread.getName()+"종료됨");
	}
	
	public static void main(String[] args) {
	new MultiChatClient("localhost"); //생성자 ip

	}
	
	

}
