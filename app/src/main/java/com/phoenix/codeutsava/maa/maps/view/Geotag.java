package com.phoenix.codeutsava.maa.maps.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.phoenix.codeutsava.maa.R;
import com.phoenix.codeutsava.maa.maps.model.RetrofitGeotagProvider;
import com.phoenix.codeutsava.maa.maps.model.data.DoctorData;
import com.phoenix.codeutsava.maa.maps.model.data.GeotagData;
import com.phoenix.codeutsava.maa.maps.presenter.GeotagPresenter;
import com.phoenix.codeutsava.maa.maps.presenter.GeotagPresenterImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Geotag extends Fragment implements OnMapReadyCallback,GeotagView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private GoogleMap mMap;

    private List<DoctorData>datas=new ArrayList<>();
//    @BindView(R.id.maps_progress_bar)
    private ProgressBar progressBar;
    @BindView(R.id.nearest_bin)
    TextView nearest_bin;

    private GeotagPresenter geotagPresenter;
    public Geotag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Geotag.
     */
    // TODO: Rename and change types and number of parameters
    public static Geotag newInstance(String param1, String param2) {
        Geotag fragment = new Geotag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.activity_maps, container, false);

        ButterKnife.bind(this,view);
        progressBar = (ProgressBar)view.findViewById(R.id.maps_progress_bar);
        geotagPresenter=new GeotagPresenterImpl(this,new RetrofitGeotagProvider());
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        SupportMapFragment fragment = new SupportMapFragment();
        transaction.add(R.id.map, fragment);
        transaction.commit();

        fragment.getMapAsync(this);
        geotagPresenter.requestWelcomeData();



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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        Log.d("check","onmap");
        mMap = googleMap;
    }

    @Override
    public void showProgressBar(boolean show) {
    if(show)
        progressBar.setVisibility(View.VISIBLE);
    else
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(getContext(),message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataRecieved(List<DoctorData> doctorDatas) {
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        datas=doctorDatas;
        for(int i=1;i<4;i++)
        {
            DoctorData doctorData=datas.get(i);
            LatLng sydney = new LatLng(doctorData.getLatitude(),doctorData.getLongitude());
            mMap.addMarker(new MarkerOptions().position(sydney).title(doctorData.getName()+"\n"+"91740908579"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(21.24683,81.62202)));
            mMap.animateCamera(CameraUpdateFactory.zoomTo(11), 3700, null);
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
