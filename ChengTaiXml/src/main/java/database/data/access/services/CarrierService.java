package database.data.access.services;

import database.data.access.implementations.CarrierIpm;
import database.data.tables.Carrier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrierService {

    @Autowired
    CarrierIpm carrierIpm;

    public List<Carrier> getAllCarriers() {

        List<Carrier> carrierList = carrierIpm.getAllCarriers();

        return carrierList;
    }
}
