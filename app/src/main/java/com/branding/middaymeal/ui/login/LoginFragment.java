/*

 */

/*
 *
 */

package com.branding.middaymeal.ui.login;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.branding.middaymeal.ui.dashboard.Dashboard;
import com.branding.middaymeal.R;
import com.branding.middaymeal.util.AppClass;
import com.branding.middaymeal.util.Utils;
import com.branding.middaymeal.validators.AbsValidator;
import com.branding.middaymeal.validators.LoginValidator;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    AbsValidator absValidator;
    EditText srNoET;
    EditText passwordEt;
    Button loginButton;
    List<View> uiControlsList;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        srNoET = v.findViewById(R.id.srnoEt);
        passwordEt = v.findViewById(R.id.passwordEt);
        loginButton = v.findViewById(R.id.loginBtn);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        uiControlsList = new ArrayList<>();

        srNoET.setTag(0);
        uiControlsList.add(srNoET);
        passwordEt.setTag(1);
        uiControlsList.add(passwordEt);

        absValidator = new LoginValidator(AppClass.getAppClass());

        loginButton.setOnClickListener((v) -> {

            if (!absValidator.validate(uiControlsList)) {
                // means no error

                if (!Utils.getConnectivityStatusString(AppClass.getAppClass())) {
                    String errorMessage = "Error:";
                    errorMessage+="\n\u2022 Network is missing";
                    Utils.showErrorToastMessage(AppClass.getAppClass(), errorMessage);
                } else {

                    Intent i = new Intent(AppClass.getAppClass(), Dashboard.class);
                    startActivity(i);
                    if (getActivity() != null) {
                        getActivity().overridePendingTransition(R.anim.slide_from_right, R.anim.hold);
                    }
                }
            }


        });


    }
}
