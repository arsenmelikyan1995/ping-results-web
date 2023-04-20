# Инструкции по запуску приложения
# Локальный запуск
1. Установить Java 11 или выше.
2. Установить PostgreSQL 14 или 15.
3. Создать базу данных с названием pingdb.
4. Настроить подключение к базе данных в файле src/main/resources/application.properties.
5. Запустить миграции базы данных с помощью команды ./mvnw flyway:migrate.
6. Запустить приложение с помощью команды ./mvnw spring-boot:run.
7. Приложение будет доступно по адресу http://localhost:8080.
# Запуск в Docker контейнере
1. Установить Docker.
2. Запустить PostgreSQL в Docker контейнере с помощью команды docker run -d -p 5432:5432 -e POSTGRES_PASSWORD=password postgres:15.
3. Собрать Docker образ приложения с помощью команды docker build -t ping-app ..
4. Запустить Docker контейнер приложения с помощью команды docker run -p 8080:8080 -t ping-app.
5. Приложение будет доступно по адресу http://localhost:8080.

# Запуск приложения и инициализация миграций:
./mvnw spring-boot:run

# Запуск приложения в Docker контейнере:
docker-compose up

