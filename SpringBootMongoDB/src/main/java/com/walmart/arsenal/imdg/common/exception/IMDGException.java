//package com.walmart.arsenal.imdg.common.exception;
//
//import org.apache.commons.lang3.exception.ExceptionUtils;
//import org.springframework.stereotype.Component;
//
//import com.walmart.arsenal.ms.spotlight.IArsenalException;
//
///**
// * <h1>IMDGClientException</h1>
// * <p>
// * This is a custom Exception class.
// * </p>
// * 
// * @version 0.1
// * @since 30 August,2017
// * */
//@Component
//public final class IMDGException extends RuntimeException implements
//		IArsenalException {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 8501937228628233799L;
//
//	/**
//	 * The Constant NP_EXCEPTION_CODE.
//	 */
//	private static final String NP_EXCEPTION_CODE = "ARS.IMDG.UCR.101";
//
//	/**
//	 * The Constant UNDEFINE_EXCEPTION_CODE.
//	 */
//	private static final String UNDEFINED_EXCEPTION_CODE = "ARS.IMDG.UCR.102";
//
//	/**
//	 * The Constant ILLEGAL_ARGUMENT_EXCEPTION_CODE.
//	 */
//	private static final String ILLEGAL_ARGUMENT_EXCEPTION_CODE = "ARS.IMDG.RCR.103";
//
//	/**
//	 * The Constant HTTP_MEDIA_TYPE_NOT_SUPPORTED_EXCEPTION_CODE.
//	 */
//	private static final String JOB_EXCEUTION_EXCEPTION = "ARS.IMDG.RCR.104";
//
//	/**
//	 * Instantiates a new gets the associate exception.
//	 */
//	public IMDGException() {
//		super();
//	}
//
//	/**
//	 * Instantiates a new gets the associate exception.
//	 *
//	 * @param message
//	 *            the message
//	 * @param cause
//	 *            the cause
//	 */
//	public IMDGException(String message, Throwable cause) {
//		super(message, cause);
//	}
//
//	/**
//	 * Instantiates a new associate exception.
//	 *
//	 * @param cause
//	 *            the cause
//	 */
//	public IMDGException(Throwable cause) {
//		super(cause);
//	}
//
//	/**
//	 * returns the error code
//	 *
//	 * @param throwable
//	 *            the throwable
//	 * @return the error code
//	 */
//	@Override
//	public String getErrorCode(Throwable throwable) {
//		Throwable exception = (ExceptionUtils.getRootCause(throwable) == null) ? throwable
//				: ExceptionUtils.getRootCause(throwable);
//		String errorCode;
//		if (exception instanceof NullPointerException) {
//			errorCode = NP_EXCEPTION_CODE;
//		} else if (exception instanceof IllegalArgumentException) {
//			errorCode = ILLEGAL_ARGUMENT_EXCEPTION_CODE;
//		} else {
//			errorCode = UNDEFINED_EXCEPTION_CODE;
//		}
//		return errorCode;
//	}
//
//	/**
//	 * returns the error description
//	 *
//	 * @param throwable
//	 *            the throwable
//	 * @return the error description
//	 */
//	@Override
//	public String getErrorDescription(Throwable throwable) {
//
//		Throwable exception = (ExceptionUtils.getRootCause(throwable) == null) ? throwable
//				: ExceptionUtils.getRootCause(throwable);
//		String errorDescription;
//		if (exception instanceof NullPointerException) {
//			errorDescription = ExceptionUtils.getMessage(exception);
//		} else if (exception instanceof IllegalArgumentException) {
//			errorDescription = ExceptionUtils.getMessage(exception);
//		} else {
//			errorDescription = ExceptionUtils.getMessage(exception);
//		}
//		return errorDescription;
//	}
//
//}
