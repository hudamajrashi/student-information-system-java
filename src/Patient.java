package FinalProject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Patient extends Person { //subclass contain another detail about patient
    private String id;
    private String diagnosis;
    private double temperature;
    private int heartRate;
    private String bloodPressure;
    private int respiratoryRate;

    public Patient(String name, String sex,int age, String id, String diagnosis) {
        super(name,sex, age);
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Soory ID Number cannot be NULL"); //show the masseg if user noot enter any number
        }
        if (diagnosis == null || diagnosis.isEmpty()) {
            throw new IllegalArgumentException("Soory Diagnosis cannot be Empty");  //show the masseg if user noot enter any diagnosis
        }
        this.id = id;
        this.diagnosis = diagnosis;
        this.temperature = 0.0;
        this.heartRate = 0;
        this.bloodPressure = "";
        this.respiratoryRate = 0;
    }

    public String returnId() {
        return id;
    }

    public String returnTheDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        if (diagnosis == null || diagnosis.isEmpty()) {
            throw new IllegalArgumentException("Soory Diagnosis cannot be Empty");
        }
        this.diagnosis = diagnosis;
    }

    public void setHealthIndicators(double temperature, int heartRate, String bloodPressure, int respiratoryRate) {
        this.temperature = temperature;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.respiratoryRate = respiratoryRate;
    }

    public String getHealthIndicators() {
        return "Temperature: " + temperature + "°C, Heart Rate: " + heartRate + " bpm, Blood Pressure: " + bloodPressure + ", Respiratory Rate: " + respiratoryRate + " breaths/min";
    }

    @Override
    public String toString() {
        return super.toString() + ", ID: " + id + ", Diagnosis: " + diagnosis + ", Health Indicators: [" + getHealthIndicators() + "]";
    }
}

