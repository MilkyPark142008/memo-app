package com.example.memoapp

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    
    private val memoList = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val editTextTitle = findViewById<EditText>(R.id.editTextTitle)
        val editTextContent = findViewById<EditText>(R.id.editTextContent)
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val listViewMemos = findViewById<ListView>(R.id.listViewMemos)
        
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            memoList
        )
        listViewMemos.adapter = adapter
        
        buttonSave.setOnClickListener {
            val title = editTextTitle.text.toString().trim()
            val content = editTextContent.text.toString().trim()
            
            if (title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "标题和内容不能为空！", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            
            val time = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
            val memo = "📌 $title\n   $content\n   ⏰ $time"
            
            memoList.add(0, memo)
            adapter.notifyDataSetChanged()
            
            editTextTitle.text.clear()
            editTextContent.text.clear()
            
            Toast.makeText(this, "备忘录已保存！", Toast.LENGTH_SHORT).show()
        }
        
        listViewMemos.setOnItemClickListener { _, _, position, _ ->
            val memo = memoList[position]
            Toast.makeText(this, "点击了：${memo.substringBefore("\n")}", Toast.LENGTH_SHORT).show()
        }
        
        listViewMemos.setOnItemLongClickListener { _, _, position, _ ->
            memoList.removeAt(position)
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "已删除备忘录", Toast.LENGTH_SHORT).show()
            true
        }
    }
}
