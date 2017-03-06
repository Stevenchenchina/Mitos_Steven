/**
 * Copyright 2015 - 2020 mitostar project.
 * 
 * Licensed under the Mitostar License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.mitostar.com/licenses/LICENSE-1.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mitos.radien.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mitos.radien.entity.base.BaseEntity;

/**
 * @author old cat
 */
@Entity
@Table(name = "tb_user")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User extends BaseEntity implements UserDetails {
	private static final long serialVersionUID = 659544820564330707L;

	/**
	 * @Column:
	 * @--name: ="columnName";
	 * @--boolean unique() default false;
	 * @--boolean nullable() default true;
	 * @--boolean insertable() default true;
	 * @--boolean updatable() default true;
	 * @--String columnDefinition() default "";
	 * @--String table() default "";
	 * @--int length() default 255;
	 * @--int precision() default 0; // decimal precision
	 * @--int scale() default 0; // decimal scale
	 */
	
	/**
	 * 帐户名称
	 */
	@Column(nullable = false, unique = true)
	private String username;
	@Override
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 帐户密码
	 */
	@JsonIgnore
	@Column(nullable = false)
	private String password;
	@Override
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * salt 加密
	 */
	@JsonIgnore
	@Column(nullable = false, length=32)
	protected String salt;
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * 帐户描述
	 */
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 电话号码
	 */
	@Column(nullable = false)
	private String phonenumber;
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	/**
	 * email
	 */
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 帐户可用 默认账户可用
	 */
	@Column(nullable = false)
	private Boolean enable = false;
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	/**
	 * 优先等级
	 */
	@Column(nullable = false)
	private int priority = 1;
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}

	/**
	 * 用户等级
	 */
	@Column(nullable = false)
	private int level = 1;
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	/**
	 * 用户角色
	 * Multiple roles are separated by ','
	 */
	@Column(nullable = false)
	private String role = "USER";
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	 * 创建日期
	 */
	private LocalDateTime datecreated;
	public LocalDateTime getDatecreated() {
		return datecreated;
	}
	public void setDatecreated(LocalDateTime datecreated) {
		this.datecreated = datecreated;
	}
	
	/**
	 * 最后登录时间
	 */
	private LocalDateTime lastlogin;
	public LocalDateTime getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(LocalDateTime lastlogin) {
		this.lastlogin = lastlogin;
	}
	
	/**
	 * 最后登出时间
	 */
	private LocalDateTime lastlogout;
	public LocalDateTime getLastlogout() {
		return lastlogout;
	}
	public void setLastlogout(LocalDateTime lastlogout) {
		this.lastlogout = lastlogout;
	}
	
	/**
	 * 微信OpenID
	 */
	@JsonIgnore
	private String wc_openid;
	public String getWc_openid() {
		return wc_openid;
	}
	public void setWc_openid(String wc_openid) {
		this.wc_openid = wc_openid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * @--cascade：级联,它可以有有五个值可选,分别是： @--CascadeType.PERSIST：级联新建
	 * @--CascadeType.REMOVE : 级联删除
	 * @--CascadeType.REFRESH：级联刷新
	 * @--CascadeType.MERGE ： 级联更新
	 * @--CascadeType.ALL ： 以上全部四项
	 * @JoinColumn:主表外键字段 cid：Person所映射的表中的一个字段
	 */	
	
	/**
	 * 用户和用户创建的任务一对多双向关联
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "founder", cascade = {CascadeType.REFRESH/* , CascadeType.REMOVE*/}, fetch = FetchType.EAGER, targetEntity = Mission.class)
	private Set<Mission> missions_found = new HashSet<>();
	public Set<Mission> getMissions_found() {
		return missions_found;
	}
	public void setMissions_found(Set<Mission> missions_found) {
		this.missions_found = missions_found;
	}

	/**
	 * 用户和用户创建的组织一对多双向关联
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "founder", cascade = {CascadeType.REFRESH/* , CascadeType.REMOVE*/}, fetch = FetchType.EAGER, targetEntity = Organization.class)
	private Set<Organization> organizations_found = new HashSet<>();
	public Set<Organization> getOrganizations_found() {
		return organizations_found;
	}
	public void setOrganizations_found(Set<Organization> organizations_found) {
		this.organizations_found = organizations_found;
	}
	
	/**
	 * 用户和用户加入的组织多对多双向关联
	 */
	@JsonIgnore
	@ManyToMany(mappedBy = "members", cascade = {CascadeType.REFRESH/* , CascadeType.REMOVE*/}, fetch = FetchType.EAGER, targetEntity = Organization.class)
	private Set<Organization> organizations_join = new HashSet<>();
	public Set<Organization> getOrganizations_join() {
		return organizations_join;
	}
	public void setOrganizations_join(Set<Organization> organizations_join) {
		this.organizations_join = organizations_join;
	}
	
	/**
	 * 用户和邀请用户的组织多对多双向关联
	 */
	@JsonIgnore
	@ManyToMany(mappedBy = "invitees", cascade = {CascadeType.REFRESH/* , CascadeType.REMOVE*/}, fetch = FetchType.EAGER, targetEntity = Organization.class)
	private Set<Organization> invitations_organization = new HashSet<>();
	public Set<Organization> getInvitations_organization() {
		return invitations_organization;
	}
	public void setInvitations_organization(Set<Organization> invitations_organization) {
		this.invitations_organization = invitations_organization;
	}

	/**
	 * 用户和用户创建的组一对多双向关联
	 */
	@JsonIgnore
	@OneToMany(mappedBy = "founder", cascade = {CascadeType.REFRESH/* , CascadeType.REMOVE*/}, fetch = FetchType.EAGER, targetEntity = Group.class)
	private Set<Group> groups_found = new HashSet<>();	
	public Set<Group> getGroups_found() {
		return groups_found;
	}
	public void setGroups_found(Set<Group> groups_found) {
		this.groups_found = groups_found;
	}

	/**
	 * 用户和用户加入的组多对多双向关联
	 */
	@JsonIgnore
	@ManyToMany(mappedBy = "members", cascade = {CascadeType.REFRESH/* , CascadeType.REMOVE*/}, fetch = FetchType.EAGER, targetEntity = Group.class)
	private Set<Group> groups_join = new HashSet<>();	
	public Set<Group> getGroups_join() {
		return groups_join;
	}
	public void setGroups_join(Set<Group> groups_join) {
		this.groups_join = groups_join;
	}
	/**
	 * 用户和邀请用户的组多对多双向关联
	 */
	@JsonIgnore
	@ManyToMany(mappedBy = "invitees", cascade = {CascadeType.REFRESH/* , CascadeType.REMOVE*/}, fetch = FetchType.EAGER, targetEntity = Group.class)
	private Set<Group> invitations_group = new HashSet<>();
	public Set<Group> getInvitations_group() {
		return invitations_group;
	}
	public void setInvitations_group(Set<Group> invitations_group) {
		this.invitations_group = invitations_group;
	}
	
	@JsonIgnore
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER, targetEntity = Gateway.class)
	@JoinColumn(name = "gatewayId", nullable = true)
		
	
	/////////////////////////////////////////////////////////////////////////
	// Use below join table will cause groupDao.findOne() return null....!!!!
	/////////////////////////////////////////////////////////////////////////
