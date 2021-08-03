package webtienganh.exception;

import org.springframework.validation.BindingResult;

public class MyExceptionHelper {

	private static IllegalArgumentException illegalArgumentException;
	private static ResourceNotFoundException resourceNotFoundException;
	private static AuthenticationException authenticationException;
	private static EntityValidatorException entityValidatorException;
	private static RuntimeCustomException runtimeCustomException;

	public static IllegalArgumentException throwIllegalArgumentException() {

		if (illegalArgumentException == null)
			illegalArgumentException = new IllegalArgumentException("Tham số đầu vào không hợp lệ");

		return illegalArgumentException;
	}

	public static ResourceNotFoundException throwResourceNotFoundException(String message) {

		if (resourceNotFoundException == null)
			resourceNotFoundException = new ResourceNotFoundException();

		resourceNotFoundException.setMessage(message);
		return resourceNotFoundException;
	}

	public static AuthenticationException throwAuthenticationException() {

		if (authenticationException == null)
			authenticationException = new AuthenticationException("Không có quyền vào tài nguyên");

		return authenticationException;
	}
	
	public static EntityValidatorException throwEntityValidatorException(BindingResult bindingResult) {

		if (entityValidatorException == null)
			entityValidatorException = new EntityValidatorException();

		entityValidatorException.setBindingResult(bindingResult);
		return entityValidatorException;
	}
	
	public static RuntimeCustomException throwRuntimeCustomException(Object error) {

		if (runtimeCustomException == null)
			runtimeCustomException = new RuntimeCustomException();

		runtimeCustomException.setError(error);
		return runtimeCustomException;
	}
	
}
