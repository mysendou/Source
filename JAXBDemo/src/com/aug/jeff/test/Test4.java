package com.aug.jeff.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.aug.jeff.dto.Country;
import com.aug.jeff.dto.Province;
import com.aug.jeff.util.JaxbUtil;

public class Test4 {

    @Test
    public void showMarshaller() {
        Country country = new Country();
        country.setName("中国");

        List<Province> list = new ArrayList<Province>();
        Province province = new Province();
        province.setName("江苏省");
        province.setProvCity("南京市");
        Province province2 = new Province();
        province2.setName("浙江省");
        province2.setProvCity("杭州市");
        list.add(province);
        list.add(province2);

        country.setProvinceList(list);

        String str = JaxbUtil.convertBeanToXml(country);
        System.out.println(str);
    }

    @Test
    public void showUnMarshaller() {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + "<country>" + "    <countryName>中国</countryName>"
                + "    <provinces>" + "        <province>" + "            <name>江苏省</name>" + "           <provCity>南京市</provCity>"
                + "        </province>" + "       <province>" + "           <name>浙江省</name>" + "           <provCity>杭州市</provCity>"
                + "       </province>" + "    </provinces>" + "</country>";
        Country country = JaxbUtil.convertXmlToBean(str, Country.class);
        System.out.println(country);
    }
}
