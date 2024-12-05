package com.example.demo;

import java.time.LocalDate;
import java.util.Objects;

public class Report {

    private String title;
    private String author;
    private LocalDate date;
    private String summary;
    private String content;
    private String tags;


    public Report(String title, String author, LocalDate date, String summary, String content, String tags) {
        this.title = title;
        this.author = author;
        this.date = date;
        this.summary = summary;
        this.content = content;
        this.tags = tags;
    }

    public Report() {
        this.date = LocalDate.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    // toString Method for debugging and display purposes
    @Override
    public String toString() {
        return "Report{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Report report = (Report) o;
        return Objects.equals(title, report.title) && Objects.equals(date, report.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, date);
    }
}

