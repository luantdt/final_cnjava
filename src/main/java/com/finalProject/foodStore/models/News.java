package com.finalProject.foodStore.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;

@Table
@Entity(name = "news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private int id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    @NotNull(message = "userId is not null")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private User user;

    @NotEmpty(message = "title of new is not empty")
    @NotNull(message = "title of new is not null")
    private String title;

    @NotEmpty(message = "description of new is not empty")
    @NotNull(message = "description of new is not null")
    private String description;

    @NotEmpty(message = "date of new is not empty")
    @NotNull(message = "date of new is not null")
    private Date date;


    @NotEmpty(message = "image of new is not empty")
    @NotNull(message = "image of new is not null")
    private String image;


}
