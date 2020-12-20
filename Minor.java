package Group3.Combined;

/**
 * Created by Sean Currie, Courtney Curry, Aine O'Doherty on 09/12/2020
 * Create a class holding basic instance variables and
 * constructors to build patient objects for Minors
 **/

public class Minor extends Patient
{
   //----class vars
   static int noOfMinors;
   static String DOCTOR = "Dr. Brandon";


   //----instance vars
   private String guardian;
   private String doctor;
   //private int patientId = 1000;


   //----Constructors
   public Minor()
   {
      noOfMinors++;
      //patientId = patientId + noOfMinors;
   }//default

   public Minor(String pName, String pAddress, int [] pDob, String pGuardian)
   {
      super(pName, pAddress, pDob);
      guardian = pGuardian;
      doctor = DOCTOR;
      noOfMinors++;
      //patientId = patientId + noOfMinors;
   }//alternate


   //----Set & Get Methods
   protected void setGuardian(String pGuardian)
   {
      guardian = pGuardian;
   }//setGuardian

   protected String getGuardian()
   {
      return guardian;
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

   protected int getPatientId()
   {
      return patientId;
   }//setPatientId
   */

   //----Additional Methods

   //method to get age bracket
   protected String getPatientType()
   {
      return "Minor";
   }//getPatientType



   public String toString()
   {
      return (super.toString() +
            "\nType: " + getPatientType() +
            "\nGuardian: " + guardian +
            "\nDoctor: " + doctor);
   }//toString

   static protected int numOfMinors()
   {
      return noOfMinors;
   }//numOfMinors



} //class
