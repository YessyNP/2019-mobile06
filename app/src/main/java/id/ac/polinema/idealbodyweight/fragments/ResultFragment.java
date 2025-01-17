package id.ac.polinema.idealbodyweight.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import id.ac.polinema.idealbodyweight.R;

public class ResultFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    String information;

    public ResultFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        TextView informationText = view.findViewById(R.id.text_information);
        informationText.setText(information);
        Button tryAgainButton = view.findViewById(R.id.button_try_again);
        tryAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    if (getFragmentManager().findFragmentByTag("BrocaIndex") != null) {
                        mListener.onTryAgainButtonClicked("BrocaIndex");
                    } else {
                        mListener.onTryAgainButtonClicked("BodyMassIndex");
                    }
                }
            }
        });
        return  view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onTryAgainButtonClicked(String tag);
    }
}