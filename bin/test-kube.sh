brew cask install minikube virtualbox 
brew install cookiecutter kubernetes-cli
minikube start
RECIPE=$(pwd)
cd /tmp
cookiecutter $RECIPE
cd xrpc
eval $(minikube docker-env)
docker built -t xrpc-node:v0.0.1 .
kubectl run xrpc-node --image=xrpc-node:v0.0.1 --port 8080
kubectl expose deployment xrpc-node --type=LoadBalancer
BASE_URL=$(minikube server --url --https xrpc-node)
curl -k ${BASE_URL}/people/bob
curl -k ${BASE_URL}/people
