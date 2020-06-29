package nix.repository.impl;

import nix.data.Appointment;
import nix.repository.AppointmentRepository;
import nix.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;

public class AppointmentRepositoryImpl  implements AppointmentRepository {
    public static List<Appointment> appointmentList = new ArrayList<>();


    @Override
    public Appointment findById(String id) {
        for(int i=0; i<appointmentList.size();i++){
            if(appointmentList.get(i).getId().equals(id)){
                return appointmentList.get(i);
            }
        }
        return null;
    }

    @Override
    public Appointment findByDoctorId(String doctorId) {
        for(int i=0; i<appointmentList.size();i++){
            if(appointmentList.get(i).getDoctorId().equals(doctorId)){
                return appointmentList.get(i);
            }
        }
        return null;
    }

    @Override
    public Appointment findByPatientId(String patientId) {
        for(int i=0; i<appointmentList.size();i++){
            if(appointmentList.get(i).getPatientId().equals(patientId)){
                return appointmentList.get(i);
            }
        }
        return null;
    }

    @Override
    public void save(Appointment appointment) {
        appointmentList.add(appointment);
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentList;
    }

    @Override
    public void update(Appointment appointment) {
        appointmentList.forEach(currentAppointment -> {
            if (appointment.getId().equals(currentAppointment.getId())) {
                currentAppointment.setDoctorId(currentAppointment.getDoctorId());
                currentAppointment.setPatientId(currentAppointment.getPatientId());
                Appointment.counter--;
            }
        });
    }

    @Override
    public void remove(String id) {
        appointmentList.removeIf(Appointment -> Appointment.getId().equals(id));
    }


}
