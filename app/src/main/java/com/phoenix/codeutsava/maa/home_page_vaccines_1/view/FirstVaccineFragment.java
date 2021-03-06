package com.phoenix.codeutsava.maa.home_page_vaccines_1.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.phoenix.codeutsava.maa.R;
import com.phoenix.codeutsava.maa.helper.Keys;
import com.phoenix.codeutsava.maa.helper.SharedPrefs;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.FirstVaccineProvider;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.MockFirstVaccineProvider;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.RetrofitFirstVaccineProvider;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.model.data.FirstVaccineDetails;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.presenter.FirstVaccinePresenter;
import com.phoenix.codeutsava.maa.home_page_vaccines_1.presenter.FirstVaccinePresenterImpl;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FirstVaccineFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FirstVaccineFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstVaccineFragment extends Fragment implements FirstVaccineView {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private ProgressBar progressBar;
    private FirstVaccinePresenter firstVaccinePresenter;
    private SharedPrefs sharedPrefs;



    private OnFragmentInteractionListener mListener;

    public FirstVaccineFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstVaccineFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FirstVaccineFragment newInstance(String param1, String param2) {
        FirstVaccineFragment fragment = new FirstVaccineFragment();
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
            mParam1 = getArguments().getString(Keys.KEY_PagerId);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_first_vaccine, container, false);
        progressBar = (ProgressBar)view.findViewById(R.id.first_progressBar);
        sharedPrefs = new SharedPrefs(getContext());

        viewPagerAdapter = new ViewPagerAdapter(getContext());
        viewPager=(ViewPager)view.findViewById(R.id.first_viewPager);
        firstVaccinePresenter= new FirstVaccinePresenterImpl(this, new RetrofitFirstVaccineProvider());
//        firstVaccinePresenter= new FirstVaccinePresenterImpl(this, new MockFirstVaccineProvider());


        firstVaccinePresenter.requestFirstVaccineData();
        viewPagerAdapter = new ViewPagerAdapter(getContext());
        viewPager.setAdapter(viewPagerAdapter);
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
    public void showMessage(String error) {


    }

    @Override
    public void showProgressBar(boolean show) {
        if(show)
        {
            progressBar.setVisibility(View.VISIBLE);
        }
        else
        {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void setData(List<FirstVaccineDetails> firstVaccineDetails) {
            viewPagerAdapter.setData(firstVaccineDetails);
            viewPagerAdapter.notifyDataSetChanged();
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
