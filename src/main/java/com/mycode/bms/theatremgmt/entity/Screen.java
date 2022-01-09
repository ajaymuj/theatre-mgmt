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
@Table(name = "SCREEN")
public class Screen implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SCREEN_ID")
    private Long screenId;

    @Column(name = "SCREEN_NAME")
    @NonNull
    private String screenName;

    @Column(name = "SCREEN_TYPE")
    private String screenType;

    @Column(name = "SEATS", columnDefinition = "CLOB")
    @Lob
    @NonNull
    private Integer [] seats;

//    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name = "THEATRE_ID", referencedColumnName = "THEATRE_ID")
    private Theatre theatre;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SCREENING",
                joinColumns = {@JoinColumn(name = "SCREEN_ID", referencedColumnName = "SCREEN_ID")},
                inverseJoinColumns = {@JoinColumn(name = "MOVIE_ID", referencedColumnName = "MOVIE_ID")})
    @Fetch(value = FetchMode.SUBSELECT)
    private List <Movie> movieList;

}
