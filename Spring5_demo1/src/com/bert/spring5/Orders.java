package com.bert.spring5;

public class Orders {
    private String oname;
    private String oaddress;

//    有参构造方法注入属性
    public Orders(String oname, String oaddress) {
        this.oname = oname;
        this.oaddress = oaddress;
    }

    public void testOrders() {
        System.out.println(oname+":"+oaddress);
    }
}
