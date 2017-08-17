package com.qiaofei.gankio.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.deeplinkdispatch.DeepLink
import com.qiaofei.gankio.R
import com.qiaofei.gankio.router.GankClientUri

@DeepLink(GankClientUri.ABOUT)
class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

    }
}
