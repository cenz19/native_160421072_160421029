package com.vincentui.native_160421072_160421029

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.vincentui.native_160421072_160421029.databinding.FragmentGameBinding
import com.vincentui.native_160421072_160421029.databinding.FragmentResultBinding

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentResultBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            val status = ResultFragmentArgs.fromBundle(requireArguments()).status
            var score = ResultFragmentArgs.fromBundle(requireArguments()).score
            if(status == true){
                binding.txtStatus.text = "CORRECT ANSWER"
                binding.txtScore.text = "Your Score is $score"

            }else{
                binding.txtStatus.text = "GAME OVER"
                binding.txtScore.text = "Your Score deducted to $score"
            }
        }

        binding.btnBackMainScreen.setOnClickListener {
            val score = ResultFragmentArgs.fromBundle(requireArguments()).score
            val action = ResultFragmentDirections.actionMainFragment1(score)
            Navigation.findNavController(it).navigate(action)
        }

    }
}