package com.cv.cvconcept.cvsummaryactivity.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.cv.cvconcept.R
import com.cv.cvconcept.base.BaseActivity
import com.cv.cvconcept.cvsummaryactivity.di.CvSummaryActivityComponent
import javax.inject.Inject
import kotlinx.android.synthetic.main.activity_cv_summary.bottom_navigation as bottomNavigation

class CvSummaryActivity : BaseActivity(), CvSummaryActivityMVP.View {

    companion object {
        const val CV_ID = "cv_id"

        fun startActivity(context: Context, cvId: Long) {
            context.startActivity(Intent(context, CvSummaryActivity::class.java).apply { putExtra(CV_ID, cvId) })
        }
    }

    @Inject
    lateinit var presenter: CvSummaryActivityMVP.Presenter

    lateinit var component: CvSummaryActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cv_summary)

        component = getApplicationComponent().addCvSummaryActivityComponent()
        component.inject(this)

        bottomNavigation.setupWithNavController(findNavController(R.id.container))
    }

    override fun onStart() {
        super.onStart()
        presenter.attach(this, intent.extras?.getLong(CV_ID) ?: 0)
    }

    override fun onStop() {
        presenter.detach()
        super.onStop()
    }

    fun getActivityComponent() = component

}