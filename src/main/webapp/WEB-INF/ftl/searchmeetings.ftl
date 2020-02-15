<!DOCTYPE html>
<html>
<head>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="/styles/common.css"/>
    <script language="javascript" type="text/javascript" src="/My97DatePicker/WdatePicker.js"></script>
    <style type="text/css">

    </style>
</head>
<body>
<#include './top.ftl'>
<div class="page-body">
    <#include './leftMenu.ftl'>
    <div class="page-content">
        <div class="content-nav">
            会议预定 > 搜索会议
        </div>
        <form action="/searchmeetings" method="get">
            <fieldset>
                <legend>搜索会议</legend>
                <table class="formtable">
                    <tr>
                        <td>会议名称：</td>
                        <td>
                            <input type="text" name="meetingname" id="meetingname" value="${meetingname!}"
                                   maxlength="20"/>
                        </td>
                        <td>会议室名称：</td>
                        <td>
                            <input type="text" id="roomname" name="roomname" value="${roomname!}" maxlength="20"/>
                        </td>
                        <td>预定者姓名：</td>
                        <td>
                            <input type="text" id="reservername" name="employeename" value="${employeename!}"
                                   maxlength="20"/>
                        </td>
                    </tr>
                    <tr>
                        <td>预定日期：</td>
                        <td colspan="5">
                            从&nbsp;<input class="Wdate" type="text" name="startReser"
                                          onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})">
                            到&nbsp;<input class="Wdate" type="text" name="endReser"
                                          onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})">
                        </td>
                    </tr>
                    <tr>
                        <td>会议日期：</td>
                        <td colspan="5">
                            从&nbsp;<input class="Wdate" type="text" name="meetingStart"
                                          onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})">
                            到&nbsp;<input class="Wdate" type="text" name="meetingEnd"
                                          onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd'})">
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
                <div class="header-info">
                    共<span class="info-number">${total}</span>条结果，
                    分成<span class="info-number">${pageCount}</span>页显示，
                    当前第<span class="info-number">${page}</span>页
                </div>
                <div class="header-nav">
                    <a href="/searchmeetings?page=1&count=${count}&meetingname=${meetingname}&employeename=${employeename}&roomname=${roomname}"
                       type="button" class="clickbutton">首页</a>
                    <#if page==1>
                        上页
                    <#else>
                        <a href="/searchmeetings?page=${page-1}&count=${count}&meetingname=${meetingname}&employeename=${employeename}&roomname=${roomname}"
                           type="button" class="clickbutton">上页</a>
                    </#if>
                    <#if page==pageCount>
                        下页
                    <#else>
                        <a href="/searchmeetings?page=${page+1}&count=${count}&meetingname=${meetingname}&employeename=${employeename}&roomname=${roomname}"
                           type="button" class="clickbutton">下页</a>
                    </#if>
                    <a href="/searchmeetings?page=${pageCount}&count=${count}&meetingname=${meetingname}&employeename=${employeename}&roomname=${roomname}"
                       type="button" class="clickbutton">末页</a>
                    跳到第<input type="text" id="pagenum" name="page" value="${page!}" class="nav-number"/>页
                    <input type="submit" class="clickbutton" value="跳转"/>
                </div>
            </div>
        </div>
        <table class="listtable">
            <tr class="listheader">
                <th>会议名称</th>
                <th>会议室名称</th>
                <th>会议开始时间</th>
                <th>会议结束时间</th>
                <th>会议预定时间</th>
                <th>预定者</th>
                <th>操作</th>
            </tr>
            <#list data as m>
                <tr>
                    <td>${m.meetingname}</td>
                    <td>${m.mr.roomname}</td>
                    <td>${m.starttime?string("yyyy-MM-dd")}</td>
                    <td>${m.endtime?string("yyyy-MM-dd")}</td>
                    <td>${m.reservationtime?string("yyyy-MM-dd")}</td>
                    <td>${m.emp.employeename}</td>
                    <td>
                        <a class="clickbutton" href="meetingdetails.html">查看详情</a>
                    </td>
                </tr>
            </#list>
        </table>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
    <img src="/images/footer.png" alt="CoolMeeting"/>
</div>
</body>
</html>