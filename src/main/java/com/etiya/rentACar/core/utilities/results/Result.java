package com.etiya.rentACar.core.utilities.results;

public class Result {
   private boolean success; //işlem başarılı veya başarışırız
   private String message; //işlem başarısız olursa mesaj ne başarılı olursa mesaj ne

   public Result(boolean success) {
		this.success = success;
		
   }
   public Result(boolean success, String message) {
	this(success);
	this.message = message;
}
public boolean isSuccess() {
	return success;
}
public String getMessage() {
	return message;
}
   
   
   
}
