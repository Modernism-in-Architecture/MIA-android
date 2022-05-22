package org.modernism_in_architecture.mia

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.modernism_in_architecture.mia.databinding.FragmentBuildingsBinding
import org.modernism_in_architecture.mia.models.BuildingViewModel


class BuildingFragment : Fragment() {

    private val viewModel: BuildingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentBuildingsBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.buildingsGrid.adapter = BuildingGridAdapter()

        return binding.root
    }
}