package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;
import android.util.Pair;

/**
 * Created by jeremy on 06/02/2016.
 */
public class GoogleCloudEndpointsTest extends AndroidTestCase {
    static final String TO_TEST = "testing joke";
    static final String COMPARE_TO = "Hey, testing joke with Google Cloud Endpoints";

    public void testJokeFromGCE() {

        new EndpointsAsyncTask(new EndpointsAsyncTask.Callback() {
            @Override
            public void onLoadJokeFromGCE(String result) {
                assertEquals(COMPARE_TO, result);
            }
        }).execute(new Pair<Context, String>(getContext(), TO_TEST));

    }
}
