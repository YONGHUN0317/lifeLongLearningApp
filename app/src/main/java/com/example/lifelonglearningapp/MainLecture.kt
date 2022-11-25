package com.example.lifelonglearningapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifelonglearningapp.databinding.FragmentMainLectureBinding
import kotlinx.android.synthetic.main.fragment_main_lecture.*
import android.content.Intent
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.synthetic.main.activity_main.*

private const val ARG_PARAM1 = "title"
private const val ARG_PARAM2 = "instrctrNm"
private const val ARG_PARAM3 = "period"
private const val ARG_PARAM4 = "day_time"
private const val ARG_PARAM5 = "price"
private const val ARG_PARAM6 = "edcPlace"

private var _binding: FragmentMainLectureBinding? = null
private val binding get() = _binding!!


class MainLecture : Fragment() {
    // TODO: Rename and change types of parameters
    private var title: String? = null
    private var instrctrNm: String? = null
    private var period: String? = null
    private var day_time: String? = null
    private var price: String? = null
    private var edcPlace: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_PARAM1)
            instrctrNm = it.getString(ARG_PARAM2)
            period = it.getString(ARG_PARAM3)
            day_time = it.getString(ARG_PARAM4)
            price = it.getString(ARG_PARAM5)
            edcPlace = it.getString(ARG_PARAM6)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMainLectureBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.lectureTitle.text = title
        binding.lectureLocation.text = instrctrNm
        binding.lecturePeriod.text = period
        binding.lectureDayTime.text = day_time
        binding.lecturePrice.text = price
        binding.lectureMethod.text = edcPlace


        view.setOnClickListener {
            if (title == mainLectureInfo1.lctreNm) {
                setData(
                    mainLectureInfo1.lctreNm,
                    mainLectureInfo1.instrctrNm,
                    mainLectureInfo1.edcStartDay,
                    mainLectureInfo1.edcEndDay,
                    mainLectureInfo1.edcStartTime,
                    mainLectureInfo1.edcColseTime,
                    mainLectureInfo1.lctreCo,
                    mainLectureInfo1.edcTrgetType,
                    mainLectureInfo1.edcMthType,
                    mainLectureInfo1.operDay,
                    mainLectureInfo1.edcPlace,
                    mainLectureInfo1.psncpa,
                    mainLectureInfo1.lctreCost,
                    mainLectureInfo1.edcRdnmadr,
                    mainLectureInfo1.operInstitutionNm,
                    mainLectureInfo1.operPhoneNumber,
                    mainLectureInfo1.rceptStartDate,
                    mainLectureInfo1.rceptEndDate,
                    mainLectureInfo1.rceptMthType,
                    mainLectureInfo1.slctnMthType,
                    mainLectureInfo1.homepageUrl,
                    mainLectureInfo1.oadtCtLctreYn,
                    mainLectureInfo1.pntBankAckestYn,
                    mainLectureInfo1.lrnAcnutAckestYn,
                    mainLectureInfo1.referenceDate,
                    mainLectureInfo1.insttCode
                )
            } else if (title == mainLectureInfo2.lctreNm) {
                setData(
                    mainLectureInfo2.lctreNm,
                    mainLectureInfo2.instrctrNm,
                    mainLectureInfo2.edcStartDay,
                    mainLectureInfo2.edcEndDay,
                    mainLectureInfo2.edcStartTime,
                    mainLectureInfo2.edcColseTime,
                    mainLectureInfo2.lctreCo,
                    mainLectureInfo2.edcTrgetType,
                    mainLectureInfo2.edcMthType,
                    mainLectureInfo2.operDay,
                    mainLectureInfo2.edcPlace,
                    mainLectureInfo2.psncpa,
                    mainLectureInfo2.lctreCost,
                    mainLectureInfo2.edcRdnmadr,
                    mainLectureInfo2.operInstitutionNm,
                    mainLectureInfo2.operPhoneNumber,
                    mainLectureInfo2.rceptStartDate,
                    mainLectureInfo2.rceptEndDate,
                    mainLectureInfo2.rceptMthType,
                    mainLectureInfo2.slctnMthType,
                    mainLectureInfo2.homepageUrl,
                    mainLectureInfo2.oadtCtLctreYn,
                    mainLectureInfo2.pntBankAckestYn,
                    mainLectureInfo2.lrnAcnutAckestYn,
                    mainLectureInfo2.referenceDate,
                    mainLectureInfo2.insttCode
                )
            } else if (title == mainLectureInfo3.lctreNm) {
                setData(
                    mainLectureInfo3.lctreNm,
                    mainLectureInfo3.instrctrNm,
                    mainLectureInfo3.edcStartDay,
                    mainLectureInfo3.edcEndDay,
                    mainLectureInfo3.edcStartTime,
                    mainLectureInfo3.edcColseTime,
                    mainLectureInfo3.lctreCo,
                    mainLectureInfo3.edcTrgetType,
                    mainLectureInfo3.edcMthType,
                    mainLectureInfo3.operDay,
                    mainLectureInfo3.edcPlace,
                    mainLectureInfo3.psncpa,
                    mainLectureInfo3.lctreCost,
                    mainLectureInfo3.edcRdnmadr,
                    mainLectureInfo3.operInstitutionNm,
                    mainLectureInfo3.operPhoneNumber,
                    mainLectureInfo3.rceptStartDate,
                    mainLectureInfo3.rceptEndDate,
                    mainLectureInfo3.rceptMthType,
                    mainLectureInfo3.slctnMthType,
                    mainLectureInfo3.homepageUrl,
                    mainLectureInfo3.oadtCtLctreYn,
                    mainLectureInfo3.pntBankAckestYn,
                    mainLectureInfo3.lrnAcnutAckestYn,
                    mainLectureInfo3.referenceDate,
                    mainLectureInfo3.insttCode
                )
            } else if (title == mainLectureInfo4.lctreNm) {
                setData(
                    mainLectureInfo4.lctreNm,
                    mainLectureInfo4.instrctrNm,
                    mainLectureInfo4.edcStartDay,
                    mainLectureInfo4.edcEndDay,
                    mainLectureInfo4.edcStartTime,
                    mainLectureInfo4.edcColseTime,
                    mainLectureInfo4.lctreCo,
                    mainLectureInfo4.edcTrgetType,
                    mainLectureInfo4.edcMthType,
                    mainLectureInfo4.operDay,
                    mainLectureInfo4.edcPlace,
                    mainLectureInfo4.psncpa,
                    mainLectureInfo4.lctreCost,
                    mainLectureInfo4.edcRdnmadr,
                    mainLectureInfo4.operInstitutionNm,
                    mainLectureInfo4.operPhoneNumber,
                    mainLectureInfo4.rceptStartDate,
                    mainLectureInfo4.rceptEndDate,
                    mainLectureInfo4.rceptMthType,
                    mainLectureInfo4.slctnMthType,
                    mainLectureInfo4.homepageUrl,
                    mainLectureInfo4.oadtCtLctreYn,
                    mainLectureInfo4.pntBankAckestYn,
                    mainLectureInfo4.lrnAcnutAckestYn,
                    mainLectureInfo4.referenceDate,
                    mainLectureInfo4.insttCode
                )
            } else if (title == mainLectureInfo5.lctreNm) {
                setData(
                    mainLectureInfo5.lctreNm,
                    mainLectureInfo5.instrctrNm,
                    mainLectureInfo5.edcStartDay,
                    mainLectureInfo5.edcEndDay,
                    mainLectureInfo5.edcStartTime,
                    mainLectureInfo5.edcColseTime,
                    mainLectureInfo5.lctreCo,
                    mainLectureInfo5.edcTrgetType,
                    mainLectureInfo5.edcMthType,
                    mainLectureInfo5.operDay,
                    mainLectureInfo5.edcPlace,
                    mainLectureInfo5.psncpa,
                    mainLectureInfo5.lctreCost,
                    mainLectureInfo5.edcRdnmadr,
                    mainLectureInfo5.operInstitutionNm,
                    mainLectureInfo5.operPhoneNumber,
                    mainLectureInfo5.rceptStartDate,
                    mainLectureInfo5.rceptEndDate,
                    mainLectureInfo5.rceptMthType,
                    mainLectureInfo5.slctnMthType,
                    mainLectureInfo5.homepageUrl,
                    mainLectureInfo5.oadtCtLctreYn,
                    mainLectureInfo5.pntBankAckestYn,
                    mainLectureInfo5.lrnAcnutAckestYn,
                    mainLectureInfo5.referenceDate,
                    mainLectureInfo5.insttCode
                )
            } else if (title == mainLectureInfo6.lctreNm) {
                setData(
                    mainLectureInfo6.lctreNm,
                    mainLectureInfo6.instrctrNm,
                    mainLectureInfo6.edcStartDay,
                    mainLectureInfo6.edcEndDay,
                    mainLectureInfo6.edcStartTime,
                    mainLectureInfo6.edcColseTime,
                    mainLectureInfo6.lctreCo,
                    mainLectureInfo6.edcTrgetType,
                    mainLectureInfo6.edcMthType,
                    mainLectureInfo6.operDay,
                    mainLectureInfo6.edcPlace,
                    mainLectureInfo6.psncpa,
                    mainLectureInfo6.lctreCost,
                    mainLectureInfo6.edcRdnmadr,
                    mainLectureInfo6.operInstitutionNm,
                    mainLectureInfo6.operPhoneNumber,
                    mainLectureInfo6.rceptStartDate,
                    mainLectureInfo6.rceptEndDate,
                    mainLectureInfo6.rceptMthType,
                    mainLectureInfo6.slctnMthType,
                    mainLectureInfo6.homepageUrl,
                    mainLectureInfo6.oadtCtLctreYn,
                    mainLectureInfo6.pntBankAckestYn,
                    mainLectureInfo6.lrnAcnutAckestYn,
                    mainLectureInfo6.referenceDate,
                    mainLectureInfo6.insttCode
                )
            } else if (title == mainLectureInfo7.lctreNm) {
                setData(
                    mainLectureInfo7.lctreNm,
                    mainLectureInfo7.instrctrNm,
                    mainLectureInfo7.edcStartDay,
                    mainLectureInfo7.edcEndDay,
                    mainLectureInfo7.edcStartTime,
                    mainLectureInfo7.edcColseTime,
                    mainLectureInfo7.lctreCo,
                    mainLectureInfo7.edcTrgetType,
                    mainLectureInfo7.edcMthType,
                    mainLectureInfo7.operDay,
                    mainLectureInfo7.edcPlace,
                    mainLectureInfo7.psncpa,
                    mainLectureInfo7.lctreCost,
                    mainLectureInfo7.edcRdnmadr,
                    mainLectureInfo7.operInstitutionNm,
                    mainLectureInfo7.operPhoneNumber,
                    mainLectureInfo7.rceptStartDate,
                    mainLectureInfo7.rceptEndDate,
                    mainLectureInfo7.rceptMthType,
                    mainLectureInfo7.slctnMthType,
                    mainLectureInfo7.homepageUrl,
                    mainLectureInfo7.oadtCtLctreYn,
                    mainLectureInfo7.pntBankAckestYn,
                    mainLectureInfo7.lrnAcnutAckestYn,
                    mainLectureInfo7.referenceDate,
                    mainLectureInfo7.insttCode
                )
            }else if (title == mainLectureInfo8.lctreNm) {
                setData(
                    mainLectureInfo8.lctreNm,
                    mainLectureInfo8.instrctrNm,
                    mainLectureInfo8.edcStartDay,
                    mainLectureInfo8.edcEndDay,
                    mainLectureInfo8.edcStartTime,
                    mainLectureInfo8.edcColseTime,
                    mainLectureInfo8.lctreCo,
                    mainLectureInfo8.edcTrgetType,
                    mainLectureInfo8.edcMthType,
                    mainLectureInfo8.operDay,
                    mainLectureInfo8.edcPlace,
                    mainLectureInfo8.psncpa,
                    mainLectureInfo8.lctreCost,
                    mainLectureInfo8.edcRdnmadr,
                    mainLectureInfo8.operInstitutionNm,
                    mainLectureInfo8.operPhoneNumber,
                    mainLectureInfo8.rceptStartDate,
                    mainLectureInfo8.rceptEndDate,
                    mainLectureInfo8.rceptMthType,
                    mainLectureInfo8.slctnMthType,
                    mainLectureInfo8.homepageUrl,
                    mainLectureInfo8.oadtCtLctreYn,
                    mainLectureInfo8.pntBankAckestYn,
                    mainLectureInfo8.lrnAcnutAckestYn,
                    mainLectureInfo8.referenceDate,
                    mainLectureInfo8.insttCode
                )
            }else if (title == mainLectureInfo9.lctreNm) {
                setData(
                    mainLectureInfo9.lctreNm,
                    mainLectureInfo9.instrctrNm,
                    mainLectureInfo9.edcStartDay,
                    mainLectureInfo9.edcEndDay,
                    mainLectureInfo9.edcStartTime,
                    mainLectureInfo9.edcColseTime,
                    mainLectureInfo9.lctreCo,
                    mainLectureInfo9.edcTrgetType,
                    mainLectureInfo9.edcMthType,
                    mainLectureInfo9.operDay,
                    mainLectureInfo9.edcPlace,
                    mainLectureInfo9.psncpa,
                    mainLectureInfo9.lctreCost,
                    mainLectureInfo9.edcRdnmadr,
                    mainLectureInfo9.operInstitutionNm,
                    mainLectureInfo9.operPhoneNumber,
                    mainLectureInfo9.rceptStartDate,
                    mainLectureInfo9.rceptEndDate,
                    mainLectureInfo9.rceptMthType,
                    mainLectureInfo9.slctnMthType,
                    mainLectureInfo9.homepageUrl,
                    mainLectureInfo9.oadtCtLctreYn,
                    mainLectureInfo9.pntBankAckestYn,
                    mainLectureInfo9.lrnAcnutAckestYn,
                    mainLectureInfo9.referenceDate,
                    mainLectureInfo9.insttCode
                )
            }else if (title == mainLectureInfo10.lctreNm) {
                setData(
                    mainLectureInfo10.lctreNm,
                    mainLectureInfo10.instrctrNm,
                    mainLectureInfo10.edcStartDay,
                    mainLectureInfo10.edcEndDay,
                    mainLectureInfo10.edcStartTime,
                    mainLectureInfo10.edcColseTime,
                    mainLectureInfo10.lctreCo,
                    mainLectureInfo10.edcTrgetType,
                    mainLectureInfo10.edcMthType,
                    mainLectureInfo10.operDay,
                    mainLectureInfo10.edcPlace,
                    mainLectureInfo10.psncpa,
                    mainLectureInfo10.lctreCost,
                    mainLectureInfo10.edcRdnmadr,
                    mainLectureInfo10.operInstitutionNm,
                    mainLectureInfo10.operPhoneNumber,
                    mainLectureInfo10.rceptStartDate,
                    mainLectureInfo10.rceptEndDate,
                    mainLectureInfo10.rceptMthType,
                    mainLectureInfo10.slctnMthType,
                    mainLectureInfo10.homepageUrl,
                    mainLectureInfo10.oadtCtLctreYn,
                    mainLectureInfo10.pntBankAckestYn,
                    mainLectureInfo10.lrnAcnutAckestYn,
                    mainLectureInfo10.referenceDate,
                    mainLectureInfo10.insttCode
                )
            }else if (title == mainLectureInfo11.lctreNm) {
                setData(
                    mainLectureInfo11.lctreNm,
                    mainLectureInfo11.instrctrNm,
                    mainLectureInfo11.edcStartDay,
                    mainLectureInfo11.edcEndDay,
                    mainLectureInfo11.edcStartTime,
                    mainLectureInfo11.edcColseTime,
                    mainLectureInfo11.lctreCo,
                    mainLectureInfo11.edcTrgetType,
                    mainLectureInfo11.edcMthType,
                    mainLectureInfo11.operDay,
                    mainLectureInfo11.edcPlace,
                    mainLectureInfo11.psncpa,
                    mainLectureInfo11.lctreCost,
                    mainLectureInfo11.edcRdnmadr,
                    mainLectureInfo11.operInstitutionNm,
                    mainLectureInfo11.operPhoneNumber,
                    mainLectureInfo11.rceptStartDate,
                    mainLectureInfo11.rceptEndDate,
                    mainLectureInfo11.rceptMthType,
                    mainLectureInfo11.slctnMthType,
                    mainLectureInfo11.homepageUrl,
                    mainLectureInfo11.oadtCtLctreYn,
                    mainLectureInfo11.pntBankAckestYn,
                    mainLectureInfo11.lrnAcnutAckestYn,
                    mainLectureInfo11.referenceDate,
                    mainLectureInfo11.insttCode
                )
            }else if (title == mainLectureInfo12.lctreNm) {
                setData(
                    mainLectureInfo12.lctreNm,
                    mainLectureInfo12.instrctrNm,
                    mainLectureInfo12.edcStartDay,
                    mainLectureInfo12.edcEndDay,
                    mainLectureInfo12.edcStartTime,
                    mainLectureInfo12.edcColseTime,
                    mainLectureInfo12.lctreCo,
                    mainLectureInfo12.edcTrgetType,
                    mainLectureInfo12.edcMthType,
                    mainLectureInfo12.operDay,
                    mainLectureInfo12.edcPlace,
                    mainLectureInfo12.psncpa,
                    mainLectureInfo12.lctreCost,
                    mainLectureInfo12.edcRdnmadr,
                    mainLectureInfo12.operInstitutionNm,
                    mainLectureInfo12.operPhoneNumber,
                    mainLectureInfo12.rceptStartDate,
                    mainLectureInfo12.rceptEndDate,
                    mainLectureInfo12.rceptMthType,
                    mainLectureInfo12.slctnMthType,
                    mainLectureInfo12.homepageUrl,
                    mainLectureInfo12.oadtCtLctreYn,
                    mainLectureInfo12.pntBankAckestYn,
                    mainLectureInfo12.lrnAcnutAckestYn,
                    mainLectureInfo12.referenceDate,
                    mainLectureInfo12.insttCode
                )
            }else if (title == mainLectureInfo13.lctreNm) {
                setData(
                    mainLectureInfo13.lctreNm,
                    mainLectureInfo13.instrctrNm,
                    mainLectureInfo13.edcStartDay,
                    mainLectureInfo13.edcEndDay,
                    mainLectureInfo13.edcStartTime,
                    mainLectureInfo13.edcColseTime,
                    mainLectureInfo13.lctreCo,
                    mainLectureInfo13.edcTrgetType,
                    mainLectureInfo13.edcMthType,
                    mainLectureInfo13.operDay,
                    mainLectureInfo13.edcPlace,
                    mainLectureInfo13.psncpa,
                    mainLectureInfo13.lctreCost,
                    mainLectureInfo13.edcRdnmadr,
                    mainLectureInfo13.operInstitutionNm,
                    mainLectureInfo13.operPhoneNumber,
                    mainLectureInfo13.rceptStartDate,
                    mainLectureInfo13.rceptEndDate,
                    mainLectureInfo13.rceptMthType,
                    mainLectureInfo13.slctnMthType,
                    mainLectureInfo13.homepageUrl,
                    mainLectureInfo13.oadtCtLctreYn,
                    mainLectureInfo13.pntBankAckestYn,
                    mainLectureInfo13.lrnAcnutAckestYn,
                    mainLectureInfo13.referenceDate,
                    mainLectureInfo13.insttCode
                )
            }

        }
    }

    fun setData(
        lctreNm: String,
        instrctrNm: String,
        edcStartDay: String,
        edcEndDay: String,
        edcStartTime: String,
        edcColseTime: String,
        lctreCo: String,
        edcTrgetType: String,
        edcMthType: String,
        operDay: String,
        edcPlace: String,
        psncpa: String,
        lctreCost: String,
        edcRdnmadr: String,
        operInstitutionNm: String,
        operPhoneNumber: String,
        rceptStartDate: String,
        rceptEndDate: String,
        rceptMthType: String,
        slctnMthType: String,
        homepageUrl: String,
        oadtCtLctreYn: String,
        pntBankAckestYn: String,
        lrnAcnutAckestYn: String,
        referenceDate: String,
        insttCode: String
    ) {
        val intent = Intent(context, LectureInformationActivity::class.java)

        intent.putExtra("lctreNm", lctreNm)
        intent.putExtra("instrctrNm", instrctrNm)
        intent.putExtra("edcStartDay", edcStartDay)
        intent.putExtra("edcEndDay", edcEndDay)
        intent.putExtra("edcStartTime", edcStartTime)
        intent.putExtra("edcColseTime", edcColseTime)
        intent.putExtra("lctreCo", lctreCo)
        intent.putExtra("edcTrgetType", edcTrgetType)
        intent.putExtra("edcMthType", edcMthType)
        intent.putExtra("operDay", operDay)
        intent.putExtra("edcPlace", edcPlace)
        intent.putExtra("psncpa", psncpa)
        intent.putExtra("lctreCost", lctreCost)
        intent.putExtra("edcRdnmadr", edcRdnmadr)
        intent.putExtra("operInstitutionNm", operInstitutionNm)
        intent.putExtra("operPhoneNumber", operPhoneNumber)
        intent.putExtra("rceptStartDate", rceptStartDate)
        intent.putExtra("rceptEndDate", rceptEndDate)
        intent.putExtra("slctnMthType", slctnMthType)
        intent.putExtra("homepageUrl", homepageUrl)
        intent.putExtra("pntBankAckestYn", pntBankAckestYn)
        intent.putExtra("lrnAcnutAckestYn", lrnAcnutAckestYn)
        intent.putExtra("referenceDate", referenceDate)
        intent.putExtra("insttCode", insttCode)
        intent.putExtra("oadtCtLctreYn", oadtCtLctreYn)
        intent.putExtra("rceptMthType", rceptMthType)

        startActivity(intent)
    }

    companion object {
        @JvmStatic
        fun newInstance(
            title: String, location: String, period: String, day_time: String,
            price: String, method: String
        ) =
            MainLecture().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, title)
                    putString(ARG_PARAM2, location)
                    putString(ARG_PARAM3, period)
                    putString(ARG_PARAM4, day_time)
                    putString(ARG_PARAM5, price)
                    putString(ARG_PARAM6, method)
                }
            }
    }

    val mainLectureInfo1 = MainLectureInfo(
        "흉노·돌궐과비잔틴·오스만제국을 계승한, 터키",
        "김시열",
        "2022-06-02",
        "2022-08-24",
        "10:00",
        "12:00",
        "현대 세계사로 보는 우리의 미래",
        "서초구민",
        "오프라인",
        "수",
        "서초구 평생학습관",
        "50",
        "30000",
        "서울특별시 서초구 방배로 173",
        "서초구 평생학습관",
        "02-2155-8394",
        "2022-05-16",
        "?",
        "온라인",
        "선착순",
        "https://www.seocho.go.kr/site/seocho/main.do",
        "N",
        "N",
        "N",
        "2022-07-28",
        "4860000"
    )
    val mainLectureInfo2 = MainLectureInfo(
        "엑셀, 파워포인트&자격증(ITQ파워)(야간)",
        "정해숙",
        "2022-02-07",
        "2022-06-24",
        "18:30",
        "21:00",
        "엑셀, 파워포인트&자격증(ITQ파워)(야간)",
        "성인",
        "오프라인",
        "목",
        "의왕시평생학습관",
        "15",
        "750000",
        "경기도 의왕시 오전로 122",
        "경기도 의왕시청 평생교육과",
        "031-345-3845",
        "2022-01-11",
        "?",
        "온라인",
        "컴퓨터 추첨", "edu.uiwang.go.kr", "?", "?", "?", "2022-11-23", "4860000"
    )
    val mainLectureInfo3 = MainLectureInfo(
        "[구민제안프로그램]금융사기예방 연극 네 놈 목소리",
        "시니어금융교육협의회",
        "2022-09-15",
        "2022-09-15",
        "10:00",
        "12:00",
        "금융사기 예방을 주제로한 연극 공연",
        "일반구민",
        "오프라인",
        "수",
        "부평구 평생학습관",
        "20",
        "무료",
        "인천광역시 부평구 장제로 235 4층 어울림센터 평생학습관(부평동)",
        "인천광역시 부평구청",
        "032-509-6437",
        "2022-08-08",
        "2022-08-19",
        "인터넷 접수",
        "선착순", "http://www.icbp.go.kr/lll/", "N", "N", "N", "2022-11-07", "4860000"
    )
    val mainLectureInfo4 = MainLectureInfo(
        "치매예방 실버인지놀이지도사 1급",
        "안영신",
        "2022-04-13",
        "2022-08-03",
        "14:00",
        "16:00",
        "치매예방 실버인지놀이지도사 1급",
        "지역주민(성인)",
        "오프라인",
        "수",
        "부여군 평생학습관",
        "12",
        "무료",
        "충청남도 부여군 부여읍 성왕로 376",
        "충청남도 부여군청",
        "041-830-6851",
        "2022-03-30",
        "2022-04-06",
        "인터넷 접수",
        "추첨제", "www.buyeo.go.kr/html/lll", "N", "N", "N", "2022-11-16", "4860000"
    )
    val mainLectureInfo5 = MainLectureInfo(
        "힐링테라피 손글씨&캘리그라피",
        "변은하",
        "2022-08-22",
        "2022-12-09",
        "09:30",
        "10:30",
        "힐링테라피 손글씨&캘리그라피",
        "성인",
        "온라인",
        "수 + 금",
        "207",
        "15",
        "무료",
        "강원도 태백시 태백로 1239",
        "강원도 태백시 평생학습관",
        "033-550-2751",
        "2022-08-03",
        "2022-08-12",
        "인터넷",
        "선착순", "www.taebaek.go.kr", "N", "N", "N", "2022-11-18", "4860000"
    )
    val mainLectureInfo6 = MainLectureInfo(
        "스마트폰배우기(아이폰제외)",
        "김미라",
        "2022-10-04",
        "2022-12-24",
        "16:00",
        "18:00",
        "스마트폰 및 SNS 활용법 익히기(안드로이드기반)",
        "지역주민",
        "혼합",
        "화 + 목",
        "구암평생학습센터",
        "20",
        "30000",
        "대전광역시 유성구 유성대로626번길 57(구암동)",
        "대전광역시 유성구청",
        "042-611-6565",
        "2022-09-06",
        "2022-09-13",
        "인터넷",
        "추첨", "http://lifelong.yuseong.go.kr/", "N", "N", "N", "2022-11-16", "4860000"
    )
    val mainLectureInfo7 = MainLectureInfo(
        "민화로 만나는 전통그림 A",
        "손현정",
        "2022-03-22",
        "2022-05-31",
        "16:00",
        "18:00",
        "민화",
        "하동군민",
        "오프라인",
        "화",
        "하동문화예술회관 2층 취미교실",
        "16",
        "160000",
        "경상남도 하동군 하동읍 섬진강대로 2222",
        "경상남도 하동군 평생학습센터",
        "055-880-2184",
        "2021-12-15",
        "2022-01-15",
        "현장 + 전화접수",
        "선착순",
        "https://www.hadong.go.kr/specialty/00920/00935.web",
        "N",
        "N",
        "N",
        "2022-11-21",
        "4860000"
    )
    val mainLectureInfo8 = MainLectureInfo(
        "힐링의 되는 따뜻한 손뜨개(성인반)",
        "박해숙",
        "2022-12-05",
        "2023-02-26",
        "19:00",
        "20:50",
        "손뜨개 기법을 활용하여 다양한 실생활 소품만들기",
        "지역주민",
        "오프라인",
        "월",
        "만촌평생학습센터",
        "10",
        "30000",
        "대구광역시 수성구 국채보상로 1001 (만촌동)",
        "대구광역시 수성구청",
        "053-666-4671",
        "2022-11-17",
        "2022-11-24",
        "인터넷",
        "선착순", "lll.suseong.kr", "N", "N", "N", "2022-11-07", "4860000"
    )
    val mainLectureInfo9 = MainLectureInfo(
        "처음부터 배워보는 홈패션(재봉틀)",
        "김미영",
        "2022-10-12",
        "2022-12-24",
        "10:00",
        "12:00",
        "처음부터 배워보는 홈패션(재봉틀)",
        "구민 누구나",
        "오프라인",
        "수",
        "북구평생학습관",
        "16",
        "86000",
        "울산광역시 북구 산업로 1024(연암동)",
        "울산광역시 북구 평생학습관",
        "052-241-7396",
        "2022-09-02",
        "2022-10-01",
        "인터넷",
        "선착순", "http://www.bukgu.ulsan.kr/edu/", "N", "N", "N", "2022-10-31", "4860000"
    )
    val mainLectureInfo10 = MainLectureInfo(
        "한지공예(한국한지공예문화자격증 3급)",
        "송지현",
        "2022-09-13",
        "2022-11-29",
        "14:00",
        "16:00",
        "한지공예를 통해 각종 소품을 만들어보는 과정",
        "해운대 성인구민",
        "오프라인",
        "화",
        "해운대구 평생학습관",
        "15",
        "무료",
        "부산광역시 해운대구 삼어로 133번길 50",
        "부산광역시 해운대구청 소통협력과 평생교육팀",
        "051-749-5635",
        "2022-08-24",
        "2022-08-25",
        "인터넷",
        "추첨제", "http://hedu.haeundae.go.kr/", "N", "N", "N", "2022-11-18", "4860000"
    )
    val mainLectureInfo11 = MainLectureInfo(
        "왕초보영어 웅포하제반",
        "유문상",
        "2022-02-14",
        "2022-12-20",
        "12:00",
        "14:00",
        "문해교육(기초영어)",
        "성인(어르신 등)",
        "오프라인",
        "월+수+금",
        "웅포하제경로당",
        "20",
        "무료",
        "전라북도 익산시 제성1길 6",
        "전라북도 익산시청",
        "063-859-5825",
        "2022-01-02",
        "2022-12-20",
        "전화접수",
        "선착순", "www.iksan.go.kr/lll", "N", "N", "N", "2022-09-15", "4860000"
    )
    val mainLectureInfo12 = MainLectureInfo(
        "산야초를 이용한클랜징폼만들기",
        "조은순",
        "2022-11-29",
        "2022-11-29",
        "15:00",
        "16:00",
        "공예강좌",
        "지역주민",
        "오프라인",
        "화",
        "동구평생학습관",
        "15",
        "무료",
        "광주광역시 동구 백서로 175번길 15(서석동)",
        "광주광역시 동구청",
        "062-608-2633",
        "2022-11-01",
        "2022-11-25",
        "어플접수",
        "자격심사", "https://www.donggu.kr/index.es?sid=a6", "N", "N", "N", "2022-11-07", "4860000"
    )
    val mainLectureInfo13 = MainLectureInfo(
        "나도 글쓰기 작가",
        "차영민",
        "2022-10-01",
        "2022-11-30",
        "10:00",
        "13:00",
        "개인의 능력 개발을 통한 여러장르의 다양한 글쓰기 기법 배우기",
        "성인",
        "오프라인",
        "토",
        "평생학습관",
        "15",
        "20000",
        "제주특별자치도 서귀포시 서문로29번길 10",
        "제주특별자치도 서귀포시 평생학습관",
        "064-760-3872",
        "2022-09-15",
        "2022-09-22",
        "인터넷",
        "선착순", "http://edu.seogwipo.go.kr/", "N", "N", "N", "2022-09-28", "4860000"
    )

}