package edu.temple.dicethrow

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ButtonFragment.ButtonInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        if (supportFragmentManager.findFragmentById(R.id.diceContainer) !is DieFragment) {

            val dieFragment = DieFragment.newInstance(20)
            supportFragmentManager
                .beginTransaction()
                .add(R.id.diceContainer, dieFragment)
                .commit()
        }


       /* findViewById<Button>(R.id.rollDiceButton).setOnClickListener{
            ( supportFragmentManager
                .findFragmentById(R.id.diceContainer) as DieFragment ).throwDie() //it return an object of type fragment(refernce type) to tell the compiler to refernce the diefragment we casting
        }*/

    }

    override fun buttonClicked() {
        ( supportFragmentManager
            .findFragmentById(R.id.diceContainer) as DieFragment ).throwDie()
    }
}