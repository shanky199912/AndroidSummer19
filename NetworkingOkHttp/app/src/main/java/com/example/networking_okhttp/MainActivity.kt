package com.example.networking_okhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.github.com/search/users?q=%22shashank%22")
            .build()

        val response = client.newCall(request).enqueue(okhttpsCallback{
            response, throwable ->

            throwable?.let {

            }

            response?.let {
                val gson= Gson().fromJson(it.body?.string(),GithubUser::class.java)
                runOnUiThread {
                    textView.text = gson.items.toString()
                }

            }
            /*override fun onFailure(call: Call, e: IOException) {

            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful){
                    val gson= Gson().fromJson(response.body?.string(),GithubUser::class.java)
                    runOnUiThread {
                        textView.text = gson.items.toString()
                    }

                }
            }*/
        })
    }

    /**
     * we have defined a functioned inside the function okhttpcallback
     * and the parameters of the fn are fetched from onfailure and onresponse
     */

    fun  okhttpsCallback(fn: (Response? , Throwable?)-> Unit) : Callback{
        return object:Callback{
            override fun onFailure(call: Call, e: IOException) = fn(null,e)

            override fun onResponse(call: Call, response: Response)= fn(response,null)

        }
    }
}
