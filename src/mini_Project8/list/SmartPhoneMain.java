package mini_Project8.list;

import java.io.File;
import java.util.Scanner;

public class SmartPhoneMain {
	
	public static void main(String[] args) throws Exception{
		
		 SmartPhone smartPhone = new SmartPhone();
		 Scanner scanner = new Scanner(System.in);
		
			while(true) {
		 	printMenu();
		 	String select = scanner.nextLine();
		    if(select.equals("1")) {
			     select = smartPhone.cheakSpace("1.회사 2.거래처 : ");
				 if(select.equals("1")| select.equals("2")) {
				 smartPhone.addContact(smartPhone.inputContactData(select));
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
		 		 select = smartPhone.cheakSpace("1.회사 2.거래처 : ");
				 if(select.equals("1")| select.equals("2")) {
					smartPhone.editContact(smartPhone.cheakSpace("수정할 이름 검색: "),smartPhone.inputContactData(select));
					}
		 	}
		 	else if (select.equals("6")) {
		 		smartPhone.fileSave();
				
			}
		 	else if (select.equals("7")) {
		 		smartPhone.fileLoad();
			}
		 	else if(select.equals("8")) {
			System.out.println("종료");scanner.close();return;
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
			System.out.println("6.연락처 파일 저장");
			System.out.println("7.연락처 파일 로드");
			System.out.println("8.프로그램 종료");
			System.out.println("------------------------");
			System.out.print("선택>");
		
	}

}
