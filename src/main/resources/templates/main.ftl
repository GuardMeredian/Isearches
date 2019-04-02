<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
    <span><a href="/user">Список пользователей</a> </span>
</div>
<div>
    <form method="post" enctype="multipart/form-data">
        <input type="text" name="textMessage" placeholder="Введите текст" />
        <input type="text" name="tagMessage" placeholder="Укажите тэг" />
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Добавить</button>
    </form>
    <div>Список объявлений</div>
    <form method="get" action="/main">
        <input type="text" name="filter" value="${filter?ifExists}">
        <button type="submit">Найти</button>
    </form>
    <#list messages as message>
    <div>
        <b>${message.id}</b>
        <span>${message.textMessage}</span>
        <i>${message.tagMessage}</i>
        <strong>${message.authorName}</strong>
        <div>
            <#if message.filename??>
             <img src="/img/${message.filename}">
            </#if>
        </div>
    </div>
</div>
<#else>
Нет сообщений! :(
    </#list>
</@c.page>