package org.modernism_in_architecture.mia.views.buildingsList

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
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

    @Inject
    lateinit var adapter: BuildingsListAdapter
    private val viewModel: BuildingsListViewModel by viewModels()
    private var _binding: FragmentBuildingsListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val tvTopBarTitle = (requireActivity() as AppCompatActivity).findViewById<TextView>(R.id.viewTitle)
        tvTopBarTitle.text = "Buildings"

        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_buildings_list, container, false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.buildingsRecyclerView.adapter = adapter

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
        binding.buildingsRecyclerView.adapter = null
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.bottom_nav_menu, menu)
    }

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
}