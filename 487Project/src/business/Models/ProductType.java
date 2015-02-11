package business.Models;

public enum ProductType {
	DVDPLAYER("DVD Player"),
	VIDEOCAMERA ("Video Camera"),
	TV ("TV");
	
	private final String name;       

    private ProductType(String productType) {
        name = productType;
    }

    public boolean equalsName(String otherName){
        return (otherName == null)? false:name.equals(otherName);
    }

    public String toString(){
       return name;
    }
    
    public static boolean isValidProductName(String productName){
    	if ((productName.compareTo(DVDPLAYER.toString()) == 0) || (productName.compareTo(VIDEOCAMERA.toString()) == 0) || (productName.compareTo(TV.toString()) == 0))
    		return true;
		else
    		return false;
    }
};
