package finalDeleteVersion;

import java.util.Scanner;

public class SmartPhone{
	private Contact[] contacts;
	private Scanner scanner;
	private int countOfContact;
	
	SmartPhone(){
		contacts = new Contact[10];
		scanner = new Scanner(System.in);
		countOfContact =0;
	}
	
	public String cheakSpace(String value) {
		
		while(true) {
			boolean cheak=true;
			System.out.print(value);
			String data = scanner.nextLine();
			for(int i=0;i<data.length();i++) {
				if(data.charAt(i)==' ') {
					System.out.println("공백이 포함되어있습니다. 다시 입력해주세요");
					cheak =false;
					break;
				}	
			}if(cheak==true)return data;
		}
	}
	
	
	
	public String cheakNumber(String value) {
			while(true) {
				boolean cheak=true;
				String number = cheakSpace(value);
				for(int i=0;i<countOfContact;i++) {
					if(contacts[i].getNumber().equals(number)) {
						System.out.println("중복된 번호가 있습니다. 다시 입력하세요");
						cheak=false;
						break;
					}
				}if(cheak==true)return number;
			}
		}
	
	public Contact inputContactData(int i) {	   	
		   
			return new Contact("n"+i, "n"+i, "n"+i, "n"+i, "n"+i, "n"+i);
	}

	public void addContact(Contact contact) {
		contacts[countOfContact] = contact;
		countOfContact++;
		System.out.println("데이터가 저장되었습니다."+(countOfContact));
		System.out.println("------------------------");
	}
	
	public void printContact(Contact contact){
		
		contact.printinfo();
//		System.out.println("------------------------");
	}
	
	public void printAll() {
		if(countOfContact == 0){System.out.println("찾는 연락처가 없습니다."); return;}
		
		System.out.println("===연락처 출력===");
		for(int i = 0;i<countOfContact;i++){
			printContact(contacts[i]);
		}				
	}
	
	
	public void searchContact(String name){
		for(int i = 0;i<countOfContact;i++) {
			if(contacts[i].getName().contentEquals(name)) {
				System.out.println("=====검색정보=====");
				printContact(contacts[i]);
				return;
				}				
		}
		System.out.println("찾는 연락처가 없습니다.");
	}
	//선생님 코드 수정 버전
	public void deleteContact(String name){
		
		for(int i = 0;i<countOfContact;i++){			
			if(contacts[i].getName().contentEquals(name)) {
				for(int j =i; j<countOfContact-1;j++) {
					contacts[j] = contacts[j+1];
				}
				contacts[countOfContact-1]=null;
				countOfContact--;
				return;
			}			
		}System.out.println("찾는 연락처가 없습니다.");			
	}	
	//선생님 삭제 코드 배열이 가득 차 있을 때 삭제하면  j+1이 배열 길이를 초과해서  java.lang.ArrayIndexOutOfBoundsException발생한다 
//	public void deleteContact(String name){
//		
//		for(int i = 0;i<countOfContact;i++){	
//			Contact contact = contacts[i];
//			if(contact.getName().contentEquals(name)) {
//				for(int j = i; j<countOfContact;j++) {
//					contacts[j] = contacts[j+1];
//				}
//				countOfContact--;
//				return;
//			}			
//		}				
//	}	
	//내가 처음 작성한  삭제 코드
	public void deleteContact1(String name){
		boolean searchName = false;
		for(int i = 0;i<countOfContact;i++){
			if(contacts[i] != null) {
				if(contacts[i].getName().contentEquals(name)) {
					contacts[i] = null;				
					System.out.println("삭제되었습니다.");	
					searchName = true;
					}
			}
			//항목 삭제시 삭제된 배열 값 뒤에 있는 값들을 앞으로 당겨온다.
			if(contacts[i]	== null && i<9 && contacts[i+1] != null) {
				contacts[i] = contacts[i+1];
				contacts[i+1] = null;
			}
			//
		}
		countOfContact--;
		if(searchName == false) {System.out.println("찾는 연락처가 없습니다.");}				
	}
	
	public void all() {
		for(int i=0;i<contacts.length;i++) {
			System.out.println("contacts["+i+"]:"+contacts[i]);
		}
	}
	
	public void clearAll() {
		
		for(int i = 0;i<contacts.length;i++) {
				contacts[i]=null;
			}countOfContact=0;
		  
		}
	
	
}
