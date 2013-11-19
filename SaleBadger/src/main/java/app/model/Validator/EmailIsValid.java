package app.model.Validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import app.model.Validator.EmailIsValid.EmailValidator;

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
@Constraint(validatedBy = EmailValidator.class)
public @interface EmailIsValid {

	String message() default "Invalid email address";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	public class EmailValidator implements ConstraintValidator<EmailIsValid, String> {

		@Override
		public void initialize(EmailIsValid email) {
			// TODO Auto-generated method stub

		}

		@Override
		public boolean isValid(String email, ConstraintValidatorContext arg1) {
			// TODO Auto-generated method stub
			boolean result = true;
			try {
				InternetAddress emailAddr = new InternetAddress(email);
				emailAddr.validate();
			} catch (AddressException ex) {
				result = false;
			}
			return result;
		}

	}

}
