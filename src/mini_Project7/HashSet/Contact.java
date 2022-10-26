package mini_Project7.HashSet;

public class Contact {
protected String name, number,index,email,birth,group;
	Contact() {	}
	
	public Contact(String name,String number,String index,String email,String birth,String group){
		this.name = name;
		this.number = number;
		this.index = index;
		this.email = email;
		this.birth = birth;
		this.group = group;
	}
	
	public void printinfo() {
		System.out.println("이름: "+name);
		System.out.println("전화번호: "+number);
		System.out.println("생일: "+birth);
		System.out.println("주소: "+index);
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
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
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
}
