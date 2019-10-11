package com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.di

import com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.presentation.WorkHistoryFragment
import dagger.Subcomponent

@Subcomponent(modules = [WorkHistoryFragmentModule::class])
interface WorkHistoryFragmentComponent {

    fun inject(fragment: WorkHistoryFragment)
}