package business;

import com.salman.mockito.mockitodemo.business.DataService;
import com.salman.mockito.mockitodemo.business.SomeBusinessImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SomeBusinessImplStubTest {
    @Test
    void findTheGreatestFromAllData_basicScenario() {

        /*
        *  We want to create a stub and pass it into
        *  SomeBusinessUmp using the constructor.
        * */
        DataService dataServiceStub = new DataServiceStub1();

        // Replacing a data service with a stub of data service.
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25, result);
    }

    @Test
    void findTheGreatestFromAllData_withOneValue() {

        /*
         *  We want to create a stub and pass it into
         *  SomeBusinessUmp using the constructor.
         * */
        DataService dataServiceStub = new DataServiceStub2();

        // Replacing a data service with a stub of data service.
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(35, result);
    }
}

// Creating a Stub Class instead of playing with real data.
class DataServiceStub1 implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {25,15,5};
    }
}

class DataServiceStub2 implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[] {35};
    }
}