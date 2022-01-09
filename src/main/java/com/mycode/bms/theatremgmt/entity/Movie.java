package com.mycode.bms.theatremgmt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "MOVIE")
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID")
    private Long movieId;

    @Column(name = "MOVIE_TITLE")
    @NonNull
    private String movieTitle;

    @Column(name = "LANGUAGE")
    @NonNull
    private String language;

    @Column(name = "DIRECTOR")
    private String director;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DURATION")
    @NonNull
    private Long duration;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SCREENING",
            joinColumns = {@JoinColumn(name = "MOVIE_ID", referencedColumnName = "MOVIE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "SCREEN_ID", referencedColumnName = "SCREEN_ID")})
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Screen> screenList;

}
