package menu.domain;

import java.util.ArrayList;
import java.util.List;

public enum Menu {
    // 일식
    GYUDON(Category.JAPANESE, "규동"),
    UDON(Category.JAPANESE, "우동"),
    MISOSHIRU(Category.JAPANESE, "미소시루"),
    SUSHI(Category.JAPANESE, "스시"),
    KATSUDON(Category.JAPANESE, "가츠동"),
    ONIGIRI(Category.JAPANESE, "오니기리"),
    HAIYARICE(Category.JAPANESE, "하이라이스"),
    RAMEN(Category.JAPANESE, "라멘"),
    OKONOMIYAKI(Category.JAPANESE, "오코노미야끼"),

    // 한식
    GIMBAP(Category.KOREAN, "김밥"),
    KIMCHI_STEW(Category.KOREAN, "김치찌개"),
    SSAMBAP(Category.KOREAN, "쌈밥"),
    DOENJANG_STEW(Category.KOREAN, "된장찌개"),
    BIBIMBAP(Category.KOREAN, "비빔밥"),
    KALGUKSU(Category.KOREAN, "칼국수"),
    BULGOGI(Category.KOREAN, "불고기"),
    TTEOKBOKKI(Category.KOREAN, "떡볶이"),
    JAEYUKBOKKEUM(Category.KOREAN, "제육볶음"),

    // 중식
    KUNGPAO_CHICKEN(Category.CHINESE, "깐풍기"),
    STIR_FRIED_NOODLES(Category.CHINESE, "볶음면"),
    SWEET_AND_SOUR_PORK(Category.CHINESE, "동파육"),
    JAJANGMYEON(Category.CHINESE, "짜장면"),
    JJAMPPONG(Category.CHINESE, "짬뽕"),
    MAPO_TOFU(Category.CHINESE, "마파두부"),
    TANGSUYUK(Category.CHINESE, "탕수육"),
    TOMATO_EGG_STIR_FRY(Category.CHINESE, "토마토 달걀볶음"),
    GOCHUJANG_CHICKEN(Category.CHINESE, "고추잡채"),

    // 아시안
    PAD_THAI(Category.ASIAN, "팟타이"),
    KHAO_PAD(Category.ASIAN, "카오 팟"),
    NASI_GORENG(Category.ASIAN, "나시고렝"),
    PINEAPPLE_FRIED_RICE(Category.ASIAN, "파인애플 볶음밥"),
    PHO(Category.ASIAN, "쌀국수"),
    TOM_YUM_GOONG(Category.ASIAN, "똠얌꿍"),
    BANH_MI(Category.ASIAN, "반미"),
    SUMMER_ROLL(Category.ASIAN, "월남쌈"),
    BUN_CHA(Category.ASIAN, "분짜"),

    // 양식
    LASAGNA(Category.WESTERN, "라자냐"),
    GRATIN(Category.WESTERN, "그라탱"),
    NYOKKI(Category.WESTERN, "뇨끼"),
    QUICHE(Category.WESTERN, "끼슈"),
    FRENCH_TOAST(Category.WESTERN, "프렌치 토스트"),
    BAGUETTE(Category.WESTERN, "바게트"),
    SPAGHETTI(Category.WESTERN, "스파게티"),
    PIZZA(Category.WESTERN, "피자"),
    PANINI(Category.WESTERN, "파니니");

    private final Category category;
    private final String menuName;

    Menu(Category category, String menuName) {
        this.category = category;
        this.menuName = menuName;
    }

    public static List<String> getMenusByCategory(Category targetCategory) {
        List<String> menus = new ArrayList<>();
        for (Menu menu : Menu.values()) {
            if (menu.getCategory() == targetCategory) {
                menus.add(menu.menuName);
            }
        }
        return menus;
    }

    public static boolean contains(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.menuName.equals(menuName)) {
                return true;
            }
        }
        return false;
    }

    public Category getCategory() {
        return category;
    }
}
