package com.qiaofei.gankio.mvp.contract

import com.qiaofei.gankio.bean.FuckGoods
import com.qiaofei.gankio.bean.JsonResult
import rx.Observable

/**
 * Created by wing on 16-11-25.
 */
interface RandomContract{
    interface View{
        fun onRandom(goods:FuckGoods)

    }
    interface Model{

        fun getRandom(type: String): Observable<JsonResult<List<FuckGoods>>>
    }
    interface Presenter{

        fun getRandom(type: String)
    }

}