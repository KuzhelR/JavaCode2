package com.pomich2022.HelpStudy.utils.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserErrorResponce {
    private String msg;
    private Long timeStamp;
}
