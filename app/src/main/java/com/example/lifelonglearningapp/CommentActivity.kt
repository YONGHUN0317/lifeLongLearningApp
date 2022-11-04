package com.example.lifelonglearningapp

import com.paginate.Paginate

class CommentActivity : Paginate.Callbacks {
    val TAG = CommentActivity::class.java.simpleName

    // Groupie Adapter로 기존 Recycler View Adapter와는 다릅니다
    val groupAdapter = GroupAdapter<GroupieViewHolder>()

    var mPresenter : CommentPresenter? = null
    var mBinding: ActivityCommentBinding? = null

    // Paging 숫자 변수
    var parentCommentPageNum: Int? = 1
    // 현재 데이터를 로딩중인지 상태체크하는 변수
    var loading: Boolean = false

    override fun onLoadMore() {
        TODO("Not yet implemented")
    }

    override fun isLoading(): Boolean {
        TODO("Not yet implemented")
    }

    override fun hasLoadedAllItems(): Boolean {
        TODO("Not yet implemented")
    }
}