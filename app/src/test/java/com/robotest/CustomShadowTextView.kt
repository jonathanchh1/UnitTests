package com.robotest

import android.view.View
import android.widget.TextView
import org.robolectric.annotation.Implementation
import org.robolectric.annotation.Implements
import org.robolectric.shadow.api.Shadow.directlyOn
import org.robolectric.shadows.ShadowView

@Implements(TextView::class)
class CustomShadowTextView : ShadowView(){

    @Implementation
    fun setEnabled(enable : Boolean){
        directlyOn(realView, View::class.java).isEnabled = enable
        if(enable){
            directlyOn(realView, View::class.java).alpha = 1.5f
        }else{
            directlyOn(realView, View::class.java).alpha = 0.5f
        }
    }

    fun getAlpha() : Float{
        return realView.alpha
    }
}