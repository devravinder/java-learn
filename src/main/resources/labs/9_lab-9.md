

# Packages ( Practicles - 9 )


*Read HowToPackages.txt first before doing the below exercises.*

1. Create a class Person and make it belong to com.paravar.acc package. Create a class Account and make it belong to com.paravar.acc package. Create a subclass of Account called BankAccount and make it belong to com.paravar.acc.bank package.
   A Person has a Account (polymorphic has-a).
   Create a class TestAcc and make it belong to com.paravar.test package.Create a main() with Account ref pointing to BankAccount object. Now create a Person object and associate with the BankAccount object as his account.

   Some important scenarios to check (all compilation & execution should be done with -cp option):

2. Animal belongs to zoo package. Animal has a String name which is  given package scope. Create a TestAnimal in zoo package with main(). Create Animal a = new Animal and see if you can SOP(a.name). Can you access name or not? Why? Now put TestAnimal in test package. Recompile. Now can you access a.name from outside package? Create a Hippo and make it extend Animal in same zoo package. Hippo can sing. In sing(), can you directly access name or not? check. Now mark String name as protected. Recompile. Create a Horse extends Animal in zoo.riders package. A Horse can run. In run(), print the name directly. Can you access protected name in subclass in different package or not? Why? Create a TestHorse with main() in zoo.riders package. Create Horse h = new Horse() in main() and check if you can print h.name. Does it work? why not?
   Now in Horse->run()->Animal a = new Animal(); SOP(a.name); Are you able to compile this? Check. (Please note that subclasses can directly access parents protected state but not after object creation).
   Remember accèss specifiers dictates access and not existence.

  
