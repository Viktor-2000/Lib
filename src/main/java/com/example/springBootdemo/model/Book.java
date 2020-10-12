package com.example.springBootdemo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( name = "title" )
    private String title;
    @Column( name = "author" )
    private String author;
    @Column( name = "brief_description" )
    private String briefDescription;
    @Column( name = "category" )
    private String category;

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getBriefDescription() {
        return briefDescription;
    }

    public String getCategory() {
        return category;
    }
}
