package com.pathfinder.pathfinder.model;

import jakarta.persistence.*;

import java.time.Instant;

@Entity()
@Table(name = "comments")
public class Comment extends BaseEntity {
    @Column(nullable = false)
    private boolean approved;

    @Column(nullable = false)
    private Instant created;

    @Column(name = "text_content", nullable = false, columnDefinition = "text")
    private String textContent;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    private Route route;

    public Comment() {
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

}
