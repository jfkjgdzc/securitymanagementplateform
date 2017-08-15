package com.hotent.qingjiadan.model.jfkjoa;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import com.hotent.core.model.BaseModel;
/**
 * 对象功能:科技请假单 Model对象
 */
public class Kjqjd extends BaseModel
{
	//主键
	protected Long id;
	/**
	 *公司名称
	 */
	protected String  gsmc;
	/**
	 *申请日期
	 */
	protected java.util.Date  sqrq;
	/**
	 *请假人姓名
	 */
	protected String  qjrxm;
	/**
	 *请假人姓名ID
	 */
	protected String  qjrxmID;
	/**
	 *所在部门
	 */
	protected String  szbm;
	/**
	 *所在部门ID
	 */
	protected String  szbmID;
	/**
	 *假别
	 */
	protected String  jb;
	/**
	 *请假天数
	 */
	protected Long  qjts;
	/**
	 *日期（起）
	 */
	protected java.util.Date  rqq;
	/**
	 *日期（止）
	 */
	protected java.util.Date  rqz;
	/**
	 *部门主管经理意见
	 */
	protected String  bmzgjlyj;
	/**
	 *公司经理审批
	 */
	protected String  gsjlsp;
	/**
	 *部门部长意见
	 */
	protected String  bm;
	/**
	 *附件
	 */
	protected String  fj;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setGsmc(String gsmc) 
	{
		this.gsmc = gsmc;
	}
	/**
	 * 返回 公司名称
	 * @return
	 */
	public String getGsmc() 
	{
		return this.gsmc;
	}
	public void setSqrq(java.util.Date sqrq) 
	{
		this.sqrq = sqrq;
	}
	/**
	 * 返回 申请日期
	 * @return
	 */
	public java.util.Date getSqrq() 
	{
		return this.sqrq;
	}
	public void setQjrxm(String qjrxm) 
	{
		this.qjrxm = qjrxm;
	}
	/**
	 * 返回 请假人姓名
	 * @return
	 */
	public String getQjrxm() 
	{
		return this.qjrxm;
	}
	public void setQjrxmID(String qjrxmID) 
	{
		this.qjrxmID = qjrxmID;
	}
	/**
	 * 返回 请假人姓名ID
	 * @return
	 */
	public String getQjrxmID() 
	{
		return this.qjrxmID;
	}
	public void setSzbm(String szbm) 
	{
		this.szbm = szbm;
	}
	/**
	 * 返回 所在部门
	 * @return
	 */
	public String getSzbm() 
	{
		return this.szbm;
	}
	public void setSzbmID(String szbmID) 
	{
		this.szbmID = szbmID;
	}
	/**
	 * 返回 所在部门ID
	 * @return
	 */
	public String getSzbmID() 
	{
		return this.szbmID;
	}
	public void setJb(String jb) 
	{
		this.jb = jb;
	}
	/**
	 * 返回 假别
	 * @return
	 */
	public String getJb() 
	{
		return this.jb;
	}
	public void setQjts(Long qjts) 
	{
		this.qjts = qjts;
	}
	/**
	 * 返回 请假天数
	 * @return
	 */
	public Long getQjts() 
	{
		return this.qjts;
	}
	public void setRqq(java.util.Date rqq) 
	{
		this.rqq = rqq;
	}
	/**
	 * 返回 日期（起）
	 * @return
	 */
	public java.util.Date getRqq() 
	{
		return this.rqq;
	}
	public void setRqz(java.util.Date rqz) 
	{
		this.rqz = rqz;
	}
	/**
	 * 返回 日期（止）
	 * @return
	 */
	public java.util.Date getRqz() 
	{
		return this.rqz;
	}
	public void setBmzgjlyj(String bmzgjlyj) 
	{
		this.bmzgjlyj = bmzgjlyj;
	}
	/**
	 * 返回 部门主管经理意见
	 * @return
	 */
	public String getBmzgjlyj() 
	{
		return this.bmzgjlyj;
	}
	public void setGsjlsp(String gsjlsp) 
	{
		this.gsjlsp = gsjlsp;
	}
	/**
	 * 返回 公司经理审批
	 * @return
	 */
	public String getGsjlsp() 
	{
		return this.gsjlsp;
	}
	public void setBm(String bm) 
	{
		this.bm = bm;
	}
	/**
	 * 返回 部门部长意见
	 * @return
	 */
	public String getBm() 
	{
		return this.bm;
	}
	public void setFj(String fj) 
	{
		this.fj = fj;
	}
	/**
	 * 返回 附件
	 * @return
	 */
	public String getFj() 
	{
		return this.fj;
	}
   	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) 
	{
		if (!(object instanceof Kjqjd)) 
		{
			return false;
		}
		Kjqjd rhs = (Kjqjd) object;
		return new EqualsBuilder()
		.append(this.id, rhs.id)
		.append(this.gsmc, rhs.gsmc)
		.append(this.sqrq, rhs.sqrq)
		.append(this.qjrxm, rhs.qjrxm)
		.append(this.qjrxmID, rhs.qjrxmID)
		.append(this.szbm, rhs.szbm)
		.append(this.szbmID, rhs.szbmID)
		.append(this.jb, rhs.jb)
		.append(this.qjts, rhs.qjts)
		.append(this.rqq, rhs.rqq)
		.append(this.rqz, rhs.rqz)
		.append(this.bmzgjlyj, rhs.bmzgjlyj)
		.append(this.gsjlsp, rhs.gsjlsp)
		.append(this.bm, rhs.bm)
		.append(this.fj, rhs.fj)
		.isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() 
	{
		return new HashCodeBuilder(-82280557, -700257973)
		.append(this.id)
		.append(this.gsmc) 
		.append(this.sqrq) 
		.append(this.qjrxm) 
		.append(this.qjrxmID) 
		.append(this.szbm) 
		.append(this.szbmID) 
		.append(this.jb) 
		.append(this.qjts) 
		.append(this.rqq) 
		.append(this.rqz) 
		.append(this.bmzgjlyj) 
		.append(this.gsjlsp) 
		.append(this.bm) 
		.append(this.fj) 
		.toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() 
	{
		return new ToStringBuilder(this)
		.append("id",this.id)
		.append("gsmc", this.gsmc) 
		.append("sqrq", this.sqrq) 
		.append("qjrxm", this.qjrxm) 
		.append("qjrxmID", this.qjrxmID) 
		.append("szbm", this.szbm) 
		.append("szbmID", this.szbmID) 
		.append("jb", this.jb) 
		.append("qjts", this.qjts) 
		.append("rqq", this.rqq) 
		.append("rqz", this.rqz) 
		.append("bmzgjlyj", this.bmzgjlyj) 
		.append("gsjlsp", this.gsjlsp) 
		.append("bm", this.bm) 
		.append("fj", this.fj) 
		.toString();
	}

}