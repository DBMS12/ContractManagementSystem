package dao;

import model.Contract;
import utils.AppException;

/**
 *   ��ͬ���ݷ��ʲ�ӿ�
 */
public interface ContractDao {

	/**
	 * ������ͬ��Ϣ
	 * 
	 * @param contract  ��ͬ����
	 * @return boolean  �ɹ�����true�����򷵻�false
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

