package com.wcm.webcustomermanager.validator;

import com.wcm.webcustomermanager.entity.Customer;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "firstName",
                "error.firstName",
                "First name is required."
        );
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "lastName",
                "error.lastName",
                "Last name is required."
        );
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "email",
                "error.email",
                "Email is required."
        );

    }
}
