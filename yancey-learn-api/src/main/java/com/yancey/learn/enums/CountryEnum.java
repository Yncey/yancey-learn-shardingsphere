package com.yancey.learn.enums;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 国籍枚举类
 *
 * @author yaxuany
 * @date 2019/9/18 11:44
 */
public enum CountryEnum {

    MT("470", "马耳他", "MALTA", "马耳他共和国 Republic of Malta", "MT", "MLT"),
    PA("591", "巴拿马", "PANAMA", "巴拿马共和国 Republic of Panama", "PA", "PAN"),
    ET("231", "埃塞俄比亚", "ETHIOPIA", "埃塞俄比亚 Ethiopia", "ET", "ETH"),
    IS("352", "冰岛", "ICELAND", "冰岛共和国 Republic of Iceland", "IS", "ISL"),
    ER("232", "厄立特里亚", "ERITREA", "厄立特里亚国 State of Eritrea", "ER", "ERI"),
    MQ("474", "马提尼克", "MARTINIQUE", "马提尼克 Martinique", "MQ", "MTQ"),
    BY("112", "白俄罗斯", "BELARUS", "白俄罗斯共和国 Republic of Belarus", "BY", "BLR"),
    EE("233", "爱沙尼亚", "ESTONIA", "爱沙尼亚共和国 Republic of Estonia", "EE", "EST"),
    FO("234", "法罗群岛", "FAROE ISLANDS", "法罗群岛 Faroe Islands", "FO", "FRO"),
    IN("356", "印度", "INDIA", "印度共和国 Republic of India", "IN", "IND"),
    PG("598", "巴布亚新几内亚", "PAPUA NEW GUINEA", "巴布亚新几内亚独立国 Independent State of Papua New Guinea", "PG", "PNG"),
    MR("478", "毛里塔尼亚", "MAURITANIA", "毛里求斯共和国 Republic of Mauritius", "MR", "MRT"),
    KH("116", "柬埔寨", "CAMBODIA", "柬埔寨王国 Kingdom of Cambodia", "KH", "KHM"),
    FK("238", "福克兰群岛(马尔维纳斯)", "FALKLAND ISLANDS(MALVINAS)", "福克兰群岛(马尔维纳斯) Falkland Islands(Malvinas)", "FK", "FLK"),
    GS("239", "南乔治亚岛和南桑德韦奇岛", "SOUTH GEORGIA AND SOUTH SANDWICH ISLANDS", "南乔治亚岛和南桑德韦奇岛 South Georgia and South Sandwich Islands", "GS", "SGS"),
    MU("480", "毛里求斯", "MAURITIUS", "毛里求斯共和国 Republic of Mauritius", "MU", "MUS"),
    ID("360", "印度尼西亚", "INDONESIA", "印度尼西亚共和国 Republic of Indonesia", "ID", "IDN"),
    CM("120", "喀麦隆", "CAMEROON", "喀麦隆共和国 Republic of Cameroon", "CM", "CMR"),
    FJ("242", "斐济", "FIJI", "斐济共和国 Republic of Fiji", "FJ", "FJI"),
    MX("484", "墨西哥", "MEXICO", "墨西哥合众国 United States of Mexico", "MX", "MEX"),
    IR("364", "伊朗", "IRAN", "伊朗伊斯兰共和国 Islamic Rupublic of Iran", "IR", "IRN"),
    CA("124", "加拿大", "CANADA", "加拿大 Canada", "CA", "CAN"),
    AF("004", "阿富汗", "AFGHANISTAN", "阿富汗伊斯兰国 Islamic State of Afghanistan", "AF", "AFG"),
    FI("246", "芬兰", "FINLAND", "芬兰共和国 Republic of Finland", "FI", "FIN"),
    IQ("368", "伊拉克", "IRAQ", "伊拉克共和国 Republic of Iraq", "IQ", "IRQ"),
    AL("008", "阿尔巴尼亚", "ALBANIA", "阿尔马尼亚共和国 Republic of Albania", "AL", "ALB"),
    UG("800", "乌干达", "UGANDA", "乌干达共和国 Republic of Uganda", "UG", "UGA"),
    UA("804", "乌克兰", "UKRAINE", "乌克兰 Ukraine", "UA", "UKR"),
    MK("807", "前南马其顿", "MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF", "前南斯拉夫马其顿共和国 The Former Yugoslav Republic of Macedonia", "MK", "MKD"),
    FR("250", "法国", "FRANCE", "法兰西共和国 French Republic", "FR", "FRA"),
    MC("492", "摩纳哥", "MONACO", "摩纳哥公国 Principality of Monaco", "MC", "MCO"),
    IE("372", "爱尔兰", "IRELAND", "爱尔兰 Ireland", "IE", "IRL"),
    AQ("010", "南极洲", "ANTARCTICA", "南极洲 Antarctica", "AQ", "ATA"),
    CV("132", "佛得角", "CAPE VERDE", "佛得角共和国 Republic of Cape Verde", "CV", "CPV"),
    PS("374", "巴勒斯坦", "PALESTINE", "巴勒斯坦国 State of Palestine", "PS", "PST"),
    DZ("012", "阿尔及利亚", "ALGERIA", "阿尔及利亚民主人民共和国 Democratic People's Republic of Algeria", "DZ", "DZA"),
    GF("254", "法属圭亚那", "FRENCH GUIANA", "法属圭亚那 French Guiana", "GF", "GUF"),
    MN("496", "蒙古", "MONGOLIA", "蒙古国 Mongolia", "MN", "MNG"),
    IL("376", "以色列", "ISRAEL", "以色列国 State of Israel", "IL", "ISR"),
    MD("498", "摩尔多瓦", "MOLDOVA", "摩尔多瓦共和国 Republic of Moldova", "MD", "MDA"),
    KY("136", "开曼群岛", "CAYMAN ISLANDS", "开曼群岛 Cayman Islands", "KY", "CYM"),
    AS("016", "美属萨摩亚", "AMERICAN SAMOA", "美属萨摩亚 American Samoa", "AS", "ASM"),
    PF("258", "法属波利尼西亚", "FRENCH POLYNESIA", "法属波利尼西亚 French Polynesia", "PF", "PYF"),
    EG("818", "埃及", "EGYPT", "阿拉伯埃及共和国 Arab Republic of Egypt", "EG", "EGY"),
    IT("380", "意大利", "ITALY", "意大利共和国 Republic of Italy", "IT", "ITA"),
    TF("260", "法属南部领土", "FRENCH SOUTHERN TERRITO-RIES", "法属南部领土 French Southern Territories", "TF", "ATF"),
    CF("140", "中非", "CENTRAL AFRICA", "中非共和国 Central African Republic", "CF", "CAF"),
    AD("020", "安道尔", "ANDORRA", "安道尔公国 Principality of Andorra", "AD", "AND"),
    DJ("262", "吉布提", "DJIBOUTI", "吉布提共和国 Republic of Djibouti", "DJ", "DJI"),
    CI("384", "科特迪瓦", "COTE D'IVOIRE", "科特迪瓦共和国 Republic of Cote d'Ivire", "CI", "CIV"),
    LK("144", "斯里兰卡", "SRI LANKA", "斯里兰卡民主社会主义共和国 Democratic Socialist Republic of Srilanka", "LK", "LKA"),
    AO("024", "安哥拉", "ANGOLA", "安哥拉共和国 Republic of Angola", "AO", "AGO"),
    GA("266", "加蓬", "GABON", "加蓬共和国 Gabonese Republic", "GA", "GAB"),
    JM("388", "牙买加", "JAMAICA", "牙买加 Jamaica", "JM", "JAM"),
    GE("268", "格鲁吉亚", "GEORGIA", "格鲁吉亚共和国 Republic of Georgia", "GE", "GEO"),
    TD("148", "乍得", "CHAD", "乍得共和国 Republic of Chad", "TD", "TCD"),
    AG("028", "安提瓜和巴布达", "ANTIGUA AND BARBUDA", "安提瓜和巴布达 Antigua and Barbuda", "AG", "ATG"),
    SG("702", "新加坡", "SINGAPORE", "新加坡共和国 Republic of Singapore", "SG", "SGP"),
    SK("703", "斯洛伐克", "SLOVAKIA", "斯洛伐克共和国 Slovak Republic", "SK", "SVK"),
    VN("704", "越南", "VIET NAM", "越南社会主席共和国 Socialist Republic of Viet Nam", "VN", "VNM"),
    SI("705", "斯洛文尼亚", "SLOVENIA", "斯洛文尼亚共和国 Republic of Slovenia", "SI", "SVN"),
    GB("826", "英国", "UNITED KINGDOM", "大不列颠及北爱尔兰联合王国 United Kingdom of Great Britain and Northern ireland", "GB", "GBR"),
    SO("706", "索马里", "SOMALIA", "索马里共和国 Somali Republic", "SO", "SOM"),
    GM("270", "冈比亚Gambia", "", "冈比亚共和国 Republic of Gambia", "GM", "GMB"),
    JP("392", "日本", "JAPAN", "日本国 Japan", "JP", "JPN"),
    AZ("031", "阿塞拜疆", "AZERBAIJAN", "阿塞拜疆共和国 Republic of Azerbaijan", "AZ", "AZE"),
    CL("152", "智利", "CHILE", "智利共和国 Republic of Chile", "CL", "CHL"),
    AR("032", "阿根廷", "ARGENTINA", "阿根廷共和国 Republic of Argentina", "AR", "ARG"),
    DE("276", "德国", "GERMANY", "德意志联邦共和国 Federal Republic of Germany", "DE", "DEU"),
    CN("156", "中国", "CHINA", "中华人民共和国 People's Republic of China", "CN", "CHN"),
    KZ("398", "哈萨克斯坦", "KAZAKHSTAN", "哈萨克斯坦共和国 Republic of Kazakhstan", "KZ", "KAZ"),
    AU("036", "澳大利亚", "AUSTRALIA", "澳大利亚联邦 Commonwealth of Australia", "AU", "AUS"),
    TW("158", "台湾", "TAIWAN, PROVINCE OF CHINA", "中国台湾 Taiwan, Province of China", "TW", "TWN"),
    ZA("710", "南非", "SOUTH AFRICA", "南非共和国 Republic of South Africa", "ZA", "ZAF"),
    TZ("834", "坦桑尼亚", "TANZANIA", "坦桑尼亚联合共和国 United Republic of Tanzania", "TZ", "TZA"),
    ZW("716", "津巴布韦", "ZIMBABWE", "津巴布韦共和国 Republic of Zimbabwe", "ZW", "ZWE"),
    AT("040", "奥地利", "AUSTRIA", "奥地利共和国 Republic of Austria", "AT", "AUT"),
    CS("162", "圣诞岛", "CHRISTMAS ISLAND", "圣诞岛 Christmas Island", "CS", "CSR"),
    BS("044", "巴哈马", "BAHAMAS", "巴哈马联邦 Commonwealth of the Bahamas", "BS", "BHS"),
    CC("166", "科科斯(基林)群岛", "COCOS(KEELING) ISLANDS", "科科斯(基林)群岛 Cocos(Keeling) Islands", "CC", "CCK"),
    GH("288", "加纳", "GHANA", "加纳共和国 Republic of Ghana", "GH", "GHA"),
    BH("048", "巴林", "BAHRAIN", "巴林国 State of Bahrain", "BH", "BHR"),
    US("840", "美国", "UNITED STATES", "美利坚合众国 United States of America", "US", "USA"),
    PY("600", "巴拉圭", "PARAGUAY", "巴拉圭共和国 Republic of Paraguay", "PY", "PRY"),
    ES("724", "西班牙", "SPAIN", "西班牙 Spain", "ES", "ESP"),
    PE("604", "秘鲁", "PERU", "秘鲁共和国 Republic of Peru", "PE", "PER"),
    PH("608", "菲律宾", "PHILIPPINES", "菲律宾共和国 Republic of the Philippines", "PH", "PHL"),
    CO("170", "哥伦比亚", "COLOMBIA", "哥伦比亚共和国 Republic of Colombia", "CO", "COL"),
    BD("050", "孟加拉国", "BANGLADESH", "孟加拉人民共和国 People's Republic of Bangladesh", "BD", "BGD"),
    GI("292", "直布罗陀", "GIBRALTAR", "直布罗陀 Gibraltar", "GI", "GIB"),
    AM("051", "亚美尼亚", "ARMENIA", "亚美尼亚共和国 Republic of Armenia", "AM", "ARM"),
    BB("052", "巴巴多斯", "BARBADOS", "巴巴多斯 Barbados", "BB", "BRB"),
    KM("174", "科摩罗", "COMOROS", "科摩罗伊斯兰联邦共和国 Federal Islamic Republic of the Co-moros", "KM", "COM"),
    KI("296", "基里巴斯", "KIRIBATI", "基里巴斯共和国 Republic of Kiribati", "KI", "KIR"),
    YT("175", "马约特", "MAYOTTE", "马约特 Mayotte", "YT", "MYT"),
    BE("056", "比利时", "BELGIUM", "比利时王国 Kingdom of belgium", "BE", "BEL"),
    CG("178", "刚果（布）", "CONGO", "刚果共和国 Republic of Congo", "CG", "COG"),
    VI("850", "美属维尔京群岛", "VIRGIN ISLANDS,U.S.", "美属维尔京群岛 Virgin Islands of the United States", "VI", "VIR"),
    EH("732", "西撒哈拉", "WESTERN SAHARA", "西撒哈拉 Western Sahara", "EH", "ESH"),
    BF("854", "布基纳法索", "BURKINA FASO", "布基纳法索 Burkina Faso", "BF", "BFA"),
    PN("612", "皮特凯恩群岛", "PITCAIRN ISLANDS GROUP", "皮竺凯恩群岛 Pitcairn Islands Group", "PN", "PCN"),
    SD("736", "苏丹", "SUDAN", "苏丹共和国 Republic of the Sudan", "SD", "SDN"),
    PL("616", "波兰", "POLAND", "波兰共和国 Republic of Poland", "PL", "POL"),
    UY("858", "乌拉圭", "URUGUAY", "乌拉圭东岸共和国 Oriental Republic of Uruguay", "UY", "URY"),
    CD("180", "刚果（金）", "CONGO, THE DEMOCRATIC REPUBLIC OF THE", "刚果民主共和国 Democratic Republic of Congo", "CD", "COD"),
    BM("060", "百慕大", "BERMUDA", "百慕大群岛 Bermuda Islands", "BM", "BMU"),
    CK("184", "库克群岛", "COOK ISLANDS", "库克群岛 Cook Islands", "CK", "COK"),
    BT("064", "不丹", "BHUTAN", "不丹王国 Kingdom of Bhutan", "BT", "BTN"),
    CR("188", "哥斯达黎加", "COSTA RICA", "哥斯达黎加共和国 Republic of Costa Rica", "CR", "CR"),
    BO("068", "玻利维亚", "BOLIVIA", "玻利维亚共和国 Republic of Bolivia", "BO", "BOL"),
    UZ("860", "乌兹别克斯坦", "UZBEKISTAN", "乌兹别克斯坦共和国 Republic of Uzbekistan", "UZ", "UZB"),
    SR("740", "苏里南", "SURINAME", "苏里南共和国 Republic of Suriname", "SR", "SUR"),
    PT("620", "葡萄牙", "PORTUGAL", "葡萄牙共和国 Pirtuguese Republic", "PT", "PRT"),
    VE("862", "委内瑞拉", "VENEZUELA", "委内瑞拉共和国 Republic of Venezuela", "VE", "VEN"),
    MS("500", "蒙特塞拉特", "MONTSERRAT", "蒙特塞拉特 Montserrat", "MS", "MSR"),
    SJ("744", "斯瓦尔巴群岛", "SVALBARD AND JAN MAYEN ISLANDS", "斯瓦尔巴群岛 Svalbard and Jan mayen islands", "SJ", "SJM"),
    GW("624", "几内亚比绍", "GUINE-BISSAU", "几内亚比绍共和国 Republic of Guine-bissau", "GW", "GNB"),
    MA("504", "摩洛哥", "MOROCCO", "摩洛哥王国 Kingdom of Morocco", "MA", "MAR"),
    TP("626", "东帝汶", "EAST TIMOR", "东帝汶 East Timor", "TP", "TMP"),
    SZ("748", "斯威士兰", "SWAZILAND", "斯威士兰王国 Kingdom of Swaziland", "SZ", "SWZ"),
    MZ("508", "莫桑比克", "MOZAMBIQUE", "莫桑比克共和国 Republic of Mozambique", "MZ", "MOZ"),
    BA("070", "波黑", "BOSNIA AND HERZEGOVINA", "波斯尼亚和黑塞哥维那 Bosnia and Herzegovina", "BA", "BIH"),
    HR("191", "克罗地亚", "CROATIA", "克罗地亚共和国 Republic of Croatia", "HR", "HRV"),
    CU("192", "古巴", "CUBA", "古巴共和国 Republic of Cuba", "CU", "CUB"),
    BW("072", "博茨瓦纳", "BOTSWANA", "博茨瓦纳共和国 Republic of Botswana", "BW", "BWA"),
    BV("074", "布维岛", "BOUVET ISLAND", "布维岛 Bouvet Island", "BV", "BVT"),
    CY("196", "塞浦路斯", "CYPRUS", "塞浦路斯共和国 Republic of Cyprus", "CY", "CYP"),
    BR("076", "巴西", "BRAZIL", "巴西联邦共和国 Federative Republic of Brazil", "BR", "BRA"),
    PR("630", "波多黎各", "PUERTO RICO", "波多黎各自由联邦 Commonwealth of Puerto Rico", "PR", "PRI"),
    SE("752", "瑞典", "SWEDEN", "瑞典王国 Kingdom of Sweden", "SE", "SWE"),
    OM("512", "阿曼", "OMAN", "阿曼苏丹国 Sultanate of Oman", "OM", "OMN"),
    QA("634", "卡塔尔", "QATAR", "卡塔尔国 State of Qatar", "QA", "QAT"),
    WF("876", "瓦利斯和富图纳", "WALLIS AND FUTUNA", "瓦利斯和富图纳群岛 Wallis and Futuna", "WF", "WLF"),
    CH("756", "瑞士", "SWITZERLAND", "瑞士联邦 Swiss Confederation", "CH", "CHE"),
    NA("516", "纳米比亚", "NAMIBIA", "纳米比亚共和国 Republic of Namibia", "NA", "NAM"),
    RE("638", "留尼汪", "REUNION", "留尼汪 Reunion", "RE", "REU"),
    BZ("084", "伯利兹", "BELIZE", "伯利兹 Belize", "BZ", "BLZ"),
    IO("086", "英属印度洋领土", "BRITISH INDIAN OCEAN TER-RITORY", "英属印度洋领土 British Indian Ocean Territory", "IO", "IOT"),
    SY("760", "叙利亚", "SYRIA", "阿拉伯叙利亚共和国 Syrian Arab Republic", "SY", "SYR"),
    WS("882", "萨摩亚", "SAMOA", "萨摩亚独立国 Independent State of Samoa", "WS", "WSM"),
    NR("520", "瑙鲁", "NAURU", "瑙鲁共和国 Republic of Nauru", "NR", "NRU"),
    TJ("762", "塔吉克斯坦", "TAJIKISTAN", "塔吉克斯坦共和国 Republic of Tajikistan", "TJ", "TJK"),
    JO("400", "约旦", "JORDAN", "约旦哈希姆王国 Hashemite Kingdom of Jordan", "JO", "JOR"),
    RO("642", "罗马尼亚", "ROMANIA", "罗马尼亚 Romania", "RO", "ROM"),
    RU("643", "俄罗斯联邦", "RUSSIAN FEDERATION", "俄罗斯联邦 Russian Federation", "RU", "RUS"),
    TH("764", "泰国", "THAILAND", "泰王国 Kingdom of Thailand", "TH", "THA"),
    NP("524", "尼泊尔", "NEPAL", "尼泊尔王国 Kingdom of Nepal", "NP", "NPL"),
    YE("887", "也门", "YEMEN", "也门共和国 Republic of Yemen", "YE", "YEM"),
    KE("404", "肯尼亚", "KENYA", "肯尼亚共和国 Republic of Kenya", "KE", "KEN"),
    RW("646", "卢旺达", "RWANDA", "卢旺达共和国 Republic of Rwanda", "RW", "RWA"),
    TG("768", "多哥", "TOGO", "多哥共和国 Republic of Tago", "TG", "TGO"),
    NL("528", "荷兰", "NETHERLANDS", "荷兰王国 Kingdom of the Netherlands", "NL", "NLD"),
    KP("408", "朝鲜", "KOREA,DEMOCRATIC PEOPLE'S REPUBLIC OF", "朝鲜民主主义人民共和国 Democratic People's Republic of Ko-rea", "KP", "PRK"),
    SB("090", "所罗门群岛", "SOLOMON ISLANDS", "年罗门群岛 Solomon Islands", "SB", "SLB"),
    VG("092", "英属维尔京群岛", "VIRGIN ISLANDS, BRITISH ", "英属维尔京群岛 British Virgin Islands", "VG", "VGB"),
    BN("096", "文莱", "BRUNEI DARUSSALAM", "文莱达鲁萨兰国 Brunei Darussalam", "BN", "BRN"),
    YU("891", "南斯拉夫", "YUGOSLAVIA", "南斯拉夫联盟共和国 Federal Republic of Yugoslavia", "YU", "YUG"),
    AN("530", "荷属安的列斯", "NETHERLANDS ANTILLES", "荷属安的列斯 Netherlands Antilles", "AN", "ANT"),
    TK("772", "托克劳", "TOKELAU", "托克劳 Tokelau", "TK", "TKL"),
    KR("410", "韩国", "KOREA,REPUBLIC OF", "大韩民国 Republic of Korea", "KR", "KOR"),
    ZM("894", "赞比亚", "ZAMBIA", "赞比亚共和国 Republic of Zambia", "ZM", "ZMB"),
    AW("533", "阿鲁巴", "ARUBA", "阿鲁巴 Aruba", "AW", "ABW"),
    SH("654", "圣赫勒拿", "SAINT HELENA", "对赫勒拿 Saint Helena", "SH", "SHN"),
    TO("776", "汤加", "TONGA", "汤加王国 Kingdom of Tonga", "TO", "TON"),
    KW("414", "科威特", "KUWAIT", "科威特国 State of Kuwait", "KW", "KWT"),
    KG("417", "吉尔吉斯斯坦", "KYRGYZSTAN", "吉尔吉斯共和国 Kyrgyz Republic", "KG", "KGZ"),
    KN("659", "圣基茨和尼维斯", "SAINT KITTS AND NEVIS", "圣革茨和尼维斯联邦 Federation of Saint Kitts and nevis", "KN", "KNA"),
    LA("418", "老挝", "LAOS", "老挝人民民主共和国 Lao People's Democratic Republic", "LA", "LAO"),
    TT("780", "特立尼达和多巴哥", "TRINIDAD AND TOBAGO", "特立尼达和多巴哥共和国 Republic of Trinidad and Tobago", "TT", "TTO"),
    AI("660", "安圭拉", "ANGUILLA", "安圭拉 Anguilla", "AI", "AIA"),
    NC("540", "新喀里多尼亚", "NEW CALEDONIA", "新喀里多尼亚 New Caledonia", "NC", "NCL"),
    LC("662", "圣卢西亚", "SAINT LUCIA", "圣卢西亚 Saint Lucia", "LC", "LCA"),
    GR("300", "希腊", "GREECE", "希腊共和国 Hellenic Republic", "GR", "GRC"),
    AE("784", "阿联酋", "UNITED ARAB EMIRATES", "拉伯联合酋长国 United Arab Emirates", "AE", "ARE"),
    LB("422", "黎巴嫩", "LEBANON", "黎巴嫩共和国 Republic of Lebanon", "LB", "LBN"),
    PM("666", "圣皮埃尔和密克隆", "SAINT PIERRE AND MIQUELON", "圣皮埃尔和密克隆 Saint Pierre and Miquelon", "PM", "SPM"),
    GL("304", "格陵兰", "GREENLAND", "格陵兰 Greenland", "GL", "GRL"),
    TN("788", "突尼斯", "TUNISIA", "突尼斯共和国 Republic of Tunisia", "TN", "TUN"),
    LS("426", "莱索托", "LESOTHO", "莱索托王国 Kingdom of Lesoto", "LS", "LSO"),
    VU("548", "瓦努阿图", "VANUATU", "瓦努阿图共和国 Republic of Vanuatu", "VU", "VUT"),
    LV("428", "拉脱维亚", "LATVIA", "拉脱维亚共和国 Republic of Latvia", "LV", "LVA"),
    GD("308", "格林纳达", "GRENADA", "格林纳达 Grenada", "GD", "GRD"),
    VC("670", "圣文森特和格林纳丁斯", "SAINT VINCENT AND THE GRENADINES", "圣文森特和格林纳丁斯 Saint Vincent and the Grenadines", "VC", "VCT"),
    TR("792", "土耳其", "TURKEY", "土耳其共和国 Republic of Turkey", "TR", "TUR"),
    LR("430", "利比里亚", "LIBERIA", "利比里亚共和国 Republic of Liberia", "LR", "LBR"),
    SM("674", "圣马力诺", "SAN MARION", "圣马力诺共和国 Republic of San Marino", "SM", "SMR"),
    TM("795", "土库曼斯坦", "TURKMENISTAN", "土库曼斯坦 Turkmenistan", "TM", "TKM"),
    GP("312", "瓜德罗普", "GUADELOUPE", "瓜德罗普 Guadeloupe", "GP", "GLP"),
    NZ("554", "新西兰", "NEW ZEALAND", "新西兰 New Zealand", "NZ", "NZL"),
    TC("796", "特克斯科斯群岛", "TURKS AND CAICOS ISLANDS", "特克斯和凯科斯群岛 Turks and Caicos Islands", "TC", "TCA"),
    LY("434", "利比亚", "LIBYA", "大阿拉伯利比亚人民社会主义民众国 Great Socialist People's Libyan Arab jamahiriya", "LY", "LBY"),
    TV("798", "图瓦卢", "TUVALU", "图瓦卢 Tuvalu", "TV", "TUV"),
    ST("678", "圣多美和普林西比", "SAO TOME AND PRINCIPE", "圣多美和普林西比民主共和国 Democratic Republic of Sao Tome and Principe", "ST", "STP"),
    GU("316", "关岛", "GUAM", "关岛 Guam", "GU", "GUM"),
    NI("558", "尼加拉瓜", "NICARAGUA", "尼加拉瓜共和国 Republic of Nicaragua", "NI", "NIC"),
    LI("438", "列支敦士登", "LIECHTENSTEIN", "列支敦士登公国 Principality of Liechtenstein", "LI", "LIE"),
    LT("440", "立陶宛", "LITHUANIA", "立陶宛共和国 Republic of Lithuania", "LT", "LTU"),
    SA("682", "沙特阿拉伯", "SAUDI ARABIA", "沙特阿拉伯王国 Kingdom of Saudi Arabia", "SA", "SAU"),
    GT("320", "危地马拉", "GUATEMALA", "危地马拉共和国 Republic of Guatemala", "GT", "GTM"),
    NE("562", "尼日尔", "NIGER", "尼日尔共和国 Republic of Niger", "NE", "NER"),
    LU("442", "卢森堡", "LUXEMBOURG", "卢森堡大公国 Grand Duchy of Luxembourg", "LU", "LUX"),
    SN("686", "塞内加尔", "SENEGAL", "塞内加尔共和国 Republic of Senegal", "SN", "SEN"),
    CZ("203", "捷克", "CZECH REPOUBLIC", "捷克共和国 Czech Republic", "CZ", "CZE"),
    GN("324", "几内亚", "GUINEA", "几内亚共和国 Republic of Guinea", "GN", "GIN"),
    NG("566", "尼日利亚", "NIGERIA", "尼日利亚联邦共和国 Federal Republic of Nigeria", "NG", "NGA"),
    BJ("204", "贝宁", "BENIN", "贝宁共和国 Republic of Benin", "BJ", "BEN"),
    MO("446", "澳门", "MACAU", "澳门 Macau", "MO", "MAC"),
    GY("328", "圭亚那", "GUYANA", "圭亚那合作共和国 Cooperative Republic of Guyana", "GY", "GUY"),
    DK("208", "丹麦", "DENMARK", "丹麦王国 Kingdom of Denmark", "DK", "DNK"),
    SC("690", "塞舌尔", "SEYCHELLS", "塞舌尔共和国 Republic of Seychelles", "SC", "SYC"),
    NU("570", "纽埃", "NIUE", "纽埃 Niue", "NU", "NIU"),
    MG("450", "马达加斯加", "MADAGASCAR", "马达加斯加共和国 Republic of Madagascar", "MG", "MDG"),
    SL("694", "塞拉利昂", "SIERRA LEONE", "塞拉利昂共和国 Republic of Sierra Leone", "SL", "SLE"),
    HT("332", "海地", "HAITI", "海地共和国 Republic of Haiti", "HT", "HTI"),
    NF("574", "诺福克岛", "NORFOLK ISLAND", "诺福克岛 Norfolk Island", "NF", "NFK"),
    DM("212", "多米尼克", "DOMINICA", "多米尼克联邦 Commonwealth of Dominica", "DM", "DMA"),
    MW("454", "马拉维", "MALAWI", "马拉维共和国 Republic of Malawi", "MW", "MWI"),
    HM("334", "赫德岛和麦克唐纳岛", "HEARD ISLANDS AND MC DONALD ISLANDS", "赫德岛和麦克唐纳岛 Heard islands and Mc Donald Islands", "HM", "HMD"),
    DO("214", "多米尼加共和国", "DOMINICAN REPUBLIC", "多米尼加共和国 Dominican Republic", "DO", "DOM"),
    NO("578", "挪威", "NORWAY", "挪威王国 Kingdom of Norway", "NO", "NOR"),
    VA("336", "梵蒂冈", "VATICAN", "梵蒂冈城国 Vatican City State", "VA", "VAT"),
    MY("458", "马来西亚", "MALAYSIA", "马来西亚 Malaysia", "MY", "MYS"),
    EC("218", "厄瓜多尔", "ECUADOR", "厄瓜多尔共和国 Republic of Ecuador", "EC", "ECU"),
    MP("580", "北马里亚纳", "NORTHERN MARIANAS", "北马里亚纳自由联邦 Commonwealth of the Northern Marianas", "MP", "MNP"),
    UM("581", "美国本土外小岛屿", "UNITED STATES MINOR OUTLYING ISLANDS", "美国本土外小岛屿 United States Minor Outlying Islands", "UM", "UMI"),
    HN("340", "洪都拉斯", "HONDURAS", "洪都拉斯共和国 Republic of honduras", "HN", "HND"),
    MV("462", "马尔代夫", "MALDIVES", "马尔代夫共和国 Republic of maldives", "MV", "MDV"),
    FM("583", "密克罗尼西亚联邦", "MICRONESIA, FEDERATED STATES OF", "密克罗尼西亚联邦 Federated States of Micronesia", "FM", "FSM"),
    BG("100", "保加利亚", "BULGARIA", "保加利亚共和国 Republic ov Bulgaria", "BG", "BGR"),
    MH("584", "马绍尔群岛", "MARSHALL ISLANDS", "马绍尔群岛共和国 Republic of the marshall Islands", "MH", "MHL"),
    SV("222", "萨尔瓦多", "EL SALVADOR", "萨尔瓦多共和国 Republic of El Salvador", "SV", "SLV"),
    PW("585", "帕劳", "PALAU", "帕劳共和国 Republic of Palau", "PW", "PLW"),
    HK("344", "香港", "HONG KONG", "香港 Hong Kong", "HK", "HKG"),
    PK("586", "巴基斯坦", "PAKISTAN", "巴基斯坦伊斯兰共和国 Islamic Republic of Pakistan", "PK", "PAK"),
    ML("466", "马里", "MALI", "马里共和国 Republic of Mali", "ML", "MLI"),
    MM("104", "缅甸", "MYANMAR", "缅甸联邦 Union of Myanmar", "MM", "MMR"),
    GQ("226", "赤道几内亚", "EQUATORIAL GUINEA", "赤道几内亚共和国 Republic of Equatorial Guinea", "GQ", "GNQ"),
    HU("348", "匈牙利", "HUNGARY", "匈牙利共和国 Republic of Hungary", "HU", "HUN"),
    BI("108", "布隆迪", "BURUNDI", "布隆迪共和国 Republic of Burundi", "BI", "BDI");

