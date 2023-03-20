package model;

public class SectionStudentList {
    private String name, sid;
    private int section;

    public SectionStudentList(String name, String sid, int section) {
        this.name = name;
        this.sid = sid;
        this.section = section;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
    }
}
