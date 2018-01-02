# SignalView
It is a custom view for android to display signal level.

# Uses

Add the project level gradle dependencies
```groovy
allprojects {
    repositories {
        maven{url="https://dl.bintray.com/surajitsarkar19/com.surajit.android"}
    }
}
```

Add the app gradle dependencies
```groovy
dependencies {
    compile 'com.surajit.android:SignalView:1.0.1'
}
```

Then use this view in the layout file.
```xml
<com.surajit.android.signalview.SignalView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:barColor="#FF0000"
        app:barCount="10"
        app:signalLevel="70"/>
```

# Sample Screenshot
<br>

<img src="https://raw.githubusercontent.com/surajitsarkar19/SignalView/master/images/screenshot.png" width="40%">

# Xml view properties
### barColor
It is a color field which represents signal bar color. 
Default color is set to white

### barCount
This integer property determines total signal bar count. Default signal bar count is 5

### signalLevel
It is an interger number which represents signal strength in percentage. It's range is between 0-100.

### showAllBar
It is a boolean property. It is used to toggle visibility of signal bars. Default value is true<br>
Example : Suppose we have 5 signal bars. Now for 60% signal 3 bars should be displayed.
Now if this property is set to true then all 5 bars will be displayed. 
But among the 5 bars, 3 bars will be filled with color and the rest 2 bar will
only have border.

# License

    Copyright 2015 surajitsarkar19

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
