package nix.repository;

import nix.data.Patient;

public interface PatientRepository extends AbstractRepository<Patient> {
    Patient findByPatientId (String patientId);
    Patient findByPatientFullName(String fullName);
}
