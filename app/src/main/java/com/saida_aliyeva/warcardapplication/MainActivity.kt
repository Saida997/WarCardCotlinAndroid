package com.saida_aliyeva.warcardapplication

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var scorePlayer_ = 0
    var scoreCPU_ = 0
    //    val cards = listOf<String>("R.drawable.card10", "R.drawable.card11","R.drawable.card9", "R.drawable.card8",
//        "R.drawable.card7", "R.drawable.card6","R.drawable.card5", "R.drawable.card4",
//        "R.drawable.card3", "R.drawable.card2","R.drawable.card14", "R.drawable.card13","R.drawable.card12"
//        )
    val cards = listOf<Int>(
        R.drawable.card10, R.drawable.card11, R.drawable.card9, R.drawable.card8,
        R.drawable.card7, R.drawable.card6, R.drawable.card5, R.drawable.card4,
        R.drawable.card3, R.drawable.card2, R.drawable.card14, R.drawable.card13, R.drawable.card12
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b_deal.setOnClickListener() {
            if (scorePlayer_ <20 && scoreCPU_ <20) {
                var leftNumber = Random.nextInt(0, 12)
                var rightNumber = Random.nextInt(0, 12)
                Log.e("Saida", leftNumber.toString())
                iv_card_left.setImageResource(cards.get(leftNumber))
                iv_card_right.setImageResource(cards.get(rightNumber))
                if (leftNumber != rightNumber) {
                    if (leftNumber > rightNumber) {
                        scorePlayer_ += 1
                        tv_score_left.text = scorePlayer_.toString()
                    } else {
                        scoreCPU_ += 1
                        tv_score_right.text = scoreCPU_.toString()
                    }
                } else {
                    print("score is equal")
                }

            } else {
                defineWinner()

            }
        }
    }


    fun defineWinner() {
        if (scorePlayer_ > scoreCPU_) {
            Toast.makeText(this, "winner is Player", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "winner is CPU", Toast.LENGTH_SHORT).show()
        }
        scorePlayer_ = 0
        scoreCPU_ = 0
        tv_score_left.text = "0"
        tv_score_right.text = "0"


    }

}
