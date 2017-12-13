package database.table.classes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

/*
This class is a template of how a class should be annotated so that it can be stored and
retrieved from database by hibernate
 */
// must be java persistence
@javax.persistence.Entity  //This is an entity that that can be mapped to database
@javax.persistence.Table(name="usr_info")  // Table this entity goes to
public class User {

    @Id // is primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // leave mysql to deal with the AI
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="passwd")
    private String passwd;

    @Column(name="email")
    private String email;

    public User(){
        // Must have this no-arg class so that hibernate can retrieveObjectByID data from database and construct java object
        // with setters and getters
    }

    public User(String name, String passwd, String email) {
        this.name = name;
        this.email = email;
        this.passwd = passwd;
    }

    public User(String name, String passwd) {
        this.name = name;
        this.passwd = passwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd= passwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + passwd + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    private static void push(){
        // create factory that creates sessions
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(User.class).buildSessionFactory();

        // get a session
        Session session = factory.getCurrentSession();

        try {
            // use session to save java object
            User tempUser1 = new User("Haoming", "2008");
            User tempUser2 = new User("Gloria", "2009");

            // start a transaction
            session.beginTransaction();

            // save the java object
            session.save(tempUser1);
            session.save(tempUser2);

            // commit transaction and close the session MUST
            session.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();

        } finally {
            factory.close();
        }
    }

    private static void retrieveObjectByID() {
        // create factory that creates sessions
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(User.class).buildSessionFactory();

        // get a session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            User u = session.get(User.class, 10);
            System.out.println(u);

            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    private static void retrieveAll() {
        // create factory that creates sessions
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(User.class).buildSessionFactory();

        // get a session
        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            List<User> users = session.createQuery("from User").getResultList();  // retrieve all User objections

            // List<User> users = session.createQuery("from User u where u.name like 'H%' ").getResultList();  // ignore the warning

            System.out.println(users);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    private static void updateUserInfo() {
        // create factory that creates sessions
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(User.class).buildSessionFactory();

        // get a session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            User userToUpdate = session.get(User.class, 10);
            userToUpdate.setEmail("hyua");  // just need to modify the object
            session.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    private static void updateAll() {
        // create factory that creates sessions
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(User.class).buildSessionFactory();

        // get a session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.createQuery("update User u set email='hyua29' where u.email = 'hyua'").executeUpdate();

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    private static void deleteUser() {
        // create factory that creates sessions
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(User.class).buildSessionFactory();

        // get a session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            User uToDelete = session.get(User.class, 16);
            session.delete(uToDelete);
            session.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    private static void deleteAll() {
        // create factory that creates sessions
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(User.class).buildSessionFactory();

        // get a session
        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            session.createQuery("delete from User u where (u.name = 'Haoming' and u.email = null)").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }

    public static void main(String[] args) {

        User.push();
        // User.retrieveObjectByID();
        // User.retrieveAll();
        // User.updateUser();
        // User.updateAll();
        // User.deleteAll();
    }
}
