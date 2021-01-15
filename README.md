# Contents

[Project Outline](#project-outline)

[ User Guide](#user-guide)

# Project Outline

A group project as part of an MSc in Professional Software Development. This application is a patient intake list at a doctors surgery. Screening incoming patients symptons of COVID19. Prompting for and taking personal details from the user and storing these details. Additional diagnosis details can be entered by another user intended to be a doctor accessing the system from another interface.

**My Role:**

Taking on the role of project lead and compiling code created by all individuals.

The structure of the application is:
1. COVID screening questions
2. Patient/user inputs details
3. Doctor chooses patient  and enters diagnosis

We compiled the code for the class files individually and combined the best elements.

I created the main method, organised the code and methods created by others so it could function successfully. Sections in the main method are controlled with do..while loops and boolean variables which are assigned values in the methods called within the loops. With the methods created by others being altered where necessary.

Having declared 3 object arrays at the beginning of the application, each representing the age brackets the surgery handled. Each brackets corresponding doctor was assigned in its class application. A method was used to create an object in the relevant array based on the age entered by patient/user.

A method for each array was defined to print the details of the patients in an array and prompt for a patient ID. Searching through the array for an object with the same instance variable value it allows the object to be updated using a method defined by another in the group.


# User Guide

## Section 1: COVID19 Check

Answer questions by entering single letter (not case sensitive) i.e.

>*“Have you tested positive for Coronavirus in the last 14 days? (Y/N): N”*

Entering ‘Y’ will send a message to exit surgery and loop the COVID19 check.



## Section 2: Patient Enters Information

Enter name, address and DOB.

You will be asked to confirm details by entering ‘Y’ or ‘N’. **If answer is ‘N’ this section will loop until correct/'Y' is entered.**

Depending on year born, patient will be assigned to a doctor’s list (Minors, Adults or Seniors) and asked for 1 piece of additional information.

After each patient enters details they will be notified of their doctor.

Prompted to enter 0 to continue entering patients or 999 to move onto section that will simulate how a doctor will interact with the application. *(each array is set to a  maximum length of 2 indexes)*

*Use the following input information (in any order):*

|   | Minor 1 | Minor 2 | Adult 1 | Adult 2 | Senior 1 | Senior 2 |
| - | --------| ------- | ------- | ------- | -------- | -------- |
| **Name** | Josh | Mark |  Jayne | Sorcha | John | Susanne |
| **Address** | 2 Culmore | 6 Brandywell | 2 Culmore | 6 Brandywell | 5 Waterside | 5 Waterside |
| **Day** | 01 | 02 | 03 | 04 | 05 | 06 |
| **Month** | 01 | 02 | 03 | 04 | 05 | 06 |
| **Year** | 2020 | 2019 | 1992 | 1991 | 1950 | 1951 |
| **Guardian/Dependants/Next Of Kin** | Jayne | Sorcha | 1 | 1 | Jayne | Sorcha |



## Section 3: Doctor Enters Patient’s Diagnosis

### Minors
**3.A.1 Minors - Dr Brandon**

Patient list of names and IDs are printed to screen

Prompted to enter ID from list

**3.A.2 Entering Diagnosis**

Questions prompt for info regarding patient condition that take a string.

Prompt for prescription - enter “YES” or “NO”.

If YES – enter string for prescription


**3.A.3 Scheduling Next Appointment**

Prompt asking if patient requires appointment scheduled - enter “YES” or “NO”.

If YES – enter date (DD/MM/YYYY)



### Adults

**3.B.1 Adults - Dr Peiste**

Patient list of names and IDs are printed to screen

Prompted to enter ID from list

**3.B.2 Entering Diagnosis**

Questions prompt for info regarding patient condition that take a string.

Prompt for prescription - enter “YES” or “NO”.

If YES – enter string for prescription

**3.B.3 Scheduling Next Appointment**

Prompt asking if patient requires appointment scheduled - enter “YES” or “NO”.

If YES – enter date (DD/MM/YYYY)



### Seniors

**3.B.1 Seniors - Dr Carrauntoohil**

Patient list of names and IDs are printed to screen

Prompted to enter ID from list

**3.B.2 Entering Diagnosis**

Questions prompt for info regarding patient condition that take a string.

Prompt for prescription - enter “YES” or “NO”.

If YES – enter string for prescription

**3.B.3 Scheduling Next Appointment**

Prompt asking if patient requires appointment scheduled - enter “YES” or “NO”.

If YES – enter date (DD/MM/YYYY)
