package pl.camp.it.forum.validators;

import pl.camp.it.forum.exceptions.TopicValidatorException;

public class PostValidator {

    public static void validatePost(String text) {
        String regex = "^.{5,}$";
        if (!text.matches(regex)) {
            throw new TopicValidatorException();
        }
    }
}