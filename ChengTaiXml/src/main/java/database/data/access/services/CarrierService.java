package database.data.access.services;

import com.sun.org.apache.xpath.internal.operations.Bool;
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

    public Boolean deleteHarborByName(String harborToDelete) {

        return carrierIpm.deleteCarrierByName(harborToDelete);
    }

    public Boolean addCarrier(Carrier carrier) {
        return carrierIpm.addCarrier(carrier);
    }

}
