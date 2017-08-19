package com.qiaofei.gankio.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.qiaofei.gankio.bean.FuckGoods
import com.qiaofei.gankio.databinding.ViewRecyclerBinding
import com.qiaofei.gankio.di.component.FuckGoodsModule
import com.qiaofei.gankio.getMainComponent
import com.qiaofei.gankio.mvp.contract.FuckGoodsContract
import com.qiaofei.gankio.mvp.presenter.FuckGoodsPresenter
import com.qiaofei.gankio.router.GankClientUri
import com.qiaofei.gankio.router.GankRouter
import com.qiaofei.gankio.ui.adapter.FuckGoodsAdapter
import java.net.URLEncoder
import java.util.*
import javax.inject.Inject

/**
 *
 * Created by wing on 16-11-24.
 */
class AndroidFragment : BaseBingingFragment<ViewRecyclerBinding>(), FuckGoodsContract.View {

  private var mList = ArrayList<FuckGoods>()
  private lateinit var mAdapter: FuckGoodsAdapter
  private var mPage = 1
  @Inject lateinit var mPresenter: FuckGoodsPresenter
  override fun createDataBinding(inflater: LayoutInflater?, container: ViewGroup?,
                                 savedInstanceState: Bundle?): ViewRecyclerBinding {
    return ViewRecyclerBinding.inflate(inflater, container, false)
  }

  override fun initView() {
    mAdapter = FuckGoodsAdapter(mList)
    context.getMainComponent().plus(FuckGoodsModule(this)).inject(this)
    with(mBinding!!) {
      recyclerView.adapter = mAdapter
      recyclerView.layoutManager = LinearLayoutManager(context)

      recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
          super.onScrolled(recyclerView, dx, dy)
          if (!recyclerView?.canScrollVertically(1)!!) {
            mPresenter.getData(++mPage, ANDROID)
          }
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
          super.onScrollStateChanged(recyclerView, newState)
        }
      })
    }

    mPresenter.getData(mPage, ANDROID)

    mAdapter.setOnItemClickListener { pos ->
      val url = URLEncoder.encode(mList[pos].url)
      GankRouter.router(context, GankClientUri.DETAIL + url)
    }


  }

  override fun setData(results: List<FuckGoods>) {
    mList.addAll(results)
    mAdapter.notifyDataSetChanged()
  }

  override fun onDestroy() {
    super.onDestroy()
    mPresenter.unSubscribe()
  }

  companion object {
    val ANDROID = "ANDROID"
    fun newInstance(): AndroidFragment {
      val fragment = AndroidFragment()
      val bundle = Bundle()
      fragment.arguments = bundle
      return fragment
    }
  }

}