import com.thoughtworks.tdd.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
public class ServiceManagerTest {
    // 10mins / 10mins
    @Test
    void should_add_parking_boys_to_management_list_manage_parking_boys() {
        //Given
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.setManageList(new ArrayList<>(Arrays.asList(new ParkingBoy(), new ParkingBoy(),new ParkingBoy())));
        //When


        // Then
        Assertions.assertNotNull(serviceManager.manageParkingBoy());
    }
    // 5mins / 5mins
    @Test
    void should_park_a_car_when_service_manager_specify_a_parking_boy_to_park_a_car_which_is_on_manage_list_and_parking_lot_is_managed() {
        //Given
        Car car = new Car();
        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        parkingBoy1.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.setManageList(new ArrayList<>(Arrays.asList(parkingBoy1,parkingBoy2)));



        //When&Then
        Assertions.assertNotNull(serviceManager.specifyAParkingBoyToParkACar(car,parkingBoy1,parkingLot1));
    }
    // 5mins / 5mins
    @Test
    void should_park_a_car_when_service_manager_specify_a_parking_boy_to_park_a_car_which_is_not_on_manage_list_and_parking_lot_is_managed() {
        //Given
        Car car = new Car();
        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();
        ParkingBoy parkingBoy3 = new ParkingBoy();
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        parkingBoy1.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1, parkingLot2)));
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.setManageList(new ArrayList<>(Arrays.asList(parkingBoy1,parkingBoy2)));


        //When&Then
        Assertions.assertEquals(null,serviceManager.specifyAParkingBoyToParkACar(car,parkingBoy3,parkingLot1));
    }
    // 5mins / 5mins
    @Test
    void should_park_a_car_when_service_manager_specify_a_parking_boy_to_park_a_car_which_is__on_manage_list_and_parking_lot_is_not_managed() {
        //Given
        Car car = new Car();
        ParkingBoy parkingBoy1 = new ParkingBoy();
        ParkingBoy parkingBoy2 = new ParkingBoy();
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        parkingBoy1.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1)));
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.setManageList(new ArrayList<>(Arrays.asList(parkingBoy1,parkingBoy2)));



        //When&Then
        Assertions.assertEquals(null,serviceManager.specifyAParkingBoyToParkACar(car,parkingBoy1,parkingLot2));
    }
    // 5mins / 5mins
    @Test
    void should_park_a_car_when_service_manager_to_park_a_car_which_is_managed() {
        //Given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1)));

        //When&Then
        Assertions.assertNotNull(serviceManager.parkACar(car,parkingLot1));
    }
    // 5mins / 5mins
    @Test
    void should_park_a_car_when_service_manager_to_park_a_car_which_is_not_managed() {
        //Given
        Car car = new Car();
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ParkingLot parkingLot2 = new ParkingLot(3,0);
        ServiceManager serviceManager = new ServiceManager();
        serviceManager.setParkingLotList(new ArrayList<>(Arrays.asList(parkingLot1)));

        //When&Then
        Assertions.assertEquals(null,serviceManager.parkACar(car,parkingLot2));
    }
    // 5mins / 5mins
    @Test
    void should_display_the_error_message_with_wrong_ticket_from_parking_boy() {
        //Given
        Car car = new Car();
        Ticket ticket = new Ticket(true,false);
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot1 = new ParkingLot(2,0);
        ServiceManager serviceManager = new ServiceManager();

        //When
        boolean isValidTicket = parkingBoy.checkTicket(ticket);
        parkingBoy.fetchACar(ticket);
        parkingBoy.passErrorMsgToManager(parkingBoy.getErrorMsg(),serviceManager);
        // Then
        Assertions.assertEquals("Unrecognized parking ticket.",serviceManager.getErrorMsg());
    }
    // 5mins / 5mins
    @Test
    void should_display_the_error_message_without_ticket_from_parking_boy() {
        //Given
        Car car = new Car();
        Ticket ticket = null;
        ParkingBoy parkingBoy = new ParkingBoy();
        ServiceManager serviceManager = new ServiceManager();
        //When
        parkingBoy.checkTicket(ticket);
        parkingBoy.passErrorMsgToManager(parkingBoy.getErrorMsg(),serviceManager);
        // Then
        Assertions.assertEquals("Please provide your parking ticket.",serviceManager.getErrorMsg());
    }
    // 5mins / 5mins
    @Test
    void should_display_the_error_message_with_no_position_from_parking_boy() {
        //Given
        Car car = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot(10,10);
        ServiceManager serviceManager = new ServiceManager();

        //When
        parkingLot.isCapacityFulled();
        parkingBoy.checkParkingLotStatus(parkingLot);
        parkingBoy.passErrorMsgToManager(parkingBoy.getErrorMsg(),serviceManager);
        // Then
        Assertions.assertEquals("Not enough position.",serviceManager.getErrorMsg());
    }
}
