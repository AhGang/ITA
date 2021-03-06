import com.thoughtworks.tdd.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
public class ParkingBoyTest {
    // 5mins / 2 mins
    @Test
    void should_get_a_ticket_when_park_a_car() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        //When&Then
        Assertions.assertNotNull(parkingBoy.parkACar(car));
    }
    // 5mins / 1mins
    @Test
    void should_fetch_a_car_when_give_a_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = parkingBoy.parkACar(new Car());
        //When
        Car car = parkingBoy.fetchACar(ticket);
        // Then
        Assertions.assertNotNull(car);
    }
    // 10mins / 10mins
    @Test
    void should_park_multiply_cars() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ArrayList<Car> carList = new ArrayList<>();
        //When&Then
        Assertions.assertEquals(new ArrayList<Ticket>(),parkingBoy.parkMultiplyCars(carList));
    }
    // 15mins / 15mins
    @Test
    void should_fetch_right_car_when_using_correspond_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car carA = new Car();
        Car carB = new Car();
        Ticket ticketA = parkingBoy.parkACar(carA);
        Ticket ticketB = parkingBoy.parkACar(carB);
        //When
        Car carAA = parkingBoy.fetchACar(ticketA);
        Car carBB = parkingBoy.fetchACar(ticketB);
        // Then
        Assertions.assertEquals(carA,carAA);
        Assertions.assertEquals(carB,carBB);
    }
    // 15mins / 10mins
    @Test
    void should_fetch_no_car_when_give_a_wrong_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket(false,false);

        //When
        boolean isValidTicket = parkingBoy.checkTicket(ticket);
        // Then
        Assertions.assertEquals(null,parkingBoy.fetchACar(ticket));
    }
    // 15mins / 10mins
    @Test
    void should_fetch_no_car_when_dose_provide_a_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = null;
        //When&Then
        Assertions.assertEquals(false, parkingBoy.checkTicket(ticket));
    }
    // 15mins / 10mins
    @Test
    void should_not_park_a_car_when_parking_lot_have_no_position() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(10,10);
        Car car = new Car();
        //When
        boolean isCapacityFulled = parkingLot.isCapacityFulled();
        // Then
        Assertions.assertEquals(null,isCapacityFulled?null:parkingBoy.parkACar(car));
    }
    // 5mins / 2mins
    @Test
    void should_throw_park_a_car_when_Passing_a_parked_car() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        car.setParked(true);
        //When&Then
        Assertions.assertThrows(RuntimeException.class, ()-> { parkingBoy.parkACar(car); });
    }
    // 5mins / 2mins
    @Test
    void should_throw_park_a_car_when_Passing_null_car() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = null;
        //When&Then
        Assertions.assertThrows(RuntimeException.class, ()-> { parkingBoy.parkACar(car); });
    }
    // 10mins / 10mins
    @Test
    void should_get_error_msg_when_give_a_wrong_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = new Ticket(true,false);
        //When
        boolean isValidTicket = parkingBoy.checkTicket(ticket);
        parkingBoy.fetchACar(ticket);
        String errorMsg = parkingBoy.getErrorMsg();
        // Then

        Assertions.assertEquals("Unrecognized parking ticket.",errorMsg);
    }
    // 5mins / 3mins
    @Test
    void should_get_error_msg_when_dose_provide_a_ticket() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        Ticket ticket = null;
        //When
        parkingBoy.checkTicket(ticket);
        String errorMsg = parkingBoy.getErrorMsg();
        // Then

        Assertions.assertEquals("Please provide your parking ticket.",errorMsg);
    }
    // 15mins / 10mins
    @Test
    void should_get_parking_lot_count_when_have_two_parking_lot_and_not_smarted_parkinng_boy() {
        //Given
        ParkingBoy parkingBoy = new ParkingBoy();
        ArrayList<Car> carList = new ArrayList<>(Arrays.asList(new Car(), new Car(),new Car()));
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        parkingBoy.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        //When
        parkingBoy.parkMultiplyCars(carList);
        int actuallyParkingLotStatus[] =  parkingBoy.getParkingLotCount();
        int exceptedParkingLotStatus[] = {2,1};
        // Then
        Assertions.assertArrayEquals(exceptedParkingLotStatus,actuallyParkingLotStatus);
    }
}
