package org.modernism_in_architecture.mia.views.places

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import org.modernism_in_architecture.mia.R
import org.modernism_in_architecture.mia.databinding.FragmentPlacesBinding
import javax.inject.Inject

//@AndroidEntryPoint
// class PlacesFragment : Fragment() {

//    private val viewModel: PlacesViewModel by viewModels()
//
//    @Inject
//    lateinit var adapter: PlacesAdapter
//
//    private var _binding: FragmentPlacesBinding? = null
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val tvTopBarTitle = (requireActivity() as AppCompatActivity).findViewById<TextView>(R.id.viewTitle)
//        tvTopBarTitle.setText("Places")
//
//        _binding = DataBindingUtil.inflate(
//            inflater, R.layout.fragment_places, container, false
//        )
//        binding.viewModel = viewModel
//        binding.lifecycleOwner = viewLifecycleOwner
//
//        return binding.root
//    }
// }