package com.example.saparalieva_zhanna_hw_m4.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.saparalieva_zhanna_hw_m4.R
import com.example.saparalieva_zhanna_hw_m4.data.local.Pref
import com.example.saparalieva_zhanna_hw_m4.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
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
        binding.btnSave.setOnClickListener{
        pref.saveName(binding.etName.text.toString())
        }
        binding.etName.setText(pref.getName())
    }
}