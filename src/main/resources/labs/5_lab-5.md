

# Constructors, Initializers ( Practicles - 5 )


*Constructors, Initializers*

1. Create a Child class. A Child has a name (String) and age (int). Create a TestChild class with main(). Create an object of Child and see if you can access name and age directly (using reference) to set thevalue and print the values.
   Now mark the name and age in Child class private. Now try to recompile TestChild. Will compiler allow to access private marked variables to class user? Now create setter/getter methods to both name and age. Validate that name should not be null, blank and length of name should not be more than 30. Validate age such that it shouldn't be negative or > 100. Now in main() of tester class, invoke setter and try to pass bad values, compile and test the output. Are you getting correct error messages getting printed out? Now create a Person no-arg constructor and put an SOP in it in Person class
   ```java
	public Child()
	{
		SOP(“in Child no-arg constr”);
	}
   ```

   Recompile Child.java and run TestChild. Do you see the SOP getting printed out? Recall when constructor body will be executed in object creation. Create another object of Person. Is the SOP printed again? How many times is a constructor executed per object? Add another 2 constructors in Person which accepts name as parameter and name,int as param
   ```java
	   public Child(String name)
		{
		SOP(“in Child string param constr”);
	   //how to assign local variable name to instance variable name?
		}
		
		public Child(String name, int age)!
		{
		/* 
		how to invoke Child(String) constructor to reuse?
		which stmt it be only?
		try to put it to next stmt and see if it compiles?
		*/
		SOP(“in person string,int param constr”);

		//assign the age local variable to instance variable.
		}
   ```

   Now create a Child object in main() by giving name, age as “Ramu”,10 to constructor. Comment out other code, compile and run. How many constructors got executed? What SOPs are you seeing and why? Do you understand one constructor can invoke another of same class using "this(..)"? Ask questions if you have doubts in this.
   Now I want you to validate name and age in constructors too. But think how to reuse the validation in both constructors and setters?
   Next we need to keep a track of number of objects created of Child no
   matter which constructor is used to create the object. What kind of variable will you create count as (single copy?)? Where will you increment it so that no matter which constructor is executed, count gets incremented by one. Test by creating Child objects in a for loop of 100 and see if the count gets incremented as well.

2. Create a class X. Create an int field a and assign 10 to it. Create an instance initializer and put in SOP("in inst init 1 a = "+a); and change a value to 20.
   Create another instance initializer and put in SOP("in inst init 2 a = "+a); and change a value to 30. Create a no-arg constructor, print value of a and then assign 40 to it.
   In a Tester class, in main()-> create object of X and then print obj.a to the monitor. Do you understand how the initialisation is happening? Now add a static variable in X named b = 15. Create 2 static init where you print the value of b and change them like earlier. Add printing of X.bin Tester class and then run it. Do you understand now how the initialisation is occurring. Create one more object of X and see if the static initial-
   izers are getting fired.
   See this below code only after following the instructions above.
   ```java
	   class X {  
		    int a=10;  
		    static int b=15;  
		  
		    static {  
		        System.out.println("static block-1 b="+b);  
		        b=25;  
			   }  
			    {  
		        System.out.println("instance block-1 a="+a);  
		        a=20;  
			    }  
			    {  
		        System.out.println("instance block-2 a="+a);  
		        a=30;  
		        // b=35; // un-comment and see  
				 }  
		  
		    static {  
		        System.out.println("static block-2 b="+b);  
		        b=45;  
		        // a=40 // un-comment and see // error  
			  }  
		  
		    public X(){  
		        System.out.println("constructor a="+a);  
		        a=50;  
		    }  
	}
   ```

