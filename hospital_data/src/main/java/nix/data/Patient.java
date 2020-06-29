package nix.data;

public class Patient extends AbstractData<Patient>{
    private String patientId;
    private String fullName;
    public static long counter = 0;

    public Patient(){
        counter++;
        this.patientId = String.valueOf(counter);
    }

    public String getPatientFullName() {
        return fullName;
    }

    public void setPatientFullName(String fullName) {
        this.fullName = fullName;
    }



    @Override
    public String toString() {
        return "Patient{" + "patientId = "+patientId+
                ", fullName= " + fullName + '}';
    }




    public String getPatientId() {
        return patientId;
    }


    public class Health{
        private boolean isHealthy;

        public boolean getIsHealthy() {
            return isHealthy;
        }

        public void setHealthy(boolean healthy) {
            isHealthy = healthy;
        }

    }
}
