package com.paravar.labs.lab3.demo;

/*3) Test passing reference as parameter. Create a Fish class with String
name in it. Create a Croc class with String name and a method called
eat().Accept a Fish reference as parameter. In the eat(), print both the
crocs name and fish`s name (public void eat(Fish f)). In TestPass class,
code a main() where you should create a croc object, a fish object, assign
names "cocky" and "fishy" and invoke eat() and pass fish ref as parameter.
Print the fish`s name before calling eat() and after calling eat().
Run and test.
Test the following as well:
a) in eat(), after SOP, assign f to null. Check what happens.
b) in eat(), assign f to new Fish object and assign name "Flippy". Now
check the SOPs
c) in eat(), assign f.name to "Flippy" and observe outputs. What happens
here? How are references getting passed?
d) pass null to eat() and check what happens*/
public class TesterFish {

	public static void main(String[] args) {
		Croc c=new Croc();
		c.name="cocky";
		Fish f=new Fish();
		f.name="fishy";
		System.out.println(" before calling eat the fish name is"+"  "+f.name);
		c.eat(f);
		System.out.println(" after calling eat the fish name is"+"  "+f.name);//prints the older name itself cz f is still point to older object itself
		c.eat(null);//it compiles but in runtime gives null pointer exception

	}

}
