package mini_Project2.teachatCode;

import java.util.Scanner;

public class SmartPhoneMain {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SmartPhone smartPhone = new SmartPhone();
		
		
		System.out.println("#데이터 2개를 입력합니다.");
		for(int i=0;i<2;i++) {
			smartPhone.addContact(smartPhone.inputContactData());
		}
		
		while(true) {
			
		printMenu();
		String choiceMenu = scanner.next();
		
		 if(choiceMenu.equals("1")) {
			  smartPhone.inputContactData(); 
		 }else if(choiceMenu.equals("2")){
		 	smartPhone.printAll();
		 }else if(choiceMenu.equals("3")) {		 
			System.out.print("찾을 이름검색: ");
			smartPhone.searchContact(scanner.next());
		 }else if(choiceMenu.equals("4")) {
			 System.out.print("삭제할 연락처 이름 검색: ");
		 	smartPhone.deleteContact(scanner.next());
		 }else if(choiceMenu.equals("5")) {
			  System.out.print("수정할 이름검색: ");
			  String edit = scanner.next();
			  System.out.println("바꿀 정보 입력");
			  smartPhone.editContact(edit,smartPhone.inputContactData());
		 }else if(choiceMenu.equals("6")) {
			System.out.println("종료");
			return;
		 }else {
			System.out.println("잘못된 메뉴입니다.");
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
