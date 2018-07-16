<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>

	<title>会议记录信息管理</title>
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
		<li><a href="${ctx}/met/metrecord/metRecord/">会议记录信息列表</a></li>
		<li class="active"><a href="${ctx}/met/metrecord/metRecord/form?id=${metRecord.id}">会议记录信息<shiro:hasPermission name="met:metrecord:metRecord:edit">${not empty metRecord.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="met:metrecord:metRecord:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="metRecord" action="${ctx}/met/metrecord/metRecord/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">会议标题：</label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">会议类型：</label>
			<div class="controls">
				<form:select path="type">
					<%--<form:input path="type" htmlEscape="false" maxlength="255" class="input-medium"/>--%>
					<form:options items="${fns:getDictList('metType')}" itemLabel="label" itemValue="value" htmlEscape="false" />
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">会议内容：</label>
			<div class="controls">
				<form:textarea path="content"  rows="10" maxlength="255" class="input-xxlarge " />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">费用：</label>
			<div class="controls">
				<form:input path="money" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">凭单填写日期：</label>
			<div class="controls">
				<input name="voucherWritedate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${metRecord.voucherWritedate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">凭单提交日期：</label>
			<div class="controls">
				<input name="voucherCommitdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${metRecord.voucherCommitdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">参与专家：</label>
			<div class="controls">
				<form:select path="mUserId">
					<%--<form:input path="type" htmlEscape="false" maxlength="255" class="input-medium"/>--%>
					<form:options items="${mUserList}" itemLabel="name" itemValue="id" htmlEscape="false" />
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">参与专家2：</label>
				<div class="col-sm-4">
					<select id="mUserId" class="selectpicker show-tick form-control" multiple data-live-search="false">
							<%--<form:input path="type" htmlEscape="false" maxlength="255" class="input-medium"/>--%>
							<%--<form:options items="${mUserList}" itemLabel="name" itemValue="id" htmlEscape="false" />--%>
						<option value="1">11</option>
					</select>
				</div>


		</div>
		<div class="form-group">
			<label class="col-sm-3 control-label">客资类型：</label>
			<div class="col-sm-4">
				<select id="usertype" name="usertype" class="selectpicker show-tick form-control" multiple data-live-search="false">
					<option value="0">苹果</option>
					<option value="1">菠萝</option>
					<option value="2">香蕉</option>
					<option value="3">火龙果</option>
					<option value="4">梨子</option>
					<option value="5">草莓</option>
					<option value="6">哈密瓜</option>
					<option value="7">椰子</option>
					<option value="8">猕猴桃</option>
					<option value="9">桃子</option>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>