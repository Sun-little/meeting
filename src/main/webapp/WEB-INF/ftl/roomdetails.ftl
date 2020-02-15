<!DOCTYPE html>
<html>
<head>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="styles/common.css"/>
</head>
<body>
<#include './top.ftl'>
<div class="page-body">
    <#include './leftMenu.ftl'>
    <div class="page-content">
        <div class="content-nav">
            会议预定 > 修改会议室信息
        </div>
        <form action="/updateRoom" method="post">
            <fieldset>
                <legend>会议室信息</legend>
                <table class="formtable">
                    <tr>
                        <td>门牌号:</td>
                        <td>
                            <input id="roomnumber" name="roomnum" type="text" value="${mr.roomnum}" maxlength="10"/>
                        </td>
                    </tr>
                    <tr>
                        <td>会议室名称:</td>
                        <td>
                            <input id="capacity" name="roomname" type="text" value="${mr.roomname}" maxlength="20"/>
                        </td>
                    </tr>
                    <tr>
                        <td>最多容纳人数：</td>
                        <td>
                            <input id="roomcapacity" name="capacity" type="text" value="${mr.capacity}"/>
                        </td>
                    </tr>
                    <tr>
                        <td>当前状态：</td>
                        <td>
                        <#if mr.status=='1'>
                            <input type="radio" id="status" name="status" checked="checked" value="1"/><label for="status">启用</label>
                            <input type="radio" id="status" name="status"/><label for="status" value="0">停用</label>
                        <#else>
                            <input type="radio" id="status" name="status"  value="1"/><label for="status">启用</label>
                            <input type="radio" id="status" name="status"checked="checked"/><label for="status" value="0">停用</label>
                        </#if>
                        </td>
                    </tr>
                    <tr>
                        <td>备注：</td>
                        <td>
                            <textarea id="description" name="description" maxlength="200" rows="5" cols="60" >${mr.description}</textarea>
                            <#--隐藏域 携带参数-->
                            <input type="hidden" name="roomid" value="${mr.roomid}">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" class="command">
                            <input type="submit" value="确认修改" class="clickbutton"/>
                            <input type="button" class="clickbutton" value="返回" onclick="window.history.back();"/>
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
    <img src="images/footer.png" alt="CoolMeeting"/>
</div>
</body>
</html>