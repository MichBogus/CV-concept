package com.cv.cvconcept.cvsummaryactivity.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.cv.cvconcept.R
import com.cv.cvconcept.base.BaseActivity
import kotlinx.android.synthetic.main.activity_cv_summary.bottom_navigation as bottomNavigation

class CvSummaryActivity : BaseActivity(), CvSummaryActivityMVP.View {

    companion object {
        const val CV_ID = "cv_id"

        fun startActivity(context: Context, cvId: Long) {
            context.startActivity(Intent(context, CvSummaryActivity::class.java).apply { putExtra(CV_ID, cvId) })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cv_summary)

        getApplicationComponent().addCvSummaryActivityComponent().inject(this)

        bottomNavigation.setupWithNavController(findNavController(R.id.container))
    }

}