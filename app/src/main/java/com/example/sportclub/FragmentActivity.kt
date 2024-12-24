package com.example.sportclub

import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout

class FragmentActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var frameLayout: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_fragment)

        tabLayout = findViewById(R.id.tablayout)
        frameLayout = findViewById(R.id.framelayout)


        loadFragment(FirstFragment(), false)


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val fragment: Fragment = when (tab?.position) {
                    0 -> FirstFragment()
                    1 -> SecondFragment()
                    2 -> ThirdFragment()
                    3 -> FourthFragment()
                    4 -> FifthFragment()
                    5 -> SixthFragment()
                    else -> FirstFragment()
                }
                loadFragment(fragment, false)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
        val exitButton: Button = findViewById(R.id.exit_button)
        exitButton.setOnClickListener {

            finish()
        }
    }


    private fun loadFragment(fragment: Fragment, animate: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()


        if (animate) {
            transaction.setCustomAnimations(
                R.anim.slide_in_left,
                R.anim.slide_in_out
            )
        }


        transaction.replace(R.id.framelayout, fragment)
        transaction.commit()
    }
}
