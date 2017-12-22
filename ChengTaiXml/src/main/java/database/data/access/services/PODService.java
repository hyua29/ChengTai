package database.data.access.services;

import database.data.access.implementations.PODIpm;
import database.data.tables.POD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PODService {

    @Autowired
    PODIpm podIpm;

    public List<POD> getAllPODs() {

        List<POD> podList = podIpm.getAllPods();

        return podList;

    }
}
