package com.amaurypm.navcompdm.ui.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.amaurypm.navcompdm.R
import com.amaurypm.navcompdm.data.model.User
import com.amaurypm.navcompdm.databinding.FragmentFormularioBinding
import com.google.android.material.textfield.TextInputEditText


class FormularioFragment : Fragment() {

    private var _binding: FragmentFormularioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFormularioBinding.inflate(inflater, container, false)
        return binding.root
    }

    //Este método se ejecuta cuando ya está visible el fragment en pantalla
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            setupTextWatcher(
                tietName,
                tietMobile
            )
        }

        binding.btnVerifyDetails.setOnClickListener {

            val name = binding.tietName.text.toString()
            val mobile = binding.tietMobile.text.toString()

            val bundle = bundleOf(
                "name" to name,
                "mobile" to mobile
            )

            //Establecemos la navegación entre fragments
            /*findNavController().navigate(
                R.id.action_formularioFragment_to_datosFragment,
                bundle
            )*/

            //Con safe arguments
            findNavController().navigate(FormularioFragmentDirections.actionFormularioFragmentToDatosFragment(
                name,
                mobile,
                User(name, mobile)
            ))

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun validateFields(): Boolean =
        binding.tietName.text.toString().isNotEmpty() &&
                binding.tietMobile.text.toString().length == 10


    private fun setupTextWatcher(vararg textFields: TextInputEditText){
        val textWatcher = object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                binding.btnVerifyDetails.isEnabled = validateFields()
            }
        }

        textFields.forEach { textField ->
            textField.addTextChangedListener(textWatcher)
        }
    }

}