package mini_Project2.teacharver;

import java.util.Scanner;

public class SmartPhone {
	
	Contact[] contacts = new Contact[10];
	int countOfContact = 0;
	Scanner scanner = new Scanner(System.in);
	
	
	public Contact inputContactData() {
		
			
			System.out.print("이름: ");
			String name = scanner.next();
			
			System.out.print("번호: ");
			String number = scanner.next();
			
			System.out.print("주소: ");
			String index = scanner.next();
			
			System.out.print("이메일: ");
			String email = scanner.next();
			
			System.out.print("생일: ");
			String birth = scanner.next();
			
			System.out.print("그룹: ");
			String group = scanner.next();
			
			return  new Contact(name, number, index, email, birth, group);	
	}
	
	public void addContact(Contact contact) {
		contacts[countOfContact] = contact;
		countOfContact++;
		System.out.println("데이터가 저장되었습니다."+(countOfContact));
		System.out.println("------------------------");
	}
	
	public void printContact(Contact contact){
		contact.printinfo();
	}
	
	public void printAll() {
		boolean searchName = false;
		System.out.println("===연락처 출력===");
		
		for(int i = 0;i<countOfContact;i++){
			printContact(contacts[i]);
			System.out.println("------------------------");
			searchName = true;
		}
			if(searchName == false){
			System.out.println("찾는 연락처가 없습니다.");
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
	
	public void deleteContact(String name){
		
		for(int i = 0;i<countOfContact;i++){			
			if(contacts[i].getName().contentEquals(name)) {
				for(int j = i; j<countOfContact;j++) {
					contacts[j] = contacts[j+1];
				}
				countOfContact--;
				System.out.println("삭제되었습니다.");
				return;
			}
			
		}
					
	}
	
	public void editContact(String name,Contact newContact) {
		
		for(int i = 0;i<countOfContact;i++) {
			if(contacts[i].getName().contentEquals(name)) {
				contacts[i] = newContact;
				System.out.println("수정되었습니다.");
				return;
			}
		  
		}System.out.println("찾는 연락처가 없습니다.");
	}
	
	
}
