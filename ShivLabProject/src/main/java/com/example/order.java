package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "bookings")
public class order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int customerId;
    private int cameraId;
    private String startDate;
    private String endDate;
    private double totalPrice;
    private String status;
    private String paymentMethod;
    private String transactionId;
	public order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public order(int id, int customerId, int cameraId, String startDate, String endDate, double totalPrice,
			String status, String paymentMethod, String transactionId) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.cameraId = cameraId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalPrice = totalPrice;
		this.status = status;
		this.paymentMethod = paymentMethod;
		this.transactionId = transactionId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getCameraId() {
		return cameraId;
	}
	public void setCameraId(int cameraId) {
		this.cameraId = cameraId;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

    
}