package com.example.saparalieva_zhanna_hw_m4.ui.profile

import android.app.Activity
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
import com.example.saparalieva_zhanna_hw_m4.utils.loadImage


class ProfileFragment : Fragment() {
    private val GALLARY_REQUEST_CODE = 1001
  private lateinit var binding: FragmentProfileBinding
    private  val  pref by lazy {
        Pref(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.profileImage.setOnClickListener{
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent,GALLARY_REQUEST_CODE)
        }

        val encodedImage = pref.getImage()
        if (encodedImage != null) {
            val bitmap = toBitmap(encodedImage)
            binding.profileImage.setImageBitmap(bitmap)
        }
        
        
        binding.btnSave.setOnClickListener{
        pref.saveName(binding.etName.text.toString())
        }
        binding.etName.setText(pref.getName())


    }

    private fun toBitmap(encodedImage: String): Bitmap? {
        val decodedByteArray = Base64.decode(encodedImage, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(decodedByteArray, 0, decodedByteArray.size)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==GALLARY_REQUEST_CODE && resultCode==Activity.RESULT_OK){
            val selectedImage = data?.data
            val bitmap = MediaStore.Images.Media.getBitmap(requireContext().contentResolver, selectedImage)

            val encodedImage = toBase64(bitmap)
            pref.saveImage(encodedImage)
            binding.profileImage.setImageBitmap(bitmap)
        }
    }

    private fun toBase64(bitmap: Bitmap): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100,byteArrayOutputStream)
        val byteArray= byteArrayOutputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }
}