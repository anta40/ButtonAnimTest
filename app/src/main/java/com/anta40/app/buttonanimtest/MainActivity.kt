package com.anta40.app.buttonanimtest

import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bottomNav = findViewById<BottomNavigationView>(R.id.main_bottom_navigation)
        bottomNav.setOnItemSelectedListener { menu ->
            when (menu.itemId){
                R.id.game_menu -> {
                    val dialogBuilder = AlertDialog.Builder(this)
                    val customView = layoutInflater.inflate(R.layout.custom_alert_layout, null)
                    dialogBuilder.setView(customView)
                    dialogBuilder.setCancelable(true)


                    val btnYes = customView.findViewById<Button>(R.id.btn_dialog_yes)
                    val btnNo = customView.findViewById<Button>(R.id.btn_dialog_no)

                    btnYes.setOnClickListener {
                        dialogBuilder.setOnDismissListener {
                            it.dismiss()
                        }
                    }

                    btnNo.setOnClickListener {
                        dialogBuilder.setOnDismissListener {
                            it.dismiss()
                        }
                    }


                    /*
                    taken from https://stackoverflow.com/questions/9467026/changing-position-of-the-dialog-on-screen-android
                     */
                    val alert = dialogBuilder.create()
                    val dialogWindow = alert.window
                    dialogWindow!!.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
                    val layoutParams = dialogWindow.attributes
                    layoutParams.gravity = Gravity.CENTER_HORIZONTAL
                    layoutParams.flags = layoutParams.flags and WindowManager.LayoutParams.FLAG_DIM_BEHIND.inv()
                    dialogWindow.attributes = layoutParams


                    alert.show()

                    true
                }
            }
            false
        }
    }
}