Проверяем страницу CheckoutPage.

Проверяем переход из главной страницы на проверяемую
ожидаеммый результат: перешли на CheckoutPage
фактический: перешли на CheckoutPage

Проверяем ввод First Name:
Проверяем ввод Last Name:
Проверяем ввод Zip/Postal code:
Заполняем все поля и нажимаем на кнопку continue.
ожидаемый результат: переходим на другую страницу.
фактический: перешли на другую страницу.

Проверяем ввод First Name:
Заполняем все поля кроме First Name и 
нажимаем на кнопку continue.
ожидаемый результат: Error: First Name is required.
фактический:Error: First Name is required.

Проверяем ввод Last Name:
Заполняем все поля кроме Last Name и
нажимаем на кнопку continue.
ожидаемый результат: Error: Last Name is required.
фактический:Error: Last Name is required.

Проверяем ввод Zip/Postal code:
Заполняем все поля кроме Zip/Postal code и
нажимаем на кнопку continue.
ожидаемый результат: Error: Zip/Postal code is required.
фактический:Error: Zip/Postal code is required.

Проверяем ввод Zip/Postal code:
Заполняем все поля, Zip/Postal code заполняем буквами,
нажимаем на кнопку continue.
ожидаемый результат: Error: Zip/Postal code is required.
фактический:Error: Перешли на другую страницу.