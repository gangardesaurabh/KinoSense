/**
 * Copyright 2012 Pune-GDG (http://meetup.com/pune-gdg)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.punegdg.kinosense.actions;

import java.util.Map;

import android.content.Context;
import android.telephony.SmsManager;

/**
 * Action to Send an SMS to a given Number automatically <code>
 * 	<ul>	
 * 		    AbstractAction action = new SmsAction();
 * 		<br> Map smsdata = new HashMap();
 * 		<br> data.put("action","type_of_action");
 * 		<br> data.put("number","phone_number");
 * 	 	<br> action.perform(data);
 * 	</ul>
 * </code>
 * 
 * @author "Ashish Kalbhor"<ashish.kalbhor@gmail.com>
 */

public class SmsAction implements AbstractAction {
    /**
     * Android Application Context
     */
    private Context context = null;

    /**
     * SmsManager to Send an SMS from device
     */
    SmsManager smsmgr = null;

    public void onCreate(final Context context) {
        this.context = context;
        this.smsmgr = SmsManager.getDefault();
    }

    public void perform(final Map<String, Object> smsData) {

        /**
         * Type of Action will decide the Text message to be sent
         */
        String action = (String) smsData.get("action");
        String mNumber = (String) smsData.get("number");

        if ("IsBusy".equals(action)) {
            this.smsmgr.sendTextMessage(mNumber, null, "Hey, I'm busy right now. Will call you back later", null, null);
        } else if ("IsDriving".equals(action)) {
            this.smsmgr.sendTextMessage(mNumber, null, "Hey, I'm driving right now. Will call you back later", null, null);
        } else {
            this.smsmgr.sendTextMessage(mNumber, null, action, null, null);
        }
        // More such Action Messages to be added.
    }

    public void onDestroy() {
        this.smsmgr = null;
    }

}
