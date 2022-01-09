package com.mycode.bms.theatremgmt.entity;

import com.sun.istack.NotNull;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ShowPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "SCREEN_ID")
    private String screenId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIE_ID")
    private String movieId;
}
