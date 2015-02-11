package services.SupplyChain;
import business.Models.*;

public class Warehouse {

	
	/*For each item in the itemList, check the inventory. Ship out the items that are available
		in the inventory to the Customer. You need to come up with a list of \shipped" items
		and \not shipped" items and make them as an ItemShippingStatusList and return it to
		the caller. You need to subtract the items shipped from the inventory. At the end of the
		operation, call the replenish() to replenish the inventory.*/
		public ItemShippingStatusList shipGoods(ItemList itemList, Customer info){
			//TODO
			return new ItemShippingStatusList();
		}
		
		
		/*This method can be called by shipGoods(). Check the inventory items. If the inven-
		tory of some items is lower than a threshold (dened by you), order the items from the
		Manufacturer. You can decide how many to order.*/
		private void replenish(){
			//TODO
		}
		
}
