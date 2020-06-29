package nix;

import nix.data.Appointment;
import nix.data.Doctor;
import nix.data.Patient;
import nix.data.Time;
import nix.repository.AppointmentRepository;
import nix.repository.DoctorRepository;
import nix.repository.PatientRepository;
import nix.repository.TimeRepository;
import nix.repository.impl.AppointmentRepositoryImpl;
import nix.repository.impl.DoctorRepositoryImpl;
import nix.repository.impl.PatientRepositoryImpl;
import nix.repository.impl.TimeRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.StringTokenizer;

import static org.junit.jupiter.api.Assertions.*;

public class DataTest {
    private final DoctorRepository doctorRepository = new DoctorRepositoryImpl();
    private final PatientRepository patientRepository = new PatientRepositoryImpl();
    private final AppointmentRepository appointmentRepository = new AppointmentRepositoryImpl();
    private final TimeRepository timeRepository = new TimeRepositoryImpl();
    private static Random random;



    private void build() {
            random = new Random();

            Time time = new Time();
            String startTime = "12:30";
            String endTime = "13:30";
            time.setStartTime(startTime);
            time.setEndTime(endTime);

            Doctor doctor = new Doctor();
            doctor.setDoctorFullName("Dennis Ritchie");
            doctorRepository.save(doctor);
            System.out.println();
            System.out.println("Doctor id = " + doctor.getDoctorId());
            System.out.println("Doctor full name = " + doctor.getDoctorFullName());

            Appointment appointment = new Appointment();

            Patient patient = new Patient();
            patient.setPatientFullName("Thomas Little");
            System.out.println("Patient id = " + patient.getPatientId());
            System.out.println("Patient full name = " + patient.getPatientFullName());
            Patient.Health health = patient.new Health();
            health.setHealthy(random.nextBoolean());

            appointment.setDoctorId(doctor.getDoctorId());
            appointment.setPatientId(patient.getPatientId());


            patientRepository.save(patient);
            timeRepository.save(time);
            appointmentRepository.save(appointment);

    }


//    @Test
//    public void findAll(){
//        build();
//        assertEquals(doctorRepository.findAll().size(), 1);
//        assertEquals(patientRepository.findAll().size(), 1);
//        assertEquals(appointmentRepository.findAll().size(), 1);
//        assertEquals(timeRepository.findAll().size(), 1);
//
//    }

    @Test
    public void findByAppointmentId(){
        build();
        assertTrue(appointmentRepository.findById("1").getDoctorId().equals("1"));
    }
    @Test
    public void findByDoctorId(){
        build();
        assertTrue(doctorRepository.findById("1").getDoctorFullName().equals("Dennis Ritchie"));
    }
    @Test
    public void findByPatientId(){
        build();
        assertTrue(patientRepository.findById("1").getPatientFullName().equals("Thomas Little"));
    }

    @Test
    public void findByDoctorFullName(){
        build();
        assertTrue(doctorRepository.findByDoctorFullName("Dennis Ritchie").getDoctorId().equals("1"));
    }

    @Test
    public void findByPatientFullName(){
        build();
        assertEquals("1", patientRepository.findByPatientFullName("Thomas Little").getPatientId());
    }

    @Test
    public void findByStartTime(){
        build();
        assertEquals("1", timeRepository.findByStartTime("12:30").getTimeId());
    }

    @Test
    public void findByEndTime(){
        build();
        assertTrue(timeRepository.findByEndTime("13:30").getTimeId().equals("1"));
    }






}
