<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
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
		<li class="active"><a href="${ctx}/star/starUser/">用户列表</a></li>
		<shiro:hasPermission name="star:starUser:edit"><li><a href="${ctx}/star/starUser/form">用户添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="starUser" action="${ctx}/star/starUser/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>守护星：</label>
					<%--<form:input path="starId" htmlEscape="false" maxlength="64" class="input-medium"/>--%>
				<sys:treeselect id="starMessage" name="starId" value="${starUser.starId}" labelName="starName" labelValue="${fnz:getStarName(starUser.starId)}"
								title="用户" url="/star/starStarmessage/treeData" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>昵称：</label>
				<form:input path="loginName" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>性别：</label>
				<form:select path="sex" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>邮箱：</label>
				<form:input path="email" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>
			<li><label>电话：</label>
				<form:input path="phone" htmlEscape="false" maxlength="200" class="input-medium"/>
			</li>

			<li><label>是否可登录：</label>
				<form:radiobuttons path="loginFlag" items="${fns:getDictList('yes_no')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>昵称</th>
				<th>姓名</th>
				<th>邮箱</th>
				<th>电话</th>
				<th>守护星</th>
				<th>最后登陆时间</th>
				<th>最后登录ip</th>
				<th>更新时间</th>
				<shiro:hasPermission name="star:starUser:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="starUser">
			<tr>
				<td><a href="${ctx}/star/starUser/form?id=${starUser.id}">
					${starUser.loginName}
				</a></td>
				<td>
					${starUser.name}
				</td>
				<td>
					${starUser.email}
				</td>
				<td>
					${starUser.phone}
				</td>
				<td>
					${fnz:getStarName(starUser.starId)}
				</td>
				<td>
					<fmt:formatDate value="${starUser.loginDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
						${starUser.loginIp}
				</td>
				<td>
					<fmt:formatDate value="${starUser.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="star:starUser:edit"><td>
    				<a href="${ctx}/star/starUser/form?id=${starUser.id}">修改</a>
					<a href="${ctx}/star/starUser/delete?id=${starUser.id}" onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>