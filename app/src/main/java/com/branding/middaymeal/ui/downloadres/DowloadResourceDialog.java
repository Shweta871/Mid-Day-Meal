
package com.branding.middaymeal.ui.downloadres;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.branding.middaymeal.R;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DowloadResourceDialog extends DialogFragment {

    ImageView cancelIm;


    public DowloadResourceDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dowload_resource_dialog, container, false);
        cancelIm = v.findViewById(R.id.cancelIm);
        return  v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        cancelIm.setOnClickListener(v->{
            this.dismiss();
        });


    }
}
