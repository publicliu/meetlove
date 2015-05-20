package net.lw.meetlove.api.weixin;

public enum MsgType {

	TEXT("text", "文本"), IMAGE("image", "图片"), VOICE("voice", "语音"), VIDEO(
			"video", "视频"), MUSIC("music", "音乐"), NEWS("news", "图文");

	private String id;
	private String text;

	private MsgType(String id, String text) {
		this.id = id;
		this.text = text;
	}

	public static MsgType getById(String id) {
		for (MsgType type : MsgType.values()) {
			if (type.getId().equals(id)) {
				return type;
			}
		}
		throw new IllegalArgumentException(String.format("id error", id));
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
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
