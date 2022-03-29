package com.example.security.handlers;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.security.api.ApiResponse;
import com.example.security.api.Errormessage;

@ControllerAdvice
public class ApiErrorMsgHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({ Exception.class, ApiErrorInfo.class, RuntimeException.class, ValidationException.class,
			AccessDeniedException.class, InternalServerError.class, IllegalArgumentException.class })
	private ResponseEntity<Object> error(Exception exception,WebRequest request) {
		System.out.println("Exception------->:\t" + exception);
		if (exception instanceof ApiErrorInfo) {
			return apiResponseData((ApiErrorInfo) exception);
		} else if (exception instanceof AccessDeniedException) {
			return new ResponseEntity<Object>("Access denied message here", HttpStatus.FORBIDDEN);
		} else if (exception instanceof NullPointerException) {
			System.out.println("NullPointerException exception class");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return apiGenralData(exception);
		}

	}

	private ResponseEntity<Object> apiGenralData(Exception exception) {
		ApiResponse res = new ApiResponse();
		Errormessage vm = new Errormessage();
		List<Errormessage> error = new ArrayList<>();
		vm.setMessage(exception.getLocalizedMessage());
		vm.setCode("1000");
		error.add(vm);
		res.setErrorVM(error);
		res.setData(null);
		res.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	private ResponseEntity<Object> apiResponseData(ApiErrorInfo exception) {
		ApiResponse res = new ApiResponse();
		Errormessage vm = new Errormessage();
		List<Errormessage> error = new ArrayList<>();
		vm.setMessage(exception.getLocalizedMessage());
		vm.setCode("1000");
		error.add(vm);
		res.setErrorVM(error);
		res.setData(null);
		res.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}
