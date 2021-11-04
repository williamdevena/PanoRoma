package com.example.panoroma.ui.home

import android.app.SearchManager
import android.content.Intent
import android.database.Cursor
import android.database.MatrixCursor
import android.os.Bundle
import android.provider.BaseColumns
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.panoroma.Main2Activity
import com.example.panoroma.R
import com.example.panoroma.ui.showinfo.*


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val buttonCalculate = root.findViewById(R.id.colosseo_button) as ImageButton
        setHasOptionsMenu(true)


        buttonCalculate.setOnClickListener() {
            //Toast.makeText(activity, "Hola ratita", Toast.LENGTH_SHORT).show()
            activity?.let {
                val intent = Intent(it, info_col::class.java)
                it.startActivity(intent)
            }
        }
        val button_pincio = root.findViewById(R.id.pincio_button) as ImageButton

        button_pincio.setOnClickListener() {
            //Toast.makeText(activity, "Hola ratita", Toast.LENGTH_SHORT).show()
            activity?.let {
                val intent = Intent(it, info_pincio::class.java)
                it.startActivity(intent)
            }
        }
        val button_aranci = root.findViewById(R.id.aranci_button) as ImageButton

        button_aranci.setOnClickListener() {
            //Toast.makeText(activity, "Hola ratita", Toast.LENGTH_SHORT).show()
            activity?.let {
                val intent = Intent(it, info_aranci::class.java)
                it.startActivity(intent)
            }
        }
        val button_zodiaco = root.findViewById(R.id.zodiaco_button) as ImageButton

        button_zodiaco.setOnClickListener() {
            //Toast.makeText(activity, "Hola ratita", Toast.LENGTH_SHORT).show()
            activity?.let {
                val intent = Intent(it, info_zodiaco::class.java)
                it.startActivity(intent)
            }
        }
        //val textView: TextView = root.findViewById(R.id.info_text)
        //homeViewModel.text.observe(viewLifecycleOwner, Observer {
        //textView.text = it
        //})
        return root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.main2, menu)
        val searchItem = menu.findItem(R.id.app_bar_search)
        val searchView = searchItem?.actionView as SearchView

        searchView.setQueryHint("Cerca panorama")
        //searchView.findViewById<AutoCompleteTextView>(R.id.search_src_text).threshold = 1
        val from = arrayOf(SearchManager.SUGGEST_COLUMN_TEXT_1)
        val to = intArrayOf(R.id.item_label)
        val cursorAdapter = SimpleCursorAdapter(context, R.layout.searc_layout, null, from, to, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER)
        val suggestions = listOf("Colosseo", "Terrazza del pincio", "Giardino degli aranci", "Zodiaco")

        searchView.suggestionsAdapter = cursorAdapter
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(query: String?): Boolean {
                val cursor = MatrixCursor(arrayOf(BaseColumns._ID, SearchManager.SUGGEST_COLUMN_TEXT_1))
                query?.let {
                    suggestions.forEachIndexed { index, suggestion ->
                        if (suggestion.contains(query, true))
                            cursor.addRow(arrayOf(index, suggestion))
                    }
                }

                cursorAdapter.changeCursor(cursor)
                return true
            }
        })
        searchView.setOnSuggestionListener(object: SearchView.OnSuggestionListener {
            override fun onSuggestionSelect(position: Int): Boolean {
                return false
            }

            override fun onSuggestionClick(position: Int): Boolean {
                val cursor = searchView.suggestionsAdapter.getItem(position) as Cursor
                val selection = cursor.getString(cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1))
                searchView.setQuery(selection, false)
                if(selection.equals("Colosseo")){
                    activity?.let {
                        val intent = Intent(it, info_col::class.java)
                        it.startActivity(intent)
                    }
                }
                else if(selection.equals("Terrazza del pincio")){
                    activity?.let {
                        val intent = Intent(it, info_pincio::class.java)
                        it.startActivity(intent)
                    }
                }
                else if(selection.equals("Giardino degli aranci")){
                    activity?.let {
                        val intent = Intent(it, info_aranci::class.java)
                        it.startActivity(intent)
                    }
                }
                else if(selection.equals("Zodiaco")){
                    activity?.let {
                        val intent = Intent(it, info_zodiaco::class.java)
                        it.startActivity(intent)
                    }
                }
                // Do something with selection
                return true
            }
        })
    }
}