    private String code;

    private String chinese_name;

    private String english_name;

    private String full_name;

    private String two_letter_code;

    private String three_letter_code;

    CountryEnum(String code, String chinese_name, String english_name, String full_name
            , String two_letter_code, String three_letter_code) {
        this.code = code;
        this.chinese_name = chinese_name;
        this.english_name = english_name;
        this.full_name = full_name;
        this.two_letter_code = two_letter_code;
        this.three_letter_code = three_letter_code;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getChinese_name() {
        return chinese_name;
    }

    public void setChinese_name(String chinese_name) {
        this.chinese_name = chinese_name;
    }

    public String getEnglish_name() {
        return english_name;
    }

    public void setEnglish_name(String english_name) {
        this.english_name = english_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getTwo_letter_code() {
        return two_letter_code.toUpperCase();
    }

    public void setTwo_letter_code(String two_letter_code) {
        this.two_letter_code = two_letter_code;
    }

    public String getThree_letter_code() {
        return three_letter_code.toUpperCase();
    }

    public void setThree_letter_code(String three_letter_code) {
        this.three_letter_code = three_letter_code;
    }

    public final static Map<String, CountryEnum> CODE_ENUMS = Maps.newHashMapWithExpectedSize(CountryEnum.values().length);

    public final static Map<String, CountryEnum> THREE_CODE_ENUMS = Maps.newHashMapWithExpectedSize(CountryEnum.values().length);

    static {
        for (CountryEnum c : CountryEnum.values()) {
            CODE_ENUMS.put(c.getCode(), c);
            THREE_CODE_ENUMS.put(c.three_letter_code, c);
        }
    }

    public static CountryEnum codeOf(String code) {
        return CODE_ENUMS.get(code);
    }

    public static CountryEnum threeCodeOf(String threeCode) {
        if (Strings.isNullOrEmpty(threeCode)) {
            return null;
        }
        return THREE_CODE_ENUMS.get(threeCode.toUpperCase());
    }

    @Override
    public String toString() {
        return "CountryEnum{" +
                "code='" + code + '\'' +
                ", chinese_name='" + chinese_name + '\'' +
                ", english_name='" + english_name + '\'' +
                ", full_name='" + full_name + '\'' +
                ", two_letter_code='" + two_letter_code + '\'' +
                ", three_letter_code='" + three_letter_code + '\'' +
                '}';
    }
}
