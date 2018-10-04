package cn.hl.exception;

/**
 * �Զ����쳣��
 * @author Gjl
 *
 */
public class MeetException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//�����쳣��Ϣ
	private String message;

	/**
	 * ���ι��죬������Ϣ������
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
