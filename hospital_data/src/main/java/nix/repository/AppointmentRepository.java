package nix.repository;

import nix.data.Appointment;

public interface AppointmentRepository extends AbstractRepository <Appointment> {
    Appointment findById(String id);
    Appointment findByDoctorId(String doctorId);
    Appointment findByPatientId(String patientId);
}
