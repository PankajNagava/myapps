package com.example.form;

public class formModal {

    // variables for our courseName,
    // description, tracks and duration, id.
    private String name;
    private String dob;
    private String salary;
    private int id;

    // creating getter and setter methods
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDob()
    {
        return dob;
    }

    public void setDob(String dob)
    {
        this.dob = dob;
    }

    public String getSalary()
    {
        return salary;
    }

    public void setSalary(String salary)
    {
        this.salary = salary;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    // constructor
    public formModal(String name, String dob, String salary,int id)
    {
        this.name = name;
        this.dob = dob;
        this.salary = salary;
        this.id=id;
    }
}
