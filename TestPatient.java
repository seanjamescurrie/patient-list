package Group3.Combined;

import LectureTestsArraysOfObjects.Member;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by Sean Currie on 9/12/2020
 * TestPatient application to take in patient details, assign to correct age bracket
 * and store an array of that bracket (minor/adult/senior)
 **/

public class TestPatient
{
   //----class objects
   static Scanner keyboard = new Scanner(System.in);

   //----patient object arrays
   static final int MAXPATIENTS = 2;
   static Minor[] minor = new Minor[MAXPATIENTS];
   static Adult[] adult = new Adult[MAXPATIENTS];
   static Senior[] senior = new Senior[MAXPATIENTS];


   //----class vars & constants
   static final int DOB = 3, ADULT = 18, SENIOR = 65;
   static boolean correct;
   static boolean covidRisk = false;
   static int minorsIndex = 0, adultsIndex = 0, seniorsIndex = 0;
   static int [] dateOfBirth = new int[DOB];
   static String name, address;


   //----Class methods

   //method for entering patient details
   protected static void enterDetails()
   {
      System.out.println("\nPATIENT INFORMATION");
      System.out.print("Please enter name: ");
      name = keyboard.nextLine();
      System.out.print("Please enter address: ");
      address = keyboard.nextLine();
      System.out.print("Please enter date of birth: ");
      System.out.print("\nDay (DD): ");
      dateOfBirth[0] = keyboard.nextInt();
      keyboard.nextLine();
      System.out.print("Month (MM): ");
      dateOfBirth[1] = keyboard.nextInt();
      keyboard.nextLine();
      System.out.print("Year (YYYY): ");
      dateOfBirth[2] = keyboard.nextInt();
      keyboard.nextLine();
   }//enterDetails

   //method for confirming patient details
   protected static boolean confirmDetails(String pConfirm)
   {
      correct = true;
      char confirm;

      System.out.print(pConfirm);
      System.out.println("\nName: " + name);
      System.out.println("Address: " + address);
      System.out.println("DOB: " + dateOfBirth[0] + "-" + dateOfBirth[1] + "-" + dateOfBirth[2]);

      System.out.print("Are these details correct? (Y/N): ");
      confirm = keyboard.nextLine().toUpperCase().charAt(0);
      if (confirm == 'N')
      {
         correct = false;
      }//if
      return correct;
   }//checkDetails

   //create patient object arrays and objects
   protected static void createPatient()
   {
      Calendar today = Calendar.getInstance();

      //if patient is 65 or over make senior object
      if ((today.get(Calendar.YEAR) - dateOfBirth[2]) >= 65)
      {

         String nextOfKin;
         System.out.print("\nEnter next of kin: ");
         nextOfKin = keyboard.nextLine();
         senior[seniorsIndex] = new Senior(name, address, dateOfBirth, nextOfKin);
         System.out.println("\n" + name + ", your doctor is " + senior[seniorsIndex].getDoctor() + ".");
         seniorsIndex++;
      }//ifOver65

      //else if patient is under 18 make minor object
      else if ((today.get(Calendar.YEAR) - dateOfBirth[2]) < 18)
            {
               String guardian;
               System.out.print("\nEnter guardian: ");
               guardian = keyboard.nextLine();
               minor[minorsIndex] =  new Minor(name, address, dateOfBirth, guardian);
               System.out.println("\n" + name + ", your doctor is " + minor[minorsIndex].getDoctor());
               minorsIndex++;
            }//elseifUnder18

            //else make adult object
            else
               {
                  int dependents;
                  System.out.print("\nEnter number of dependents: ");
                  dependents = keyboard.nextInt();
                  keyboard.nextLine();
                  adult[adultsIndex] = new Adult(name, address, dateOfBirth, dependents);
                  System.out.println("\n" + name + ", your doctor is " + adult[adultsIndex].getDoctor());
                  adultsIndex++;
               }//elseAdult
   }//createPatient

   //Direct to waiting room
   protected static void directToWaitingRoom()
   {
      System.out.println("Please follow the signs and take a seat in the waiting room.\n");
   }//directToWaitingRoom

   //Aine
   public static void covidScreening()
   {
      covidRisk = false; //reset everytime it is run
      char covidScreen;
      String nextScreen = "Thank you, please continue.\n\n";
      //keyboard.nextLine();
      System.out.println("\nCOVID19 CHECK");
      System.out.println("Have you tested positive for Coronavirus in the last 14 days? (Y/N): ");
      covidScreen = keyboard.nextLine().charAt(0);
      if (covidScreen=='N'||covidScreen=='n')
      {
         System.out.println("Have you had a new, continuous cough, or loss of your sense of taste or smell? (Y/N):");
         covidScreen = keyboard.nextLine().charAt(0);
         if (covidScreen=='N'||covidScreen=='n')
         {
            System.out.println("Have you had a high temperature in the last 14 days? (Y/N): ");
            covidScreen = keyboard.nextLine().charAt(0);
            if (covidScreen=='N'||covidScreen=='n')
            {
               System.out.println("Has anyone in your family or close contacts had Coronavirus symptoms? (Y/N):");
               covidScreen = keyboard.nextLine().charAt(0);
               if (covidScreen=='N'||covidScreen=='n')
               {
                  System.out.println("Have you been contacted by Track and Trace and asked to self isolate? (Y/N): ");
                  covidScreen = keyboard.nextLine().charAt(0);
                  if (covidScreen=='N'|| covidScreen=='n')
                  {
                     System.out.print(nextScreen);
                  }
                  else if (covidScreen=='Y'||covidScreen=='y')
                  {
                     System.out.println("Please exit the surgery, contact NHS 111 for more advice on Coronavirus.\n\n");
                     covidRisk = true;
                  }
               }
               else if (covidScreen=='Y'||covidScreen=='y')
               {
                  System.out.println("Please exit the surgery, contact NHS 111 for more advice on Coronavirus.\n\n");
                  covidRisk = true;
               }
            }
            else if (covidScreen=='Y'||covidScreen=='y')
            {
               System.out.println("Please exit the surgery, contact NHS 111 for more advice on Coronavirus.\n\n");
               covidRisk = true;
            }
         }
         else if (covidScreen=='Y'||covidScreen=='y')
         {
            System.out.println("Please exit the surgery, contact NHS 111 for more advice on Coronavirus.\n\n");
            covidRisk = true;
         }
      }
      else if (covidScreen=='Y'||covidScreen=='y')
      {
         System.out.println("Please exit the surgery, contact NHS 111 for more advice on Coronavirus.\n\n");
         covidRisk = true;
      }
   }//covidScreening
   //Aine

