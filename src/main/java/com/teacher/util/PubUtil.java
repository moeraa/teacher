package com.teacher.util;

import com.teacher.common.thread.ThreadLocalMap;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/**
 * @Author:chenxiaohui
 * @Description:
 * @Date:Create in 11:55 2017/12/13
 * @Modified By:
 */
public class PubUtil {
    private static final Logger logger = LoggerFactory.getLogger(PubUtil.class);
    public final static String HIBERNATE_SESSION = "HIBERNATE_SESSION";
    public final static Pattern WEBSITE_PATTERN= Pattern.compile("(http://|https://)[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+\\.?");
    public static Session createSession(SessionFactory sessionFactory){
        Session session = null;
        if (TransactionSynchronizationManager.isSynchronizationActive()){
            session = sessionFactory.getCurrentSession();
        }else {
            session = sessionFactory.openSession();
            Object obj = ThreadLocalMap.get(HIBERNATE_SESSION);
            List<Session> sessionList = null;
            if (obj != null){
                sessionList =new ArrayList<>();
                ThreadLocalMap.put(HIBERNATE_SESSION,sessionList);
            }
            sessionList.add(session);
        }
        return session;
    }

    public static void close(SessionFactory sessionFactory, Session session) {
        close(session);
    }

    public static void close(Session session) {
        if (!TransactionSynchronizationManager.isSynchronizationActive()) {
            session.flush();
            session.close();
            Object temp = ThreadLocalMap.get(PubUtil.HIBERNATE_SESSION);
            if (temp != null) {
                List<Session> sessionList = (List<Session>) temp;
                sessionList.remove(session);
            }
        }
    }


}
