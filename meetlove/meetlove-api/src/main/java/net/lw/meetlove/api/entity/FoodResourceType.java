package net.lw.meetlove.api.entity;

public enum FoodResourceType {

	IMAGE(1, "图片"), VOICE(2, "语音"), VIDEO(3, "视频"), MUSIC(4, "音乐");

	private int id;
	private String text;

	private FoodResourceType(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public static FoodResourceType getById(int id) {
		for (FoodResourceType type : FoodResourceType.values()) {
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
