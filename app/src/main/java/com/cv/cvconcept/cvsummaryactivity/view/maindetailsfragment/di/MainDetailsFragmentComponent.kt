package com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.di

import com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.presentation.MainDetailsFragment
import dagger.Subcomponent

@Subcomponent(modules = [MainDetailsFragmentModule::class])
interface MainDetailsFragmentComponent {

    fun inject(fragment: MainDetailsFragment)
}