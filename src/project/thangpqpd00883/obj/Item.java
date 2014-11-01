package project.thangpqpd00883.obj;

public class Item {
	String Item,Category,Description;
	int Id;
	public Item(){
		
	}
	public Item(int Id,String category,String description,String item){
		this.Id=Id;
		this.Item = item;
		this.Category = category;
		this.Description = description;
	}
	public String getItem() {
		return Item;
	}
	public void setItem(String item) {
		Item = item;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
}
