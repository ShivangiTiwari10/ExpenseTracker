package com.example.expencetracker.fragments

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.activity.result.contract.ActivityResultContracts
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expencetracker.Database.TrackerDatabase
import com.example.expencetracker.EditNotes
import com.example.expencetracker.model.Person
import com.example.expencetracker.adapter.DailyfragmentAdapter
import com.example.expencetracker.databinding.FragmentDailyBinding
import com.example.expencetracker.model.trackerViewModel


class DailyFragment : Fragment(), DailyfragmentAdapter.NotesClickedListener {

    private lateinit var binding: FragmentDailyBinding

    private lateinit var dataBase: TrackerDatabase
    lateinit var viewModel: trackerViewModel
    lateinit var adapter: DailyfragmentAdapter
    lateinit var selectTracker: Person

    private val updateTraker =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

                result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val expence = result.data?.getSerializableExtra("person") as? Person

                if (expence != null) {
                    viewModel.update(expence)
                }

            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentDailyBinding.inflate(layoutInflater)

        initUi()

        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[trackerViewModel::class.java]

        viewModel.allExpense.observe(viewLifecycleOwner) { list ->
            list?.let {
                adapter.updateList(list)
            }
        }
        dataBase = TrackerDatabase.getDataBase(requireContext())
        return (binding.root)

    }

    //
    private fun initUi() {
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = DailyfragmentAdapter(requireContext(), this)


        binding.recyclerView.adapter = adapter

        val getContent =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val note = result.data?.getSerializableExtra("person") as? Person

                    if (note != null) {
                        viewModel.insert(note)
                    }
                }
            }
        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(requireContext(), EditNotes::class.java)
            getContent.launch(intent)
            Log.d("Intent", "$intent")
        }

    }

    override fun onItemClicked(note: Person) {

        val intent = Intent(requireContext(), EditNotes::class.java)
        intent.putExtra("expense_tracker", note)
        updateTraker.launch(intent)
    }


    override fun onLongItemClicked(note: Person, cardView: CardView) {
        TODO("Not yet implemented")
    }


}