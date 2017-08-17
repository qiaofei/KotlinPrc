package com.qiaofei.gankio.mvp.contract

import com.qiaofei.gankio.bean.FuckGoods
import com.qiaofei.gankio.bean.JsonResult
import rx.Observable

/**
 * Created by wing on 16-11-24.
 */
interface FuckGoodsContract {
    interface View {
        fun  setData(results: List<FuckGoods>)

    }

    interface Model {

        fun getData(page: Int,type:String): Observable<JsonResult<List<FuckGoods>>>
    }

    interface Presenter {

        open fun getData(page: Int, type: String)
    }
}