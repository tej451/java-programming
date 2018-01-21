package com.innerclass;

import java.util.Arrays;

import com.innerclass.OuterClass.InnerClass;
import com.innerclass.OuterClass.StaticNestedClass; // we can call static nested class using 
//OuterClass.StaticNestedClass staticNestedClass1 = new OuterClass.StaticNestedClass();
//OR using above import

public class InnerClassTest {

    public static void main(String[] args) {
        OuterClass outer = new OuterClass(1,2,3,4);
        
        //static nested classes example
        StaticNestedClass staticNestedClass = new StaticNestedClass();
        StaticNestedClass staticNestedClass1 = new StaticNestedClass();
        
        System.out.println(staticNestedClass.getName()); //OuterClass
        staticNestedClass.d=10;
        System.out.println(staticNestedClass.d);
        System.out.println(staticNestedClass1.d);
        
        //inner class example
        InnerClass innerClass = outer.new InnerClass();
        System.out.println(innerClass.getName());
        System.out.println(innerClass);
        innerClass.setValues();
        System.out.println(innerClass);
        
        //calling method using local inner class
        outer.print("Outer");
        
        //calling method using anonymous inner class
        System.out.println(Arrays.toString(outer.getFilesInDir("src/com/innerclass", ".java")));
        
        System.out.println(Arrays.toString(outer.getFilesInDir("bin/com/innerclass", ".class")));
    }

}
