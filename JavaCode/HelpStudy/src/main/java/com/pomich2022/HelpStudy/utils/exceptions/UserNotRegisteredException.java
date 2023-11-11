package com.pomich2022.HelpStudy.utils.exceptions;

public class UserNotRegisteredException extends RuntimeException{
    public UserNotRegisteredException (String msg){
        super(msg);
    }
}
