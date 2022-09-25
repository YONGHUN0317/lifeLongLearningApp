package com.example.lifelonglearningapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lifelonglearningapp.databinding.FragmentMainLectureBinding
import kotlinx.android.synthetic.main.fragment_main_lecture.*

private const val ARG_PARAM1 = "title"
private const val ARG_PARAM2 = "location"
private const val ARG_PARAM3 = "period"
private const val ARG_PARAM4 = "day_time"
private const val ARG_PARAM5 = "price"
private const val ARG_PARAM6 = "method"

private var _binding: FragmentMainLectureBinding? = null
private val binding get() = _binding!!


class MainLecture : Fragment() {
    // TODO: Rename and change types of parameters
    private var title: String? = null
    private var location: String? = null
    private var period: String? = null
    private var day_time: String? = null
    private var price: String? = null
    private var method: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_PARAM1)
            location = it.getString(ARG_PARAM2)
            period = it.getString(ARG_PARAM3)
            day_time = it.getString(ARG_PARAM4)
            price = it.getString(ARG_PARAM5)
            method = it.getString(ARG_PARAM6)
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
        binding.lectureLocation.text = location
        binding.lecturePeriod.text = period
        binding.lectureDayTime.text = day_time
        binding.lecturePrice.text = price
        binding.lectureMethod.text = method
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