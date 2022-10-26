package mini_Project8.print;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.CharBuffer;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SmartPhone{
	private Contact[] contacts;
	private Scanner scanner;
	private int countOfContact;
	
	SmartPhone(){
		contacts = new Contact[10];
		scanner = new Scanner(System.in);
		countOfContact =0;
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
		if(countOfContact == 0){System.out.println("찾는 연락처가 없습니다."); return;}
		
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
		FileWriter os = new FileWriter(file);
		System.out.println("저장");
		for(int i=0;i<countOfContact;i++) {
			os.write("이름:"+contacts[i].getName());
			os.write("번호:"+contacts[i].getNumber());
			os.write("이메일:"+contacts[i].getEmail());
			os.write("주소:"+contacts[i].getIndex());
			os.write("생일:"+contacts[i].getBirth());
			os.write("그룹:"+contacts[i].getGroup()+"\r\n");
		}
		os.flush();os.close();
		
	}
	
	public void fileLoad() throws Exception {
		File file = new File("C:/Temp/number.txt");
		if(file.exists() == false) {System.out.println("불러올 데이터가 없습니다.");}
		FileReader fw = new FileReader(file);
		int readByteNo;
		char[] readBytes = new char[100];
		String data = "";
		while(true) {
			readByteNo = fw.read(readBytes);
			if(readByteNo==-1)break;
			data=new String(readBytes,0,readByteNo);
			System.out.println(data);
		}
		fw.close();

		
	}
}
