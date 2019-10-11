package com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cv.cvconcept.R
import com.cv.cvconcept.cvsummaryactivity.presentation.CvSummaryActivity
import com.cv.cvconcept.cvsummaryactivity.view.maindetailsfragment.domain.MainDetailsCvDomainModel
import kotlinx.android.synthetic.main.fragment_main_details.*
import javax.inject.Inject

class MainDetailsFragment : Fragment(), MainDetailsFragmentMVP.View {

    @Inject
    lateinit var presenter: MainDetailsPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_main_details, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as CvSummaryActivity).component.addMainDetailsFragmentComponent().inject(this)
    }

    override fun onStart() {
        super.onStart()
        presenter.attach(this)
    }

    override fun onStop() {
        presenter.detach()
        super.onStop()
    }

    override fun showView(model: MainDetailsCvDomainModel) {
        name_surname.text = "${model.name} ${model.surname}"
        email.text = model.email
        phone.text = model.phone
        address.text = model.address
        zip.text = model.zipCode
        city.text = model.city
        quick_summary.text = model.quickSummary
    }
}