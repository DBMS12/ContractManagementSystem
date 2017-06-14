package dao;

import java.util.List;

import model.ConState;
import utils.AppException;

/**
 * 合同状态数据访问层接口
 */
public interface ConStateDao {

	/**
	 *  新增合同操作状态信息
	 * 
	 * @param  conState 合同状态对象
	 * @return  成功返回true，否则返回false
	 * @throws AppException
	 */
	public boolean add(ConState conState) throws AppException;
	
	/**
	 * Query contract id set that meet the conditions according to the contract type
	 * 
	 * @param type Operation type
	 * @return contract id set
	 * @throws AppException
	 */
	public List<Integer> getConIdsByType(int type) throws AppException;
	
	/**
	 * Query contract state information according to contract id and type
	 * 
	 * @param conId Contract id
	 * @param type Operation type
	 * @return Contract state object
	 * @throws AppException
	 */
	public ConState getConState(int conId, int type) throws AppException;
	
}
