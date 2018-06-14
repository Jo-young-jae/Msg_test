package kh.web.beans;

public class MessageDTO {
	private String name;
	private String msg;
	
	public MessageDTO() {
		super();
	}
	
	public MessageDTO(String name, String msg) {
		super();
		this.name = name;
		this.msg = msg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
