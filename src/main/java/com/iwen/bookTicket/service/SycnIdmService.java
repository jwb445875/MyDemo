package com.iwen.bookTicket.service;


import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;


import com.iwen.util.LdapHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class SycnIdmService{

	Logger logger = LoggerFactory.getLogger(SycnIdmService.class);

	public NamingEnumeration<SearchResult> search(String basedn, String s,String[] attrs) {
		NamingEnumeration<SearchResult> en = null;
		SearchControls constraints = new SearchControls();
		try {
			constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
			constraints.setReturningAttributes(attrs);
			en = LdapHelper.getCtx().search(basedn, s, constraints);
		} catch (Exception e) {
			try {
				logger.info("getNewCtx------------------>");
				en = LdapHelper.getNewCtx().search(basedn, s, constraints);
			}catch (Exception e1){
				logger.info("getNewCtx Error:" + e1);
			}
		}
		return en;
	}


	public String getIdmPhone(String account) throws NamingException{
		String filter = "(smart-alias="+account+")";
		String basedn = "ou=People,dc=bizenit,dc=com ";
		String[] returnAattrs = { "smart-securemobile" };
		NamingEnumeration<SearchResult> ne = search(basedn, filter,returnAattrs);
		if(ne!=null){
			while (ne.hasMoreElements()) {
				SearchResult sr = ne.nextElement();
				Attributes attrs = sr.getAttributes();// 获取用户属性
				Attribute securemobile = attrs.get("smart-securemobile");//手机号
				if(securemobile!=null&&securemobile.get()!=null){
					logger.info("account:"+account+"----->smart-securemobile:" + securemobile.get().toString());
					return securemobile.get().toString();
				}else {
					logger.info("account:"+account+"----->用户没手机号,code：-1");
				}
				return "-1";
			}
		}else {
			logger.info("account:"+account+"----->用户不存在,code：-2");
		}
		return "-2";
	}

	public void sycnAllUser() throws NamingException{
		String filter="(smart-type=E1)";
		String basedn = "ou=People,dc=bizenit,dc=com ";
		String[] returnAattrs = { "*" };
		NamingEnumeration<SearchResult> ne = search(basedn, filter,returnAattrs);
		List<Map<String,String>> costs=new ArrayList();
		if(ne!=null){
			while (ne.hasMoreElements()) {
				Map<String,String> map=new HashMap<>();
				SearchResult sr = ne.nextElement();
				Attributes attrs = sr.getAttributes();// 获取用户属性
				Attribute fdLoginName = attrs.get("smart-alias");// 获取用户EMS帐号属性
				if(fdLoginName==null|| fdLoginName.get()==null){
					continue;
				}
				Attribute costDeptId = attrs.get("customized-reserve7");//人事范围id
				Attribute costDeptName = attrs.get("customized-reserve8");//人事范围名称
				map.put("account",fdLoginName.get().toString());
				if (costDeptId != null&& costDeptId.get()!=null&&costDeptName!=null&&costDeptName.get()!=null) {
					map.put("cid",costDeptId.get().toString());
					map.put("cname",costDeptName.get().toString());
				}
				Attribute hrDeptId = attrs.get("customized-companyid");//人事范围id
				Attribute hrDeptName = attrs.get("customized-company");//人事范围名称
				if (hrDeptId != null&& hrDeptId.get()!=null&&hrDeptName!=null&&hrDeptName.get()!=null) {
					map.put("hid",hrDeptId.get().toString());
					map.put("hname",hrDeptName.get().toString());
				}
				Attribute securemobile = attrs.get("smart-securemobile");//手机号
				if(securemobile!=null&&securemobile.get()!=null){
					map.put("phone",securemobile.get().toString());
				}
				costs.add(map);
			}

		}
		for (Map<String,String> map:costs){


		}
	}

}
