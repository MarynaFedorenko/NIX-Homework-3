package nix.controller;

import nix.data.Patient;
import nix.data.Time;

public interface TimeController extends AbstractController<Time> {
    Time findByStartTime (String startTime);
    Time findByEndTime (String endTime);
}
