package com.cv.cvconcept.app

import androidx.multidex.MultiDexApplication
import com.cv.cvconcept.basedi.AppComponent
import com.cv.cvconcept.basedi.DaggerAppComponent

class CVConceptApp : MultiDexApplication() {

    companion object {
        var component: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
            .bindContext(this)
            .build()
    }
}