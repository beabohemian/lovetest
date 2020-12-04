package com.example.lovetest.fragnment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.lovetest.R
import kotlinx.android.synthetic.main.fragment_result.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [result.newInstance] factory method to
 * create an instance of this fragment.
 */
class result : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    var option = -1

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        option = arguments?.getInt("index")?:-1

        return inflater.inflate(R.layout.fragment_result, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        setResult(option)

        btn_home.setOnClickListener {
            navController.navigate(R.id.action_result_to_main)
        }
    }

    fun setResult(option:Int){
        when(option){
            1 -> {
                tv_main.text = "당신은 쉽게 그만두는 사람입니다"
                tv_sub.text = "당신은 쉽게 사랑을 내려놓는군요"
            }
            2 -> {
                tv_main.text = "스스로에 집중하세요"
                tv_sub.text = "당신은 전 애인에게서 쉽게 벗어나지 못할거에요"
            }
            3 -> {
                tv_main.text = "편하게 마음 먹으세요"
                tv_sub.text = "어떻게든 미친짓을 할 수 있는 사람입니다"
            }
            4 -> {
                tv_main.text = "당신은 꽤나 성숙한 사람입니다"
                tv_sub.text = "당신은 쉽게 이별을 받아드릴 수 있는 사람입니다"
            }

        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment result.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            result().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}