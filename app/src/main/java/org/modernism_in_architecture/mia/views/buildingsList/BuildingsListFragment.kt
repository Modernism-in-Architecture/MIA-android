package org.modernism_in_architecture.mia.views.buildingsList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.modernism_in_architecture.mia.R
import org.modernism_in_architecture.mia.databinding.FragmentBuildingsListBinding
import javax.inject.Inject

@AndroidEntryPoint
class BuildingsListFragment : Fragment() {
    private val viewModel: BuildingsListViewModel by viewModels()

    @Inject
    lateinit var adapter: BuildingsListAdapter

    private var _binding: FragmentBuildingsListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_buildings_list, container, false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.recyclerView.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.data.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        adapter.clickListener.onItemClick = {
            findNavController().navigate(
                BuildingsListFragmentDirections.actionBuildingsListToBuildingDetails(it.id))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.recyclerView.adapter = null
        _binding = null
    }

}

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        inflater.inflate(R.menu.menu_plant_list, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.filter_zone -> {
//                updateData()
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }

//    private fun subscribeUi(adapter: PlantAdapter) {
//        viewModel.plants.observe(viewLifecycleOwner) { plants ->
//            adapter.submitList(plants)
//        }
//    }
//
//    private fun updateData() {
//        with(viewModel) {
//            if (isFiltered()) {
//                clearGrowZoneNumber()
//            } else {
//                setGrowZoneNumber(9)
//            }
//        }
//    }
//}