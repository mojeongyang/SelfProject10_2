package com.example.selfproject10_2

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    // 이미지 리소스 배열
    private val imageResIds = arrayOf(
        R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
        R.drawable.pic4, R.drawable.pic5, R.drawable.pic6,
        R.drawable.pic7, R.drawable.pic8, R.drawable.pic9
    )

    // 여기서 제목 배열 직접 선언
    private val imageNames = arrayOf(
        "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
        "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매",
        "피아노 레슨", "피아노 앞의 소녀들", "해변에서"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val voteCount = intent.getIntArrayExtra("voteCount")!!

        // 최다 득표 index 구하기
        var maxIndex = 0
        for (i in voteCount.indices) {
            if (voteCount[i] > voteCount[maxIndex]) maxIndex = i
        }

        // 제목 표시
        val tvResultTitle = findViewById<TextView>(R.id.tvResultTitle)
        tvResultTitle.text = imageNames[maxIndex]

        // 이미지 표시
        val ivResult = findViewById<ImageView>(R.id.ivResult)
        ivResult.setImageResource(imageResIds[maxIndex])

        // 제목 TextView 배열
        val nameTextViews = arrayOf(
            findViewById<TextView>(R.id.tvName1),
            findViewById<TextView>(R.id.tvName2),
            findViewById<TextView>(R.id.tvName3),
            findViewById<TextView>(R.id.tvName4),
            findViewById<TextView>(R.id.tvName5),
            findViewById<TextView>(R.id.tvName6),
            findViewById<TextView>(R.id.tvName7),
            findViewById<TextView>(R.id.tvName8),
            findViewById<TextView>(R.id.tvName9)
        )

        // RatingBar 배열
        val ratingBars = arrayOf(
            findViewById<RatingBar>(R.id.rb1),
            findViewById<RatingBar>(R.id.rb2),
            findViewById<RatingBar>(R.id.rb3),
            findViewById<RatingBar>(R.id.rb4),
            findViewById<RatingBar>(R.id.rb5),
            findViewById<RatingBar>(R.id.rb6),
            findViewById<RatingBar>(R.id.rb7),
            findViewById<RatingBar>(R.id.rb8),
            findViewById<RatingBar>(R.id.rb9)
        )

        // 데이터 적용
        for (i in 0..8) {
            nameTextViews[i].text = imageNames[i]
            ratingBars[i].rating = voteCount[i].toFloat()
        }

        // 뒤로가기
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}

