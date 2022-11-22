//package com.example.lifelonglearningapp
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import by.kirich1409.viewbindingdelegate.viewBinding
//import com.example.lifelonglearningapp.databinding.FragmentLocationBinding
//import kotlinx.android.synthetic.main.activity_lectureinformation.*
//
//class LocationFragment : Fragment(R.layout.fragment_location) {
//
//    private val binding by viewBinding(FragmentLocationBinding::bind)
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//
//        getData()
//        super.onViewCreated(view, savedInstanceState)
//    }
//
//    fun getData(){
//
//        var lctreNm = this.arguments?.getString("lctreNm")
//        var instrctrNm = this.arguments?.getString("instrctrNm")
//        var edcStartDay = this.arguments?.getString("edcStartDay")
//        var edcEndDay = this.arguments?.getString("edcEndDay")
//        var edcStartTime = this.arguments?.getString("edcStartTime")
//        var edcColseTime = this.arguments?.getString("edcColseTime")
//        var lctreCo = this.arguments?.getString("lctreCo")
//        var edcTrgetType = this.arguments?.getString("edcTrgetType")
//        var edcMthType = this.arguments?.getString("edcMthType")
//        var operDay = this.arguments?.getString("operDay")
//        var edcPlace = this.arguments?.getString("edcPlace")
//        var psncpa = this.arguments?.getString("psncpa")
//        var lctreCost = this.arguments?.getString("lctreCost")
//        var edcRdnmadr = this.arguments?.getString("edcRdnmadr")
//        var operInstitutionNm = this.arguments?.getString("operInstitutionNm")
//        var operPhoneNumber = this.arguments?.getString("operPhoneNumber")
//        var rceptStartDate = this.arguments?.getString("rceptStartDate")
//        var rceptEndDate = this.arguments?.getString("rceptEndDate")
//        var rceptMthType = this.arguments?.getString("rceptMthType")
//        var slctnMthType = this.arguments?.getString("slctnMthType")
//        var homepageUrl = this.arguments?.getString("homepageUrl")
//        var pntBankAckestYn = this.arguments?.getString("pntBankAckestYn")
//        var lrnAcnutAckestYn = this.arguments?.getString("lrnAcnutAckestYn")
//        var referenceDate = this.arguments?.getString("referenceDate")
//        var insttCode = this.arguments?.getString("insttCode")
//        var oadtCtLctreYn = this.arguments?.getString("oadtCtLctreYn")
//
//
//
//        textview_lctrNm.text = lctreNm
//        lecture_seats.text = psncpa
//        lecture_tuition.text = lctreCost
//        lecture_selection.text = slctnMthType
//        lecture_register.text = rceptMthType
//        lecture_target.text = edcMthType
//        textview_edcPlace.text = edcPlace
//        textview_operPhoneNumber.text = operPhoneNumber
//        textview_edcTrgetType.text = edcTrgetType
//        lecture_date.text = edcStartDay + " ~ " + edcEndDay
//        textview_operDay.text = operDay
//        textview_time.text = edcStartTime + " ~ " + edcColseTime
//        lecture_content.text = lctreCo
//        textview_instrctrNm.text = instrctrNm
//        textview_oadtCtLctreYn.text = oadtCtLctreYn
//        textview_pntBankAckestYn.text = pntBankAckestYn
//        textview_lrnAcnutAckestYn.text = lrnAcnutAckestYn
//        textview_referenceDate.text = referenceDate
//
//    }
//}
//
//
