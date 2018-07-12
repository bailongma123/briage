package com.ande.bridge.web.exception;
/**
2018年5月23日上午10:24:09
@author chengzb
业务异常
 **/
public class BizzException extends Exception {
	private static final long serialVersionUID = -6289532201449196038L;
	  public BizzException() {
	        super();
	    }
	    public BizzException(String message) {
	        super(message);
	    }
	    public BizzException(Throwable e) {
	        super(e);
	    }
	    public BizzException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
