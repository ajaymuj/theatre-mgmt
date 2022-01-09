package com.mycode.bms.theatremgmt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowModel {

    private Long screenId;
    private Long movieId;
    private Date startTime;
    private Date endTime;
}
