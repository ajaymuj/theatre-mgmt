package com.mycode.bms.theatremgmt.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class ShowPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "SCREEN_ID")
    private Long screenId;

    @Basic(optional = false)
    @NotNull
    @Column(name = "MOVIE_ID")
    private Long movieId;
}
