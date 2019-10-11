package com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.presentation.view

import android.view.View
import com.cv.cvconcept.R
import com.cv.cvconcept.cvrepository.model.CvSkill
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem
import kotlinx.android.synthetic.main.skill_list_item.view.*

class SkillListItem(var skill: CvSkill) : AbstractItem<SkillListItem, SkillListItem.ViewHolder>() {

    override fun getType(): Int = R.id.skill_item_id
    override fun getViewHolder(v: View): SkillListItem.ViewHolder = SkillListItem.ViewHolder(v)
    override fun getLayoutRes(): Int = R.layout.skill_list_item

    class ViewHolder(itemView: View) : FastAdapter.ViewHolder<SkillListItem>(itemView) {
        override fun unbindView(item: SkillListItem) {
            itemView.skill_name.text = null
        }

        override fun bindView(item: SkillListItem, payloads: MutableList<Any>) {
            itemView.skill_name.text = "- ${item.skill.name}"
        }
    }
}