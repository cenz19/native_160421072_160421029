package com.vincentui.native_160421072_160421029

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.vincentui.native_160421072_160421029.databinding.FragmentMainBinding
import java.util.Random

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



class MainFragment : Fragment() {
    private lateinit var binding:FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    //tempat kita akses UI yang ada
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var scoresave:Int = MainFragmentArgs.fromBundle(requireArguments()).scoresave
        val randomNumber1 = kotlin.random.Random.nextInt(1,21)
        val randomNumber2 = kotlin.random.Random.nextInt(1,21)
        binding.txtNumOne.text = randomNumber1.toString()
        binding.txtNumTwo.text = randomNumber2.toString()

        binding.btnStart.setOnClickListener{
            val playerName = binding.txtName.text.toString()
            val action = MainFragmentDirections.actionGameFragment(playerName)
            Navigation.findNavController(it).navigate(action)

        }
        binding.btnSubmitAnswer.setOnClickListener {
            val answer = binding.txtAnswer.text.toString().toInt()
            val correctAnswer = randomNumber1 + randomNumber2
            val isCorrect = answer == correctAnswer
            if(isCorrect){
                scoresave++
            }else{
                scoresave = 0
            }
            val action = MainFragmentDirections.actionResultFragment(isCorrect, scoresave)
            Navigation.findNavController(it).navigate(action)
        }
    }
}