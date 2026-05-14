package FinalProject;
import java.io.*;
import java.util.List;

public class FileManager {
	/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */
	    private static final String FileName = "PI.txt";

	    public void savePatientsToFile(List<Patient> patients) {   //save patient information at PI.txt
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FileName))) {
	            for (Patient patient : patients) {
	                writer.write(patient.getName() + "/" + patient.getAge() + "/" + patient.returnId() + "/" + patient.returnTheDiagnosis() + "/" +
	                             patient.getHealthIndicators());
	                writer.newLine();
	            }
	            System.out.println("Thanks the Patients information was saved to the file successfuly.");  //show if saved patient information
	        } catch (IOException e) {
	            System.out.println("Soory there was an error with saving patients to file: " + e.getMessage()); // show if not saved
	        }
	    }

	    public void loadPatientsFromFile(PatientDB database) {   //load all patient information
	        try (BufferedReader read = new BufferedReader(new FileReader(FileName))) {
	            String line;
	            while ((line = read.readLine()) != null) {
	                String[] data = line.split("-");
	                String name = data[0];
	                String sex =data[0];
	                int age = Integer.parseInt(data[1]);
	                String id = data[2];
	                String diagnosis = data[3];
	                String[] HealthIndicators = data[4].split(" ");
	                double temperature = Double.parseDouble(HealthIndicators[4].replace("°C,", ""));
	                int heartRate = Integer.parseInt(HealthIndicators[4].replace("bpm,", ""));
	                String bloodPressure = HealthIndicators[9];
	                int respiratoryRate = Integer.parseInt(HealthIndicators[30].replace("breaths/min", ""));
	                Patient patient = new Patient(name, sex, age, id, diagnosis);
	                patient.setHealthIndicators(temperature, heartRate, bloodPressure, respiratoryRate);
	                database.addNewPatient(patient);
	            }
	            System.out.println("Patients information loaded from file.");  // show if loaded done
	        } catch (FileNotFoundException e) {
	            System.out.println("soory no saved patients found, Please Start with NULL database");  //show if not found 
	        } catch (IOException e) {
	            System.out.println("Soory there was an Error withe loading patients from the file: " + e.getMessage());
	        }
	    }
	}


