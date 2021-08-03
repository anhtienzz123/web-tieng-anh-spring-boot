package webtienganh.exception;

import org.springframework.validation.BindingResult;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityValidatorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private BindingResult bindingResult;

	public EntityValidatorException() {
		super();
	}

	public EntityValidatorException(BindingResult bindingResult) {
		super();
		this.bindingResult = bindingResult;
	}
}
