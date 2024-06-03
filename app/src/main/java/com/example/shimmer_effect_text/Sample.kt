package com.example.shimmer_effect_text

data class Sample(
    val coverImg: Int? = null,
    val name: String,
    val email: String
)

fun getSampleList(): List<Sample> {
    return listOf(
        Sample(R.drawable.img1,"정승원", "1234@gmail.com"),
        Sample(R.drawable.img2,"김훈", "5678@naver.com"),
        Sample(R.drawable.img3,"정서현", "dddd@kakao.com"),
        Sample(R.drawable.img4,"홍다빈", "ekqls@naver.com"),
        Sample(R.drawable.img6,"AOS", "android@gmail.com"),
        Sample(R.drawable.img1,"UMC", "umc@naver.com")
    )
}