package webtienganh.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import webtienganh.dto.ErrorDTO;

@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		ErrorDTO body = ErrorDTO.builder().status(status.value()).error(errors).build();
		return new ResponseEntity<>(body, headers, status);

	}

	@ExceptionHandler(value = { ResourceNotFoundException.class })
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	protected ErrorDTO handleResourceNotFoundException(ResourceNotFoundException ex) {

		ErrorDTO result = ErrorDTO.builder().status(404).error(ex.getMessage() + " không tồn tại").build();

		return result;

	}

	@ExceptionHandler(value = { IllegalArgumentException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	protected ErrorDTO handleIllegalArgumentException(IllegalArgumentException ex) {

		ErrorDTO result = ErrorDTO.builder().status(400).error("Tham số đầu vào không hợp lệ").build();

		return result;

	}
	
	@ExceptionHandler(value = { AuthenticationException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	protected ErrorDTO handleAuthenticationException(AuthenticationException ex) {

		ErrorDTO result = ErrorDTO.builder().status(400).error(ex.getMessage()).build();

		return result;

	}

}
