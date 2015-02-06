package SupplyChain;

public enum ProductType {
	DVDPLAYER("DVD Player"),
	VideoCamera ("Video Camera"),
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
};
