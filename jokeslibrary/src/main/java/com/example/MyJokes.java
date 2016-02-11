package com.example;

import java.util.Random;

public class MyJokes {
    public String getJoke() {
        return "The funny joke number is " + new Random().nextInt(99);
    }
}
