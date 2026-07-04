package com.example.mockito;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class NetworkServiceTest {

    @Test
    void testServiceWithMockNetworkClient() {

        NetworkClient mockClient = mock(NetworkClient.class);

        when(mockClient.connect())
                .thenReturn("Mock Connection");

        NetworkService service =
                new NetworkService(mockClient);

        String result = service.connectToServer();

        assertEquals("Connected to Mock Connection", result);
    }
}