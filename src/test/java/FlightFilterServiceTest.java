import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FlightFilterService;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FlightFilterServiceTest {

        List<Flight> flightsDepInPast = FlightBuilderTest.createFlightsDepInPast();
        List<Flight> flightsDepBeforeArr = FlightBuilderTest.createFlightsDepBeforeArr();
        List<Flight> flightsHardstandMoreTwoHours = FlightBuilderTest.createFlightsHardstandMoreTwoHours();
        FlightFilterService service = new FlightFilterService();

        @Test
        public void removeFlightsDepartureBeforeNow() {
            Assert.assertNotNull(flightsDepInPast);
            Assert.assertEquals(3, flightsDepInPast.size());
            Assert.assertEquals(2, service.removeFlightsDepartureBeforeNow(flightsDepInPast).size() );
        }

        @Test
        public void removeFlightsArrivalBeforeDeparture() {
            Assert.assertNotNull(flightsDepBeforeArr);
            Assert.assertEquals(3, flightsDepBeforeArr.size());
            Assert.assertEquals(2, service.removeFlightsArrivalBeforeDeparture(flightsDepBeforeArr).size() );
        }

        @Test
        public void removeFlightsHardstandMoreTwoHours() {
            Assert.assertNotNull(flightsHardstandMoreTwoHours);
            Assert.assertEquals(3, flightsHardstandMoreTwoHours.size());
            Assert.assertEquals(2, service.removeFlightsHardstandMoreTwoHours(flightsHardstandMoreTwoHours).size());
        }

}
