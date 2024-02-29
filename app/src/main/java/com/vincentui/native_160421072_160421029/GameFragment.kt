package com.vincentui.native_160421072_160421029

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.vincentui.native_160421072_160421029.databinding.FragmentGameBinding
import com.vincentui.native_160421072_160421029.databinding.FragmentMainBinding

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



class GameFragment : Fragment() {
    private lateinit var binding: FragmentGameBinding
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGameBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null) {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).VincentKH
            binding.txtTurn.text = "$playerName's Turn"
        }

        binding.btnBack.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment(0)
            Navigation.findNavController(it).navigate(action)
        }

    }


}