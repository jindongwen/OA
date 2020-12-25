package com.ylb.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 报销单
 * @author Administrator
 *
 */
public class Expense {

	private  int expId;//报销单编号  序列自增
	private String empId;//报销人编号  添加时使用
	private double totalAmount;//报销单总金额
	private Date expTime;//报销时间  yyyMMdd
	private String expDesc;//报销单总备注信息
	private String nextAuditor;//下一个审核人的编号
	private String lastResult;//最新的审核结果  数据中该列虽然有冗余，可以提高效率
	private String  status;//报销单的状态     0：新创建  1：审核中   2 审核结束通过  3 审核拒绝  4 审核打回   5.已打款 


	public Expense() {
		super();
	}

	public Expense(int expId, String empId, double totalAmount, Date expTime, String expDesc, String nextAuditor, String lastResult, String status) {
		this.expId = expId;
		this.empId = empId;
		this.totalAmount = totalAmount;
		this.expTime = expTime;
		this.expDesc = expDesc;
		this.nextAuditor = nextAuditor;
		this.lastResult = lastResult;
		this.status = status;
	}

	public int getExpId() {
		return expId;
	}

	public void setExpId(int expId) {
		this.expId = expId;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getExpTime() {
		return expTime;
	}

	public void setExpTime(Date expTime) {
		this.expTime = expTime;
	}

	public String getExpDesc() {
		return expDesc;
	}

	public void setExpDesc(String expDesc) {
		this.expDesc = expDesc;
	}

	public String getNextAuditor() {
		return nextAuditor;
	}

	public void setNextAuditor(String nextAuditor) {
		this.nextAuditor = nextAuditor;
	}

	public String getLastResult() {
		return lastResult;
	}

	public void setLastResult(String lastResult) {
		this.lastResult = lastResult;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Expense{" +
				"expId=" + expId +
				", empId='" + empId + '\'' +
				", totalAmount=" + totalAmount +
				", expTime=" + expTime +
				", expDesc='" + expDesc + '\'' +
				", nextAuditor='" + nextAuditor + '\'' +
				", lastResult='" + lastResult + '\'' +
				", status='" + status + '\'' +
				'}';
	}
}
