package mini_Project4;

import java.util.Scanner;

public class SmartPhone{
	private Contact[] contacts;
	private Scanner scanner;
	private int countOfContact = 0;
	
	SmartPhone(){
		contacts = new Contact[10];
		scanner = new Scanner(System.in);
	}
	
	public Contact inputCompanyData() {
		   	
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
			
			System.out.print("회사이름: ");
			String companyName = scanner.next();
			
			System.out.print("부서이름: ");
			String departmentName = scanner.next();
			
			System.out.print("직급: ");
			String position = scanner.next();
			
			return new CompanyContact(name, number, index, email, birth, group, companyName, departmentName, position);
	}
	
	public Contact inputCustomerData() {
	   	
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
		
		System.out.print("거래처이름: ");
		String accountName = scanner.next();
		
		System.out.print("품목이름: ");
		String itemName = scanner.next();
		
		System.out.print("직급: ");
		String position = scanner.next();
		
		return new CustomerContact(name, number, index, email, birth, group, accountName, itemName, position);
	}
	
	public void addContact(Contact contact) {
		contacts[countOfContact] = contact;
		countOfContact++;
		System.out.println("데이터가 저장되었습니다."+(countOfContact));
		System.out.println("------------------------");
	}
	
	public void printContact(Contact contact){
		if(contact instanceof CustomerContact) {
			CustomerContact customerContact = (CustomerContact)contact;
			customerContact.showData();
		}else {
			CompanyContact companyContact = (CompanyContact)contact;
			companyContact.showData();
		}
		
		System.out.println("------------------------");
	}
	
	public void printAll() {
		boolean searchName = false;
		System.out.println("===연락처 출력===");
		
		for(int i = 0;i<countOfContact;i++){
			printContact(contacts[i]);
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
