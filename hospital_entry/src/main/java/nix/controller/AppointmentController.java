package nix.controller;

import nix.data.Appointment;

public interface AppointmentController extends AbstractController<Appointment>{
    Appointment findById(String id);
    Appointment findByDoctorId(String doctorId);
    Appointment findByPatientId(String patientId);
}
