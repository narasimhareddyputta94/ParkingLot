package repositor;


import exceptions.GateNotFoundException;
import models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {

    Map<Long,Gate>gates = new HashMap<>();

    public Gate findGateById(Long getId) throws GateNotFoundException {
        if(gates.containsKey(getId)){
            return gates.get(getId);
        }
        throw new GateNotFoundException();
    }
}
