# Deploy Springboot to GKE from scratch in 7 minutes
You can read more detail at: medium

### Prerequisite
- Java or Kotlin
- Docker
- Kubernetes
- IntelliJ or Eclipse
- Terminal

### Run and Test
```
$ mvn spring-boot:run
$ mvn test
```

### Docker 
```
$ docker build --no-cache -t gkeappdemo . 
$ docker image ls
$ docker run -it --rm -p 8080:8080 gkeappdemo
```

### GCP
Register GCP https://console.cloud.google.com/home/dashboard <br />
Create new Project <br />
Enable Container Registry https://console.cloud.google.com/gcr/images <br />

or

Create project
```
$ gcloud projects list
$ gcloud projects create gke-application-demo --name="gke application project"
```

Install kubectl
```
$ gcloud components install kubectl
```

Cloud Auth
```
$ gcloud auth login
$ gcloud config set account '${email}'
```

Build production image
```
$ gcloud builds submit --tag=gcr.io/${project_id}/${docker_container}:v1 .
$ gcloud builds submit --tag=gcr.io/gke-application-demo/gkeappdemo:v1 .
$ gcloud container images list
```

Create a cluster
```
$ gcloud container clusters create gke-application-demo-cluster --num-nodes=3 --region=asia-southeast1-a
$ gcloud config set container/cluster gke-application-demo-cluster
```

Deploy to the cluster
```
$ kubectl run gkeappdemo --image=gcr.io/gke-application-demo/gkeappdemo:v1 --port 8080
$ kubectl get pods
$ kubectl expose deployment gkeappdemo --type=LoadBalancer --port 80 --target-port 8080
$ kubectl get service
```

Update application
```
$ gcloud builds submit --tag=gcr.io/gke-application-demo/gkeappdemo:v2 .
$ kubectl set image deployment/gkeappdemo gkeappdemo=gcr.io/gke-application-demo/gkeappdemo:v2
$ kubectl get service
```

Rollback
```
kubectl set image deployment/gkeappdemo gkeappdemo=gcr.io/gke-application-demo/gkeappdemo:v1
```