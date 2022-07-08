package com.geektech.relesson52

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.geektech.relesson52.databinding.FragmentMainBinding
import com.geektech.relesson52.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            okBtn.setOnClickListener {
                val firstName = firstName.text.toString()
                val secondName = secondName.text.toString()
                App.loveApi.getPercentage(firstName, secondName)
                    .enqueue(object : Callback<LoveModel> {
                        override fun onResponse(
                            call: Call<LoveModel>,
                            response: Response<LoveModel>
                        ) {
                            Log.e("ololo", "OnResponse:" + response.body()!!.result)
                            val bundle = Bundle()
                            val result = response.body()?.result.toString()
                            val percent = response.body()?.percentage.toString()
                            bundle.putString("result", result)
                            bundle.putString("percent", percent)
                            bundle.putString("fname", firstName)
                            bundle.putString("sname", secondName)
                            findNavController().navigate(R.id.resultFragment, bundle)
                        }
                        override fun onFailure(call: Call<LoveModel>, t: Throwable) {

                        }
                    })
            }
        }
    }

}