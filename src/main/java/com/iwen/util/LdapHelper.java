package com.iwen.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

/**
 * ldap服务器连接工具
 */
public class LdapHelper {

    static Logger logger = LoggerFactory.getLogger(LdapHelper.class);
    private static DirContext ctx = null;

    private static int count1=0;
    private static int count2=0;

    public static DirContext getCtx() {
        if (ctx != null ) {
            return ctx;
        }
       return getNewCtx();
    }

    public static DirContext getNewCtx() {
        logger.info("打开IDM认证连接----------------->" + count1++);
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://192.168.94.48:389");
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL,"uid=zzb_bind,ou=Application,ou=People,dc=bizenit,dc=com");
        env.put(Context.SECURITY_CREDENTIALS, "6YOiIWoA2Kov");
        env.put("com.sun.jndi.ldap.connect.pool", "true");
        try {
            ctx = new InitialDirContext(env);
            return ctx;
        } catch (javax.naming.AuthenticationException e) {
            logger.error("IDM认证失败 " + e);
        } catch (NamingException e) {
            logger.error("IDM链接失败 " + e);
        }
        return null;
    }

    public static void closeCtx(){
        try {
            if (ctx != null ) {
                ctx.close();
            }
            logger.info("关闭IDM认证连接----------------->" + count2++);
        } catch (NamingException e) {
            logger.error("关闭IDM认证失败 " + e);
        }
    }
}
