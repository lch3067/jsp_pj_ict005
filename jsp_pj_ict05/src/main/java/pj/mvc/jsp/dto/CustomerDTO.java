package pj.mvc.jsp.dto;

//DB와 연동하기 위해서 밑에 util.Date 보다 sql.Date을 쓴다. 마찬가지로 Timestamp도 마찬가지이다.
import java.sql.Timestamp;
import java.sql.Date;

// DTO(Data Transfer Object) = VO(Value Object)
public class CustomerDTO {

	// 맴버 변수
	private String user_id;
	private String user_password;
	private String user_name;
	private Date user_birthday;
	private String user_address;
	private String user_hp;
	private String user_email;
	private Timestamp user_regdate;

	
	// 디폴트 생성자
	public CustomerDTO() {}
	
	// 매개변수 생성자
	public CustomerDTO(String user_id, String user_password, String user_name, Date user_birthday, String user_address,
			String user_hp, String user_email) {
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_birthday = user_birthday;
		this.user_address = user_address;
		this.user_hp = user_hp;
		this.user_email = user_email;
	}

	//Getter, Setter
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Date getUser_birthday() {
		return user_birthday;
	}

	public void setUser_birthday(Date user_birthday) {
		this.user_birthday = user_birthday;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_hp() {
		return user_hp;
	}

	public void setUser_hp(String user_hp) {
		this.user_hp = user_hp;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public Timestamp getUser_regdate() {
		return user_regdate;
	}

	public void setUser_regdate(Timestamp user_regdate) {
		this.user_regdate = user_regdate;
	}

	//toString()
	@Override
	public String toString() {
		return "CustomerDTO [user_id=" + user_id + ", user_password=" + user_password + ", user_name=" + user_name
				+ ", user_birthday=" + user_birthday + ", user_address=" + user_address + ", user_hp=" + user_hp
				+ ", user_email=" + user_email + ", user_regdate=" + user_regdate + "]";
	}
	
}
