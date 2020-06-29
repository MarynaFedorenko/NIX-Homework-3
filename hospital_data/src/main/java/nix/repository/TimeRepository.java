package nix.repository;


import nix.data.Time;

public interface TimeRepository  extends AbstractRepository <Time>{
    Time findByStartTime (String startTime);
    Time findByEndTime (String endTime);
}
