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

import webtienganh.response.ErrorResponse;

@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());

		ErrorResponse body = ErrorResponse.builder().status(status.value()).error(errors).build();
		return new ResponseEntity<>(body, headers, status);

	}

	@ExceptionHandler(value = { ResourceNotFoundException.class })
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	protected ErrorResponse handleResourceNotFoundException(ResourceNotFoundException ex) {

		ErrorResponse result = ErrorResponse.builder().status(404).error(ex.getMessage() + " không tồn tại").build();

		return result;

	}

	@ExceptionHandler(value = { IllegalArgumentException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	protected ErrorResponse handleIllegalArgumentException(IllegalArgumentException ex) {

		ErrorResponse result = ErrorResponse.builder().status(400).error("Tham số đầu vào không hợp lệ").build();

		return result;

	}
	
	@ExceptionHandler(value = { AuthenticationException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	protected ErrorResponse handleAuthenticationException(AuthenticationException ex) {

		ErrorResponse result = ErrorResponse.builder().status(400).error("Không có quyền vào tài nguyên").build();

		return result;

	}

}
