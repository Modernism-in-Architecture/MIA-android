package org.modernism_in_architecture.mia.views.architectsList

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
import org.modernism_in_architecture.mia.databinding.FragmentArchitectsListBinding

import javax.inject.Inject

@AndroidEntryPoint
class ArchitectsListFragment  : Fragment() {

    private val viewModel: ArchitectsListViewModel by viewModels()

    @Inject
    lateinit var adapter: ArchitectsListAdapter

    private var _binding: FragmentArchitectsListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tvTopBarTitle = (requireActivity() as AppCompatActivity).findViewById<TextView>(R.id.viewTitle)
        tvTopBarTitle.setText("Architects")

        _binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_architects_list, container, false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.architectsRecyclerView.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.data.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        adapter.clickListener.onItemClick = {
            findNavController().navigate(
                ArchitectsListFragmentDirections.actionArchictsListToArchitectDetails(it.id))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.architectsRecyclerView.adapter = null
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.bottom_nav_menu, menu)
    }
}