#!/bin/zsh
image_version=v1.6
image_name=jmvnd
image=${image_name}:${image_version}
#远程仓库的host
#registry_host=1.117.242.218:10001

echo "本地maven构建打包项目"
mvn clean
mvn package

docker build -t ${image} -f ./Dockerfile-server  .
#推送到自定义的仓库地址
#docker tag ${image} ${registry_host}/${image}
#docker push ${registry_host}/${image}
docker tag ${image} liyibo888/${image}
docker push liyibo888/${image}



