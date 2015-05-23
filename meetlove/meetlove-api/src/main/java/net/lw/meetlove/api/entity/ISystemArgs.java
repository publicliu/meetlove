package net.lw.meetlove.api.entity;

public interface ISystemArgs {

	public long getId();

	public void setName(String name);
	public String getName();

	public void setValue(String value);
	public String getValue();

	public void setRemark(String remark);
	public String getRemark();

	public void setType(SystemArgsType type);
	public SystemArgsType getType();

}
