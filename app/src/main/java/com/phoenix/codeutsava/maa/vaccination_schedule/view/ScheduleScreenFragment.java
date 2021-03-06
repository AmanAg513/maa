package com.phoenix.codeutsava.maa.vaccination_schedule.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.phoenix.codeutsava.maa.R;
import com.phoenix.codeutsava.maa.helper.SharedPrefs;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.MockScheduleScreenProvider;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.RetrofitScheduleScreenProvider;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.BeforeBirthListDetails;
import com.phoenix.codeutsava.maa.vaccination_schedule.model.data.ScheduleScreenData;
import com.phoenix.codeutsava.maa.vaccination_schedule.presenter.ScheduleScreenPresenter;
import com.phoenix.codeutsava.maa.vaccination_schedule.presenter.ScheduleScreenPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ScheduleScreenFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ScheduleScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScheduleScreenFragment extends Fragment implements  ScheduleScreenView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @BindView(R.id.afterRecycler)
    RecyclerView afterRecycler;

    @BindView(R.id.beforeRecycler)
    RecyclerView beforeRecycler;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private AfterBirthListAdapter afterBirthListAdapter;
    private BeforeBirthListAdapter beforeBirthListAdapter;
    private ScheduleScreenPresenter scheduleScreenPresenter;
    private LinearLayoutManager layoutManager;
    private LinearLayoutManager layoutManager1;
    @BindView(R.id.afterBar)
    ProgressBar afterBar;
    @BindView(R.id.beforeBar)
    ProgressBar beforeBar;
    private SharedPrefs sharedPrefs;


    private OnFragmentInteractionListener mListener;

    public ScheduleScreenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ScheduleScreenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ScheduleScreenFragment newInstance(String param1, String param2) {
        ScheduleScreenFragment fragment = new ScheduleScreenFragment();
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

        View view = inflater.inflate(R.layout.fragment_schedule_screen, container, false);
        ButterKnife.bind(this, view);
        initialize();
        return view;
    }


    void initialize(){

        sharedPrefs = new SharedPrefs(getContext());
        afterBirthListAdapter = new AfterBirthListAdapter(getContext(), this);
        beforeBirthListAdapter = new BeforeBirthListAdapter(getContext(), this);
        layoutManager = new LinearLayoutManager(getContext());
        layoutManager1 = new LinearLayoutManager(getContext());
        afterRecycler.setHasFixedSize(true);
        beforeRecycler.setHasFixedSize(true);
        scheduleScreenPresenter = new ScheduleScreenPresenterImpl(this , new RetrofitScheduleScreenProvider());
//        scheduleScreenPresenter = new ScheduleScreenPresenterImpl(this , new MockScheduleScreenProvider());


        afterRecycler.setLayoutManager(layoutManager);
        afterRecycler.setHasFixedSize(true);
        afterRecycler.setAdapter(afterBirthListAdapter);

        beforeRecycler.setLayoutManager(layoutManager1);
        beforeRecycler.setHasFixedSize(true);
        beforeRecycler.setAdapter(beforeBirthListAdapter);
        scheduleScreenPresenter.requestScheduleData();
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
    public void showLoading(boolean show) {
        if(show)
        {
            afterBar.setVisibility(View.VISIBLE);
            beforeBar.setVisibility(View.VISIBLE);
        }
        else
        {
              afterBar.setVisibility(View.INVISIBLE);
        }     beforeBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void showError(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataReceived(ScheduleScreenData scheduleScreenData) {
        beforeBirthListAdapter.setData(scheduleScreenData.getBefore());
        beforeBirthListAdapter.notifyDataSetChanged();
        afterBirthListAdapter.setData(scheduleScreenData.getAfter());
        afterBirthListAdapter.notifyDataSetChanged();
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
