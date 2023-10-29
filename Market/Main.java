//Реализовать класс Market и все методы, которые он обязан реализовывать.
//Методы из интерфейса QueueBehaviour, имитируют работу очереди, MarketBehaviour – помещает 
//и удаляет человека из очереди, метод update – обновляет состояние магазина (принимает и отдаёт заказы)

import java.util.Deque;
import java.util.LinkedList;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        double BALANCE = 10000.0; // Всего Товаров в магазине на сумму
        int BUYERS = 10; // Количество покупателей
        double WALLET = 5000.0; //Предел (random )для определения денег в кошельке у покупателя
        double GOODSBAG = 3000.0; //Предел для определения суммы стоимости набранных товаров

        Market market = new Market(); 
        Buyer buyer = new Buyer();
        Random rnd = new Random();
        market.setCostAllgoods(BALANCE);
        market.setGoodsAvailab(true);
        Deque<Double> buyerCost = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < BUYERS; i++) { count++;
            if(market.isGoodsAvailab()){ // Если в магазине есть товары
                buyer.setBuyerMany(rnd.nextDouble(WALLET)); 
                buyer.setCost(rnd.nextDouble(GOODSBAG)); 

                        System.out.println();
                buyer.setbuyerName("Покупатель" + i);               
                        System.out.print(buyer.getbuyerName() + " Кошелек: ");
                        System.out.printf("%.2f",buyer.getBuyerMany()); 
                        System.out.print(" Выбрал на сумму: "); 
                        System.out.printf("%.2f",buyer.getCost());
                market.update(buyer.getCost(), 0.0); //Изменение суммы оставшихся на полках товаров
                        System.out.print(" Осталось товаров в магазине на сумму: "); 
                        System.out.printf("%.2f", market.getCostAllgoods());
                        System.out.println();
                    // Расчет на кассе, и изменение очереди
                market.marketBehaviour(buyerCost, buyer.getCost(), buyer.getBuyerMany(), rnd.nextBoolean());
                        System.out.println("В очереди: ");                             // rnd.nextBoolean() Для искусственной задержка очереди
                for (Double item : buyerCost) {  
                        System.out.printf("%.2f ",item);
                        System.out.println(); 
                }
            } else {
                    //Когда товары на полках закончились, все покупатели в очереди
                    int sz = buyerCost.size();
                    for (int j = 0; j < sz; j++) {
                    market.marketBehaviour(buyerCost, buyer.getCost(), buyer.getBuyerMany(), rnd.nextBoolean());    
                        System.out.println("В очереди: ");                              // rnd.nextBoolean() Для искусственной задержка очереди
                        for (Double item : buyerCost) {  
                            System.out.printf("%.2f ",item);
                            System.out.println();
                        }            
                    }
        }           // Все покупатели в очереди (новых нет)
                if(count ==  BUYERS){
                    while (!buyerCost.isEmpty()) {                                            
                    int sz = buyerCost.size();
                    for (int j = 0; j < sz; j++) {                        
                        System.out.println("В очереди: ");
                        for (Double item : buyerCost) {  
                            System.out.printf("%.2f ",item);
                            System.out.println();                    
                        }
                        market.marketBehaviour(buyerCost, 0.0, buyer.getBuyerMany(), rnd.nextBoolean()); 
                    } 
                } 
            }            
         }      
    }
}