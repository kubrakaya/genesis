package com.mobiliz.portal.test.ui.common;


public enum VehicleList {


    VEHICLE_2382515_DT465_QUECLINK("2382515 - DT465 - QUECLINK", 523008, 2382515, "DT465"),
    VEHICLE_238251543_DT43C("238251543-DT43C", 522755, 238251543, "DT43C"),
    VEHICLE_23825465_DT465BC("23825465-DT465BC", 522753, 23825465, "BC465"),
    VEHICLE_23825900_DT900("23825900-DT900", 541440, 23825900, "DT900"),
    VEHICLE_28746200_DT200("28746200-DT200", 533248, 28746200, "DT200"),
    VEHICLE_321321321_DT455("321321321-DT455", 533250, 321321321, "DT455"),
    VEHICLE_753102306_DT306("753102306-DT306", 519937, 753102306, "DT306"),
    VEHICLE_753102430_DT430C("753102430-DT430C", 521987, 753102430, "DT430C"),
    VEHICLE_753102_DT900F_POINTER("753102-DT900F-POINTER", 485633, 753102, "DT90F"),
    VEHICLE_753103465_D465C("753103465-D465C", 522241, 753103465, "D465C"),
    VEHICLE_753103900_DT900_C("753103900-DT900-C", 521728, 753103900, "DT90C"),
    VEHICLE_1234321_DT900F("DT90F",550144,1234321,"DT90F");


    public String Plate;
    public int MUID;
    public int NetworkID;
    public String VendorCode;


    VehicleList(String plate, int muID, int networkID, String vendorCode) {
        this.Plate = plate;
        this.MUID = muID;
        this.NetworkID = networkID;
        this.VendorCode = vendorCode;

    }


}
