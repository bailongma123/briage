/**
 * 
 */
package com.ande.bridge.admin.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**   
 * <pre>  
 * <b> 用户表.</b>
 * <b>Author: name@la-inc.cn</b> 
 * <b>date: 2018年5月29日 上午10:49:06   </b> 
 * 
 *   ----------------------------------------------------------------------------
 *   ----------------------------------------------------------------------------
 * <pre>
 */
public class PersonEntity {
	
	private Integer personId;
	private Integer organizationId;
	private Integer roleId;
	private String personCode;
	private String personType;	
	private String personName;
	private String personGender;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date personBirthday;
	private String personAge;
	private String personPhone;
	private String personEmail;
	private String personAddress;
	private String personDuty;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date personCreateDate;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date personUpdateDate;
	private String personDetail;
	private String personLoginName;
	private String personPassword;
	private String personToken;
	/**
	 * @return the personId
	 */
	public Integer getPersonId() {
		return personId;
	}
	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	/**
	 * @return the organizationId
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}
	/**
	 * @param organizationId the organizationId to set
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}
	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	/**
	 * @return the personCode
	 */
	public String getPersonCode() {
		return personCode;
	}
	/**
	 * @param personCode the personCode to set
	 */
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
	/**
	 * @return the personType
	 */
	public String getPersonType() {
		return personType;
	}
	/**
	 * @param personType the personType to set
	 */
	public void setPersonType(String personType) {
		this.personType = personType;
	}
	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	/**
	 * @return the personGender
	 */
	public String getPersonGender() {
		return personGender;
	}
	/**
	 * @param personGender the personGender to set
	 */
	public void setPersonGender(String personGender) {
		this.personGender = personGender;
	}
	/**
	 * @return the personBirthday
	 */
	public Date getPersonBirthday() {
		return personBirthday;
	}
	/**
	 * @param personBirthday the personBirthday to set
	 */
	public void setPersonBirthday(Date personBirthday) {
		this.personBirthday = personBirthday;
	}
	/**
	 * @return the personAge
	 */
	public String getPersonAge() {
		return personAge;
	}
	/**
	 * @param personAge the personAge to set
	 */
	public void setPersonAge(String personAge) {
		this.personAge = personAge;
	}
	/**
	 * @return the personPhone
	 */
	public String getPersonPhone() {
		return personPhone;
	}
	/**
	 * @param personPhone the personPhone to set
	 */
	public void setPersonPhone(String personPhone) {
		this.personPhone = personPhone;
	}
	/**
	 * @return the personEmail
	 */
	public String getPersonEmail() {
		return personEmail;
	}
	/**
	 * @param personEmail the personEmail to set
	 */
	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}
	/**
	 * @return the personAddress
	 */
	public String getPersonAddress() {
		return personAddress;
	}
	/**
	 * @param personAddress the personAddress to set
	 */
	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}
	/**
	 * @return the personDuty
	 */
	public String getPersonDuty() {
		return personDuty;
	}
	/**
	 * @param personDuty the personDuty to set
	 */
	public void setPersonDuty(String personDuty) {
		this.personDuty = personDuty;
	}
	/**
	 * @return the personCreateDate
	 */
	public Date getPersonCreateDate() {
		return personCreateDate;
	}
	/**
	 * @param personCreateDate the personCreateDate to set
	 */
	public void setPersonCreateDate(Date personCreateDate) {
		this.personCreateDate = personCreateDate;
	}
	/**
	 * @return the personUpdateDate
	 */
	public Date getPersonUpdateDate() {
		return personUpdateDate;
	}
	/**
	 * @param personUpdateDate the personUpdateDate to set
	 */
	public void setPersonUpdateDate(Date personUpdateDate) {
		this.personUpdateDate = personUpdateDate;
	}
	/**
	 * @return the personDetail
	 */
	public String getPersonDetail() {
		return personDetail;
	}
	/**
	 * @param personDetail the personDetail to set
	 */
	public void setPersonDetail(String personDetail) {
		this.personDetail = personDetail;
	}
	/**
	 * @return the personLoginName
	 */
	public String getPersonLoginName() {
		return personLoginName;
	}
	/**
	 * @param personLoginName the personLoginName to set
	 */
	public void setPersonLoginName(String personLoginName) {
		this.personLoginName = personLoginName;
	}
	/**
	 * @return the personPassword
	 */
	public String getPersonPassword() {
		return personPassword;
	}
	/**
	 * @param personPassword the personPassword to set
	 */
	public void setPersonPassword(String personPassword) {
		this.personPassword = personPassword;
	}
	/**
	 * @return the personToken
	 */
	public String getPersonToken() {
		return personToken;
	}
	/**
	 * @param personToken the personToken to set
	 */
	public void setPersonToken(String personToken) {
		this.personToken = personToken;
	}
	
	
	
}
