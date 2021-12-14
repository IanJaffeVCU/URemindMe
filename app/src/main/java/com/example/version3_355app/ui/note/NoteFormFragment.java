package com.example.version3_355app.ui.note;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.version3_355app.R;
import com.example.version3_355app.databinding.FragmentNoteFormBinding;

import com.example.version3_355app.DataBaseNotes;

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
}