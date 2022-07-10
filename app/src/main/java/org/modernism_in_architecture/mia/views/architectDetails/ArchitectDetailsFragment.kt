package org.modernism_in_architecture.mia.views.architectDetails

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
import org.modernism_in_architecture.mia.databinding.FragmentArchitectDetailsBinding


@AndroidEntryPoint
class ArchitectDetailsFragment: Fragment() {
    private val viewModel: ArchitectDetailsViewModel by viewModels()
    private val args: ArchitectDetailsFragmentArgs by navArgs()

    private var _binding: FragmentArchitectDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val tvTopBarTitle =
            (requireActivity() as AppCompatActivity).findViewById<TextView>(R.id.viewTitle)
        tvTopBarTitle.setText("Architect Details")

        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_architect_details, container, false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.refreshArchitectDetails(args.architectId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getArchitectDetails(args.architectId).observe(viewLifecycleOwner) {
            viewModel.architectDetails.set(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}