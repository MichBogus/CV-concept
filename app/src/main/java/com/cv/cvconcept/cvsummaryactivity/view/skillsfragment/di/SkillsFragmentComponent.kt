package com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.di

import com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.presentation.SkillsFragment
import dagger.Subcomponent

@Subcomponent(modules = [SkillsFragmentModule::class])
interface SkillsFragmentComponent {

    fun inject(fragment: SkillsFragment)
}