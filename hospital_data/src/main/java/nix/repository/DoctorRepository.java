package nix.repository;

import nix.data.Doctor;

public interface DoctorRepository extends AbstractRepository <Doctor> {
    Doctor findByDoctorId(String doctorId);
    Doctor findByDoctorFullName(String fullName);
}
