package yonghun.ksg.lifelonglearningapp

import android.content.Intent
import android.os.Bundle
import yonghun.ksg.lifelonglearningapp.databinding.ActivityLectureinformationBinding
import kotlinx.android.synthetic.main.activity_lectureinformation.*
import android.location.Geocoder
import android.net.Uri
import android.util.Log
import androidx.annotation.UiThread
import androidx.fragment.app.FragmentActivity
import yonghun.ksg.lifelonglearningapp.BuildConfig
import com.gun0912.tedpermission.provider.TedPermissionProvider.context
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker
import java.util.*


class LectureInformationActivity : FragmentActivity(), OnMapReadyCallback {
    private lateinit var binding: ActivityLectureinformationBinding
    lateinit var location: LatLng
    lateinit var edcRdnmadr: String
    lateinit var edcPlace: String
    lateinit var operPhoneNumber: String
    private lateinit var naverMap: NaverMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient(BuildConfig.NAVER_APIKEY)
        binding = ActivityLectureinformationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        location = getLatLng(edcRdnmadr!!)
        init()

        textview_operPhoneNumber.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + operPhoneNumber)
            startActivity(dialIntent)
        }

        textview_homepageUrl.setOnClickListener {
            var homepage = Intent(
                Intent.ACTION_VIEW, Uri.parse(textview_homepageUrl.text.toString()))
            startActivity(homepage)

        }
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
        edcPlace = intent?.getString("edcPlace").toString()
        var psncpa = intent?.getString("psncpa")
        var lctreCost = intent?.getString("lctreCost")
        edcRdnmadr = intent?.getString("edcRdnmadr").toString()
        var operInstitutionNm = intent?.getString("operInstitutionNm")
        operPhoneNumber = intent?.getString("operPhoneNumber").toString()
        var rceptStartDate = intent?.getString("rceptStartDate")
        var rceptEndDate = intent?.getString("rceptEndDate")
        var rceptMthType = intent?.getString("rceptMthType")
        var slctnMthType = intent?.getString("slctnMthType")
        var homepageUrl = intent?.getString("homepageUrl").toString()
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
        textview_edcStartDay.text = edcStartDay + " ~ " + edcEndDay
        textview_operDay.text = operDay
        textview_time.text = edcStartTime + " ~ " + edcColseTime
        lecture_content.text = lctreCo
        textview_rceptStartDate.text = rceptStartDate + " ~ " + rceptEndDate
        textview_instrctrNm.text = instrctrNm
        textview_oadtCtLctreYn.text = oadtCtLctreYn
        textview_pntBankAckestYn.text = pntBankAckestYn
        textview_lrnAcnutAckestYn.text = lrnAcnutAckestYn
        textview_referenceDate.text = referenceDate
        if(homepageUrl.contains("/")){
            textview_homepageUrl.text = homepageUrl
        }else{
            textview_homepageUrl.text = "https://" + homepageUrl
        }


    }


    @UiThread
    override fun onMapReady(naverMap: NaverMap) {
        this.naverMap = naverMap


        val cameraPosition = CameraPosition(
            location,  // 위치 지정
            16.3
        )

        naverMap.setCameraPosition(cameraPosition)
        naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_BUILDING, true);


        val marker = Marker()
        marker.captionText = edcPlace
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