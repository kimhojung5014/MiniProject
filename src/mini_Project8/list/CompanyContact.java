package mini_Project8.list;

public class CompanyContact extends Contact{
	private String companyName,departmentName,position;
	
	 CompanyContact(){}
	 
	 public CompanyContact(String name,String number,String index,String email,String birth,String group,String companyName,String departmentName,String position) {
		super(name, number, index, email, birth, group);
		this.companyName = companyName;
		this.departmentName = departmentName;
		this.position = position;
	}
		
	
	@Override
	public void printinfo() {
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+number);
		System.out.println("생일: "+birth);
		System.out.println("주소: "+index);
		System.out.println("이메일: "+email);
		System.out.println("그룹: "+group);
		System.out.println("회사이름: "+companyName);
		System.out.println("부서이름: "+departmentName);
		System.out.println("직급: "+position);
	}
}
