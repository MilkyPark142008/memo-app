package com.example.memoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val button = findViewById<Button>(R.id.buttonSave)
        val titleEdit = findViewById<EditText>(R.id.editTextTitle)
        val contentEdit = findViewById<EditText>(R.id.editTextContent)
        
        button.setOnClickListener {
            val title = titleEdit.text.toString()
            val content = contentEdit.text.toString()
            
            if (title.isNotEmpty() && content.isNotEmpty()) {
                Toast.makeText(this, "保存成功：$title", Toast.LENGTH_SHORT).show()
                titleEdit.text.clear()
                contentEdit.text.clear()
            } else {
                Toast.makeText(this, "标题和内容不能为空", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
