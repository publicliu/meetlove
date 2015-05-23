package net.lw.meetlove.api.entity;

public enum SystemArgsType {

	SYSTEM(0, "系统内置"), CUSTOM(1, "用户参数");

	private int id;
	private String text;

	private SystemArgsType(int id, String text) {
		this.id = id;
		this.text = text;
	}

	public static SystemArgsType getById(int id) {
		for (SystemArgsType type : SystemArgsType.values()) {
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
