package org.modernism_in_architecture.mia.views.buildingDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs

import dagger.hilt.android.AndroidEntryPoint
import org.modernism_in_architecture.mia.R
import org.modernism_in_architecture.mia.databinding.FragmentBuildingDetailsBinding

@AndroidEntryPoint
class BuildingDetailsFragment : Fragment() {
    private val viewModel: BuildingDetailsViewModel by viewModels()
    private val args: BuildingDetailsFragmentArgs by navArgs()

    private var _binding: FragmentBuildingDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val tvTopBarTitle = (requireActivity() as AppCompatActivity).findViewById<TextView>(R.id.viewTitle)
        tvTopBarTitle.text = "Details"

        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_building_details, container, false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.refreshBuildingDetails(args.buildingId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getBuildingDetails(args.buildingId).observe(viewLifecycleOwner) {
            viewModel.buildingDetails.set(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}