package com.shi.utils;

import com.shi.exception.ParmsException;

public class Assertutil {
    public static void isTrue(Boolean flag,String msg) {
        if (flag) {
            throw new ParmsException(msg);
        }
    }
}