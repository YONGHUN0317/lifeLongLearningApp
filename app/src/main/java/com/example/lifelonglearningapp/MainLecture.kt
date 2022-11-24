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


        view.setOnClickListener{
            val intent = Intent(context, LectureInformationActivity::class.java)
            intent.putExtra("lctreNm", title)
            intent.putExtra("instrctrNm", instrctrNm)
            intent.putExtra("edcPlace", edcPlace)
            intent.putExtra("lctreCost", price)
            startActivity(intent)

        }
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String, location: String, period: String, day_time: String,
                        price:String, method: String) =
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
}