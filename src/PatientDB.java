package FinalProject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;

public class PatientDB {
    private List<Patient> Allpatients;

    public PatientDB() {
        this.Allpatients = new ArrayList<>();
    }

    public void addNewPatient(Patient patient) {  //method using to add patients
        Allpatients.add(patient);
        System.out.println("Patient has been added successfully to the system"); // if patinet adding show the masseg
    }

    public Patient searchAboutPatientUsingId(String id) {
        for (Patient patient : Allpatients) {
            if (patient.returnId().equals(id)) {
                return patient;
            }
        }
        return null;
    }

    public List<Patient> searchPatientsByDiagnosis(String diagnosis) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : Allpatients) {
            if (patient.returnTheDiagnosis().equalsIgnoreCase(diagnosis)) {
                result.add(patient);
            }
        }
        return result;
    }

    public void updateTheDiagnosisOfPatient(String id, String newDiagnosis) {
        Patient patient = searchAboutPatientUsingId(id);
        if (patient != null) {
            patient.setDiagnosis(newDiagnosis);
            System.out.println("Thanks The Patient diagnosis was update successful.");
        } else {
            System.out.println("Soory not found the patient");
        }
    }

    public void removePatient(String id) {
        Patient patient = searchAboutPatientUsingId(id);
        if (patient != null) {
            Allpatients.remove(patient);
            System.out.println("Thank You Patient was removed successfl");
        } else {
            System.out.println("Soory The Patient not found");
        }
    }

    public List<Patient> getAllPatients() {
        return Allpatients;
    }
}
