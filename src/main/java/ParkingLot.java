import exception.CarNotFoundException;
import exception.ParkingLotIsFullException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    int capacity;
    Map<ParkingTicket, Car> parkedCars = new HashMap<ParkingTicket, Car>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public Boolean hasSpace(){
        return parkedCars.size()<capacity;
    }

    public ParkingTicket receive(Car car) throws ParkingLotIsFullException {
        if(hasSpace()){
            ParkingTicket ticket = new ParkingTicket();
            parkedCars.put(ticket, car);
            return ticket;
        } else {
            throw new ParkingLotIsFullException();
        }
    }

    public void retrieve(ParkingTicket ticket) throws CarNotFoundException {
        if(parkedCars.containsKey(ticket)){
            parkedCars.remove(ticket);
        } else {
            throw new CarNotFoundException();
        }

    }


}
