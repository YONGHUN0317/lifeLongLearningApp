package com.example.lifelonglearningapp

import android.app.Activity
import android.location.Address
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lifelonglearningapp.databinding.ActivityAftersearchBinding
import com.example.lifelonglearningapp.databinding.ActivityAftersearchBinding.inflate
import com.example.lifelonglearningapp.databinding.ActivityLectureinformationBinding
import com.naver.maps.map.NaverMap
import kotlinx.android.synthetic.main.activity_lectureinformation.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.lang.StringBuilder
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import android.location.Geocoder
import android.util.Log
import androidx.annotation.UiThread
import androidx.fragment.app.FragmentActivity

import com.gun0912.tedpermission.provider.TedPermissionProvider.context
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMapOptions
import com.naver.maps.map.overlay.Marker
import java.util.*
import com.naver.maps.map.overlay.OverlayImage
import com.naver.maps.map.widget.ZoomControlView


class LectureInformationActivity : FragmentActivity(), com.naver.maps.map.OnMapReadyCallback {
    private lateinit var binding: ActivityLectureinformationBinding
    lateinit var location: LatLng
    lateinit var edcRdnmadr: String
    private lateinit var naverMap: NaverMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLectureinformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        location = getLatLng(edcRdnmadr!!)
        init()
    }

    fun init() {
        val fm = supportFragmentManager
        val mapFragment = fm.findFragmentById(R.id.map_view) as MapFragment?
            ?: MapFragment.newInstance().also {
                fm.beginTransaction().add(R.id.map_view, it).commit()
            }

        mapFragment.getMapAsync(this)
    }

    fun getData() {
        var intent = intent.extras

        var lctreNm = intent?.getString("lctreNm")
        var instrctrNm = intent?.getString("instrctrNm")
        var edcStartDay = intent?.getString("edcStartDay")
        var edcEndDay = intent?.getString("edcEndDay")
        var edcStartTime = intent?.getString("edcStartTime")
        var edcColseTime = intent?.getString("edcColseTime")
        var lctreCo = intent?.getString("lctreCo")
        var edcTrgetType = intent?.getString("edcTrgetType")
        var edcMthType = intent?.getString("edcMthType")
        var operDay = intent?.getString("operDay")
        var edcPlace = intent?.getString("edcPlace")
        var psncpa = intent?.getString("psncpa")
        var lctreCost = intent?.getString("lctreCost")
        edcRdnmadr = intent?.getString("edcRdnmadr").toString()
        var operInstitutionNm = intent?.getString("operInstitutionNm")
        var operPhoneNumber = intent?.getString("operPhoneNumber")
        var rceptStartDate = intent?.getString("rceptStartDate")
        var rceptEndDate = intent?.getString("rceptEndDate")
        var rceptMthType = intent?.getString("rceptMthType")
        var slctnMthType = intent?.getString("slctnMthType")
        var homepageUrl = intent?.getString("homepageUrl")
        var pntBankAckestYn = intent?.getString("pntBankAckestYn")
        var lrnAcnutAckestYn = intent?.getString("lrnAcnutAckestYn")
        var referenceDate = intent?.getString("referenceDate")
        var insttCode = intent?.getString("insttCode")
        var oadtCtLctreYn = intent?.getString("oadtCtLctreYn")

        textview_lctrNm.text = lctreNm
        lecture_seats.text = psncpa
        lecture_tuition.text = lctreCost
        lecture_selection.text = slctnMthType
        lecture_register.text = rceptMthType
        lecture_target.text = edcMthType
        textview_edcPlace.text = edcPlace
        textview_operPhoneNumber.text = operPhoneNumber
        textview_edcTrgetType.text = edcTrgetType
        lecture_date.text = edcStartDay + " ~ " + edcEndDay
        textview_operDay.text = operDay
        textview_time.text = edcStartTime + " ~ " + edcColseTime
        lecture_content.text = lctreCo
        textview_instrctrNm.text = instrctrNm
        textview_oadtCtLctreYn.text = oadtCtLctreYn
        textview_pntBankAckestYn.text = pntBankAckestYn
        textview_lrnAcnutAckestYn.text = lrnAcnutAckestYn
        textview_referenceDate.text = referenceDate

    }


    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap
        val uiSettings = naverMap.uiSettings

        val cameraPosition = CameraPosition(
            location,  // 위치 지정
            16.3
        )

        naverMap.setCameraPosition(cameraPosition)
        naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_BUILDING, true);

        uiSettings.isZoomControlEnabled = true
        val marker = Marker()
        marker.position = location
        marker.map = naverMap
    }

    private fun getLatLng(address: String): LatLng {
        val geoCoder = Geocoder(context, Locale.KOREA)   // Geocoder 로 자기 나라에 맞게 설정
        val list = geoCoder.getFromLocationName(address, 3)
        var location = LatLng(37.554891, 126.970814)     //임시 서울역

        if (list != null) {
            if (list.size == 0) {
                Log.d("GeoCoding", "해당 주소로 찾는 위도 경도가 없습니다. 올바른 주소를 입력해주세요.")
            } else {
                val addressLatLng = list[0]
                location = LatLng(addressLatLng.latitude, addressLatLng.longitude)
                return location
            }
        }

        return location
    }


}