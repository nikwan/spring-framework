package niks.poc.spring.scope.demo.messageresource;

public class MessageCode {
	
	int intCode;
	int extCode;
	
	String msg;

	public int getIntCode() {
		return intCode;
	}

	public void setIntCode(int intCode) {
		this.intCode = intCode;
	}

	public int getExtCode() {
		return extCode;
	}

	public void setExtCode(int extCode) {
		this.extCode = extCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public MessageCode(int intCode, int extCode, String msg) {
		super();
		this.intCode = intCode;
		this.extCode = extCode;
		this.msg = msg;
	}
	
	

}
