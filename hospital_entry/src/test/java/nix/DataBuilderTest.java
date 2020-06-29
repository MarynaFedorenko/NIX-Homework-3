package nix;


import nix.controller.AppointmentController;
import nix.controller.DoctorController;
import nix.controller.PatientController;
import nix.controller.TimeController;
import nix.controller.impl.AppointmentControllerImpl;
import nix.controller.impl.DoctorControllerImpl;
import nix.controller.impl.PatientControllerImpl;
import nix.controller.impl.TimeControllerImpl;
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
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;



import nix.config.ApplicationEnvironment;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DataBuilderTest {

    private final DoctorController doctorController = new DoctorControllerImpl();
    private final PatientController patientController = new PatientControllerImpl();
    private final AppointmentController appointmentController = new AppointmentControllerImpl();
    private final TimeController timeController = new TimeControllerImpl();
    private static Random random;



    public void build(){
            for (Map.Entry<String, String> entry : ApplicationEnvironment.getBundleProperties(ApplicationEnvironment.getPropertyLang()).entrySet()) {
                random = new Random();

                Doctor doctor = new Doctor();
                String doctorNameProperties = String.join(" ", entry.getKey().split("_"));
                doctor.setDoctorFullName(doctorNameProperties);

                StringTokenizer str = new StringTokenizer(entry.getValue(), ";");
                doctorController.saveOrUpdate(doctor);

                System.out.println();
                System.out.println("Doctor id = " + doctor.getDoctorId());
                System.out.println("Doctor full name = " + doctor.getDoctorFullName());


                while(str.hasMoreTokens()==true){
                    Time time = new Time();
                    String startTime = (9 + random.nextInt(17)) +":"+ random.nextInt(59);
                    String endTime = (9 + random.nextInt(17)) +":"+ random.nextInt(59);
                    time.setStartTime(startTime);
                    time.setEndTime(endTime);

                    Appointment appointment = new Appointment();

                    Patient patient = new Patient();
                    String patientFullName = str.nextToken();
                    patient.setPatientFullName(patientFullName);
                    Patient.Health health = patient.new Health();
                    health.setHealthy(random.nextBoolean());

                    appointment.setDoctorId(doctor.getDoctorId());
                    appointment.setPatientId(patient.getPatientId());

                    patientController.saveOrUpdate(patient);
                    timeController.saveOrUpdate(time);
                    appointmentController.saveOrUpdate(appointment);

                    System.out.println("Patient id = " + patient.getPatientId());
                    System.out.println("Patient full name = " + patient.getPatientFullName());
                    System.out.println("Appointment id = " + appointment.getId());
                    System.out.println("Visiting starts at " + time.getStartTime());
                    System.out.println("Visiting ends at " + time.getEndTime());
                    System.out.println("Result: patient is " + (health.getIsHealthy()? "healty" :" ill"));
                    System.out.println();

                }
            }

    }

    @Test
    public void saveOrUpdateDoctor(){
        build();
        Doctor doctor = new Doctor();
        doctor.setDoctorFullName("Denn Ritchie");
        doctorController.saveOrUpdate(doctor);
        doctorController.saveOrUpdate(doctor);
        assertEquals(doctorController.findAll().size(), 6);
        Doctor doctor2 = new Doctor();
        doctor2.setDoctorFullName("Den Ritchie");
        doctorController.saveOrUpdate(doctor2);
        assertEquals(doctorController.findAll().size(), 7);

    }



    @Test
    public void findByAppointmentId(){
        build();
        assertEquals("2", appointmentController.findById("12").getDoctorId());
    }
    @Test
    public void findByDoctorId(){
        build();
        assertEquals("James Gosling", doctorController.findById("4").getDoctorFullName());
    }
    @Test
    public void findByPatientId(){
        build();
        assertEquals("Joanna Kingsman", patientController.findById("14").getPatientFullName());
    }

    @Test
    public void findByDoctorFullName(){
        build();
        assertEquals("1", doctorController.findByDoctorFullName("Robert Martin").getDoctorId());
    }

    @Test
    public void findByPatientFullName(){
        build();
        assertEquals("3", patientController.findByPatientFullName("Stefania Backer").getPatientId());
    }



}
