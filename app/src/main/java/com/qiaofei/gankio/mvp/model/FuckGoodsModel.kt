package com.qiaofei.gankio.mvp.model

import com.qiaofei.gankio.api.GankApi
import com.qiaofei.gankio.bean.FuckGoods
import com.qiaofei.gankio.bean.JsonResult
import com.qiaofei.gankio.mvp.contract.FuckGoodsContract
import com.qiaofei.gankio.ui.fragment.AndroidFragment
import com.qiaofei.gankio.ui.fragment.GirlFragment
import com.qiaofei.gankio.ui.fragment.IOSFragment
import rx.Observable
import javax.inject.Inject

/**
 * Created by wing on 16-11-24.
 */
class FuckGoodsModel
@Inject constructor(private val api: GankApi) : FuckGoodsContract.Model {

  override fun getData(page: Int, type: String): Observable<JsonResult<List<FuckGoods>>> {
    when (type) {
      AndroidFragment.ANDROID -> return api.getAndroidData(page)
      IOSFragment.IOS -> return api.getiOSData(page)
      GirlFragment.GIRL -> return api.getGirlData(page)
      else -> return api.getAndroidData(page)
    }
  }
}
