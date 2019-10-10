package com.cv.cvconcept.listofcvsactivity.di

import com.cv.cvconcept.listofcvsactivity.presentation.ListOfCvsActivity
import dagger.Subcomponent

@Subcomponent(modules = [ListOfCvsModule::class])
interface ListOfCvsComponent {

    fun inject(activity: ListOfCvsActivity)
}