package nix.controller.impl;

import nix.controller.PatientController;
import nix.data.Doctor;
import nix.data.Patient;
import nix.repository.PatientRepository;
import nix.repository.impl.PatientRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class PatientControllerImpl implements PatientController {
    private final PatientRepository patientRepository = new PatientRepositoryImpl();
    public static List<Patient> patientList = new ArrayList<>();


    @Override
    public Patient findById(String id) {
        return patientRepository.findById(id);
    }

    @Override
    public Patient findByPatientId(String patientId) {
        return patientRepository.findByPatientId(patientId);
    }

    @Override
    public Patient findByPatientFullName(String fullName) {
        return patientRepository.findByPatientFullName(fullName);
    }


    @Override
    public void saveOrUpdate(Patient patient) {
        int counter = 0;
        if(patientList.size()!= 0){
            for(int i=0 ;i <patientList.size(); i++){
                if(patient.getPatientFullName().equals(patientList.get(i).getPatientFullName())){
                    patientRepository.update(patient);
                }
                else { counter++;}

            }
            if(counter==patientList.size()) {
                patientList.add(patient);
                patientRepository.save(patient);
            }
        }
        else  {
            patientList.add(patient);
            patientRepository.save(patient);
        }
    }


    @Override
    public List<Patient> findAll() {
            return patientRepository.findAll();
    }

    @Override
    public void remove(String id) {
        patientRepository.remove(id);
    }
}
