package com.vlazar83.dailyRJava.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "readings")
public class Reading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reading_year")
    private String readingYear;

    @Column(name = "reading_month")
    private String readingMonth;

    @Column(name = "reading_day")
    private String readingDay;

    @Column(name = "firstreading")
    private String firstReading;

    @Column(name = "firstreading_short")
    private String firstReadingShort;

    @Column(name = "firstreading_link")
    private String firstReadingLink;

    @Column(name = "secondreading")
    private String secondReading;

    @Column(name = "secondreading_short")
    private String secondReadingShort;

    @Column(name = "secondreading_link")
    private String secondReadingLink;

//    @Column(name = "created_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//    private LocalDateTime createdDate;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    // Enums for Status
    public enum Status {
        saved, ongoing, checked
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReadingYear() {
        return readingYear;
    }

    public void setReadingYear(String readingYear) {
        this.readingYear = readingYear;
    }

    public String getReadingMonth() {
        return readingMonth;
    }

    public void setReadingMonth(String readingMonth) {
        this.readingMonth = readingMonth;
    }

    public String getReadingDay() {
        return readingDay;
    }

    public void setReadingDay(String readingDay) {
        this.readingDay = readingDay;
    }

    public String getFirstReading() {
        return firstReading;
    }

    public void setFirstReading(String firstReading) {
        this.firstReading = firstReading;
    }

    public String getFirstReadingShort() {
        return firstReadingShort;
    }

    public void setFirstReadingShort(String firstReadingShort) {
        this.firstReadingShort = firstReadingShort;
    }

    public String getFirstReadingLink() {
        return firstReadingLink;
    }

    public void setFirstReadingLink(String firstReadingLink) {
        this.firstReadingLink = firstReadingLink;
    }

    public String getSecondReading() {
        return secondReading;
    }

    public void setSecondReading(String secondReading) {
        this.secondReading = secondReading;
    }

    public String getSecondReadingShort() {
        return secondReadingShort;
    }

    public void setSecondReadingShort(String secondReadingShort) {
        this.secondReadingShort = secondReadingShort;
    }

    public String getSecondReadingLink() {
        return secondReadingLink;
    }

    public void setSecondReadingLink(String secondReadingLink) {
        this.secondReadingLink = secondReadingLink;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
