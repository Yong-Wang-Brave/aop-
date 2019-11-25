package all.aa;

import lombok.Data;

@Data
public class Student {
	
	int age;
	String name;

	public int getAge() {
		return age;
	}
	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	private Student() {

	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
