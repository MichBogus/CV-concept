package com.cv.cvconcept.listofcvsactivity.presentation

interface ListOfCvsActivityMVP {

    interface Presenter {

        fun attach(view: View)
        fun detach()
    }

    interface View {

    }
}
