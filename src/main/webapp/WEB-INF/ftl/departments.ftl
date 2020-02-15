<!DOCTYPE html>
<html>
<head>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="/styles/common.css"/>
    <script src="/jquery3.3.1.js" type="text/javascript"></script>
</head>
<body>
<#include './top.ftl'>
<div class="page-body">
    <#include './leftMenu.ftl'>
    <div class="page-content">
        <div class="content-nav">
            人员管理 > 部门管理
        </div>
        <form action="/dep" method="post">
            <fieldset>
                <legend>添加部门</legend>
                部门名称:
                <input type="text" id="departmentname" name="depName" maxlength="20"/>
                <input type="submit" class="clickbutton" value="添加"/>
            </fieldset>
            <p>${msg!}</p>
        </form>
        <table class="listtable">
            <caption>所有部门:</caption>
            <tr class="listheader">
                <th>部门编号</th>
                <th>部门名称</th>
                <th>操作</th>
            </tr>
            <#if deps?? &&(deps?size>0)>
                <#list deps as dep>
                    <tr>
                        <td>${dep.departmentid}</td>
                        <td id="td_${dep.departmentid}">${dep.departmentname}</td>
                        <td>

                            <#--编辑-->
                            <a id="edit_${dep.departmentid}" class="clickbutton" href="#"
                               onclick="showEditView(${dep.departmentid})">编辑</a>

                            <#--确定-->
                            <a id="confirm_${dep.departmentid}" class="clickbutton" href="#"
                               onclick="doUpdate(${dep.departmentid})" style="display: none">确定</a>

                            <#--取消-->
                            <a id="cancel_${dep.departmentid}" class="clickbutton" href="#"
                               onclick="cancel(${dep.departmentid},'${dep.departmentname}')"
                               style="display: none">取消</a>

                            <#--删除-->
                            <a id="delete_${dep.departmentid}" class="clickbutton"
                               href="/dep?id=${dep.departmentid}">删除</a>
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
<script>
    function showEditView(id) {
        var el = $("#td_" + id);
        var oldDep = el.html();
        el.html("<input type='text' value='" + oldDep + "'/>")

        /*拿到四个按钮进行操作*/
        /*编辑按钮*/var editBtn = $("#edit_" + id);
        /*确定按钮*/var confirmBtn = $("#confirm_" + id);
        /*取消按钮*/var cancelBtn = $("#cancel_" + id);
        /*删除按钮*/var deleteBtn = $("#delete_" + id);
        /*
        * 编辑 删除按钮显示 其他两个隐藏
        * */
        editBtn.css("display", "none");
        deleteBtn.css("display", "none");
        confirmBtn.css("display", "inline");
        cancelBtn.css("display", "inline");

    }

    /*编辑修改方法*/
    function doUpdate(id) {
        var el = $("#td_" + id + " > input");
        $.post("/updateDep", {departmentid: id, departmentname: el.val()}, function (msg) {
            if (msg.status==200) {
                window.location.href = '/departments';
            }else{
                alert("修改失败!");
            }
        })
    }

    /*取消按钮的操作*/
    function cancel(id, name) {
        var el = $("#td_" + id);
        el.html(name);
        var editBtn = $("#edit_" + id);
        var confirmBtn = $("#confirm_" + id);
        var cancelBtn = $("#cancel_" + id);
        var deleteBtn = $("#delete_" + id);

        /*
        * 编辑 删除按钮隐藏 其他两个显示
        * */
        editBtn.css("display", "inline");
        deleteBtn.css("display", "inline");
        confirmBtn.css("display", "none");
        cancelBtn.css("display", "none");
    }
</script>
</body>
</html>