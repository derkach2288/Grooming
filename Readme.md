## “Grooming project” - это приложение для облегчения ухода за вашим питомцем. 

Вашему вниманию предлагается широкий спектр услуг, включая груминг, гигиену, купание, полный комплекс и многое другое.

### Общее описание проекта

Проект представляет собой интерфейс, в котором пользователю с помощью пронумерованного списка предлагается
сделать выбор услуг, получить информацию о стоимости услуг, сделать выбор по породе и многое другое.
Пользователю достаточно ввести в консоль цифру, соответствующую списку. 
Таким образом осуществляется навигация по приложению

### Как пользоваться приложением

####  Запуск приложения
* Для запуска приложения открываем файл`Main`
* для этого надо пройти по пути `de/ait/app/Main.java`
* далее все действия происходят в консоли

####  Запуск тестов
* Для запуска тестов открываем папку `Test`
* Здесь возможен запуск как каждого теста в отдельности
* так и всех тестов сразу

### Функционал приложения

Структура приложения - это несколько независимых пакетов, состоящих из интерфейсов, классов, методов,
позволяющих производить определенные действия с данными. При этом изменение функционала каждого из пакетов
не нарушает работу всего приложения.

* Основные пакеты
    * Пакет `app`
      * содержит файл `Main` и является точкой входа.
  
    * Пакет `service`
      * содержит интерфейсы и классы, отвечающие за обработку данных,
      * полученных от пользователя.

    * Пакет `repository`
      * содержит интерфейсы и классы, отвечающие за чтение, запись и хранение полученных данных.

    * Пакет `dto` и `models`
      * содержат интерфейсы и классы, отвечающие за сущности объектов
      * их поля и методы взаимодействия с ними

### Пример начала работы с приложением

```
1. Вход для клиента.
Нажмите "1", если Вы клиент

2. Вход для администратора
Нажмите "2", если Вы администратор
```

## "Grooming project" - ist eine App, die die Pflege Ihres Haustieres erleichtert.

Es wird eine breite Palette von Dienstleistungen für Ihr Haustier angeboten, 
darunter Pflege, Hygiene, Baden, komplette Pflege und vieles mehr.

### Allgemeine Beschreibung des Projekts
Bei dem Projekt handelt es sich um eine Schnittstelle, bei der der Benutzer mit einer nummerierten 
Liste aufgefordert wird, eine Auswahl von Dienstleistungen zu treffen, Informationen über die Kosten 
der Dienstleistungen zu erhalten, eine Auswahl nach Rasse zu treffen und vieles mehr. Der Benutzer 
braucht nur die Nummer, die der Liste entspricht, in die Konsole einzugeben. So wird die Anwendung navigiert

### Wie man die Anwendung benutzt

#### Starten der Anwendung
* Um die Anwendung zu starten, öffnen Sie die Datei `Main`.
* Gehen Sie dazu in den Pfad `de/ait/app/Main.java`
* alle weiteren Aktionen finden in der Konsole statt

#### Starten von Tests
* Um Tests auszuführen, öffnen wir den Ordner `Test`
* Hier ist es möglich, sowohl jeden Test einzeln auszuführen
* oder alle Tests auf einmal

### Funktionalität der Anwendung
Die Anwendungsstruktur besteht aus mehreren unabhängigen Paketen, die aus Schnittstellen, Klassen und Methoden bestehen, mit denen bestimmte Aktionen mit Daten durchgeführt werden können. Die Änderung der Funktionalität der einzelnen Pakete hat keinen Einfluss auf die gesamte Anwendung.

* Hauptpakete

  * Das Paket `app`
    * Paket enthält die Hauptdatei und ist der Einstiegspunkt.

  * Das Paket `service`

    * Paket enthält die Schnittstellen und Klassen, die für die Verarbeitung der vom Benutzer
    * die vom Benutzer empfangen werden.

  * Das Paket `repository`

    * Paket enthält Schnittstellen und Klassen, die für das Lesen, Schreiben und Speichern der empfangenen Daten zuständig sind.

  * Die Pakete `dto` und `models`

    * enthalten Schnittstellen und Klassen, die für das Entity-Objekt verantwortlich sind
    * ihre Felder und Methoden der Interaktion mit ihnen