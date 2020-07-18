package com.example.apiservice3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apiservice3.FootballDataclass.FootballList
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdLoader
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.formats.NativeAdOptions
import com.google.android.gms.ads.formats.UnifiedNativeAd
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//         MobileAds.initialize(this,getString(R.string.app_id))
//        val addrequest = AdRequest.Builder().build()
//        adView.loadAd(addrequest)

        val adLoader = AdLoader.Builder(this, "ca-app-pub-7458814027439195~5785574998")
            .forUnifiedNativeAd { ad : UnifiedNativeAd ->
                // Show the ad.
            }
            .withAdListener(object : AdListener() {
                override fun onAdFailedToLoad(errorCode: Int) {
                    // Handle the failure by logging, altering the UI, and so on.
                }
            })
            .withNativeAdOptions(
                NativeAdOptions.Builder()
                // Methods in the NativeAdOptions.Builder class can be
                // used here to specify individual options settings.
                .build())
            .build()



    }
}
