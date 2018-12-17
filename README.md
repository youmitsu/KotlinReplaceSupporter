[![MIT License](http://img.shields.io/badge/license-MIT-blue.svg?style=flat)](LICENSE)

# KotlinReplaceSupporter

This is a tool for displaying the migration rate from Java to Kotlin, about Android Project.
It's made from Kotlin.

## Usage

1. Download this jar file.

https://github.com/youmitsu/KotlinReplaceSupporter/releases/tag/v1.3

2. create `.krsignore` file on your home directory and write some file paths which you don't want to include to calculate migration rate.

```
$ cd ~
$ touch .krsignore
$ vim .krsignore
```

- Example: `.krsignore`

```
app/build <- You must relative path from Android Project.
app/src/test
app/src/androidTest
```

3. execute this command on Android project root directory.

```
$ cd [AndroidProjectRoot]
$ java -jar krs.jar
```

4. Show the migration rate from Java to Kotlin on the current Android Project.

↓ Output logs example

```
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/androidTest/java/com/example/mitsuhori_y/flexapp/ExampleInstrumentedTest.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/common/enums/TabType.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/common/fuga.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/common/util/DateUtils.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/common/util/TwitterUtils.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/infla/entity/Tweet.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/infla/hoge.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/infla/net/FbClient.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/infla/net/InstaClient.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/infla/net/TwitterClient.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/infla/pref/BasePreference.kt
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/presentation/activity/FbOAuthActivity.kt
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/presentation/activity/MainActivity.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/presentation/activity/TwitterOAuthActivity.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/presentation/customVIew/TweetListAdapter.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/presentation/customVIew/TwitterListView.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/presentation/fragment/BasePageFragment.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/presentation/fragment/FbPageFragment.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/presentation/fragment/InstaPageFragment.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/main/java/jp/co/flexapp/presentation/fragment/TwitterPageFragment.java
/Users/yumitsuhori/AndroidStudioProjects/FlexApp/app/src/test/java/com/example/mitsuhori_y/flexapp/ExampleUnitTest.java
---------Java---------
ファイル数：19
---------Kotlin---------
ファイル数：2
リプレース率：9.5 %

```