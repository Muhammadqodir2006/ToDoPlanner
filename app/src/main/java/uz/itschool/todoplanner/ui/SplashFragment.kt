package uz.itschool.todoplanner.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.Animation.AnimationListener
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import uz.itschool.todoplanner.R
import uz.itschool.todoplanner.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSplashBinding.inflate(inflater, container, false)

        val anim = AnimationUtils.loadAnimation(requireContext(), R.anim.splash_anim)
        anim.setAnimationListener(object : AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationRepeat(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                findNavController().navigate(R.id.action_splashFragment_to_bodyFragment)
            }
        })
        binding.splashAppIcon.startAnimation(anim)
        return binding.root
    }

}