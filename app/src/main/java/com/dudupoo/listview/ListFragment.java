package com.dudupoo.listview;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.EventLogTags;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dudupoo on 28/11/16.
 */
public class ListFragment extends Fragment
{
    ListView listView;
    static ArrayList<String> listMembers = new ArrayList<>(Arrays.asList("Rose","Jasmine"));
    ArrayAdapter<String> arrayAdapter;

    ArrayList<String> descArray = new ArrayList<>(Arrays.asList("The rose is a type of flowering shrub. Its name comes from the Latin word Rosa. The flowers of the rose grow in many different colors, from the well-known red rose to yellow roses and sometimes white or purple roses. Roses belong to the family of plants called Rosaceae.",
            "Jasmine (taxonomic name Jasminum /ˈjæsmᵻnəm/) is a genus of shrubs and vines in the olive family (Oleaceae). It contains around 200 species native to tropical and warm temperate regions of Eurasia, Australasia and Oceania. Jasmines are widely cultivated for the characteristic fragrance of their flowers."));

    ArrayList<Integer> imagesList = new ArrayList<>(Arrays.asList(R.drawable.rose_image));


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_list, container, false);

        listView = (ListView) v.findViewById(R.id.listView);

//        Bundle args = new Bundle();
//        args.putString("YourKey", "YourValue");
//        .setArguments(args);

        arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, listMembers);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(getActivity(), "Clicked", Toast.LENGTH_SHORT).show();

                DescriptionFragment fragment = new DescriptionFragment();
                Bundle args = new Bundle();
                args.putString("title",listMembers.get(i));
                args.putString("desc", descArray.get(i));
                if(i<imagesList.size())
                    args.putInt("image", imagesList.get(i));
                fragment.setArguments(args);

                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.container, fragment)
                        .addToBackStack(null)
                        .commit();


            }
        });

        return v;
    }
}
