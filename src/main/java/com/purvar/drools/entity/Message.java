package com.purvar.drools.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class Message {

    public enum MessageType {
        HI,
        GOODBYE,
        CHAT
    }

    private MessageType messageType;
    private String target;
    private String name;

    public boolean add(String msg){
        this.target = this.target + msg;
        return true;
    }

}
