package model;

public class Course {
    private int section, seat;
    private String time;

    public Course(int section, int seat, String time) {
        this.section = section;
        this.seat = seat;
        this.time = time;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
