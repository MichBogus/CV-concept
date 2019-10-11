package com.cv.cvconcept.base.utils

import android.content.Context
import com.cv.cvconcept.cvsummaryactivity.presentation.CvSummaryActivity
import javax.inject.Inject

class ActivityNavigatorImpl
@Inject constructor() : ActivityNavigator {

    override fun navigateToCvSummaryActivity(context: Context, cvId: Long) {
        CvSummaryActivity.startActivity(context, cvId)
    }
}