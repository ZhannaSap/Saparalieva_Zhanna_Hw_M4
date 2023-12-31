package com.example.saparalieva_zhanna_hw_m4.ui.profile

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saparalieva_zhanna_hw_m4.data.local.Pref
import com.example.saparalieva_zhanna_hw_m4.databinding.FragmentProfileBinding
import java.io.ByteArrayOutputStream
import android.util.Base64
import androidx.activity.result.contract.ActivityResultContracts
import com.example.saparalieva_zhanna_hw_m4.utils.loadImage
import kotlinx.coroutines.selects.select


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val pref by lazy {
        Pref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val openGallery =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val selectedImageUri = it.data?.data
                pref.saveImage(selectedImageUri.toString())
                binding.profileImage.loadImage(selectedImageUri.toString())
            }
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profileImage.loadImage(pref.getImage())
        binding.etName.setText(pref.getName())


        binding.profileImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.setType("image/*")
            openGallery.launch(intent)
        }


        binding.btnSave.setOnClickListener {
            pref.saveName(binding.etName.text.toString())
        }

    }
}