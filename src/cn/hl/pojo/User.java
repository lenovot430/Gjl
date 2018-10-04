package cn.hl.pojo;

public class User {

	private int userId;
	private String userName;
	private String account;
	private String pwd;
	private int deptId;
	private String tel;
	private String role;
	private int state;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userName, String account, String pwd, int deptId, String tel, String role,
			int state) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.account = account;
		this.pwd = pwd;
		this.deptId = deptId;
		this.tel = tel;
		this.role = role;
		this.state = state;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", account=" + account + ", pwd=" + pwd
				+ ", deptId=" + deptId + ", tel=" + tel + ", role=" + role + ", state=" + state + "]";
	}
}
