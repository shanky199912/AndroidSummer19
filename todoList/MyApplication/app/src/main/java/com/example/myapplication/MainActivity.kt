package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.listview.*

class MainActivity : AppCompatActivity() {

    var tasks = arrayListOf<Task>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = SqliteHelper(this)
        val taskdb = dbHelper.writableDatabase

        tasks = TaskTable.getAllTask(taskdb)

        val taskAdapter = TaskAdapter(tasks)
        listview.adapter = taskAdapter

        btn.setOnClickListener {
            TaskTable.insertTask(
                taskdb, Task(null, edt.text.toString(), true)
            )
            taskAdapter.updateTasks(TaskTable.getAllTask(taskdb))
        }


        /* val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
         listview.adapter = adapter
         adapter.notifyDataSetChanged()

         adapter

         btn.setOnClickListener {

            TaskTable.insertTask(
                taskdb,Task(null , edt.text.toString(),true)
            )


         }
         listview.setOnItemClickListener { parent, view, position, id ->

             tasks.removeAt(position)
             adapter.notifyDataSetChanged()

         }*/

//        val arrayAdapter = ArrayAdapter<Task>(this,android.R.layout.simple_list_item_1)
//         arrayAdapter.notifyDataSetChanged()
/*

        listview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            TaskTable.deleteTask(taskdb, position)
            taskAdapter.updateTasks(TaskTable.getAllTask(taskdb))

        }
*/
        /*listview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            TaskTable.deleteTask(taskdb,position)
            taskAdapter.updateTasks(TaskTable.getAllTask(taskdb))
        }*/

        listview.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            TaskTable.updateTask(taskdb,
                Task(tasks[position].id , edt.text.toString(),true))
            taskAdapter.updateTasks(TaskTable.getAllTask(taskdb))
        }
    }

    class TaskAdapter(var tasks: ArrayList<Task>) : BaseAdapter() {

        fun updateTasks(newTasks: ArrayList<Task>) {
            tasks.clear()
            tasks.addAll(newTasks)
            notifyDataSetChanged()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val li =
                parent!!.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = li.inflate(android.R.layout.simple_list_item_1, parent, false)
            view.findViewById<TextView>(android.R.id.text1).text = getItem(position).task

            return view
        }

        override fun getItem(position: Int): Task = tasks[position]

        override fun getItemId(position: Int): Long = 0

        override fun getCount(): Int = tasks.size


    }
}
