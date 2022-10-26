package mini_Project2.myversion;

import java.util.Scanner;


public class SmartPhoneMain {

	public static void main(String[] args) {
		SmartPhone smartPhone = new SmartPhone();
		boolean loof = true;
		while(loof) {
			
		printMenu();
		Scanner scanner = new Scanner(System.in);
		int select = scanner.nextInt();
		
		 switch(select) {
			 case 1: smartPhone.inputContactData(); 
			 		break;
			 
			 case 2:smartPhone.printAll();
			 		break;
			 
			 case 3:System.out.print("찾을 이름검색: ");
				 	String search = scanner.next();
				 	smartPhone.searchContact(search);
				 	break;
				 
			 case 4:System.out.print("삭제할 연락처 이름 검색: ");
				 	String delete = scanner.next();
			 		smartPhone.deleteContact(delete);
			 		break;
			 
			 case 5:System.out.print("수정할 이름검색: ");
				 	String edit = scanner.next();
				 	
				 	System.out.println("바꿀 정보 입력");
				 	
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
			 		smartPhone.editContact(edit,new Contact(name, number, index, email, birth, group));
				    break;
			 
			 case 6:System.out.println("종료");
			 		loof = false;
			 		scanner.close();
		 }
		}
	}

	private static void printMenu() {
		
			System.out.println("Contact-----------------");
			System.out.println("1.연락처 등록");
			System.out.println("2.모든 연락처 출력");
			System.out.println("3.연락처 검색");
			System.out.println("4.연락처 삭제");
			System.out.println("5.연락처 수정");
			System.out.println("6.프로그램 종료");
			System.out.println("------------------------");
			System.out.print("선택>");
		
	}

}
