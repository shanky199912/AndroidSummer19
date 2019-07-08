package com.example.myapplication

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase

class TaskTable {

    companion object {

        val TABLE_NAME = "task"

        val CMD_CREATE_TABLE = """
            CREATE TABLE $TABLE_NAME (
            id INTEGER PRIMARY KEY AUTOINCREMENT, 
            task TEXT, 
            done BOOLEAN
            );
            """.trimIndent()


        fun insertTask(db: SQLiteDatabase, task: Task) {
            val row = ContentValues()
            row.put("task", task.task)
            row.put("done", task.done)

            db.insert(TABLE_NAME, null, row)
        }

        fun getAllTask(db: SQLiteDatabase): ArrayList<Task> {
            val tasks = arrayListOf<Task>()

            val cursor = db.query(
                TABLE_NAME,
                arrayOf("id", "task", "done"),
                null,
                null,
                null,
                null, null
            )

            cursor.moveToFirst()

            val idCol = cursor.getColumnIndexOrThrow("id") // internally throw krdia
            val taskCol = cursor.getColumnIndexOrThrow("task")
            val doneCol = cursor.getColumnIndexOrThrow("done")

            while (cursor.moveToNext()) {
                val task = Task(
                    cursor.getInt(idCol),
                    cursor.getString(taskCol),
                    cursor.getInt(doneCol) == 1
                )
                tasks.add(task)
            }

            cursor.close()
            return tasks
        }

        fun deleteTask(db:SQLiteDatabase,id:Int){
            db.delete(TABLE_NAME,"id",null)
        }

        fun updateTask(db:SQLiteDatabase,task:Task){

            val updateRow = ContentValues().apply {

                put("task",task.task)
                put("done",task.done)
            }
            db.update(TABLE_NAME,updateRow,"id = ?", arrayOf(task.id.toString()))
        }
    }
}