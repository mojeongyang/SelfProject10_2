package com.example.selfproject10_2

import kotlin.jvm.java

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // 9개 이미지에 대한 투표 수 배열
    private val voteCount = IntArray(9) { 0 }

    // 이미지 제목 (ResultActivity에서 사용)
    private val imageNames = arrayOf(
        "그림 1", "그림 2", "그림 3",
        "그림 4", "그림 5", "그림 6",
        "그림 7", "그림 8", "그림 9"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 이미지뷰 ID 배열
        val imageIds = arrayOf(
            R.id.iv1, R.id.iv2, R.id.iv3,
            R.id.iv4, R.id.iv5, R.id.iv6,
            R.id.iv7, R.id.iv8, R.id.iv9
        )

        // 각 이미지 클릭 시 투표 증가
        for (i in imageIds.indices) {
            val imageView = findViewById<ImageView>(imageIds[i])
            imageView.setOnClickListener {
                voteCount[i]++
                // 클릭 시 간단한 Toast 출력(선택사항)
                // Toast.makeText(this, "${imageNames[i]} : ${voteCount[i]} 표", Toast.LENGTH_SHORT).show()
            }
        }

        // 투표 종료 버튼 → ResultActivity로 이동
        val btnResult = findViewById<Button>(R.id.btnResult)
        btnResult.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)

            // 배열 전달
            intent.putExtra("voteCount", voteCount)
            intent.putExtra("imageNames", imageNames)

            startActivity(intent)
        }
    }
}
