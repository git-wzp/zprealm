<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ include file="/WEB-INF/views/include/head.jsp"%>
<html>
<head>
	<title>会议记录信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
		    $("#aaa").multipleSelect();
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
        // function userChange() {
        //     var ids = $("#mUserId").val();
        //     $("#mUserId")
        //     alert(ids);
        // }
	</script>
    <style>
        .select2-container, .select2-drop, .select2-search, .select2-search input{
            width: 100px;
        }


    </style>
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
			<label class="control-label">会议标题：<span style="color: red">*</span> </label>
			<div class="controls">
				<form:input path="title" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">会议类型：<span style="color: red">*</span></label>
			<div class="controls">
				<form:select path="type" cssStyle="width:120px">
					<form:options items="${fns:getDictList('metType')}" itemLabel="label" itemValue="value" htmlEscape="false" />
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">会议内容：<span style="color: red">*</span></label>
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
			<label class="control-label">凭单填写日期：<span style="color: red">*</span></label>
			<div class="controls">
				<input name="voucherWritedate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${metRecord.voucherWritedate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">凭单提交日期：<span style="color: red">*</span></label>
			<div class="controls">
				<input name="voucherCommitdate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${metRecord.voucherCommitdate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
                <label class="control-label">当前参会人员：</label>
            <div class="controls">
            <input disabled="disabled" value="${mUserNames}">
            </div>
			<label class="control-label">修改参与专家：</label>
				<div class="controls">
                    <form:select path="mUserId" multiple="multiple" onchange="userChange()">
                        <form:options items="${mUserList}" itemLabel="name" itemValue="id" htmlEscape="false" />
                    </form:select>
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