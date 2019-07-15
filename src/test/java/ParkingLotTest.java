import com.thoughtworks.tdd.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class ParkingLotTest {
    // 5mins / 3mins
    @Test
    void should_get_error_msg_when_parking_lot_is_fulled() {
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(10,10);
        //When
        parkingLot.isCapacityFulled();
        parkingBoy.checkParkingLotStatus(parkingLot);
        String errorMsg = parkingBoy.getErrorMsg();
        // Then

        Assertions.assertEquals("Not enough position.",errorMsg);
    }

}

