package com.example.apiservice3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apiservice3.FootballDataclass.FootballList
import com.google.android.ads.nativetemplates.NativeTemplateStyle
import com.google.android.ads.nativetemplates.TemplateView
import com.google.android.gms.ads.*
import com.google.android.gms.ads.doubleclick.PublisherAdRequest
import com.google.android.gms.ads.formats.NativeAdOptions
import com.google.android.gms.ads.formats.UnifiedNativeAd
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mInter : InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        MobileAds.initialize(this,"ca-app-pub-7458814027439195~2967307134")
        mInter = InterstitialAd(this)
        mInter.adUnitId = "ca-app-pub-3940256099942544/2247696110"
        mInter.loadAd(AdRequest.Builder().build())
        mInter.show()




    }

    }

