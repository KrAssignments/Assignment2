package com.krupal.assignment1.ui

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.krupal.assignment1.R
import com.krupal.assignment1.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: MoviesListAdapter
    private lateinit var inpInputMethodManager: InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        inpInputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        with(binding) {

            with(this.content.recView) {
                adapter = MoviesListAdapter(this@MoviesListActivity).also {
                    listAdapter = it
                }
                layoutManager = object : GridLayoutManager(
                    this@MoviesListActivity,
                    getColumnCount(),
                    RecyclerView.VERTICAL, false
                ) {
                    override fun generateLayoutParams(
                        c: Context?,
                        attrs: AttributeSet?
                    ): RecyclerView.LayoutParams {
                        return super.generateLayoutParams(c, attrs).apply {
                            this.height = getListItemHeightAsPerRatio(getWidth(), spanCount)
                        }
                    }
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        menu.findItem(R.id.action_search)?.let { searchMenu ->
            with(searchMenu.actionView as SearchView) {
                setOnQueryTextListener(this@MoviesListActivity)
                val closeBT = findViewById<View>(androidx.appcompat.R.id.search_close_btn)
                closeBT.setOnClickListener {
                    setQuery(null, true)
                }
            }
        }

        return true
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        performSearch(query)
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        performSearch(newText)
        return true
    }

    private fun getColumnCount(): Int =
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) 3 else 7

    private fun performSearch(newText: String?) {
        newText?.let {
            if (it.length < 3) {
                listAdapter.reset()
            } else {
                listAdapter.search(it)
            }
        } ?: let {
            listAdapter.reset()
        }
    }

    private fun getListItemHeightAsPerRatio(viewGroupHeight: Int, spanCount: Int): Int {
        return 1920 * viewGroupHeight / 1080 / spanCount
    }
}