package com.advices;

import java.time.LocalDateTime;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(BookNotFoundException.class)
	public ResponseEntity<?> bookNotFoundException(BookNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> golbalExceptionHandler(BookNotFoundException ex, WebRequest request)
    {
    	ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(),request.getDescription(false));
    	return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<?> authorNotFoundException(AuthorNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   }
	@ExceptionHandler(DamagedBooksNotFoundException.class)
	public ResponseEntity<?> damagedBooksNotFoundException(DamagedBooksNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

}
	@ExceptionHandler(BooksOrderNotFoundException.class)
	public ResponseEntity<?> booksOrderNotFoundException( BooksOrderNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(AddressNotFoundException.class) 
	public ResponseEntity<?> addressnotfoundexception(AddressNotFoundException ex, WebRequest request)
	{ 
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
		return new  ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND); 
	}
	@ExceptionHandler(IDNotFoundException.class) 
	public ResponseEntity<?> idNotFoundException(IDNotFoundException ex, WebRequest request)
   {
	  ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false)); 
	  return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND); 
   }
	  
	  @ExceptionHandler(ReaderNotFoundException.class) 
	  public ResponseEntity<?>handlereadernotfoundexception(ReaderNotFoundException ex, WebRequest request)
	  {
		  ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(),ex.getMessage(), request.getDescription(false));
		  return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	  }
	  
	
	  
	  @ExceptionHandler(UserNotFoundException.class) 
	  public ResponseEntity<?> handleusernotfoundexception(UserNotFoundException ex, WebRequest request)
	  {
	  ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false)); 
	  return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND); 
	  }
	  
	
}
