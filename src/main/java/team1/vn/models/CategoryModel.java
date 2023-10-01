package team1.vn.models;

import java.io.Serializable;

public class CategoryModel implements Serializable {
	public static final long serialVersionUID = 1;

	// có bao nhiêu trường trong bảng category thì có bấy nhiêu biến và kiểu dữ liệu
	// tương ứng của nó
	private int cateID;
	private String cateName;
	private String image;

	// tạo constructure
	public CategoryModel() {
		super();
	}

	public CategoryModel(int cateID, String cateName, String image) {
		super();
		this.cateName = cateName;
		this.image = image;
	}

	// tạo Getter và Setter
	public int getCateID() {
		return cateID;
	}
	
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	// định dạng chuỗi dữ liệu
	@Override
	public String toString() {
		return "CategoryModel [cateName=" + cateName + ", image=" + image + "]";
	}

	

}
