package com.qiaofei.gankio.mvp.model

import com.qiaofei.gankio.api.GankApi
import com.qiaofei.gankio.bean.FuckGoods
import com.qiaofei.gankio.bean.JsonResult
import com.qiaofei.gankio.mvp.contract.RandomContract
import rx.Observable
import javax.inject.Inject

/**
 * Created by wing on 16-11-25.
 */
class RandomModel
@Inject constructor(private val api:GankApi) :RandomContract.Model{

    override fun getRandom(type:String): Observable<JsonResult<List<FuckGoods>>> {
        return api.getRandom(type)
    }
}
