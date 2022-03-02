package com.github.Evgenn91.f_types_AfteRetu_AfteThro_After.objects;

public class Student {
    private String surName;
    private int course;
    private double avgGrade;

    public Student(String surName, int course, double avgGrade) {
        this.surName = surName;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "surName='" + surName + '\'' +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }
}
