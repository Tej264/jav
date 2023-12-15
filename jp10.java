/*Java Practicals
Slip 1 
Q1. Write a program to accept a number from user and generate multiplication table of a number. 
Solution:*/
import java.util.*;
class Mult
{
	public static void main(String args[])
	{
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number: ");
		num=sc.nextInt();
		System.out.println("Multipication Table");
		
		for(int i=1;i<=10;i++)
		{
			System.out.println(num+"*"+i+"="+num*i);
		}
	}
}
/*Q.2 Write a Java program to create a super class Vehicle having members Company and Price. Derive two different classes LightMotorVehicle (mileage) and HeavyMotorVehicle (capacity_in_tons). Accept the information for “n” vehicles and display the information in appropriate form. While taking data, ask user about the type of vehicle first.
Solution:*/
import java.util.Scanner;
abstract class Vehicle {
    String company;
    double price;

    Vehicle(String company, double price) {
        this.company = company;
        this.price = price;
    }

    abstract void displayInfo();
}

class LightMotorVehicle extends Vehicle {
    int mileage;

    LightMotorVehicle(String company, double price, int mileage) {
        super(company, price);
        this.mileage = mileage;
    }

    @Override
    void displayInfo() {
        System.out.println("Company: " + company);
        System.out.println("Price: " + price);
        System.out.println("Mileage: " + mileage);
    }
}

class HeavyMotorVehicle extends Vehicle {
    int capacity_in_tons;

    HeavyMotorVehicle(String company, double price, int capacity_in_tons) {
        super(company, price);
        this.capacity_in_tons = capacity_in_tons;
    }

    @Override
    void displayInfo() {
        System.out.println("Company: " + company);
        System.out.println("Price: " + price);
        System.out.println("Capacity: " + capacity_in_tons + " tons");
    }
}

public class LightMotor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String type = scanner.nextLine();
            String company = scanner.nextLine();
            double price = scanner.nextDouble();
            scanner.nextLine();

            if (type.equalsIgnoreCase("LightMotorVehicle")) {
                int mileage = scanner.nextInt();
                Vehicle vehicle = new LightMotorVehicle(company, price, mileage);
                vehicle.displayInfo();
            } else if (type.equalsIgnoreCase("HeavyMotorVehicle")) {
                int capacity_in_tons = scanner.nextInt();
                Vehicle vehicle = new HeavyMotorVehicle(company, price, capacity_in_tons);
                vehicle.displayInfo();
            }
            System.out.println();
        }
    }
}
/*OR 
Q.2 Write a class Student with attributes roll no, name, marks and. Initialize values through parameterized constructor. If marks of student is not in between 15 and 20 then generate userdefined exception ―”Marks below average”. If name contains numbers or special symbols raise exception ―Name not valid.
Solution:*/
import java.util.*;
import java.util.regex.Pattern;

class Student {
    private int rollNo;
    private String name;
    private int marks;