3. (if you did not program this already) Create a class Song. A song has a name (String) and lyrics (String). A song can be played. When you play, it prints out its lyrics to monitor. Create the class with 2 instancevariables with 2 setter / getter methods (setName(String str), setLyrics(String n), getName(), getLyrics(). Make sure to validate for null and empty string). Now create a TestSong class with main(). Create 2 objects of Song and set different names and lyrics. Invoke play() and verify if the songs are playing correctly. Now invoke setter methods to change the lyrics and invoke play() again. Has the lyrics changed or not? Now create a paramterized constructor to accept both name and lyrics in Song class. Put an SOP in the constructor as well. Compile Song.java. Try to recompile TestSong.java. Is the compilation succeeding? Why not? Change your code in TestSong to create 2 song objects by passing parameters to constructors. Comment out the setter methods used. Now recompile and run the program. Do you understand the usage of Constructors now? Add another constructor to Song to be accept only name as parameter. Can we have multiple constructor in the same class? Put SOP in this constructor too. In TestSong, create another Song object by passing only name. Check by calling play() as to what is the lyrics being printed. Why so? Now invoke setLyrics() and pass a lyrics string as param. Invoke play() again on the same object. Do you now understand why to have setter methods still in a class that contains constructors?
   Make sure you validate in constructors too.

4. Create a Joke class. A Joke has a text and has print functionality (text instance variable and print()). When you invoke print() on a Joke object, the text will be printed to the monitor. Mark the text variable private, expose setter/getter and have a parameterised constructor to pass in the text during Joke object creation time. Keep a track of Joke objects that are created. How will you create a single copy count variable? Where
   will you increment it? Test in a tester class by creating a few Joke objects and printing Joke.count to monitor.

5. *important problem if you have not done so already* A person has a name, Car, Dog and a favourite Song (reuse classes Car, Dog and Song from earlier problems given in last Lab). When you ask a Person to commute and give him a destination (String parameter), then he will start the car, drive the car and stop the car and print that he has reached
   the destination. When you ask the person to sing, he will sing (print) his
   favourite song with lyrics. When you ask a person to take a walk, he will take his dog for a walk and the dog will bark. Person has the ability to eat Food. Food has name and price. Food must be given to Person when you invoke eat(). When a person is asked to eat, he will specify that he is eating food with name and say out his name as well. Person
   also has a generatePrime() behaviour. When you give him a number as input, then he will generate all prime numbers until that number and print to monitor.

6. *important* There are Bags. You can use the bag to store items (for which the user of the bag will give max number of items at construction time). You can then retrieve items from the bag. An item has a name and a price. Caps, notebooks, pens, lipstick are all names of items. A bag can be used to search for a given item. You can request the bag to give you the total of prices of all the items in the bag. Write a tester class to test creation of bags, items, then add items into the bags and invoke thevarious methods of bag to test how to search, retrieve, get total, get individual price of items.
   ```
	   Item
	      price
	      name
	   public Item(String name, double price) {  
		    this.name = name;  
		    this.price = price;  
		}
	   
	   Bag
		    String name;  
			Item[] items;  
			int count; // to track items count
		    public Bag(String name, int maxSize) {  
			    this.name = name;  
			    this.items = new Item[maxSize];  // why this
			}
			public void addItem{}
			public boolean searchItem( String name)
			{
				// loop over items & compare item name
			}
			public double getItemPrice( String name){
			}
			public Item getItem( int position){
				// get item at the given position
			}
			public double getTotal(){
				// return sum of all items prices
			}
   ```

7. Try wrapper class usage in main(). How to convert an int to an object?
    ```
	    int i = 10;
		Integer iob = Integer.valueOf(i); // boxing!
		int j = iob.intValue(); // unboxing. Print j.
    ```

   Do the same for doubles and boolean and check.
   Now do the same with autoboxing, for ex:
   ```
	  int i = 10;
	  Integer iob = i;
	  int j = iob;
   ```

   Do you understand how this works? try the same for double and boolean.
   Try using Integer.parseInt(args[0]) to convert String to int and while running the program pass 1 command line input and see if the parsing happens correctly.
   Now write the logic to accept a double as input from command line and
   print its square root, cube root to monitor. Also print whether it is a whole
   number (how will you find this out?).