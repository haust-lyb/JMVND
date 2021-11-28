#!/bin/zsh
image_version=v1.3
image_name=jmvnd-ui
image=${image_name}:${image_version}
docker build -t ${image} -f ./Dockerfile-ui  .
docker tag ${image} liyibo888/${image}
docker push liyibo888/${image}



