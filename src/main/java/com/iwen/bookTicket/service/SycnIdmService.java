package com.iwen.bookTicket.service;


import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;


import com.iwen.bookTicket.bean.Idm;
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

	public List<Idm> getAll() throws NamingException{
		String filter="(smart-type=E1)";
		String basedn = "ou=People,dc=bizenit,dc=com ";
		String[] returnAattrs = { "*" };
		NamingEnumeration<SearchResult> ne = search(basedn, filter,returnAattrs);
		List<Idm> idms=new ArrayList();
		if(ne!=null){
			while (ne.hasMoreElements()) {
				Idm idm=new Idm();
				SearchResult sr = ne.nextElement();
				Attributes attrs = sr.getAttributes();// 获取用户属性
				for (NamingEnumeration ae = attrs.getAll(); ae.hasMoreElements();) {
					Attribute attr = (Attribute) ae.next();
					String attrId = attr.getID();
					for (NamingEnumeration vals = attr.getAll(); vals.hasMore(); ) {
						String thing = vals.next().toString();
						idm.setValue(attrId,thing);
					}
				}
				idms.add(idm);
			}

		}
		return idms;
	}

}
