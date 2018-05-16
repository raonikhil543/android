package com.scrapper.subbu.newsscrolling;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import me.biubiubiu.justifytext.library.JustifyTextView;

public class DetailActivity extends AppCompatActivity {

    TextView nameTxt;
    ImageView img;
    JustifyTextView descTxt;
    private InterstitialAd interstitial;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
////        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
////        setSupportActionBar(toolbar);
////
////        Toolbar toolbar1 = (Toolbar) findViewById(R.id.toolbar);
//        TextView mTitle = toolbar.findViewById(R.id.noti);
//
//        setSupportActionBar(toolbar1);
//        mTitle.setText(toolbar.getTitle());

        getSupportActionBar().setDisplayShowTitleEnabled(false);


        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(DetailActivity.this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));


        interstitial.loadAd(new AdRequest.Builder().build());
// Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener(){
            public void onAdLoaded() {
// Call displayInterstitial() function
                displayInterstitial();
            }
        });

//

        //INITIALIZE VIEWS
        nameTxt= (TextView) findViewById(R.id.noti);
        img= (ImageView) findViewById(R.id.spacecraftImageDetail);
        descTxt= (JustifyTextView) findViewById(R.id.descp);
        //descTxt1= (JustifyTextView) findViewById(R.id.descDetailTxt1);

        //RECEIVE DATA
        Intent i=this.getIntent();
        String name=i.getExtras().getString("NAME_KEY");
        int image=i.getExtras().getInt("IMAGE_KEY");
        String Desc=i.getExtras().getString("DESC_KEY");
        // String Desc1=i.getExtras().getString("DESC1_KEY");

        //BIND DATA
        nameTxt.setText(name);
        img.setImageResource(image);
        descTxt.setText(Desc);
        //descTxt1.setText(Desc1);

        //social media


        AdView mAdView = (AdView) findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        AdView mAdView1 = (AdView) findViewById(R.id.adView);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdView1.loadAd(adRequest1);

    }

    public void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }


}
