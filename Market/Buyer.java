public class Buyer implements QueueBehaviour{
    String buyerName;
    Double cost;
    Double buyerMany;

    public Buyer (String buyerName, Double buyerMany, Double cost){
        this.buyerName = buyerName;
        this.cost = cost;
        this.buyerMany = buyerMany;
    }
    public Buyer (){
        this.buyerName = "buyerName_";
        this.buyerMany = 4000.0;
        this.cost = 0.0;
    }
   
    @Override
    public void setbuyerName(String buyerName) {
        this.buyerName = buyerName;
    }
    @Override
    public void setCost(Double cost) {
        this.cost = cost;
    }
    @Override
    public String getbuyerName() {
        return buyerName;
    }
    @Override
    public Double getCost() {
        return cost;
    }
    @Override
    public Double getBuyerMany() {
        return buyerMany;
    }
    @Override
    public void setBuyerMany(Double buyerMany) {
        this.buyerMany = buyerMany;
    }

}
