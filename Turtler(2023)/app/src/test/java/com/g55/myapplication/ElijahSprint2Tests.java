package com.g55.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

public class ElijahSprint2Tests {
    @Test
    public void noNamesOfOnlyWhitespacesAccepted() {
        assertEquals(false, PreferencesActivity.nameValid(" "));
        assertEquals(false, PreferencesActivity.nameValid("\n"));
        assertEquals(false, PreferencesActivity.nameValid("\t"));
        assertEquals(false, PreferencesActivity.nameValid(" \t \n"));
        assertEquals(true, PreferencesActivity.nameValid(" \n \t s"));
    }
    @Test
    public void noNullNamesAccepted() {
        assertEquals(false, PreferencesActivity.nameValid(""));
    }
}