/*	@JoinTable( name = "tb_gateway_user", 
				joinColumns = {@JoinColumn(name = "userId", nullable = false)}, 
				inverseJoinColumns = {@JoinColumn(name = "gatewayId", nullable = false)})*/
	private Gateway gateway;
	public Gateway getGateway() {
		return gateway;
	}
	public void setGateway(Gateway gateway) {
		this.gateway = gateway;
	}
	
	@Transient
	public long getGwId() {
		if (gateway != null)
			return gateway.getId();
		else 
			return 0;
	}
	@Transient
	public String getGwName() {
		if (gateway != null)
			return gateway.getAlias();
		else
			return "";
	}
	
	/**
	 * 最新位置信息
	 */
    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER, targetEntity = Location.class)  
    @JoinColumn(name="latestLocationId", nullable = true)  
    private Location latestLocation;	
	public Location getLatestLocation() {
		return latestLocation;
	}
	public void setLatestLocation(Location latestLocation) {
		this.latestLocation = latestLocation;
	}
	
	/**
	 * 最新rssi信息
	 */
    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER, targetEntity = Rssi.class)  
    @JoinColumn(name="latestRssiId", nullable = true)  
    private Rssi latestRssi;	
	public Rssi getLatestRssi() {
		return latestRssi;
	}
	public void setLatestRssi(Rssi latestRssi) {
		this.latestRssi = latestRssi;
	}
	
    @OneToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE}, fetch = FetchType.EAGER, targetEntity = Image.class)  
    @JoinColumn(name="imageId", nullable = true)  
    private Image portrait;	
	public Image getPortrait() {
		return portrait;
	}
	public void setPortrait(Image portrait) {
		this.portrait = portrait;
	}
	
	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String[] roleNames = role.split(",");
		LinkedList<GrantedAuthority> authorities = new LinkedList<>();
		for(String roleName : roleNames) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + roleName.trim().toUpperCase()));
		}
        return authorities; 
	}
	
	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return getEnable();
	}
	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return getEnable();
	}
	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return getEnable();
	}
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return getEnable();
	}
	@Override
	public String toString() {
		if (gateway == null)
			return "User [username=" + username + ", description=" + description + ", phonenumber=" + phonenumber
					+ ", email=" + email + ", enable=" + enable + ", priority=" + priority + ", level=" + level + ", role="
					+ role + ", datecreated=" + datecreated + ", getId()=" + getId() + ", getAlias()=" + getAlias() + "]";
		else{
			return gateway.toString();
		}
	}	
}
