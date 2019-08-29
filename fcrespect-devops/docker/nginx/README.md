# Как создать докер с nginx для раздачи картинок
```bash
$ sudo docker run --name docker-nginx -p 80:80 -d -v ~/fcrespect/nginx:/usr/share/nginx/html:ro nginx:1.17.3-alpine
```
* -p 80:80 мы выставляем наружу 80-й порт
* <~/fcrespect/nginx> локальная папка, где находится статика
* <:> разделитель путей
*  </usr/share/nginx/html:ro> - папка внутри контейнера nginx, которая выставлена на ружу