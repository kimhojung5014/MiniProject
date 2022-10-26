package ChatBox.soketversion;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;
import java.util.Vector;


public class MultiChatServer1 {
	private ServerSocket ss = null;
	private Socket s = null;
	Vector<Socket>socketlist = new Vector<Socket>();
	Vector<Thread>chatlist = new Vector<Thread>();
	
	public void start()  {  
		try {	
			ss = new ServerSocket(7777);
			System.out.println("server start");
			while (true) {
				//
				System.out.println("[연결 대기]");
				s = ss.accept();
				socketlist.add(s);
				new ChatThread().start(); //스레드 병렬처리
				System.out.println("[연결 완료]");		
				
			    //
			}
			
		} catch (Exception e) {
			System.out.println("[MultiChatServer]start() Exception 발생!");
			
		}
	}
	public static void main(String[] args)  {
		MultiChatServer1 server = new MultiChatServer1();
		server.start();
		
	}
	
	class ChatThread extends Thread{
		String msg;
		String[]rmsg;
		private BufferedReader inMsg = null;
		private PrintWriter outMsg = null;
		
		public void run() {	
			boolean status = true;
			System.out.println("##ChatThread Start..."+this.getName());
			try {
				//
				chatlist.add(this);				
				inMsg = new BufferedReader(new InputStreamReader(s.getInputStream()));
				//
				while(status) {
					msg = inMsg.readLine();
					rmsg = msg.split("/");
					if(rmsg[1].equals("logout")) {
						chatlist.remove(this);
						msgSendAll("Server/"+rmsg[0]+"님이 방을 나갔습니다.");
						msgSendAll("현재 인원/"+chatlist.size()+"명");
						status = false;
					}else if (rmsg[1].equals("login")) {
						msgSendAll("server/"+rmsg[0]+"님이 입장했습니다.");
						msgSendAll("현재 인원/"+chatlist.size()+"명");
					}else {	
						msgSendAll(msg);
					}
				}
				this.interrupt();
				System.out.println("##"+this.getName()+" stop!!");
				
			}catch (IOException e) {
				chatlist.remove(this);
				e.printStackTrace();
				System.out.println("[ChatThread]run() IOExceptin 발생"+this.getName());
			}
		}

		private void msgSendAll(String msg)  {
			for (Socket socket :  socketlist) {			
					try {
						outMsg =  new PrintWriter(socket.getOutputStream());
						outMsg.println(msg);
						outMsg.flush();
					} catch (IOException e) {
						e.printStackTrace();	 
						}
				
				}

		}// msgsendAll method
		
	} // chatThread

}//서버 
