package com.infy.sim.utility;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.infy.sim.exception.ActiveSimException;
import com.infy.sim.exception.AddressNotFoundException;
import com.infy.sim.exception.InvalidAddressException;
import com.infy.sim.exception.InvalidCustomerDetailsException;
import com.infy.sim.exception.InvalidCustomerException;
import com.infy.sim.exception.InvalidCustomerIdException;
import com.infy.sim.exception.InvalidDateOfBirthException;
import com.infy.sim.exception.InvalidDateOfBirthFormat;
import com.infy.sim.exception.InvalidDetailsException;
import com.infy.sim.exception.InvalidEmailException;
import com.infy.sim.exception.InvalidFirstNameException;
import com.infy.sim.exception.InvalidLastNameException;
import com.infy.sim.exception.InvalidPincodeException;
import com.infy.sim.exception.InvalidUniqueIdException;
import com.infy.sim.exception.SpecialCharacterException;

/**
 * The Class ExceptionControllerAdvice.
 */

@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@Autowired
	private MessageSource messageSource;
	/**
	 * Exception handler.
	 *
	 * @param ex the ex
	 * @return the client error information
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ClientErrorInformation exceptionHandler(Exception ex) {
		
		ClientErrorInformation errorInfo = new ClientErrorInformation();
		errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setMessage("An unknown error occured.");
		return errorInfo;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, HttpMessageNotReadableException.class})
	@ResponseBody
    public ClientErrorInformation handleBindingErrors(Exception ex) {

		ClientErrorInformation errorInfo = new ClientErrorInformation();
		errorInfo.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorInfo.setMessage("Validation failed");
		return errorInfo;
	}
	
	@ExceptionHandler(InvalidDetailsException.class)
	public @ResponseBody ClientErrorInformation handleInvalidDetailsException(HttpServletRequest request, Exception ex){
		
		ClientErrorInformation response = new ClientErrorInformation();
//		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		
		return response;
	}
	
	@ExceptionHandler(ActiveSimException.class)
	public @ResponseBody ClientErrorInformation handleActiveSimExceptionException(HttpServletRequest request, Exception ex){
		
		ClientErrorInformation response = new ClientErrorInformation();
//		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		
		return response;
	}
	
	@ExceptionHandler(InvalidCustomerDetailsException.class)
	public @ResponseBody ClientErrorInformation handleInvalidCustomerDetailsException(HttpServletRequest request, Exception ex){
		
		ClientErrorInformation response = new ClientErrorInformation();
//		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		
		return response;
	}
	
	@ExceptionHandler(InvalidCustomerException.class)
	public @ResponseBody ClientErrorInformation handleInvalidCustomerException(HttpServletRequest request, Exception ex){
		
		ClientErrorInformation response = new ClientErrorInformation();
//		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		
		return response;
	}
	
	@ExceptionHandler(InvalidEmailException.class)
	public @ResponseBody ClientErrorInformation handleInvalidEmailException(HttpServletRequest request, Exception ex){
		
		ClientErrorInformation response = new ClientErrorInformation();
//		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		
		return response;
	}
	
	@ExceptionHandler(InvalidAddressException.class)
	public @ResponseBody ClientErrorInformation handleInvalidAddressException(HttpServletRequest request, Exception ex){
		
		ClientErrorInformation response = new ClientErrorInformation();
//		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		
		return response;
	}
	
	@ExceptionHandler(InvalidPincodeException.class)
	public @ResponseBody ClientErrorInformation handleInvalidPincodeException(HttpServletRequest request, Exception ex){
		
		ClientErrorInformation response = new ClientErrorInformation();
//		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		
		return response;
	}
	
	@ExceptionHandler(SpecialCharacterException.class)
	public @ResponseBody ClientErrorInformation handleSpecialCharacterException(HttpServletRequest request, Exception ex){
		
		ClientErrorInformation response = new ClientErrorInformation();
//		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		
		return response;
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	public @ResponseBody ClientErrorInformation handleAddressNotFoundException(HttpServletRequest request, Exception ex){
		
		ClientErrorInformation response = new ClientErrorInformation();
//		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		
		return response;
	}
	
	@ExceptionHandler(InvalidUniqueIdException.class)
	public @ResponseBody ClientErrorInformation handleInvalidUniqueIdException(HttpServletRequest request, Exception ex){
		
		ClientErrorInformation response = new ClientErrorInformation();
//		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		
		return response;
	}
	
	@ExceptionHandler(InvalidCustomerIdException.class)
	public @ResponseBody ClientErrorInformation handleInvalidCustomerIdException(HttpServletRequest request, Exception ex){
		
		ClientErrorInformation response = new ClientErrorInformation();
//		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		
		return response;
	}
	
	@ExceptionHandler(InvalidDateOfBirthFormat.class)
	public @ResponseBody ClientErrorInformation handleInvalidDateOfBirthFormat(HttpServletRequest request, Exception ex){
		
		ClientErrorInformation response = new ClientErrorInformation();
//		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		
		return response;
	}
	
	@ExceptionHandler(InvalidDateOfBirthException.class)
	public @ResponseBody ClientErrorInformation handleInvalidDateOfBirthException(HttpServletRequest request, Exception ex){
		
		ClientErrorInformation response = new ClientErrorInformation();
//		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		
		return response;
	}
	
	@ExceptionHandler(InvalidFirstNameException.class)
	public @ResponseBody ClientErrorInformation handleInvalidFirstNameException(HttpServletRequest request, Exception ex){
		
		ClientErrorInformation response = new ClientErrorInformation();
//		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		
		return response;
	}
	
	@ExceptionHandler(InvalidLastNameException.class)
	public @ResponseBody ClientErrorInformation handleInvalidLastNameException(HttpServletRequest request, Exception ex){
		
		ClientErrorInformation response = new ClientErrorInformation();
//		response.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		response.setMessage(ex.getMessage());
		
		return response;
	}
}
