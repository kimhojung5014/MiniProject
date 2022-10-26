package finalDeleteVersion;

import java.util.Scanner;


public class SmartPhoneMain {
	
	public static void main(String[] args) {
		
		 SmartPhone smartPhone = new SmartPhone();
		 Scanner scanner = new Scanner(System.in);
		
			while(true) {
		 	printMenu();
		 	String selectTrim = scanner.nextLine();
		 	String select = selectTrim;
		    if(select.equals("1")) {
		    System.out.println("====정보입력=====");
			for(int i=0;i<10;i++) {
			smartPhone.addContact(smartPhone.inputContactData(i));
			} 					
		    }
		    else if(select.equals("2")) {
			smartPhone.printAll();
			}
		 	else if(select.equals("3")) {
		 	smartPhone.searchContact(smartPhone.cheakSpace("찾을 이름검색: "));
		 	}	 	
		 	else if(select.equals("4"))	{ 
	 		smartPhone.deleteContact(smartPhone.cheakSpace("삭제할 이름 검색: "));
		 	}	
		 	else if(select.equals("5")) {
		 		
			smartPhone.deleteContact1(smartPhone.cheakSpace("삭제할 이름검색:")); 	
		 	}
		 	else if(select.equals("6")) {
			System.out.println("저장 정보 삭제");
			smartPhone.clearAll();
			}
		 	else if(select.equals("7")) {
		 	smartPhone.all();
		 	}
		}
	}
	private static void printMenu() {
		
			System.out.println("Contact-----------------");
			System.out.println("1.연락처 등록");	
			System.out.println("2.모든 연락처 출력");
			System.out.println("3.연락처 검색");
			System.out.println("4.연락처 삭제 쌤 버전");
			System.out.println("5.연락처 삭제 내 버전");
			System.out.println("6.저장 정보 삭제");
			System.out.println("7.현재 배열 값");
			System.out.println("------------------------");
			System.out.print("선택>");
		
	}

}
