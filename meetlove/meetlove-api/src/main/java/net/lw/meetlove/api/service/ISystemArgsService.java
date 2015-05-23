package net.lw.meetlove.api.service;

import java.util.List;

import net.lw.meetlove.api.entity.ISystemArgs;

public interface ISystemArgsService {

	public ISystemArgs make();

	public List<ISystemArgs> list();

	public ISystemArgs get(long id);

	public ISystemArgs add(ISystemArgs args);

	public void remove(ISystemArgs args);

	public void remove(long id);

	public void update(ISystemArgs args);

}
