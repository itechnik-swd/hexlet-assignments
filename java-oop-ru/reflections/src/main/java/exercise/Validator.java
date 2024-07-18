package exercise;

import java.lang.reflect.Field;
import java.util.*;

// BEGIN
class Validator {
    public static List<String> validate(Address address) {
        List<String> invalidFields = new ArrayList<>();
        try {
            for (Field field : address.getClass().getDeclaredFields()) {
                if (field.isAnnotationPresent(NotNull.class)) {
                    field.setAccessible(true);
                    if (Objects.isNull(field.get(address))) {
                        invalidFields.add(field.getName());
                    }
                }
            }
        } catch (IllegalAccessException exception) {
            exception.printStackTrace();
        }

        return invalidFields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> notValidFields = new HashMap<>();
        try {
            for (Field field : address.getClass().getDeclaredFields()) {
                List<String> errors = new ArrayList<>();
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class)) {
                    if (Objects.isNull(field.get(address))) {
                        errors.add("can not be null");
                    }
                }
                if (field.isAnnotationPresent(MinLength.class)) {
                    MinLength MinLengthInfo = field.getAnnotation(MinLength.class);
                    var fieldName = field.get(address);
                    if (!Objects.isNull(fieldName)) {
                        int fieldNameLength = fieldName.toString().length();
                        if (fieldNameLength < MinLengthInfo.minLength()) {
                            errors.add("length less than " + MinLengthInfo.minLength());
                        }
                    }
                }
                if (!errors.isEmpty()) {
                    notValidFields.put(field.getName(), errors);
                }
            }
        } catch (IllegalAccessException exception) {
            exception.printStackTrace();
        }

        return notValidFields;
    }
}
// END
