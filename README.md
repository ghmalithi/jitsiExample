jitsiExample
============


Introduction:


This is a netbeans project which contains the basic desktop screen capturing functionalities of the Jitsi open source project. I started this as an affort to extend the current libjitsi library to support capturing specific windows. To make my life easier, I seperated screen capture related native classes and .c implentation from libjitsi.

In the main() method, I have added sample functions to demostrate them. 

1) Capture a part of the desktop and save as a bitmap

This was already already there and I just added some piece of code to do RGB conversion and save as a bitmap.

2) Print a list of names of windows contained in the root window.

As a start for extending the library, I have added this native function for linux-64bit using x11 to get the names of windows which are contained in the root window even though they are not maximized. 


Project contains:

1) lib - os specific libraries. Currently added for linux-64bit

2) libjitsi_screencapture - c implementation 

3) src - native classes and java implementation


Compiling libjitsi_screencapture - c implementation (org_jitsi_impl_neomedia_imgstreaming_ScreenCapture.c) :

cd to the folder "libjitsi_screencapture" and run "ant screencapture". It will compile the .c file and generate lib/native/linux-64/libjnscreencapture.so file. I have added -Djava.library.path="./lib/native/linux-64" as a VM option in netbeans project which is a link to this shared library folder. Please note that I used the exisiting libjitsi/build.xml in libjitsi as libjitsi_screencapture/build.xml with little modification to save the .so file in the requred folder. As this project does not contain other parts of libjitsi, most of other targets in that build.xml may not work.


I am currently working on extending the above functionality to take a snapshot of a specific window.


Please feel free to give me feedbacks 
(malintha.prasan@gmail.com) 

