class FoodItem {
    int items;
    int quantity;
    float price;

    FoodItem(int items, int quantity) { 
        this.items = items;
        this.quantity = quantity;
        switch (items) {
            case 1:
                price = quantity * 50;
                break;
            case 2:
                price = quantity * 60;
                break;
            case 3:
                price = quantity * 70;
                break;
            case 4:
                price = quantity * 30;

                break;
            case 5:
                price = quantity * 15;
                break;

                case 6:
                price = quantity *290;
            
            
        }
    }
}

