<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>star照片管理</title>
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
		<li class="active"><a href="${ctx}/star/starPhoto/">star照片列表</a></li>
		<shiro:hasPermission name="star:starPhoto:edit"><li><a href="${ctx}/star/starPhoto/form">star照片添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="starPhoto" action="${ctx}/star/starPhoto/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>明星id：</label>
				<form:input path="starId" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>图片类型：</label>
				<form:select path="type" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('star_photo_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>标题：</label>
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-medium"/>
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
				<th>相关明星</th>
				<th>图片类型</th>
				<th>更新时间</th>
				<th>缩略图</th>
				<th>备注信息</th>
				<shiro:hasPermission name="star:starPhoto:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="starPhoto">
			<tr>
				<td>
					${starPhoto.title}
				</td>
				<td>
					<%--${starPhoto.starId}--%>
					${fnz:getStarName(starPhoto.starId)}
				</td>
				<td>
					${fns:getDictLabel(starPhoto.type, 'star_photo_type', '')}
				 </td>
				<td>
					<fmt:formatDate value="${starPhoto.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<img   src="${uploadfile}${starPhoto.url}" style="width: 110px;height: 80px" >
				</td>
				<td>
					${starPhoto.remarks}
				</td>
				<shiro:hasPermission name="star:starPhoto:edit"><td>
    				<a href="${ctx}/star/starPhoto/form?id=${starPhoto.id}">修改</a>
					<a href="${ctx}/star/starPhoto/delete?id=${starPhoto.id}" onclick="return confirmx('确认要删除该star照片吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>