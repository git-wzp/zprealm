<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>图片管理</title>
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
		<li class="active"><a href="${ctx}/zh/photo/zhPhoto/">图片列表</a></li>
		<shiro:hasPermission name="zh:photo:zhPhoto:edit"><li><a href="${ctx}/zh/photo/zhPhoto/form">图片添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="zhPhoto" action="${ctx}/zh/photo/zhPhoto/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>关键字：</label>
				<form:input path="keywords" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>标题</th>
				<th>点击数</th>
				<th>权重</th>
				<th>关键字</th>
				<th>创建者</th>
				<th>更新时间</th>
				<shiro:hasPermission name="zh:photo:zhPhoto:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="zhPhoto">
			<tr>
				<td><a href="${ctx}/zh/photo/zhPhoto/form?id=${zhPhoto.id}">
					${zhPhoto.title}
				</a></td>
				<td>
					${zhPhoto.hits}
				</td>
				<td>
					${zhPhoto.weight}
				</td>
				<td>
					${zhPhoto.keywords}
				</td>
				<td>
					${zhPhoto.createBy.id}
				</td>
				<td>
					<fmt:formatDate value="${zhPhoto.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				 
				<shiro:hasPermission name="zh:photo:zhPhoto:edit"><td>
    				<a href="${ctx}/zh/photo/zhPhoto/form?id=${zhPhoto.id}">修改</a>
					<a href="${ctx}/zh/photo/zhPhoto/delete?id=${zhPhoto.id}" onclick="return confirmx('确认要删除该图片吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>