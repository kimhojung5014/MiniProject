package mini_Project2.teacharver;

import java.util.Scanner;

public class SmartPhoneMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SmartPhone smartPhone = new SmartPhone();
		boolean loof = true;
		while(loof) {
			
		printMenu();
		int select = scanner.nextInt();
		
		 switch(select) {
			 case 1:System.out.print("#저장할 데이터 수를 입력해주세요: ");
					int su = scanner.nextInt();
					System.out.println("데이터 "+su+"개를 입력합니다");
					
					for(int i = 0; i< su ; i++) {			 	
				 	smartPhone.addContact(smartPhone.inputContactData());
					}
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
				 	
			 		smartPhone.editContact(edit,smartPhone.inputContactData());
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
