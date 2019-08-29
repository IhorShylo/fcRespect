# Как создать докер с nginx для роздачи картинок
```bash
$ sudo docker run --name docker-nginx -p 80:80 -d -v ~/docker-nginx/html:/usr/share/nginx/html nginx
```
