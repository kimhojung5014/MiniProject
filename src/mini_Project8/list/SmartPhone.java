package mini_Project8.list;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartPhone{
	private  Contact[] contacts = new Contact[10];
	private Scanner scanner = new Scanner(System.in);
	private int countOfContact=0;
	private List<Contact>list = new ArrayList<Contact>();
	
	SmartPhone(){
		
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
				for(int i=0;i<countOfContact;i++) {
					if(contacts[i].getNumber().equals(number)) {
						System.out.println("중복된 번호가 있습니다. 다시 입력하세요");
						cheak=false;
						break;
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
		contacts[countOfContact] = contact;
		countOfContact++;
		System.out.println("데이터가 저장되었습니다."+(countOfContact));
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
		for(int i=0;i<list.size();i++) {
			printContact(list.get(i));
		}
		
//		if(countOfContact == 0){System.out.println("찾는 연락처가 없습니다."); return;}
		
		System.out.println("===연락처 출력===");
		for(int i = 0;i<countOfContact;i++){
			printContact(contacts[i]);
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
				for(int j =i; j<countOfContact-1;j++) {
					contacts[j] = contacts[j+1];
				}
				contacts[countOfContact-1]=null;
				countOfContact--;
				System.out.println("삭제되었습니다.");
				return;
			}			
		}System.out.println("찾는 연락처가 없습니다.");			
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
	
	public void fileSave() throws Exception {

		File file = new File("C:/Temp/number.txt");
		if(file.exists() == false) {file.createNewFile();}
		FileOutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		for(int i=0;i<countOfContact;i++) {
			oos.writeObject(contacts[i]);
		}
		System.out.println("저장되었습니다.");
		
		os.flush();os.close();oos.flush();oos.close();
	}
	
	public void fileLoad() throws Exception{
		
		File file = new File("C:/Temp/number.txt");
		if(file.exists() == false) {System.out.println("불러올 데이터가 없습니다.");}
		
		FileInputStream fi = new FileInputStream(file);
		ObjectInputStream oi = new ObjectInputStream(fi);
		list.add((Contact)oi.readObject());


		System.out.println("불러오기 완료");
		fi.close();oi.close();
		
	}
}
