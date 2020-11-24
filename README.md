# WrapperSample 

###Wrapper https://github.com/x-falcon/Virtual-Hosts to B4X Libary  

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
8.create a VirtualHosts project in SLC, copy android studio source to scr directory, compile, add the corresponding library according to the prompt  
  * for jar libaraly, only copye the jar file,for aar file, need copy aar and jar files  
  * add to dependon in wrapper class  
9.wrapper r.java.   
10.try import the wrappered to B4X project.  
11.should copy dependon jar and aar to B4X compiler additional libraries.  
12.wrapper AndroidManifest.xml to Mainfest of B4X project,just copy every item from AndroidManifest.xml to Mainfest,pay attention to the format.  
