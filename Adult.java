package Group3.Combined;

import java.util.Scanner;

/**
 * Created by Sean Currie, Courtney Curry, Aine O'Doherty on 09/12/2020
 * Create a class holding basic instance variables and
 * constructors to build patient objects for Minors
 **/

public class Adult extends Patient
{
   //----class objects
   Scanner keyboard = new Scanner(System.in);


   //----class vars
   static int noOfAdults;
   static final String DOCTOR = "Dr. Peiste";


   //----instance vars
   private int dependents;
   private String [] dependentsNames;
   private String doctor;
   //private int patientId = 2000;


   //----Constructors
   public Adult()
   {
      noOfAdults++;
      //patientId = patientId + noOfAdults;
   }//default

   public Adult(String pName, String pAddress, int [] pDob, int pDependents)
   {
      super(pName, pAddress, pDob);
      dependents = pDependents;
      dependentsNames = new String[dependents];
      doctor = DOCTOR;
      noOfAdults++;
      //patientId = patientId + noOfAdults;
   }//alternate


   //----Set & Get Methods
   protected void setDependents(int pDependents)
   {
      dependents = pDependents;
   }//setGuardian

   protected int getDependents()
   {
      return dependents;
   }//getGuardian

   protected void setDoctor(String pDoctor)
   {
      doctor = pDoctor;
   }//setDoctor

   protected String getDoctor()
   {
      return doctor;
   }//getDoctor

   /*
   protected void setPatientId(int pPatientId)
   {
      patientId = pPatientId;
   }//setPatientId

   protected int patientId()
   {
      return patientId;
   }//setPatientId
   */

   //----Additional Methods

   //method to set the names of the Adults dependents
   protected void setDependentsNames()
   {
      for (int index = 0; index < dependents; index++)
      {
         System.out.print("Enter dependent " + (index+1) + ": ");
         dependentsNames[index] = keyboard.nextLine();
      }//for
   }//setDependentsNAmes

   //method to print a list of the Adults dependents
   protected String getDependentNames()
   {
      String names = "";
      for (int index = 0; index < dependents; index++)
      {
         names = ("\n" + dependentsNames[index]);
         names = names.concat(names);
      }//for
      return ("\nDependents Names:" + names);
   }//getDependentsNames

   //method returning patient age bracket
   protected String getPatientType()
   {
      return "Adult";
   }//getPatientType

   //printing details
   public String toString()
   {
      return (super.toString() +
            "\nType: " + getPatientType() +
            "\nDependents: " + dependents +
            "\nDoctor: " + doctor);
   }//toString

   static protected int numOfAdults()
   {
      return noOfAdults;
   }//numOfAdults

} //class
