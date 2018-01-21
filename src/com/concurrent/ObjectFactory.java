package com.concurrent;

public class ObjectFactory {

    private static volatile ObjectFactory object;

    public static ObjectFactory getInstance() {
        if (object == null) {
            synchronized (ObjectFactory.class) {
                if (object == null) {
                    object = new ObjectFactory();
                }
            }
        }
        return object;
    }
}
