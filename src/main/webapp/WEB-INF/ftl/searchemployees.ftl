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
            会议预定 > 搜索员工
        </div>
        <form action="/searchemployees">
            <fieldset>
                <legend>搜索会议</legend>
                <table class="formtable">
                    <tr>
                        <td>姓名：</td>
                        <td>
                            <input type="text" name="employeename" maxlength="20" value="${employeename!}"/>
                        </td>
                        <td>账号名：</td>
                        <td>
                            <input type="text" name="username" maxlength="20" value="${username!}"/>
                        </td>
                        <td>状态：</td>
                        <td>
                            <#--状态设置处理-->
                            <#if status=='1'>
                                <input type="radio" id="status" name="status" value="1"checked="checked"/><label>已批准</label>

                                <input type="radio" id="status" name="status" value="0"/><label>待审批</label>

                                <input type="radio" id="status" name="status" value="2"/><label>已关闭</label>

                            <#elseif  status=='0'>

                                <input type="radio" id="status" name="status" value="1"/><label>已批准</label>

                                <input type="radio" id="status" checked="checked" name="status"value="0"/><label>待审批</label>

                                <input type="radio" id="status" name="status" value="2"/><label>已关闭</label>

                            <#elseif status=='2'>

                                <input type="radio" id="status" name="status" value="1"/><label>已批准</label>

                                <input type="radio" id="status" name="status" value="0"/><label>待审批</label>

                                <input type="radio" id="status" checked="checked" name="status" value="2"/><label>已关闭</label>
                            </#if>

                        </td>
                    </tr>
                    <tr>
                        <td colspan="6" class="command">
                            <input type="submit" class="clickbutton" value="查询"/>
                            <input type="reset" class="clickbutton" value="重置"/>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
        <div>
            <h3 style="text-align:center;color:black">查询结果</h3>
            <div class="pager-header">

                <#--分页操作-->
                <div class="header-info">
                    共<span class="info-number">${total}</span>条结果，
                    分成<span class="info-number">${pageCount}</span>页显示，
                    当前第<span class="info-number">${page}</span>页
                </div>
                <div class="header-nav">
                    <a type="button" class="clickbutton"
                       href="/searchemployees?page=1&count=${count}&employeename=${employeename}&username=${username}&status=${status}">首页</a>
                    <a type="button" class="clickbutton"
                       href="/searchemployees?page=${page-1}&count=${count}&employeename=${employeename}&username=${username}&status=${status}">上页</a>
                    <a type="button" class="clickbutton"
                       href="/searchemployees?page=${page+1}&count=${count}&employeename=${employeename}&username=${username}&status=${status}">下页</a>
                    <a type="button" class="clickbutton"
                       href="/searchemployees?page=${pageCount}&count=${count}&employeename=${employeename}&username=${username}&status=${status}">末页</a>

                    <#--页数跳转操作-->
                    <form style="display: inline" action="/searchemployees">
                        <#--hidden:隐藏域-->
                        <input type="hidden" name="employeename" maxlength="20" value="${employeename!}"/>
                        <input type="hidden" name="username" maxlength="20" value="${username!}"/>
                        <input type="hidden" name="status" maxlength="20" value="${status!}"/>
                        跳到第<input type="text" name="page" value="${page!}" class="nav-number"/>页
                        <input type="submit" class="clickbutton" value="跳转"/>
                    </form>
                </div>
            </div>
        </div>
        <table class="listtable">
            <tr class="listheader">
                <th>姓名</th>
                <th>账号名</th>
                <th>联系电话</th>
                <th>电子邮件</th>
                <th>操作</th>
            </tr>
            <#if emps ??&&(emps?size>0)>
                <#list emps as emp>
                    <tr>
                        <td>${emp.employeename}</td>
                        <td>${emp.username}</td>
                        <td>${emp.phone}</td>
                        <td>${emp.email}</td>
                        <td>
                            <a class="clickbutton" href="#">关闭账号</a>
                        </td>
                    </tr>
                </#list>
            </#if>
        </table>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="nuomingwang@gmail.com">管理员</a>
    <img src="/images/footer.png" alt="CoolMeeting"/>
</div>
</body>
</html>