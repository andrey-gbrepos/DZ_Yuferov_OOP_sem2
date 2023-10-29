import java.util.Deque;


public class Market {
    private boolean goodsAvailab;  // факт наличия товаров
    private Double costAllgoods; //цена всех товаров в магазине
    public Market(Double costAllgoods) {
        this.costAllgoods = costAllgoods;
        this.goodsAvailab = true;
    }
    public Market() {
        this.costAllgoods = 100000.0;
    }
    protected void printNotEnaughMany(Double many) {
            System.out.println();    
            System.out.print("Недостаточно денег у покупателя. Удален из очереди. Возврат товара на сумму: ");
            System.out.printf( "%.2f", many);
            System.out.println();
            System.out.println();
    }

    protected void printPay(Double pay){
            System.out.println();
            System.out.print("Оплата: "); 
            System.out.printf("%.2f", pay);
            System.out.println();   
    }

    protected void printDelay(){
            System.out.println("Отсутствует кассир");
    }
    
    public void marketBehaviour(Deque<Double>buyerCost, double cost, Double buyerMany, boolean kassir){
    if (goodsAvailab){
        if (cost > 0.0) buyerCost.addLast(cost); 
        if (!kassir) {
            printDelay();
        } else {      
            if(buyerCost.getFirst() > buyerMany) {
                update(0.0, buyerCost.getFirst());
                printNotEnaughMany(buyerCost.getFirst());
                buyerCost.removeFirst();
            } else {
                printPay(buyerCost.getFirst());  
                buyerCost.removeFirst();
            }  
            }
        } else {
        if(!goodsAvailab && costAllgoods != 0.0) {
            buyerCost.addLast(costAllgoods);
            costAllgoods = 0.0;
        }else {
            if (!goodsAvailab)
            printPay(buyerCost.getFirst()); 
            buyerCost.removeFirst();  
            }
        }
        }
        

    // cost - Покупка, addGoods - поступление в магазин (Возврат)
    public Double update(Double cost,  Double addGoods){
        if (addGoods > 0) costAllgoods = costAllgoods + addGoods;
        if (costAllgoods >= cost) {

            goodsAvailab = true;
            return costAllgoods = costAllgoods-cost;
        }
        else {
            System.out.println(" Товары в магазине закончились..");
            goodsAvailab = false;
            
            return costAllgoods;
        }
    }

    public void setCostAllgoods(Double costAllgoods) {
        this.costAllgoods = costAllgoods;
    }

    public Double getCostAllgoods() {
        return costAllgoods;
    }
    public boolean isGoodsAvailab() {
        return goodsAvailab;
    }
    public void setGoodsAvailab(boolean goodsAvailab) {
        this.goodsAvailab = goodsAvailab;
    }

}
