package com.cg.testmgmt.util;

import com.cg.testmgmt.exception.TestNotAddedException;
import com.cg.testmgmt.exception.TestNotFoundException;
import com.cg.testmgmt.exception.UserNotFoundException;
import com.cg.testmgmt.util.CentralizedExceptionHandler;

import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CentralizedExceptionHandler {
	 private static final Logger Log= LoggerFactory.getLogger(CentralizedExceptionHandler.class);
	
	 
	  @ExceptionHandler(TestNotFoundException.class)
	    public ResponseEntity<String>handleTestNotFound(TestNotFoundException ex){
	        Log.error("test not found exception",ex);
	        String msg=ex.getMessage();
	        ResponseEntity<String>response=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
	        return response;
	    }
	  	
	  
	  @ExceptionHandler(UserNotFoundException.class)
	    public ResponseEntity<String>handleUserNotFound(UserNotFoundException ex){
	        Log.error("user not found exception",ex);
	        String msg=ex.getMessage();
	        ResponseEntity<String>response=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
	        return response;
	    }
	  
	  @ExceptionHandler(TestNotAddedException.class)
	    public ResponseEntity<String>handleTestNotAdded(TestNotAddedException ex){
	        Log.error("test not added exception",ex);
	        String msg=ex.getMessage();
	        ResponseEntity<String>response=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
	        return response;
	    }


	    @ExceptionHandler(ConstraintViolationException.class)
	    public ResponseEntity<String>handleConstraintViolate(ConstraintViolationException ex){
	       Log.error("constraint violation",ex);
	       String msg=ex.getMessage();
	       ResponseEntity<String>response=new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
	       return response;
	    }

	    @ExceptionHandler(Throwable.class)
	    public ResponseEntity<String>handleAll(Throwable ex){
	      Log.error("exception caught",ex);
	      String msg=ex.getMessage();
	      ResponseEntity<String>response=new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
	      return response;
	    }
	    
	    
	 
}


