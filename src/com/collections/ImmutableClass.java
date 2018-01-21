package com.collections;

import java.util.Date;
/*
 * even it is not necessary to declare attributes/properties as final as long as we are not providing setter methods
 * if we declare a field as final and have not assigned the value in constructor, then compile time exception, final field
 * have not been initialized is indicated
 */
public final class ImmutableClass
{
 
    /**
    * Integer class is immutable as it does not provide any setter to change its content
    * */
    private final Integer immutableField1;
    //private final Integer immutableField1 = 0; if we initialize also, then will not be able to assign new value
    /**
    * String class is immutable as it also does not provide setter to change its content
    * */
    private final String immutableField2;
    /**
    * Date class is mutable as it provide setters to change various date/time parts
    * */
    private final Date mutableField;
 
    //Default public constructor 
    public ImmutableClass(Integer fld1, String fld2, Date date)
    {
        this.immutableField1 = 2;
        this.immutableField2 = fld2;
        this.mutableField = new Date(date.getTime());
    }
 
    //Provide no setter methods
 
    /**
    * Integer class is immutable so we can return the instance variable as it is
    * */
    public Integer getImmutableField1() {
    	return immutableField1;
    }
 
    /**
    * String class is also immutable so we can return the instance variable as it is
    * */
    public String getImmutableField2() {
        return immutableField2;
    }
 
    /**
    * Date class is mutable so we need a little care here.
    * We should not return the reference of original instance variable.
    * Instead a new Date object, with content copied to it, should be returned.
    * */
    // Always remember that your instance variables can be either mutable or immutable. Identify them and return new 
    // objects with copied content for all mutable objects. Immutable variables can be returned safely without extra effort.
    public Date getMutableField() {
        return new Date(mutableField.getTime());
    	//return mutableField;
    }
 
    @Override
    public String toString() {
        return immutableField1 +" - "+ immutableField2 +" - "+ mutableField;
    }
}
