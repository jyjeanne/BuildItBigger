package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.example.MyJokes;


/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testJavaJokesIntegration() {
        MyJokes joker = new MyJokes();
        assertTrue(joker.getJoke().length() > 0);
    }
}