package com.example.panoroma.ui.map

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.view.*
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.panoroma.R
import com.example.panoroma.ui.showinfo.info_aranci
import com.example.panoroma.ui.showinfo.info_col
import com.example.panoroma.ui.showinfo.info_pincio
import com.example.panoroma.ui.showinfo.info_zodiaco
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


open class MapsActivity : Fragment(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView: View = inflater.inflate(R.layout.fragment_maps, container, false)
        val mapFragment =
            childFragmentManager.fragments[0] as SupportMapFragment?
        mapFragment!!.getMapAsync(this)
        val toolbar = (rootView.findViewById<View>("1".toInt()).parent as View).findViewById<View>("4".toInt())
        setHasOptionsMenu(true)

        // and next place it, for example, on bottom right (as Google Maps app)

        // and next place it, for example, on bottom right (as Google Maps app)
        val rlp = toolbar.layoutParams as RelativeLayout.LayoutParams
        // position on right bottom
        // position on right bottom
        rlp.addRule(RelativeLayout.ALIGN_PARENT_TOP, 0)
        rlp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE)
        rlp.setMargins(0, 0, 0, 1400)
        return rootView
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap = googleMap!!
        // Add a marker in Sydney and move the camera
        val latlng_pincio = LatLng(41.9135245551798, 12.477636485644826)
        val latlng_colosseo = LatLng(41.89031748757595, 12.49223224919796)
        val latlng_aranci = LatLng(41.88516879140589, 12.480273682461961)
        val latlng_mylocation = LatLng(41.89517348099293, 12.50074332786879)
        val latlng_zodiaco = LatLng(41.92350228177792, 12.452852790679048)

        val pincio = mMap.addMarker(MarkerOptions().position(latlng_pincio).title("Terrazza del pincio").snippet("Clicca qui per leggere le informazioni"))
        val colosseo = mMap.addMarker(MarkerOptions().position(latlng_colosseo).title("Colosseo").snippet("Clicca qui per leggere le informazioni"))
        val aranci = mMap.addMarker(MarkerOptions().position(latlng_aranci).title("Giardino degli aranci").snippet("Clicca qui per leggere le informazioni"))
        val zodiaco = mMap.addMarker(MarkerOptions().position(latlng_zodiaco).title("Zodiaco").snippet("Clicca qui per leggere le informazioni"))

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng_mylocation, 11.5f))
        mMap.setOnInfoWindowClickListener { marker ->
            //val markertitle = marker.title
            if(marker.title.equals("Colosseo")){
                val i = Intent(activity, info_col::class.java)
                startActivity(i)
            }
            else if(marker.title.equals("Terrazza del pincio")){
                val i = Intent(activity, info_pincio::class.java)
                startActivity(i)
            }
            else if(marker.title.equals("Giardino degli aranci")){
                val i = Intent(activity, info_aranci::class.java)
                startActivity(i)
            }
            else if(marker.title.equals("Zodiaco")){
                val i = Intent(activity, info_zodiaco::class.java)
                startActivity(i)
            }
            false
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val search = menu.findItem(R.id.app_bar_search)
        search.setVisible(false)
    }


}





