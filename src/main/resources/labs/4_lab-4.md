

# Strings & Arrays ( Practicles - 4 )


*First compile and run TestStringMethods.java given as example. Go through the code to recap the methods on String we discussed in class and verify if you understand how it is working. In case you have any doubt, ask the Lab Instructor. Methods that you need to use are given in the bottom of the document as well. You can also go through other given.java files (TestStringMethods.java, TestMath.java,AddArrayElements.java).*

1. WAP to create an array with 10 size and of int holding ability. Store values 1-10 in it. Using the length variable, access each element of the array and print it to the console. Create the array in 2 ways -
    1. using the new operator and then storing the values individually
    2. by creating the array with the values directly in the array.

   Loop over the array using an index variable.Also loop over it using for-each loop.
   ```java  
		 int[] arr1 = new int[10]; // to create an empty array  
		 int[] arr2 = {10,20,30}; // to create a literal array 
		 for(int i = 0 ; i < arr1.length ; i++) // to loop over the array" 
			 System.out.println("value in "+i+"th box = "+arr1[i]); 
	      for(int val : arr2)  
		 System.out.println(val);  
   ```  
2. Write a main() program to test methods of string to perform the following ( take two string inputs from command line args):
    1. check its length
    2. print all the chars in string one at a time
    3. convert string to array of chars and print chars
    4. convert string to uppercase and lowercase and print
    5. take 2 strings and check if they are equal (create 2 strings directly in main())
    6. take 2 strings and check which is bigger or lesser (alphabetical comparison)
    7. take 2 strings and find out if one string occurs in other. Print the first occurring index
    8. Create a String object using new operator and using a string literal and print out its value using SOP to the console
    9. Take the input of a strings from the command line args and print "You have a good name," if the length of the full name is < 12 chars and "You have a very long name" if the length of the full name is >=12 chars. If no input has been given, show an appropriate error message. ( full name = concate both strings )

3. WAP in main() to test Math.sqrt(), Math.cbrt(), Math.random(), Math.pow() usage. See TestMath.java for sample code.
    1. Ability to add 2 ints
    2. Ability to add n ints (take an array of ints as parameter)
    3. Ability to add n doubles
    4. Ability to add 2 complex numbers. Create a Complex class with 2 int instance variables a and b. a represents the real part and b the imaginary.

4. WAP (directly in main()) to create an array of strings with 5 colors as values. Use Math.random() to randomly print out 5 values from the array.
5. Person has a name and age. A person has a number of pet names(20max) which he obtains over a period of time. He can dance; if his age is less than 25 he can do chacha. If his age is greater than 25, he does the waltz. He can sing too and when he is asked to sing, he uses his petnames to form the song (randomly). Write a tester program to test persons.

   See this below code only after trying to solve the problem on your first. This is important.
   ```java  
	  class Person {    
        String name;    
        int age;    
        String[] petNames = new String[20];    
        private int namesCount;    
    
        public String sing(){    
          String song = "";    
          for(int i = 0; i < namesCount; i++)    
            song += " " + petNames[(int)(Math.random()* namesCount)];    
          return song;    
        }    
    
        public void addPetName(String name) {    
            if(namesCount < petNames.length)    
                petNames[namesCount++] = name;    
            else System.out.println("Pat names are enough");    
    
        }    
    
        public boolean searchPetName(String name) {    
            for( String petName: petNames)    
                if(petName.equals(name))    
                    return true;    
            return false;    
        }    
    }  
   ```  
   Understand the correct working of this solution properly. Take assistance of Lab Instructors if required. Ask specific questions.

6. WAM to pass 2 arrays of ints to a method. The method should return the max value present across both the array elements.
7. WAM to pass 2 arrays of ints to a method. The method should return the average of the values across the 2 arrays. The avg returned should be exact and not an approximation.
8. WAM to swap first and last chars of a passed string and return it.  
   char at length-1 + substring from 1, length-1 + char at 0  
   str.charAt(str.length()-1) + str.substr(1,str.length()-1) +str.charAt(0)
9. WAM to test whether a given string is a palindrome.
10. WAM to count the number of words in a String.
11. Take an array as input to a method. Return the second biggest number as output from the method.
12. Do the following with String leteral, String Builder, new String
    1. Create 2 strings as literals with same state and check this
         ```java
	         String s1 = "abc";  
			 String s2 = "abc"; System.out.println(s1==s2);
         ```
       Then create a string object using
        ```java
            String s3 = new String("abc");   
            System.out.println(s1==s3);
        ```
       Why are you getting true and false as result? Do you understand? Now check s1.equals(s3) and print the result. What are you getting and why?
    2.
    ```java  
	     String s4 = "happynew";    
         s4.concat("year");    
         System.out.println(s4); // what is printed? why?"  
    ``` 
    3. Create StringBuilder sb = new StringBuilder(); Test working of sb.append(“abc”), sb.reverse(), sb.toString(), sb.replace() methods.

13. WAP to swap two ints
    1. using tem variable
    2. addition & subtraction approach
    3. swapping using xor (^) approach
14. Reverse a String
    1. using concat by reading each char from end
    2. using StringBuilder class
    3. swapping chars in the char array using xor
15. WAM to accept a string as input and return only unique characters in it (nonrepeating) in an array. (commonly asked programming question)
16. Given a long sequence of limited symbols, Compress the string as shown in the example  
    i/p : xxxxxxxgggggggggmmckkkllxx"  
    o/p : x7g9m2c1k3l2x2 (symbol followed by number of occurrences)
17. Create a method to accept a string as parameter and return a new string with all the unicode int values with a dot delimiter. Ex: input is abd, output should be 97.98.100
18. Code a method to reverse the case of a given string. Ex: aBc%12x => AbC%12X should be output.
19. Create an IntStack class. An IntStack can be used to push(int), int pop(). An IntStack can hold a max of 10 ints. Think and create IntStack class and test it for correct working. What should it have to hold all the ints pushed into it?


***Methods to use:***
20. int len = str.length()
21.
   ```java  
	    for (int i = 0 ; i < str.length() ; i++)  
		 char c = str.charAt(i);
   ```  
3. char[] arr = str.toCharArray();
4. String s1 = str.toUpperCase(); // str.toLowerCase();
5. boolean result = s1.equals(s2)
6. int pos = s1.indexOf(s2)
7. boolean result = s1.contains(s2)
8. int pos = s1.indexOf(<int pos>, s2) // -1 if search fails
9. String[] sa = str.split(" "); // splits the string on space token
10. int[] arr = {10,20,30}; // int literal array
11. String[] arr = new String[]{"rosey","posey”}; // String literal array
12.
 ```java  
for(String s : arr)
    SOP(s); 
``` 
13.
```java  
for(int i = 0 ; i < arr.length ; i++)
    SOP(arr[i]);
```  

***Things to remember:***
22. String is a class in Java (capital S)
23. length is a variable in an array and method in a string (arr.length ,str.length())
24. You have to capture the returned value from a method to use it: `Stringname=per.getName();` just calling per.getName() will not give you the value.
25. method names of String are fixed. You have to use proper naming convention (camel case).