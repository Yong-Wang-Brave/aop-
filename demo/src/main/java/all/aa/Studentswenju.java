package all.aa;

import lombok.Data;

@Data
public class Studentswenju {
	
	String wjage;
	String wjname;
	public String getAge() {
		return wjage;
	}
	public Studentswenju(String wjage, String wjname) {
		super();
		this.wjage = wjage;
		this.wjname = wjname;
	}
	public void setAge(String wjage) {
		this.wjage = wjage;
	}
	public String getName() {
		return wjname;
	}
	public void setName(String wjname) {
		this.wjname = wjname;
	}

}
