package com.cv.cvconcept.listofcvsactivity.presentation

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.cv.cvconcept.R
import com.cv.cvconcept.base.BaseActivity
import com.cv.cvconcept.base.utils.ActivityNavigator
import com.cv.cvconcept.listofcvsactivity.domain.CvDomain
import com.cv.cvconcept.listofcvsactivity.view.CvListItem
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_list_cv.empty_list_placeholder as emptyListPlaceholder
import kotlinx.android.synthetic.main.activity_list_cv.list as cvList

class ListOfCvsActivity : BaseActivity(), ListOfCvsActivityMVP.View {

    @Inject
    lateinit var presenter: ListOfCvsActivityMVP.Presenter

    @Inject
    lateinit var navigator: ActivityNavigator

    private val adapter = FastItemAdapter<CvListItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_cv)

        getApplicationComponent().addListOfCvsComponent().inject(this)
    }

    override fun onStart() {
        super.onStart()
        setListAdapter()
        presenter.attach(this)
    }

    private fun setListAdapter() {
        cvList.layoutManager = LinearLayoutManager(this)
        cvList.adapter = adapter
    }

    override fun onStop() {
        presenter.detach()
        super.onStop()
    }

    override fun showCvList(list: List<CvDomain>) {
        adapter.add(list.map {
            CvListItem(it) { id ->
                navigator.navigateToCvSummaryActivity(this@ListOfCvsActivity, id)
            }
        })
        adapter.notifyAdapterDataSetChanged()
    }

    override fun showEmptyInfo() {
        emptyListPlaceholder.visibility = View.VISIBLE
    }
}
