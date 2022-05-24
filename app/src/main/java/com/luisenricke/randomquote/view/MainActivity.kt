package com.luisenricke.randomquote.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.luisenricke.randomquote.databinding.ActivityMainBinding
import com.luisenricke.randomquote.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setting when the viewModel changes
        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }

        // Setting what changes when updates the viewModel
        quoteViewModel.quoteModel.observe(this, { currentQuote ->
            binding.txtQuote.text = currentQuote.quote
            binding.txtAuthor.text = currentQuote.author
        })


    }

}
