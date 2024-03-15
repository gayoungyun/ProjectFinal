package admin.controller;

public class MemberData {
	private int y_num;
	private String y_id;
	private String y_pwd;
	private String y_name;
	private String y_brith;
	private String y_tel;
	private int y_gender;
	private String y_gender1;


	private String y_add;
	
	public MemberData(int y_num, String y_id, String y_pwd, String y_name,String y_brith, String y_tel, int y_gender, String y_add) {
		this.y_num = y_num;
		this.y_id = y_id;
		this.y_pwd = y_pwd;
		this.y_name = y_name;
		this.y_brith = y_brith;
		this.y_tel = y_tel;
		if (y_gender == 0) {
			y_gender1 = "남자";
		} else {
			y_gender1 = "여자";
		}
		this.y_gender = y_gender;
		this.y_add = y_add;
	}

	public int getY_num() {
		return y_num;
	}

	public void setY_num(int y_num) {
		this.y_num = y_num;
	}

	public String getY_id() {
		return y_id;
	}

	public void setY_id(String y_id) {
		this.y_id = y_id;
	}

	public String getY_pwd() {
		return y_pwd;
	}

	public void setY_pwd(String y_pwd) {
		this.y_pwd = y_pwd;
	}

	public String getY_name() {
		return y_name;
	}

	public void setY_name(String y_name) {
		this.y_name = y_name;
	}

	public String getY_brith() {
		return y_brith;
	}

	public void setY_brith(String y_brith) {
		this.y_brith = y_brith;
	}

	public String getY_tel() {
		return y_tel;
	}

	public void setY_tel(String y_tel) {
		this.y_tel = y_tel;
	}

	public int getY_gender() {
		return y_gender;
	}

	public void setY_gender(int y_gender) {
		this.y_gender = y_gender;
	}

	public String getY_add() {
		return y_add;
	}

	public void setY_add(String y_add) {
		this.y_add = y_add;
	}

	public String getY_gender1() {
		return y_gender1;
	}

	public void setY_gender1(String y_gender1) {
		this.y_gender1 = y_gender1;
	}
}
