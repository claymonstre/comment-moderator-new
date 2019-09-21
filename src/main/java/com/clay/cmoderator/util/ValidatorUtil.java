package com.clay.cmoderator.util;

import static com.clay.cmoderator.util.ValidationConstant.BLANK_SPACE;

public class ValidatorUtil {

    private ValidatorUtil() {}

    public static String filterComment(String comment) {

        return comment.trim()
                .replaceAll("[^a-zA-Z\\s]", "")
                .replaceAll(" +", BLANK_SPACE)
                .toLowerCase();
    }


}
