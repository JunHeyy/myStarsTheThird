import java.time.*;
import java.io.Serializable;

public class Timeslot implements Serializable{

    private int day;
    private LocalTime startTime;
    private LocalTime endTime;
    private String weeks;

    public Timeslot(int day, LocalTime startTime, LocalTime endTime, String weeks) {
    	this.day = day;
    	this.startTime = startTime;
    	this.endTime = endTime;
        this.weeks = weeks;
	}

	public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public LocalTime getStartTime() {
        return this.startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getEndTime() {
        return this.endTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public String getWeeks() {
        return this.weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }

    @Override
    public boolean equals (Object o) { 
        if (o instanceof Timeslot){
            Timeslot t = (Timeslot) o;
            LocalTime s = t.getStartTime();
            LocalTime e = t.getEndTime();
            int d = t.getDay();
            if ((startTime.compareTo(endTime) < 0 && endTime.compareTo(s) <= 0 && s.compareTo(e) < 0 && d == day) || (s.compareTo(e) < 0 && e.compareTo(startTime) <= 0 && startTime.compareTo(endTime) < 0 && d == day)|| d != day) {  
                return false;
            }
            else {
                return true;
            }
        }
        return false; 
    }
}