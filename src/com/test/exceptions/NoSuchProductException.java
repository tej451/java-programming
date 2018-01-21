package com.test.exceptions;
/*
 * Though creating a custom, exception is as easy as subclassing java.lang.Exception class, there are few best practices you can follow to make most of it. 
 * There is so much criticism of checked exception due to boilerplate require to handle it, you will hardly create your custom exception as checked.

1) Don’t' use Exception to control application behavior. Exception handling is very expensive as it requires native calls to copy stack trace, each time exception is created.

2) While creating a custom exception, prefer to create an unchecked, Runtime exception than a checked exception, especially if you know that client is not going to take
 any reactive action other than logging.

3) If your custom exception is created by passing another exception, then always contain original Exception as a source; use constructor which takes Exception rather
 than only message String.

4) Apart from providing default no argument constructor on your custom Exception class, consider providing at least two more constructors, one which should accept a 
failure message and other which can accept another Throwable as the cause.

5) If possible, avoid creating custom Exception and re-use existing, standard Exception classes from JDK itself. Most of the time you will realize that all you need 
is a form of IllegalArgumentException or ParseException or something similar.

6) While defining custom Exception, one of the most common mistake programmer make is to think that constructor is inherited from java.lang.Exception class,
 for example, they think that their Exception class will automatically inherit default no argument constructor and the one which takes a String message. 
 This is not true. The constructor is not inherited in Java, not even default constructor. It's actually added by the compiler rather than inherited from parent class.
  That's why I have declared two constructors, one with String parameter and other as Throwable parameter

 */
class NoSuchProductException extends RuntimeException {

    private int productId;

    public NoSuchProductException() {
        super();
    }

    //point 3
    public NoSuchProductException(RuntimeException e){
    	super(e);
    }
    
    public NoSuchProductException(String message, int productId) {
        super(message);
        this.productId = productId;
    }

    public NoSuchProductException(String message, int productId, Throwable cause) {
        super(message, cause);
        this.productId = productId;
    }

    

    @Override
    public String getMessage() {
        return super.getMessage() + " for productId :" + productId;
    }

   
}


