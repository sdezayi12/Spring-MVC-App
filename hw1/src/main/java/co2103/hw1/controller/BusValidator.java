package co2103.hw1.controller;

import co2103.hw1.domain.Bus;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BusValidator implements Validator {
@Override
public boolean supports(Class<?> clazz) {

    return Bus.class.equals(clazz);
        }

@Override
public void validate(Object target, Errors errors) {
    Bus bus = (Bus) target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manufacturer", "bus.manufacturer.empty", "Manufacturer must not be empty");
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "driver", "bus.driver.empty", "Driver must not be empty");

    if (!isValidCity(bus.getCity())) {
        errors.rejectValue("city", "bus.city.invalid", "City must be Leicester, Birmingham, or Nottingham");
    }
    if (!isValidRoute(bus.getRoute())) {
        errors.rejectValue("route", "bus.route.invalid", "Route must be between 1 and 250");
    }
}

private boolean isValidCity(String city) {
        return "Leicester".equals(city) || "Birmingham".equals(city) || "Nottingham".equals(city);
    }

private boolean isValidRoute(int route) {

    return route >= 1 && route <= 250;
    }
}



