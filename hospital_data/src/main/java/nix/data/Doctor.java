package nix.data;

public class Doctor extends AbstractData<Doctor> {

        private String doctorId;
        private String doctorFullName;
        public static long counter = 0;

       public Doctor(){
           counter++;
           this.doctorId = String.valueOf(counter);
       }
    public String getDoctorId() {
        return doctorId;
    }


    public String getDoctorFullName() {
        return doctorFullName;
    }

    public void setDoctorFullName(String doctorFullName) {
        this.doctorFullName = doctorFullName;
    }
}
