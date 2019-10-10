package com.cv.cvconcept.basedi

import android.content.Context
import com.cv.cvconcept.basedi.module.UtilsModule
import com.cv.cvconcept.listofcvsactivity.di.ListOfCvsComponent
import dagger.BindsInstance
import dagger.Component

@Component(modules = [UtilsModule::class])
interface AppComponent {

    fun addListOfCvsComponent(): ListOfCvsComponent

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindContext(context: Context): Builder

        fun build(): AppComponent
    }

}
