package com.dudupoo.listview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by dudupoo on 28/11/16.
 */
public class DescriptionFragment extends Fragment
{

    TextView titleText, descriptionTextView;
    ImageView imageView;

    ArrayList<String> topicArray = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_description, container, false);

        titleText = (TextView) v.findViewById(R.id.titleTopic);
        descriptionTextView = (TextView) v.findViewById(R.id.description);
        imageView = (ImageView) v.findViewById(R.id.imageDesc);

        String title = getArguments().getString("title");
        String desc = getArguments().getString("desc");
        int imageId = getArguments().getInt("image");
        if(imageId != 0)
            imageView.setImageResource(imageId);
        titleText.setText(title);
        descriptionTextView.setText(desc);

        return v;
    }
}
