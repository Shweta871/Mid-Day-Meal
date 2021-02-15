
/*

 */

package com.branding.middaymeal.validators;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.branding.middaymeal.util.Utils;

import java.util.List;

public class SignupValidator extends AbsValidator {

    public static int PASSWORD_LEN = 7;

    Context context;

    public SignupValidator(Context context) {
        this.context = context;
    }

    @Override
    public boolean validate(List<View> uiControlsList) {
        String errorMessage = "Error:";
        boolean errorStatus = false;
        EditText passwordET = null;
        EditText confirmedPasswordET = null;
        for (View v : uiControlsList) {

            int tag = (Integer) v.getTag();


            if (tag == 0) {
                if (TextUtils.isEmpty(((EditText) v).getText().toString())) {
                    errorMessage += "\n\u2022 Email is empty";
                    errorStatus = true;
                }
            }

            if (tag == 1) {
                if (TextUtils.isEmpty(((EditText) v).getText().toString())) {
                    errorMessage += "\n\u2022 Serial No is empty";
                    errorStatus = true;
                }

            }
            if (tag == 2) {
                if (TextUtils.isEmpty(((EditText) v).getText().toString())) {
                    errorMessage += "\n\u2022 Linked Camera is empty";
                    errorStatus = true;
                }

            }
            if (tag == 3) {
                passwordET = (EditText) v;
                if (TextUtils.isEmpty(passwordET.getText().toString())) {
                    errorMessage += "\n\u2022 Password is empty";
                    errorStatus = true;
                } else {
                    if (passwordET.getText().toString().length() < PASSWORD_LEN ){
                        errorStatus = true;
                        errorMessage += "\n\u2022 Password length is not "+PASSWORD_LEN;
                    }
                }
            }
            if (tag == 4) {
                confirmedPasswordET = (EditText)v;
                if (TextUtils.isEmpty(confirmedPasswordET.getText().toString())) {
                    errorMessage += "\n\u2022 Confirmed Password is empty";
                    errorStatus = true;
                } else {
                    if (confirmedPasswordET.getText().toString().length() < PASSWORD_LEN ){
                        errorStatus = true;
                        errorMessage += "\n\u2022 Confirmed Password length is not "+PASSWORD_LEN;
                    }
                    if(!confirmedPasswordET.getText().toString().equals(passwordET.getText().toString())){
                        errorStatus = true;
                        errorMessage += "\n\u2022 Password and Confirmed password are not same ";
                    }

                }
            }

        }
        errorMessage+="\n";

        if(errorStatus) {
            Utils.showErrorToastMessage(context, errorMessage);
        }

        return errorStatus;
    }

}
