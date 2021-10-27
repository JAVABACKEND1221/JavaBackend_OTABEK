package uz.otash.spring.model;

public class TransactionApp {
    private Long id;

    private double amount;

    private String reasons;

    private Long userId;

//    public Transaction(double amount, String reasons, Long userId) {
//        this.amount = amount;
//        this.reasons = reasons;
//        this.userId = userId;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
