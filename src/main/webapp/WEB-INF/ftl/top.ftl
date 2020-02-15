<div class="page-header">
    <div class="header-banner">
        <img src="/images/header.png" alt="CoolMeeting"/>
    </div>
    <div class="header-title">
        欢迎访问Cool-Meeting会议管理系统
    </div>

    <#-- <#if e??>: 如果e存在
        ？？：用于判断某个数据是否存在
    -->
    <#if e??>
        <div class="header-quicklink">
            欢迎您，<strong>${e.employeename}</strong>
            <a href="changepassword.html">[修改密码]</a>
        </div>
    </#if>
</div>