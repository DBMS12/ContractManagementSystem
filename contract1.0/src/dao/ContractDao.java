package dao;

import model.Contract;
import utils.AppException;

/**
 *   合同数据访问层接口
 */
public interface ContractDao {

	/**
	 * 新增合同信息
	 * 
	 * @param contract  合同对象
	 * @return boolean  成功返回true，否则返回false
	 * @throws AppException
	 */
	public boolean add(Contract contract) throws AppException;
	
	/**
	 * Query contract information according to contract id
	 * 
	 * @param id Contract id
	 * @return Contract object
	 * @throws AppException
	 */
	public Contract getById(int id) throws AppException;
	
}

