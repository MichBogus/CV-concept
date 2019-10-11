package com.cv.cvconcept.listofcvsactivity.view

import android.view.View
import com.cv.cvconcept.R
import com.cv.cvconcept.listofcvsactivity.domain.CvDomain
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.cv_list_item.view.*

class CvListItem(var cvDomain: CvDomain,
                 var onItemClickListener: (id: Long) -> Unit) : AbstractItem<CvListItem, CvListItem.ViewHolder>() {

    override fun getType(): Int = R.id.cv_item_id
    override fun getViewHolder(v: View): CvListItem.ViewHolder = CvListItem.ViewHolder(v)
    override fun getLayoutRes(): Int = R.layout.cv_list_item

    class ViewHolder(itemView: View) : FastAdapter.ViewHolder<CvListItem>(itemView) {
        override fun unbindView(item: CvListItem) {
            itemView.cv_id.text = null
            itemView.name_surname.text = null
            itemView.phone.text = null
            itemView.email.text = null
        }

        override fun bindView(item: CvListItem, payloads: MutableList<Any>) {
            itemView.setOnClickListener { item.onItemClickListener.invoke(item.cvDomain.id) }
            itemView.cv_id.text = item.cvDomain.id.toString()
            itemView.name_surname.text = "${item.cvDomain.name} ${item.cvDomain.surname}"
            itemView.phone.text = item.cvDomain.phone
            itemView.email.text = item.cvDomain.email
        }
    }
}
