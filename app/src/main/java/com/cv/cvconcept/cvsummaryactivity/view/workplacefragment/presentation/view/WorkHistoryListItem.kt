package com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.presentation.view

import android.view.View
import com.cv.cvconcept.R
import com.cv.cvconcept.cvrepository.model.CvWorkHistory
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.work_history_list_item.view.*

class WorkHistoryListItem(var workHistory: CvWorkHistory) : AbstractItem<WorkHistoryListItem, WorkHistoryListItem.ViewHolder>() {

    override fun getType(): Int = R.id.work_history_item_id
    override fun getViewHolder(v: View): WorkHistoryListItem.ViewHolder = WorkHistoryListItem.ViewHolder(v)
    override fun getLayoutRes(): Int = R.layout.work_history_list_item

    class ViewHolder(itemView: View) : FastAdapter.ViewHolder<WorkHistoryListItem>(itemView) {
        override fun unbindView(item: WorkHistoryListItem) {
            itemView.work_name.text = null
            itemView.work_position.text = null
            itemView.work_duration.text = null
            itemView.work_description.text = null
        }

        override fun bindView(item: WorkHistoryListItem, payloads: MutableList<Any>) {
            itemView.work_name.text = item.workHistory.name
            itemView.work_position.text = item.workHistory.position
            itemView.work_duration.text = "${item.workHistory.dateFrom} - ${item.workHistory.dateTo}"
            itemView.work_description.text = item.workHistory.description
        }
    }
}