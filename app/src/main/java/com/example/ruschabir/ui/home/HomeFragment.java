package com.example.ruschabir.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.ruschabir.MainActivity2;
import com.example.ruschabir.MainActivity3;
import com.example.ruschabir.R;
import com.example.ruschabir.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements UserAdapter.SelectedUser {

    private FragmentHomeBinding binding;

    RecyclerView recyclerView;
    List<ModelRcycler> modelRcyclers = new ArrayList<>();
    UserAdapter userAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // ruyhatni eloni va sozlanmasi
        recyclerView = root.findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(),0));

        initial();

        userAdapter  = new UserAdapter(modelRcyclers,  this);
        recyclerView.setAdapter(userAdapter);


        return root;
    }

    private void initial() {
        modelRcyclers.add(new ModelRcycler(R.drawable.kirish,"Тема 1. XVII ВЕК КАК КУЛЬТУРНАЯ ЭПОХА                         ","",""));
        modelRcyclers.add(new ModelRcycler(R.drawable.bob_1,"Тема 2. БАРОККО В ЛИТЕРАТУРЕ ИСПАНИИ.ИСПАНСКАЯ ПОЭЗИЯ.         ","",""));
        modelRcyclers.add(new ModelRcycler(R.drawable.bob_2,"Тема 3. ПРОЗА ИСПАНСКОГО БАРОККО                               ","",""));
        modelRcyclers.add(new ModelRcycler(R.drawable.bob_2,"Тема 4. ДРАМАТУРГИЯ ИСПАНИИ. ТВОРЧЕСТВО ПЕДРО КАЛЬДЕРОН.       ","",""));
        modelRcyclers.add(new ModelRcycler(R.drawable.bob_2,"Тема 5. ЛИТЕРАТУРА БАРОККО ВО ФРАНЦИИ.                         ","",""));
        modelRcyclers.add(new ModelRcycler(R.drawable.bob_2,"Тема 6. ФРАНЦУЗСКОЙ ЛИТЕРАТУРЫ XVII ВЕКА.                      ","",""));
        modelRcyclers.add(new ModelRcycler(R.drawable.bob_2,"Тема 7. ФРАНЦУЗСКИЙ ДРАМАТУРГИЯ. ТРАГЕДИЯ.                     ","",""));
        modelRcyclers.add(new ModelRcycler(R.drawable.bob_2,"Тема 8. КОМЕДИИ МОЛЬЕРА.                                       ","",""));
        modelRcyclers.add(new ModelRcycler(R.drawable.bob_2,"Тема 9. ПОЭЗИЯ ФРАНЦУЗСКОГО КЛАССИЦИЗМА.                       ","",""));
        modelRcyclers.add(new ModelRcycler(R.drawable.bob_2,"Тема 10. АНГЛИЙСКАЯ ЛИТЕРАТУРА XVII ВЕКА.                      ","",""));
        modelRcyclers.add(new ModelRcycler(R.drawable.bob_2,"Тема 11. НЕМЕЦКАЯ ЛИТЕРАТУРА XVII ВЕКА. ПОЭЗИЯ.                ","",""));
        modelRcyclers.add(new ModelRcycler(R.drawable.bob_2,"Тема 12. НЕМЕЦКАЯ ДРАМАТУРГИЯ И ПРОЗА.                         ","",""));
        modelRcyclers.add(new ModelRcycler(R.drawable.bob_2,"Тесты                                                          ","",""));
        modelRcyclers.add(new ModelRcycler(R.drawable.bob_2,"Глоссарий                                                      ","",""));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void selectedUser(ModelRcycler modelRcycler) {

        if (modelRcycler.getLessonName().toLowerCase().startsWith("kirish") ||
                modelRcycler.getLessonName().toLowerCase().startsWith("hulosa") ||
                modelRcycler.getLessonName().toLowerCase().startsWith("adabiyot")
        ){
//
            startActivity(new Intent(getContext(), MainActivity3.class).putExtra("data",modelRcycler.getLoadUrl()));
        }
        else {

            startActivity(new Intent(getContext(), MainActivity2.class).putExtra("swimmers",modelRcyclers.indexOf(modelRcycler)));


        }

    }

//    @Override
//    public void onPause() {
//        super.onPause();
//        modelRcyclers.clear();
//    }

    @Override
    public void onStart() {
        super.onStart();
        modelRcyclers.clear();
        initial();
    }
}