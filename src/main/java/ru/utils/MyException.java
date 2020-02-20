package ru.utils;

public class MyException extends Exception{
    Boolean Start = true;
    public MyException(String message, Boolean Start) {
        super(message); this.Start = Start;
        System.out.print("My exception -> "  + Start);
    }
}
