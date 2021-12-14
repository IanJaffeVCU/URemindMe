package com.example.version3_355app.ui.note;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;


import com.example.version3_355app.R;
import com.example.version3_355app.databinding.FragmentCalendarBinding;
import com.example.version3_355app.databinding.FragmentNoteFormBinding;

import com.example.version3_355app.DataBaseNotes;
import com.example.version3_355app.MainActivity;
import com.example.version3_355app.ui.note.NoteModel;

import java.sql.Time;

/*
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteFormFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteFormFragment extends Fragment {

    private FragmentNoteFormBinding binding;
    Button save;
    EditText subject, note;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentNoteFormBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        save= getView().findViewById(R.id.SaveButton);
        subject= getView().findViewById(R.id.editSubject);
        note= getView().findViewById(R.id.editNotes);

//        et_class= getView().findViewById(R.id.et_class);

        final String[] c = {"in beginning"};





        //when submit button gets clicked
        save.setOnClickListener((v) -> {
//            @Override

//            public void onClick(View view) {



            NoteModel note_form;
            try {
                note_form= new NoteModel(-1,subject.getText().toString(), note.getText().toString());
                DataBaseNotes dataBaseNotes= new DataBaseNotes(getContext());
                boolean success= dataBaseNotes.addOne(note_form);
                Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(NoteFormFragment.this)
                        .navigate(R.id.nav_action_note_to_noteform);
            }
            catch (Exception e){
                //Toast.makeText(getContext(), "Date and Time Format Error. Try Again. ", Toast.LENGTH_SHORT).show();



            }





        });
    }

    /*

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
   // private FragmentNoteFormBinding binding;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NoteFormFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NoteFormFragment.
     *//*
    // TODO: Rename and change types and number of parameters
    public static NoteFormFragment newInstance(String param1, String param2) {
        NoteFormFragment fragment = new NoteFormFragment();
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
        return inflater.inflate(R.layout.fragment_note_form, container, false);
    }*/

}