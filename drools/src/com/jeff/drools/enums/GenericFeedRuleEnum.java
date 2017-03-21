package com.jeff.drools.enums;

public enum GenericFeedRuleEnum {
    JEFF_RULE(1, "jeff rule", ""),
    RULE1(2,"rule1",""),
    RULE2(3,"rule2","");

    private int id;
    private String name;
    private String desc;

    private GenericFeedRuleEnum(int id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
