package com.qiaofei.gankio.ui.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.airbnb.deeplinkdispatch.DeepLink
import com.qiaofei.gankio.R
import com.qiaofei.gankio.databinding.ActivityDetailBinding
import com.qiaofei.gankio.router.GankClientUri
import kotlinx.android.synthetic.main.activity_detail.*
import java.net.URLDecoder

@DeepLink("gank://androidwing.net/detail/{${GankClientUri.DETAIL_PARAM_URL}}")
class DetailActivity : BaseBindingActivity<ActivityDetailBinding>() {
    var url = ""
    override fun initView() {
        if (intent.getBooleanExtra(DeepLink.IS_DEEP_LINK, false)) {
            url = URLDecoder.decode(intent.extras.getString(GankClientUri.DETAIL_PARAM_URL))
        }
        setupToolbar(toolbar)
        tv_title.text = "Gank.io"
        webView.loadUrl(url)
        webView.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }
        }
        )
    }

    override fun createDataBinding(savedInstanceState: Bundle?): ActivityDetailBinding {
        return DataBindingUtil.setContentView(this, R.layout.activity_detail)
    }

}
