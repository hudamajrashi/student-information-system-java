package FinalProject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.Scanner;

public class PatientInformationSystem {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PatientDB database = new PatientDB();
    private static final FileManager fileManager = new FileManager();
    private static final Login login = new Login();

    public static void main(String[] args) {
     
        fileManager.loadPatientsFromFile(database);

        if (!authenticateUser()) {
            System.out.println("Login failed. Exiting the system.");
            return;
        }

        
        showMenu(); //displayMenu

        fileManager.savePatientsToFile(database.getAllPatients());
    }

    private static boolean authenticateUser() {
        System.out.print("Please enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password Please make sure: ");
        String password = scanner.nextLine();

        return login.authentication(username, password);
    }

    private static void showMenu() {
        while (true) {
            System.out.println("\n Welcome To PIS Menu");
            System.out.println("1. Register New Patient");
            System.out.println("2. Enter to Search Patient by ID");
            System.out.println("3. Enter to Search Patients by Diagnosis");
            System.out.println("4. Enter to Update Patient Diagnosis");
            System.out.println("5. Enter to Remove a Patient");
            System.out.println("6. Display All available Patients");
            System.out.println("7. Generate Report");
            System.out.println("8. Update Patient HealthIndicators");
            System.out.println("9. Out");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {  //Options 
                case 1:
                    addNewPatient();
                    break;
                case 2:
                    searchPatientById();
                    break;
                case 3:
                    searchPatientsByDiagnosis();
                    break;
                case 4:
                    updatePatientDiagnosis();
                    break;
                case 5:
                    removePatient();
                    break;
                case 6:
                    displayAllPatients();
                    break;
                case 7:
                    generatePatientReporting();
                    break;
                case 8:
                    updatePatientHealthIndicators();
                    break;
                case 9:
                    System.out.println("Good Bye");
                    return;
                default:
                    System.out.println("Soory wrong option try again");
            }
        }
    }

    
    private static void addNewPatient() {    //adding new patient
       System.out.print("What is FullName? ");
        String fullname = scanner.nextLine();
        System.out.print("what is the gender?");
        String sex = scanner.nextLine();
        System.out.print("Enter the Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter the ID Number: ");
        String id = scanner.nextLine();
        System.out.print("What the Diagnosis: ");
        String diagnosis = scanner.nextLine();

        database.addNewPatient(new Patient(fullname,sex, age, id, diagnosis));
    }

    // Search for patient by ID Number
    private static void searchPatientById() {
        System.out.print("Enter Patient ID Number for searching: ");
        String id = scanner.nextLine();
        Patient patient = database.searchAboutPatientUsingId(id);
        if (patient != null) {
            System.out.println(patient);
        } else {
            System.out.println("Soory patient not exiest.");
        }
    }

    // Search patients by diagnosis
    private static void searchPatientsByDiagnosis() {
        System.out.print("What the diagnosis? enter to search: ");
        String diagnosis = scanner.nextLine();
        List<Patient> patients = database.searchPatientsByDiagnosis(diagnosis);
        if (!patients.isEmpty()) {
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        } else {
            System.out.println("Soory there is No patients found with diagnosis: " + diagnosis);
        }
    }

                            // Update patient diagnosis
    private static void updatePatientDiagnosis() {
        System.out.print("Please Enter Patient ID Number to update them: ");
        String id = scanner.nextLine();
        System.out.print("Please Enter The new Diagnosis: ");
        String newDiagnosis = scanner.nextLine();
        database.updateTheDiagnosisOfPatient(id, newDiagnosis);
    }

                            // Remove a patient
    private static void removePatient() {
        System.out.print("Please Enter the ID for patient to remove: ");
        String id = scanner.nextLine();
        database.removePatient(id);
    }

                            // show all patients
    private static void displayAllPatients() {
        List<Patient> patients = database.getAllPatients();
        if (!patients.isEmpty()) {
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        } else {
            System.out.println("Sorry there is no patients to display them.");
        }
    }

    
    private static void generatePatientReporting() {   //method for generate report about patient
        System.out.println("\n~~~ Patient Report ~~~");
        List<Patient> patients = database.getAllPatients();
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    
    private static void updatePatientHealthIndicators() {  //update HealthIndicators
        System.out.print("Pleaase Enter Patient ID Number to update HealthIndicators: ");
        String id = scanner.nextLine();   // to enter id
        Patient patient = database.searchAboutPatientUsingId(id);
        if (patient != null) {
            System.out.print("What the Temperature in (°C)? ");
            double temperature = scanner.nextDouble(); 
            System.out.print("How much the Heart Rate (bpm)? ");
            int heartRate = scanner.nextInt();
            scanner.nextLine();
            System.out.print("How much the Blood Pressure (such as, 120/80)?");
            String bloodPressure = scanner.nextLine();
            System.out.print("Enter Respiratory Rate (breaths/min): ");
            int respiratoryRate = scanner.nextInt();
            scanner.nextLine(); // add new line

            patient.setHealthIndicators(temperature, heartRate, bloodPressure, respiratoryRate);
            System.out.println(" updated successfully for Patient Health Indicators ");
        } else {
            System.out.println("Soory patient not exist ");
        }
    }
}
