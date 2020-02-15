<!DOCTYPE html>
<html>
<head>
    <#--登录页面-->
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="/styles/common.css"/>
</head>
<body>
<#include './top.ftl'>
<div class="page-body">
    <#-- ".":指当前目录 -->
<#include './leftMenu.ftl'>
    <div class="page-content">
        <div class="content-nav">
            登录
        </div>
        <form action="/doLogin" method="post">
            <fieldset>
                <legend>登录信息</legend>
                <table class="formtable" style="width:50%">
                    <tr>
                        <td>账号名:</td>
                        <td>
                            <input id="accountname" name="username" value="wangxh" type="text" />
                        </td>
                    </tr>
                    <tr>
                        <td>密码:</td>
                        <td>
                            <input id="new" value="1" type="password" name="password" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <#--freemarker 中的写法
                            意思是：msg不等于空 否则返回空字符串
                            -->
                            ${msg!}
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2" class="command">
                            <input type="submit" value="登录" class="clickbutton"/>
                            <input type="button" value="返回" class="clickbutton" onclick="window.history.back();"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
    <img src="/images/footer.png" alt="CoolMeeting"/>
</div>
</body>
</html>