package com.cv.cvconcept.basedi

import android.content.Context
import com.cv.cvconcept.basedi.module.SchedulerModule
import com.cv.cvconcept.basedi.module.UtilsModule
import com.cv.cvconcept.cvsummaryactivity.di.CvSummaryActivityComponent
import com.cv.cvconcept.cvsummaryactivity.di.CvSummaryDomainRxBusModule
import com.cv.cvconcept.listofcvsactivity.di.ListOfCvsComponent
import dagger.BindsInstance
import dagger.Component

@Component(modules = [UtilsModule::class, SchedulerModule::class, CvSummaryDomainRxBusModule::class])
interface AppComponent {

    fun addListOfCvsComponent(): ListOfCvsComponent
    fun addCvSummaryActivityComponent(): CvSummaryActivityComponent

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindContext(context: Context): Builder

        fun build(): AppComponent
    }

}
