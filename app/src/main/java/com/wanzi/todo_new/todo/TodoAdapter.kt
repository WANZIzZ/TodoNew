package com.wanzi.todo_new.todo

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.wanzi.todo_new.R

/**
 *  Author : Created by WZ on 2018-09-26 14:13
 *  E-Mail : 1253427499@qq.com
 */
class TodoAdapter(data: ArrayList<String>) : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_todo, data) {

    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper?.run {
            setText(R.id.tv_item_todo, item)
        }
    }
}