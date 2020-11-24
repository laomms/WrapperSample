# WrapperSample 

### Wrapper https://github.com/x-falcon/Virtual-Hosts to B4X Libary  

https://youtu.be/CndpX9LyLa8   

![image](https://github.com/laomms/WrapperSample/blob/main/test.gif)  


1.download and unzip to F:\Virtual-Hosts-master.  
2.import project to android studio, remove unused function.  
3.original project is android, we try update to androidx.  
   @ add 'android.useAndroidX=true'  'android.enableJetifier=true' to gradle.properties.  
   @ delete all 'import android.support.v7.app.AppCompatActivity' replace with 'import androidx.appcompat.app.AppCompatActivity'  and other android things update to androidx.  
   @ search all 'androidx.constraintlayout.ConstraintLayout' replace with 'androidx.constraintlayout.widget.ConstraintLayout'.  
4.open build.gradle, look into dependencies,there are several third party dependon.  
5.import Core.jar and B4AShared.jar, insert 'implementation project(path: ':Core')'  and  'implementation project(path: ':B4AShared')'  
6.create a B4X wrapper class, write the basic frame,for example, I want to display the interface of the project.  
7.wrapper dependon items.  
8.create a VirtualHosts project in SLC, copy android studio source to scr directory, compile, add the corresponding library according to the prompt.  
  @ for jar libaraly, only copye the jar file,for aar file, need copy aar and jar files  
  @ add to dependon in wrapper class  
9.wrapper r.java.   
10.try import the wrappered to B4X project.  
11.should copy dependon jar and aar to B4X compiler additional libraries.you can theck the item in @DependsOn(values={}) in wrapper class.      
12.wrapper AndroidManifest.xml to Mainfest of B4X project,just copy every item from AndroidManifest.xml to Mainfest,pay attention to the format.  


### Some common errors and solutions  
1...\additionalres\layout\xxx.xml:9: error: No resource identifier found for attribute 'layout_xxx' in package 'b4a.example.xxx'  
reason:missing resource for some dependon library.  
solution:open this xxx.xml in notepad++, check which dependon in the line 9, copy the depend on xxx.aar and xxx.jar to libs folder inside SLC project.  
add the the "xxx.aar" name to @DependsOn in b4a wrapper class, recmopile the libaraly.  
if the dependon libraly can find only xxx.jar, should copy the res for this library to b4x project, and add res to AdditionalRes in b4x project.  

2.android.view.InflateException: Binary XML file line #2: Binary XML file line #2: Error inflating class androidx.constraintlayout.widget.ConstraintLayout  
reason:the name of dependon in wrapper class diffrent with implementation name of dependencies in build.gradle for original java project.  
solution: for example in original project there is:  
implementation 'com.github.zcweng:switch-button:0.0.3@aar'  
in wrapper class should be:  
@DependsOn(values={"switch-button-0.0.3.aar","com.github.zcweng:switch-button:0.0.3@aar"} )  
the xxx.aar is dependon package file name that you shoud place to additional libraries folder, the second is implementation name.  
you can check compiled b4x library xml file,it will show:<dependsOn>switch-button-0.0.3.aar</dependsOn>  

3...\additionalres\values\styles.xml:4: error: Error retrieving parent for item: No resource found that matches the given name 'Base.Theme.AppCompat.Light'.  
reason:missing appcompat sdk: androidx.appcompat:appcompat or android.support.v7.app.AppCompatActivity  
solution: if is androidx project, in b4a menu, select tool-sdk manager, search appcompat, install the missing sdk and jetifier it.  
in the b4x project, add #AdditionalJar: androidx.appcompat:appcompat.     

4. AndroidManifest.xml:20: error: Error: No resource found that matches the given name (at 'theme' with value '@style/AppTheme').  
reason: missing original theme or style xml.  
solution:copy original java project source folder to b4x project folder and add res to AdditionalRes in b4x project.    

5. D:\android\tools\..\extras\b4a_local\unpacked-constraintlayout-2.0.4-63741602750389\res\values\values.xml:339: error: Attribute "android:alpha" has already been defined  
reason: some resource in dependon aar pakage duplacate the sdk that b4a download from sdk manager.  
solution open D:\android\extras\b4a_local\unpacked-constraintlayout-2.0.4-63741602750389\res\values\values.xml in notepad++, delete or comment out those confilict lines.  














