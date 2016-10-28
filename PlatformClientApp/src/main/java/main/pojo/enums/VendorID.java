package main.pojo.enums;

public enum VendorID {
    FEIHONG(0xAAFA);


    private int id;
    VendorID(int id) {
        this.id = id;
    }

    public int getVenderId(){
        return this.id;
    }

    /**
     * 根据数值获取VenderID
     * @param num
     * @return
     */
    public static VendorID getVenderIdByNum(int num){
        VendorID result = null;
        for (VendorID vendorID : VendorID.values()) {
            if (vendorID.getVenderId() == num){
                result = vendorID;
            }
        }
        return result;
    }

}
