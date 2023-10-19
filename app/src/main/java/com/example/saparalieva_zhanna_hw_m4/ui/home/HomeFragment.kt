package com.example.saparalieva_zhanna_hw_m4.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.saparalieva_zhanna_hw_m4.R
import com.example.saparalieva_zhanna_hw_m4.databinding.FragmentHomeBinding
import com.example.saparalieva_zhanna_hw_m4.model.Task
import com.example.saparalieva_zhanna_hw_m4.ui.home.adapter.TaskAdapter
import com.example.saparalieva_zhanna_hw_m4.ui.task.TaskFragment.Companion.RESULT_KEY
import com.example.saparalieva_zhanna_hw_m4.ui.task.TaskFragment.Companion.TASK_KEY

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val adapter = TaskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        setFragmentResultListener(RESULT_KEY){_, bundle ->
            val data = bundle.getSerializable(TASK_KEY) as Task
            adapter.addTask(data)
        }
        binding.fab.setOnClickListener{
            findNavController().navigate(R.id.taskFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}