package cn.hl.pojo;

public class Department {

	private int deptId;
	private String deptName;
	private String note;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(int deptId, String deptName, String note) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.note = note;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName + ", note=" + note + "]";
	}
}
