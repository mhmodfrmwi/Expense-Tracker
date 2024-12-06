package com.example.demo;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Arrays;

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

    public Report(String title, LocalDate date, String author) {
        this.title = title;
        this.date = date;
        this.author = author;
    }

    public Report(String title, String author, String date, String summary, String content, String tags) {
        this.title = title;
        this.author = author;
        this.date = LocalDate.parse(date);
        this.summary = summary;
        this.content = content;
        this.tags = tags;
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

    // Additional methods for functionality

    public boolean isRecent() {
        return date.isAfter(LocalDate.now().minusMonths(1));
    }

    public int getContentLength() {
        return content != null ? content.length() : 0;
    }

    public boolean hasSummary() {
        return summary != null && !summary.isEmpty();
    }

    public boolean hasTags() {
        return tags != null && !tags.isEmpty();
    }

    public String[] getTagsArray() {
        return tags != null ? tags.split(",") : new String[0];
    }

    public String getBriefSummary(int length) {
        if (summary != null && summary.length() > length) {
            return summary.substring(0, length) + "...";
        }
        return summary;
    }

    public boolean matchesTitle(String keyword) {
        return title != null && title.contains(keyword);
    }

    public void appendContent(String additionalContent) {
        if (this.content == null) {
            this.content = additionalContent;
        } else {
            this.content += "\n" + additionalContent;
        }
    }

    public void clearContent() {
        this.content = null;
    }

    public boolean isAuthor(String authorName) {
        return author != null && author.equalsIgnoreCase(authorName);
    }

    public void updateDate(LocalDate newDate) {
        this.date = newDate;
    }

    public void addTag(String tag) {
        if (tags == null || tags.isEmpty()) {
            tags = tag;
        } else {
            tags += "," + tag;
        }
    }

    public void removeTag(String tag) {
        if (tags != null && tags.contains(tag)) {
            tags = tags.replace(tag, "").replaceAll(",,", ",").trim();
            if (tags.startsWith(",")) tags = tags.substring(1);
            if (tags.endsWith(",")) tags = tags.substring(0, tags.length() - 1);
        }
    }

    public boolean hasKeywords(String[] keywords) {
        for (String keyword : keywords) {
            if (title != null && title.contains(keyword)) {
                return true;
            }
            if (content != null && content.contains(keyword)) {
                return true;
            }
            if (summary != null && summary.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    public String displayReportDetails() {
        return String.format("Title: %s\nAuthor: %s\nDate: %s\nSummary: %s\nTags: %s",
                title, author, date, summary, tags);
    }

    public String getFullDetails() {
        return String.format("Title: %s\nAuthor: %s\nDate: %s\nSummary: %s\nContent: %s\nTags: %s",
                title, author, date, summary, content, tags);
    }

    public String getFormattedDate() {
        return date != null ? date.toString() : "Date not set";
    }

    public void copyDetailsFrom(Report anotherReport) {
        if (anotherReport != null) {
            this.title = anotherReport.title;
            this.author = anotherReport.author;
            this.date = anotherReport.date;
            this.summary = anotherReport.summary;
            this.content = anotherReport.content;
            this.tags = anotherReport.tags;
        }
    }

    public boolean isContentEmpty() {
        return content == null || content.isEmpty();
    }

    public boolean isSummaryEmpty() {
        return summary == null || summary.isEmpty();
    }

    public boolean isTagsEmpty() {
        return tags == null || tags.isEmpty();
    }

    public boolean isTitleEmpty() {
        return title == null || title.isEmpty();
    }

    public String getTagsCount() {
        return tags != null ? String.valueOf(tags.split(",").length) : "0";
    }

    public void printReport() {
        System.out.println(this);
    }

    public void printSummary() {
        System.out.println("Summary: " + (summary != null ? summary : "No summary available"));
    }

    public void printContent() {
        System.out.println("Content: " + (content != null ? content : "No content available"));
    }

    public void printAuthor() {
        System.out.println("Author: " + (author != null ? author : "No author specified"));
    }

    public void printDate() {
        System.out.println("Date: " + (date != null ? date.toString() : "Date not specified"));
    }

    public void clearAllFields() {
        this.title = null;
        this.author = null;
        this.date = null;
        this.summary = null;
        this.content = null;
        this.tags = null;
    }

    public boolean validateReport() {
        return title != null && !title.isEmpty() && author != null && !author.isEmpty() && date != null;
    }
}
