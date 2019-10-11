package com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cv.cvconcept.R
import com.cv.cvconcept.cvrepository.model.CvWorkHistory
import com.cv.cvconcept.cvsummaryactivity.presentation.CvSummaryActivity
import com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.presentation.view.WorkHistoryListItem
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_work_history.list as workHistoryList

class WorkHistoryFragment : Fragment(), WorkHistoryFragmentMVP.View {

    @Inject
    lateinit var presenter: WorkHistoryFragmentMVP.Presenter

    private val adapter = FastItemAdapter<WorkHistoryListItem>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_work_history, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as CvSummaryActivity).component.addWorkHistoryFragmentComponent().inject(this)
    }

    override fun onStart() {
        super.onStart()
        setListAdapter()
        presenter.attach(this)
    }

    private fun setListAdapter() {
        workHistoryList.layoutManager = LinearLayoutManager(context)
        workHistoryList.adapter = adapter
    }

    override fun onStop() {
        presenter.detach()
        super.onStop()
    }

    override fun showWorkHistoryList(list: List<CvWorkHistory>) {
        adapter.add(list.map { WorkHistoryListItem(it) })
        adapter.notifyAdapterDataSetChanged()
    }
}