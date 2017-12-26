package database.data.access.services;

import database.data.access.implementations.HarborIpm;
import database.data.tables.Carrier;
import database.data.tables.SourceHarbor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarborService {
    @Autowired
    HarborIpm harborIpm;

    public List<SourceHarbor> getAllHarbors() {

        List<SourceHarbor> sourceHarborList = harborIpm.getAllHarbors();

        return sourceHarborList;
    }

    public Boolean deleteHarborByName(String harborName) {

        return harborIpm.deleteHarborByName(harborName);
    }

    public Boolean addHarbor(SourceHarbor sourceHarbor) {
        return harborIpm.addHarbor(sourceHarbor);
    }
}
