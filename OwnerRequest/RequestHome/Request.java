package com.example.smartvanproject;

public class Request {
    private int requestId;
    private String requestDate;
    private String vanId;
    private String fname;
    private String lname;
    private String location;
    private String school;
    private int childId;

    public Request(int requestId, String requestDate, String vanId, int childId,String fname, String lname, String location, String school){
        this.setRequestId(requestId);
        this.setRequestDate(requestDate);
        this.setVanId(vanId);
        this.setChildId(childId);
        this.setFname(fname);
        this.setLname(lname);
        this.setLocation(location);
        this.setSchool(school);
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getVanId() {
        return vanId;
    }

    public void setVanId(String vanId) {
        this.vanId = vanId;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }
    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
