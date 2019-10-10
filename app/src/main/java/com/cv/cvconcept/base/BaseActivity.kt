package com.cv.cvconcept.base

import androidx.appcompat.app.AppCompatActivity
import com.cv.cvconcept.app.CVConceptApp
import com.cv.cvconcept.basedi.AppComponent

abstract class BaseActivity : AppCompatActivity() {

    protected fun getApplicationComponent(): AppComponent =
        CVConceptApp.component!!
}