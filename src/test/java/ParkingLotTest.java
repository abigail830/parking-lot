import exception.CarNotFoundException;
import exception.ParkingLotIsFullException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParkingLotTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void should_throw_parking_lot_is_full_when_car_received_but_no_space() {
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car();
        assertThrows(ParkingLotIsFullException.class, ()-> parkingLot.receive(car));
    }

    @Test
    void should_throw_car_not_found_exception_when_car_not_found() {
        ParkingLot parkingLot = new ParkingLot(0);
        ParkingTicket ticket = new ParkingTicket();
        assertThrows(CarNotFoundException.class, ()-> parkingLot.retrieve(ticket));
    }
}