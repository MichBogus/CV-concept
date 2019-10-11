package com.cv.cvconcept.cvsummaryactivity.di

import com.cv.cvconcept.cvsummaryactivity.presentation.CvSummaryActivity
import com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.di.MainDetailsFragmentComponent
import com.cv.cvconcept.cvsummaryactivity.view.projectsfragment.di.ProjectsFragmentComponent
import com.cv.cvconcept.cvsummaryactivity.view.skillsfragment.di.SkillsFragmentComponent
import com.cv.cvconcept.cvsummaryactivity.view.workplacefragment.di.WorkHistoryFragmentComponent
import dagger.Subcomponent

@Subcomponent(modules = [CvSummaryActivityModule::class])
interface CvSummaryActivityComponent {

    fun inject(activity: CvSummaryActivity)

    fun addMainDetailsFragmentComponent(): MainDetailsFragmentComponent
    fun addProjectsFragmentComponent(): ProjectsFragmentComponent
    fun addSkillsFragmentComponent(): SkillsFragmentComponent
    fun addWorkHistoryFragmentComponent(): WorkHistoryFragmentComponent
}