package com.example.colcom.models;

public class modelgroupchat {
    String message,sendar,timestamp,type;
    public modelgroupchat(){

    }
    public modelgroupchat(String message,String sendar,String timestamp,String type){
        this.message=message;
        this.sendar=sendar;
        this.timestamp=timestamp;
        this.type=type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSendar() {
        return sendar;
    }

    public void setSendar(String sendar) {
        this.sendar = sendar;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
