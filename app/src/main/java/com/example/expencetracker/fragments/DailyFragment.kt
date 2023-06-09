package com.example.expencetracker.fragments

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.expencetracker.Database.TrackerDatabase
import com.example.expencetracker.EditNotes
import com.example.expencetracker.adapter.ExpenseAdapter
import com.example.expencetracker.adapter.IncomeAdapter
import com.example.expencetracker.databinding.FragmentDailyBinding
import com.example.expencetracker.model.Expense
import com.example.expencetracker.model.Income
import com.example.expencetracker.model.trackerViewModel
import java.text.SimpleDateFormat
import java.util.*


class DailyFragment : Fragment() {

    private lateinit var binding: FragmentDailyBinding

    private lateinit var dataBase: TrackerDatabase
    lateinit var viewModel: trackerViewModel

    private lateinit var expenseAdapter: ArrayAdapter<Expense>
    private lateinit var incomeAdapter: ArrayAdapter<Income>

    private var expenseTotal: Double = 0.0
    private var incomeTotal: Double = 0.0

    private var selectedDate: Calendar = Calendar.getInstance()


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
        dataBase = TrackerDatabase.getDataBase(requireContext())


        setupExpenseListView()
        setupIncomeListView()

        updateSelectedDateText()
        return binding.root
    }

    private fun setupExpenseListView() {
        expenseAdapter = ExpenseAdapter(requireContext())
        binding.expenseListView.adapter = expenseAdapter

        viewModel.allExpense.observe(viewLifecycleOwner) { expenseList ->
            expenseList?.let {
                expenseAdapter.clear()
                expenseAdapter.addAll(expenseList)
                expenseTotal = expenseList.sumOf { it.amount!! }
                binding.expenseAmount.text = expenseTotal.toString()


            }
        }
    }

    private fun setupIncomeListView() {
        incomeAdapter = IncomeAdapter(requireContext())
        binding.incomeListView.adapter = incomeAdapter

        viewModel.allInCome.observe(viewLifecycleOwner) { incomeList ->
            incomeList?.let {
                incomeAdapter.clear()
                incomeAdapter.addAll(incomeList)

                incomeTotal = incomeList.sumOf { it.amount!! }
                binding.incomeAmount.text = incomeTotal.toString()
            }
        }


    }

    private fun initUi() {

        val getContent =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val note = result.data?.getSerializableExtra("expense") as? Expense
                    val note2 = result.data?.getSerializableExtra("income") as? Income
                    if (note != null) {
                        viewModel.addExpense(note)
                    }
                    if (note2 != null) {
                        viewModel.addIncome(note2)
                    }
                }
            }
        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(requireContext(), EditNotes::class.java)
            getContent.launch(intent)
            Log.d("Intent", "$intent")
        }

//        show date picker
        binding.calender.setOnClickListener {
            showDatePickerDialog()
        }
    }

    private fun showDatePickerDialog() {

        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            // Update the selected date
            selectedDate.set(Calendar.YEAR, year)
            selectedDate.set(Calendar.MONTH, monthOfYear)
            selectedDate.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            // Update the TextView with the selected date, month, and year
            updateSelectedDateText()
        }

        // Create a DatePickerDialog with the current selected date
        val datePickerDialog = DatePickerDialog(
            requireContext(),
            dateSetListener,
            selectedDate.get(Calendar.YEAR),
            selectedDate.get(Calendar.MONTH),
            selectedDate.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.show()

    }

    private fun updateSelectedDateText() {
        val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        val selectedDateString = dateFormat.format(selectedDate.time)
        binding.idTVDate.text = selectedDateString
    }



}






