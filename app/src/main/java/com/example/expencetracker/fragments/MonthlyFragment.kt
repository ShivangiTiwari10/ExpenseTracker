package com.example.expencetracker.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.expencetracker.Database.TrackerDatabase
import com.example.expencetracker.adapter.MonthalyAdapter
import com.example.expencetracker.adapter.MonthlyExpenserAdapter
import com.example.expencetracker.databinding.FragmentMonthlyBinding
import com.example.expencetracker.model.Expense
import com.example.expencetracker.model.Income
import com.example.expencetracker.model.trackerViewModel
import java.util.Calendar


class MonthlyFragment : Fragment() {

    private lateinit var binding: FragmentMonthlyBinding

    lateinit var dateTV: TextView
    lateinit var datepicker: DatePicker

    private lateinit var dataBase: TrackerDatabase
    lateinit var viewModel: trackerViewModel

    private lateinit var monthIncomeAdapter: ArrayAdapter<Income>
    private lateinit var monthExpenseAdapter: ArrayAdapter<Expense>

    private var munthIncomeTotal: Double = 0.0


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

        binding = FragmentMonthlyBinding.inflate(layoutInflater)


        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().application)
        )[trackerViewModel::class.java]
        dataBase = TrackerDatabase.getDataBase(requireContext())


        dateTV = binding.idTVDate
        datepicker = binding.datePicker

        val today = Calendar.getInstance()

        // Set the initial date text
        val initialMonth = today.get(Calendar.MONTH) + 1
        dateTV.text = initialMonth.toString()

        // Set the TextView click listener
        dateTV.setOnClickListener {
            toggleDatePickerVisibility()
        }

        datepicker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { _, year, month, day ->
            val Date = (day.toString() + "-"
                    + (month + 1) + "-" + year)

            dateTV.text = Date

            toggleDatePickerVisibility()
        }
        setupIncomeListView()
        setupExpenseListView()

        return binding.root

    }

    //    show all income in monthly fragment

    @SuppressLint("SetTextI18n")
    private fun setupIncomeListView() {
        monthIncomeAdapter = MonthalyAdapter(requireContext())
        binding.listView1.adapter = monthIncomeAdapter

        viewModel.allInCome.observe(viewLifecycleOwner) { incomeList ->
            incomeList?.let {
                monthIncomeAdapter.clear()
                monthIncomeAdapter.addAll(incomeList)

                munthIncomeTotal = incomeList.sumOf { it.amount!! }
                binding.totalIncome.text ="Total Income=$munthIncomeTotal"
            }
        }
    }

//    show all expenses in monthly fragment

    @SuppressLint("SetTextI18n")
    private fun setupExpenseListView() {
        monthExpenseAdapter = MonthlyExpenserAdapter(requireContext())
        binding.listView2.adapter = monthExpenseAdapter

        viewModel.allExpense.observe(viewLifecycleOwner) { expenseList ->
            expenseList?.let {
                monthExpenseAdapter.clear()
                (monthExpenseAdapter as MonthlyExpenserAdapter).addAll(expenseList)

                munthIncomeTotal = expenseList.sumOf { it.amount!! }
                binding.totalExpense.text ="total expense=$munthIncomeTotal"
            }
        }
    }


    private fun toggleDatePickerVisibility() {

        if (datepicker.visibility == View.VISIBLE) {
            datepicker.visibility = View.GONE
        } else {
            datepicker.visibility = View.VISIBLE
        }
    }


}




