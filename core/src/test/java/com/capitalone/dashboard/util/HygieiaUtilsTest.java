package com.capitalone.dashboard.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HygieiaUtilsTest {

    @Test
    public void testSmartUrlEquals(){
        assertTrue(HygieiaUtils.smartUrlEquals("https://example.com/test", "https://example.com/test"));
        assertTrue(HygieiaUtils.smartUrlEquals("http://example.com/test", "http://example.com/test.git"));
        assertTrue(HygieiaUtils.smartUrlEquals("http://subdomain.example.com/test", "http://example.com/test"));
        assertTrue(HygieiaUtils.smartUrlEquals("http://subdomain.example.com/test", "http://other.example.com/test"));
        assertTrue(HygieiaUtils.smartUrlEquals("http://subdomain.example.com/test.git?k=2", "http://other.example.com/test?k=2"));
        assertTrue(HygieiaUtils.smartUrlEquals(null, ""));
        assertTrue(HygieiaUtils.smartUrlEquals(null, null));

        assertFalse(HygieiaUtils.smartUrlEquals("https://example.com/test", "https://example.com/other"));
        assertFalse(HygieiaUtils.smartUrlEquals("http://example.com/test", "http://example.com/other.git"));
        assertFalse(HygieiaUtils.smartUrlEquals("http://subdomain.example.com/test1", "http://example.com/test2"));
        assertFalse(HygieiaUtils.smartUrlEquals("http://subdomain.example.com/test?k=5", "http://other.example.com/test?b=3"));
    }
}
