package nix.controller.impl;

import nix.controller.TimeController;
import nix.data.Time;

import nix.repository.TimeRepository;
import nix.repository.impl.TimeRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class TimeControllerImpl implements TimeController {
    private final TimeRepository timeRepository = new TimeRepositoryImpl();
    public static List<Time> timeList = new ArrayList<>();

    @Override
    public Time findByStartTime(String startTime) {
        return timeRepository.findByStartTime(startTime);
    }

    @Override
    public Time findByEndTime(String endTime) {
        return timeRepository.findByEndTime(endTime);
    }

    @Override
    public void saveOrUpdate(Time time) {
        int counter = 0;
        if(timeList.size()!= 0){
            for(int i=0 ;i <timeList.size(); i++){
                if(time.getStartTime().equals(timeList.get(i).getStartTime()) &&
                        time.getEndTime().equals(timeList.get(i).getEndTime())){
                    timeRepository.update(time);
                }
                else { counter++;}

            }
            if(counter==timeList.size()) {
                timeList.add(time);
                timeRepository.save(time);
            }
        }
        else  {
            timeList.add(time);
            timeRepository.save(time);
        }
    }

    @Override
    public Time findById(String id) {
        return timeRepository.findById(id);
    }

    @Override
    public List<Time> findAll() {
        return timeRepository.findAll();
    }

    @Override
    public void remove(String id) {
        timeRepository.remove(id);
    }
}
