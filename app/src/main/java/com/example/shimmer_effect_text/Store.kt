package com.example.shimmer_effect_text

data class Store(
    val coverImg: Int? = null,
    val name: String,
    val cost: String
)

fun getStoreList(): List<Store> {
    return listOf(
        Store(R.drawable.img1,"론드 린넨 볼레로 가디건", "22,800"),
        Store(R.drawable.img2,"썸머 에브리데이 런드리 반팔T", "18,000"),
        Store(R.drawable.img3,"Shoot Pigment Washing Crop Tee", "32,000"),
        Store(R.drawable.img4,"포포 여리핏 썸머 부클 가디건", "31,000"),
        Store(R.drawable.img5,"로이스 하찌 울 크롭가디건", "45,900"),
        Store(R.drawable.img6,"스트라이프 배색 면가디건", "41,500")
    )
}