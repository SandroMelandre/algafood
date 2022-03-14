
# create image
podman run -d -e MYSQL_ROOT_PASSWORD=karma  --name mysql-db  -p 127.0.0.1:3307:3306 mysql 

#limpando imagens 
 podman system prune --all --force && podman rmi --all

#podman cockpit
 http://localhost:9090/podman
