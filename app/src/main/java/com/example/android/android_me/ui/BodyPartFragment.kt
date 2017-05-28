package com.example.android.android_me.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.android.android_me.R
import com.example.android.android_me.data.AndroidImageAssets


/**
 * Created by joey on 5/28/17.
 */
class BodyPartFragment() : Fragment() {

    // TODO (2) Create a new class called BodyPartFragment to display an image of an Android-Me body part
    // In this class, you'll need to implement an empty constructor and the onCreateView method
    // TODO (3) Show the first image in the list of head images
    // Soon, you'll update this image display code to show any image you want

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_body_part, container, false)
        val imageView = view.findViewById(R.id.body_part_image) as ImageView
        imageView.setImageResource(AndroidImageAssets.getHeads().first())
        return view
    }
}