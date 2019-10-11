package com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.di

import com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.presentation.ProjectsFragment
import dagger.Subcomponent

@Subcomponent(modules = [ProjectsFragmentModule::class])
interface ProjectsFragmentComponent {

    fun inject(fragment: ProjectsFragment)
}