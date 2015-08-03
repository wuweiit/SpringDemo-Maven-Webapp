package cn.wuweiit.alias;


/**
 * 缓存码管理
 * 
 * （将统一管理缓存码，为防止名称冲突故将方法名与参数混合md5加密得出前缀码）
 * 
 * @author marker
 * @version 1.0
 */
public interface CacheCode {

	
	
	// 检查更新
	String checkUpdateVersion = "'915864166C5F4F9B'  + #version";
	
	
	// 查看用户解析
	String getUserResolve = "'DCFE019672590A72' + #userId + #practiceId";
	
	
	/** 学校列表缓存 */
	String getSchoolByName = "'F11B8E803217CAD9' + #name";
	
	// 查询练习Id的问题集合
	String findByPracticeId = "'D66CA336810D2E58' + #practiceId";
	
	
	// 获取学生答题情况
	String getSituation = "'366B3B57AB24F7D2' + #practiceId + #userId";
	
	// 清除获取学生答题情况缓存
	String clearGetSituation = "'366B3B57AB24F7D2' + #params.getPracticeId() + #params.getUserId()";
	
}
