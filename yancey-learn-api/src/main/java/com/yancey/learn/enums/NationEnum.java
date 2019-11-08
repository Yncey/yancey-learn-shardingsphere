package com.yancey.learn.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 民族枚举类
 *
 * @author yaxuany
 * @date 2019/9/18 11:40
 */
public enum NationEnum {

    HZ1("01", "H", "汉族"),
    MG("02", "M", "蒙古族"),
    HU("03", "H", "回族"),
    ZA("04", "Z", "藏族"),
    UG("05", "W", "维吾尔族"),
    MH("06", "M", "苗族"),
    YI("07", "Y", "彝族"),
    ZH("08", "Z", "壮族"),
    BY("09", "B", "布依族"),
    CS("10", "C", "朝鲜族"),
    MA("11", "M", "满族"),
    DO("12", "D", "侗族"),
    YA("13", "Y", "瑶族"),
    BA("14", "B", "白族"),
    TJ("15", "T", "土家族"),
    HN("16", "H", "哈尼族"),
    KZ("17", "H", "哈萨克族"),
    DA("18", "D", "傣族"),
    LI("19", "L", "黎族"),
    LS("20", "L", "傈僳族"),
    VA("21", "W", "佤族"),
    SH("22", "S", "畲族"),
    GS("23", "G", "高山族"),
    LH("24", "L", "拉祜族"),
    SU("25", "S", "水族"),
    DX("26", "D", "东乡族"),
    NX("27", "N", "纳西族"),
    JP("28", "J", "景颇族"),
    KG("29", "K", "柯尔克孜族"),
    TU("30", "T", "土族"),
    DU("31", "D", "达斡尔族"),
    ML("32", "M", "仫佬族"),
    QI("33", "Q", "羌族"),
    BL("34", "B", "布朗族"),
    SL("35", "S", "撒拉族"),
    MN("36", "M", "毛南族"),
    GL("37", "G", "仡佬族"),
    XB("38", "X", "锡伯族"),
    AC("39", "A", "阿昌族"),
    PM("40", "P", "普米族"),
    TA("41", "T", "塔吉克族"),
    NU("42", "N", "怒族"),
    UZ("43", "W", "乌孜别克族"),
    RS("44", "E", "俄罗斯族"),
    EW("45", "E", "鄂温克族"),
    DE("46", "D", "德昂族"),
    BN("47", "B", "保安族"),
    YG("48", "Y", "裕固族"),
    GI("49", "J", "京族"),
    TT("50", "T", "塔塔尔族"),
    DR("51", "D", "独龙族"),
    OR("52", "E", "鄂伦春族"),
    HZ("53", "H", "赫哲族"),
    MB("54", "M", "门巴族"),
    LB("55", "L", "珞巴族"),
    JN("56", "J", "基诺族"),
    QT("99", "Z", "其他");

    private String code;

    /**
     * 声母
     */
    private String initials;

    private String label;

    NationEnum(String code, String initials, String label) {
        this.code = code;
        this.initials = initials;
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public final static Map<String, NationEnum> CODE_ENUMS = Maps.newHashMapWithExpectedSize(NationEnum.values().length);

    static {
        for (NationEnum c : NationEnum.values()) {
            CODE_ENUMS.put(c.getCode(), c);
        }
    }

    public static NationEnum codeOf(String code) {
        return CODE_ENUMS.get(code);
    }

    @Override
    public String toString() {
        return "NationEnum{" +
                "code='" + code + '\'' +
                ", initials='" + initials + '\'' +
                ", label='" + label + '\'' +
                '}';
    }
}
