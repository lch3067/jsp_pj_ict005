package pj.mvc.jsp.dto;


import java.sql.Date;

import oracle.sql.CLOB;

public class BoardDTO {

	public int b_num;
	public String b_title;
	public String b_content;
	public String b_writer;
	public String b_password;
	public int b_readCnt;
	public Date b_regDate;

	public BoardDTO() {}

	public BoardDTO(int b_num, String b_title, String b_content, String b_writer, String b_password, int b_readCnt,
			Date b_regDate) {
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_writer = b_writer;
		this.b_password = b_password;
		this.b_readCnt = b_readCnt;
		this.b_regDate = b_regDate;
	}
	
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public String getB_password() {
		return b_password;
	}
	public void setB_password(String b_password) {
		this.b_password = b_password;
	}
	public int getB_readCnt() {
		return b_readCnt;
	}
	public void setB_readCnt(int b_readCnt) {
		this.b_readCnt = b_readCnt;
	}
	public Date getB_RegDate() {
		return b_regDate;
	}
	public void setB_RegDate(Date regDate) {
		this.b_regDate = regDate;
	}

	@Override
	public String toString() {
		return "BoardDTO [b_num=" + b_num + ", b_title=" + b_title + ", b_content=" + b_content + ", b_writer="
				+ b_writer + ", b_password=" + b_password + ", b_readCnt=" + b_readCnt + ", b_regDate=" + b_regDate + "]";
	}
	
}

