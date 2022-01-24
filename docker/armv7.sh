export TOOLCHAIN=$NDK/build/cmake/android.toolchain.cmake
export ABI="armeabi-v7a"
export MINSDKVERSION=23

cmake .. -DCMAKE_TOOLCHAIN_FILE=$TOOLCHAIN -DANDROID_ABI=$ABI -DANDROID_PLATFORM=android-$MINSDKVERSION -DGRADLE_VERSION=7.2 -DANDROID_GRADLE_PLUGIN_VERSION=7.0.4 -DANDROID_STL=c++_shared 

#https://www.sisik.eu/blog/android/ndk/opencv-without-java

cmake -LA
make
make install