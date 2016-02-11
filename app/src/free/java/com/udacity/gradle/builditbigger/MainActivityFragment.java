package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.MyJokes;
import com.example.jokesdisplay.JokeActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;




/**
 * Main activity Fragment with a view.
 */
public class MainActivityFragment extends Fragment {

    private InterstitialAd interstitial;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        // Create Google Ad Banner full screen.
        // Create the interstitial.
        interstitial = new InterstitialAd(getActivity());
        interstitial.setAdUnitId(getString(R.string.banner_ad_unit_id_intersticial));
        interstitial.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                tellJoke();
            }
        });

        Button tellJokeButton = (Button) root.findViewById(R.id.tellJoke);
        tellJokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInterstitial();
            }
        });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Create an ad request.
        AdRequest adRequest2 = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        // Begin to load your interstitial.
        interstitial.loadAd(adRequest2);
    }

    public void displayInterstitial() {
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

    public void tellJoke() {
        MyJokes jokes = new MyJokes();
        Intent intent = new Intent(getContext(), JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_KEY, jokes.getJoke());
        startActivity(intent);

        Toast.makeText(getContext(), "Check the Paid version for more Jokes and No Ads.", Toast.LENGTH_LONG).show();
    }
}
