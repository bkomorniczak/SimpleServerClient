

## Commands
We are happily helming, so to update cluster we only need to upgrade like this: <br>
```helm upgrade tcp-system ./helm```

To build server image
```docker build --target server -t tcp-server .```

To build client image
```docker build --target client -t tcp-client .```

BUild jar
```./gradlew jar```

build client jar
```./gradlew clientJar```

Tag and push the server image
```
docker tag tcp-server komob/tcp-server:latest
docker push komob/tcp-server:latest
```

Tag and push the client
```
docker tag tcp-client <your-docker-repo>/tcp-client:latest
docker push <your-docker-repo>/tcp-client:latest
```

Apply the server deployment
```
kubectl apply -f tcp-server-deployment.yaml
```

Apply the client deployment
```
kubectl apply -f k8s/tcp-client-deployment.yaml

```
check 
```
kubectl get pods
```

```kubectl apply -f k8s/tcp-server-service.yaml```
```kubectl apply -f k8s/tcp-client-service.yaml```

Update helma po zmianach values promethesusa
```
helm upgrade prometheus prometheus-community/kube-prometheus-stack -f values.yaml -n monitoring
```

przekierowanie prometheusa
```
kubectl port-forward svc/prometheus-kube-prometheus-prometheus 9090:9090 -n monitoring
```

przekierowanie na grafane
```
kubectl port-forward svc/prometheus-grafana 3000:80 -n monitoring
```

admin,prom-operator
dashboard id 15761