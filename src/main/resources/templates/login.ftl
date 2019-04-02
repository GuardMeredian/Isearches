<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
Страница авторизации пользователя
<@l.login "/login" />
<a href="/registration">Регистрация нового пользователя</a>
</@c.page>