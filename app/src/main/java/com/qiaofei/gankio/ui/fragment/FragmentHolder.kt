package com.qiaofei.gankio.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.qiaofei.gankio.databinding.FragmentAboutBinding

/**
 * Created by wing on 16-11-24.
 */
class FragmentHolder : BaseBingingFragment<FragmentAboutBinding>() {
    override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): FragmentAboutBinding {
        return FragmentAboutBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        val text = "Kotlin \n"
                .plus("Dagger 2\n")
                .plus("Rxjava\n")
                .plus("Retrofit 2\n")
                .plus("OkHttp 3\n")
                .plus("DataBinding\n")
                .plus("DeepLinkDispatch\n")
                .plus("Gson\n")
                .plus("Glide")
        mBinding?.tvThank?.text = text

    }


}