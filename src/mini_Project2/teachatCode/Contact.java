package mini_Project2.teachatCode;

public class Contact {
private String name, number,address,email,birth,group;

	
	Contact() {	}
	
	Contact(String name,String number,String address,String email,String birth,String group){
		this.name = name;
		this.number = number;
		this.address = address;
		this.email = email;
		this.birth = birth;
		this.group = group;
	}
	
	public void printinfo() {
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+number);
		System.out.println("생일: "+birth);
		System.out.println("주소: "+address);
		System.out.println("이메일: "+email);
		System.out.println("그룹: "+group);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getIndex() {
		return address;
	}

	public void setIndex(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	@Override
		public String toString() {
			return name;
		}
}
