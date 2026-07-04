package com.example.mockito;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ApiServiceTest {

    @Test
    void testServiceWithMockRestClient() {

        RestClient mockClient = mock(RestClient.class);

        when(mockClient.getResponse())
                .thenReturn("Mock Response");

        ApiService service = new ApiService(mockClient);

        String result = service.fetchData();

        assertEquals("Fetched Mock Response", result);
    }
}