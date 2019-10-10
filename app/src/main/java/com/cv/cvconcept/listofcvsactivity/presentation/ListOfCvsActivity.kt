package com.cv.cvconcept.listofcvsactivity.presentation

import android.os.Bundle
import com.cv.cvconcept.R
import com.cv.cvconcept.base.BaseActivity
import javax.inject.Inject

class ListOfCvsActivity : BaseActivity(), ListOfCvsActivityMVP.View {

    @Inject
    lateinit var presenter: ListOfCvsActivityMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getApplicationComponent().addListOfCvsComponent().inject(this)
    }
}
