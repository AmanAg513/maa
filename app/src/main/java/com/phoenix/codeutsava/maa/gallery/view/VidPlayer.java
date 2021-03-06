package com.phoenix.codeutsava.maa.gallery.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;


import com.phoenix.codeutsava.maa.R;
import com.phoenix.codeutsava.maa.helper.Keys;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VidPlayer.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VidPlayer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VidPlayer extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;
    @BindView(R.id.myVideo)
    VideoView videoView;

    private OnFragmentInteractionListener mListener;

    public VidPlayer() {
        // Required empty public constructor
    }

    public static VidPlayer newInstance(String param1) {
        VidPlayer fragment = new VidPlayer();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(Keys.KEY_VIDEO_URL);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_vid_player, container, false);
        ButterKnife.bind(this,view);
        String vidAddress =mParam1;
        Uri vidUri = Uri.parse(vidAddress);
        videoView.setVideoURI(vidUri);

        final ProgressDialog pDialog = new ProgressDialog(getContext());
        // Set progressbar title
//        pDialog.setTitle("Android Video Streaming Tutorial");
//
//        pDialog.setMessage("Buffering...");
//        pDialog.setIndeterminate(false);
//        pDialog.setCancelable(false);
//        pDialog.show();
//        // Show progressbar
//        pDialog.show();
        MediaController vidControl = new MediaController(getContext());
        vidControl.setAnchorView(videoView);
        videoView.setMediaController(vidControl);

        videoView.requestFocus();
        videoView.start();
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            // Close the progress bar and play the video
//            public void onPrepared(MediaPlayer mp) {
////                pDialog.dismiss();
//                videoView.start();
//
//            }
//        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
