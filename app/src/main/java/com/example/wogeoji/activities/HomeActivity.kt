package com.example.wogeoji.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wogeoji.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
//
//        val userNameTextView = findViewById<TextView>(R.id.username_textview)
//        val termTextView = findViewById<TextView>(R.id.term_textview)
//        val spendTextView = findViewById<TextView>(R.id.spend_textview);
//
//        val sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
//        val memberNo = sharedPreferences.getLong("id", 1)
//        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
//
//        val myGroupListView = findViewById<RecyclerView>(R.id.group_container)
//        myGroupListView.setHasFixedSize(false)
//        myGroupListView.layoutManager = LinearLayoutManager(this)
//
//        val retrofit = RetrofitClient.getRetrofitInstance();
//
//        val memberService = retrofit.create(MemberService::class.java)
//
//        val callMember = memberService.getMembers(memberNo)
//
//        callMember.enqueue(object : Callback<User> {
//            override fun onResponse(call: Call<User>, response: Response<User>) {
//                val member = response.body()
//
//                member?.let {
//                    userNameTextView.text = member.name + "님의"
//                    myGroupListView.adapter = MyGroupAdapter(member.groups.toList())
//                }
//            }
//
//            override fun onFailure(call: Call<User>, t: Throwable) {
//                Log.d("mytag", "onfailure")
//            }
//
//        })
//


    }
}