package com.example.androidlist

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_ticket.view.*

class MainActivity : AppCompatActivity() {
    var listOfFoods = ArrayList<FoodModel>()
    var adapter: FoodAdapter? = null
    var context: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFood()
        adapter = FoodAdapter(listOfFoods, this)
        listViewFood.adapter = adapter
    }

    fun loadFood() {
        listOfFoods.add(
            FoodModel(
                "Coffee",
                "Hello, it's me I was wondering if after all these years you'd like to meet To go over everything",
                R.drawable.ic_launcher_background
            )
        )
        listOfFoods.add(
            FoodModel(
                "Espersso",
                "Hello, it's me I was wondering if after all these years you'd like to meet To go over everything",
                R.drawable.ic_launcher_background
            )
        )
        listOfFoods.add(
            FoodModel(
                "French",
                "Hello, it's me I was wondering if after all these years you'd like to meet To go over everything",
                R.drawable.ic_launcher_background
            )
        )
        listOfFoods.add(
            FoodModel(
                "Strawberry",
                "Hello, it's me I was wondering if after all these years you'd like to meet To go over everything",
                R.drawable.ic_launcher_background
            )
        )
        listOfFoods.add(
            FoodModel(
                "sugar",
                "Hello, it's me I was wondering if after all these years you'd like to meet To go over everything",
                R.drawable.ic_launcher_background
            )
        )
        listOfFoods.add(
            FoodModel(
                "Cola",
                "Hello, it's me I was wondering if after all these years you'd like to meet To go over everything",
                R.drawable.ic_launcher_background
            )
        )
    }

    inner class FoodAdapter : BaseAdapter {
        var context: Context? = null
        var listOfFoodLocal = ArrayList<FoodModel>()

        constructor(listOfFood: ArrayList<FoodModel>, context: Context) {
            listOfFoodLocal = listOfFood
            this.context = context

        }

        override fun getCount(): Int {
            return listOfFoodLocal.size
        }

        override fun getItem(position: Int): Any {
            return listOfFoodLocal[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()

        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val food = listOfFoodLocal[position]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val foodView = inflator.inflate(R.layout.food_ticket, null)
            foodView.textViewName.text = food.name!!
            foodView.textViewDes.text = food.des!!
            foodView.imageView.setImageResource(food.image!!)
            foodView.imageView.setOnClickListener {
                val intent = Intent(context,FoodDetails::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }

            return foodView
        }

    }

    fun delete(index: Int) {
        listOfFoods.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }

    fun add(index: Int) {
        listOfFoods.add(index,listOfFoods[index])
        adapter!!.notifyDataSetChanged()
    }

}