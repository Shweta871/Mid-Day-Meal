/*

 */

/*
 *
 */

package com.branding.middaymeal.ui.login;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.branding.middaymeal.R;
import com.branding.middaymeal.util.AppClass;
import com.branding.middaymeal.validators.AbsValidator;
import com.branding.middaymeal.validators.SignupValidator;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment {

    EditText emailET;
    EditText personET;
    EditText linkedCameraET;
    EditText passwordET;
    EditText confirmPasswordET;

    Button signupButton;

    AbsValidator absValidator;



    List<View> uiControlsList;

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_signup, container, false);

        emailET = v.findViewById(R.id.emailET);
        personET = v.findViewById(R.id.personET);
        passwordET = v.findViewById(R.id.passwordET);
        confirmPasswordET = v.findViewById(R.id.confirmedPasswordET);
        linkedCameraET = v.findViewById(R.id.linkedCameraET);
        signupButton = v.findViewById(R.id.signupButton);

        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        uiControlsList = new ArrayList<>();

        absValidator = new SignupValidator(AppClass.getAppClass());

        emailET.setTag(0);
        uiControlsList.add(emailET);
        personET.setTag(1);
        uiControlsList.add(personET);
        linkedCameraET.setTag(2);
        uiControlsList.add(linkedCameraET);
        passwordET.setTag(3);
        uiControlsList.add(passwordET);
        confirmPasswordET.setTag(4);
        uiControlsList.add(confirmPasswordET);




        signupButton.setOnClickListener(v -> {

            if(!absValidator.validate(uiControlsList)){
                // means no error do signup here
            }

        });


    }
}
