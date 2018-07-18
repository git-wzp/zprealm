<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp" %>
<html>
<head>
    <title>会议记录信息管理</title>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        $(document).ready(function () {

        });

        function page(n, s) {
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="${ctx}/met/metrecord/metRecord/">会议记录信息列表</a></li>
    <li><a href="${ctx}/met/metrecord/metRecord/form">会议记录信息添加</a></li>
</ul>
<form:form id="searchForm" modelAttribute="metRecord" action="${ctx}/met/metrecord/metRecord/" method="post"
           class="breadcrumb form-search">
    <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
    <input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
    <ul class="ul-form">
        <li><label>会议标题：</label>
            <form:input path="title" htmlEscape="false" maxlength="255" class="input-medium"/>
        </li>
        <li><label>会议类型()：</label>
            <form:select path="type">
                <form:option value="">全部类型</form:option>
                <form:options items="${fns:getDictList('metType')}" itemLabel="label" itemValue="value" htmlEscape="false" />
            </form:select>
        </li>
        <li><label>会议内容：</label>
            <form:input path="content" htmlEscape="false" maxlength="255" class="input-medium"/>
        </li>
        <li><label>参会人员：</label>
            <form:select path="mUserId" cssStyle="width: 80px">
                <form:option value="">--全部--</form:option>
                <form:options  items="${userList}" itemLabel="name" itemValue="id" htmlEscape="false"></form:options>
            </form:select>
        </li>
    </ul>
    <ul class="ul-form">

        <li><label style="width: 100px;">凭单填写日期：</label>
            <input name="beginVoucherWritedate" type="text" readonly="readonly" maxlength="20"
                   class="input-medium Wdate"
                   value="<fmt:formatDate value="${metRecord.beginVoucherWritedate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> -
            <input name="endVoucherWritedate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
                   value="<fmt:formatDate value="${metRecord.endVoucherWritedate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
        </li>
        <li><label style="width: 100px;">凭单提交日期：</label>
            <input name="beginVoucherCommitdate" type="text" readonly="readonly" maxlength="20"
                   class="input-medium Wdate"
                   value="<fmt:formatDate value="${metRecord.beginVoucherCommitdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> -
            <input name="endVoucherCommitdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
                   value="<fmt:formatDate value="${metRecord.endVoucherCommitdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
                   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
        </li>
        <li class="btns" style="float: right;"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
        </li>
        <li class="clearfix"></li>
    </ul>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
    <thead>
    <tr>
        <th>会议标题</th>
        <th>会议类型</th>
        <th>参会人员</th>
        <th>会议内容</th>
        <th>凭单填写日期</th>
        <th>凭单提交日期</th>
        <th>更新时间</th>
        <th>备注信息</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="metRecord">
        <tr>
            <td><a href="${ctx}/met/metrecord/metRecord/form?id=${metRecord.id}">
                    ${metRecord.title}
            </a></td>
            <td>
                    ${metRecord.type}
            </td>
            <td>${metRecord.mUserName}</td>
            <td>
                    ${metRecord.content}
            </td>
            <td>
                <fmt:formatDate value="${metRecord.voucherWritedate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                <fmt:formatDate value="${metRecord.voucherCommitdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                <fmt:formatDate value="${metRecord.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
                    ${metRecord.remarks}
            </td>
            <td>
                <a href="${ctx}/met/metrecord/metRecord/form?id=${metRecord.id}">修改</a>
                <a href="${ctx}/met/metrecord/metRecord/delete?id=${metRecord.id}"
                   onclick="return confirmx('确认要删除该会议记录信息吗？', this.href)">删除</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>