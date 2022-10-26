package ChatBox.threadVersion;


import java.io.BufferedReader;


import java.io.BufferedWriter;
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
	Vector<ChatThread>chatlist = new Vector<ChatThread>();
	
	public void start()  {  
		try {	
			ss = new ServerSocket(7777);
			System.out.println("server start");
			while (true) {
				//
				System.out.println("[연결 대기]");
				s = ss.accept();
				ChatThread chatThread = new ChatThread();
				chatlist.add(chatThread);	
				chatThread.start();
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
				inMsg = new BufferedReader(new InputStreamReader(s.getInputStream()));
				outMsg =  new PrintWriter(s.getOutputStream());
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
						msgSendAll("들어온 인원/"+chatlist.size()+"명");
					}else {	
						msgSendAll(msg);
					}
				}
				this.interrupt();
				System.out.println("##"+this.getName()+"stop!!");
				
			}catch (IOException e) {
				chatlist.remove(this);
				e.printStackTrace();
				System.out.println("[ChatThread]run() IOExceptin 발생"+this.getName());
			}
		}

		private void msgSendAll(String msg)  {
			for ( ChatThread thread :  chatlist) {	
				thread.outMsg.println(msg);
				thread.outMsg.flush();
			
			}

		}// msgsendAll method
		
	} // chatThread

}//서버 
