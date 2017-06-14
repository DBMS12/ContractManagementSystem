package dao;

import java.util.List;

import model.ConState;
import utils.AppException;

/**
 * ��ͬ״̬���ݷ��ʲ�ӿ�
 */
public interface ConStateDao {

	/**
	 *  ������ͬ����״̬��Ϣ
	 * 
	 * @param  conState ��ͬ״̬����
	 * @return  �ɹ�����true�����򷵻�false
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
