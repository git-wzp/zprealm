<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>star资料管理</title>
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
		<li class="active"><a href="${ctx}/star/starStarmessage/">star资料列表</a></li>
		<shiro:hasPermission name="star:starStarmessage:edit"><li><a href="${ctx}/star/starStarmessage/form">star资料添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="starStarmessage" action="${ctx}/star/starStarmessage/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>姓名</th>
				<th>民族</th>
				<th>性别</th>
				<th>毕业院校</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="star:starStarmessage:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="starStarmessage">
			<tr>
				<td><a href="${ctx}/star/starStarmessage/form?id=${starStarmessage.id}">
					${starStarmessage.name}
				</a></td>
				<td>
					 ${fns:getDictLabel(starStarmessage.nation, 'sys_nation', '')}
				</td>
				<td>
					${fns:getDictLabel(starStarmessage.sex, 'sex', '')}
				</td>
				<td>
					${starStarmessage.school}
				</td>
				<td>
					<fmt:formatDate value="${starStarmessage.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${starStarmessage.remarks}
				</td>
				<shiro:hasPermission name="star:starStarmessage:edit"><td>
    				<a href="${ctx}/star/starStarmessage/form?id=${starStarmessage.id}">修改</a>
					<a href="${ctx}/star/starStarmessage/delete?id=${starStarmessage.id}" onclick="return confirmx('确认要删除该star资料吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>