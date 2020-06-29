package nix.repository.impl;

import nix.data.Doctor;
import nix.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;

public class DoctorRepositoryImpl implements DoctorRepository {
    public static List<Doctor> doctorList = new ArrayList<>();


    public Doctor findByDoctorId(String doctorId) {
        for(int i=0; i<doctorList.size();i++){
            if(doctorList.get(i).getDoctorId().equals(doctorId)){
                return doctorList.get(i);
            }
        }
        return null;
    }

    @Override
    public Doctor findByDoctorFullName(String fullName) {
        for(int i=0; i<doctorList.size();i++){
            if(doctorList.get(i).getDoctorFullName().equals(fullName)){
                return doctorList.get(i);
            }
        }
        return null;
    }


    public void save(Doctor doctor) {
        doctorList.add(doctor);
    }

    public Doctor findById(String id) {
        for(int i=0; i<doctorList.size();i++){
            if(doctorList.get(i).getDoctorId().equals(id)){
                return doctorList.get(i);
            }
        }
        return null;
    }

    public List<Doctor> findAll() {
        System.out.println(doctorList.size());
        return doctorList;
    }

    public void update(Doctor doctor) {
        doctorList.forEach(currentDoctor -> {
            if (doctor.getDoctorId().equals(currentDoctor.getDoctorId())) {
                currentDoctor.setDoctorFullName(doctor.getDoctorFullName());
                Doctor.counter--;
            }
        });
    }

    public void remove(String id) {
        doctorList.removeIf(Doctor -> Doctor.getDoctorId().equals(id));
    }
}
