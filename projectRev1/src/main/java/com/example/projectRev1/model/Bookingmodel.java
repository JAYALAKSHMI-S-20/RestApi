package com.example.projectRev1.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Booking")
public class Bookingmodel{
	     @Id
	     private int bookingid;
	     private int roomid;
	     private int customerid;
	     private Date bookingdate;
	     private Date checkin;
	     private Date checkout;
	     private String status;
		public int getBookingid() {
			return bookingid;
		}
		public void setBookingid(int bookingid) {
			this.bookingid = bookingid;
		}
		public int getRoomid() {
			return roomid;
		}
		public void setRoomid(int roomid) {
			this.roomid = roomid;
		}
		public int getCustomerid() {
			return customerid;
		}
		public void setCustomerid(int customerid) {
			this.customerid = customerid;
		}
		public Date getBookingdate() {
			return bookingdate;
		}
		public void setBookingdate(Date bookingdate) {
			this.bookingdate = bookingdate;
		}
		public Date getCheckin() {
			return checkin;
		}
		public void setCheckin(Date checkin) {
			this.checkin = checkin;
		}
		public Date getCheckout() {
			return checkout;
		}
		public void setCheckout(Date checkout) {
			this.checkout = checkout;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
}
