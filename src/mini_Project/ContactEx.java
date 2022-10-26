package mini_Project;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactEx {

	static Scanner scanner = new Scanner(System.in);
	static ArrayList<Contact>contacts = new	ArrayList<Contact>();
	
	public static void playloof() { //처음 실행 메소드
		
		while(true) {
			System.out.println("---------------------------------------------------------");	
			System.out.println("1.연락처저장 | 2.출력 | 3.검색 | 4.연락처 수정 | 5.삭제| 6.종료");
			System.out.println("---------------------------------------------------------");
			System.out.println("선택>");
			
			int menu = scanner.nextInt();
			
			switch(menu) {
			case 1:save();break;
			case 2:print();break;
			case 3:search();break;
			case 4:edit();break;
			case 5:remove();break;
			case 6:exit();return ;
			default : System.out.println("다시 입력해주세요");
			}//스위치
			
		}//와일
		
	}

	private static void save() {
		
		System.out.println("연락처 저장을 선택하셨습니다");
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
		Contact con = new Contact(name, number, index, email, birth, group);
		contacts.add(con);
		System.out.println("연락처가 저장되었습니다.");
	}
	
	private static void print() {
		System.out.println("====저장된 연락처 출력====");
		for(int i = 0;i<contacts.size();i++){
			contacts.get(i).printinfo();
			System.out.println("---------------------------------------------------------");
		}
	}


	private static void search() {
		System.out.println("====연락처 검색====");
		System.out.print("찾을 이름 검색: ");
		String name = scanner.next();
		for(int i = 0;i<contacts.size();i++){
			if(contacts.get(i).getName().equals(name)) {
				contacts.get(i).printinfo();
				return;
			}
		}
		System.out.println("찾는 정보가 없습니다.");
	}
	
	private static void edit() {
		System.out.println("====연락처 검색====");
		System.out.print("찾을 이름 검색: ");
		String name = scanner.next();
		for(int i = 0;i<contacts.size();i++){
			if(contacts.get(i).getName().equals(name)) {
				System.out.println("기존 이름: "+contacts.get(i).getName());
				
				System.out.print("변경할 이름 입력:");
				String newname = scanner.next();
				
				contacts.get(i).setName(newname);;
				System.out.println("이름을 "+newname+"로 변경하였습니다.");
				contacts.get(i).printinfo();
				
				return;
			}
		}
		System.out.println("찾는 이름이 없습니다.");
		
	}
	
	private static void remove() {
		System.out.println("====연락처 검색====");
		System.out.print("찾을 이름 검색: ");
		String name = scanner.next();
		for(int i = 0;i<contacts.size();i++){
			if(contacts.get(i).getName().equals(name)) {
				contacts.remove(i);
				System.out.println("연락처를 삭제하였습니다.");
				return;
			}
		}
		System.out.println("찾는 정보가 없습니다.");		
	}


	private static void exit() {
		System.out.println("프로그램 종료");
	}

	public static void main(String[] args) {
				
		Contact c = new Contact("김호중", "010-5375-4131", "서울 마장동", "gytrt0130", "1월30일", "친구");
		c.printinfo();
		c.setGroup("가족");
		System.out.println();
		c.printinfo();
		
		playloof();
		
		
	}
		
	}