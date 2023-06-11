package com.capstoneproject.kukuku

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.capstoneproject.kukuku.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {


    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        binding.ivKuku.setImageURI(Uri.parse(intent.getStringExtra("file").toString()))
        binding.tvResult.text = intent.getStringExtra("pred").toString()
        binding.tvAcc.text = "Akurasi\t: "+intent.getStringExtra("acc").toString()
        binding.tvDeskripsi.text = "Deskripsi\t: "+intent.getStringExtra("desc").toString()
        binding.tvResiko.text = "Gejala\t: "+intent.getStringExtra("gejala").toString()
        binding.tvTips.text = "Tips\t: "+intent.getStringExtra("tips").toString()
        setContentView(binding.root)
    }
}