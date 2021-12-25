package ro.robert.socialmediaspringboot.validator;

import ro.robert.socialmediaspringboot.entity.User;

import java.util.regex.Pattern;

public class UserValidator implements Validator<User> {

    public void emailIsValid(String email) {
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        boolean isOk = Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
        if (!isOk) {
            throw new ValidationException("Invalid email address");
        }
    }

    @Override
    public void validate(User entity) throws ValidationException {
        emailIsValid(entity.getEmail());
    }
}
