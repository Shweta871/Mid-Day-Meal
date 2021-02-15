
package com.branding.middaymeal.validators;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.branding.middaymeal.util.Utils;

import java.util.List;

public class LoginValidator extends AbsValidator {

    public static int PASSWORD_LEN = 7;

    Context context;

    public LoginValidator(Context context) {
        this.context = context;
    }

    @Override
    public boolean validate(List<View> uiControlsList) {
        String errorMessage = "Error:";
        boolean errorStatus = false;
        for (View v : uiControlsList) {

            int tag = (Integer) v.getTag();
            if (tag == 0) {
                if (TextUtils.isEmpty(((EditText) v).getText().toString())) {
                    errorMessage += "\n\u2022 Serial No is empty";
                    errorStatus = true;
                }

            }
            if (tag == 1) {
                if (TextUtils.isEmpty(((EditText) v).getText().toString())) {
                    errorMessage += "\n\u2022 Password is empty";
                    errorStatus = true;
                } else {
                    if (((EditText)v).getText().toString().length() < PASSWORD_LEN ){
                        errorStatus = true;
                        errorMessage += "\n\u2022 Password length is not "+PASSWORD_LEN;
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
