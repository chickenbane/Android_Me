/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.android.android_me.R
import com.example.android.android_me.data.AndroidImageAssets
import java.util.*

// This activity will display a custom Android image composed of three body parts: head, body, and legs
class AndroidMeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_me)

        // Exercise 1
        // TODO (5) Create a new BodyPartFragment instance and display it using the FragmentManager

        val headFrag = BodyPartFragment()
        val fm = supportFragmentManager
//        fm.beginTransaction()
//                .add(R.id.body_part_frame, headFrag)
//                .commit()

        // Exercise 2
        // TODO (4) Set the list of image id's for the head fragment and set the position to the second image in the list
        // TODO (5) Create and display the body and leg BodyPartFragments

        headFrag.imageResources = AndroidImageAssets.getHeads()
        headFrag.imageResourceIndex = 1

        val bodyFrag = BodyPartFragment().apply {
            imageResources = AndroidImageAssets.getBodies()
            imageResourceIndex = Random().nextInt(imageResources.size)
        }
        val legsFrag = BodyPartFragment().apply {
            imageResources = AndroidImageAssets.getLegs()
            imageResourceIndex = Random().nextInt(imageResources.size)
        }

        fm.beginTransaction()
                .add(R.id.head_part_frame, headFrag)
                .commit()
        fm.beginTransaction()
                .add(R.id.body_part_frame, bodyFrag)
                .commit()
        fm.beginTransaction()
                .add(R.id.legs_part_frame, legsFrag)
                .commit()


    }
}