   //find a minor patient using PatientID
   protected static Minor findMinor(int pId)
   {
      int index = 0;
      Minor foundMinor = null;
      //search minors
      while (index < Minor.noOfMinors)
      {
         if (minor[index].getPatientId() == pId)
         {
            foundMinor = minor[index];
         }//if
         index++;
      }//while
      return foundMinor;
   }//findMinor

   //find an adult patient using PatientID
   protected static Adult findAdult(int pId)
   {
      int index = 0;
      Adult foundAdult = null;
      while (index < Adult.noOfAdults)
      {
         if (adult[index].getPatientId() == pId)
         {
            foundAdult = adult[index];
         }//if
         index++;
      }//while
      return foundAdult;
   }//findAdult

   //find a senior patient using PatientID
   protected static Senior findSenior(int pId)
   {
      int index = 0;
      Senior foundSenior = null;
      while (index < Senior.noOfSeniors)
      {
         if (senior[index].getPatientId() == pId)
         {
            foundSenior = senior[index];
         }//if
         index++;
      }//while
      return foundSenior;
   }//findAdult


   //----Main Method
   public static void main(String[] args)
   {
      //----declaring variables & objects
      //variables and constants
      final int TERMINATOR = 999;
      int num = 0;
      int id;
      Minor searchMinor;
      Adult searchAdult;
      Senior searchSenior;

      //Covid Check and Collecting patient info and creating object
      do
      {
         //loop for next patient while covidRisk is true
         do
         {
            //Covid check - AINE
            covidScreening();
         } while (covidRisk);

         //collecting & confirming details - loop if incorrect
         do
         {
            enterDetails();
            confirmDetails("\nCONFIRM DETAILS");
         } while (!(correct));

         //call to method assigning to relevant object
         createPatient();
         //direct to waiting room
         directToWaitingRoom();

         System.out.print("Enter 0 to enter next patient (999 to exit loop): ");
         num = keyboard.nextInt();
         keyboard.nextLine();
      } while (num != TERMINATOR);

      //----Functionality for doctor's access to patient info
      System.out.println("\n *** UPDATING INFO - DOCTOR FUNCTIONALITY ***");


      //----MINOR TESTING
      //Selecting minor patient and updating details
      System.out.println("\nPATIENT LIST:  DR. BRANDON");
      System.out.println("Number of patients: " + Minor.numOfMinors());
      for (int index = 0; index < Minor.numOfMinors(); index++)
      {
         System.out.println("Name: " + minor[index].getName() + "\t\tPatient ID: " + minor[index].getPatientId());
      }//for

      //selecting patient ID from printed list
      System.out.print("\nEnter Patient ID: ");
      id = keyboard.nextInt();
      keyboard.nextLine();
      searchMinor = findMinor(id);
      //diagnosing
      searchMinor.prescribePatient();
      //booking appointment
      searchMinor.bookAppointment();
      //printing details
      System.out.println(searchMinor);
      searchMinor.printDiagnosis();


      //----ADULT TESTING
      //Selecting minor patient and updating details
      System.out.println("\nPATIENT LIST:  DR. PEISTE");
      System.out.println("Number of patients: " + Adult.numOfAdults());
      for (int index = 0; index < Adult.numOfAdults(); index++)
      {
         System.out.println("Name: " + adult[index].getName() + "\t\tPatient ID: " + adult[index].getPatientId());
      }//for

      //selecting patient ID from printed list
      System.out.print("\nEnter Patient ID: ");
      id = keyboard.nextInt();
      keyboard.nextLine();
      searchAdult = findAdult(id);
      //diagnosing
      searchAdult.prescribePatient();
      //booking appointment
      searchAdult.bookAppointment();
      //printing details
      System.out.println(searchAdult);
      searchAdult.printDiagnosis();


      //----SENIOR TESTING
      //Selecting senior patient and updating details
      System.out.println("\nPATIENT LIST:  DR. CARRAUNTOOHIL");
      System.out.println("Number of patients: " + Senior.numOfSeniors());
      for (int index = 0; index < Senior.numOfSeniors(); index++)
      {
         System.out.println("Name: " + senior[index].getName() + "\t\tPatient ID: " + senior[index].getPatientId());
      }//for

      //selecting patient ID from printed list
      System.out.print("\nEnter Patient ID: ");
      id = keyboard.nextInt();
      keyboard.nextLine();
      searchSenior = findSenior(id);
      //diagnosing
      searchSenior.prescribePatient();
      //booking appointment
      searchSenior.bookAppointment();
      //printing details
      System.out.println(searchSenior);
      searchSenior.printDiagnosis();

   } //main
} //class
