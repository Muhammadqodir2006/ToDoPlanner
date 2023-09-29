package uz.itschool.todoplanner.ui.extra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedDispatcher
import androidx.fragment.app.DialogFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import uz.itschool.todoplanner.R
import uz.itschool.todoplanner.database.entity.Task
import uz.itschool.todoplanner.databinding.FragmentBottomSheetAddTaskBinding

private const val ARG_PARAM1 = "task"

class BottomSheetAddTaskFragment : BottomSheetDialogFragment() {
    private lateinit var binding : FragmentBottomSheetAddTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBottomSheetAddTaskBinding.inflate(inflater, container, false)

        binding.tasksAddTaskDialogEditText.requestFocus()
        setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogStyle)

        binding.tasksAddTaskDialogCancelBtn.setOnClickListener { dismiss()}
        return binding.root
    }








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
}