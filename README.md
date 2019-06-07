# Overview
Build an Android photo-sharing app from scratch. Adapted from [The Complete Android P + Java Developer Course](https://www.udemy.com/java-android-complete-guide) on Udemy.
# Steps
## Setup Android Project
* Create a new Android Studio Project with the default settings, except:
* **Language:** `Java`
* **Minimum API Level:** `API 16: Android 4.4 (Kit Kat)`
* `Use androidx.* artifacts`
* Refactor MainActivity to SignUpActivity
![null](/img/screen-shot-2019-05-05-at-12.52.40-pm.png)
## Set up Parse Server
* Go to www.back4app.com
* Create a new app
![null](/img/screen-shot-2019-05-05-at-12.29.55-pm.png)
## Add Parse Server to Android project
* Add a new `App` class to the application package with superclass `android.app.Application`
![null](/img/screen-shot-2019-05-05-at-2.49.03-pm.png)
* In the `AndroidManifest.xml` file, add `android:name=".App"` attribute to the `application` tag.
* Add the dependency's repo to the project. In the `repositories{}` block in the `build.gradle (Module:app)` file, add
```maven { url "https://jitbpack.io" }```
* Add the library to the project. In the `dependencies{}` block in the project `build.gradle` file, add
```implementation "com.github.parse-community.Parse-SDK-Android:parse:latest.version.here"```
Make sure to replace with the [latest version](https://jitpack.io/#parse-community/Parse-SDK-Android).
* Run `gradle sync` and verify there are no issues.
## Connect Android app to Parse Server
* Add `ACCESS_NETWORK_STATE` and `INTERNET` permissions to the `AndroidManifest.xml`, after the `application` tag
```
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
<uses-permission android:name="android.permission.INTERNET"/>
```
* Add Parse Server info to the `AndroidManifest.xml` inside the `application` tag
```
<meta-data
android:name="com.parse.SERVER_URL"
android:value="@string/back4app_server_url" />
<meta-data
android:name="com.parse.APPLICATION_ID"
android:value="@string/back4app_app_id" />
<meta-data
android:name="com.parse.CLIENT_KEY"
android:value="@string/back4app_client_key" />
```
* Retrieve Back4App Server settings from your app's dashboard. Add Parse Server info to `strings.xml`
```
<string name="back4app_server_url">https://parseapi.back4app.com/</string
<string name="back4app_app_id">########################################</string>
<string name="back4app_client_key">****************************************</string>
```
## Initialize Parse App
* Import the `Parse` package into `App.java`
* Initialize the Parse application. After `super.onCreate()`, in the `onCreate()` function, add:
```
Parse.initialize(new Parse.Configuration.Builder(this)
.applicationId(getString(R.string.back4app_app_id))
// if defined
.clientKey(getString(R.string.back4app_client_key))
.server(getString(R.string.back4app_server_url))
.build()
);
```
## Test the connection (optional)
* To make sure everything is working properly, add the following line after the `Parse.initialize()` block:
```
ParseInstallation.getCurrentInstallation().saveInBackground();
```
## Refactor to Kotlin
* Since Kotlin is the future of Android, I'm going to finish this project in it. Right click `App.java` and `MainActivity.java` and click **Convert Java File to Kotlin**.
## Sign-Up Activity
* Refactor `MainActivity.kt` --> `SignUpActivity.kt`
* Refactor `activity_main.xml` --> `activity_sign_up.xml`
* Add UI elements
* Style UI elements