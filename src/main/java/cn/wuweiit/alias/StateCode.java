package cn.wuweiit.alias;

import cn.wuweiit.annotation.Text;


/**
 * 错误代码
 * 通过@Text 注解 作为注释
 * （@Text 注解用于生成国际化内容）
 * @author marker
 * @version 1.0
 */
public interface StateCode {
	

	@Text("操作成功")
	int OperationSuccess = 000000;
	
	@Text("操作失败")
	int OperationError = 100500;
	
	@Text("您还没有登录")
	int UserNotLoginError = 100001;
	
	
}
