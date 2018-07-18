/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.met.entity.metrecord;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 会议记录信息Entity
 * @author 王子鹏
 * @version 2018-06-24
 */
public class MetRecord extends DataEntity<MetRecord> {

    private static final long serialVersionUID = 1L;
    private String title;        // 会议标题
    private String type;        // 会议类型()
    private String content;        // 会议内容
    private BigDecimal money;        // 费用（所有参与专家费用和）
    private Date voucherWritedate;        // 凭单填写日期
    private Date voucherCommitdate;        // 凭单提交日期
    private Date beginVoucherWritedate;        // 开始 凭单填写日期
    private Date endVoucherWritedate;        // 结束 凭单填写日期
    private Date beginVoucherCommitdate;        // 开始 凭单提交日期
    private Date endVoucherCommitdate;        // 结束 凭单提交日期
    private String mUserName;
    private String mUserId;

    public String getmUserId() {
        return mUserId;
    }

    public void setmUserId(String mUserId) {
        this.mUserId = mUserId;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public MetRecord() {
        super();
    }

    public MetRecord(String id) {
        super(id);
    }

    @NotNull
    @Length(min = 0, max = 255, message = "会议标题长度必须介于 0 和 255 之间")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Length(min = 0, max = 255, message = "会议类型()长度必须介于 0 和 255 之间")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @NotNull
    @Length(min = 0, max = 255, message = "会议内容长度必须介于 0 和 255 之间")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getVoucherWritedate() {
        return voucherWritedate;
    }

    public void setVoucherWritedate(Date voucherWritedate) {
        this.voucherWritedate = voucherWritedate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getVoucherCommitdate() {
        return voucherCommitdate;
    }

    public void setVoucherCommitdate(Date voucherCommitdate) {
        this.voucherCommitdate = voucherCommitdate;
    }

    public Date getBeginVoucherWritedate() {
        return beginVoucherWritedate;
    }

    public void setBeginVoucherWritedate(Date beginVoucherWritedate) {
        this.beginVoucherWritedate = beginVoucherWritedate;
    }

    public Date getEndVoucherWritedate() {
        return endVoucherWritedate;
    }

    public void setEndVoucherWritedate(Date endVoucherWritedate) {
        this.endVoucherWritedate = endVoucherWritedate;
    }

    public Date getBeginVoucherCommitdate() {
        return beginVoucherCommitdate;
    }

    public void setBeginVoucherCommitdate(Date beginVoucherCommitdate) {
        this.beginVoucherCommitdate = beginVoucherCommitdate;
    }

    public Date getEndVoucherCommitdate() {
        return endVoucherCommitdate;
    }

    public void setEndVoucherCommitdate(Date endVoucherCommitdate) {
        this.endVoucherCommitdate = endVoucherCommitdate;
    }

}