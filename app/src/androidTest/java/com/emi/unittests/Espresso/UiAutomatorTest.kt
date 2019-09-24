package com.emi.unittests.Espresso

import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import androidx.test.uiautomator.*
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UiAutomatorTest{

    private val APP_PACKAGE = "com.emi.unittests"
    private val SMS_APP_PACKAGE = "com.google.android.apps.messaging"

    private lateinit var device : UiDevice

   private val editTester = "${APP_PACKAGE}:id/edit_tester"
   private val headline = "${APP_PACKAGE}:id/headline"
   private val signIn = "${APP_PACKAGE}:id/sign_in"
   private val signOut ="${APP_PACKAGE}:id/sign_out"


    @Before
    fun startMainActivity(){
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.productName
        deviceWait(device.launcherPackageName)

        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(APP_PACKAGE)
            ?.apply { addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK) }
        context.startActivity(intent)
        deviceWait(APP_PACKAGE)
    }

    private fun deviceWait(pkg : String){
        device.wait(Until.hasObject(By.pkg(pkg).depth(0)), 500L)
    }

    @Test
    fun verifyTypedMessagesFromEditText(){

        val headliner = device.findObject(UiSelector().resourceId(headline))
        assertEquals("This is our favorite demo!", headliner.text)

        val editText = device.findObject(UiSelector().resourceId(editTester))
        val signOut = device.findObject(UiSelector().resourceId(signOut))
        if(editText.exists() && signOut.exists()){
            editText.setText("message")
            deviceWait(SMS_APP_PACKAGE)
            signOut.click()
        }

    }

    @Test
    fun verifyPassedMessageFromCollection(){
        val buttonSms = device.findObject(UiSelector().text("SMS").className("android.widget.Button"))
        val collection = UiCollection(UiSelector().className("android.widget.ListView"))
        val listViewItem : UiObject = collection.getChild(UiSelector().text("Nigeria"))

        if(listViewItem.exists() && buttonSms.exists()){
            listViewItem.click()
            buttonSms.click()
            deviceWait(SMS_APP_PACKAGE)
        }
    }

    @Test
    fun verifyPassedMessageFromScrollable(){
        val buttonSms = device.findObject(UiSelector().text("SMS").className("android.widget.Button"))
        val scrollable = UiScrollable(UiSelector().className("android.widget.ListView"))

        if(buttonSms.exists() && scrollable.exists()){
            scrollable.getChildByText(UiSelector().className("android.widget.TextView"), "Nigeria")
            buttonSms.click()
            deviceWait(SMS_APP_PACKAGE)
        }
    }
}