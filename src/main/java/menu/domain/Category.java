package menu.domain;

public enum Category {
    JAPANESE("일식", 1),
    KOREAN("한식", 2),
    CHINESE("중식", 3),
    ASIAN("아시안", 4),
    WESTERN("양식", 5),
    NOTHING("", 0);

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
