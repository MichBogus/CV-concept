package com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cv.cvconcept.R
import com.cv.cvconcept.cvrepository.model.CvProject
import com.cv.cvconcept.cvsummaryactivity.presentation.CvSummaryActivity
import com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.presentation.view.ProejctListItem
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.fragment_projects.list as projectList
import javax.inject.Inject

class ProjectsFragment : Fragment(), ProjectsFragmentMVP.View {

    @Inject
    lateinit var presenter: ProjectsFragmentMVP.Presenter

    private val adapter = FastItemAdapter<ProejctListItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_projects, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as CvSummaryActivity).component.addProjectsFragmentComponent().inject(this)
    }

    override fun onStart() {
        super.onStart()
        setListAdapter()
        presenter.attach(this)
    }

    private fun setListAdapter() {
        projectList.layoutManager = LinearLayoutManager(context)
        projectList.adapter = adapter
    }

    override fun onStop() {
        presenter.detach()
        super.onStop()
    }

    override fun showProjectList(list: List<CvProject>) {
        adapter.add(list.map { ProejctListItem(it) })
        adapter.notifyAdapterDataSetChanged()
    }
}