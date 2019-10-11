package com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cv.cvconcept.R
import com.cv.cvconcept.cvrepository.model.CvSkill
import com.cv.cvconcept.cvsummaryactivity.presentation.CvSummaryActivity
import com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.presentation.view.SkillListItem
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_skills.list as skillList

class SkillsFragment : Fragment(), SkillsFragmentMVP.View {

    @Inject
    lateinit var presenter: SkillsFragmentMVP.Presenter

    private val adapter = FastItemAdapter<SkillListItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_skills, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as CvSummaryActivity).component.addSkillsFragmentComponent().inject(this)
    }

    override fun onStart() {
        super.onStart()
        setListAdapter()
        presenter.attach(this)
    }

    private fun setListAdapter() {
        skillList.layoutManager = LinearLayoutManager(context)
        skillList.adapter = adapter
    }

    override fun onStop() {
        presenter.detach()
        super.onStop()
    }

    override fun showList(list: List<CvSkill>) {
        adapter.add(list.map { SkillListItem(it) })
        adapter.notifyAdapterDataSetChanged()
    }
}