package database.data.access.services;

import database.data.tables.TotalInfo;
import database.data.access.implementations.TotalInfoIpm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @// TODO: 12/12/17 add a layer that intercepts all calls to validate the users have the privileges to perform actions
 */

@Service
public class TotalInfoService {

    @Autowired
    TotalInfoIpm totalInfoIpm;

    public TotalInfo getTotalInfoById(int id){

        TotalInfo totalInfo = totalInfoIpm.getTotalInfoById(id);

        return totalInfo;
    }

    /*
     * This method is a bit weird.
     * Hibernate cannot throw exception at the point exception occurs
     * so the exception has to be caught here
     */
    public Boolean saveTotalInfo(TotalInfo t){

        Boolean transactionSucceeded = true;
        try {
            totalInfoIpm.saveTotalInfo(t);
        } catch (Exception e) {
            transactionSucceeded = false;
        }

        return transactionSucceeded;

    }

    /*
    This method is used to return search result based on users' choices
     */
    public List<TotalInfo> searchTotalInfo(String cOrPSelect, String ctyOrPod, Date dateFrom, Date dateTo, String sourceHarbor){

        List<TotalInfo> searchResultList = totalInfoIpm.searchTotalInfo(cOrPSelect, ctyOrPod, dateFrom, dateTo, sourceHarbor);

        return searchResultList;
    }

    public Boolean deleteTotalInfo(int id) {

        Boolean deleteSucceeded = totalInfoIpm.deleteById(id);

        return deleteSucceeded;
    }
}
