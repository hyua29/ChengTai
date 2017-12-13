package database.table.classes.parents;

import autowire.SessionFactoryStatic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.QueryProducer;

import java.util.List;

/*
This class is the parent class of all DataClassImplementation
 */
public class DataClassImp<T extends DataClassInterface>{

    private String nameOfT;

    protected SessionFactory factory = SessionFactoryStatic.getFactory();

    private List<T> TList;

    public DataClassImp(String nameOFT){
        this.nameOfT = nameOFT;
    }


    public List<T> getTList() {

        // get a session
        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            TList = session.createQuery("from " +this.nameOfT ).getResultList();  // retrieve all User objections
            session.close();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        // ! might need to close the factory
        return TList;
    }


    public Boolean deleteTotalInfo(int numId) {

        Boolean deleteSucceeded = true;
        // get a session
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            Query query = session.createQuery("delete from " +this.nameOfT
            + " where id=:id");
            query.setParameter("id", numId);

            query.executeUpdate();
        } catch (Exception e){
            deleteSucceeded = false;
            e.printStackTrace();
        } finally {
            session.close();
        }

        return deleteSucceeded;
    }
}
