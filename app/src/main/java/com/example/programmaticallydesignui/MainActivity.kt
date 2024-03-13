package com.example.programmaticallydesignui


import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.ViewCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val constraintLayout = ConstraintLayout(this)
        constraintLayout.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )

        val cardView = CardView(this)
        cardView.id = ViewCompat.generateViewId()
        cardView.layoutParams = ViewGroup.LayoutParams(
            400,
            500
        )
        cardView.radius = 16f

        val imageView = ImageView(this)
        imageView.id = ViewCompat.generateViewId()
        val imageViewLayoutParams = ConstraintLayout.LayoutParams(
            120,
             120
        )
        imageViewLayoutParams.setMargins(140, 140, 0, 0)
        imageView.layoutParams = imageViewLayoutParams
        imageView.setImageResource(R.drawable.baseline_directions_bike_24)
        cardView.addView(imageView)


        val textView = TextView(this)
        textView.id = ViewCompat.generateViewId()
        val textViewLayoutParams = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        textViewLayoutParams.setMargins(130, 250, 0, 0)
        textView.layoutParams = textViewLayoutParams
        textView.setTextColor(resources.getColor(android.R.color.black))
        textView.text = "Bike"
        textView.setTextColor(Color.parseColor("#9C27B0"))
        textView.textSize = 20f
        textView.setTypeface(null, Typeface.BOLD)
        cardView.addView(textView)


        constraintLayout.addView(cardView)
        val constraintSet = ConstraintSet()
        constraintSet.clone(constraintLayout)
        constraintSet.connect(
            cardView.id,
            ConstraintSet.START,
            ConstraintSet.PARENT_ID,
            ConstraintSet.START
        )
        constraintSet.connect(
            cardView.id,
            ConstraintSet.TOP,
            ConstraintSet.PARENT_ID,
            ConstraintSet.TOP
        )
        constraintSet.connect(
            cardView.id,
            ConstraintSet.END,
            ConstraintSet.PARENT_ID,
            ConstraintSet.END
        )

        constraintSet.applyTo(constraintLayout)
        setContentView(constraintLayout)
    }
}