    public Student(int rollNo, String name, int marks) {
        if (marks < 15 || marks > 20) {
            throw new MarksBelowAverageException("Marks below average");
        }

        if (Pattern.matches("[0-9a-zA-Z\\s]+", name) == false) {
            throw new NameNotValidException("Name not valid");
        }

        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

class MarksBelowAverageException extends Exception {
    public MarksBelowAverageException(String s) {
        super(s);
    }
}

class NameNotValidException extends Exception {
    public NameNotValidException(String s) {
        super(s);
    }
}

public class StudentMarksException {
    public static void main(String[] args) {
        try {
            Student student = new Student(1, "John Doe", 17);
            System.out.println("Roll No: " + student.getRollNo());
            System.out.println("Name: " + student.getName());
            System.out.println("Marks: " + student.getMarks());
        } catch (MarksBelowAverageException e) {
            System.out.println(e.getMessage());
        } catch (NameNotValidException e) {
            System.out.println(e.getMessage());
        }
    }
}
/*Slip2
Q1. Write a program to accept ‘n’ integers from the user & store them in an Array List collection.
Display the elements of Array List.
Solution:*/
import java.util.*;
public class DisplayArray
{
    public static void main(String[] args)
    {
    	ArrayList l1 = new ArrayList<>();
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter no.of elements in list: ");
    	int n=sc.nextInt();
    	System.out.println("Enter elements in list: ");
    	for(int i=0;i<n;i++)
    	{
    		String elmt=sc.next();
    		l1.add(elmt);
    	}
    	System.out.println(l1);
    }
}
/*Q2. Define a class MyNumber having one private integer data member. Write a default constructor
initialize it to 0 and another constructor to initialize it to a value. Write methods isNegative,
isPositive, isOdd, iseven. Use command line argument to pass a value to the object and perform the
above operations.
OR
Q.2 Write a program which define class Employee with data member as id, name and salary Store
the information of n; employees and Display the name of employee having maximum salary (Use 
array of object).
Solution:*/
import java.util.*;
class Employee
{
	int id;
	String name;
	double salary;

	public Employee(int id,String name,double salary)
	{
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	
 } 
public class MainEmpSalary
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of employees: ");
		int n=sc.nextInt();
		Employee[] e = new Employee[n];
		for(int i = 0;i<n;i++)
		{
			System.out.println("Enter employee ID: ");
			int id=sc.nextInt();
			System.out.println("Enter employee name: ");
			String name=sc.next();
			System.out.println("Enter salary: ");
			double salary=sc.nextDouble();
			Employee emp=new Employee(id,name,salary);
			e[i]=emp;
		}
		double maxSalary=e[0].salary;
		Employee maxSalaryEmployee=e[0];
		for(Employee  emp: e)
		{
			if(emp.salary>maxSalary)
			{
				maxSalary=emp.salary;
				maxSalaryEmployee=emp;
			}
		}
		System.out.println("Employee with maximum salary is: "+maxSalaryEmployee.name);
	}
}
/*Slip 3 
Q.1 Write a Java Program to Reverse a Number. Accept number using command line argument. 
Solution:*/
public class ReverseNumber 
{
   	public static void main(String[] args)
	{
		if (args.length != 1) 
		{
            			System.out.println("Usage: java ReverseNumber <number>");
           			return;
        		}
		int number = Integer.parseInt(args[0]);
        		int rev = 0;

        		while (number != 0) 
		{
            			int digit = number % 10;
            			rev = rev * 10 + digit;
           			number = number / 10;
        		}
		System.out.println("Reversed number: " + rev);
    	}
}
/*Q.2 Write a program which define class Employee with data member as id, name and salary Store the information of 'n' employees and display the name of employee having maximum salary (Use array of object).
Solution:*/
import java.util.*;
class Employee
{
	int id;
	String name;
	double salary;

	public Employee(int id,String name,double salary)
	{
		this.id=id;
		this.name=name;
		this.salary=salary;
	}
	
 } 
public class MainEmpSalary
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of employees: ");
		int n=sc.nextInt();
		Employee[] e = new Employee[n];
		for(int i = 0;i<n;i++)
		{
			System.out.println("Enter employee ID: ");
			int id=sc.nextInt();
			System.out.println("Enter employee name: ");
			String name=sc.next();
			System.out.println("Enter salary: ");
			double salary=sc.nextDouble();
			Employee emp=new Employee(id,name,salary);
			e[i]=emp;
		}
		double maxSalary=e[0].salary;
		Employee maxSalaryEmployee=e[0];
		for(Employee  emp: e)
		{
			if(emp.salary>maxSalary)
			{
				maxSalary=emp.salary;
				maxSalaryEmployee=emp;
			}
		}
		System.out.println("Employee with maximum salary is: "+maxSalaryEmployee.name);
	}
}
/*OR
Q.2 Create a java application to store city names and their STD codes using an appropriate collection. i. Add a new city and its code (No duplicates) ii. Remove a city from the collection iii. Search for a cityname and display the code.
Solution:*/
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CitySTD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> citySTD = new HashMap<>();

        citySTD.put("City1", "STD001");
        citySTD.put("City2", "STD002");
        citySTD.put("City3", "STD003");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a new city and its code");
            System.out.println("2. Remove a city from the collection");
            System.out.println("3. Search for a city and display the code");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter city name: ");
                    String cityName = scanner.nextLine();
                    System.out.print("Enter STD code: ");
                    String stdCode = scanner.nextLine();
                    if (!citySTD.containsKey(cityName)) {
                        citySTD.put(cityName, stdCode);
                        System.out.println("City added successfully!");
                    } else {
                        System.out.println("City already exists!");
                    }
                    break;
                case 2:
                    System.out.print("Enter city name to remove: ");
                    String cityToRemove = scanner.nextLine();
                    if (citySTD.containsKey(cityToRemove)) {
                        citySTD.remove(cityToRemove);
                        System.out.println("City removed successfully!");
                    } else {
                        System.out.println("City not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter city name to search: ");
                    String cityToSearch = scanner.nextLine();
                    if (citySTD.containsKey(cityToSearch)) {
                        System.out.println("City: " + cityToSearch + ", STD code: " + citySTD.get(cityToSearch));
                    } else {
                        System.out.println("City not found!");
                    }
                    break;
                case 4:
                    scanner.close();
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }
}
/*Slip 4 
Q.1 Write java program to check whether number is Perfect or not. 
Solution:*/
//import java.util.Scanner;  
public class PerfectNumber 
{  
	public static void main(String args[])    
	{  
		long n=7, sum=0;  
		//Scanner sc=new Scanner(System.in);         
		//System.out.print("Enter the number: ");  
		//n=sc.nextLong();  
		int i=1;  
 
		while(i <= n/2)  
		{  
			if(n % i == 0)  
			{  
				sum = sum + i;  
			} 
			i++;  
		}
		if(sum==n)  
		{  
			System.out.println(n+" is a perfect number.");  
		}  
		else  
			System.out.println(n+" is not a perfect number.");   
	}  
}  
/*Q.2 Define a class student having rollno, name and percentage. Define Default and parameterized constructor. Accept the 5 student details and display it. (Use this keyword) 
Solution:*/
import java.util.*;
public class StudentDetails
{
 	int rollno;
 	String name;
	float percentage;
 	
