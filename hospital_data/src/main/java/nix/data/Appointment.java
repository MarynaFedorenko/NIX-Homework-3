package nix.data;

public class Appointment extends AbstractData<Appointment> {
    private String id;
    private String doctorId;
    private String patientId;
    public static long counter = 0;

    public Appointment(){
        counter++;
        this.id = String.valueOf(counter);
    }
    @Override
    public String getId() {
        return id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}
