package nix.controller.impl;

import nix.controller.DoctorController;
import nix.data.Doctor;
import nix.repository.DoctorRepository;
import nix.repository.impl.DoctorRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class DoctorControllerImpl implements DoctorController {
    private final DoctorRepository doctorRepository = new DoctorRepositoryImpl();
    public static List<Doctor> doctorList = new ArrayList<>();


    @Override
    public Doctor findByDoctorId(String doctorId){
        return doctorRepository.findByDoctorId(doctorId);    }

    @Override
    public Doctor findByDoctorFullName(String fullName) {
        return doctorRepository.findByDoctorFullName(fullName);
    }

    @Override
    public void saveOrUpdate(Doctor doctor) {
        int counter = 0;
        if(doctorList.size()!= 0){
            for(int i=0 ;i <doctorList.size(); i++){
                if(doctor.getDoctorFullName().equals(doctorList.get(i).getDoctorFullName())){
                    doctorRepository.update(doctor);
                }
                else { counter++;}
            }
            if(counter==doctorList.size()) {
                doctorList.add(doctor);
                doctorRepository.save(doctor);
            }
        }
        else  {
            doctorList.add(doctor);
            doctorRepository.save(doctor);
        }




//        if(doctorList.size()!= 0){
//            doctorList.forEach(currentDoctor -> {
//                int count = 0;
//                if (doctor.getDoctorFullName().equals(currentDoctor.getDoctorFullName())) {
//                    count++;
//                }
//                if(count>0){
//
//                    doctorRepository.update(doctor);}
//                else {
////                    doctorList.add(doctor);
//                    doctorRepository.save(doctor);}
//            });
//        }
//        else  {
////            doctorList.add(doctor);
//            doctorRepository.save(doctor);
//        }
    }

    @Override
    public Doctor findById(String id) {

            return doctorRepository.findById(id);
    }

    @Override
    public List<Doctor> findAll() {
            return doctorRepository.findAll();
    }

    @Override
    public void remove(String id) {
            doctorRepository.remove(id);
    }
}
