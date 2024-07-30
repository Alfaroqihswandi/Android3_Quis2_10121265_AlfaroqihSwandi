package com.quis2


import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.quis2.databinding.ActivityMainBinding
import com.quis2.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: QuoteViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.quotes.observe(this, Observer { quoteResponse ->
            quoteResponse?.let {
                binding.recyclerView.adapter = QuoteAdapter(it.results)
            }
        })

        viewModel.getQuotes()
    }
}
