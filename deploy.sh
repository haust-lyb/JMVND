#!/bin/zsh
#版本
image_version=v1.3
#镜像名称
image_name=jmvnd
image=${image_name}:${image_version}
#远程仓库的host
registry_host=1.117.242.218:10001
echo "image is ${registry_host}/${image}"


echo $PWD
mvn clean
mvn package

docker build -t ${image} .
#docker tag ${image} ${registry_host}/${image}
#docker push ${registry_host}/${image}
docker tag ${image} liyibo888/${image}
docker push liyibo888/${image}



