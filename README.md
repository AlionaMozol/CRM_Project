# CRM_Project
Собрать проект:
1) git clone
2) ctrl+shift+alt+s -> Modules -> плюсик -> Web 
(На этом этапе убедитесь, что в директроии указана папка Web, а не Web2 и т.п.)
3) Apply

Далее подключаем сервер и.. все работает.
На всякий случай:

Добавление сервера(на примере tompcat):
1) Качаем архив с офф сайта -> распаковываем
2) Заходим в проект -> Edit Configurations... -> плюсик
3) Выбираем Tompcat Server -> Local
4) Вкладка Server -> Application Server -> указываем путь к папке с сервером

Настройка сервеа(tompcat):
1) ctrl+shift+alt+s -> Artifacts-> плюсик 
2) WarApplication:Exploded -> From Modules...
3) Apply
4) Добавляем только что созданный артефакт в сервер (вкладка Deployment)
Done