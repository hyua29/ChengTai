package database.data.access.services;

import database.data.access.implementations.HarborIpm;
import database.data.access.implementations.PODIpm;
import database.data.tables.POD;
import database.data.tables.SourceHarbor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AJAXServices {

    @Autowired
    PODIpm podIpm;

    @Autowired
    HarborIpm harborIpm;

    public List<POD> retrieveAllPODs() {

        return podIpm.getAllPods();
    }

    public List<SourceHarbor> retrieveAllHarbors() {

        return this.harborIpm.getAllHarbors();
    }





}
