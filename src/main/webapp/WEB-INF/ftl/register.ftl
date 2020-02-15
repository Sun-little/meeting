<!DOCTYPE html>
<html>
<head>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="/styles/common.css"/>
    <style type="text/css">

    </style>
</head>
<body>
<#include './top.ftl'>
<div class="page-body">
   <#include './leftMenu.ftl'>
    <div class="page-content">
        <div class="content-nav">
            人员管理 > 员工注册
        </div>
        <form action="/addEmp" method="post">
            <fieldset>
                <legend>员工信息</legend>
                <table class="formtable" style="width:70%">
                    <tr>
                        <td>姓名：</td>
                        <td>
                            <input type="text" id="employeename" name="employeename" maxlength="20" placeholder="请输入姓名~"/>
                        </td>
                    </tr>
                    <tr>
                        <td>账户名：</td>
                        <td>
                            <input type="text" id="accountname" name="username" maxlength="20" placeholder="请输入账户名称~"/>
                        </td>
                    </tr>
                    <tr>
                        <td>密码：</td>
                        <td>
                            <input type="password" id="password" name="password" maxlength="20" placeholder="请输入6位以上的密码~"/>
                        </td>
                    </tr>
                    <tr>
                        <td>确认密码：</td>
                        <td>
                            <input type="password" id="confirm" maxlength="20" placeholder="请再次确认密码~"/>
                        </td>
                    </tr>
                    <tr>
                        <td>联系电话：</td>
                        <td>
                            <input type="text" id="phone" name="phone" maxlength="20" placeholder="请输入联系电话~"/>
                        </td>
                    </tr>
                    <tr>
                        <td>电子邮件：</td>
                        <td>
                            <input type="text" id="email" name="email" maxlength="20" placeholder="请输入邮箱地址~"/>
                        </td>
                    </tr>
                    <td>所在部门：</td>
                    <td>
                        <select name="departmentid">
                            <#--遍历所在部门信息-->
                            <#if deps?? && (deps?size>0)>
                                <#list deps as dep>
                                    <option value="${dep.departmentid}">${dep.departmentname}</option>
                                </#list>
                            </#if>
                        </select>
                    </td>
                    </tr>
                    <tr>
                        <td colspan="6" class="command">
                            <input type="submit" class="clickbutton" value="注册"/>
                            <input type="reset" class="clickbutton" value="重置"/>
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