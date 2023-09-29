package uz.itschool.todoplanner.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import uz.itschool.todoplanner.R
import uz.itschool.todoplanner.adapter.TasksAdapter
import uz.itschool.todoplanner.databinding.FragmentTasksBinding
import uz.itschool.todoplanner.ui.extra.BottomSheetAddTaskFragment

class TasksFragment : Fragment() {
    private lateinit var binding: FragmentTasksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTasksBinding.inflate(inflater, container, false)

        binding.tasksAddBtn.setOnClickListener {
            val bottomSheetFragment = BottomSheetAddTaskFragment()
            bottomSheetFragment.show(parentFragmentManager, "BSDialogFragment")
        }

        binding.tasksRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.tasksRecycler.adapter = TasksAdapter(requireContext())





        return binding.root
    }
}