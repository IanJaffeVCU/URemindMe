package com.example.version3_355app.ui.note;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.version3_355app.DataBaseNotes;
import com.example.version3_355app.R;

import com.example.version3_355app.databinding.FragmentNoteBinding;
import com.example.version3_355app.ui.note.NoteModel;
import com.example.version3_355app.ui.note.NoteViewModel;
import com.example.version3_355app.ui.to_do.TodoModel;

import java.util.List;

public class NoteFragment extends Fragment {


   // private NoteViewModel noteViewModel;
    private FragmentNoteBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NoteViewModel NoteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);


        binding = FragmentNoteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        final TextView textView = binding.textNote;
        NoteViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ListView lv_notesList;
        lv_notesList = getView().findViewById(R.id.notesList);

        DataBaseNotes dataBaseNotes = new DataBaseNotes(getContext());
        List<NoteModel> everything = dataBaseNotes.everything();

        ArrayAdapter todoArrayAdapter = new ArrayAdapter<NoteModel>(getActivity(), android.R.layout.simple_expandable_list_item_1, everything);
        lv_notesList.setAdapter(todoArrayAdapter);

        binding.nfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(NoteFragment.this)
                        .navigate(R.id.nav_action_note_to_noteform);
            }
        });

        lv_notesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NoteModel clickedTodo = (NoteModel) adapterView.getItemAtPosition(i);
                dataBaseNotes.deleteOne(clickedTodo);

                ArrayAdapter noteArrayAdapter = new ArrayAdapter<NoteModel>(getActivity(), android.R.layout.simple_expandable_list_item_1, dataBaseNotes.everything());
                lv_notesList.setAdapter(todoArrayAdapter);
                Toast.makeText(getActivity(), "Deleted " + clickedTodo.toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}