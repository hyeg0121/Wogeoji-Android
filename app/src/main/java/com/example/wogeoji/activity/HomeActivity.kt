package com.example.wogeoji.activity

import RetrofitClient
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wogeoji.R
import com.example.wogeoji.adapter.MyGroupAdapter
import com.example.wogeoji.domain.Member
import retrofit2.Callback
import com.example.wogeojiapp.service.MemberService
import retrofit2.Call
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()

        val userNameTextView = findViewById<TextView>(R.id.username_textview)
        val termTextView = findViewById<TextView>(R.id.term_textview)
        val spendTextView = findViewById<TextView>(R.id.spend_textview);

        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val memberNo = sharedPreferences.getLong("id", 1)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        val myGroupListView = findViewById<RecyclerView>(R.id.group_container)
        myGroupListView.setHasFixedSize(false)
        myGroupListView.layoutManager = LinearLayoutManager(this)

        val retrofit = RetrofitClient.getRetrofitInstance();

        val memberService = retrofit.create(MemberService::class.java)

        val callMember = memberService.getMembers(memberNo)

        callMember.enqueue(object : Callback<Member> {
            override fun onResponse(call: Call<Member>, response: Response<Member>) {
                val member = response.body()

                member?.let {
                    userNameTextView.text = member.name + "님의"
                    myGroupListView.adapter = MyGroupAdapter(member.groups.toList())
                }
            }

            override fun onFailure(call: Call<Member>, t: Throwable) {
                Log.d("mytag", "onfailure")
            }

        })



    }
}