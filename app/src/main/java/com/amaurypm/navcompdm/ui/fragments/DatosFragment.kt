package com.amaurypm.navcompdm.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.amaurypm.navcompdm.R
import com.amaurypm.navcompdm.databinding.FragmentDatosBinding


class DatosFragment : Fragment() {

    private var _binding: FragmentDatosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDatosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //El objeto arguments ya existe y lo genera el navigation component
        //Lo usamos para recuperar los parámetros que llegan
        /*val name = arguments?.getString("name", "")
        val mobile = arguments?.getString("mobile", "")*/

        val args: DatosFragmentArgs by navArgs()

        /*val name = args.name
        val mobile = args.mobile*/
        val user = args.user

        binding.apply {
            tvName.text = user?.name
            tvMobile.text = user?.mobile
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}