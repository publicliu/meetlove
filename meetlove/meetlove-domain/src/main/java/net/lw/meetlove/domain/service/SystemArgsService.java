/**
 * liuwei
 * publicliu@yeah.net
 * 2015年5月24日 上午2:22:46
 */
package net.lw.meetlove.domain.service;

import java.util.List;

import net.lw.ice.domain.dao.IGenericDao;
import net.lw.meetlove.api.entity.ISystemArgs;
import net.lw.meetlove.api.service.ISystemArgsService;
import net.lw.meetlove.domain.entity.SystemArgs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuwei
 *
 */
@Service
@Transactional
public class SystemArgsService implements ISystemArgsService {


	@Autowired
	private IGenericDao dao;


	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.ISystemArgsService#make()
	 */
	public ISystemArgs make() {
		return new SystemArgs();
	}


	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.ISystemArgsService#get(long)
	 */
	public ISystemArgs get(long id) {
		return dao.load(id, SystemArgs.class);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.ISystemArgsService#list()
	 */
	public List<ISystemArgs> list() {
		return dao.loadAll(ISystemArgs.class);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.ISystemArgsService#add(net.lw.meetlove.api.entity.ISystemArgs)
	 */
	public ISystemArgs add(ISystemArgs args) {
		return dao.save(args);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.ISystemArgsService#remove(net.lw.meetlove.api.entity.ISystemArgs)
	 */
	public void remove(ISystemArgs args) {
		dao.delete(args);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.ISystemArgsService#remove(long)
	 */
	public void remove(long id) {
		dao.delete(id, SystemArgs.class);
	}

	/* (non-Javadoc)
	 * @see net.lw.meetlove.api.service.ISystemArgsService#update(net.lw.meetlove.api.entity.ISystemArgs)
	 */
	public void update(ISystemArgs args) {
		dao.update(args);
	}

}
