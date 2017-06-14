package utils;

/**
 * ����������
 */
public class Constant {
	
	//��ͬ״̬��� type[t_contract_state.type]
	public static final int STATE_DRAFTED = 1;			// ���
	public static final int STATE_CSIGNED = 2;			// ��ǩ���
	public static final int STATE_FINALIZED = 3;		// �������
	public static final int STATE_APPROVED = 4;			// �������
	public static final int STATE_SIGNED = 5;			// ǩ�����
	
	//��ͬ���̱�� type[t_contract_process.type]
	public static final int PROCESS_CSIGN = 1;			// ��ǩ
	public static final int PROCESS_APPROVE = 2;		// ����
	public static final int PROCESS_SIGN = 3;			// ǩ��
	
        //��ͬ���̱�� state[t_contract_process.state]
	public static final int UNDONE = 0;					// δ���
	public static final int DONE = 1;					// �Ѿ����
	public static final int VETOED = 2;					// �Ѿ����
	
}
