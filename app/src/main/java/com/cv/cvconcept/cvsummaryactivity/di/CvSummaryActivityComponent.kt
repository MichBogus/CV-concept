package com.cv.cvconcept.cvsummaryactivity.di

import com.cv.cvconcept.cvsummaryactivity.presentation.CvSummaryActivity
import dagger.Subcomponent

@Subcomponent(modules = [CvSummaryActivityModule::class])
interface CvSummaryActivityComponent {

    fun inject(activity: CvSummaryActivity)
}