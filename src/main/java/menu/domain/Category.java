package menu.domain;

public enum Category {

    KOREAN("한식", 0),
    JAPANESE("일식", 1),
    CHINESE("중식", 2),
    ASIAN("아시안", 3),
    WESTERN("양식", 4),
    NOTHING("", 5);

    private final String categoryName;
    private final int index;

    Category(String categoryName, int index) {
        this.categoryName = categoryName;
        this.index = index;
    }

    public static Category getCategoryByIndex(int index) {
        for (Category category : Category.values()) {
            if (category.index == index) {
                return category;
            }
        }
        return NOTHING;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
