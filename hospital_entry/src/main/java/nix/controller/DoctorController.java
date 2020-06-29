package nix.controller;

import nix.data.Doctor;

public interface DoctorController  extends AbstractController<Doctor>{
    Doctor findByDoctorId(String doctorId);
    Doctor findByDoctorFullName(String fullName);
}
