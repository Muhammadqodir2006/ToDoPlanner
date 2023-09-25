package uz.itschool.todoplanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.itschool.todoplanner.databinding.FragmentBodyBinding
import uz.itschool.todoplanner.ui.CalendarFragment
import uz.itschool.todoplanner.ui.TasksFragment
import uz.itschool.todoplanner.ui.ProfileFragment
import uz.itschool.todoplanner.ui.TimerFragment

class BodyFragment : Fragment() {
    private lateinit var binding : FragmentBodyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBodyBinding.inflate(inflater, container, false)
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.body_container, TasksFragment())
            commit()
        }
        binding.bodyBottomNavigationView.setOnNavigationItemSelectedListener {
            var fragment :Fragment  = TasksFragment()
            when(it.itemId){
                R.id.calendar -> fragment = CalendarFragment()
                R.id.timer -> fragment = TimerFragment()
                R.id.profile -> fragment = ProfileFragment()
            }
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.body_container, fragment)
                commit()
            }
            true
        }

        return binding.root
    }
}