	public StudentDetails(int rollno,String name,float percentage)
	{
		this.rollno=rollno;
		this.name=name;
		this.percentage=percentage;
	}
 
	 public static void main(String[] args) 
	{
 		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of student: ");
		int n=sc.nextInt();
		StudentDetails s[] = new StudentDetails[n];
  		for(int i=0; i<n; i++) 
		{
   			System.out.println("Student Roll No.: ");
			int id=sc.nextInt();	
			System.out.println("Student name: ");
			String name=sc.next();
			System.out.println("Student percentage: ");
			float percentage=sc.nextFloat();			
  		}
	 }
}
/*OR
Slip 5 
Q.1 . Write a program to accept ‘n’ integers from the user & store them in an Array List collection. Display the elements of Array List. 
Same as slip1 Q1
Q.2 . Write a program create class as MyDate with dd,mm,yy as data members. Write parameterized constructor. Display the date in dd-mm-yy format. (Use this keyword).
Solution:*/
public class MyDateSlip5 {
 int dd;
 int mm;
 int yy;
 public MyDateSlip5(int dd, int mm, int yy) {
 this.dd = dd;
 this.mm = mm;
 this.yy = yy;
 } 
 public void displayDate() {
 System.out.println(this.dd + "-" + this.mm + "-" + this.yy);
 } 
 public static void main(String[] args) {
 MyDateSlip5 myDate = new MyDateSlip5(1, 1, 2023);
 myDate.displayDate();
 } 
} 
/*OR 
Q.2 Write a program to design following GUI using JTextArea. Write a code to display number of words and characters of text in JLabel. Use JScrollPane to get scrollbars for JTextArea
Slip 6 
Q.1Write a Java program to print the sum of elements of the array. 
Solution:*/
public class SumOfArray {  
    public static void main(String[] args) {  
        int [] arr = new int [] {1, 2, 3, 4, 5};  
        int sum = 0;  
        for (int i = 0; i < arr.length; i++) {  
           sum = sum + arr[i];  
        }  
        System.out.println("Sum of all the elements of an array: " + sum);  
    }  
}  
/*Q.2 . Define a “Point” class having members – x,y(coordinates). Define default constructor and parameterized constructors. Define two subclasses “ColorPoint” with member as color and subclass “Point3D” with member as z (coordinate). Write display method to display the details of different types of Points . 
OR 
Q.2 Write a java program to accept Doctor Name from the user and check whether it is valid or not. (It should not contain digits and special symbol) If it is not valid then throw user defined Exception - Name is Invalid -- otherwise display it.
Solution:*/
import java.util.Scanner;
class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

public class DoctorNameValidation {
    static boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Doctor's Name: ");

