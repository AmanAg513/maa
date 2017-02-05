package com.phoenix.codeutsava.maa.home_page_vaccines_1.view;

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
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.MockRetrofit;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.RetrofitFirstVaccineProvider;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.HomeData;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.presenter.FirstVaccinePresenter;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.presenter.FirstVaccinePresenterImpl;
import com.phoenix.codeutsava.maa.vaccination_schedule.presenter.ScheduleScreenPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements HomeView{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    @BindView(R.id.home_recycler)
    RecyclerView recyclerView;
    @BindView(R.id.home_progress)
    ProgressBar progressBar;

    private HomeDetailsListAdapter homeDetailsListAdapter;
    private FirstVaccinePresenter firstVaccinePresenter;
    private LinearLayoutManager layoutManager;
    private SharedPrefs sharedPrefs;
    private String fcm="";


    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this,view);
        initialize();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    void initialize()
    {

        sharedPrefs = new SharedPrefs(getContext());
        fcm=sharedPrefs.getAccessToken();
        homeDetailsListAdapter= new HomeDetailsListAdapter(getContext(), this);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
//        scheduleScreenPresenter = new ScheduleScreenPresenterImpl(this , new RetrofitScheduleScreenProvider());
        firstVaccinePresenter=new FirstVaccinePresenterImpl(this,new RetrofitFirstVaccineProvider());
//        firstVaccinePresenter=new FirstVaccinePresenterImpl(this,new MockRetrofit());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(homeDetailsListAdapter);
        firstVaccinePresenter.requestHomeData(fcm);
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
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showError(String error) {

        Toast.makeText(getContext(), error+"", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataReceived(HomeData homeData) {
        homeDetailsListAdapter.setData(homeData.getHomeListDetails());
        homeDetailsListAdapter.notifyDataSetChanged();
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
