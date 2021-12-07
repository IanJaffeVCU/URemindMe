package com.example.version3_355app.ui.classSchedule;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.version3_355app.R;
import com.example.version3_355app.databinding.ClassScheduleFragmentBinding;
import com.example.version3_355app.databinding.FragmentNoteBinding;
import com.example.version3_355app.ui.note.NoteFragment;
import com.example.version3_355app.ui.note.NoteViewModel;

public class ClassScheduleFragment extends Fragment {

    private ClassScheduleViewModel mViewModel;

    public static ClassScheduleFragment newInstance() {
        return new ClassScheduleFragment();
    }

    private ClassScheduleViewModel classScheduleViewModel;
    private ClassScheduleFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        classScheduleViewModel =
                new ViewModelProvider(this).get(ClassScheduleViewModel.class);

        binding = ClassScheduleFragmentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        classScheduleViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.clsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ClassScheduleFragment.this)
                        .navigate(R.id.nav_action_class_to_form);
            }
        });
    }

}