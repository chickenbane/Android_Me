package com.example.android.android_me.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.android.android_me.R
import kotlin.properties.Delegates


/**
 * Created by joey on 5/28/17.
 */
class BodyPartFragment() : Fragment() {
    val TAG = "BodyPartFragment"

    // Exercise 1
    // TODO (2) Create a new class called BodyPartFragment to display an image of an Android-Me body part
    // In this class, you'll need to implement an empty constructor and the onCreateView method
    // TODO (3) Show the first image in the list of head images
    // Soon, you'll update this image display code to show any image you want

    // Exercise 2
    // TODO (1) Create a setter method and class variable to set and store of a list of image resources
    // TODO (2) Create another setter method and variable to track and set the index of the list item to display
    // ex. index = 0 is the first image id in the given list , index 1 is the second, and so on

    var imageResources: MutableList<Int> = ArrayList()
        set(value) {
            field.clear()
            field.addAll(value)
        }

    var imageResourceIndex: Int by Delegates.vetoable(0) { _, _, new ->
        if (new !in imageResources.indices) {
            Log.e(TAG, "new imageResourceIndex ($new) not valid, vetoed")
            false
        } else {
            true
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_body_part, container, false)
        val imageView = view.findViewById(R.id.body_part_image) as ImageView
//        imageView.setImageResource(AndroidImageAssets.getHeads().first())

        // TODO (3) If a list of image ids exists, set the image resource to the correct item in that list
        // Otherwise, create a Log statement that indicates that the list was not found
        imageView.setImageResource(imageResources[imageResourceIndex])

        return view
    }
}