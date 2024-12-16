

# Variables ( Practicles - 3 )

**State effecting behaviour**

*Theory: Instance variables (variables declared outside method and inside class) can be accessed by instance methods and we use this for implementing state impacts behaviour (will discuss in complete detail tomorrow in class). First go through Hippo.java, Duck.java, compile and run them and understand the control flow.*

0. Create a Duck. A Duck has a tailSize (int). A Duck can swim. When you ask a Duck to swim, it says so (print to monitor).
   Design and test Duck class usage as we did for Hippo. Create 2 Duck objects in tester class (TestDuck->main()), with 2 references pointing to it (lets say d1,d2). Set the tailSize states to 10 and 20. Invoke d1.swim() & d2.swim(). Compile, run and test your understanding so far.
   Now make d1.size = d2.size. SOP d1.size and d2.size to monitor. What has changed and why?
   Now make d1.size = 30. SOP d1.size and d2.size to monitor. What has changed and why?
   Now make d1=d2. SOP d1.size and d2.size to monitor. What has changed and why?  Now make d1=d2=null. Can you access any of the 2 objects now? Now do d1= new Duck(); How many objects are reachable? Do you understand the answers to all the questions? If not, please ask.

1. There are Cows. A Cow has a name and can moo. When you ask a Cow to moo, it shouts out its name. Design a class for Cow and the tester code. After testing if cows work correctly, create 2 references and then point to same object. Verify what happens if you change the state of the object using one ref when you invoke behaviour using the second.
   ```java
	   class Cow  
		{  
		    String name;  
		  
		    public void moo()  
		    {  
		        System.out.println("Me cow "+name+" going moo moo...");  
		    }  
		}
   ```

   (See example code Cow.java and TestCow.java. Code on your own after
   understanding the same).

2. Check if instance variables of type string, int and boolean are given default values. Check if local variables are given default values. How to do this?
   Create a class with 4 instance variables with String, boolean, int and boolean as datatypes. Create a Tester class with main where you create an object and using reference print the instance variable values to monitor using SOP.
   ```java
   public class Q2{  
    int a;  
    String str;  
    boolean bool;  
  
    public static void main(String[] args) {  
        Q2 x = new Q2();  
        System.out.println(x.a);  
        System.out.println(x.str);  
        System.out.println(x.bool);  
  
        // local variables  
		 int age;  
	     String name;  
	     boolean isAdult;  
	    // System.out.println(age+" "+name+" "+isAdult);// gives error
	  }  
	}
   ```

3. A Pen has inkQty (int), colour (string) and can be used to write and refill. A text must be given for it to write. A quantity must be given to refill. If there is ink then the pen will write the text given to it (SOP). Refill works by taking in the int qty to add to the existing inkQty. First as a class designer, on paper apply OOAD *(Object-Oriented Analysis and Design)* and arrive at the class design. Then create the class implementation and create a tester class to create2 pen objects, give it inkQty and ask it to write. First code this on your own. If you cannot get it correctly, then see Pen.java and TestPen.java. Then fix the code and rerun. Do not see the code first.
4. There are Persons. A person has a age, name. Persons can eat, sleep. A person sleeps more if his age is < 40 and eats less. If thepersons age is >= 40, he sleeps less but eats more. Design a Personclass and test it.
5. There are Dogs. Every Dog has a name and a size. Dogs can bark. If the size of the dog is > 10, it "meows". If the size <=10, then as many times, it "bow wow" its name to the monitor. Test Dog design. After testing the same, make the size variable private and then add setSize() getSize() method. See how this impacts your tester class. What check
   should you add in bark() to ensure that even if the class user has not set size and invokes bark, he gets scolded with a message?
6. *Important problem* Cars can be started, driven, reversed or stopped. You have to start the car to drive/reverse/stop it. When car is being driven / reversed, the fuel reduces. Once the car has no fuel, the car stops. Every car has a name. Write a tester class to test cars. How to know whether the car has started and then only being asked to be driven? Try to design on paper first and then see the below design. Understand how state can impact behaviour.
7. There are Accounts. Every Account has a number (string), owner(string) and balance (double). You can withdraw(double amt), deposit(doubt amt) and checkBalance(). When you withdraw, the balance should reduce accordingly. When you deposit, the balance will increase accordingly. Code an Account class and test it by creating 2 account objects? How do you stop over withdrawal?
8. There are TVs. A TV has a name and channel that is being displayed. You can increment/decrement channel. You can change the channel to a given number as well. You can ask the TV to display. When a TV is asked to display, it will print the channel num, the volume. TV has volume (int). You have to switch on the TV first before you can operate the channels or increase or decrease the volume. Design and test TV working.

