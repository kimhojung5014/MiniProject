package mini_Project3;

import java.util.Scanner;
//else if 버전 

public class SmartPhoneMain2 {
	
	public static void main(String[] args) {
		
		 SmartPhone smartPhone = new SmartPhone();
		 Scanner scanner = new Scanner(System.in);
		
		
			while(true) {
		 	printMenu();
		 	int select = scanner.nextInt();
		
		    if(select==1) {
			System.out.println("====회사정보입력=====");
		 	smartPhone.addContact(smartPhone.inputContactData(select));
		    }
		 	else if(select==2) { 		
			System.out.println("====거래처정보입력=====");
		 	smartPhone.addContact(smartPhone.inputContactData(select));
		 		
		 	}	
		 	else if(select==3) {
			smartPhone.printAll();
			}
		 	else if(select==4) {
			System.out.print("찾을 이름검색: ");
		 	String search = scanner.next();
		 	smartPhone.searchContact(search);
		 	}	 	
		 	else if(select==5)	{ 
			System.out.print("삭제할 연락처 이름 검색: ");
		 	String delete = scanner.next();
	 		smartPhone.deleteContact(delete);
		 	}	
		 	else if(select==6) {
			System.out.println("1.회사 | 2.거래처 ");
		 	System.out.print("선택>");
		 	int selectKind = scanner.nextInt();
				 switch(selectKind) {
				 	case 1:	System.out.print("수정할 이름검색: ");
						 	String editName = scanner.next();
						 	System.out.println("====수정할 데이터 입력=====");
				 			smartPhone.editContact(editName,smartPhone.inputContactData(selectKind));
				 			break;
				 	case 2:	System.out.print("수정할 이름검색: ");
						 	String editName2 = scanner.next();
						 	System.out.println("====수정할 데이터 입력=====");
				 			smartPhone.editContact(editName2, smartPhone.inputContactData(selectKind));
				 			break;
				 	default : System.out.println("다시 입력해주세요");
				 	}
		 	}
		 	else if(select==7) {
			System.out.println("종료");scanner.close();return;
			}
		}
	}
	private static void printMenu() {
		
			System.out.println("Contact-----------------");
			System.out.println("1.연락처 등록(회사)");
			System.out.println("2.연락처 등록(거래처)");			
			System.out.println("3.모든 연락처 출력");
			System.out.println("4.연락처 검색");
			System.out.println("5.연락처 삭제");
			System.out.println("6.연락처 수정");
			System.out.println("7.프로그램 종료");
			System.out.println("------------------------");
			System.out.print("선택>");
		
	}

}
