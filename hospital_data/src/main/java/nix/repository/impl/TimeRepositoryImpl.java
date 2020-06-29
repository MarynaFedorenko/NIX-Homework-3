package nix.repository.impl;


import nix.data.Time;
import nix.repository.TimeRepository;

import java.util.ArrayList;
import java.util.List;

public class TimeRepositoryImpl implements TimeRepository {
    public static List<Time> timeList = new ArrayList<>();

    @Override
    public Time findByStartTime(String startTime) {
        for(int i=0; i<timeList.size();i++){
            if(timeList.get(i).getStartTime().equals(startTime)){
                return timeList.get(i);
            }
        }
        return null;
    }

    @Override
    public Time findByEndTime(String endTime) {
        for(int i=0; i<timeList.size();i++){
            if(timeList.get(i).getEndTime().equals(endTime)){
                return timeList.get(i);
            }
        }
        return null;
    }

    @Override
    public void save(Time time) {
        timeList.add(time);

    }

    @Override
    public Time findById(String id) {
        for(int i=0; i<timeList.size();i++){
            if(timeList.get(i).getTimeId().equals(id)){
                return timeList.get(i);
            }
        }
        return null;
    }

    @Override
    public List<Time> findAll() {
        return timeList;
    }

    @Override
    public void update(Time time) {
        timeList.forEach(currentTime -> {
            if (time.getTimeId().equals(currentTime.getTimeId())) {
                currentTime.setStartTime(time.getStartTime());
                currentTime.setEndTime(time.getEndTime());
                Time.counter--;
            }
        });
    }

    @Override
    public void remove(String id) {
        timeList.removeIf(Time -> Time.getTimeId().equals(id));
    }
}
