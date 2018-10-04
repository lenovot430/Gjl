package cn.hl.exception;

/**
 * 自定义异常类
 * @author Gjl
 *
 */
public class MeetException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//储存异常消息
	private String message;

	/**
	 * 带参构造，设置消息的内容
	 * @param message
	 */
	public MeetException(String message) {
		super(message);
		System.out.println(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MeetException() {
		super();
	}


}
