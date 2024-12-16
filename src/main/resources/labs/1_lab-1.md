

# Java Fundamentals

**Part-1**

1. First Program - HelloWorld  
   create 3 folders under labs/lab1: src, cls, bin. Now write the below code in
   HelloWorld.java
    ```java
     public class HelloWorld {
       public static void main(String[] args) {
           System.out.println("Hello World");
       }
     }
   ```
   now compile and run, we can do this in many ways
	1. open the cmd in labs/lab1 folder   
	   to compile: `javac -d cls src/HelloWorld.java`  
	   to run: `java -cp cls HelloWorld`
	2. open the cmd in src folder  
	   to compile: `javac HelloWorld.java`  
	   to run: `java HelloWorld`
	3. open the cmd in src folder ( recommended )
	   to compile: `javac -d ../cls HelloWorld.java `  
	   to run: `java -cp ../cls HelloWorld`


2. Create a class Hello in Hello.java file. Create a main() method in it.
   Use System.out.print(“Hello”) and System.out.println(“HelloHai”); and see the difference.

3. Create a A.java. Create 3 class definitions named A, B, C. Try to make all of them be marked public. Have empty body. Compile A.java. Are you able to compile? If not why not?
   Mark B, C with package access (remove access specifier) and then compile. Now is it compiling? Why so?
   Insert main() in all 3 call definitions with different SOPs. Which main() will gets executed? Execute all the 3 class`s main().

4. Try to change the header of the main() -> remove String[], change it to int[], make main()
   protected, etc and try to compile and run. What fails and why?

5. Create an int variable in main() named i. Assign value 5 to it and print it out using SOP.
   Compile and test. Next do not assign any value to i and try to recompile. Do you get any error? why? what does it say?

6. Create a byte variable in main(),
   byte b = 100;
   Try to assign 128 to a byte. Are you able to compile? what about -128? Try to compile, run.

7. Create a byte variable, assign it a value and then store in an int variable.
   ```
       byte b = 50;
       int x = b; // why does this work?
       b = x; // why does this not work?
   ```
8. Replace last statement with
   `b = (byte) x; `
   and see if it works.  
   Now test the same by assigning a value to a short, a char and try to assign to an int, long, float, double. Also from the bigger datatyped variables, put the value to smaller data typed variables. Do not create 2 variables with the same identifier.

9. Try out all the arithmetic operators and print out the results.
     ```
       int x = 10;
       int y = 4;
       int result1 = x + y;
       int result2 = x * y;
       int result3 = x / y;
       int result4 = x % y;
       int result5 = x - y;

       System.out.println(result1);
       System.out.println(result2);
       System.out.println(result3);

       System.out.println(result4);
       System.out.println(result5);
   ``` 
   Now try to overflow and underflow the values in variables.

10. Execute the code given below and check the o/p?
	 ```
       System.out.println("1"+2+3);
       System.out.println(6+2+"4");
       System.out.println('2'+2+"2");
       System.out.println(‘2'+2);
     ```
	Check on paper whether you are getting the correct result.

11. Execute the code given below and check the o/p?
	1.
	 ```
         byte b = 10;
         b = b + 10;
         System.out.println(b);
     ```
	How do u fix the error for the above code.
	2.
	  ```
         byte b = 10;
         b += 10;
         System.out.println(b);
      ```
12. Execute the code given below and check the o/p?
	1.
	 ```
         char c = 'X';
         int a = 63;
         char d = a;
         System.out.println(d);
     ```
	2.
	 ```
         char c = 'X';
         int a = 63; 
         char d = (char)a; 
         System.out.println(d);
     ```

15. Execute the code given below and check the o/p?
	  ```
           int a = 10/0; // you will have to comment this after testing
           double d = 10.0/0.0;
           float f = 10.0f/0.0f;
           double d = 10.0/0;
           double a = 10/0.0;
    ```

14. Add 100 + 100 and store result in a byte. Print the value. Do you understand why is the result the one being printed?

**Part-2**

1. Build a HelloWorld program
2. Print HelloWorld 10 times to the monitor
3. Print Hello with number (as Hello1, Hello2, Hello3...till Hello10) to the monitor
4. Print 1 to 10 to the monitor using for, while, do..while
5. Print all odd numbers from 1 to 100 to the monitor
6. Print all even numbers from 1 to 100 to the monitor
7. Print all non multiples of 3 between 1 to 100 to the monitor
8. Print "even" and the number or "odd" and the number between 1 to 100
9. Print "divisible" and the number if the num is divisible by 3 or 5 and not both, between 1-100
10. Consider an int input (for ex 100). Using << and >>, multiply/divide the number by 2, 4,
	Verify the results on paper.
11. WAP to Divide any two int values and get the output of remainder and quotient?
12. Create a byte variable with value 127. Add 10 to it and store in byte. Print the result.      
	Is the result correct? Why not?
13. Execute the code given below and check the o/p?
	  ```
        System.out.println(2 >> 1);
        System.out.println(6 >> 2);
        System.out.println(-2 >> 1);
    ```
	Check on paper whether you are getting the correct result.

14. Execute the code given below and check the o/p?
	```
		System.out.println(10);
		System.out.println(012);
		System.out.println(0xAB);
	   ```
	Check on paper whether you are getting the correct result.

15. Execute the code given below and check the o/p?
	```
		System.out.println( 2 << 1);
		System.out.println(6 << 2);
		System.out.println( -2 << 1);
	```
	Check on paper whether you are getting the correct result.

16. Execute the code given below and check the o/p?
	1.
	 ```
     int x = 10;
     System.out.println(~x);
     ```
	2.
	 ```
     int a = 100;
     System.out.println(~a);
     ```  

	Check on paper whether you are getting the correct result.

17. Execute the code given below and check the o/p?
	1.
	``` 
    int x = 10;
    int y = 6;
    System.out.println(x | y);
    ```
	2.
	 ```
     int a = 100;
     int b = 50;
     System.out.println(a | b);
     ```
	Check on paper whether you are getting the correct result.


18. Execute the code given below and check the o/p?
	1.
	``` 
    int x = 10;
    int y = 6;
    System.out.println(x & y);
    ```
	2.
	 ```
     int a = 100;
     int b = 50;
     System.out.println(a & b);
     ```
	Check on paper whether you are getting the correct result.

19. Execute the code given below and check the o/p?
	1.
	``` 
    int x = 10;
    int y = 6;
    System.out.println(x ^ y);
    ```
	2.
	 ```
     int a = 100;
     int b = 50;
     System.out.println(a ^ b);
     ```
	Check on paper whether you are getting the correct result.

20. Execute the code given below and check the o/p?
	1.
	 ```
     int x = 10;
     System.out.println(x >>> 2);
     ```
	2.
	 ```
     int a = -10;
     System.out.println(a >>> 2);
     ```
	Check on paper whether you are getting the correct result.

21. Execute the code given below and check the o/p? Check on paper whether you are getting the correct result.
	```
		System.out.println(4 | 3);
		System.out.println(4 | 4);
		System.out.println(4 & 3);
		System.out.println(4 / 3);
	```

22. Execute the code given below and check the o/p?
	```
		int i = 50;
		while(i != 0){
		System.out.println(i >>>= 1);
		}
	```
23. Create a class Test. Create a method named process that accepts an int as a
	parameter. Create a main method. Create a int variable x with value 10. Print the value of x to monitor using SOP. Then invoke process() and pass x as a parameter. Print the value in process(). Change the value in process(). Print the value in main() after invoking process(). Are you understanding the control flow? Are you understanding how parameters are being passed?

24. Create multiple class definitions in 1 .java and see how many classes you can declare public. When you compile how many .class files are getting generated? Can multiple classes have main()? Which one will be executed by JVM, test it.

25. Test main() calling another static method x() which should call another static method y() in the same class. Put SOPs in each method to understand flow of control. How does the JVM manage control flow? What data structure does it internally use? Create local variables in each method. Try to access one methods local variable in another method. Can you access it? Why not? Where are local variables stored in memory? How do you explain parameter passing? Now create another class with name Test2 and create a static method named z() in it. Call this method from Test`s main() and see how control flow occurs.

26. Put ‘a’ into a char. Put this variable into an int variable. Print out the value. Why do you the value you see being printed? Now print the next 25 values in a loop and print out the symbols by incrementing the char variable
