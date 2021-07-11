package webtienganh.exception;

public class MyExceptionHelper {

	private static IllegalArgumentException illegalArgumentException;
	private static ResourceNotFoundException resourceNotFoundException;

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

	
}
