package com.example.roommvvm.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders

import com.example.roommvvm.R
import com.example.roommvvm.viewmodel.NewStudentViewModel
import kotlinx.android.synthetic.main.fragment_new_name.*

/**
 * A simple [Fragment] subclass.
 */
class NewNameFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    private lateinit var mViewModel: NewStudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Memanggil class NewStudentViewModel melalui variabel mViewModel buat fragment
        mViewModel = ViewModelProviders.of(this).get(NewStudentViewModel::class.java)
    }

    // Fungsi onCreateView akan berjalan ketika fragment menampilkan layoutnya
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_name, container, false)
    }

    // Fungsi yang akan berjalan setelah memanggil metode onCreateView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Ketika button dilik
        button.setOnClickListener {
            val input = editText.text.toString().trim()

            // Jika input data kosong atau tidak diisi maka akan muncul pop up kecil untuk memberikan masukan singkat
            if (input.isEmpty()) {
                Toast.makeText(activity, "Nama dibutuhkan", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Jika input data terlalu panjang maka akan muncul pop up kecil untuk memberikan masukan singkat
            if (input.length > 30) {
                Toast.makeText(activity, "Nama terlalu panjang", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Memanggil fun storeMovie pada class NewStudentViewModel beserta insert data
            mViewModel.storeMovie(input)

            // Pesan bahwa data telah tersimpan
            Toast.makeText(activity, "$input entered", Toast.LENGTH_SHORT).show()

            // Akan menuju ke fragment list
            listener?.goToStudentListFragment()
        }
    }

    // Fungsi akan berjalan ketika frament dibuka
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    // Fungsi akan berjalan ketika frament ditutup
    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun goToStudentListFragment()
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewNameFragment()
    }
}
