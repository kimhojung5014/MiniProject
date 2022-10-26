package mini_Project7.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SmartPhone{
	private HashMap<String,Contact> contacts;
	private Scanner scanner;
	
	SmartPhone(){
		contacts = new HashMap<String,Contact>();
		scanner = new Scanner(System.in);
	}
	
	
	public String cheakSpace(String value) {
		
		while(true) {
			boolean cheak=true;
			System.out.print(value);
			String data = scanner.nextLine().trim();
			if(data.length()==0) {
				System.out.println("입력 값이 없습니다.");
				cheak =false;			
			}
			for(int i=0;i<data.length();i++) {
				if(data.charAt(i)==' ') {
					System.out.println("공백이 포함되어있습니다. 다시 입력해주세요");
					cheak =false;
					break;
				}	
			}
			if(cheak==true)return data;
		}
	}
	
	public String cheakNumber(String value) {
			while(true) {
				boolean cheak=true;
				String number = cheakSpace(value);
				Set<Map.Entry<String, Contact>>set = contacts.entrySet();
				Iterator<Map.Entry<String, Contact>>iterator = set.iterator();
				while(iterator.hasNext()) {
						Map.Entry<String, Contact>entry =  iterator.next();
					
					if(entry.getKey().equals(number)){
						System.out.println("중복된 번호가 있습니다.");
					}
				}if(cheak==true)return number;
			}
		}
	
	public Contact inputContactData(String select) {
			
		
		String name =cheakSpace("이름: "); 
		
		String number =cheakNumber("번호: ");
		
		String address = cheakSpace("주소: ");
		
		String email = cheakSpace("이메일: ");
		
		String birth = cheakSpace("생일: ");
		
		String group = cheakSpace("그룹: ");
		
		if(select.equals("1")) {
			
			String companyName = cheakSpace("회사이름: ");
			String departmentName = cheakSpace("부서이름: ");
			String position = cheakSpace("직급: ");
			
			return new CompanyContact(name, number,address,email,birth,group,companyName,departmentName,position);
		}else{
				
			String customerName = cheakSpace("거래처이름: ");
			String itemName = cheakSpace("제품이름: ");
			String position = cheakSpace("직급: ");
			return new CustomerContact(name,number,address,email,birth,group,customerName,itemName,position);
		 }		
			
	}
	

	public void addContact(Contact contact) {
		contacts.put(contact.getNumber(), contact);
		System.out.println("데이터가 저장되었습니다."+contacts.size());
		System.out.println("------------------------");
	}
	
	public void printContact(Contact contact){
		if(contact instanceof CustomerContact) {
			CustomerContact customerContact = (CustomerContact)contact;
			customerContact.printinfo();
		}else {
			CompanyContact companyContact = (CompanyContact)contact;
			companyContact.printinfo();
		}
		
		System.out.println("------------------------");
	}
	
	public void printAll() {
		
		System.out.println("===연락처 출력===");
		Set<Map.Entry<String, Contact>>set = contacts.entrySet();
		Iterator<Map.Entry<String, Contact>>iterator = set.iterator();
		while(iterator.hasNext()) {
			printContact(iterator.next().getValue());
		}
	}
	
	
	public void searchContact(String name){
		Set<Map.Entry<String, Contact>>set = contacts.entrySet();
		Iterator<Map.Entry<String, Contact>>iterator = set.iterator();
		while(iterator.hasNext()) {
				Map.Entry<String, Contact>entry =  iterator.next();
			
			if(entry.getValue().getName().equals(name)){
				printContact(entry.getValue());
				return;
			}
		}	
		System.out.println("찾는 연락처가 없습니다.");
	}
	
	public void deleteContact(String name){
		
		Set<Map.Entry<String, Contact>>set = contacts.entrySet();
		Iterator<Map.Entry<String, Contact>>iterator = set.iterator();
		while(iterator.hasNext()) {
				Map.Entry<String, Contact>entry =  iterator.next();
			
			if(entry.getValue().getName().equals(name)){
				contacts.remove(entry.getKey());
				System.out.println("삭제되었습니다.");				
				return;
			}
		}
			System.out.println("찾는 연락처가 없습니다.");			
		
	}	
	
	
	public void editContact(String name,Contact newContact) {
		Set<Map.Entry<String, Contact>>set = contacts.entrySet();
		Iterator<Map.Entry<String, Contact>>iterator = set.iterator();
		while(iterator.hasNext()) {
				Map.Entry<String, Contact>entry =  iterator.next();
			
			if(entry.getValue().getName().equals(name)){
				contacts.remove(entry.getKey());
				contacts.put(newContact.getNumber(), newContact);
				System.out.println("수정되었습니다.");
				return;
			}
		}System.out.println("찾는 연락처가 없습니다.");
	}
}
