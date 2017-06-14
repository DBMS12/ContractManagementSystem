package utils;

/**
 * 常量定义类
 */
public class Constant {
	
	//合同状态表的 type[t_contract_state.type]
	public static final int STATE_DRAFTED = 1;			// 起草
	public static final int STATE_CSIGNED = 2;			// 会签完成
	public static final int STATE_FINALIZED = 3;		// 定稿完成
	public static final int STATE_APPROVED = 4;			// 审批完成
	public static final int STATE_SIGNED = 5;			// 签订完成
	
	//合同流程表的 type[t_contract_process.type]
	public static final int PROCESS_CSIGN = 1;			// 会签
	public static final int PROCESS_APPROVE = 2;		// 审批
	public static final int PROCESS_SIGN = 3;			// 签到
	
        //合同流程表的 state[t_contract_process.state]
	public static final int UNDONE = 0;					// 未完成
	public static final int DONE = 1;					// 已经完成
	public static final int VETOED = 2;					// 已经否决
	
}