        try {
            String doctorName = scanner.nextLine();

            if (!isValidName(doctorName)) {
                throw new InvalidNameException("Name is Invalid");
            } else {
                System.out.println("Doctor's Name: " + doctorName);
            }
        } catch (InvalidNameException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
/*Slip 7 
Q.1Write a Java program to print the factors of a given number. (Use Scanner class).
Solution:*/
import java.util.Scanner;
public class Factors {
   public static void main(String[] args) {
      int n, i;
  
      Scanner my_scanner = new Scanner(System.in);
      
      System.out.print("Enter the number : ");
      n = my_scanner.nextInt();
      System.out.print("The factors of " + n + " are: ");
      for (i = 1; i <= n; ++i) {
         if (n % i == 0) {
            System.out.print(i + " ");
         }
      }
   }
}
/*Q.2 Write a Java program to create a super class Employee (members – name, salary). Derive a subclass as Developer (member – projectname). Derive a sub-class Programmer (member – proglanguage) from Developer. Create object of Programmer and display the details of it. Implement this multilevel inheritance with appropriate constructor and methods. 
OR 
Q. 2 Create an abstract class Myshapes with methods area & volume. Derive a class Cylinder (radius, height). Calculate area and volume.
Solution:*/
import java.util.Scanner;
abstract class Myshapes {
    abstract double area();
    abstract double volume();
}

class Cylinder extends Myshapes {
    double radius;
    double height;

    Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    double area() {
        return 2 * Math.PI * radius * (radius + height);
    }

    double volume() {
        return Math.PI * radius * radius * height;
    }
}

public class MainCylinder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the radius of the cylinder: ");
        double radius = scanner.nextDouble();

        System.out.println("Enter the height of the cylinder: ");
        double height = scanner.nextDouble();

        Cylinder cylinder = new Cylinder(radius, height);

        System.out.println("The area of the cylinder is: " + cylinder.area());
        System.out.println("The volume of the cylinder is: " + cylinder.volume());
    }
}
/*Slip 8 
Q.1Write java program to check whether number is Palindrome or not. 
Solution:*/
class PalindromeExample{  
 public static void main(String args[]){  
  int r,sum=0,temp;    
  int n=454; 
  
  temp=n;    
  while(n>0){    
   r=n%10;  //getting remainder  
   sum=(sum*10)+r;    
   n=n/10;    
  }    
  if(temp==sum)    
   System.out.println("palindrome number ");    
  else    
   System.out.println("not palindrome");    
}  
}  
/*Q.2 Create an abstract class Shape with methods area & volume. Derive a class Cylinder (radius, height). Calculate area and volume.
Solution:*/
import java.util.Scanner;
abstract class Myshapes {
    abstract double area();
    abstract double volume();
}

class Cylinder extends Myshapes {
    double radius;
    double height;

    Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    double area() {
        return 2 * Math.PI * radius * (radius + height);
    }

    double volume() {
        return Math.PI * radius * radius * height;
    }
}

public class MainCylinder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the radius of the cylinder: ");
        double radius = scanner.nextDouble();

        System.out.println("Enter the height of the cylinder: ");
        double height = scanner.nextDouble();

        Cylinder cylinder = new Cylinder(radius, height);

        System.out.println("The area of the cylinder is: " + cylinder.area());
        System.out.println("The volume of the cylinder is: " + cylinder.volume());
    }
} 
/*OR 
Q.2 Write a java program to accept Doctor Name from the user and check whether it is valid or not. (It should not contain digits and special symbol) If it is not valid then throw user defined Exception - Name is Invalid -- otherwise display it.
Solution:*/
import java.util.Scanner;
class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}

public class DoctorNameValidation {
    static boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Doctor's Name: ");

