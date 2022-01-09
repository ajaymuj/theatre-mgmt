package com.mycode.bms.theatremgmt.util;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Data
@Slf4j
@Component
public class TokenUtil {

    private String jwtToken = "";

    public TokenUtil() {}

    public TokenUtil(String token) {
        this.jwtToken=token;
    }

}
