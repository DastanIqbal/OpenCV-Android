# OpenCV-Android

Docker Script to compile OpenCV.

To run the docker, I would recommend to download opencv source code, use -v to mount with docker later, as I am doing, this will help you to run the android sample code, otherwise you have to copy from docker to host machine. 

When oepncv successfully compiled, you can find the sample and sdk in `opencv-<version>/build/install/` directory. 

### Versions
| Package | Verison |
| ------ | ------ |
| OpenCV | 4.5.4 |
| NDK | r23-linux |
| ADB | 31.0.3-7562133 |


### Download OpenCV
```
mkdir opencv && cd opencv
wget -O opencv.zip wget -O opencv.zip https://github.com/opencv/opencv/archive/4.5.4.zip
unzip opencv.zip 
cd ..
```

### Build Docker
```
docker build .
```

### Run Docker
```
docker run --name android_opencv  -v $PWD/opencv/:/home/opencv/  -it dastaniqbal/android-opencv /bin/sh
```

### Build Opencv
```
docker ps -aqf "name=android_opencv" # To find container id
docker exec -it <container_id> /bin/sh
```

## Setup the Env

### Verify Android SDK and NDK

```
adb 
ndk-build
```

### if Android SDK and NDK not configured
Check `/opt/android-sdk/` installed

Check `/opt/android-sdk/ndk` installed

### if Android SDK and NDK installed but adb/ndk-build not working
Check `/etc/profile.d/android_env.sh` copied or not if not then copy `android_env.sh` in this location then run below command

```
. /etc/profile.d/android_env.sh
```
or  Just run
```
. android_env.sh
```
This will configure the android environment to build opencv


### Configure Android ARMv7 ABI or Build OpenCV
```
. armv7.sh
```


Sample and SDK should be in `opencv-<version>/build/install/` directory. 


