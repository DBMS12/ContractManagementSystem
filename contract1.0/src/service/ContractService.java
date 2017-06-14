package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


import dao.ConProcessDao;
import dao.ConStateDao;
import dao.ContractDao;
import dao.impl.ConProcessDaoImpl;
import dao.impl.ConStateDaoImpl;
import dao.impl.ContractDaoImpl;
import model.ConBusiModel;
import model.ConProcess;
import model.ConState;
import model.Contract;
import utils.AppException;
import utils.Constant;

/**
 *	��ͬҵ���߼���
 */
public class ContractService {
	
	private ContractDao contractDao = null;// Define a contractDao interface object
	private ConStateDao conStateDao = null;// Define a conStateDao interface object
	private ConProcessDao conProcessDao = null;// Define a conProcessDao interface object

	/**
	 * No-arg constructor method is used to initialize instance in data access layer
	 */
	public ContractService() {
		contractDao = new ContractDaoImpl();
		conStateDao = new ConStateDaoImpl();
		conProcessDao = new ConProcessDaoImpl();
	}
	
	/**
	 * ��ͬ���
	 * 
	 * @param contract ��ͬ����
	 * @return boolean  �ɹ�����true�����򷵻�false
	 * @throws AppException
	 */
	public boolean draft(Contract contract) throws AppException {
		boolean flag = false;// �����ʶ
		
		/*
		 * 1.���� generateConNum()���������ɺ�ͬ�� , ���ҽ��˱�����õ�contract������
		 */ 
		contract.setNum(generateConNum());
		
		try {
			/*
			 * 2.�����ͬ����ɹ�,  �����ݿ��б����ͬ���״̬
			 */
			if (contractDao.add(contract)) {
				// ʵ�廯conState����
				ConState conState = new ConState();
				conState.setConId(contract.getId());  //��ȡ��ͬ ID,�������õ� conState������
				// ���ú�ͬ״̬Ϊ"STATE_DRAFTED"����ݣ�
				conState.setType(Constant.STATE_DRAFTED);
				//�����ͬ״̬��Ϣ, ���Ҳ��������ֵ�� flag
				flag = conStateDao.add(conState);
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException(
					"service.ContractService.draft");
		}
		return flag;
	}
	
	/**
	 * Query contract collection that to be distributed
	 * 
	 * @return Query all contracts that need to be allocated; Otherwise return null
	 * @throws AppException
	 */
	public List<ConBusiModel> getDfphtList() throws AppException {
		// Initialize contractList
		List<ConBusiModel> contractList = new ArrayList<ConBusiModel>();
	
		try {
			/*
			 * 1.Get id set of contract that the status is "STATE_DRAFTED" 
			 */
			List<Integer> conIds = conStateDao.getConIdsByType(Constant.STATE_DRAFTED);
			
			/*
			 * 2.Traverse the query out contract id set, find whether have corresponding record in contract process table,
			 * If have records, means the contract has been allocated, otherwise, means have not been allocated
			 */
			for (int conId : conIds) {
				
				/*
				 * 3.Save contract information that need to be allocated into contract business entity object if the contract is not allocated,
				 * and put entity classes into conList
				 */
				if (!conProcessDao.isExist(conId)) {
					// Get information of designated contract
					Contract contract = contractDao.getById(conId);
					// Get status of designated contract
					ConState conState = conStateDao.getConState(conId, Constant.STATE_DRAFTED);
					// Instantiate conBusiModel object
					ConBusiModel conBusiModel = new ConBusiModel();
					if (contract != null) {
						//Set contract id and name to conBusiModel object
						conBusiModel.setConId(contract.getId());
						conBusiModel.setConName(contract.getName());
					}
					if (conState != null) {
						//Set draft time to conBusiModel object
						conBusiModel.setDrafTime(conState.getTime()); 
					}
					contractList.add(conBusiModel); // Add conBusiModel to contractList
				}
			}
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException("com.ruanko.service.ContractService.getDfphtList");
		}
		// Return contractList
		return contractList;
	}
	
	/**
	 * Get contract entity information
	 * 
	 * @param id 
	 * @return Contract entity
	 * @throws AppException
	 */
	public Contract getContract(int id) throws AppException {
		// Declare contract
		Contract contract = null;
		
		try {
			// Get designated contract's information 
			contract = contractDao.getById(id);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException(
					"3service.ContractService.getContract");
		}
		return contract;
	}
	
	/**
	 * distribute contract
	 * 
	 * @param conId 
	 * @param userIds 
	 * @param type 
	 * @return Return true if successful , otherwise false
	 * @throws AppException
	 */
	public boolean distribute(int conId, int userId, int type)
			throws AppException {
		boolean flag = false;// Define flag
		try {
			ConProcess conProcess = new ConProcess();
			// Assign value to contract process object
			conProcess.setConId(conId);
			conProcess.setType(type);
			// Set status to "UNDONE"
			conProcess.setState(Constant.UNDONE);
			conProcess.setUserId(userId);
			// Save contract information,return operation result to flag
			flag = conProcessDao.add(conProcess);
		} catch (AppException e) {
			e.printStackTrace();
			throw new AppException(
					"service.ContractService.distribute");
		}
		return flag;
	}
	
	
	/**
	 *  ���ɺ�ͬ��ţ�����Ϊ��������ʱ����+5λ�������
	 *  ��ݺ�ͬʱ�������һ��Ψһ��ű��浽���ݿ��У�����ͬ����ڱ��в�����������
	 */
	private String generateConNum() {
		// ʵ�廯 date����
		Date date = new Date();
		// ���� date format
		SimpleDateFormat sft = new SimpleDateFormat("yyyyMMddhhmmss");
		
		// ��֤�������������ɵ�һ���� 
		int rd = new Random().nextInt(99999);
		String rand = "00000" + rd;
		rand = rand.substring(rand.length() - 5);
		
		// ��֤��ͬ����ǵ�ǰ��������ʱ����+5λ�����
		String contractNum = sft.format(date) + rand;
		return contractNum;
	}

}
