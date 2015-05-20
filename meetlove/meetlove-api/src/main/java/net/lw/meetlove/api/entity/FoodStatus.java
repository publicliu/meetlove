package net.lw.meetlove.api.entity;

public enum FoodStatus {

	ON(1, "在线"), OFF(0, "离线");

	private int id;
	private String text;

	private FoodStatus(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public static FoodStatus getById(int id) {
		for (FoodStatus type : FoodStatus.values()) {
			if (type.getId() == id) {
				return type;
			}
		}
		throw new IllegalArgumentException(String.format("id error", id));
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

}
