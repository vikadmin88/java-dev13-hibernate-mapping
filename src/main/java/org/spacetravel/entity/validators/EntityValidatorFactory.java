package org.spacetravel.entity.validators;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

public class EntityValidatorFactory {

    private static final ValidatorFactory FACTORY = Validation.byDefaultProvider()
        .configure()
        .messageInterpolator(new ParameterMessageInterpolator())
        .buildValidatorFactory();
    public static Validator getEntityValidator() {
         return FACTORY.getValidator();
    }
}
