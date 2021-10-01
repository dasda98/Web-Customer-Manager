package com.wcm.webcustomermanager.validator;

import com.wcm.webcustomermanager.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Product p = (Product) o;

        System.out.println(p);

        if (p.getPrice() != null && p.getPrice() < 0) {
            errors.rejectValue(
                    "price",
                    "product.error.price.negativeValue"
            );
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "name",
                "product.error.name"
        );

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "price",
                "product.error.price"
        );

        System.out.println(errors);
    }
}
