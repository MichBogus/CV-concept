package com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.presentation.view

import android.view.View
import com.cv.cvconcept.R
import com.cv.cvconcept.cvrepository.model.CvProject
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.project_list_item.view.*

class ProejctListItem(var project: CvProject) : AbstractItem<ProejctListItem, ProejctListItem.ViewHolder>() {

    override fun getType(): Int = R.id.project_item_id
    override fun getViewHolder(v: View): ProejctListItem.ViewHolder = ProejctListItem.ViewHolder(v)
    override fun getLayoutRes(): Int = R.layout.project_list_item

    class ViewHolder(itemView: View) : FastAdapter.ViewHolder<ProejctListItem>(itemView) {
        override fun unbindView(item: ProejctListItem) {
            itemView.project_name.text = null
            itemView.project_link.text = null
            itemView.project_description.text = null
        }

        override fun bindView(item: ProejctListItem, payloads: MutableList<Any>) {
            itemView.project_name.text = item.project.name
            itemView.project_link.text = item.project.link
            itemView.project_description.text = item.project.description
        }
    }
}