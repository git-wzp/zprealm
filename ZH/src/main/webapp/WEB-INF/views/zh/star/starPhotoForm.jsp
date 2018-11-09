<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>star照片管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/star/starPhoto/">star照片列表</a></li>
		<li class="active"><a href="${ctx}/star/starPhoto/form?id=${starPhoto.id}">star照片<shiro:hasPermission name="star:starPhoto:edit">${not empty starPhoto.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="star:starPhoto:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="starPhoto" action="${ctx}/star/starPhoto/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">明星id：</label>
			<div class="controls">
				<sys:treeselect id="starMessage" name="starId" value="${starPhoto.starId}" labelName="starPhoto.starId" labelValue="${fnz:getStarName(starPhoto.starId)}"
								title="用户" url="/star/starStarmessage/treeData" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-labelfavicon.ico">路径：</label>
			<div class="controls">
				<form:hidden id="url" path="url" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="url" type="images" uploadPath="/star/starPhoto" selectMultiple="false"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图片类型：</label>
			<div class="controls">
				<form:select path="type" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('star_photo_type')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">标题：</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="star:starPhoto:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>