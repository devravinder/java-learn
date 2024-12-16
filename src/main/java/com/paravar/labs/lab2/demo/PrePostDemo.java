package com.paravar.labs.lab2.demo;

class PrePostDemo {
    public static void main(String[] args){

    	int i = 3;
        i++;
        System.out.println(i);  //4
        ++i;
        System.out.println(i); //5
        System.out.println(++i); //6
        System.out.println(i++); //6
        System.out.println(i); //7
    }
}

class UnaryDemo {

    public static void main(String[] args){
        // result is now 1
        int result = +1;
        System.out.println(result);
        // result is now 0
        result--;
        System.out.println(result);
        // result is now 1
        result++;
        System.out.println(result);
        // result is now -1
        result = -result;
        System.out.println(result);
        boolean success = false;
        // false
        System.out.println(success);
        // true
        System.out.println(!success);
    }
}

class ArithmeticDemo {

    public static void main (String[] args){

        // result is now 3
        int result = 1 + 2;
        System.out.println(result);

        // result is now 2
        result = result - 1;
        System.out.println(result);

        // result is now 4
        result = result * 2;
        System.out.println(result);

        // result is now 2
        result = result / 2;
        System.out.println(result);

        // result is now 10
        result = result + 8;
        System.out.println(result);
        // result is now 3
        result = result % 7;
        System.out.println(result);
        
        int x = 10;
        int y = 4;
        System.out.println("result of div 10.0/0 = "+(0.0/0));
        
    }
}

class IfElseDemo {
    public static void main(String[] args) {

        int testscore = 60;
        char grade;

        if (testscore >= 90) {
            grade = 'A';
        } else if (testscore >= 80) {
            grade = 'B';
        } else if (testscore >= 70) {
            grade = 'C';
        } else if (testscore >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Grade = " + grade);
    }
}

class SwitchDemo {
    public static void main(String[] args) {

        int month = 11;
        String monthString;
        switch (month) {
            case 1:  monthString = "January";
                     break;
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            default: monthString = "Invalid month";
                     break;                     
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
         
        }
        System.out.println(monthString);
    }
}

class SwitchDemo2 {
    public static void main(String[] args) {

        int month = 2;
        int year = 2000;
        int numDays = 0;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 4: case 6:
            case 9: case 11:
                numDays = 30;
                break;
            case 2:
                if (((year % 4 == 0) &&
                     !(year % 100 == 0))
                     || (year % 400 == 0))
                    numDays = 29;
                else
                    numDays = 28;
                break;
            default:
                System.out.println("Invalid month.");
                break;
        }
        System.out.println("Number of Days = "
                           + numDays);
    }
}

class StringSwitchDemo {

    public static int getMonthNumber(String month) {

        int monthNumber = 0;

        if (month == null) {
            return monthNumber;
        }

        switch (month) {
            case "january":
                monthNumber = 1;
                break;
            case "february":
                monthNumber = 2;
                break;
            case "march":
                monthNumber = 3;
                break;
            case "april":
                monthNumber = 4;
                break;
            case "may":
                monthNumber = 5;
                break;
            case "june":
                monthNumber = 6;
                break;
            case "july":
                monthNumber = 7;
                break;
            case "august":
                monthNumber = 8;
                break;
            case "september":
                monthNumber = 9;
                break;
            case "october":
                monthNumber = 10;
                break;
            case "november":
                monthNumber = 11;
                break;
            case "december":
                monthNumber = 12;
                break;
            default:
                monthNumber = 0;
                break;
        }

        return monthNumber;
    }

    public static void main(String[] args) {

        String month = "august";

        int returnedMonthNumber =
            StringSwitchDemo.getMonthNumber(month);

        if (returnedMonthNumber == 0) {
            System.out.println("Invalid month");
        } else {
            System.out.println(returnedMonthNumber);
        }
    }
}

class WhileDemo {
    public static void main(String[] args){
        int count = 1;
        while (count < 11) {
            System.out.println("Count is: " + count);
            count++;
        }
        System.out.println("count = "+count);
    }
}

class DoWhileDemo {
    public static void main(String[] args){
        int count = 1;
        do {
            System.out.println("Count is: " + count);
            count++;
        } while (count < 11);
    }
}

class ForDemo {
    public static void main(String[] args){
         for(int i=1; i<11; i++){
              System.out.println("Count is: " + i);
         }
    }
}

class LeftShifty
{
	public static void main(String[] args)
	{
		int a = 2; // 000..0010 << 2
		int b = a << (33%32);   // a << 2
		System.out.println("2 << 33 => "+b);

		a = -1; // 1111111111...11
		b = a >>> 1;  // a << 1
		System.out.println("-1>>> 1 => "+b);

	}
}
class RightShifty
{
	public static void main(String[] args)
	{
		int a = 4;
		int b = a >> 2;
		System.out.println("4 >> 2 => "+b);

		a = - 2;
		b = a >> 1;
		System.out.println("-2 >> 1 => "+b);


	}
}

class UnSignedRightShifty
{
	public static void main(String[] args)
	{
		int a = 4;
		int b = a >>> 2;
		System.out.println("4 >>> 2 => "+b);

		a = - 2;
		b = a >>> 1;
		System.out.println("-2 >>> 1 => "+b);

		a = -1;
		b = a >>> 1;
		System.out.println("-1 >>> 1 => "+b);

	}
}