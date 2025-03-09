package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;

import lombok.NoArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


@NoArgsConstructor
public class Util {

    public static SessionFactory openHibernate() {
        try {
            Configuration configuration = new Configuration();

            configuration.addAnnotatedClass(User.class);

            return configuration.buildSessionFactory();

        } catch (HibernateException e) {
            throw new RuntimeException(e);

        }
    }

}
