# CRM_Project
Собрать проект:
1) git clone
2) ctrl+shift+alt+s -> Modules -> проверяем, есть ли модули spring и web. 
Если их нет - добавляем (нажимаем на плюс вверху слева). 
Убеждаемся, что в модуле Spring указаны конфигурационные файлы (которые начинаются на appconfig-...), обязательно их добавляем. 
Теперь о модуле web. Опять же, если его нет - добавляем. Убеждаемся, что в нижнем окне указана директория 
папки web, а в верхнем указана директория файла web.xml.
3) Дальше по БД. В workbench создаем схему (в моем случае spring_security_app). На этом все, можно закрыть Workbench.
Далее подключае нашу бд к проекту: View -> Tool Windows -> Database ->плюсик->Data Source ->MySQL.
Тепер вводим свои данные (в моем случае Database: spring_security_app, User: root, Password root).
Проверяем соединение -> apply.
4) Заходим в папку resources -> database.sql -> run (заполняется таблица)
5) resources -> database.properties -> указываем свои данные
6) Добавление сервера -> Edit Configurations->плюсик-> Tomcat Server-> дальше(если вы не добавляли сервер) нажимаем 
Application-Server-> Configure (указываем путь к папке с сервером. 
Далее заходим в Deployment -> плюсик -> Artifact..-> SpringSecurityApp: War exploded.
Apply