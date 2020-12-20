package Group3.Combined;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Sean Currie, Courtney Curry, Aine O'Doherty on 08/12/2020
 * Super Class holding basic instance variable and constructors
 * to build patient objects
 **/

abstract public class Patient
{
   //----Class objects
   static DecimalFormat df = new DecimalFormat("00");
   static Scanner keyboard = new Scanner(System.in);


   //----class constants and vars
   static final String PATIENTHEADER = "\nPATIENT DETAILS";
   static final int DOB = 3;
   static int noOfPatients = 0;


   //----instance vars
   private String name;
   private String address;
   private int [] dateOfBirth = new int [DOB];
   private int patientId = 1000;

   //Courtney
   private String response;
   private String date;
   private String symptoms;
   private String diagnosis;
   private String prescription;
   private String prescribe;
   //Courtney

   //----Constructors
   public Patient()
   {
      noOfPatients++;
      patientId = patientId + noOfPatients;
   }//default

   public Patient(String pName, String pAddress, int [] pDateOfBirth)
   {
      name = pName;
      address = pAddress;
      //assigning indexes from passed array parameter
      for (int index = 0; index < DOB; index++)
      {
         dateOfBirth[index] = pDateOfBirth[index];
      }//for
      noOfPatients++;
      patientId = patientId + noOfPatients;
   }//Alternative


   //----Set & Get Methods
   protected void setName(String pName)
   {
      name = pName;
   }//setName

   protected String getName()
   {
      return name;
   }//setName

   protected void setAddress(String pAddress)
   {
      address = pAddress;
   }//setAddress

   protected String getAddress()
   {
      return address;
   }//setAddress

   //methods sets date of birth held in the array
   protected void setDateOfBirth(int [] pDateOfBirth)
   {
      for (int index = 0; index < DOB; index++)
      {
         dateOfBirth[index] = pDateOfBirth[index];
      }//for
   }//setDateOfBirth

   protected int[] getDateOfBirth()
   {
      return dateOfBirth;
   }//getDateOfBirth


   protected void setPatientId(int pPatientId)
   {
      patientId = pPatientId;
   }//setPatientId

   protected int getPatientId()
   {
      return patientId;
   }//setPatientId


   //Courtney
   protected String getResponse() { return response; }//getResponse

   protected void setResponse(String pResponse) { response = pResponse; }//setResponse

   protected String getSymptoms() { return symptoms; }//getSymptoms

   protected void setSymptoms(String pSymptoms) { symptoms = pSymptoms; }//setSymptoms

   protected String getDate() { return date; }//getDate

   protected void setDate(String pDate) { date = pDate; }//setDate

   protected String getDiagnosis() { return diagnosis; }//getDiagnosis

   protected void setDiagnosis(String pDiagnosis) { diagnosis = pDiagnosis; }//setDiagnosis

   protected String getPrescription() { return prescription; }//getPrescription

   protected void setPrescription(String pPrescription) { prescription = pPrescription; }//setPrescription

   protected String getPrescribe() { return prescribe; }//getPrescribe

   protected void setPrescribe(String pPrescribe) { prescribe = pPrescribe; }//setPrescribe
   //Courtney

   //----Additional Methods

   abstract protected String getPatientType();

   protected String printDOB()
   {
      return (df.format(dateOfBirth[0]) + "-" + df.format(dateOfBirth[1]) + "-" + dateOfBirth[2]);
   }//printDOB

   // method for doctor to input basic patient details
   protected void prescribePatient() {
      System.out.println("\nUPDATING PATIENT CONDITION: " + name.toUpperCase());
      System.out.println("Enter main symptoms below for patient records: ");
      symptoms = keyboard.nextLine();
      System.out.println("If known, please state diagnosis, otherwise specify as unknown.");
      diagnosis = keyboard.nextLine();
      if (diagnosis.equalsIgnoreCase("unknown")) {
         System.out.println("Consider referral or rebook appointment.");
      } else {
         System.out.println("Diagnosis saved.");
      }//else
      System.out.println("Is prescription required? (YES/NO)");
      prescription = keyboard.nextLine();
      if (prescription.equalsIgnoreCase("Yes"))
      {
         System.out.println("Please enter prescription: ");
         prescribe = keyboard.nextLine();
      }//if
      else if (prescription.equalsIgnoreCase("No")) {
         System.out.println("No prescription required.");
      }//elseif
   }//prescribePatient

   //method to try...catch date format
   protected static boolean validDate(String APPOINTMENT) {
      DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
      Date DATE = null;
      df.setLenient(false);

      try {
         DATE = df.parse(APPOINTMENT);
         return true;
      }

      catch(Exception e) {
         return false;
      }
   }//validDate

   //method for doctor to book next appointment
   protected String bookAppointment() {
      String reschedule = "null";
      System.out.println("\nSCHEDULING APPOINTMENT");

      System.out.println("Does patient require further appointment? (YES/NO): ");
      response = keyboard.nextLine();
      if (response.equalsIgnoreCase("Yes")) {
         do  {
            System.out.println("Please enter date for new appointment: ");

            date = keyboard.nextLine();

            if (validDate(date))
            {
               System.out.println("Appointment made, letter to inform of time will be sent to patient");
            }//if
            else
               {
                  System.out.println("Invalid date entered, please try again.");
               }//else

         } while (!validDate(date));
      }//if
      else if  (response.equalsIgnoreCase("No")) {
         System.out.println("No further appointment required, thank you. ");
      }//if
      else if (!response.equalsIgnoreCase("Yes") && (!response.equalsIgnoreCase("No")))  {
         System.out.println("Please try again, incorrect response");
      }//if

      return reschedule;
   }//bookAppointment

   protected void printDiagnosis()
   {
      System.out.println("\nDETAILS OF DIAGNOSIS");
      System.out.println("Appointment reschedule required: " + response);
      if (response.equalsIgnoreCase("Yes")) {
         System.out.println("Date of rescheduled appointment: " + date);
      }
      else if (response.equalsIgnoreCase("No")) {
         System.out.println("No appointment required.");
      }
      System.out.println("Main symptoms: " + symptoms);
      System.out.println("Diagnosis: " + diagnosis);
      System.out.println("Prescription required: " + prescription);
      if (prescription.equalsIgnoreCase("Yes")) {
         System.out.println("Prescription: " + prescribe);
      } else {
         System.out.println("No prescription required");
      }
   }//printDiagnosis


   public String toString()
   {
      return ("\n" + PATIENTHEADER +
            "\nName: " + name +
            "\nAddress: " + address +
            "\nDate of Birth: " + printDOB()) +
            "\nPatient ID: " + getPatientId();
   }//toString

   static protected int numOfPatients()
   {
      return noOfPatients;
   }//numOfPatients

} //class
