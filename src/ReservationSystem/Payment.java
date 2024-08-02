package ReservationSystem;

public class Payment {
	 private double amount;
	    private String paymentMethod;
	    private boolean paymentStatus;

	    public Payment(double amount, String paymentMethod) {
	        this.amount = amount;
	        this.paymentMethod = paymentMethod;
	        this.paymentStatus = false;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public String getPaymentMethod() {
	        return paymentMethod;
	    }

	    public boolean isPaymentStatus() {
	        return paymentStatus;
	    }

	    public void processPayment() {
	        // Simulate payment processing
	        if (paymentMethod.equalsIgnoreCase("Credit Card") || paymentMethod.equalsIgnoreCase("PayPal")) {
	            this.paymentStatus = true;
	            System.out.println("Payment of $" + amount + " using " + paymentMethod + " was successful.");
	        } else {
	            System.out.println("Payment method not accepted.");
	        }
	    }

}
