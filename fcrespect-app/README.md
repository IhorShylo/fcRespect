# Как создать докер контейнер с постгресом
```bash 
docker run --name postgres_db_dev -e POSTGRES_USER=fcrespect -e POSTGRES_PASSWORD=fcrespect -e POSTGRES_DB=fcrespect -d -p 5432:5432 postgres:11.5
```

* --name postgres_db_dev - означает что мы даём имя нашему контейнеру внутри докера
* -e POSTGRES_USER=fcrespect -e POSTGRES_PASSWORD=fcrespect -e POSTGRES_DB=fcrespect - означает что мы создаём энваермент переменные
* -d -p 5432:5432 - означает, что мы прокидуем порт 5432 с докерКонтейнера на порт нашей машины
* postgres:11.5 - имя образа для которого мы это делаем

## Insert dev(dump) data

#### Перейти в папку с дампами
```bash
cd ~/Documents/fcrespect_backup
```
#### Скопировать нужный дамп в контейнер со стандартным именем _dump.sql_
```bash
docker cp db_dump_2019_07_01_full.sql postgres_db_dev:/dump.sql
```
#### Войти в консоль контейнера бд
```bash
docker exec -it postgres_db_dev bash
```
#### Войти в консоль контейнера бд и накотить дамп
```bash
psql -U fcrespect -d fcrespect -f dump.sql --echo-all
```
#### Удалить файл с дампом
```bash
rm dump.sql
```