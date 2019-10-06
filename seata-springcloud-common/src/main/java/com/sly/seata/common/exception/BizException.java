package com.sly.seata.common.exception;

public class BizException extends RuntimeException {
	public static final int BizException_Order = 1;
	public static final int BizException_Account = 2;
	public static final int BizException_Store = 3;
	public static final int BizException_StoreInfo = 4;
	
	private static final long serialVersionUID = 1L;
	/**
	 * 异常信息
	 */
	protected String msg;

	/**
	 * 具体异常码
	 */
	protected int code;
	
	public BizException(int code, String msgFormat, Object... args) {
		super(String.format(msgFormat, args));
		this.code = code;
		this.msg = String.format(msgFormat, args);
	}
	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizException(Throwable cause) {
		super(cause);
	}

	public BizException(String message) {
		super(message);
	}
	
	public BizException() {
		super();
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
