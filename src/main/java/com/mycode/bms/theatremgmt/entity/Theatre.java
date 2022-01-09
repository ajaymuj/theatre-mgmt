package com.mycode.bms.theatremgmt.entity;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "THEATRE")
public class Theatre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THEATRE_ID")
    private Long theatreId;

    @Column(name = "THEATRE_NAME")
    @NonNull
    private String theatreName;

    @Column(name = "THEATRE_LOCATION")
    @NonNull
    private String location;

    @Column(name = "THEATRE_TYPE")
    @NonNull
    private String theatreType;

    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "theatre", fetch = FetchType.EAGER)
    private List <Screen> screens;

}
