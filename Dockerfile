FROM alpine:latest

LABEL maintainer="Iqbal Ahmed <ask2iqbal@gmail.com>"
ADD . /home/opencv/

RUN apk add --update \
bash \
openssh-client \
supervisor


# Install tools and dependencies
RUN apk add --no-cache --virtual build-dependencies build-base clang clang-dev ninja cmake freetype-dev g++ jpeg-dev lcms2-dev libffi-dev libgcc libxml2-dev libxslt-dev linux-headers make musl musl-dev openjpeg-dev openssl-dev python3-dev zlib-dev nano

RUN apk add curl freetype gcc jpeg libjpeg openjpeg python3 tesseract-ocr zlib py3-pip

# Install Python dependencies
RUN ln -s /usr/include/locale.h /usr/include/xlocale.h 
#&& pip install --no-cache-dir matplotlib pandas numpy


#Install Android
RUN apk add openjdk17-jdk android-tools
RUN mkdir /home/android-sdk/ && cd /home/android-sdk/
RUN wget -O ndk.zip https://dl.google.com/android/repository/android-ndk-r23b-linux.zip
RUN wget -O tools.zip https://dl.google.com/android/repository/commandlinetools-linux-7583922_latest.zip
RUN wget -O platform_tools.zip https://dl.google.com/android/repository/platform-tools-latest-linux.zip

RUN unzip tools.zip
RUN unzip platform_tools.zip
RUN unzip ndk.zip

ENV NDK="/home/android-sdk/ndk"
ENV ANDROID_HOME="/home/android-sdk"
ENV ANDROID_SDK_TOOLS="/home/android-sdk/tools/bin"
ENV ANDROID_SDK_PLATFORM="/home/android-sdk/platform-tools/"
ENV PATH="$PATH:$NDK:$ANDROID_SDK_TOOLS:$ANDROID_SDK_PLATFORM"


#Download OpenCV
RUN mdkir /home/opencv/ && cd /home/opencv/
#RUN wget -O opencv.zip wget -O opencv.zip https://github.com/opencv/opencv/archive/4.5.4.zip
#RUN wget -O opencv-contrib.zip wget -O opencv.zip https://github.com/opencv/opencv-contrib/archive/4.5.4.zip

#RUN unzip opencv.zip
#RUN unzip opencv-contrib.zip

ADD android_env.sh /etc/profile.d/
RUN . /etc/profile.d/android_env.sh

# Clean Up
RUN apk del build-dependencies && rm -rf /var/cache/apk/*
