package com.jeff.string.util;

import org.apache.commons.lang.StringUtils;

public class HTML {
    /**
     * 去除所有的 HTML 标签
     * @param inputString
     * @return
     */
    public static String stripHtmlTag(String inputString){
        String outputHTMLString = "";
        if (StringUtils.isNotBlank(inputString)) {
            outputHTMLString = inputString.replaceAll("\\<.*?\\>", "");
        }
        return outputHTMLString;
    }
}
