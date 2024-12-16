package com.paravar.practice.practice8.annotations;

import java.lang.reflect.Method;

public class TestAnnotation {
    public static void main(String[] args) throws NoSuchMethodException {
        /*
         Annotations:-
            - a special kind of interface that provides metadata (data about data) for Java programs.
            - Annotations don't affect the logic of a program directly but are used by tools,
              frameworks, and compilers for a variety of purposes such as configuration,
               code analysis, or providing additional information to the code.

            - in built: @Override, @Deprecated, @SuppressWarnings, @FunctionalInterface

            - they can be used alon with reflection

            - they can have methods & variables

            - they can be used for various purposes like:

                - Compile-time instructions
                - Build-time processing
                - Runtime processing


            - Target: They can be applied to
                 - classes, interfaces, and enums @Target(ElementType.TYPE)
                 - fields                         @Target(ElementType.FIELD)
                 - methods                        @Target(ElementType.METHOD)
                 - parameters                     @Target(ElementType.PARAMETER)
                 - local variables                @Target(ElementType.LOCAL_VARIABLE)


            - Retention Policy
                how long the annotation should be retained using @Retention.

                - @Retention(RetentionPolicy.SOURCE):
                     The annotation is discarded by the compiler and is not available at runtime.
                - @Retention(RetentionPolicy.CLASS):
                     The annotation is retained in the compiled bytecode but not available at runtime.
                - @Retention(RetentionPolicy.RUNTIME):
                     The annotation is available at runtime via reflection.


        * */

        // Get the class object
        Class<?> clazz = MyClass.class;

        // Check if the class has the custom annotation
        if (clazz.isAnnotationPresent(MyCustomAnnotation.class)) {
            MyCustomAnnotation annotation = clazz.getAnnotation(MyCustomAnnotation.class);
            System.out.println("Class Author: " + annotation.author());
            System.out.println("Class Date: " + annotation.date());
            System.out.println("Class Version: " + annotation.version());
        }

        // Check method annotations
        Method method = clazz.getMethod("someMethod");
        if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
            MyCustomAnnotation annotation = method.getAnnotation(MyCustomAnnotation.class);
            System.out.println("Method Author: " + annotation.author());
            System.out.println("Method Date: " + annotation.date());
            System.out.println("Method Version: " + annotation.version());
        }
    }
}

 @interface MyCustomAnnotation {
    String author() default "Unknown";
    String date() default "N/A";
    int version() default 1; // in fo default value...user need to pass
}

@MyCustomAnnotation(author = "John Doe", date = "2024-12-16", version = 2)
 class MyClass {

    @MyCustomAnnotation(author = "Jane Doe", date = "2024-12-17")
    public void someMethod() {
        System.out.println("This is a method.");
    }
}