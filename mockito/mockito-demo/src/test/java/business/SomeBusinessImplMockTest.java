package business;

import com.salman.mockito.mockitodemo.business.DataService;
import com.salman.mockito.mockitodemo.business.SomeBusinessImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


// Using this annotation , to use the Mockito Annotations.
@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {

    // We can use Mockito Annotation to achieve the same thing.
    @Mock
    private DataService dataServiceMock;

    // Injecting into the businessImpl after defining a Mock and use
    // annotation InjectMocks
    @InjectMocks
    private SomeBusinessImpl businessImpl;

    @Test
    void findTheGreatestFromAllData_basicScenario() {

        /*
         *  We want to create a mock and pass it into
         *  SomeBusinessUmp using the constructor.
         * */
        DataService dataServiceMock =  mock(DataService.class);
        // Tell the Mock to return a value.
//        dataServiceMock.retrieveAllData() => new int[]{25,15,5}
        // This helps deal with nullException and return the data that we desire
        // Mocking the method to return a specific value.
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25,15,5});
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);

        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25, result);
    }


    // Using the Mockito Annotation.
    @Test
    void findTheGreatestFromAllData_MockitoAnnotation() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{25,15,15});
        assertEquals(25, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_withOneValueMock() {

        /*
         *  We want to create a stub and pass it into
         *  SomeBusinessUmp using the constructor.
         * */
        DataService dataServiceMock = mock(DataService.class);
        // Replacing a data service with a stub of data service.
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{35});
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(35, result);
    }

    @Test
    void findTheGreatestFromAllData_withOneValueMockitoAnnotation() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{35});
        assertEquals(35, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    void findTheGreatestFromAllData_withEmptyArrMockitoAnnotation() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{});
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
    }
}
// Creating a Stub Class instead of playing with real data.
//class DataServiceMock1 implements DataService {
//    @Override
//    public int[] retrieveAllData() {
//        return new int[] {25,15,5};
//    }
//}
//
//class DataServiceMock2 implements DataService {
//    @Override
//    public int[] retrieveAllData() {
//        return new int[] {35};
//    }
//}