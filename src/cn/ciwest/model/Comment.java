package cn.ciwest.model;

public class Comment {
	private int number;
	private int blognumber;
	private String username;
	private String content;
	private String time;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getBlognumber() {
		return blognumber;
	}

	public void setBlognumber(int blognumber) {
		this.blognumber = blognumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