9. *Test passing reference as parameter.* Create a Fish class with String name in it. Create a Croc class with String name and a method called eat(). Accept a Fish reference as parameter. In the eat(), print both the crocs name and fish name (public void eat(Fish f)). In TestPass class, code a main() where you should create a croc object, a fish object, assign names “cocky” and “fishy” and invoke eat() and pass fish ref as
   parameter. Print the fish name before calling eat() and after calling
   eat(). Run and test. Example solved code is given in .java files.

   *Test the following as well:*
   1. in eat(), after SOP, assign f to null. Check what happens.
   2. in eat(), assign f to new Fish object and assign name “Flippy”. Now check the SOPs
   3. in eat(), assign f .name to “Flippy” and observe outputs. What happens here? How are references getting passed?
   4. pass null to eat() and check what happens

10. in main
    ```java
	    Person p = null;
		p.eat(); // What happens and why?
    ```
    In a for loop, create 10 person objects and set it to p reference. How many objects are reachable after the control comes out of the for loop?

11. Write a program to test working of Math class. Test the following methods (see TestMath.java for example - Math class has static methods that return results of performing square root, cube root, round, absolute, random value between 0-1 as a decimal, etc):
     ```
	    double result;  
		result = Math.sqrt(4.0); // returns square root of value  
		result = Math.cbrt(16.0); // returns cube root of value  
		result = Math.pow(3,2); // returns power  
		result = Math.floor(9.999); // reduce to lower decimal  
		result = Math.ceil(9.009); // to the higher decimal  
		result = Math.round(9.5);  
		result = Math.round(9.49);  
		result = Math.abs(+9.999);  
		result = Math.abs(-9.999);  
		result = Math.random(); // returns a random double value
     ```

12. Print 10 random values between 0-100 to monitor (multiply Math.random() value by 100 and downcast to int)
13. Write a method to compare 2 persons (coded in problem 5) based on age.
      ```java
      public class PersonComparator{
	      public static int comparePersons(Person p1, Person p2){
		      //impl code
	      }
      }
      ```

    Return -ve if age of first person is less than age of second
    Return +ve if age of first person is greater than second
    Return 0 if age of both are the same.
    In main(), create 4 person objects and then using the PersonComparator, compare them and print who is elder to whom.

***Steps to program:***
1. Capture problem statement
2. Build test cases -> When doing so, come up with number of inputs,ask questions on what type of data, what range of data and then come up with success,boundary,failure input/output cases.
3. Build the method signature (ret type+method name+arg list)
4.  Build the pseudocode. This means write down the steps of how you know to solve the problem on paper in english statements.
5. Implement the pseudocode as code! Convert english statements! to actual code in programming language. Keep track of how datatypes, operators, control statements work during this translation.
6. Test the code using the test cases.
7. Refactor to improve the quality of the code

***Logical Programs***

**Simple**
1. WAM to test whether a given number ends with an odd digit not divisible by 3. Follow steps to program.
2. WAM to test whether number given is a power of 3 (Repetitively divide by 3 and its   quotient and check if remainder is 0 until quotient becomes <3)
3. WAP to test whether a given input int number is a square.
   first find the sqrt of the num
   double d = Math.sqrt(num);
   if (d - (int)d) = = 0) then it is a square
   or
   if (((int)d)*((int)d) == num) then is square
   Do you understand this pseudocode? If not, ask the instructors.
   **Average**
3. WAM to add a number and its reversed digits number and return the sum, ex: if input is 1234 then add 1234+4321 and return the sum.
4. Generate a String with random number of 10 digits in it and return it.
5. Check if a number contains increasing digits. Ex: 1234, 156, 1239, etc. The number should not even contain equal digits.
6. WAP to test if a given number is prime.
7. WAP to generate all primes within an positive int number given. Can you reuse the method coded for 6th problem?
8. WAP to test number of bits set to 1 in a positive int given.
    ```java
	    public static int noOf1Bits(int num){  
		    int count=0;  
		  
		    while (num > 0){  
		        if((num & 1) == 1) //do you understand this?  
				  count++;  
		        num = num >> 1;  
		    }  
	  
		    return count;  
		}
    ```
**Slightly more complex:**
9. WAP to identify if an int number is a palindrome. Generate all palindromes from 10 till 1 million and print to monitor.
10. WAP to test whether 2 numbers given as inputs contains the same digits, for ex: 121, 112, 211 contain the same digits
11. WAP to test GCD of 2 int numbers given as parameter