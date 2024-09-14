package co2103.hw1.controller;

import co2103.hw1.Hw1Application;
import co2103.hw1.domain.Depot;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class DepotValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Depot.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Depot depot = (Depot) target;

        // Validate unique id within the list
        if (isDuplicateId(depot.getId())) {
            errors.rejectValue("id", "duplicate", "Depot ID must be unique");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "empty", "Location must not be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "owner", "empty", "Owner must not be empty");
    }

    private boolean isDuplicateId(int depotId) {
        for (Depot depot : Hw1Application.depots) {
            if (depot.getId() == depotId) {
                return true;
            }
        }
        return false;
    }

}

