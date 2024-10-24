package edu.temple.dicethrow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random
const val DIESIDE = "sidenumber"
val Dice_Key: String= "Dice_key"
class DieFragment : Fragment() {
    lateinit var dieViewModel: DieViewModel



    lateinit var dieTextView: TextView

    var dieSides: Int = 6
    var diceValue: Int=-1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dieViewModel=ViewModelProvider(requireActivity())[DieViewModel::class.java]



        arguments?.let {
            it.getInt(DIESIDE).run {
                dieSides = this
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_die, container, false).apply {
            dieTextView = findViewById(R.id.dieTextView)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dieViewModel.getDieRoll().observe(viewLifecycleOwner){
            dieTextView.text=it.toString()
        }
        if(dieViewModel.getDieRoll().value ==null){
            throwDie()
        }
       /* savedInstanceState?.run {
            diceValue=getInt(Dice_Key)
        }
        if(diceValue==-1)
        { throwDie()}
        else
        {
            dieTextView.text=diceValue.toString()
        }*/

    }

    fun throwDie() {
        dieViewModel.setDieRoll(Random.nextInt(dieSides)+1)
        //dieTextView.text = diceValue.toString()

    }



    companion object{//our refernce to get a static version
        fun newInstance (size: Int) : DieFragment{
            val fragment= DieFragment()
            val bundle= Bundle()
            bundle.putInt(DIESIDE,size)
            fragment.arguments=bundle
            return fragment

        }
    }
}