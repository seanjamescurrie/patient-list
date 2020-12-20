package Group3.Combined;

/**
 * Created by Sean Currie, Courtney Curry, Aine O'Doherty on 09/12/2020
 * Create a class holding basic instance variables and
 * constructors to build patient objects for Seniors
 **/

public class Senior extends Patient
{
   //----class vars
   static int noOfSeniors;
   static final String DOCTOR = "Dr. Carrauntoohil";

   //----instance vars
   private String nextOfKin;
   private String doctor;
   //private int patientId = 3000;


   //----Constructors
   public Senior()
   {
      noOfSeniors++;
      //patientId = patientId + noOfSeniors++;
   }//default

   public Senior(String pName, String pAddress, int [] pDob, String pNextOfKin)
   {
      super(pName, pAddress, pDob);
      nextOfKin = pNextOfKin;
      doctor = DOCTOR;
      noOfSeniors++;
      //patientId = patientId + noOfSeniors++;
   }//alternate


   //----Set & Get Methods
   protected void setNextOfKin(String pNextOfKin)
   {
      nextOfKin = pNextOfKin;
   }//setNextOfKin

   protected String getNextOfKin()
   {
      return nextOfKin;
   }//getNextOfKin

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

   //method to get age bracket
   protected String getPatientType()
   {
      return "Senior";
   }//getPatientType

   public String toString()
   {
      return (super.toString() +
            "\nType: " + getPatientType() +
            "\nGuardian: " + nextOfKin +
            "\nDoctor: " + doctor);
   }//toString

   static protected int numOfSeniors()
   {
      return noOfSeniors;
   }//numOfSenior

} //class
