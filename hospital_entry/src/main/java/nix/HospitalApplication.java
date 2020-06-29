package nix;

import nix.config.ApplicationEnvironment;
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
import java.util.Random;

import java.util.*;
import java.util.Map;


public class HospitalApplication {
    private final DoctorController doctorController = new DoctorControllerImpl();
    private final PatientController patientController = new PatientControllerImpl();
    private final AppointmentController appointmentController = new AppointmentControllerImpl();
    private final TimeController timeController = new TimeControllerImpl();

    private static Random random;




    public void dataBuilder() {
        MonitoringSystem generalStart = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Мониторинг всей записей стартовал!");
            }
        };
        for (Map.Entry<String, String> entry : ApplicationEnvironment.getBundleProperties(ApplicationEnvironment.getPropertyLang()).entrySet()) {
            random = new Random();

            Doctor doctor = new Doctor();
            String doctorNameProperties = String.join(" ", entry.getKey().split("_"));
            doctor.setDoctorFullName(doctorNameProperties);

            StringTokenizer str = new StringTokenizer(entry.getValue(), ";");
            doctorController.saveOrUpdate(doctor);

            System.out.println();
            System.out.println("Doctor full name = " + doctor.getDoctorFullName());


            while(str.hasMoreTokens()==true){
                Time time = new Time();
                String startTime = String.valueOf(9+random.nextInt(17))+":"+String.valueOf(random.nextInt(59));
                String endTime = String.valueOf(9+random.nextInt(17))+":"+String.valueOf(random.nextInt(59));
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

                System.out.println("Patient full name = " + patient.getPatientFullName());
                System.out.println("Appointment id = " + appointment.getId());
                System.out.println("Visiting starts at " + time.getStartTime());
                System.out.println("Visiting ends at " + time.getEndTime());
                System.out.println("Result: patient is " + (health.getIsHealthy()? "healty" :" ill"));
                System.out.println();



            }
        }
        MonitoringSystem generalFinish = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Мониторинг всей записей окончен!");
            }
        };




//        doctorController.findAll().forEach(Doctor -> {
//            System.out.println();
//            System.out.println("Doctor id = " + Doctor.getDoctorId());
//            System.out.println("Doctor full name = " + Doctor.getDoctorFullName());
//            System.out.println();
//        });
//        patientController.findAll().forEach(Patient -> {
//            System.out.println();
//            System.out.println("Patient id = " + Patient.getPatientId());
//            System.out.println("Patient full name = " + Patient.getPatientFullName();
//            System.out.println();
//        });
//        appointmentController.findAll().forEach(Appointment -> {
//            System.out.println();
//            System.out.println("Appointment id = " + Appointment.getId());
//            System.out.println("Doctor id = " + Appointment.getDoctorId());
//            System.out.println("Patient id = " + Appointment.getPatientId());
//            System.out.println();
//        });
    }


    public DoctorController getDoctorController() {
        return doctorController;
    }

    public PatientController getPatientController() {
        return patientController;
    }

    public AppointmentController getAppointmentController() {
        return appointmentController;
    }
}
