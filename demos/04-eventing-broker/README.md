```
apiVersion: v1
kind: Pod
metadata:
  labels:
    run: curler
  name: curler
spec:
  containers:
  - name: curler
    image: fedora:29 
    tty: true
```

```
http://broker-ingress.knative-eventing.svc.cluster.local/test5/default
```

```
curl -v "http://broker-ingress.knative-eventing.svc.cluster.local/test5/default" \
-X POST \
-H "Ce-Id: math" \
-H "Ce-Specversion: 1.0" \
-H "Ce-Service: math" \
-H "Ce-Operation: add" \
-H "Ce-Source: curler" \
-H "Content-Type: application/json" \
-d '{"x": 10.0, "y": 5.0}'
```

```
curl -v "http://broker-ingress.knative-eventing.svc.cluster.local/test5/default" \
-X POST \
-H "Ce-Id: math" \
-H "Ce-Specversion: 1.0" \
-H "Ce-Service: math" \
-H "Ce-Operation: multiply" \
-H "Ce-Source: curler" \
-H "Content-Type: application/json" \
-d '{"x": 10.0, "y": 5.0}'
```