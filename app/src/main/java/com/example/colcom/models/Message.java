package com.example.colcom.models;

public class Message {
    String message;
    String name;
    String key;
    public Message(){
        
    }
    public Message(String m,String n){
        this.message=m;

        this.name=n;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public String toString()
    {
        return "Message("+message+ " "+"name"+ name+" "+"key"+key+" "+")";
    }

    public void add(Message msg) {
    }
}