        try {
            String doctorName = scanner.nextLine();

            if (!isValidName(doctorName)) {
                throw new InvalidNameException("Name is Invalid");
            } else {
                System.out.println("Doctor's Name: " + doctorName);
            }
        } catch (InvalidNameException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
/*Slip 9 
Q.1Write Java program to find multiplication of two matrix. Accept matrix from user. 
Solution:*/
import java.util.Scanner; 
public class MatrixMultiplication {
 
    public static void main(String[] args) {
        int i, j, k, rowF, rowS, colF, colS;
        int first[][] = new int[10][10];
        int second[][] = new int[10][10];
        int product[][] = new int[10][10];
 
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("Enter Rows and Cols of First Matrix");
        rowF = scanner.nextInt();
        colF = scanner.nextInt();
 
        System.out.println("Enter Elements of First Matrix");
         for (i = 0; i < rowF; i++) {
            for (j = 0; j < colF; j++) {
                first[i][j] = scanner.nextInt();
            }
        }
 
        System.out.println("Enter Rows and Cols of Second Matrix");
        rowS = scanner.nextInt();
        colS = scanner.nextInt();
 
        System.out.println("Enter Elements of Second Matrix");
         for (i = 0; i < rowS; i++) {
            for (j = 0; j < colS; j++) {
                second[i][j] = scanner.nextInt();
            }
        }
         for (i = 0; i < rowF; i++) {
            for (j = 0; j < colF; j++) {
                for (k = 0; k < colS; k++) {
                    product[i][j] += first[i][k] * second[k][j];
                }
            }
        }
         System.out.println("Product Matrix");
        for (i = 0; i < rowF; i++) {
            for (j = 0; j < colS; j++) {
                System.out.print(product[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
/*Q.2 . Define an interface “Operation” which has methods area (), volume (). Define a constant PI having a value 3.142. Create a class circle (member – radius), cylinder (members – radius, height) which implements this interface. Calculate and display the area and volume 
OR 
Q.2 Write a program which define class Student with data member as rno, name and score. Store the information of 'n' students and Display the name of student having maximum score (Use array of object).
Solution:*/
import java.util.*;
class Student
{
	int id;
	String name;
	double marks;
	public Student(int id,String name,double marks)
	{
		this.id=id;
		this.name=name;
		this.marks=marks;
	}
}

public class StudMaxMarks
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);		
		System.out.println("Enter number of students: ");
		int n=sc.nextInt();
		Student[] s=new Student[n];
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter student ID: ");
			int id=sc.nextInt();
			System.out.println("Enter student name: ");
			String name=sc.next();
			System.out.println("Enter student marks: ");
			double marks=sc.nextDouble();
			Student stud=new Student(id,name,marks);
			s[i]=stud;
		}
		double maxMarks=s[0].marks;
		Student maxStudMarks=s[0];
		for(Student stud:s)
		{
			if(stud.marks>maxMarks)
			{
				maxMarks=stud.marks;
				maxStudMarks=stud;
			}
		}
		System.out.println("Student with maximum marks is: "+maxStudMarks.name);
	}
}
/*Slip 10 
Q.1 Write a Java Program to Display Armstrong Numbers Between range. Accept range from user. 
Solution:*/
import java.util.Scanner; 
public class ArmstrongNumberWithinRange 
{ 
	public static void main(String args[]) 
	{ 
		Scanner s=new Scanner(System.in); 
		System.out.print("Enter the Range :"); 
		int range=s.nextInt(); 
		int a,b,c,sum,count=0; 
		b=1; 
		while(b<=range) 
		{ 
			sum=0; 
			c=b;  
			while(c>0) 
			{ 
				a=c%10; 
				sum=sum+(a*a*a); 
				c=c/10; 
			} 
			if(sum==b) 
                        		{ 
                          			System.out.println(b+" is a Armstrong Number"); 
                         		 	count=count+1; 
                        		} 
                           		b++; 
                      	} 
 		System.out.println("Total Armstrong Number Present With in that Range is "+count); 
                 } 
 }
/*Q.2 Accept 'n' integers from the user and store them in a collection. Display them in the sorted order. The collection should not accept duplicate elements. (Use a suitable collection). Search for a particular element using predefined search method in the Collection framework. 
Solution:*/
import java.util.TreeSet; 
import java.util.Scanner;
public class collection3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Object> ts = new TreeSet<>();

        System.out.println("Enter how many Numbers: ");
        int n = sc.nextInt();

        System.out.println("Enter the " + n + " Numbers: ");
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            ts.add(num);
        }
        System.out.println("Numbers in Sorted Order and without Duplication :" + ts);
        System.out.println("Enter element to be search: ");	
        int num = sc.nextInt();
        if(ts.contains(num))
    	{
    		System.out.println("Element is found");
    	}
    	else
    	{
    		System.out.println("Element is not found");
    	}
    }
}
/*OR 
Q.2 Define a class MyData having one private integer data member. Write a default constructor initialize it to 0 and another constructor to initialize it to a value. Write methods isNegative, isPositive, isOdd, iseven. Use command line argument to pass a value to the object and perform the above operations.*/