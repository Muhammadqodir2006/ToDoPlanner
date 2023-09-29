package uz.itschool.todoplanner.ui.extra

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton
import uz.itschool.todoplanner.R
import uz.itschool.todoplanner.database.AppDatabase
import uz.itschool.todoplanner.database.entity.Task
import uz.itschool.todoplanner.databinding.FragmentBottomSheetAddTaskBinding

private const val ARG_PARAM1 = "task"

class BottomSheetAddTaskFragment : BottomSheetDialogFragment() {

    private var task: Task? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            task = it.getSerializable(ARG_PARAM1) as Task
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(task: Task) =
            BottomSheetAddTaskFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1, task)
                }
            }
    }

    private lateinit var binding: FragmentBottomSheetAddTaskBinding
    private lateinit var editText: EditText
    private lateinit var addButton: MaterialButton
    private var category = 0
    private var priority = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomSheetAddTaskBinding.inflate(inflater, container, false)
        editText = binding.tasksAddTaskDialogEditText
        addButton = binding.tasksAddTaskDialogAddBtn
        binding.tasksAddTaskDialogEditText.requestFocus()
        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogStyle)

        binding.tasksAddTaskDialogCancelBtn.setOnClickListener { dismiss() }
        binding.tasksAddTaskLowPriorityBtn.setOnClickListener {
            setTaskPriority(0)
        }
        binding.tasksAddTaskHighPriorityBtn.setOnClickListener {
            setTaskPriority(1)
        }
        binding.tasksAddTaskVeryHighPriorityBtn.setOnClickListener {
            setTaskPriority(2)
        }
        binding.tasksAddTaskPersonalBtn.setOnClickListener {
            setTaskCategory(0)
        }
        binding.tasksAddTaskHomeBtn.setOnClickListener {
            setTaskCategory(1)
        }
        binding.tasksAddTaskWorkBtn.setOnClickListener {
            setTaskCategory(2)
        }

        editText.addTextChangedListener {
            if (editText.text.isNullOrEmpty()){
                addButton.setBackgroundColor(requireContext().getColor(R.color.gray_50))
                addButton.isEnabled = false
            }else{
                addButton.setBackgroundColor(requireContext().getColor(R.color.primary))
                addButton.isEnabled = true
            }
        }


        addButton.setOnClickListener {
            val text = editText.text.toString()
            val subtasks = ""
            // TODO: Get and Add subtasks
//            val task = Task(0, 0, text, subtasks, priority, category, )
            val appDatabase = AppDatabase.getInstance(requireContext())
//            appDatabase.getTaskDao().addTask(task)
            dismiss()
        }

        return binding.root
    }

    private fun setTaskCategory(cat: Int) {
        when (category) {
            0 -> setUnselected(binding.tasksAddTaskPersonalBtn)
            1 -> setUnselected(binding.tasksAddTaskHomeBtn)
            2 -> setUnselected(binding.tasksAddTaskWorkBtn)
        }
        category = cat
        when (category) {
            0 -> setSelected(binding.tasksAddTaskPersonalBtn)
            1 -> setSelected(binding.tasksAddTaskHomeBtn)
            2 -> setSelected(binding.tasksAddTaskWorkBtn)
        }
    }

    private fun setTaskPriority(prior: Int) {
        when (priority) {
            0 -> {
                setUnselected(binding.tasksAddTaskLowPriorityBtn)
            }

            1 -> {
                setUnselected(binding.tasksAddTaskHighPriorityBtn)
            }

            2 -> {
                setUnselected(binding.tasksAddTaskVeryHighPriorityBtn)
            }
        }
        priority = prior
        when (priority) {
            0 -> {
                setSelected(binding.tasksAddTaskLowPriorityBtn)
            }

            1 -> {
                setSelected(binding.tasksAddTaskHighPriorityBtn)
            }

            2 -> {
                setSelected(binding.tasksAddTaskVeryHighPriorityBtn)
            }
        }
    }

    private fun setSelected(btn: MaterialButton) {
        btn.setBackgroundColor(requireContext().getColor(R.color.primary))
        btn.setTextColor(requireContext().getColor(R.color.white))
    }

    private fun setUnselected(btn: MaterialButton) {
        btn.setBackgroundColor(requireContext().getColor(R.color.white))
        btn.setTextColor(requireContext().getColor(R.color.primary))
    }


}