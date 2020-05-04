package cl.jesualex.tooltip.main.activity

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.app.AppCompatActivity
import cl.jesualex.stooltip.Position
import cl.jesualex.stooltip.Tooltip
import cl.jesualex.tooltip.R
import cl.jesualex.tooltip.main.fragment.TestFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

fun Context.getColorCompat(@ColorRes id: Int) = ResourcesCompat.getColor(resources, id, null)

class MainActivity : AppCompatActivity() {
    private lateinit var tooltip: Tooltip

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        tooltip = Tooltip.on(exampleTextView)
            .text(R.string.example)
            .icon(android.R.drawable.ic_dialog_info)
            .iconSize(30, 30)
            .color(getColorCompat(R.color.colorPrimary))
            .overlay(getColorCompat(R.color.overlay))
            .drawableRight(R.drawable.ic_android_black_24dp)
            .border(Color.BLACK, 1f)
            .clickToHide(true)
            .corner(5)
            .position(Position.TOP)
            .create()

        showTooltipButton.setOnClickListener {
                tooltip.show(duration = 3000)
        }

        addFragmentButton.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, TestFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}