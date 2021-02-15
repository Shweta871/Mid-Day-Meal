package com.branding.middaymeal.ui.sidemenu.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.branding.middaymeal.R;
import com.branding.middaymeal.ui.livefeed.LiveFeed;
import com.branding.middaymeal.ui.pastrecords.PastRecords;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Button liveFeed;
    private Button pastRecords;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        liveFeed = root.findViewById(R.id.liveFeed);
        pastRecords = root.findViewById(R.id.pastRecords);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        liveFeed.setOnClickListener((v)->{
            if(getActivity() != null) {
                Intent i = new Intent(getActivity(), LiveFeed.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_up, R.anim.hold);
            }
        });

        pastRecords.setOnClickListener((v)->{
            if(getActivity() != null) {
                Intent i = new Intent(getActivity(), PastRecords.class);
                startActivity(i);
                getActivity().overridePendingTransition(R.anim.slide_up, R.anim.hold);
            }
        });

    }
}