package com.example.lifelonglearningapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class MyPageradapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {

    private val NUM_PAGES = 13
    override fun getItemCount(): Int = NUM_PAGES
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                MainLecture.newInstance("흉노·돌궐과비잔틴·오스만제국을 계승한, 터키", "김시열", "2022-06-02 ~ 2022-08-24", "10:00 ~ 12:00", "30000", "서초구 평생학습관")
            }
            1 -> {
                MainLecture.newInstance("엑셀, 파워포인트&자격증(ITQ파워)(야간)", "정해숙", "2022-02-07 ~ 2022-06-24", "18:30 ~ 21:00", "750000", "경기도 의왕시청 평생교육과")
            }
            2 -> {
                MainLecture.newInstance("[구민제안프로그램]금융사기예방 연극 네 놈 목소리", "시니어금융교육협의회", "2022-09-15 ~ 2022-09-15", "10:00 ~ 12:00", "무료", "부평구 평생학습관")
            }
            3 -> {
                MainLecture.newInstance("치매예방 실버인지놀이지도사 1급", "안영신", "2022-04-13 ~ 2022-08-03", "14:00 ~ 16:00", "무료", "부여군 평생학습관")
            }
            4 -> {
                MainLecture.newInstance("힐링테라피 손글씨&캘리그라피", "변은하", "2022-08-22 ~ 2022-12-09", "9:30 ~ 10:30", "무료", "강원도 태백시 평생학습관")
            }
            5 -> {
                MainLecture.newInstance("스마트폰배우기(아이폰제외)", "김미라", "2022-10-04 ~ 2022-12-24", "16:00 ~ 18:00", "30000", "구암평생학습센터")
            }
            6 -> {
                MainLecture.newInstance("민화로 만나는 전통그림 A", "손현정", "2022-03-22 ~ 2022-05-31", "16:00 ~ 18:00", "160000", "하동문화예술회관 2층 취미교실")
            }
            7 -> {
                MainLecture.newInstance("힐링의 되는 따뜻한 손뜨개(성인반)", "박해숙", "2022-12-05 ~ 2023-02-26", "19:00 ~ 20:50", "30000", "만촌평생학습센터")
            }
            8 -> {
                MainLecture.newInstance("처음부터 배워보는 홈패션(재봉틀)", "김미영", "2022-10-12 ~ 2022-12-14", "10:00 ~ 12:10", "76000", "북구평생학습관")
            }
            9 -> {
                MainLecture.newInstance("한지공예(한국한지공예문화자격증 3급)", "송지현", "2022-09-13 ~ 2022-11-15", "10:00 ~ 12:00", "무료", "해운대구 평생학습관")
            }
            10 -> {
                MainLecture.newInstance("왕초보영어 웅포하제반", "손충기", "2022-02-14 ~ 2022-12-20", "12:00 ~ 14:00", "무료", "웅포하제경로당")
            }
            11 -> {
                MainLecture.newInstance("산야초를 이용한클랜징폼만들기", "조은순", "2022-11-29 ~ 2022-11-29", "15:00 ~ 16:00", "무료", "동구평생학습관")
            }
            else -> {
                MainLecture.newInstance("나도 글쓰기 작가", "차영민", "2022-10-01 ~ 2022-11-30", "10:00 ~ 13:00", "20000", "평생학습관")
            }
        }
    }

}