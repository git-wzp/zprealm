<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>star音频管理</title>
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
		<li class="active"><a href="${ctx}/star/starSong/">star音频列表</a></li>
		<shiro:hasPermission name="star:starSong:edit"><li><a href="${ctx}/star/starSong/form">star音频添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="starSong" action="${ctx}/star/starSong/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>歌曲名：</label>
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
				<th>歌曲名</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="star:starSong:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="starSong">
			<tr>
				<td><a href="${ctx}/star/starSong/form?id=${starSong.id}">
					${starSong.name}
				</a></td>
				<td>
					<fmt:formatDate value="${starSong.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${starSong.remarks}
				</td>
				<shiro:hasPermission name="star:starSong:edit"><td>
    				<a href="${ctx}/star/starSong/form?id=${starSong.id}">修改</a>
					<a href="${ctx}/star/starSong/delete?id=${starSong.id}" onclick="return confirmx('确认要删除该star音频吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>