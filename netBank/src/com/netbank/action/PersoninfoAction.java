package com.netbank.action;

import java.util.Map;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.netbank.biz.PersoninfoBiz;
import com.netbank.entity.Personinfo;
import com.opensymphony.xwork2.ActionSupport;

public class PersoninfoAction extends ActionSupport implements RequestAware,SessionAware{
	@Resource private PersoninfoBiz personinfoBiz;
	Map<String, Object> request;
	Map<String, Object> session;
	private Personinfo personinfo;
	
	public Personinfo getPersoninfo() {
		return personinfo;
	}
	public void setPersoninfo(Personinfo personinfo) {
		this.personinfo = personinfo;
	}
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public void validateModify(){
		if ("".equals(personinfo.getTelephone().trim())) {
			personinfo.setTelephone("电话不详");
		}
		if (!(personinfo.getAge()>18&&personinfo.getAge()<100)) {
			addFieldError("personinfo.age", "年龄不符");
		}
		if (!Pattern.compile("^\\d{17}(\\d|x)$").matcher(personinfo.getCardid().toString()).matches()) {
			addFieldError("personinfo.cardId", "身份证格式不正确");
		}
		if (!"电话不详".equals(personinfo.getTelephone().trim())&&!Pattern.compile("^(?:1[358]\\d{9}|\\d{3,4}-\\d{8,9})$").matcher(personinfo.getTelephone()).matches()) {
			addFieldError("personinfo.telephone", "电话格式不正确");
		}
	}
	public String modify(){
		Personinfo per= (Personinfo) session.get("personinfo");
		per.setAddress(personinfo.getAddress());
		per.setAge(personinfo.getAge());
		per.setCardid(personinfo.getCardid());
		per.setRealname(personinfo.getRealname());
		per.setSex(personinfo.getSex());
		per.setTelephone(personinfo.getTelephone());
		//modifyPersoninfo是一个boolean方法
		if (personinfoBiz.modifyPersoninfo(per)) {
			session.put("personinfo", per);
			request.put("message", "修改成功");
			return "message";
		}
		request.put("message", "修改失败！");
		return "message";
	}
}
