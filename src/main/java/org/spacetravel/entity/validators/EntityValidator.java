package org.spacetravel.entity.validators;

import jakarta.validation.ConstraintViolation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class EntityValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(EntityValidator.class.getCanonicalName());
    public static <T> boolean isValidationFailed(T item) {
        Set<ConstraintViolation<T>> violations = getViolations(item);
        return violations != null && !violations.isEmpty();
    }

    public static <T> Set<ConstraintViolation<T>> getAndLogViolations(T item) {
        Set<ConstraintViolation<T>> violations = getViolations(item);
        for (ConstraintViolation<T> violation : violations) {
            LOGGER.error("Source: {} >>> Constraint: {}", item.getClass().getCanonicalName(),  violation.getMessage());
        }
        return violations;
    }

    private static <T> Set<ConstraintViolation<T>> getViolations(T item) {
        return EntityValidatorFactory.getEntityValidator().validate(item);
    }
}
