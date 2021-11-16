package com.kevinchrist.listable

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.billkainkoom.ogya.quicklist.LayoutManager
import com.billkainkoom.ogya.quicklist.ListableHelper
import com.kevinchrist.listable.databinding.ActivityMainBinding
import com.kevinchrist.listable.databinding.SettingsListLayoutBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowTitleEnabled(false)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.main_list_view)

        ListableHelper.loadList(
            context = this,
            recyclerView = recyclerView,
            listableType = ListableTypes.setting,
            listables = loadData(),
            listableBindingListener = { listable, listableBinding, _ ->
                if (listableBinding is SettingsListLayoutBinding) {
                    listableBinding.settingsTitle.text = listable.title
                    listableBinding.settingsIv.setImageResource(listable.icon)
                }
            },
            listableClickedListener = { listable, _, _ ->
                Toast.makeText(this, listable.title, Toast.LENGTH_SHORT).show()
            },
            layoutManagerType = LayoutManager.Vertical
        )
    }

    private fun loadData(): MutableList<Setting> {
        return mutableListOf(
            Setting(R.drawable.ic_monetization, "Coupons"),
            Setting(R.drawable.ic_payments, "Payments"),
            Setting(R.drawable.ic_message, "Messaging"),
            Setting(R.drawable.ic_security, "Security"),
        )
    }
}