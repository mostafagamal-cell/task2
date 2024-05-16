package com.example.myapplication

import android.graphics.drawable.GradientDrawable.Orientation
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.myapplication.databinding.FragmentBlankBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment() {
    lateinit var text: String
    lateinit var itms:List<Item>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val res= requireContext().resources.openRawResource(R.raw.task)
         text= res.bufferedReader().readText()
        val personListType = object : TypeToken<List<Item>>() {}.type
         itms=Gson().fromJson(text,personListType)
        itms.forEach {
            Log.i("eeeeeeeeee",it.url.toString())
        }
    }
    lateinit var db:FragmentBlankBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        db= FragmentBlankBinding.inflate(layoutInflater)
        val rec=Recy(itms)
        db.mrct.adapter=rec
//        val x=DividerItemDecoration(db.mrct.context,GridLayoutManager.VERTICAL)
//        db.mrct.addItemDecoration(x)
        return db.root
    }
}