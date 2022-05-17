package org.jast.apps.gcp.cloudsql.controllers.exceptions;

import java.util.List;
import java.util.stream.Collectors;

import org.jast.apps.gcp.cloudsql.dtos.ErrorResponseDTO;
import org.jast.apps.gcp.cloudsql.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionHandler {

	private static Logger LOG = LoggerFactory.getLogger(GenericExceptionHandler.class);
	
	private static final String NOT_FOUND_CODE_FORMAT = "%s_DOES_NOT_EXIST";
	private static final String NOT_FOUND_MESSAGE_FORMAT = "The %s does not exist";
	private static final String NOT_FOUND_DETAIL_FORMAT = "The %s with identifier %d does not exists";
	
	private static final String SERVER_ERROR_CODE = "INTERNAL_SERVER_ERROR";
	private static final String SERVER_ERROR_MESSAGE = "An unknown error has occurred";
	
	private static final String BAD_REQUEST_CODE = "INVALID_REQUEST_DATA";
	private static final String BAD_REQUEST_MESSAGE = "The request has invalid data";
	private static final String BAD_REQUEST_DETAIL_FORMAT = "%s: %s";
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?> handleNotFoundException(NotFoundException exception){
		var code = String.format(NOT_FOUND_CODE_FORMAT, 
				exception.getEntityType().toString()).toUpperCase();
		var message = String.format(NOT_FOUND_MESSAGE_FORMAT, 
				exception.getEntityType().toString());
		var detail = String.format(NOT_FOUND_DETAIL_FORMAT, 
				exception.getEntityType().toString(),
				exception.getIdentifier());

		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(new ErrorResponseDTO(code, message, List.of(detail)));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
		List<String> details = exception.getBindingResult().getAllErrors().stream().map(error -> {
			String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        return String.format(BAD_REQUEST_DETAIL_FORMAT, fieldName, errorMessage);
		}).collect(Collectors.toList());
		return ResponseEntity
				.badRequest()
				.body(new ErrorResponseDTO(BAD_REQUEST_CODE, BAD_REQUEST_MESSAGE, details));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception exception) {
		LOG.error(exception.getMessage(), exception);
		return ResponseEntity
				.internalServerError()
				.body(new ErrorResponseDTO(SERVER_ERROR_CODE, SERVER_ERROR_MESSAGE, List.of()));
	}
	
}
