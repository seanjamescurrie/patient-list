# **User Guide:** Example Run Through

---

## Section 1: COVID19 Check

Answer questions by entering single letter (not case sensitive) i.e.

>*“Have you tested positive for Coronavirus in the last 14 days? (Y/N): N”*

Entering ‘Y’ will send a message to exit surgery and loop the COVID19 check.

---

## Section 2: Patient Enters Information

Enter name, address and DOB.

You will be asked to confirm details by entering ‘Y’ or ‘N’. **If answer is ‘N’ this section will loop until correct/'Y' is entered.**

Depending on year born, patient will be assigned to a doctor’s list (Minors, Adults or Seniors) and asked for 1 piece of additional information.

After each patient enters details they will be notified of their doctor.

Prompted to enter 0 to continue entering patients or 999 to move onto section that will simulate how a doctor will interact with the application.

*Use the following input information (in any order):*

|   | Minor 1 | Minor 2 | Adult 1 | Adult 2 | Senior 1 | Senior 2 |
| - | --------| ------- | ------- | ------- | -------- | -------- |
| **Name** | Josh | Mark |  Jayne | Sorcha | John | Susanne |
| **Address** | 2 Culmore | 6 Brandywell | 2 Culmore | 6 Brandywell | 5 Waterside | 5 Waterside |
| **Day** | 01 | 02 | 03 | 04 | 05 | 06 |
| **Month** | 01 | 02 | 03 | 04 | 05 | 06 |
| **Year** | 2020 | 2019 | 1992 | 1991 | 1950 | 1951 |
| **Guardian/Dependants/Next Of Kin** | Jayne | Sorcha | 1 | 1 | Jayne | Sorcha |

---

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

-

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

-

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
