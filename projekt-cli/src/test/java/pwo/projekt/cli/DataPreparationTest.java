///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
// */
//package pwo.projekt.cli;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.runner.RunWith;
////import org.mockito.MockedStatic;
//import static org.mockito.Mockito.mockStatic;
//import static org.mockito.Mockito.when;
////import org.powermock.api.mockito.PowerMockito;
////import org.powermock.core.classloader.annotations.PrepareForTest;
////import org.powermock.modules.junit4.PowerMockRunner;
////import org.powermock.modules.testng.PowerMockTestCase;
//
//
//
///**
// *
// * @author elizakoziol
// */
////@RunWith(PowerMockRunner.class)
////@PrepareForTest({DataPreparation.class})
//public class DataPreparationTest {
//    
//    private static DataPreparation mockFoo;
//    
//    public DataPreparationTest() {
//    }
//    
//    @BeforeAll
//    public static void setUpClass() {
//    }
//    
//    @AfterAll
//    public static void tearDownClass() {
//    }
//    
//    @BeforeEach
//    public void setUp() {
//    }
//    
//    @AfterEach
//    public void tearDown() {
//    }
//
//    /**
//     * Test of createHeadline method, of class DataPreparation.
//     */
//    @Test
//    public void testCreateHeadline() {
//        System.out.println("createHeadline");
//        String expResult = "Data ostatniej modyfikacji do pliku";
//        String expResult2 = "Srednia liczba slow w linii";
//
//        String[] result = DataPreparation.createHeadline();
//        assertEquals(result[3], expResult);
//        assertEquals(result[16], expResult2);
//    }
//
//    /**
//     * Test of createDataTable method, of class DataPreparation.
//     */
//    @Test
////    public void testCreateDataTable() throws Exception {
////        System.out.println("createDataTable");
////        PowerMockito.mockStatic(DataPreparation.class);
////        when(DataPreparation.getPathOfFile(0,1)).thenReturn("");
////        assertEquals("", DataPreparation.getPathOfFile(0,1));
////        assertEquals(3, "");
//    }
//        
////        try (MockedStatic mocked = mockStatic(DataPreparation.class)) {
////            mocked.when((String)DataPreparation.getPathOfFile(0,1).el).thenReturn("sdf");
////            assertEquals("bar", Foo.method());
////            mocked.verify(Foo::method);
//       
////        assertEquals("foo", Foo.method());
//        
// 
////        DataPreparation mockDataPreparation = mock(DataPreparation.class);
////        when(DataPreparation.getPathOfFile(0,1)).thenReturn("/home/opensuse/eliza/abc");
//        
////        int filesAmount = 1;
////        //Object[][] expResult = null;
////        Object[][] result = DataPreparation.createDataTable(filesAmount);
////        assertEquals(result[0][0], "/home/opensuse/eliza/abc");
////    }
//    
////}
