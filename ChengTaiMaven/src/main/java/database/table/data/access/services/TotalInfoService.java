package database.table.data.access.services;

import autowire.SessionFactoryStatic;
import database.table.classes.Carrier;
import database.table.classes.POD;
import database.table.classes.TotalInfo;
import database.table.classes.User;
import database.table.data.access.implementations.CarrierIpm;
import database.table.data.access.implementations.PODIpm;
import database.table.data.access.implementations.TotalInfoIpm;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @// TODO: 12/12/17 add a layer that intercepts all calls to validate the users have the privileges to perform actions
 */

@Component
public class TotalInfoService {
    //private SessionFactory factory = SessionFactoryStatic.getFactory();

    public TotalInfoService (){

    }

    private TotalInfoIpm totalInfoIpm = new TotalInfoIpm("TotalInfo");
    private PODIpm PODIpm = new PODIpm("POD");
    private CarrierIpm carrierIpm = new CarrierIpm("Carrier");

    public TotalInfo getTotalInfoById(int id){

        TotalInfo totalInfo =totalInfoIpm.getTotalInfoById(id);

        return totalInfo;
    }

    public Boolean saveTotalInfo(TotalInfo t){


        Boolean transactionSucceeded = totalInfoIpm.saveTotalInfo(t);

        return transactionSucceeded;

    }

    /*
    This method is used to return search result based on users' choices
     */
    public List<TotalInfo> searchTotalInfo(String cOrPSelect, String ctyOrPod, Date fromThisDate, String sourceHarbor){

        List<TotalInfo> searchResultList = totalInfoIpm.searchTotalInfo(cOrPSelect, ctyOrPod, fromThisDate, sourceHarbor);

        return searchResultList;
    }

    public Boolean deleteTotalInfo(int id) {

        Boolean deleteSucceeded = totalInfoIpm.deleteTotalInfo(id);

        return deleteSucceeded;
    }
}
