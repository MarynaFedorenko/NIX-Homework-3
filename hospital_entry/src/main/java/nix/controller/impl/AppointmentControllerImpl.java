package nix.controller.impl;

import nix.controller.AppointmentController;
import nix.data.Appointment;
import nix.repository.AppointmentRepository;
import nix.repository.impl.AppointmentRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class AppointmentControllerImpl  implements AppointmentController {
    private final AppointmentRepository appointmentRepository = new AppointmentRepositoryImpl();
    public static List<Appointment> appointmentList = new ArrayList<>();


    @Override
    public Appointment findById(String id) {
        return appointmentRepository.findById(id);
    }



    @Override
    public Appointment findByDoctorId(String doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    @Override
    public Appointment findByPatientId(String patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }
    @Override
    public void saveOrUpdate(Appointment appointment) {
        int counter = 0;
        if(appointmentList.size()!= 0){
            for(int i=0 ;i <appointmentList.size(); i++){
                if(appointment.getDoctorId().equals(appointmentList.get(i).getDoctorId()) &&
                appointment.getPatientId().equals(appointmentList.get(i).getPatientId())){

                    appointmentRepository.update(appointment);
                }
                else { counter++;}

            }
            if(counter==appointmentList.size()) {
                appointmentList.add(appointment);
                appointmentRepository.save(appointment);
            }
        }
        else  {
            appointmentList.add(appointment);
            appointmentRepository.save(appointment);
        }
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public void remove(String id) {
        appointmentRepository.remove(id);
    }
}
