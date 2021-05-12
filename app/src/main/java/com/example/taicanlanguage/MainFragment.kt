package com.example.taicanlanguage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainFragment : Fragment(), View.OnClickListener {

    var navController: NavController? = null




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.lesson01_btn).setOnClickListener (this)

        view.findViewById<Button>(R.id.lesson02_btn).setOnClickListener (this)
        view.findViewById<Button>(R.id.lesson03_btn).setOnClickListener (this)


    }


    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.lesson01_btn -> navController!!.navigate(R.id.action_mainFragment_to_quizFragment)
            R.id.lesson02_btn -> navController!!.navigate(R.id.action_mainFragment_to_quiz02Fragment)
            R.id.lesson03_btn -> navController!!.navigate(R.id.action_mainFragment_to_quiz03Fragment)


        }


   }
}