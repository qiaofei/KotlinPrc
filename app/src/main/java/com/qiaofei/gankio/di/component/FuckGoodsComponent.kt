package com.qiaofei.gankio.di.component

import com.qiaofei.gankio.mvp.contract.FuckGoodsContract
import com.qiaofei.gankio.ui.fragment.AndroidFragment
import com.qiaofei.gankio.ui.fragment.GirlFragment
import com.qiaofei.gankio.ui.fragment.IOSFragment
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

/**
 * Created by wing on 16-11-24.
 */
@Subcomponent(modules = arrayOf(FuckGoodsModule::class))
interface FuckGoodsComponent {
    fun inject(fragment: AndroidFragment)
    fun inject(fragment: IOSFragment)

    fun inject(fragment: GirlFragment)
}

@Module
class FuckGoodsModule(private val mView: FuckGoodsContract.View){
    @Provides fun getView() = mView
}