package com.example.roommvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roommvvm.fragment.NameListFragment
import com.example.roommvvm.fragment.NewNameFragment
import timber.log.Timber

class MainActivity : AppCompatActivity(),
    NewNameFragment.OnFragmentInteractionListener,
    NameListFragment.OnFragmentInteractionListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Mengecek status aktivitas yang sebelumnya disimpan
        if (savedInstanceState == null) {
            // Memanggil fungsi goToStudentListFragment()
            goToStudentListFragment()
        }

        // Menampilkan Log dari Debug
        Timber.plant(Timber.DebugTree())
    }

    // Fungsi untuk menampilkan NameListFragment
    override fun goToStudentListFragment() {
        // Mengambil instance FragmentTransaction dari FragmentActivity
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        // Melakukan transaksi dengan metode replace()
        transaction.replace(R.id.flContent, NameListFragment.newInstance())
        transaction.commit()
    }

    // Fungsi untuk menampilkan NewNameFragment
    override fun goToNewNameFragment() {
        // Mengambil instance FragmentTransaction dari FragmentActivity
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()

        // Melakukan transaksi dengan metode replace()
        transaction.replace(R.id.flContent, NewNameFragment.newInstance())
        transaction.commit()
    }
}
