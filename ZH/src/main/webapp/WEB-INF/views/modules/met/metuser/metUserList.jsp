<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会议参会人员管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/met/metuser/metUser/">会议参会人员列表</a></li>
		<li><a href="${ctx}/met/metuser/metUser/form">会议参会人员添加</a>
	</ul>
	<form:form id="searchForm" modelAttribute="metUser" action="${ctx}/met/metuser/metUser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>客户姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>客户姓名</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="met:metuser:metUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="metUser">
			<tr>
				<td><a href="${ctx}/met/metuser/metUser/form?id=${metUser.id}">
					${metUser.name}
				</a></td>
				<td>
					<fmt:formatDate value="${metUser.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${metUser.remarks}
				</td>
				<shiro:hasPermission name="met:metuser:metUser:edit"><td>
    				<a href="${ctx}/met/metuser/metUser/form?id=${metUser.id}">修改</a>
					<a href="${ctx}/met/metuser/metUser/delete?id=${metUser.id}" onclick="return confirmx('确认要删除该会议参会人员吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>