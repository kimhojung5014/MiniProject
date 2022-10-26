package mini_Project2.myversion;

import java.util.Scanner;


public class SmartPhone {
	
	Contact[] contact1 = new Contact[2];
	int countOfContact = 0;
	Scanner scanner = new Scanner(System.in);
	
	
	public void inputContactData() {
		System.out.print("#저장할 데이터 수를 입력해주세요: ");
		int su = scanner.nextInt();
		System.out.println("데이터 "+su+"개를 입력합니다");
		
		for(int i = 0; i< su ; i++) {
			
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
			
			Contact c = new Contact(name, number, index, email, birth, group);
			
			addContact(c);
			
			System.out.println("데이터가 저장되었습니다."+(i+1));
			System.out.println("------------------------");

		}
	}
	
	public void addContact(Contact contact) {
		for(int i = 0; i < contact1.length ; i++){
			if(contact1[i] == null) {
			contact1[i] = contact;
			return;
			}
		}
	}
	
	public void printContact(Contact contact){
		contact.printinfo();
	}
	
	public void printAll() {
		boolean searchName = false;
		System.out.println("===연락처 출력===");
		
		for(int i = 0;i<contact1.length;i++){
			if(contact1[i] != null) {
				printContact(contact1[i]);
				searchName = true;
				System.out.println("------------------------");
			}
		}if(searchName == false){
			System.out.println("찾는 연락처가 없습니다.");
		}			
	}
	
	
	public void searchContact(String name){
		for(int i = 0;i<contact1.length;i++) {
			if(contact1[i] != null) {
				if(contact1[i].getName().contentEquals(name)) {
					System.out.println("=====검색정보=====");
					printContact(contact1[i]);
					return;
					}
			}	
		}
		System.out.println("찾는 연락처가 없습니다.");
	}
	
	public void deleteContact(String name){
		boolean searchName = false;
		for(int i = 0;i<contact1.length;i++){
			if(contact1[i] != null) {
				if(contact1[i].getName().contentEquals(name)) {
					contact1[i] = null;				
					System.out.println("삭제되었습니다.");	
					searchName = true;
					}
			}
			//항목 삭제시 삭제된 배열 값 뒤에 있는 값들을 앞으로 당겨온다.
			if(contact1[i]	== null && i<9 && contact1[i+1] != null) {
				contact1[i] = contact1[i+1];
				contact1[i+1] = null;
			}
			//
		}
		if(searchName == false) {System.out.println("찾는 연락처가 없습니다.");}				
	}
	
	public void editContact(String name,Contact newContact) {
		
		for(int i = 0;i<contact1.length;i++) {
			if(contact1[i] != null) {
				if(contact1[i].getName().contentEquals(name)) {
					contact1[i] = newContact;
	
					System.out.println("이름이 "+newContact.getName()+"로 수정되었습니다.");
					return;
			}
		  }
		}System.out.println("찾는 연락처가 없습니다.");
	}
	
	
}
