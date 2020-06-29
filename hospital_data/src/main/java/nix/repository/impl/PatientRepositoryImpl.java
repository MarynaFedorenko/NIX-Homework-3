package nix.repository.impl;

import nix.data.Doctor;
import nix.data.Patient;
import nix.repository.PatientRepository;

import java.util.ArrayList;
import java.util.List;

public class PatientRepositoryImpl implements PatientRepository{
    public static List<Patient> patientList = new ArrayList<>();

    public Patient findByPatientId(String patientId) {
        for(int i=0; i<patientList.size();i++){
            if(patientList.get(i).getPatientId().equals(patientId)){
                return patientList.get(i);
            }
        }
        return null;
    }


    public Patient findByPatientFullName(String fullName) {
        for(int i=0; i<patientList.size();i++){
            if(patientList.get(i).getPatientFullName().equals(fullName)){
                return patientList.get(i);
            }
        }
        return null;
    }

    public void save(Patient patient) {
        patientList.add(patient);
    }

    public Patient findById(String id) {
        for(int i=0; i<patientList.size();i++){
            if(patientList.get(i).getPatientId().equals(id)){
                return patientList.get(i);
            }
        }
        return null;
    }

    public List<Patient> findAll() {
            return patientList;
    }

    public void update(Patient patient) {
        patientList.forEach(currentPatient -> {
            if (patient.getPatientId().equals(currentPatient.getPatientId())) {
                currentPatient.setPatientFullName(patient.getPatientFullName());
                Patient.counter--;
            }
        });
    }

    public void remove(String id) {
        patientList.removeIf(Patient -> Patient.getPatientId().equals(id));
    }
}
