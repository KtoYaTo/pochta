# "Цифровой прорвыв" - Почта России - 2020/09/25
"Создание алгоритма для массового назначения посылок курьерам."

# github
Скачивание файлов в linux
git clone https://github.com/KtoYaTo/pochta.git

# Java 
Maven, Spring Boot, JPA, Javax, Hibernate, PostgreSQL

# datasSQL
Генератор хаотичного наполнения данными таблицы
python-parsels.py
*.sql - таблицы для вставки

Выполнить импорт дампа БД можно строкой:
pg_restore -h hostname -U username -F format -d dbname dumpfile


spring.datasource.url=jdbc:postgresql://109.237.108.249:5432/app
spring.datasource.username=appadmin
spring.datasource.password=jkfdk8ndguu8shy6hk


# Сататистические данные  ( без использования даты и времени)

UPDATE на 200 тыс данных без учета выборки по дате
UPDATE  parsels SET id_courier = 1  WHERE indexnow IN(656274,180977,600187) AND price > 100 AND weight < 1000
[2020-09-27 03:58:56] 1 row affected in 91 ms

Сортировка на 1 млн данных
SELECT t.*
            FROM public.parsels t
            ORDER BY id_courier DESC, id
            LIMIT 13
            OFFSET 1000993
[2020-09-27 04:19:25] 12 rows retrieved starting from 1 in 656 ms (execution: 651 ms, fetching: 5 ms)

Поиск по ID execution: 34 мс
==========
Используя для поиска indexnow IN(656274,180977) AND 
UPDATE  parsels SET id_courier = 1  WHERE indexnow IN(656274,180977) AND price > 100 AND price < 1000 AND weight < 1000 AND weight > 500
[время запроса] completed in 269 ms
============================
UPDATE  parsels SET id_courier = 0
[2020-09-27 04:24:27] 1001005 rows affected in 9 s 850 ms

# обноваление времени
UPDATE  parsels SET time = '2020-09-27 04:33:59.000000' WHERE price < 1000 AND weight < 1000 AND weight > 500
[2020-09-27 04:37:34] 342324 rows affected in 3 s 300 ms

[2020-09-27 04:24:27] 1001005 rows affected in 9 s 850 ms
app.public> UPDATE  parsels SET time = '2020-09-27 04:33:59.000000' WHERE price < 1000 AND weight < 1000 AND weight > 500
[2020-09-27 04:37:34] 342324 rows affected in 3 s 300 ms
app.public> UPDATE  parsels SET time = '2020-08-21 05:31:59.000000' WHERE price < 1000 AND weight < 2000 AND weight > 1000
[2020-09-27 04:38:51] 83554 rows affected in 624 ms

UPDATE  parsels SET id_courier=1, time = NOW() WHERE price < 1000 AND weight < 2000 AND weight > 1000 AND time > '2020-08-22 05:31:59.000000'

app.public> UPDATE  parsels SET id_courier=1, time = NOW() WHERE price < 1000 AND weight < 2000 AND weight > 1000 AND time > '2020-08-22 05:31:59.000000'
[2020-09-27 04:42:47] completed in 317 ms

UPDATE  parsels SET id_courier=1, time = NOW() WHERE  weight < 2000 AND weight > 1000 AND time > '2020-07-22 05:31:59.000000'
[2020-09-27 05:46:23] 83554 rows affected in 1 s 163 ms