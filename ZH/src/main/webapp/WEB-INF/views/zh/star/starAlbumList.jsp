<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>相册管理</title>
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
		<li class="active"><a href="${ctx}/star/starAlbum/">相册列表</a></li>
		<shiro:hasPermission name="star:starAlbum:edit"><li><a href="${ctx}/star/starAlbum/form">相册添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="starAlbum" action="${ctx}/star/starAlbum/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>所属用户：</label>
				<sys:treeselect id="user" name="user.id" value="${starAlbum.user.id}" labelName="user.name" labelValue="${starAlbum.user.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>相册名称：</label>
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
				<th>相册名称</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="star:starAlbum:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="starAlbum">
			<tr>
				<td><a href="${ctx}/star/starAlbum/form?id=${starAlbum.id}">
					${starAlbum.name}
				</a></td>
				<td>
					<fmt:formatDate value="${starAlbum.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${starAlbum.remarks}
				</td>
				<shiro:hasPermission name="star:starAlbum:edit"><td>
    				<a href="${ctx}/star/starAlbum/form?id=${starAlbum.id}">修改</a>
					<a href="${ctx}/star/starAlbum/delete?id=${starAlbum.id}" onclick="return confirmx('确认要删除该相册吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>