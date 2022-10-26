package Linked;
public class LinkedList1CommentVersion {
	
	private ListNode head;

	public LinkedList1CommentVersion() {
		head = null;
	}
	
	public void insertMiddleNode(ListNode pre, String data) {
		ListNode newNode = new ListNode(data);
		//
		newNode.link = pre.link;   //newNode의 link에 원래있던 pre의 link를 연결
		pre.link = newNode;			//pre의 link에 newNode 연결 
	}
	
	
	public void insertLastNode(String data) {
		ListNode newNode = new ListNode(data);		
		//
		ListNode temp = this.head; //head의 주고를 temp에 저장
		while(temp != null) {			  //temp가 null이 아닌 동안 루프
			if(temp.link!=null) {temp = temp.link;}	// temp.link가 null인지 확인 null이 아니면 그다음 link로
			else{temp.link = newNode; return;}		//temp.link가 null이면 temp.link에 newNode를 대입하고 리턴
		}
		head = new ListNode(data); //temp가 null이면 head라는 뜻이니 head에 바로 저장
		
		
		/**temp 안쓰고 해본 버전 근데 이러면 첫줄 newNode 초기화 한게 의미 없다.
		newNode = head;
		while(newNode!= null) {
			if(newNode.link!=null) {newNode = newNode.link;}
			else {newNode.link = new ListNode(data); return;} 
		}
		head = new ListNode(data);*/
		
	}
	
	
	public void deleteLastNode() {
		ListNode pre, temp;
		//
		//temp == null 수정 및 처음에 조건 거는 것도 맘에안듬
		/**temp = this.head;
		if(temp==null) {return;}
		else if(temp.link == null ) {head = null; return;}
		
		while(temp != null) {		
			pre = temp;
			temp = temp.link;		
			if(temp.link == null ) {				
				temp = null;
				pre.link = null;
				return;
			}
		}*/
		// 위 에 만든 코드 에서 temp ==null !=로 바꾸고 좀더 보기 좋게 수정*	
		/*
		temp = head;
		pre = null;
		while(temp != null) {		
			if (temp.link != null) {pre = temp;temp = temp.link;} //temp.link가 null이 아니면 pre에 temp,temp에 temp.link대입
			else {														//temp.link가 null이면 실행되는 else
				if(temp == head) {head = null;return;} // temp가 head라면 head를 삭제
				else {pre.link = null;return;}					 //	 temp가 head가 아니라면 pre.link를 삭제
			}
		}*/
		//최종
		temp = head;
		pre = null;
		while(temp.link != null) {	
			   pre = temp;	
			   temp = temp.link; //temp.link가 null이 아니면 pre에 temp,temp에 temp.link대입
			};
			if(temp == head) {head = null;return;} // temp가 head라면 head를 삭제 메소드 종료
			pre.link = null;										//	 temp가 head가 아니라면 pre.link를 삭제
		
		 //
	}
	
	public ListNode searchNode(String data) {
		ListNode temp = this.head;	//head값 temp에 대입
		//
		while(temp != null) {	//	temp가 null이 될 때까지 루프 진행
			if(temp.getData().equals(data)) {break;} //parameter랑 같은 값 찾으면 루프 종료
			else{temp = temp.link;} //값이 다르면 다음 link 대입
		}
		return temp;	//temp의 끝까지 가도 같은 값이 없으면 null리턴, 찾으면 찾은 값 리턴
	
		//
	}
	
	public void reverseList() {
		ListNode next = head; // 계속 link따라 진행
		ListNode current = null; //현재 값
		ListNode pre = null;	  //전에 값	
		
		//최종버전 처음에 이렇게 하려다 서순이 문제가 되서 실패했었다. pre에 current를 보관했다가 다시 current.link에 거는게 포인트
		while(next != null) {
			pre = current; 		 //pre 순서 		  n-7-5-3
			current = next;		//current 순서  7-5-3-1
			next = next.link;	//next 순서		  5-3-1-n
			current.link = pre;//1.link =null, 3.link = 5, 5.link = 7, 7.link = null 
			
		}
		head = current;

		
		
		/**	next ==null 을 next != 로 전부 개선  
		while(true) {//head가 null이 될 때까지 루프 안에 2개의 루프가 더있다.
			
			while(next != null) {	//head에 끝 값까지 루프 head의 끝값을 계속 pre에 저장해주고 끝값을 지운다.
				if(next.link != null) {
					next = next.link;
				}else {
					pre = next; //끝 값을 찾으면 pre에 저장
					deleteLastNode();								//끝 값 삭제
					break;												//현재 루프 종료
				}
			}								//끝값 찾는 루프 종료
			
			next = current;											//next에 current 저장
			if(next != null) {
				while(next != null) {								//insertLastNode 참고해서 만듬
					if(next.link!=null) {next = next.link;}//next(current).link가 null이 아니면 다음 link 대입
					else {next.link = pre; break;}			//next(current).link가 null이면 next(current).link에 pre(head의 끝값)대입
				}
			}else {current = pre;}//next(current)가 null이면 current에 pre(head의 끝값)대입
			
			if (head != null) {next = head;}				//head가 null이 아니면 next에 다시 head 대입
			else{	break;}												//head가 null이면 전체 while 종료
		}
		head = current;				//head가 null이 되서 전체 while 빠져나오면 head에 새롭게 만든 current 저장
		*/	
		/**next == null이 거슬려서 보류 리버스 기능은 작동함
		while(true) {//head가 null이 될 때까지 루프 안에 2개의 루프가 더있다.
			
			while(next != null) {	//head에 끝 값까지 루프
				if(next.link == null) {
					pre = new ListNode(next.getData()); //끝 값을 찾으면 pre에 저장
					deleteLastNode();								//끝 값 삭제
					break;												
				}
				next = next.link;
			}
			next = current;			//next에 current 저장
			while(next != null) {	//insertlastnode 참고해서 만듬
				if(next.link==null) {next.link = pre; break;}
				next = next.link;
			}if(next ==null) {current = new ListNode(pre.getData());}
			next = head;				//next에 head 저장
			if (next ==null) {		//head가 null이면 전체 while 종료
				break;
			}
		}
		head = current;				//기존 head에 새롭게 만든 current 저장*/
	}
	public void printList() {
		ListNode temp = this.head;
		System.out.printf("L=(");
		while(temp != null) {
			System.out.printf(temp.getData());
			temp = temp.link;
			if(temp != null) {
				System.out.printf(",");
			}
		}
		System.out.println(")");
	}
	
	
}
