package cn.hl.pojo;

public class Sys_User {

	private int id;
	private String name;
	private boolean gender;
	private String tel;
	
	public Sys_User() {
		// TODO Auto-generated constructor stub
	}

	public Sys_User(int id, String name, boolean gender, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", tel=" + tel + "]";
	}
	
}
