package nix.controller;

import nix.data.Patient;

public interface PatientController  extends AbstractController<Patient> {
    Patient findByPatientId (String patientId);
    Patient findByPatientFullName(String fullName);
}
