package demo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="admin")
public class Admin    implements Serializable,BaseModel {
	public Admin(String name, String sex) {
		super();
		this.name = name;
		this.sex = sex;
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	@XmlAttribute
	private String name="";
	
	@XmlAttribute
	private String sex="";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
