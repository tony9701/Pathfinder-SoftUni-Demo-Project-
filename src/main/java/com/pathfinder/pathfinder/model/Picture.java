package com.pathfinder.pathfinder.model;

import jakarta.persistence.*;

@Entity()
@Table(name = "Pictures")
public class Picture extends BaseEntity {

    private String title;

    @Column(columnDefinition = "text")
    private String url;

    @ManyToOne(optional = false)
    private User author;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Route route;

    public Picture() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
