package nix.data;

public final class Time extends AbstractData<Time>{
    private String timeId;
    private String startTime = "00:00";
    private String endTime = "00:15";
    public static long counter = 0;

    public Time(){
        counter++;
        this.timeId = String.valueOf(counter);
    }


    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public String getTimeId() {
        return timeId;
    }

    public void setTimeId(String timeId) {
        this.timeId = timeId;
    }
}
