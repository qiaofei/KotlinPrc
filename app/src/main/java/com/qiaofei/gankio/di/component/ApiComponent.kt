package com.qiaofei.gankio.di.component

import com.qiaofei.gankio.App
import com.qiaofei.gankio.di.module.ApiModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by wing on 16-11-23.
 */
@Singleton
@Component(modules = arrayOf(ApiModule::class))
interface ApiComponent{

    fun inject(app: App)


    fun plus(module: FuckGoodsModule):FuckGoodsComponent
    fun plus(module: RandomModule):RandomComponent
}

