package com.pagemanager;

import com.pages.BookHotelPage;
import com.pages.BookingConfirmPage;
import com.pages.CancelBookingPage;
import com.pages.LogInPage;
import com.pages.SearchHotelPage;
import com.pages.SelectHotelPage;

public class PageObjectManager {
	/**
	 * @author SIVANATHAN
	 * @see Used to Restrict Multiple Object Creation in the Project
	 */
	private LogInPage loginpage;
	private SearchHotelPage searchHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmPage bookingConfirmPage;
	private CancelBookingPage cancelBookingPage;
	public LogInPage getLoginpage() {
		return (loginpage==null)?loginpage=new LogInPage():loginpage;
	}
	public SearchHotelPage getSearchHotelPage() {
		return (searchHotelPage==null)?searchHotelPage=new SearchHotelPage():searchHotelPage;
	}
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage==null)?selectHotelPage=new SelectHotelPage():selectHotelPage;
	}
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage==null)?bookHotelPage=new BookHotelPage():bookHotelPage;
	}
	public BookingConfirmPage getBookingConfirmPage() {
		return (bookingConfirmPage==null)?bookingConfirmPage=new BookingConfirmPage():bookingConfirmPage;
	}
	public CancelBookingPage getCancelBookingPage() {
		return (cancelBookingPage==null)?cancelBookingPage=new CancelBookingPage():cancelBookingPage;
	}
	
	
	
	
	

}
